package bird.dao;

import bird.entity.Category;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;


public class CategoryDaoImpl implements CategoryDao{

	@Autowired
    SessionFactory sessionfactory;
    Session session;
    Transaction transaction;

    @Override
    public boolean addCategory(Category category)throws Exception{
        boolean b = false;
        try
        {
            session = sessionfactory.openSession();
            transaction = session.beginTransaction();
            session.save(category);
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
}
