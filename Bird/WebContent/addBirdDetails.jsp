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
<center>Add Bird Detail</center>
<form action="bird/addBirdDetail" method="post" enctype="multipart/form-data" name="form1">
Choose Category:<select id="categoryId" name="categoryId" >
<option id="option"></option>
</select>
Choose Bird:<select id="bdId" name="bdId">
<option id="option"></option>
</select>
<br><br>
Color:<input type="text" id="birdColor" name="birdColor" maxlength="50" onkeypress="return onlyAlphabets(event,this);"><br><br>
Description:<input type="text" id="birdDetails" name="birdDetails" maxlength="1000" ><br><br>
Food:<input type="text" id="birdFood" name="birdFood" maxlength="100" onkeypress="return onlyAlphabets(event,this);"><br><br>
Population:<input type="text" id="birdPopulation" name="birdPopulation" maxlength="50" onkeypress="return alphanumeric(documnt.form1.birdPopulation);"><br><br>
Alternative Name:<input type="text" id="birdAltName" name="birdAltName" maxlength="100" onkeypress="return onlyAlphabets(event,this);"><br><br>
Scientific Name:<input type="text" id="birdSciName" name="birdSciName" maxlength="100" onkeypress="return onlyAlphabets(event,this);"><br><br>
Resident:<input type="text" id="birdResident" name="birdResident" maxlength="100" onkeypress="return onlyAlphabets(event,this);"><br><br>
Visibility:<input type="text" id="birdVisibility" name="birdVisibility" maxlength="50" onkeypress="return onlyAlphabets(event,this);"><br><br>
Migratory Status:<input type="text" id="birdMigrtStatus" name="birdMigrtStatus" maxlength="50" onkeypress="return onlyAlphabets(event,this);"><br><br>
Nesting Period:<input type="text" id="birdNestPeriod" name="birdNestPeriod" maxlength="10" onkeypress="return alphanumeric(documnt.form1.birdNestPeriod);"><br><br>
Sound File:<input type="file" id="birdSound" value="Upload" name="birdSound" onchange="checkfile(this);"><br> Max Upload size is 950 KB<br><br>
<input type="submit" value="Submit" onclick="return validation()">
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
  function validation(){
	  var birdsound=document.getElementById("birdSound").value;
	  var birdcolor=document.getElementById("birdColor").value;
	  var birddetails=document.getElementById("birdDetails").value;
	  var birdfood=document.getElementById("birdFood").value;
	  var birdPopulation=document.getElementById("birdPopulation").value;
	  var birdAltName=document.getElementById("birdAltName").value;
	  var birdSciName=document.getElementById("birdSciName").value;
	  var birdResident=document.getElementById("birdResident").value;
	  var birdVisibility=document.getElementById("birdVisibility").value;
	  var birdMigrtStatus=document.getElementById("birdMigrtStatus").value;
	  var birdNestPeriod=document.getElementById("birdNestPeriod").value;
	  var catid=document.getElementById("categoryId").value;
	  var bdid=document.getElementById("bdId").value;
	  if(catid == 0){
		  alert("Please select Catagory");
		  document.getElementById("categoryId").focus();
		  return false;
	  }
	  if(bdid == 0){
		  alert("Please select Bird");
		  document.getElementById("bdId").focus();
		  return false;
	  }
	  if(birdcolor==" "){
		  alert("Please enter birds color");
		  document.getElementById("birdColor").focus();
	  return false;
	  }
	  if(birddetails==""){
		  alert("Please enter birds description");
		  document.getElementById("birdDetails").focus();
	  return false;
	  }
	  if(birdfood==""){
		  alert("Please enter birds food");
		  document.getElementById("birdFood").focus();
	  return false;
	  }
	  if(birdPopulation==""){
		  alert("Please enter birds population");
		  document.getElementById("birdPopulation").focus();
	  return false;
	  }
	  if(birdAltName==""){
		  alert("Please enter birds altrnative name");
		  document.getElementById("birdAltName").focus();
	  return false;
	  }
	  if(birdSciName==""){
		  alert("Please enter birds scientific name");
		  document.getElementById("birdSciName").focus();
	  return false;
	  }
	  if(birdResident==""){
		  alert("Please enter birds resident");
		  document.getElementById("birdResident").focus();
	  return false;
	  }
	  if(birdVisibility==""){
		  alert("Please enter birds visibility");
		  document.getElementById("birdVisibility").focus();
	  return false;
	  }
	  if(birdMigrtStatus==""){
		  alert("Please enter birds migretory status");
		  document.getElementById("birdMigrtStatus").focus();
	  return false;
	  }
	  if(birdNestPeriod==""){
		  alert("Please enter birds nesting period");
		  document.getElementById("birdNestPeriod").focus();
	  return false;
	  }
	  
	  if(birdsound.length < 1){
		  alert("Upload a sound file");
		  document.getElementById("birdSound").focus();
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
  
  function alphanumeric(inputtxt)  
  {  
   var letterNumber = /^[0-9a-zA-Z]/;  
   if((inputtxt.value.match(letterNumber)))   
    {  
     return true;  
    }  
  else  
    {   
     alert("message");   
     return false;   
    }  
    }
  
 </script>
  <script type="text/javascript" src="js/birddet.js"></script>
</body>
</html>