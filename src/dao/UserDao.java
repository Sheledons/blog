package dao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import utils.C3p0Utils;
import domain.User;
public class UserDao implements UserDaoInter {

	public User verUser(User u) {
		JdbcTemplate template=new JdbcTemplate(C3p0Utils.getDataSource());
		User ru=null;
		String sql="select * from user where name=? and pwd=?";
		try{
			ru=template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),u.getName(),u.getPwd());
			//BeanPropertyRowMapper 是一个实现的了封装javaBean的接口,我们只需要传入要封装的javaBean,和字节码文件的类型（User.class）
		}
		catch(DataAccessException e){
			System.out.println("DataAcess");
		}
		System.out.println("UserDao");
		return ru;
	}

}
