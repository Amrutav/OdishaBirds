<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <a href="addBirdDetails.jsp" class="list-group-item">Bird Details</a>
  <a href="addBirdImage.jsp" class="list-group-item active">Bird Image Gallery</a>
   <a href="logout.jsp" class="list-group-item ">Logout</a> 
</div>
  		  
        </div>
        <form method="post" enctype="multipart/form-data" id="imageGallery">
        <div class="col-lg-8" >
        	<div id="Div1" class="row" style="margin-top: 5px; margin-bottom: 10px;">
                            <div id="DIVEditCatList">
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Catagory</b></div>
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
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Image Name</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                     <input  name="imageName" type="text" id="imageName" class="form-control">
                                </div>
                               
                            </div> 
                             
                            <div class="col-lg-3">
                                <div class="col-lg-5" style="padding-top: 8px;">
                                    <b>Image</b>
                                    
                                    <div class="Div_Col_Button_Browse_Btn active">
                    Browse Image
                    	<input type="file" id="birdImage" value="Browse Image" class="FileUpload_Css" onchange="checkfile(this);" name="birdImage"/>
                    	
                    </div>

                                </div>
                                <div class="col-lg-7" style="padding-left:80px;">
                                    
                                         <img id="BirdImage" src="img/profile.png"  style="height:90px;width:90px;border-width:0px;border:1px solid #ccc;">
                                  
                                </div>
                            </div>
                                </div>
                            
						<!-- <div id="DIVEditCatList" style="padding-left:20px;">
                            
                          <div class="BirdImage_Box">
							<img src="">
    						<div class="BirdImage_button_Box">
                                <div class="BirdImage_Button">
                                    Delete
                                </div>
    						</div>
						 </div>   
                            
                        </div> -->
						
						
						
						
                        </div>
                        <div class="row">
                        	<div class="col-lg-12">
                                <div id="DivUpdate" data-target="" data-toggle="modal">
                                   
                                     
                                
                                     </div>
                                <div data-toggle="modal" id="ADDSubCat">
                                    
                                   
                                   <input type="submit" name="btnAddCat" value="Add Bird Image" onclick="return validate();" id="btnAddCat" class="btn btn-primary">
                                   <input type="reset" name="btnReset" value="Reset" id="btnReset" class="btn btn-danger">
                                   
                                   
                                </div>
                            </div>
                        </div>
                        
                        
                        <div style="padding-top:20px">
                        <table class="table_gallery" id="image" >
                                    
                                    <tbody>
                                     <!-- <td style="padding-left:10px">
                                      <img src="http://85.25.196.222:8083/BirdImages/Parrot20161024140219.jpg" style="height:100px;width:100px; padding-bottom: 2px;"><br>&nbsp;&nbsp;<input type="button" name="btnAddCat" value="DELETE"id="btnAddCat" class="btn btn-danger" >
                                      </td>
                                        <td style="padding-left:20px">
                                      <img src="http://85.25.196.222:8083/BirdImages/Parrot20161024140219.jpg" style="height:100px;width:100px;"><input type="submit" name="btnAddCat" value="DELETE"id="btnAddCat" class="btn-gallery btn-del-gallery">
                                      </td> -->       
                                          
                                     
                                    </tbody>
                                </table>
                        </div>
                        
                        
                        <div class="Contain_List">
                        	<div class="panel panel-default">
                        <div class="panel-heading">
                            Bird List
                        </div>
                       
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="image-table">
                                    <thead>
                                        <tr>
                                           
                                            <th>Bird Name</th>
                                            <th>Gallery</th>
                                            
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

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        
        reader.onload = function (e) {
            $('#BirdImage').attr('src', e.target.result);
            $('#hfCatId3').attr('value', e.target.result);
            console.log($("#hfCatId3").val());
        }
        
        reader.readAsDataURL(input.files[0]);
    }
}
$("#birdImage").change(function(){
    readURL(this);
});
$("#btnReset").click(function(){
	$("#BirdImage").attr("src", "");
});

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
   } else
    return true;
  }
	
	 function validate() {
		var Cat=document.getElementById("categoryId").value;
	  var bdid=document.getElementById("bdId").value;
	  var fname=document.getElementById("birdImage").value;
	  var BirdName=document.getElementById("imageName").value;

         if (Cat == 0) {
              alert("Please Select Catagory");
              return false;
          }
			
		if(bdid == 0){
		  alert("Please select Bird");
		  document.getElementById("bdId").focus();
		  return false;
	  }
        if (BirdName =="") {
            alert("Please Enter Bird Name");
			document.getElementById("imageName").focus();
            return false;
        }
       
		 if (fname.length < 1) {
              alert("Please Browse File to Upload");
              return false;
          }

		 else {
            return true;
        }
    }
</script>
<script type="text/javascript" src="js/image.js"></script>
<script src="js/classie.js"></script>
</body>
</html>