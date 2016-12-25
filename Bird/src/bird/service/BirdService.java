package bird.service;

import bird.entity.BirdDetail;

import bird.entity.BIrd;
import bird.entity.BIrdBeans;
import bird.entity.BirdBean;

import java.util.List;

public interface BirdService{

    public abstract boolean addBird(BirdDetail bird)throws Exception;

    public abstract List<BirdBean> getBirdListByCategoryId(int birdId)throws Exception;

	public abstract boolean addNewBird(BIrd imageObj)throws Exception;

	public abstract List<BIrdBeans> birdListByCatId(int categoryId)throws Exception;

	public abstract List<BIrd> searchByName(String birdName)throws Exception;

	public abstract BIrd validateBirdName(String birdName)throws Exception;

	public abstract BirdDetail validateBirdDetails(String bdId)throws Exception;

	public abstract boolean deleteBird(BIrd bird)throws Exception;

	public abstract List<BIrdBeans> birdList()throws Exception;

	public abstract List<BIrd> birdListByBirdId(int birdId)throws Exception;

	public abstract boolean updateBird(BIrd bird)throws Exception;

	public abstract List<BirdDetail> birdDetListByBirdDetId(int birdDetailId)throws Exception;

	public abstract boolean deleteBirdDetails(BirdDetail bird)throws Exception;

	public abstract boolean updateBirdDetails(BirdDetail bird)throws Exception;
}
