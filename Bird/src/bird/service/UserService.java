package bird.service;

import bird.entity.User;

public interface UserService {

	public User getAuthenticateUser(User user)throws Exception;

	public boolean userLogout(User user)throws Exception;

}
