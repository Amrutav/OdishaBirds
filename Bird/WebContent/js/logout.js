$(document).ready(function(){
		  
	var uid=sessionStorage.getItem("UserData");	
	if(uid!=null){
		sessionStorage.clear();
		window.location="Login.jsp";
	}
});	

