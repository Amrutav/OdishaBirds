package bird.dao;

import bird.entity.Image;
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
    public List<Image> birdImageListByBirdId(int birdId)throws Exception{
        List<Image> getBirdImageListbyBirdId = new ArrayList<Image>();
        try
        {
            session = sessionfactory.openSession();
            transaction = session.beginTransaction();
            String sql = "SELECT ImageName,ImagePath,BirdId FROM tbl_image WHERE BirdId = "+birdId;
            SQLQuery query = session.createSQLQuery(sql);
            System.out.println(query);
            query.addEntity(Image.class);
            getBirdImageListbyBirdId = query.list();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return getBirdImageListbyBirdId;
    }
}
