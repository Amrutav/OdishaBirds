package bird.cont;

import bird.entity.*;

import bird.service.BirdService;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    static final Logger logger = Logger.getLogger(Bird.class);
    
    @RequestMapping(value="/addBird", method = RequestMethod.POST)
     public @ResponseBody BirdJsonResponse addBird(HttpServletRequest requst,@RequestParam(value="birdSound",required=false) MultipartFile sound){
        BirdJsonResponse birdJsonRespons = new BirdJsonResponse();
        Bird bird = null;
        String soundFile = null;
        String fileName = requst.getParameter("birdName");
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
        int catId = Integer.parseInt(requst.getParameter("catId"));
        Category category = new Category();
        category.setCategoryId(catId);
        String hostname = "http://85.25.196.222:8080/";
        String fullPath = null;
        System.out.println("controller body");
        try
        {
            if(sound != null)
            {
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                soundFile = saveSound(fileName+dateFormat.format(date).toString()+".mp3",sound);
                fullPath = hostname+soundFile;
                bird = new Bird();
                bird.setBirdName(fileName);
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
                bird.setCategory(category);
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

    @RequestMapping(value="/BirdListByCategoryId", method = RequestMethod.GET)
    public @ResponseBody List<Bird> getBirdListByCategoryId(@RequestParam(value = "categoryId")int categoryId)
    {
        List<Bird> birdListByCategoryId = new ArrayList<Bird>();
        try
        {
            System.out.println("HELLO");
            birdListByCategoryId = birdServices.getBirdListByCategoryId(categoryId);
            logger.debug(birdListByCategoryId);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return birdListByCategoryId;
    }

    private String saveSound(String filename, MultipartFile sound){
    	
        String soundSrc = null;
        try{
        String rootPath = System.getProperty("catalina.home");
        logger.debug(rootPath);
        logger.info(rootPath);
        File dir = new File(rootPath + File.separator + "webapps" + File.separator + "Birds" + File.separator + "Sounds");
        if(!dir.exists())
        {
            dir.mkdirs();
        }
        File file = new File(dir.getAbsolutePath()+ File.separator+ filename);
        FileUtils.writeByteArrayToFile(file, sound.getBytes());
        logger.debug("Go to the location:  "
				+ file.toString()
				+ " on your computer and verify that the sound has been stored.");
        soundSrc = "Birds" + File.separator + "Sounds" + File.separator + filename;
        return soundSrc;
        }catch(Exception e){
        	e.printStackTrace();
			logger.error("Failed!", e);
        }
        return soundSrc;
    }

}
