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
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<style type="text/css">
.BrdLine{
	border-bottom: 1px solid #ccc;
	}
</style>
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
 
  <a href="addCategory.jsp" class="list-group-item active">Category</a>
  <a href="addBird.jsp" class="list-group-item ">Add Bird</a>
  <a href="addBirdDetails.jsp" class="list-group-item">Bird Details</a>
  <a href="addBirdImage.jsp" class="list-group-item">Bird Image Gallery</a>
   <a href="logout.jsp" class="list-group-item ">Logout</a>
</div>
  		  		<div class="list-group">
  				
				
  				</div>
  		  		
        </div>
        
       
        <div class="col-lg-8" >
        	<div id="Div1" class="row" style="margin-top: 5px; margin-bottom: 10px;">
                            <div id="DIVEditCatList">
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Category Name</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                     <input name="catName" type="text" id="catName" class="form-control">
                                </div>
                               
                            </div>
                                </div>
                          

                        </div>
                        <div class="row" style="margin-top: 5px; margin-bottom: 10px;">
                        <div class="col-lg-12 pull-left">
                                <div id="DivUpdate" data-target="" data-toggle="modal">
                                   
                                     
                                
                                     </div>
                                <div data-toggle="modal" id="ADDCategory">
                                     
                                     
                                  <input type="submit" name="btnAddCat" value="Add Catagory" onclick="return validate();" id="btnAddCat" class="btn btn-primary">
                                    <input type="submit" name="btnUpdCat" onclick="return validate();" value="Update Catagory" id="btnUpdCat" class="btn btn-default">
                                   <input type="reset" name="btnReset" value="Reset" id="btnReset" class="btn btn-danger">
                                   <input type="hidden" name="hfCatId" id="hfCatId">
                                </div>
                            </div>
                </div> 
                        
                        <div class="Contain_List">
                        	<div class="panel panel-default">
                        <div class="panel-heading">
                            Category List
                        </div>
                       
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="category">
                                    <thead>
                                        <tr>
                                           
                                            <th>Category Name</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      
                                              <!-- <tr>
                                                  
                                                  <td></td>
                                                  <td class="center">
                                                    <a href="#">
                                                          Edit
                                                    </a>
                                                    
                                                  </td>
                                                  <td class="center"><a href="#">Delete</a></td>
                                              </tr> -->
                                          
                                     
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                        </div>
        </div>
       
       
    </div>
    
    
	

</div>

<div>

</div>
<div id="display">

</div>
<script type="text/javascript">
    
    
    function validate() {

        var categoryName = document.getElementById("catName").value;
        
        if (categoryName == "") {
            alert("Please Enter Catagory");
            document.getElementById("catName").focus();
			return false;
        } else{
        	return true;
        }
        
    }
</script>
<script type="text/javascript" src="js/cat.js"></script>
<script src="js/classie.js"></script>

</body>
</html>