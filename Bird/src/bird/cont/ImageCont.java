package bird.cont;

import bird.entity.*;

import bird.service.ImageService;
import bird.utils.FileOperations;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    String status=null;
    static final Logger logger = Logger.getLogger(Image.class);
   
    @RequestMapping(value="/addBirdImage",method=RequestMethod.POST)
    public void addBirdImage(HttpServletRequest requst,HttpServletResponse response,@RequestParam(value="birdImage",required=false) MultipartFile image)throws ServletException, IOException
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
                imgFile = FileOperations.saveImage(fileName+dateFormat.format(date).toString()+".jpg", image);
                fullPath = hostname+imgFile;
                imageObj = new Image();
                imageObj.setBird(bird);
                imageObj.setImagePath(fullPath);
                imageObj.setImageName(fileName);
                flag = imageServices.addBirdImage(imageObj);
                System.out.println(flag);
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
        response.sendRedirect("http://85.25.196.222:8083/Birds/addBirdImage.jsp");
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
