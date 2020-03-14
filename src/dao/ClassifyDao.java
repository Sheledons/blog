package dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import utils.ConnectionUtils;
import utils.DButils;

import domain.Classify;

public class ClassifyDao implements ClassifyDaoInter {
	private QueryRunner runner=DButils.getRunner();
	@Override
	public Long getClassifyNumber(int uid) {
		// TODO Auto-generated method stub
		String sql="select count(*) from classify where uid=?";
		Long num=0l;
		try{
			num=runner.query(ConnectionUtils.getConnection(),sql, new ScalarHandler<Long>(),uid);
		}catch(Exception e){
			throw new RuntimeException("sql÷¥––¥ÌŒÛ");
		}
		return num;
	}

	@Override
	public List<Classify> getClassify(int uid) {
		// TODO Auto-generated method stub
		String sql="select * from classify where uid=?";
		List<Classify> list=null;
		try{
			list=runner.query(ConnectionUtils.getConnection(),sql, new BeanListHandler<Classify>(Classify.class),uid);
		}catch(Exception e){
			throw new RuntimeException("sql÷¥––¥ÌŒÛ");
		}
		return list;
	}

	@Override
	public List<Classify> getClassifyLimit(int uid,int locpage) {
		String sql="select * from classify where uid=? limit ?,4";
		int param=4*locpage-4;
		List<Classify> list=null;
		try{
			list=runner.query(ConnectionUtils.getConnection(),sql,new BeanListHandler<Classify>(Classify.class),uid,param);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("sql÷¥––¥ÌŒÛ");
		}
		return list;
	}
	@Override
	public int createClassify(String cname,int uid) {
		String sql="insert into classify(cname,cnumber,uid) values(?,0,?)";
		int flag=0;
		try{
			flag=runner.update(ConnectionUtils.getConnection(),sql, cname,uid);
		}catch(Exception e){
			throw new RuntimeException("sql÷¥––¥ÌŒÛ");
		}
		return flag;
	}

	@Override
	public Classify getClassifyByCname(String cname) {
		String sql="select * from classify where cname=?";
		List<Classify> c=null;
		try{
			c=runner.query(ConnectionUtils.getConnection(),sql, new BeanListHandler<Classify>(Classify.class),cname);
		}catch(Exception e){
			throw new RuntimeException("sql÷¥––¥ÌŒÛ");
		}
		return c.get(0);
	}

	@Override
	public int delClassify(int cid) {
		// TODO Auto-generated method stub
		String sql="delete from classify where cid=?";
		int num=0;
		try{
			num=runner.update(ConnectionUtils.getConnection(),sql,cid);
		}catch(Exception e){
			throw new RuntimeException("sql÷¥––¥ÌŒÛ");
		}
		return num;
	}

	@Override
	public int addCnumber(int cnumber,int cid) {
		// TODO Auto-generated method stub
		String sql="update classify set cnumber = ? where cid=?";
		int num=0;
		try{
			num=runner.update(ConnectionUtils.getConnection(),sql,cnumber,cid);
		}catch(Exception e){
			System.out.println("addCnumber");
			throw new RuntimeException("sql÷¥––¥ÌŒÛ");
		}
		System.out.println("add  "+num);
		return num;
	}

	@Override
	public int getClassifyCnumber(int cid) {
		// TODO Auto-generated method stub
		int num=0;
		String sql="select cnumber from classify where cid=?";
		try{
			num=runner.query(ConnectionUtils.getConnection(),sql,new ScalarHandler<Integer>(),cid);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("getClassifyCnumber");
			throw new RuntimeException("sql÷¥––¥ÌŒÛ");
		}
		System.out.println("num");
		return num;
	}
	
}
