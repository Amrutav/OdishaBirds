package bird.dao;

import bird.entity.Category;
import java.util.List;

public interface CategoryDao
{

    public boolean addCategory(Category category)throws Exception;

    public List<Category> getCategoryList()throws Exception;
}
