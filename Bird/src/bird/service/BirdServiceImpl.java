package bird.service;

import bird.dao.BirdDao;
import bird.entity.Bird;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BirdServiceImpl implements BirdService{

    @Autowired
	BirdDao birdDao;

    public boolean addBird(Bird bird)throws Exception{
        return birdDao.addBird(bird);
    }

    public List<Bird> getBirdListByCategoryId(int categoryId)throws Exception{
        return birdDao.getBirdListByCategoryId(categoryId);
    }
}
