package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import utils.C3p0Utils;

import domain.Classify;

public class ClassifyDao implements ClassifyDaoInter {
	private JdbcTemplate temp=new JdbcTemplate(C3p0Utils.getDataSource());
	@Override
	public int getClassifyNumber(int uid) {
		// TODO Auto-generated method stub
		String sql="select count(*) from classify where uid=?";
		Integer num;
		try{
			num=temp.queryForObject(sql,Integer.class,uid);
		}catch(DataAccessException e){
			num=0;
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<Classify> getClassify(int uid) {
		// TODO Auto-generated method stub
		String sql="select * from classify where uid=?";
		List<Classify> list=null;
		try{
			list=temp.query(sql,new BeanPropertyRowMapper<Classify>(Classify.class),uid);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return list;
	}

}
