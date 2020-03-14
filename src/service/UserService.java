package service;

import beanFactory.BeanFactory;
import domain.User;
import dao.UserDao;
public class UserService  implements UserServiceInter{

	@Override
	public User login(User u) {
		// TODO Auto-generated method stub
		UserDao dao=(UserDao)BeanFactory.getBean("userDao");
		return dao.verUser(u);
	}
	
}
