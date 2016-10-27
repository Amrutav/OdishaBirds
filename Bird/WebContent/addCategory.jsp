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
Category Name:<input type="text" id="catName" name="catName" maxlength="100"><br><br>
<input type="submit" value="Submit" id="cat" onclick="return validation()">

<script type="text/javascript">
function validation(){
	  var catname=document.getElementById("catName").value;
	 
	  if(catname==""){//cat kana drop down... no..txt run ... done mane data insert...next time b hauni..but duplicat chck hauchi...dekha
		  document.getElementById("catName").focus();
	  return false;
	  }else{
		  return true;
	  }
}

</script>
<script type="text/javascript" src="js/cat.js"></script>
</body>
</html>