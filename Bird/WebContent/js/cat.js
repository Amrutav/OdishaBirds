$(document).ready(function(){
	
	var uid=sessionStorage.getItem("UserData");	
	
	$('#btnUpdCat').attr("disabled", 'disabled');
	
	if(uid==null){
		alert("Please login to continue")
		window.location="Login.jsp";
		return false;
	}
	$.ajax({
	    url: 'category/categoryList',
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	        var table=$("#category");
		    $.each(result, function(i, item){
		    	var CatID=result[i].categoryId;
		    	table+='<tr ><td>'+result[i].categoryName+ '</td><td>' +'<div style="cursor:pointer;" onclick="assignUpdateValue('+CatID+');">'+"Edit"+'</td><td>' +'<div style="cursor:pointer;" onclick="deleteImage('+CatID+');">'+"Delete"+'</div></td></tr>';
		    });  
		    $('#category').append(table);  
	}
	});
	
	
	
		$( "#btnAddCat" ).click(function( event ){
			dataObject = {
					'categoryName':$('#catName').val()
			};
		var categoryName=$('#catName').val();
		
		$.ajax({
		    url: 'category/validateCat?categoryName='+categoryName,
		    type: 'get',
			contentType: "application/json; charset=utf-8",
			dataType:'json',
			data:JSON.stringify(dataObject),
		    success: function(result) {
		
		if(result.status=="NOT EXIST"){
			dataObject = {
					  'categoryName':$('#catName').val()
						}
						$.ajax({
							url: 'category/addCategory',
							type: 'post',
							contentType: "application/json; charset=utf-8",
							dataType:'json',
							data:JSON.stringify(dataObject),
							success: function(result) {
								if(result.status=="SUCCESS"){
									$("#catName").val('');
									alert("Category insertd succssfully");
									window.location="addCategory.jsp";
									}else{	
										alert("Error in insertion");
									}
							}
						});
		}else if (result.status=="EXIST"){	
		    	$("#catName").val('');
		    	alert("This Category is taken. Take Another");
		}
	}
		});
		
		    
		});
	

		
		$( "#btnUpdCat" ).click(function( event ){
			dataObject = {
					'categoryName':$('#catName').val()
			};
		var categoryName=$('#catName').val();
		$.ajax({
		    url: 'category/validateCat?categoryName='+categoryName,
		    type: 'get',
			contentType: "application/json; charset=utf-8",
			dataType:'json',
			data:JSON.stringify(dataObject),
		    success: function(result) {
		if(result.status=="NOT EXIST"){
			dataObject = {
					'categoryId':$('#hfCatId').val(),  
					'categoryName':$('#catName').val()
						}
						$.ajax({
							url: 'category/updateCategory',
							type: 'post',
							contentType: "application/json; charset=utf-8",
							dataType:'json',
							data:JSON.stringify(dataObject),
							success: function(result) {
								if(result.status=="SUCCESS"){
									$("#catName").val('');
									alert("Category updated succssfully");
									window.location="addCategory.jsp";
									}else{	
										alert("Error in updation");
									}
							}
						});
		    }else if (result.status=="EXIST"){	
		    	$("#catName").val('');
		    	alert("This Category is taken. Take Another");
		}
	}
		});
		});		
		
});

function assignUpdateValue(id){
	
	$('#btnUpdCat').prop("disabled", false);
	$('#btnAddCat').prop("disabled", true);
	$('#btnAddCat').css("cursor","wait");
	
	var catId=id;
	$.ajax({
	    url: 'category/categoryListById?categoryId='+catId,
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	    	 var CatName=result[0].categoryName;
	    	 var CatId=result[0].categoryId;
	    	 $("#catName").val(CatName);
	    	 $("#hfCatId").val(CatId);
	    }
	});
	
}



function deleteImage(id){
	
	dataObject={
			'categoryId':id
		};
	$.ajax({
	    url: 'category/deleteCategory',
	    type: 'delete',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:JSON.stringify(dataObject),
	    success: function(result) {
	        if(result.status=="SUCCESS"){
        		window.location="addCategory.jsp";
	        }else{
	        	alert("Error in deletion.");
	        }     
	}
	});
	

}