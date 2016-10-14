package bird.dao;

import bird.entity.Bird;
import bird.entity.BirdBean;

import java.util.List;

public interface BirdDao
{

    public abstract boolean addBird(Bird bird)throws Exception;

    public abstract List<BirdBean> getBirdListByCategoryId(int categoryId)throws Exception;
}
