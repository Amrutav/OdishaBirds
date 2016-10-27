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
<center>Add Bird Image</center>
<form action="bird/addBird" method="post" enctype="multipart/form-data">
Choose Category:<select id="categoryId" name="categoryId">
<option id="option"></option>
</select>
<br><br>
Enter Bird Name:<input type="text" id="birdName" name="birdName" maxlength="55"><br><br>
File:<input type="file" id="birdImage" value="Upload" name="birdImage" onchange="checkfile(this);"><br>  Max Upload size is 950 KB<br><br>
<input type="submit" value="Submit" onclick="return validation()">
</form>
<script type="text/javascript" language="javascript">
function checkfile(sender) {
	   var validExts = new Array(".jpeg", ".jpg",".png",".JPG",".JPEG",".PNG");
	   var fileExt = sender.value;
	   var birdImage=document.getElementById("birdImage").value;
	   fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
	   if (validExts.indexOf(fileExt) < 0) {
		   $('#birdImage').val('');
	    alert("Invalid file selected, valid files are of "+ validExts.toString() + " types.");
	    document.getElementById("birdImage").focus();
	    return false;
	   } 
	   else
	    return true;
	  } 
  function validation(){
	  var fname=document.getElementById("birdImage").value;
	  var birdname=document.getElementById("birdName").value;
	  var catid=document.getElementById("categoryId").value;
	  if(catid == 0){
		  alert("Please select Catagory");
		  document.getElementById("categoryId").focus();
		  return false;
	  }
	  if(birdname==""){
		  alert("Please enter bird name");
		  document.getElementById("birdName").focus();
	  return false;
	  }
	  
	  if(fname.length < 1){
		  alert("Upload an image");
		  document.getElementById("birdImage").focus();
		  return false;
	  }else{
		  return true;
	  }
  }
 </script>
 <script type="text/javascript" src="js/bird.js"></script>
</body>
</html>