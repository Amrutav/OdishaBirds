package bird.dao;

import bird.entity.BirdDetail;




import bird.service.BirdServiceImpl;
import bird.entity.BIrd;
import bird.entity.BIrdBeans;
import bird.entity.BirdBean;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class BirdDaoImpl implements BirdDao{

    @Autowired
	private SessionFactory sessionfactory;
    Session session;
    Transaction transaction;
    static final Logger logger = Logger.getLogger(BirdServiceImpl.class);
    
    @Override
    public boolean addBird(BirdDetail bird)throws Exception{
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
    public List<BirdBean> getBirdListByCategoryId(int birdId)throws Exception{
        List<BirdBean> getBirdListbyCategoryId = new ArrayList<BirdBean>();
        List temp=null;
        try
        {
            session = sessionfactory.openSession();
            transaction = session.beginTransaction();
            String sql = "SELECT BdId,BirdSound,BirdColor,BirdDetails,BirdFood,BirdPopulation,BirdAltName,BirdSciName,BirdResident,BirdVisibility,BirdMigrtStatus,BirdNestPeriod FROM tbl_bird_detail WHERE BdId= "+birdId;
            Query query = session.createSQLQuery(sql);
            temp=query.list();
            if(temp != null && temp.size()!=0){
            	for(Object obj:temp){
            		Object[] bird=(Object[]) obj;
            		BirdBean bean=new BirdBean();
            		bean.setBirdId((int) bird[0]);
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

	@Override
	public boolean addNewBird(BIrd imageObj) throws Exception {
		// TODO Auto-generated method stub
		        boolean b = false;
		        try
		        {
		            session = sessionfactory.openSession();
		            transaction = session.beginTransaction();
		            session.save(imageObj);
		            transaction.commit();
		            session.close();
		            b = true;
		        }catch(Exception e){
		            e.printStackTrace();
		        }
		        return b;
	}

	@Override
	public List<BIrdBeans> birdListByCatId(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		List<BIrdBeans> getBirdImageListbyBirdId = new ArrayList<BIrdBeans>();
        List temp=null;
        try
        {
            session = sessionfactory.openSession();
            transaction = session.beginTransaction();
            String sql = "SELECT BirdName,BirdImage,CatId,BirdId FROM tbl_bird WHERE CatId = "+categoryId;
            Query query = session.createSQLQuery(sql);
            temp=query.list();
            if(temp != null && temp.size()!=0){
            	for(Object obj:temp){
            		Object[] img = (Object[]) obj;
            		BIrdBeans bean=new BIrdBeans();
            		bean.setBirdName((String) img[0]);
            		bean.setBrdImage((String) img[1]);
            		bean.setCatId((int) img[2]);
            		bean.setBirdId((int) img[3]);
            		getBirdImageListbyBirdId.add(bean);
            	}
            }
        }
        catch(HibernateException e){
            e.printStackTrace();
        }finally{
        	if(session!=null){
        		session.close();
        	}
        }
        return getBirdImageListbyBirdId;
	}

	@Override
	public List<BIrd> searchByName(String birdName) throws Exception {
		// TODO Auto-generated method stub
		List<BIrd> list=new ArrayList<BIrd>();
		try{
		session=sessionfactory.openSession();
		transaction = session.beginTransaction();
		String sql="SELECT * FROM tbl_bird WHERE BirdName LIKE '%"+birdName+"%'";
		SQLQuery query=session.createSQLQuery(sql);
		query.addEntity(BIrd.class);
		list=query.list();
		System.out.println(list.size());
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public BIrd validateBirdName(String birdName) throws Exception, HibernateException {
		// TODO Auto-generated method stub
		BIrd bird=new BIrd();
		try {
			session = sessionfactory.openSession();
			Criteria criteria = session.createCriteria(bird.getClass());
			criteria.add(Restrictions.eq("birdName", birdName));
			bird = (BIrd) criteria.uniqueResult();
			return bird;
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
		return bird;
		
	}

	@Override
	public BirdDetail validateBirdDetails(String bdId) throws Exception {
		// TODO Auto-generated method stub
		BirdDetail birddet=new BirdDetail();
		try {
			session=sessionfactory.openSession();
			transaction = session.beginTransaction();
			String sql="select * from tbl_bird bd, tbl_bird_detail bds where bd.BirdId = bds.BdId and bd.BirdId = "+bdId;
			SQLQuery query=session.createSQLQuery(sql);
			query.addEntity(BirdDetail.class);
			List<BirdDetail> list = query.list();
			birddet=list.get(0);
			return birddet;
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
		return birddet;
	}

	@Override
	public boolean deleteBird(BIrd bird) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.delete(bird);
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
	public List<BIrdBeans> birdList() throws Exception {
		// TODO Auto-generated method stub
		List<BIrdBeans> birdList= new ArrayList<BIrdBeans>();
		try{
			session = sessionfactory.openSession();
			Criteria criteria = session.createCriteria(BIrd.class);
			birdList = criteria.addOrder(Order.asc("category")).list();
			System.out.println(birdList);
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	return birdList;
	}

	@Override
	public List<BIrd> birdListByBirdId(int birdId) throws Exception {
		// TODO Auto-generated method stub
		List<BIrd> getBird = new ArrayList<BIrd>();
		try {
			System.out.println("inside");
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM tbl_bird WHERE birdId = "+birdId;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(BIrd.class);
			getBird = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getBird;
	}

	@Override
	public boolean updateBird(BIrd bird) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
        try
        {
            session = sessionfactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(bird);
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
	public List<BirdDetail> birdDetListByBirdDetId(int bdId) throws Exception {
		// TODO Auto-generated method stub
		List<BirdDetail> getBird = new ArrayList<BirdDetail>();
		try {
			System.out.println("inside");
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM tbl_bird_detail WHERE BdId = "+bdId;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(BirdDetail.class);
			getBird = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getBird;
	}

	@Override
	public boolean deleteBirdDetails(BirdDetail bird) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.delete(bird);
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
	public boolean updateBirdDetails(BirdDetail bird) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
        try
        {
            session = sessionfactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(bird);
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
}
