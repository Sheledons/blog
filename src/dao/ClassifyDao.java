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

	@Override
	public List<Classify> getClassifyLimit(int uid,int locpage) {
		String sql="select * from classify where uid=? limit ?,4";
		int param=4*locpage-4;
		List<Classify> list=null;
		try{
			list=temp.query(sql,new BeanPropertyRowMapper<Classify>(Classify.class),uid,param);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int createClassify(String cname,int uid) {
		String sql="insert into classify(cname,cnumber,uid) values(?,0,?)";
		int flag=0;
		try{
			flag=this.temp.update(sql,cname,uid);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Classify getClassifyByCname(String cname) {
		String sql="select * from classify where cname=?";
		Classify c=null;
		try{
			c=this.temp.queryForObject(sql, new BeanPropertyRowMapper<Classify>(Classify.class),cname);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public int delClassify(int cid) {
		// TODO Auto-generated method stub
		String sql="delete from classify where cid=?";
		int num=0;
		try{
			num=this.temp.update(sql,cid);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return num;
		return false;
	}

}
