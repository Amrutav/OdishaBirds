$(document).ready(function(){
	
	
	var uid=sessionStorage.getItem("UserData");	
	console.log(uid);
	alert(uid);
	
	if(uid==null){
		alert("Please login to continue")
		window.location="Login.jsp";
		return false;
	}
	$('#bdId').change(function() {
	
		$('#image').empty();
		dataObject={
		'birdId':$('#bdId').val()
	};
	var birdId=$('#bdId').val();
	$.ajax({
	    url: 'image/BirdImageListByBirdId?birdId='+birdId,
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	        console.log(result);
	    var table=$("#image");
	    $.each(result, function(i, item){
	  var ImgID=result[i].imageId;
	  
	    	table+='<tr ><td>'+result[i].imageName+ '</td><td>' + '<img src="'+result[i].imagePath+'" width="100px" height="100px"  >'+ '</td><td>' +'<input type="button" value="Delete" onclick="deleteImage('+ImgID+');">'+'</td></tr>';
	    	
	  
	    });  
	    $('#image').append(table);
	}
	});
	});
	
	
	
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
	        $('<option>').text('--Select--').val(0).appendTo(select);
		    $.each(result, function(i, item){
		    	$('<option>').text(item.birdName).val(item.birdId).appendTo(select);
		    });
	}
	});
	});
});


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
	        console.log(result);
	      
	}
	});
	
}