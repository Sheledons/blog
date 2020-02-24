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
			//BeanPropertyRowMapper ��һ��ʵ�ֵ��˷�װjavaBean�Ľӿ�,����ֻ��Ҫ����Ҫ��װ��javaBean,���ֽ����ļ������ͣ�User.class��
			System.out.println("url  "+ru.getImageUrl());
			System.out.println("uid  "+ru.getUid());
		}
		catch(DataAccessException e){
			System.out.println("DataAcess");
		}
		return ru;
	}

}
