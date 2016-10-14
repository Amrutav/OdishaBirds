package bird.service;

import bird.entity.Bird;
import bird.entity.BirdBean;

import java.util.List;

public interface BirdService{

    public abstract boolean addBird(Bird bird)throws Exception;

    public abstract List<BirdBean> getBirdListByCategoryId(int categoryId)throws Exception;
}
