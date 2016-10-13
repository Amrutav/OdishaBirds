<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>Add Bird Image</center>
<form action="image/addBirdImage" method="post" enctype="multipart/form-data">
Enter BirdId:<input type="text" id="birdId" name="birdId"><br><br>
Enter Image Name:<input type="text" id="imageName" name="imageName"><br><br>
File:<input type="file" id="birdImage" value="Upload" name="birdImage" onchange="checkfile(this);"><br><br>
<input type="submit" value="Submit">
</form>
<script type="text/javascript" language="javascript">
  function checkfile(sender) {
   var validExts = new Array(".jpg", ".jpg",".png");
   var fileExt = sender.value;
   fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
   if (validExts.indexOf(fileExt) < 0) {
    alert("Invalid file selected, valid files are of "
      + validExts.toString() + " types.");
    return false;
   } else
    return true;
  }
 </script>
</body>
</html>