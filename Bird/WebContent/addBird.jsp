<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>Add Birds</center>
<form action="bird/addBird" method="post" enctype="multipart/form-data">
Choose Category:<input type="text" id="catId" name="catId"><br><br>
Name:<input type="text" id="birdName" name="birdName"><br><br>
Color:<input type="text" id="birdColor" name="birdColor"><br><br>
Details:<input type="text" id="birdDetails" name="birdDetails"><br><br>
Food:<input type="text" id="birdFood" name="birdFood"><br><br>
Population:<input type="text" id="birdPopulation" name="birdPopulation"><br><br>
Alternative Name:<input type="text" id="birdAltName" name="birdAltName"><br><br>
Scientific Name:<input type="text" id="birdSciName" name="birdSciName"><br><br>
Resident:<input type="text" id="birdResident" name="birdResident"><br><br>
Visibility:<input type="text" id="birdVisibility" name="birdVisibility"><br><br>
Migratory Status:<input type="text" id="birdMigrtStatus" name="birdMigrtStatus"><br><br>
Nesting Period:<input type="text" id="birdNestPeriod" name="birdNestPeriod"><br><br>
Sound File:<input type="file" id="birdSound" value="Upload" name="birdSound" onchange="checkfile(this);"><br><br>
<input type="submit" value="Submit">
</form>
<script type="text/javascript" language="javascript">
  function checkfile(sender) {
   var validExts = new Array(".aac", ".mp3");
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