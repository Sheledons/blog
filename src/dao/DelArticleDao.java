package dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import utils.C3p0Utils;
import utils.ConnectionUtils;
import utils.DButils;

import domain.Article;

public class DelArticleDao implements DelArticleDaoInter {
	private QueryRunner runner=DButils.getRunner();
	@Override
	public int addRow(Article art) {
		// TODO Auto-generated method stub
		String sql="insert into delArticle(uid,time,cid,content,viewTimes,aname) values(?,?,?,?,?,?)";
		Object [] params={art.getUid(),art.getTime(),art.getCid(),art.getContent(),art.getViewTimes(),art.getAname()};
		int num=0;
		try{
			num=runner.update(ConnectionUtils.getConnection(),sql,params);
		}catch(Exception e){
			throw new RuntimeException("addRow÷¥––¥ÌŒÛ");
		}
		return num;
	}
	@Override
	public List<Article> getDelArticle(int uid) {
		// TODO Auto-generated method stub
		String sql="select aid,aname,time from delArticle where uid=?";
		List<Article> list=null;
		try{
			list=runner.query(ConnectionUtils.getConnection(),sql, new BeanListHandler<Article>(Article.class),uid);
		}catch(Exception e){
			throw new RuntimeException("getDelArticle÷¥––¥ÌŒÛ");
		}
		return list;
	}
	@Override
	public int deleteRow(int aid) {
		// TODO Auto-generated method stub
		String sql="delete from delArticle where aid=?";
		int num=0;
		try{
			num=runner.update(ConnectionUtils.getConnection(),sql, aid);
		}catch(Exception e){
			throw new RuntimeException("deleteRow÷¥––¥ÌŒÛ");
		}
		return num;
	}
	@Override
	public Article getDelArticleOne(int aid) {
		// TODO Auto-generated method stub
		String sql="select * from delArticle where aid=?";
		List<Article> art=null;
		try{
			art=runner.query(ConnectionUtils.getConnection(),sql, new BeanListHandler<Article>(Article.class),aid);
		}catch(Exception e){
			throw new RuntimeException("getDelArticleOne÷¥––¥ÌŒÛ");
		}
		return art.get(0);
	}
	@Override
	public void deleteAllRow(int uid) {
		// TODO Auto-generated method stub
		String sql="delete from delarticle where uid=?";
		try{
			runner.execute(ConnectionUtils.getConnection(),sql, uid);
		}catch(Exception e){
			throw new RuntimeException("deleteAllRow÷¥––¥ÌŒÛ");
		}
	}
	@Override
	public Long getNewAid(int uid) {
		// TODO Auto-generated method stub
		String sql="select aid from delArticle where uid=? order by aid DESC limit 1";
		Long aid=0l;
		try{
			aid=runner.query(ConnectionUtils.getConnection(),sql,new ScalarHandler<Long>(),uid);
		}catch(Exception e){
			throw new RuntimeException("getNewAid÷¥––¥ÌŒÛ");
		}
		return aid;
	}
	
}
