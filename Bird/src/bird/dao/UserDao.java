package bird.dao;

import bird.entity.User;

public interface UserDao {

	public User getAuthenticUser(User user)throws Exception;

	public boolean userLogout(User user)throws Exception;

}
