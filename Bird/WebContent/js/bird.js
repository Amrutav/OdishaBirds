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
	    $('<option>').text('--Select--').val(0).appendTo(select);
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
	
	$('#categoryId').change(function() {
		$('#bird').empty();
		var categoryId=$("#categoryId").val();
	
	$.ajax({
	    url: 'bird/BirdListByCatId?categoryId='+categoryId,
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	        console.log(result);
	    var table=$("#bird");
	    $.each(result, function(i, item){
	    		var BirdID=result[i].birdId;
	  	    	table+='<tr ><td>'+result[i].birdName+ '</td><td>' + '<img src="'+result[i].brdImage+'" width="100px" height="100px"  >'+ '</td><td>' +'<input type="button" value="Delete" onclick="deleteBird('+BirdID+');">'+'</td></tr>';
	  	  
	  	    });  
	  	    $('#bird').append(table);  
	}
	});
	
	});
});

function deleteBird(id){
	
	dataObject={
			'birdId':id
		};
	$.ajax({
	    url: 'bird/deleteBird',
	    type: 'delete',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:JSON.stringify(dataObject),
	    success: function(result) {
	        console.log(result);
	      
	}
	});
}