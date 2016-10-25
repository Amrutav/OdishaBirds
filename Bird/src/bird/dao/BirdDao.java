package bird.dao;

import bird.entity.BirdDetail;
import bird.entity.Category;
import bird.entity.BIrd;
import bird.entity.BIrdBeans;
import bird.entity.BirdBean;

import java.util.List;

public interface BirdDao
{

    public abstract boolean addBird(BirdDetail bird)throws Exception;

    public abstract List<BirdBean> getBirdListByCategoryId(int birdId)throws Exception;

	public abstract boolean addNewBird(BIrd imageObj)throws Exception;

	public abstract List<BIrdBeans> birdListByCatId(int categoryId)throws Exception;

	public abstract List<BIrd> searchByName(String birdName) throws Exception;

	public abstract BIrd validateBirdName(String birdName)throws Exception;
}
