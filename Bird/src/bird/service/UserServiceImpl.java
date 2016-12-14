package bird.service;

import org.springframework.beans.factory.annotation.Autowired;

import bird.dao.UserDao;
import bird.entity.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Override
	public User getAuthenticateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			user = userDao.getAuthenticUser(user);
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
		try {
			return userDao.userLogout(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
