$(document).ready(function(){

	$('#categoryId').change(function() {
	
		  $('#bdId').empty();
		});
	
	$.ajax({
	    url: 'category/categoryList',
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	        console.log(result);
	    var select=$("#categoryId");
	    $.each(result, function(i, item){
	    	$('<option>').text(item.categoryName).val(item.categoryId).appendTo(select);
	    });   
	}
	});	
	
	$("#categoryId").blur(function(){

		dataObject = {
			'categoryId':$('#categoryId').val()
  };
	console.log(dataObject);
	var categoryId = $('#categoryId').val();
	$.ajax({
	    url: 'bird/BirdListByCatId?categoryId='+categoryId,
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:JSON.stringify(dataObject),
	    success: function(result) {
	        console.log(result); 
	        var select=$("#bdId");
		    $.each(result, function(i, item){
		    	$('<option>').text(item.birdName).val(item.birdId).appendTo(select);
		    });
	}
	});
	});
});