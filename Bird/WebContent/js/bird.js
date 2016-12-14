$(document).ready(function(){
	
	var uid=sessionStorage.getItem("UserData");	
	if(uid==null){
		alert("Please login to continue")
		window.location="Login.jsp";
		return false;
	}
	
	$('#btnUpdCat').attr("disabled", 'disabled');
	
	$("#addbirdform").attr("action", "bird/addBird"); //Will set it
	
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
	
	
	
	$.ajax({
	    url: 'bird/BirdList',
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	        console.log(result);
	        var table=$("#bird-table");
		    $.each(result, function(i, item){
		    		var BirdID=result[i].birdId;
		  	    	table+='<tr><td>'+result[i].birdName+ '</td><td>' +'<div style="cursor:pointer;" onclick="assignUpdateValue('+BirdID+');">'+"Edit"+'</td><td>' +'<div style="cursor:pointer;" onclick="deleteBird('+BirdID+');">'+"Delete"+'</div></td></tr>';
		  	  
		  	    });  
		  	    $('#bird-table').append(table);    
	}
	});
	
	
	
	$("#birdName").blur(function(){
		
		var action=$("#addbirdform").attr("action");
		if(action=="bird/addBird"){
		
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
		    }else if (result.status=="EXIST"){	
		    	$("#birdName").val('');
		    	alert("This bird already exists. Insert new one.");
		    		}
		    	}
			});
		}
	});
	
	$('#categoryId').change(function() {
		$('#bird-table tbody').empty();
		var categoryId=$("#categoryId").val();
	
	$.ajax({
	    url: 'bird/BirdListByCatId?categoryId='+categoryId,
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	        console.log(result);
	    var table=$("#bird-table");
	    $.each(result, function(i, item){
	    		var BirdID=result[i].birdId;
	  	    	table+='<tr><td>'+result[i].birdName+ '</td><td>' +'<div style="cursor:pointer;" onclick="assignUpdateValue('+BirdID+');">'+"Edit"+'</td><td>' +'<div style="cursor:pointer;" onclick="deleteBird('+BirdID+');">'+"Delete"+'</div></td></tr>';
	  	  
	  	    });  
	  	    $('#bird-table').append(table);  
	}
	});
	
	});
});



function assignUpdateValue(id){
	
	$('#btnUpdCat').prop("disabled", false);
	
	$('#btnAddCat').prop("disabled", true);
	$('#btnAddCat').css("cursor","wait");
	$("#addbirdform").attr("action", "bird/updateBird"); //Will set it
	
	var birdId=id;
	$.ajax({
	    url: 'bird/BirdListByBirdId?birdId='+birdId,
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	    	console.log(result);
	    	console.log(result[0].birdName);
	    	 var BdName=result[0].birdName;
	    	 var Image=result[0].birdImage;
	    	 var BdId=result[0].birdId;
	    	 console.log(BdName);
	    	 console.log(Image);
	    	 console.log(BdId);
	    	 var select=$("#categoryId");
	    	 $("#categoryId").empty();
	    	 $('<option>').text(result[0].category.categoryName).val(result[0].category.categoryId).appendTo(select);
	    	 $("#birdName").val(BdName);
	    	 $("#BirdImage").attr('src',Image);
	    	 $("#BirdImage").attr('value',Image);
	    	 $("#hfCatId").val(BdId);
	    	 $("#hfCatId2").val(Image);
	    	 $("#hfCatId3").val(Image);
	    	
	    }
	});
	
}



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
	    	if(result.status=="SUCCESS"){
        		window.location="addBird.jsp";
	        }else{
	        	alert("Error in deletion.");
	        }  
	}
	});
}