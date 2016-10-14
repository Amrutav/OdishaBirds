package bird.service;

import bird.entity.Image;
import bird.entity.ImageBean;

import java.util.List;

public interface ImageService
{

    public boolean addBirdImage(Image image)throws Exception;

    public List<ImageBean> birdImageListByBirdId(int birdId)throws Exception;
}
