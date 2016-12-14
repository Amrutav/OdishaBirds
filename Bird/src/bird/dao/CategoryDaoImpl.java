package bird.dao;

import bird.entity.Category;
import bird.service.CategoryServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;


public class CategoryDaoImpl implements CategoryDao{

	@Autowired
    SessionFactory sessionfactory;
    Session session;
    Transaction transaction;
    static final Logger logger = Logger.getLogger(CategoryServiceImpl.class);
    @Override
    public boolean addCategory(Category category)throws Exception{
        boolean b = false;
        try
        {
            session = sessionfactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(category);
            transaction.commit();
            session.close();
            b = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public List<Category> getCategoryList()throws Exception{
        List<Category> categoryList = new ArrayList<Category>();
        try
        {
            session = sessionfactory.openSession();
            Criteria criteria = session.createCriteria(Category.class);
            categoryList = criteria.list();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return categoryList;
    }

	@Override
	public Category validatecategory(String catName) throws Exception, HibernateException {
		// TODO Auto-generated method stub
		Category category=new Category();
		try {
			session = sessionfactory.openSession();
			Criteria criteria = session.createCriteria(category.getClass());
			criteria.add(Restrictions.eq("categoryName", catName));
			category = (Category) criteria.uniqueResult();
			return category;
		} catch (HibernateException e) {
			logger.error("Exception occurs in ", e);
		}catch(Exception ex){
			logger.error("Exception occurs in ", ex);
		}finally{
			try {
				session.close();
			} catch (HibernateException e) {
				logger.error("Exception occurs in ", e);
			}
		}
		return category;
	}

	@Override
	public boolean deleteCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.delete(category);
			transaction.commit();
			session.close();
			b = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Category> getCategoryListById(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		List<Category> getBoardListbyuserId = new ArrayList<Category>();
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM tbl_category WHERE categoryId = "+categoryId;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Category.class);
			getBoardListbyuserId = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getBoardListbyuserId;
	}

	
}
