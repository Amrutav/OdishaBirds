package bird.service;

import bird.dao.CategoryDao;
import bird.entity.Category;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

// Referenced classes of package bird.service:
//            CategoryService

public class CategoryServiceImpl implements CategoryService{

    @Autowired
	CategoryDao categoryDao;

    @Override
    public boolean addCategory(Category category)throws Exception{
        return categoryDao.addCategory(category);
    }

    @Override
    public List<Category> getCategoryList()throws Exception{
        return categoryDao.getCategoryList();
    }

	@Override
	public Category validateCategory(String catName) throws Exception {
		// TODO Auto-generated method stub
		return categoryDao.validatecategory(catName);
	}

	@Override
	public boolean deleteCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		return categoryDao.deleteCategory(category);
	}

	@Override
	public List<Category> getCategoryListById(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryListById(categoryId);
	}

}
