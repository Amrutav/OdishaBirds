package bird.cont;

import bird.entity.*;

import bird.service.ImageService;
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
        int birdId = Integer.parseInt(requst.getParameter("bdId"));
        BIrd bird=new BIrd();
        bird.setBirdId(birdId);
        String hostname = "http://85.25.196.222:8083/";
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
                System.out.println(flag);
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
    public @ResponseBody List<ImageBean> getBirdImageListByBirdId(@RequestParam(value="birdId",required=false)int birdId){
        List<ImageBean> birdImageListByBirdId = new ArrayList<ImageBean>();
        try{
            System.out.println("HELLO");
            birdImageListByBirdId = imageServices.birdImageListByBirdId(birdId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return birdImageListByBirdId;
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
    
    @RequestMapping(value = "/deleteImage", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ImageJsonResponse deleteImage(@Valid @RequestBody Image image){
    	ImageJsonResponse imageJsonResponse = new ImageJsonResponse();
		System.out.println(image.getImageId());
		try{
			flag = imageServices.deleteImage(image);
			if(flag){
				imageJsonResponse.setStatus("SUCCESS");
			}else{
				imageJsonResponse.setStatus("FAILED");
			}
			return imageJsonResponse;
		}catch (Exception e) {
			imageJsonResponse.setStatus(e.toString());
			logger.error("Exception Occurs in : ", e);
		}
		return imageJsonResponse;
	}
}
