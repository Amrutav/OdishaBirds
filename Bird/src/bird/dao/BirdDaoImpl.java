package bird.dao;

import bird.entity.Bird;
import bird.entity.BirdBean;

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
    public List<BirdBean> getBirdListByCategoryId(int categoryId)throws Exception{
        List<BirdBean> getBirdListbyCategoryId = new ArrayList<BirdBean>();
        List temp=null;
        try
        {
            session = sessionfactory.openSession();
            transaction = session.beginTransaction();
            String sql = "SELECT BirdName,BirdSound,BirdColor,BirdDetails,BirdFood,BirdPopulation,BirdAltName,BirdSciName,BirdResident,BirdVisibility,BirdMigrtStatus,BirdNestPeriod FROM tbl_bird WHERE CategoryId= "+categoryId;
            Query query = session.createSQLQuery(sql);
            temp=query.list();
            if(temp != null && temp.size()!=0){
            	for(Object obj:temp){
            		Object[] bird=(Object[]) obj;
            		BirdBean bean=new BirdBean();
            		bean.setBirdName((String) bird[0]);
            		bean.setBirdSound((String) bird[1]);
            		bean.setBirdColor((String) bird[2]);
            		bean.setBirdDetails((String) bird[3]);
            		bean.setBirdFood((String) bird[4]);
            		bean.setBirdPopulation((String) bird[5]);
            		bean.setBirdAltName((String) bird[6]);
            		bean.setBirdSciName((String) bird[7]);
            		bean.setBirdRsident((String) bird[8]);
            		bean.setBirdVisibility((String) bird[9]);
            		bean.setBirdMigrtStatus((String) bird[10]);
            		bean.setBirdNestPeriod((String) bird[11]);
            		getBirdListbyCategoryId.add(bean);
            	}
            }
            
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
        }finally{
        	if(session!=null){
        		session.close();
        	}
        }
        return getBirdListbyCategoryId;
    }
}
