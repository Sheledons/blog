package dao;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import utils.C3p0Utils;
import utils.ConnectionUtils;
import utils.DButils;
import domain.User;
public class UserDao implements UserDaoInter {

	public User verUser(User u) {
	    QueryRunner runner=DButils.getRunner();
		List<User> ru=null;
		String sql="select * from user where name=? and pwd=?";
		try{
			ru=runner.query(ConnectionUtils.getConnection(),sql,new BeanListHandler<User>(User.class),u.getName(),u.getPwd());
			//BeanPropertyRowMapper ��һ��ʵ�ֵ��˷�װjavaBean�Ľӿ�,����ֻ��Ҫ����Ҫ��װ��javaBean,���ֽ����ļ���������ͣ�User.class��
		}
		catch(Exception e){
			throw new RuntimeException(" verUserִ��ʧ��");
		}
		return ru.get(0);
	}

}
