$(document).ready(function(){
	
	
	var uid=sessionStorage.getItem("UserData");
		
	if(uid==null){
		alert("Please login to continue")
		window.location="Login.jsp";
		return false;
	}
	
	$('#btnUpdDetails').attr("disabled", true);
	
	$("#birdDetails").attr("action", "bird/addBirdDetail"); //Will set it	

//Category List in Dropdown		
	$.ajax({
	    url: 'category/categoryList',
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	        console.log(result);
	    var select=$("#categoryId");
	    $('<option>').text('--Select Category--').val(0).appendTo(select);
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
	        console.log(result); 
	        $.each(result, function(i, item){
		    	$('<option>').text(item.birdName).val(item.birdId).appendTo(selectbird);
		    });
	}
	});
	});
	
	
//Validate Bird Details	
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
		    	alert("Details for the bird already exists. Insert for anathor.");
		    	$('#bdId').empty();
		    	var selectbd=$("#bdId");
			    $('<option>').text('-- Select Bird --').val(0).appendTo(selectbd);
		    	return true;
		}
		}
		});
	});
	
	
//bird list in table
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
	
//bird list by category id
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
	
	$('#btnUpdDetails').prop("disabled", false);
	
	$('#btnAddDetaisl').prop("disabled", true);
	$('#btnAddDetaisl').css("cursor","wait");
	$("#birdDetails").attr("action", "bird/updateBirdDetails"); //Will set it
	
	var bdId=id;
	$.ajax({
	    url: 'bird/BirdDetListByBirdDetId?bdId='+bdId,
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	    	console.log(result);
	    	
	    	
	    	var selectCate=$("#categoryId");
	    	$("#categoryId").empty();
	    	$('<option>').text(result[0].bird.category.categoryName).val(result[0].bird.category.categoryId).appendTo(selectCate);
	    	$('#categoryId').prop("disabled", true);
	    	
	    	var selectBd=$("#bdId");
	    	$("#bdId").empty();
	    	$('<option>').text(result[0].bird.birdName).val(result[0].bird.birdId).appendTo(selectBd);
	    	$('#bdId').prop("disabled", true);
	    	
	    	$("#birdColor").val(result[0].birdColor);
	    	$("#birdFood").val(result[0].birdFood);
	    	$("#birdPopulation").val(result[0].birdPopulation);
	    	$("#birdAltName").val(result[0].birdAltName);
	    	$("#birdSciName").val(result[0].birdSciName);
	    	$("#birdResident").val(result[0].birdRsident);
	    	$("#birdVisibility").val(result[0].birdVisibility);
	    	$("#birdMigrtStatus").val(result[0].birdMigrtStatus);
	    	$("#birdNestPeriod").val(result[0].birdNestPeriod);
	    	$("textarea#birdDetails").val(result[0].birdDetails);	    	
	    	
	    	var birdDetId=result[0].birdDetailId;
	    	var sound=result[0].birdSound;
	    	$("#BirdSound").attr('src',sound);
	    	$("#BirdSound").attr('value',sound);
	    	$("#hfCatId").val(birdDetId);
	    	$("#hfCatId2").val(sound);
	    	$("#hfCatId3").val(sound);
	    	
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