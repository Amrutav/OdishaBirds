
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Panel</title>
<link href="css/style.css"  rel="stylesheet" type="text/css"  />
<link href="css/bootstrap.css"  rel="stylesheet" type="text/css"  />
<link href="css/SlideMenu.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

</head>
<body>
<div id="Wrapper">
<div class="header header_Txt">ADMIN PANEL</div>
    <div class="AdminFixedpanel_Container">
        
        <div class="Menu_RightContainer">
        	
        </div>
       
                        
                      
    </div>
    
    
    <div class="DashboardContainer_Div">
    	
    	<div class="col-lg-3" >
        	
    			<div class="list-group">
  <a href="addCategory.jsp" class="list-group-item">Category</a>
  <a href="addBird.jsp" class="list-group-item">Add Bird</a>
  <a href="addBirdDetails.jsp" class="list-group-item active">Bird Details</a>
  <a href="addBirdImage.jsp" class="list-group-item">Bird Image Gallery</a>
   <a href="logout.jsp" class="list-group-item ">Logout</a>
</div>
  		  
        </div>
        
        <form method="post" enctype="multipart/form-data" id="birdDetails">
        <div class="col-lg-8" >
        	<div id="Div1" class="row" style="margin-top: 5px; margin-bottom: 10px;">
                            <div id="DIVEditCatList">
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Category</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                   
                                     <select name="categoryId" id="categoryId" class="form-control">
                                     	
                                     </select>
                                </div>
                               
                            </div>
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Bird</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                     <select name="bdId" id="bdId" class="form-control">
                                     	<option value="0">-- Select Bird --</option>
                                       
                                     </select>
                                </div>
                               
                            </div> 
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Color</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                    <input  name="birdColor" type="text" id="birdColor" class="form-control">
                                </div>
                               
                            </div>
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Food</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                     <input  name="birdFood" type="text" id="birdFood" class="form-control">
                                </div>
                               
                            </div>
                                </div>
                            <div id="DIVEditCatList">
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Population</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                   <input  name="birdPopulation" type="text" id="birdPopulation" class="form-control">
                                </div>
                               
                            </div>
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Alternative Name</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                   <input  name="birdAltName" type="text" id="birdAltName" class="form-control">
                                </div>
                               
                            </div> 
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Scientific Name</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                    <input  name="birdSciName" type="text" id="birdSciName" class="form-control">
                                </div>
                               
                            </div>
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Resident</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                     <input  name="birdResident" type="text" id="birdResident" class="form-control">
                                </div>
                               
                            </div>
                                </div>
						
                        <div id="DIVEditCatList">
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Visibility</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                   <input  name="birdVisibility" type="text" id="birdVisibility" class="form-control">
                                </div>
                               
                            </div>
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Migratory Status</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                   <input  name="birdMigrtStatus" type="text" id="birdMigrtStatus" class="form-control">
                                </div>
                               
                            </div> 
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Nesting Period</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                    <input  name="birdNestPeriod" type="text" id="birdNestPeriod" class="form-control">
                                </div>
                               
                            </div>
                            
                                </div>
                        <div id="DIVEditCatList">
                            <div class="col-lg-6">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Details</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                  
                                   <textarea  name="birdDetails" id="birdDetails" class="form-control"></textarea>
                                </div>
                               
                            </div>
                            <div class="col-lg-6">
                                <div class="col-lg-12" style="padding-top: 8px;">
                                    <b>Sound File</b> 
                                    
                                    <div class="Div_Col_Button_Browse_Btn active">
                    Browse Sound
                    	<input type="file" id="birdSound" value="Browse Sound" class="FileUpload_Css" name="birdSound" onchange="checkfile(this);"/>
                    	
 
                    </div>

                                </div>
                                
                            </div> 
                            <div>
                    	<audio controls style="padding-left: 30px;" id="BirdSound" name="BirdSound">
  						<source src="" type="audio/ogg">
  						<source src="" type="audio/mpeg">
						Your browser does not support the audio element.
						</audio>
                    	</div>
                        </div>
                        
                        
                        </div>
                        <div class="row">
                        	<div class="col-lg-12">
                                <div id="DivUpdate" data-target="" data-toggle="modal">
                                   
                                     
                                
                                     </div>
                                <div data-toggle="modal" id="ADDSubCat">
                                     
                                   <input type="submit" name="btnAddDetaisl" value="Add Bird Details" onclick="return validate();"  id="btnAddDetaisl" class="btn btn-primary">
                                    <input type="submit" name="btnUpdDetails" onclick="return updateValidate();" value="Update Bird Details" id="btnUpdDetails" class="btn btn-default">
                                   <input type="reset" name="btnReset" value="Reset" id="btnReset" class="btn btn-danger">
                                   <input type="hidden" name="hfCatId" id="hfCatId">
                                   <input type="hidden" name="hfCatId2" id="hfCatId2">
                                   <input type="hidden" name="hfCatId3" id="hfCatId3" value="">
                                   
                                </div>
                            </div>
                        </div>
                        
                        <div class="Contain_List">
                        	<div class="panel panel-default">
                        <div class="panel-heading">
                            Bird List
                        </div>
                       
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="bird-table">
                                    <thead>
                                        <tr>
                                           
                                            <th>Bird Name</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      
                                             
                                          
                                     
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                        </div>
        </div>
        </form>
       
    </div>
    
    
	

</div>

<div>

</div>
<script type="text/javascript">

$("#birdSound").change(function(){
    readURL(this);
});

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        
        reader.onload = function (e) {
            $('#BirdSound').attr('src', e.target.result);
            console.log($('#BirdSound').attr('src'));
            $('#hfCatId3').attr('value', e.target.result);
            console.log($("#hfCatId3").val());
        }
        
        reader.readAsDataURL(input.files[0]);
    }
}

