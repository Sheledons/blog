package service;

import domain.User;
import dao.UserDao;
public class UserService  implements UserServiceInter{

	@Override
	public User login(User u) {
		// TODO Auto-generated method stub
		UserDao dao=new UserDao();
		return dao.verUser(u);
	}
	
}
