package bird.dao;

import bird.entity.Category;
import java.util.List;

public interface CategoryDao
{

    public boolean addCategory(Category category)throws Exception;

    public List<Category> getCategoryList()throws Exception;

	public Category validatecategory(String catName)throws Exception;

	public boolean deleteCategory(Category category)throws Exception;

	public List<Category> getCategoryListById(int categoryId)throws Exception;


}
