package bird.service;

import bird.entity.Bird;
import java.util.List;

public interface BirdService{

    public abstract boolean addBird(Bird bird)throws Exception;

    public abstract List<Bird> getBirdListByCategoryId(int categoryId)throws Exception;
}
