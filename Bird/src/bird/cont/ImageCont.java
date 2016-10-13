package bird.cont;

import bird.entity.*;

import bird.service.ImageService;
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
@RequestMapping("/image")
public class ImageCont{

    @Autowired
	private ImageService imageServices;
    private boolean flag;
    static final Logger logger = Logger.getLogger(Image.class);
   
    @RequestMapping(value="/addBirdImage",method=RequestMethod.POST)
    public @ResponseBody ImageJsonResponse addBirdImage(HttpServletRequest requst,@RequestParam(value="birdImage",required=false) MultipartFile image)
    {
        ImageJsonResponse imageJsonRespons = new ImageJsonResponse();
        Image imageObj = null;
        String imgFile = null;
        String fileName = requst.getParameter("imageName");
        int birdId = Integer.parseInt(requst.getParameter("birdId"));
        Bird bird = new Bird();
        bird.setBirdId(birdId);
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
                imageObj = new Image();
                imageObj.setBird(bird);
                imageObj.setImagePath(fullPath);
                imageObj.setImageName(fileName);
                flag = imageServices.addBirdImage(imageObj);
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

    @RequestMapping(value="/BirdImageListByBirdId",method=RequestMethod.GET)
    public @ResponseBody List<Image> getBirdImageListByBirdId(@RequestParam(value="birdId",required=false)int birdId){
        List<Image> birdImageListByBirdId = new ArrayList<Image>();
        try{
            System.out.println("HELLO");
            birdImageListByBirdId = imageServices.birdImageListByBirdId(birdId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return birdImageListByBirdId;
    }

    private String saveImage(String filename, MultipartFile image){
        String imgSrc = null;
        try{
        String rootPath = System.getProperty("catalina.home");
        logger.debug(rootPath);
        logger.info(rootPath);
        File dir = new File(rootPath + File.separator + "webapps" + File.separator + "Birds" + File.separator + "Images");
        if(!dir.exists())
        {
            dir.mkdirs();
        }
        File file = new File(dir.getAbsolutePath()+ File.separator+ filename);
        FileUtils.writeByteArrayToFile(file, image.getBytes());
        logger.debug("Go to the location:  "
				+ file.toString()
				+ " on your computer and verify that the image has been stored.");
        imgSrc = "Birds" + File.separator + "Images" + File.separator + filename;
        return imgSrc;
        }catch(Exception e){
        e.printStackTrace();
        logger.error("Failed!", e);
        }
        return imgSrc;
    }

}
