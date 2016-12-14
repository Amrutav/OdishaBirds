package bird.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileOperations {
		
	//Save Image Method
	
		public static String saveImage(String filename, MultipartFile image)throws RuntimeException, IOException {

			//save image starts
			String imgSrc=null;
			try {
				
				String rootPath = System.getProperty("catalina.home");
			    File dir = new File(rootPath + File.separator + "webapps" + File.separator + "BirdImages");
			    if (!dir.exists())
			     dir.mkdirs();
				File file = new File(dir.getAbsolutePath()+ File.separator+ filename);
				FileUtils.writeByteArrayToFile(file, image.getBytes());
				imgSrc= "BirdImages" + File.separator + filename;
				return imgSrc;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return imgSrc;
			//save image ends
		}
		
		
		//Save Image Method
		
			public static String saveSound(String filename, MultipartFile sound)throws RuntimeException, IOException {

				//save image starts
				String imgSrc=null;
				try {
					
					String rootPath = System.getProperty("catalina.home");
				    File dir = new File(rootPath + File.separator + "webapps" + File.separator + "BirdSounds");
				    if (!dir.exists())
				     dir.mkdirs();
					File file = new File(dir.getAbsolutePath()+ File.separator+ filename);
					FileUtils.writeByteArrayToFile(file, sound.getBytes());
					imgSrc= "BirdSounds" + File.separator + filename;
					return imgSrc;
				} catch (IOException e) {
					e.printStackTrace();
				}
				return imgSrc;
				//save image ends
			}
		
		
		//Delete File
		
		
		public static String deleteFile(String fileName)throws RuntimeException, IOException{
			String status=null;
			try{

				//URI uri=new URI(fileName);
				//if(uri.isAbsolute()){
					//System.out.println("Absolute");
					File file=new File(fileName);
					//file.delete();
					if(!file.exists()&& !file.isDirectory()){
						//FileUtils.forceDelete(file);
						file.delete();
						status="Success";
						}
					else{
						status="Failed";
					}
				//}
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println(status);
			return status;
		}
}
