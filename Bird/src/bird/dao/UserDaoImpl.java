package bird.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import bird.entity.User;

public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory sessionFactory;
	Session session;
	Transaction transaction;
	
	@Override
	public User getAuthenticUser(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(user.getClass());
			criteria.add(Restrictions.eq("userName", user.getUserName()));
			criteria.add(Restrictions.eq("password", user.getPassword()));
			user=(User) criteria.uniqueResult();
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean userLogout(User user) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			User existingUser = (User)session.get(user.getClass(), user.getLoginId());
			session.update(existingUser);
			transaction.commit();
			b = true;
		}  catch (Exception ex) {
			transaction.rollback();
		}finally{
			try {
				session.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return b;
	}

}
