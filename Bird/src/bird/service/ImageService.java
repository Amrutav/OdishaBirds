package bird.service;

import bird.entity.Image;
import java.util.List;

public interface ImageService
{

    public boolean addBirdImage(Image image)throws Exception;

    public List<Image> birdImageListByBirdId(int birdId)throws Exception;
}
