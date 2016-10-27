$(document).ready(function(){
	alert("Welcome");
	
	
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
									alert("done");
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
	
	/*$( "#cat" ).click(function( event ) {
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
					alert("done");
					}else{	
						alert("error");
					}
			}
		});
	});*/
	
	
});