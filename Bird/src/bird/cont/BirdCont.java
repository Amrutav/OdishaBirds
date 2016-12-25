package bird.cont;

import bird.entity.*;



import bird.service.BirdService;
import bird.utils.FileOperations;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/bird")
public class BirdCont
{

    @Autowired
	BirdService birdServices;
    private boolean flag;
    String status=null;
    static final Logger logger = Logger.getLogger(BirdDetail.class);
    String name=null;
 
    
    //Bird
    
    //Add New Bird
    
    @RequestMapping(value="/addBird",method=RequestMethod.POST)
    public void addNewBird(HttpServletRequest requst,HttpServletResponse response,@RequestParam(value="birdImage",required=false) MultipartFile image)throws ServletException, IOException
    {
        BIrd imageObj = null;
        String imgFile = null;
        String fileName = requst.getParameter("birdName");
        System.out.println("controller body");
        int catId = Integer.parseInt(requst.getParameter("categoryId"));
        Category category=new Category();
        category.setCategoryId(catId);
        String hostname = "http://85.25.196.222:8083/";
        String fullPath = null;
        System.out.println("controller body");
        try
        {
            if(image != null)
            {
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                imgFile = FileOperations.saveImage(fileName+dateFormat.format(date).toString()+".jpg", image);
                fullPath = hostname+imgFile;
                imageObj = new BIrd();
                imageObj.setCategory(category);
                imageObj.setBirdImage(fullPath);
                imageObj.setBirdName(fileName);
                flag = birdServices.addNewBird(imageObj);
                if(flag){
                	status="SUCCESS";
                } else{
                	status="UnSuccessful";
                }
            }
        }
        catch(Exception e)
        {
            logger.error("Error occours in : ", e);
        }
        response.sendRedirect("http://85.25.196.222:8083/Birds/addBird.jsp");
    }
    
    
//Bird List By Category Id 
    
