package bird.cont;

import bird.entity.*;

import bird.service.BirdService;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
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
    static final Logger logger = Logger.getLogger(BirdDetail.class);
    
    @RequestMapping(value="/addBirdDetail", method = RequestMethod.POST)
     public @ResponseBody BirdJsonResponse addBird(HttpServletRequest requst,@RequestParam(value="birdSound",required=false) MultipartFile sound){
        BirdJsonResponse birdJsonRespons = new BirdJsonResponse();
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
        String hostname = "http://85.25.196.222:8080/";
        String fullPath = null;
        System.out.println("controller body");
        try
        {
            if(sound != null && sound.getSize() != 0)
            {
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                soundFile = saveSound(fileName+dateFormat.format(date).toString()+".mp3",sound);
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
                if(flag)
                {
                    birdJsonRespons.setStatus("SUCCSS");
                } else
                {
                    birdJsonRespons.setStatus("FAILED");
                }
            }
        }
        catch(Exception e)
        {
            logger.error("Error occours in : ", e);
            birdJsonRespons.setStatus(e.toString());
        }
        return birdJsonRespons;
    }

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

    @RequestMapping(value="/addBird",method=RequestMethod.POST)
    public @ResponseBody BIrdJson addBirdImage(HttpServletRequest requst,@RequestParam(value="birdImage",required=false) MultipartFile image)
    {
    	BIrdJson imageJsonRespons = new BIrdJson();
        BIrd imageObj = null;
        String imgFile = null;
        String fileName = requst.getParameter("birdName");
        System.out.println("controller body");
        int catId = Integer.parseInt(requst.getParameter("categoryId"));
        Category category=new Category();
        category.setCategoryId(catId);
        String hostname = "http://85.25.196.222:8080/";
        String fullPath = null;
        System.out.println("controller body");
        try
        {
            if(image != null)
            {
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                imgFile = saveImage(fileName+dateFormat.format(date).toString()+".jpg", image);
                fullPath = hostname+imgFile;
                imageObj = new BIrd();
                imageObj.setCategory(category);
                imageObj.setBirdImage(fullPath);
                imageObj.setBirdName(fileName);
                flag = birdServices.addNewBird(imageObj);
                if(flag){
                    imageJsonRespons.setStatus("SUCCSS");
                } else{
                    imageJsonRespons.setStatus("FAILED");
                }
            }
        }
        catch(Exception e)
        {
            logger.error("Error occours in : ", e);
            imageJsonRespons.setStatus(e.toString());
        }
        return imageJsonRespons;
    }
    
    @RequestMapping(value="/BirdListByCatId",method=RequestMethod.GET)
    public @ResponseBody List<BIrdBeans> getBirdListByCatId(@RequestParam(value="categoryId",required=false)int categoryId){
        List<BIrdBeans> birdListByBirdId = new ArrayList<BIrdBeans>();
        try{
            System.out.println("HELLO");
            birdListByBirdId = birdServices.birdListByCatId(categoryId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return birdListByBirdId;
    }
    
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
    
    private String saveImage(String filename, MultipartFile image)throws RuntimeException, IOException {

		//save image starts
		String imgSrc=null;
		try {
			
			String rootPath = System.getProperty("catalina.home");
			logger.debug(rootPath);
			logger.info(rootPath);
		    File dir = new File(rootPath + File.separator + "webapps" + File.separator + "BirdImages");
		    if (!dir.exists())
		     dir.mkdirs();
			File file = new File(dir.getAbsolutePath()+ File.separator+ filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			logger.debug("Go to the location:  "
					+ file.toString()
					+ " on your computer and verify that the image has been stored.");
			imgSrc= "BirdImages" + File.separator + filename;
			return imgSrc;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Failed!", e);
		}
		return imgSrc;
		//save image ends
	}
    
    private String saveSound(String filename, MultipartFile sound)throws RuntimeException, IOException{
    	
        String soundSrc = null;
        try{
        String rootPath = System.getProperty("catalina.home");
        logger.debug(rootPath);
        logger.info(rootPath);
        File dir = new File(rootPath + File.separator + "webapps" + File.separator + "BirdSounds");
        if(!dir.exists())
        {
            dir.mkdirs();
        }
        File file = new File(dir.getAbsolutePath()+ File.separator+ filename);
        FileUtils.writeByteArrayToFile(file, sound.getBytes());
        logger.debug("Go to the location:  "
				+ file.toString()
				+ " on your computer and verify that the sound has been stored.");
        soundSrc = "BirdSounds" + File.separator + filename;
        return soundSrc;
        }catch(Exception e){
        	e.printStackTrace();
			logger.error("Failed!", e);
        }
        return soundSrc;
    }
    
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
    
    @RequestMapping(value = "/deleteBird", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BIrdJson deleteImage(@Valid @RequestBody BIrd bird){
    	BIrdJson birdJsonResponse = new BIrdJson();
		System.out.println(bird.getBirdId());
		try{
			flag = birdServices.deleteBird(bird);
			if(flag){
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
}
