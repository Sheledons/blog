package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import utils.C3p0Utils;

import domain.Article;

public class DelArticleDao implements DelArticleDaoInter {
	JdbcTemplate temp=new JdbcTemplate(C3p0Utils.getDataSource());
	@Override
	public int addRow(Article art) {
		// TODO Auto-generated method stub
		String sql="insert into delArticle(uid,time,cid,content,viewTimes,aname) values(?,?,?,?,?,?)";
		int num=0;
		try{
			num=this.temp.update(sql,art.getUid(),art.getTime(),art.getCid(),art.getContent(),art.getViewTimes(),art.getAname());
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return num;
	}
	@Override
	public List<Article> getDelArticle(int uid) {
		// TODO Auto-generated method stub
		String sql="select aid,aname,time from delArticle where uid=?";
		List<Article> list=null;
		try{
			list=this.temp.query(sql,new BeanPropertyRowMapper<Article>(Article.class),uid);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int deleteRow(int aid) {
		// TODO Auto-generated method stub
		String sql="delete from delArticle where aid=?";
		int num;
		try{
			num=this.temp.update(sql,aid);
		}catch(DataAccessException e){
			e.printStackTrace();
			num=0;
		}
		return num;
	}
	@Override
	public Article getDelArticleOne(int aid) {
		// TODO Auto-generated method stub
		String sql="select * from delArticle where aid=?";
		Article art=null;
		try{
			art=this.temp.queryForObject(sql, new BeanPropertyRowMapper<Article>(Article.class),aid);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return art;
	}
	@Override
	public void deleteAllRow(int uid) {
		// TODO Auto-generated method stub
		String sql="delete from delarticle where uid=?";
		try{
			this.temp.update(sql,uid);
		}catch(DataAccessException d){
			
		}
	}
	@Override
	public int getNewAid(int uid) {
		// TODO Auto-generated method stub
		String sql="select aid from delArticle where uid=? order by aid DESC limit 1";
		int aid=this.temp.queryForObject(sql,Integer.class,uid);
		return aid;
	}
	
}
