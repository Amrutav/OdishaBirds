package bird.service;

import bird.dao.ImageDao;
import bird.entity.Image;
import bird.entity.ImageBean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class ImageServiceImpl implements ImageService{

    @Autowired
	ImageDao imageDao;
   
    @Override
    public boolean addBirdImage(Image imageObj)throws Exception{
        return imageDao.addBirdImage(imageObj);
    }
    
    @Override
    public List<ImageBean> birdImageListByBirdId(int birdId)throws Exception{
        return imageDao.birdImageListByBirdId(birdId);
    }

	@Override
	public boolean deleteImage(Image image) throws Exception {
		// TODO Auto-generated method stub
		return imageDao.deleteImage(image);
	}
}
