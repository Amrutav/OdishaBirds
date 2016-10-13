package bird.service;

import bird.entity.Category;
import java.util.List;

public interface CategoryService
{

    public boolean addCategory(Category category)throws Exception;

    public List<Category> getCategoryList()throws Exception;
}
