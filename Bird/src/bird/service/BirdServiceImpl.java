package bird.service;

import bird.dao.BirdDao;

import bird.entity.BirdDetail;
import bird.entity.Category;
import bird.entity.BIrd;
import bird.entity.BIrdBeans;
import bird.entity.BirdBean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BirdServiceImpl implements BirdService{

    @Autowired
	BirdDao birdDao;

    @Override
    public boolean addBird(BirdDetail bird)throws Exception{
        return birdDao.addBird(bird);
    }

    @Override
    public List<BirdBean> getBirdListByCategoryId(int birdId)throws Exception{
        return birdDao.getBirdListByCategoryId(birdId);
    }

	@Override
	public boolean addNewBird(BIrd imageObj) throws Exception {
		// TODO Auto-generated method stub
		return birdDao.addNewBird(imageObj);
	}

	@Override
	public List<BIrdBeans> birdListByCatId(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		return birdDao.birdListByCatId(categoryId);
	}

	@Override
	public List<BIrd> searchByName(String birdName) throws Exception {
		// TODO Auto-generated method stub
		return birdDao.searchByName(birdName);
	}

	@Override
	public BIrd validateBirdName(String birdName) throws Exception {
		// TODO Auto-generated method stub
		return birdDao.validateBirdName(birdName);
	}

	@Override
	public BirdDetail validateBirdDetails(String bdId) throws Exception {
		// TODO Auto-generated method stub
		return birdDao.validateBirdDetails(bdId);
	}

	@Override
	public boolean deleteBird(BIrd bird) throws Exception {
		// TODO Auto-generated method stub
		return birdDao.deleteBird(bird);
	}

	@Override
	public List<BIrdBeans> birdList() throws Exception {
		// TODO Auto-generated method stub
		return birdDao.birdList();
	}

	@Override
	public List<BIrd> birdListByBirdId(int birdId) throws Exception {
		// TODO Auto-generated method stub
		return birdDao.birdListByBirdId(birdId);
	}

	@Override
	public boolean updateBird(BIrd bird) throws Exception {
		// TODO Auto-generated method stub
		return birdDao.updateBird(bird);
	}

	@Override
	public List<BirdDetail> birdDetListByBirdDetId(int birdDetailId) throws Exception {
		// TODO Auto-generated method stub
		return birdDao.birdDetListByBirdDetId(birdDetailId);
	}

	@Override
	public boolean deleteBirdDetails(BirdDetail bird) throws Exception {
		// TODO Auto-generated method stub
		return birdDao.deleteBirdDetails(bird);
	}

	@Override
	public boolean updateBirdDetails(BirdDetail bird) throws Exception {
		// TODO Auto-generated method stub
		return birdDao.updateBirdDetails(bird);
	}
}
