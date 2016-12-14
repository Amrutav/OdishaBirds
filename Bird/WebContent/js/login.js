$(document).ready(function(){
		  
		$("#AdminLogin").click(function(  ) {
			dataObject = {
		  'userName':$('#txtUserName').val(),
		  'password':$('#txtPassword').val()
		  };
		console.log(dataObject);
			
		$.ajax({
		    url: 'User/login',
		    type: 'post',
			contentType: "application/json; charset=utf-8",
			dataType:'json',
			data:JSON.stringify(dataObject),
		    success: function(result) {
		    	console.log(result);
		        	if(result.status=="SUCCESS"){
		        		var userData=result.user.loginId;
		        		var session = sessionStorage.setItem("UserData",userData);
		        		console.log(session);
		        		window.location="addCategory.jsp";
		        		        		
		    }else if (result.status=="ERROR"){	
		}else{
			alert("Wrong Username or Password");
		}
		}
		});
		});


	

});	

