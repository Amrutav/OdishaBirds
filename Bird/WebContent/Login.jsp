<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ODISHA BIRD</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="Wrapper">
	<div class="header header_Logo">
    <div>
    <img src="img/Logo.png">
    </div>
    
    </div>
	
    <div class="Reg_FormContainer">
     	<div class="LoginReg_Header">
        <font style="font-size:28px;">ODISHA BIRDS</font><br>
        	ADMIN LOGIN
        </div>
       
    		  
		        <div class="Adminlogin_Panel">
                
            	<div class="AdminControl_Panel">
                	<div class="AdminLoginPanel_Lbl">User Name : </div>
                    <div  style="width:auto; float:left;padding-left: 20px;">
                    	<input type="text" id="txtUserName" required class="Admininput_Css" name="txtUserName"/>
                    </div>
                </div>
                <div class="AdminControl_Panel">
                	<div class="AdminLoginPanel_Lbl">Password : </div>
                    <div  style="width:auto; float:left;padding-left: 20px;">
                    	<input type="password"  class="Admininput_Css" required id="txtPassword" name="txtPassword" />
                    </div>
                </div>
                
            </div>
		   
    <div class="Admin_Reg_Row">
        	<input type="submit" class="LogInRegBtn"  value="LOGIN" id="AdminLogin" onClick="return validate(); " />
        </div>
 </div>
 <script type="text/javascript">
	 function validate() {

        var UserName = document.getElementById("txtUserName").value;
        var Password = document.getElementById("txtPassword").value;
      
        
        if (UserName =="") {
            alert("Please Enter UserName");
			document.getElementById("txtUserName").focus();
            return false;
        }
         if (Password=="") {
            alert("Please Enter Password");
			document.getElementById("txtPassword").focus();
            return false;
        } 

      
        
        
        
        else {
            return true;
        }
    }
</script>
<script type="text/javascript" src="js/login.js"></script>
</body> 

</html>