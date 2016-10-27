$(document).ready(function(){
	alert("Welcome");
	
		$('#categoryId').change(function() {
			$('#bdId').empty();
		  alert("change"); 
		  
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
	
	/*$('#categoryId').change(function() {
		dataObject = {
				'categoryId':$('#categoryId').val() se second DD ra id kana
	  
	};*/
	
	$("#categoryId").blur(function(){
		$('#bdId').empty();//run
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
	
	$("#bdId").blur(function(){
		dataObject = {
				'birdId':$('#bdId').val()
		};
		console.log(dataObject);
		var bdId=$('#bdId').val();
		$.ajax({
		    url: 'bird/validateBirdDetails?bdId='+bdId,
		    type: 'get',
			contentType: "application/json; charset=utf-8",
			dataType:'json',
			data:JSON.stringify(dataObject),
		    success: function(result) {
		        console.log(result); 
		if(result.status=="NOT EXIST"){
		    }else if (result.status=="EXIST"){	
		    	$('#bdId').empty();
		    	alert("Details for the bird already exists. Insert for anathor.");
		    	return true;
		}
		}
		});
	});
});