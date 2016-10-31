$(document).ready(function(){
	
		
	$.ajax({
	    url: 'category/categoryList',
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	        console.log(result);
	        var table=$("#category");
		    $.each(result, function(i, item){
		    	var CatID=result[i].categoryId;
		    	table+='<tr ><td>'+result[i].categoryName+ '</td><td>' +'<input type="button" value="Delete" onclick="deleteImage('+CatID+');">'+'</td></tr>';
		    });  
		    $('#category').append(table);  
	}
	});
	
	
	
	//$("#catName").blur(function()
			$( "#cat" ).click(function( event ){
		dataObject = {
				'categoryName':$('#catName').val()
		};
		console.log(dataObject);
		var categoryName=$('#catName').val();
		if(categoryName==""){
			alert("Please enter category");
			return;
		}else{
		$.ajax({
		    url: 'category/validateCat?categoryName='+categoryName,
		    type: 'get',
			contentType: "application/json; charset=utf-8",
			dataType:'json',
			data:JSON.stringify(dataObject),
		    success: function(result) {
		        console.log(result); 
		if(result.status=="NOT EXIST"){
			dataObject = {
					  'categoryName':$('#catName').val()
						}
						console.log(dataObject);
						$.ajax({
							url: 'category/addCategory',
							type: 'post',
							contentType: "application/json; charset=utf-8",
							dataType:'json',
							data:JSON.stringify(dataObject),
							success: function(result) {
								
								console.log(result); 
								if(result.status=="SUCCESS"){
									$("#catName").val('');
									alert("Category Insertd Succssfully");
									}else{	
										alert("error");
									}
							}
						});
		    }else if (result.status=="EXIST"){	
		    	alert("This Category is taken. Choose Anathor please");
		}
		}
		});
		}
	});
	
	
});


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
	        console.log(result);
	      
	}
	});
	
}