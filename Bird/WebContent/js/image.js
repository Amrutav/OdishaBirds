$(document).ready(function(){
	
	
	var uid=sessionStorage.getItem("UserData");
	
	if(uid==null){
		alert("Please login to continue")
		window.location="Login.jsp";
		return false;
	}
		
	$("#imageGallery").attr("action", "image/addBirdImage"); //Will set it
	
	
	//bird list in table
	$.ajax({
	    url: 'bird/BirdList',
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	        var table=$("#image-table");
		    $.each(result, function(i, item){
		    		var BirdID=result[i].birdId;
		  	    	table+='<tr><td>'+result[i].birdName+ '</td><td>' +'<div style="cursor:pointer;" onclick="viewGallery('+BirdID+');">'+"View"+'</td></tr>';
		  	  
		  	    });  
		  	    $("#image-table").append(table);    
	}
	});
	
	//bird list by category id
	$('#categoryId').change(function() {
		$('#image-table tbody').empty();
		var categoryId=$("#categoryId").val();
	
	$.ajax({
	    url: 'bird/BirdListByCatId?categoryId='+categoryId,
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	    var tablee=$("#image-table");
	    $.each(result, function(i, item){
	    		var BirdID=result[i].birdId;
	  	    	tablee+='<tr><td>'+result[i].birdName+ '</td><td>' +'<div style="cursor:pointer;" onclick="viewGallery('+BirdID+');">'+"View"+'</td></tr>';
	  	  
	  	    });  
	  	    $("#image-table").append(tablee);  
	}
	});
	
	});
	
	//Category List in Dropdown		
	$.ajax({
	    url: 'category/categoryList',
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	    var select=$("#categoryId");
	    $('<option>').text('-- Select Category --').val(0).appendTo(select);
	    $.each(result, function(i, item){
	    	$('<option>').text(item.categoryName).val(item.categoryId).appendTo(select);
	    });   
	}
	});	
	
	
//Bird name by Category	
	
	$("#categoryId").change(function(){
		$('#bdId').empty();
		var selectbird=$("#bdId");
	    $('<option>').text('-- Select Bird --').val(0).appendTo(selectbird);
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
	        $.each(result, function(i, item){
		    	$('<option>').text(item.birdName).val(item.birdId).appendTo(selectbird);
		    });
	}
	});
	});
	
});



function viewGallery(id){
	$('#image').empty();
	dataObject={
			'birdId':id
		};
	var birdId=id;
	$.ajax({
	    url: 'image/BirdImageListByBirdId?birdId='+birdId,
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:JSON.stringify(dataObject),
	    success: function(result) {
	      var tableI=$("#image");
	    $.each(result, function(i, item){
	  var ImgID=result[i].imageId;
	  		
	  tableI+='<td style="padding-left:10px"><img src="'+result[i].imagePath+'" width="100px" height="100px" padding-bottom: 2px><br>&nbsp;&nbsp;<input type="button" value="DELETE" class="btn btn-danger" onclick="deleteImage('+ImgID+');"></td>';
	    	
	  });  
	    $('#image').append(tableI);
	}
	});
}


function deleteImage(id){
	
	dataObject={
			'imageId':id
		};
	$.ajax({
	    url: 'image/deleteImage',
	    type: 'delete',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:JSON.stringify(dataObject),
	    success: function(result) {
	    	if(result.status=="SUCCESS"){
        		window.location="addBirdImage.jsp";
	        }else{
	        	alert("Error in deletion.");
	        } 
	      
	}
	});
	
}