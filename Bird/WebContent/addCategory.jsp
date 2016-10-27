<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>Add Category</center>
Category Name:<input type="text" id="catName" name="catName" maxlength="100" onkeypress="return onlyAlphabets(event,this);"><br><br>
<input type="submit" value="Submit" id="cat" onclick="return validation()">

<script type="text/javascript">
function validation(){
	  var catname=document.getElementById("catName").value;
	 
	  if(catname==""){
		  document.getElementById("catName").focus();
	  return false;
	  }else{
		  return true;
	  }
}

function onlyAlphabets(e, t) {
    try {
        if (window.event) {
            var charCode = window.event.keyCode;
        }
        else if (e) {
            var charCode = e.which;
        }
        else { return true; }
        if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123) ||(charCode==32))
            return true;
        else
            return false;
    }
    catch (err) {
        alert(err.Description);
    }
}

</script>
<script type="text/javascript" src="js/cat.js"></script>
</body>
</html>