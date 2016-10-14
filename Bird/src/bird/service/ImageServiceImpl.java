package bird.service;

import bird.dao.ImageDao;
import bird.entity.Image;
import bird.entity.ImageBean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class ImageServiceImpl implements ImageService{

    @Autowired
	ImageDao imageDao;
    
    public boolean addBirdImage(Image imageObj)throws Exception{
        return imageDao.addBirdImage(imageObj);
    }

    public List<ImageBean> birdImageListByBirdId(int birdId)throws Exception{
        return imageDao.birdImageListByBirdId(birdId);
    }
}
