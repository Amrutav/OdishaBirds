package bird.dao;

import bird.entity.Bird;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;

public class BirdDaoImpl implements BirdDao{

    @Autowired
	private SessionFactory sessionfactory;
    Session session;
    Transaction transaction;

    @Override
    public boolean addBird(Bird bird)throws Exception{
        boolean b = false;
        try
        {
            session = sessionfactory.openSession();
            transaction = session.beginTransaction();
            session.save(bird);
            transaction.commit();
            session.close();
            b = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public List<Bird> getBirdListByCategoryId(int categoryId)throws Exception{
        List<Bird> getBirdListbyCategoryId = new ArrayList<Bird>();
        try
        {
            session = sessionfactory.openSession();
            transaction = session.beginTransaction();
            String sql = "SELECT BirdId,BirdName,BirdSound,BirdColor,BirdDetails,BirdFood,BirdPopulation,BirdAltName,BirdSciName,BirdResident,BirdVisibility,BirdMigrtStatus,BirdNestPeriod,CategoryId FROM tbl_bird WHERE CategoryId= "+categoryId;
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Bird.class);
            getBirdListbyCategoryId = query.list();
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
        }
        return getBirdListbyCategoryId;
    }
}
