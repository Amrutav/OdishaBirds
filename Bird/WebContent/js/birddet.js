$(document).ready(function(){
	
	
	var uid=sessionStorage.getItem("UserData");	
	console.log(uid);
	alert(uid);
		
	if(uid==null){
		alert("Please login to continue")
		window.location="Login.jsp";
		return false;
	}
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
	    $('<option>').text('--Select--').val(0).appendTo(select);
	    $.each(result, function(i, item){
	    	$('<option>').text(item.categoryName).val(item.categoryId).appendTo(select);
	    });   
	}
	});	
	
	/*$('#categoryId').change(function() {
		dataObject = {
				'categoryId':$('#categoryId').val() 
	  
	};*/
	
	$("#categoryId").blur(function(){
		$('#bdId').empty();
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
	        $('<option>').text('--Select--').val(0).appendTo(select);
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