    @RequestMapping(value="/BirdListByCatId",method=RequestMethod.GET)
    public @ResponseBody List<BIrdBeans> getBirdListByCatId(@RequestParam(value="categoryId",required=false)int categoryId){
        List<BIrdBeans> birdListByCatId = new ArrayList<BIrdBeans>();
        try{
            System.out.println("HELLO");
            birdListByCatId = birdServices.birdListByCatId(categoryId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return birdListByCatId;
    }
    
    
//Bird List By Bird Id 
    
    @RequestMapping(value="/BirdListByBirdId",method=RequestMethod.GET)
    public @ResponseBody List<BIrd> getBirdListByBirdId(@RequestParam(value="birdId",required=false)int birdId){
        List<BIrd> birdListByBirdId = new ArrayList<BIrd>();
        try{
            System.out.println("HELLO");
            birdListByBirdId = birdServices.birdListByBirdId(birdId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return birdListByBirdId;
    }
    
    
//Bird List by category in ascending order
    
    @RequestMapping(value="/BirdList",method=RequestMethod.GET)
    public @ResponseBody List<BIrdBeans> getBirdList(){
        List<BIrdBeans> birdList = new ArrayList<BIrdBeans>();
        try{
            System.out.println("Incoming");
            birdList = birdServices.birdList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return birdList;
    }
    
    
//Validate the Bird by Name
    
    @RequestMapping(value = "/validateBird", method = RequestMethod.GET)
	public @ResponseBody BIrdJson validateBirdName( @RequestParam(value = "birdName") String birdName) {
    	BIrdJson birdJsonResponse=new BIrdJson();
	    try {
	        BIrd category = birdServices.validateBirdName(birdName);
	        if(category!=null){
	        	birdJsonResponse.setStatus("EXIST");
	        }else{
	        	birdJsonResponse.setStatus("NOT EXIST");
	        }
	    	return birdJsonResponse;
	       } catch (Exception e) {
	    	logger.error("Exception occurs in", e);
	    	birdJsonResponse.setStatus(e.toString());
	    }
	   	return birdJsonResponse;
	}
    
    
 //Search Bird By Name
    
    @RequestMapping(value="/searchByBirdName", method = RequestMethod.GET)
	public @ResponseBody List<BIrd> getBirdList(@RequestParam(value="birdname") String birdName ){
		List<BIrd> list= new ArrayList<BIrd>();
		try{
			list=birdServices.searchByName(birdName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
    
    
 //Delete the bird 
    
    @RequestMapping(value = "/deleteBird", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BIrdJson deleteBird(@Valid @RequestBody BIrd bird){
    	BIrdJson birdJsonResponse = new BIrdJson();
    	List<BIrd> birdByBirdId = new ArrayList<BIrd>();
    	int birdId=bird.getBirdId();
		System.out.println(bird.getBirdId());
		
		try{
			System.out.println("Incoming");
			birdByBirdId = birdServices.birdListByBirdId(birdId);
			for(int i=0;i<birdByBirdId.size();i++){ 
				name=birdByBirdId.get(i).getBirdImage();
				 }
			System.out.println(name);
			flag = birdServices.deleteBird(bird);
			if(flag){
				FileOperations.deleteFile(name);
				birdJsonResponse.setStatus("SUCCESS");
			}else{
				birdJsonResponse.setStatus("FAILED");
			}
			return birdJsonResponse;
		}catch (Exception e) {
			birdJsonResponse.setStatus(e.toString());
			logger.error("Exception Occurs in : ", e);
		}
		return birdJsonResponse;
	}
    
    
//Update Bird    
    
    @RequestMapping(value="/updateBird", method = RequestMethod.POST)
	public void updateBird(HttpServletRequest requst,HttpServletResponse response, @RequestParam(value="birdImage",required=false)MultipartFile image)throws ServletException, IOException{
		CategoryJsonResponse categoryJsonRespons = new CategoryJsonResponse();
		BIrd bird=null;
		String imgFile=null;
		String fileName=requst.getParameter("birdName");
		System.out.println(fileName);
		String hfname=requst.getParameter("hfCatId2");
		String name=requst.getParameter("hfCatId3");
		System.out.println("Hidden field is: "+hfname);
		System.out.println("image field name is: "+name);
		int id=Integer.parseInt(requst.getParameter("hfCatId"));
		int catid=Integer.parseInt(requst.getParameter("categoryId"));
		Category category=new Category();
		category.setCategoryId(catid);
		String hostname="http://85.25.196.222:8083/";
		String fullPath=null;
		System.out.println("Update");
		if(!hfname.equals(name)){
			System.out.println("image update ");
		
		try{
			if(image != null){
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss") ;
				imgFile=FileOperations.saveImage(fileName+dateFormat.format(date).toString()+".jpg",image);
			fullPath=hostname+imgFile;	
			bird=new BIrd();
			bird.setBirdId(id);
			bird.setCategory(category);
			bird.setBirdName(fileName);
			bird.setBirdImage(fullPath);
			boolean flag=birdServices.updateBird(bird);
			if(flag){
				FileOperations.deleteFile(name);
				status="SUCCESS";
			}else{
				status="UNSUCCESS";
			}
			}
			
		}catch(Exception e){
			logger.error("Error occours in : ",e);
			categoryJsonRespons.setStatus(e.toString());
		}
		}
		else if (hfname.equals(name)) {
			System.out.println("only update ");
			try {
				bird=new BIrd();
				bird.setBirdId(id);
				bird.setCategory(category);
				bird.setBirdName(fileName);
				bird.setBirdImage(hfname);
				boolean flag=birdServices.updateBird(bird);
				if(flag){
					FileOperations.deleteFile(name);
					status="SUCCESS";
				}else{
					status="UNSUCCESS";
				}
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("http://85.25.196.222:8083/Birds/addBird.jsp");
	}
    
    
    
    
    //Bird Details
    
    
    //Add Bird Details
    
    @RequestMapping(value="/addBirdDetail", method = RequestMethod.POST)
     public void addBirdDetail(HttpServletRequest requst,HttpServletResponse response,@RequestParam(value="birdSound",required=false) MultipartFile sound)throws ServletException, IOException
    {
        BirdDetail bird = null;
        String soundFile = null;
        String fileName="OriBird";
        String birdColor = requst.getParameter("birdColor");
        String birdDetails = requst.getParameter("birdDetails");
        String birdFood = requst.getParameter("birdFood");
        String birdPopulation = requst.getParameter("birdPopulation");
        String birdAltName = requst.getParameter("birdAltName");
        String birdSciName = requst.getParameter("birdSciName");
        String birdResident = requst.getParameter("birdResident");
        String birdVisibility = requst.getParameter("birdVisibility");
        String birdMigrtStatus = requst.getParameter("birdMigrtStatus");
        String birdNestPeriod = requst.getParameter("birdNestPeriod");
        int bdId = Integer.parseInt(requst.getParameter("bdId"));
        BIrd birdObj=new BIrd();
        birdObj.setBirdId(bdId);
        String hostname = "http://85.25.196.222:8083/";
        String fullPath = null;
        System.out.println("controller body");
        try
        {
            if(sound != null && sound.getSize() != 0)
            {
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                soundFile = FileOperations.saveSound(fileName+dateFormat.format(date).toString()+".mp3",sound);
                fullPath = hostname+soundFile;
                bird = new BirdDetail();
                bird.setBirdSound(fullPath);
                bird.setBirdColor(birdColor);
                bird.setBirdDetails(birdDetails);
                bird.setBirdFood(birdFood);
                bird.setBirdPopulation(birdPopulation);
                bird.setBirdAltName(birdAltName);
                bird.setBirdSciName(birdSciName);
                bird.setBirdRsident(birdResident);
                bird.setBirdVisibility(birdVisibility);
                bird.setBirdMigrtStatus(birdMigrtStatus);
                bird.setBirdNestPeriod(birdNestPeriod);
                bird.setBird(birdObj);
                flag = birdServices.addBird(bird);
                if(flag){
                	status="SUCCESS";
                } else{
                	status="UnSuccessful";
                }
            }
        }
        catch(Exception e)
        {
            logger.error("Error occours in : ", e);
            e.printStackTrace();
        }
        response.sendRedirect("http://85.25.196.222:8083/Birds/addBirdDetails.jsp");
    }

    
    //View Bird Details By Bird Id
    
    @RequestMapping(value="/BirdDetailsListByBirdId", method = RequestMethod.GET)
    public @ResponseBody List<BirdBean> getBirdListByCategoryId(@RequestParam(value = "birdId")int birdId)
    {
        List<BirdBean> birdDetailsListByBirdId = new ArrayList<BirdBean>();
        try
        {
            System.out.println("HELLO");
            birdDetailsListByBirdId = birdServices.getBirdListByCategoryId(birdId);
            logger.debug(birdDetailsListByBirdId);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return birdDetailsListByBirdId;
    }
    
        
    
    //Validate the Bird Details that the details are present or not
    
    @RequestMapping(value = "/validateBirdDetails", method = RequestMethod.GET)
	public @ResponseBody BirdJsonResponse validateBirdDetails( @RequestParam(value = "bdId") String bdId) {
    	BirdJsonResponse birdJsonResponse=new BirdJsonResponse();
	    try {
	    	BirdDetail details = birdServices.validateBirdDetails(bdId);
	        if(details.getBird().getBirdId()>0){
	        	birdJsonResponse.setStatus("EXIST");
	        }else{
	        	birdJsonResponse.setStatus("NOT EXIST");
	        }
	    	return birdJsonResponse;
	       } catch (Exception e) {
	    	logger.error("Exception occurs in", e);
	    	birdJsonResponse.setStatus(e.toString());
	    }
	   	return birdJsonResponse;
	}
    
    
//BirdDetails List By BirdDet Id 
    
    @RequestMapping(value="/BirdDetListByBirdDetId",method=RequestMethod.GET)
    public @ResponseBody List<BirdDetail> getBirdDetListByBirdDetId(@RequestParam(value="birdDetailId",required=false)int birdDetailId){
        List<BirdDetail> birdListByBirdId = new ArrayList<BirdDetail>();
        try{
            System.out.println("HELLO");
            birdListByBirdId = birdServices.birdDetListByBirdDetId(birdDetailId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return birdListByBirdId;
    }
    
//Delete the bird 
    
    @RequestMapping(value = "/deleteBirdDetail", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BirdJsonResponse deleteBirdDetails(@Valid @RequestBody BirdDetail bird){
    	BirdJsonResponse birdJsonResponse = new BirdJsonResponse();
    	List<BirdDetail> birdByBirdId = new ArrayList<BirdDetail>();
    	int birdDetailId=bird.getBirdDetailId();
		System.out.println(bird.getBirdDetailId());
		
		try{
			System.out.println("Incoming");
			birdByBirdId = birdServices.birdDetListByBirdDetId(birdDetailId);
			for(int i=0;i<birdByBirdId.size();i++){ 
				name=birdByBirdId.get(i).getBirdSound();
				 }
			System.out.println(name);
			flag = birdServices.deleteBirdDetails(bird);
			if(flag){
				FileOperations.deleteFile(name);
				birdJsonResponse.setStatus("SUCCESS");
			}else{
				birdJsonResponse.setStatus("FAILED");
			}
			return birdJsonResponse;
		}catch (Exception e) {
			birdJsonResponse.setStatus(e.toString());
			logger.error("Exception Occurs in : ", e);
		}
		return birdJsonResponse;
	}
    
    
//Update Bird  Details 
    
    @RequestMapping(value="/updateBirdDetails", method = RequestMethod.POST)
	public void updateBirdDetails(HttpServletRequest requst,HttpServletResponse response,@RequestParam(value="birdSound",required=false) MultipartFile sound)throws ServletException, IOException
    {
		CategoryJsonResponse categoryJsonRespons = new CategoryJsonResponse();
		BirdDetail bird = null;
		String soundFile=null;
		String fileName="OriBird";
		System.out.println(fileName);
		String hfname=requst.getParameter("hfCatId2");
		String name=requst.getParameter("hfCatId3");
		System.out.println("Hidden field is: "+hfname);
		System.out.println("image field name is: "+name);
		
		int id=Integer.parseInt(requst.getParameter("hfCatId"));
		
		int catid=Integer.parseInt(requst.getParameter("categoryId"));
		Category category=new Category();
		category.setCategoryId(catid);
		
		int bdId = Integer.parseInt(requst.getParameter("bdId"));
        BIrd birdObj=new BIrd();
        birdObj.setBirdId(bdId);
        
        String birdColor = requst.getParameter("birdColor");
        String birdDetails = requst.getParameter("birdDetails");
        String birdFood = requst.getParameter("birdFood");
        String birdPopulation = requst.getParameter("birdPopulation");
        String birdAltName = requst.getParameter("birdAltName");
        String birdSciName = requst.getParameter("birdSciName");
        String birdResident = requst.getParameter("birdResident");
        String birdVisibility = requst.getParameter("birdVisibility");
        String birdMigrtStatus = requst.getParameter("birdMigrtStatus");
        String birdNestPeriod = requst.getParameter("birdNestPeriod");
        
		String hostname="http://85.25.196.222:8083/";
		String fullPath=null;
		
		System.out.println("Update");
		
		if(!hfname.equals(name)){
			System.out.println("image update ");
		
		try{
			if(sound != null){
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss") ;
				soundFile=FileOperations.saveSound(fileName+dateFormat.format(date).toString()+".mp3",sound);
			fullPath=hostname+soundFile;	
			bird = new BirdDetail();
			bird.setBirdSound(fullPath);
            bird.setBirdColor(birdColor);
            bird.setBirdDetails(birdDetails);
            bird.setBirdFood(birdFood);
            bird.setBirdPopulation(birdPopulation);
            bird.setBirdAltName(birdAltName);
            bird.setBirdSciName(birdSciName);
            bird.setBirdRsident(birdResident);
            bird.setBirdVisibility(birdVisibility);
            bird.setBirdMigrtStatus(birdMigrtStatus);
            bird.setBirdNestPeriod(birdNestPeriod);
            bird.setBird(birdObj);
			boolean flag=birdServices.updateBirdDetails(bird);
			if(flag){
				FileOperations.deleteFile(name);
				status="SUCCESS";
			}else{
				status="UNSUCCESS";
			}
			}
			
		}catch(Exception e){
			logger.error("Error occours in : ",e);
			categoryJsonRespons.setStatus(e.toString());
		}
		}
		else if (hfname.equals(name)) {
			System.out.println("only update ");
			try {
				bird.setBirdSound(hfname);
                bird.setBirdColor(birdColor);
                bird.setBirdDetails(birdDetails);
                bird.setBirdFood(birdFood);
                bird.setBirdPopulation(birdPopulation);
                bird.setBirdAltName(birdAltName);
                bird.setBirdSciName(birdSciName);
                bird.setBirdRsident(birdResident);
                bird.setBirdVisibility(birdVisibility);
                bird.setBirdMigrtStatus(birdMigrtStatus);
                bird.setBirdNestPeriod(birdNestPeriod);
                bird.setBird(birdObj);
				boolean flag=birdServices.updateBirdDetails(bird);
				if(flag){
					FileOperations.deleteFile(name);
					status="SUCCESS";
				}else{
					status="UNSUCCESS";
				}
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("http://85.25.196.222:8083/Birds/addBirdDetails.jsp");
	}   
}
