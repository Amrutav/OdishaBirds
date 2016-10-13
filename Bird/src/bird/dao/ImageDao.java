package bird.dao;

import bird.entity.Image;
import java.util.List;

public interface ImageDao{

    public boolean addBirdImage(Image image)throws Exception;

    public List<Image> birdImageListByBirdId(int birdId)throws Exception;
}