$("#btnReset").click(function(){
	$("#birdSound").attr("src", "");
});


function checkfile(sender) {
	   var validExts = new Array(".mp3", ".ogg",".aac");
	   var fileExt = sender.value;
	   var birdSound=document.getElementById("birdSound").value;
	   fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
	   if (validExts.indexOf(fileExt) < 0) {
		   $('#birdSound').val('');
	    alert("Invalid file selected, valid files are of "+ validExts.toString() + " types.");
	    document.getElementById("birdSound").focus();
	    return false;
	   } 
	   else
	    return true;
	  }


	 function validate() {
		var SelectCat=document.getElementById("categoryId").value;
		var SelectBird=document.getElementById("bdId").value;
        var txtColor = document.getElementById("birdColor").value;
		var txtFood = document.getElementById("birdFood").value;
		var txtPopulation = document.getElementById("birdPopulation").value;
		var txtAltName = document.getElementById("birdAltName").value;
		var txtScName = document.getElementById("birdSciName").value;
		var txtRes = document.getElementById("birdResident").value;
		var txtVis = document.getElementById("birdVisibility").value;
		var txtMStat = document.getElementById("birdMigrtStatus").value;
		var txtNestPeriod = document.getElementById("birdNestPeriod").value;
		var txtDetails = document.getElementById("birdDetails").value;
        var SoundFile = document.getElementById("birdSound").value;

         if (SelectCat == 0) {
              alert("Please Select Catagory");
              return false;
          }
		if (SelectBird == 0) {
              alert("Please Select Bird");
              return false;
          }
        if (txtColor =="") {
            alert("Please Enter Color");
			document.getElementById("birdColor").focus();
            return false;
        }
       if (txtFood =="") {
            alert("Please Enter Food");
			document.getElementById("birdFood").focus();
            return false;
        }
		if (txtPopulation =="") {
            alert("Please Enter Population");
			document.getElementById("birdPopulation").focus();
            return false;
        }
		if (txtAltName =="") {
            alert("Please Enter Alternative Name");
			document.getElementById("birdAltName").focus();
            return false;
        }
		if (txtScName =="") {
            alert("Please Enter Scientific Name");
			document.getElementById("birdSciName").focus();
            return false;
        }
		if (txtRes =="") {
            alert("Please Enter Residence");
			document.getElementById("birdResident").focus();
            return false;
        }
		if (txtVis =="") {
            alert("Please Enter Visibility");
			document.getElementById("birdVisibility").focus();
            return false;
        }
		if (txtMStat =="") {
            alert("Please Enter Migratory Statu");
			document.getElementById("birdMigrtStatus").focus();
            return false;
        }
		if (txtNestPeriod =="") {
            alert("Please Enter Nesting Period");
			document.getElementById("birdNestPeriod").focus();
            return false;
        }
		if (txtDetails =="") {
            alert("Please Enter Details");
			document.getElementById("birdDetails").focus();
            return false;
        }
		 if (SoundFile.length < 1) {
              alert("Please Browse Sound File to Upload");
			  document.getElementById("birdSound").focus();
              return false;
          }

		 else {
            return true;
        }
    }
	 
	 
	 function updateValidate() {
			var SelectCat=document.getElementById("categoryId").value;
			var SelectBird=document.getElementById("bdId").value;
	        var txtColor = document.getElementById("birdColor").value;
			var txtFood = document.getElementById("birdFood").value;
			var txtPopulation = document.getElementById("birdPopulation").value;
			var txtAltName = document.getElementById("birdAltName").value;
			var txtScName = document.getElementById("birdSciName").value;
			var txtRes = document.getElementById("birdResident").value;
			var txtVis = document.getElementById("birdVisibility").value;
			var txtMStat = document.getElementById("birdMigrtStatus").value;
			var txtNestPeriod = document.getElementById("birdNestPeriod").value;
			var txtDetails = document.getElementById("birdDetails").value;

	         if (SelectCat == 0) {
	              alert("Please Select Catagory");
	              return false;
	          }
			if (SelectBird == 0) {
	              alert("Please Select Bird");
	              return false;
	          }
	        if (txtColor =="") {
	            alert("Please Enter Color");
				document.getElementById("birdColor").focus();
	            return false;
	        }
	       if (txtFood =="") {
	            alert("Please Enter Food");
				document.getElementById("birdFood").focus();
	            return false;
	        }
			if (txtPopulation =="") {
	            alert("Please Enter Population");
				document.getElementById("birdPopulation").focus();
	            return false;
	        }
			if (txtAltName =="") {
	            alert("Please Enter Alternative Name");
				document.getElementById("birdAltName").focus();
	            return false;
	        }
			if (txtScName =="") {
	            alert("Please Enter Scientific Name");
				document.getElementById("birdSciName").focus();
	            return false;
	        }
			if (txtRes =="") {
	            alert("Please Enter Residence");
				document.getElementById("birdResident").focus();
	            return false;
	        }
			if (txtVis =="") {
	            alert("Please Enter Visibility");
				document.getElementById("birdVisibility").focus();
	            return false;
	        }
			if (txtMStat =="") {
	            alert("Please Enter Migratory Statu");
				document.getElementById("birdMigrtStatus").focus();
	            return false;
	        }
			if (txtNestPeriod =="") {
	            alert("Please Enter Nesting Period");
				document.getElementById("birdNestPeriod").focus();
	            return false;
	        }
			if (txtDetails =="") {
	            alert("Please Enter Details");
				document.getElementById("birdDetails").focus();
	            return false;
	        }
			 

			 else {
	            return true;
	        }
	    }
</script>
<script type="text/javascript" src="js/birddet.js"></script>
<script src="js/classie.js"></script>
</body>
</html>