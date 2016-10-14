package bird.dao;

import bird.entity.Image;
import bird.entity.ImageBean;

import java.util.List;

public interface ImageDao{

    public boolean addBirdImage(Image image)throws Exception;

    public List<ImageBean> birdImageListByBirdId(int birdId)throws Exception;
}
