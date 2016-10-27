$(document).ready(function(){
	
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
	
	
	
	$("#birdName").blur(function(){
		dataObject = {
				'birdName':$('#birdName').val()
		};
		console.log(dataObject);
		var birdName=$('#birdName').val();
		$.ajax({
		    url: 'bird/validateBird?birdName='+birdName,
		    type: 'get',
			contentType: "application/json; charset=utf-8",
			dataType:'json',
			data:JSON.stringify(dataObject),
		    success: function(result) {
		        console.log(result); 
		if(result.status=="NOT EXIST"){
			//alert("ok");
		    }else if (result.status=="EXIST"){	
		    	$("#birdName").val('');
		    	alert("This bird already exists. Insert new one.");
		}
		}
		});
	});
	
	
	
});