package bird.dao;

import bird.entity.Bird;
import java.util.List;

public interface BirdDao
{

    public abstract boolean addBird(Bird bird)throws Exception;

    public abstract List<Bird> getBirdListByCategoryId(int categoryId)throws Exception;
}
