package bird.dao;

import bird.entity.Image;
import bird.entity.ImageBean;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;

public class ImageDaoImpl implements ImageDao{

    @Autowired
	SessionFactory sessionfactory;
    Session session;
    Transaction transaction;

    @Override
    public boolean addBirdImage(Image imageObj)throws Exception{
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
    public List<ImageBean> birdImageListByBirdId(int birdId)throws Exception{
        List<ImageBean> getBirdImageListbyBirdId = new ArrayList<ImageBean>();
        List temp=null;
        try
        {
            session = sessionfactory.openSession();
            transaction = session.beginTransaction();
            String sql = "SELECT ImageName,ImagePath FROM tbl_image WHERE BirdId = "+birdId;
            Query query = session.createSQLQuery(sql);
            temp=query.list();
            if(temp != null && temp.size()!=0){
            	for(Object obj:temp){
            		Object[] img = (Object[]) obj;
            		ImageBean bean=new ImageBean();
            		bean.setImageName((String) img[0]);
            		bean.setImagePath((String) img[1]);
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
}
