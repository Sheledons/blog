package dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.Article;
import utils.C3p0Utils;
public class ArticleDao implements ArticleDaoInter{
	private JdbcTemplate temp=new JdbcTemplate(C3p0Utils.getDataSource());
	@Override
	public int getNumber(int uid) {
		int number=0;
		
		String sql="select count(aid) from article where uid=?";
		try{
			number=this.temp.queryForObject(sql,Integer.class,uid);
		}
		catch(DataAccessException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			
		}
		System.out.println("anumber  "+number);
		return number;
	}

	@Override
	public List<Article> getArticleByTimes(int uid) {

		String sql="select aname,viewTimes from article where uid=? order by viewTimes DESC";
		List<Article> art=null;
		try{
			art=this.temp.query(sql,new BeanPropertyRowMapper<Article>(Article.class),uid);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return art;
	}

	@Override
	public List<Article> getArticleByCreate(int uid) {
//		String sql="select * from article where uid=? order by aid DESC"; //°´aid ½µÐò
		String sql="select article.aid,article.time,article.content,article.viewTimes,article.aname,classify.cname from article inner join classify on article.cid=classify.cid where article.uid=? order by article.aid DESC";
		List<Article> art=null;
		try{
			art=this.temp.query(sql,new BeanPropertyRowMapper<Article>(Article.class),uid);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return art;
	}

	@Override
	public Article getArticleNewOne(int cid) {
		// TODO Auto-generated method stub
		String sql="select aname,time,viewTimes from article where cid=? order by aid DESC limit 1";
		Article art=null;
		try{
			art=this.temp.queryForObject(sql,new BeanPropertyRowMapper<Article>(Article.class),cid);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return art;
	}

	@Override
	public int createArticle(Article art) {
		// TODO Auto-generated method stub
		int aid=art.getAid();
		String sql;
		sql="insert into article(uid,time,cid,content,viewTimes,aname) values(?,?,?,?,0,?)";
		int flag=0;
		try{
//			System.out.println("aname{  "+art.getAname());
			flag=this.temp.update(sql,art.getUid(),art.getTime(),art.getCid(),art.getContent(),art.getAname());
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Article> getArticleById(int uid) {
		// TODO Auto-generated method stub
		String sql="select aname,time,viewTimes,aid from article where uid=? order by aid DESC";
		List<Article> list=null;
		try{
			list=this.temp.query(sql,new BeanPropertyRowMapper<Article>(Article.class),uid);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteArticle(int aid) {
		// TODO Auto-generated method stub
		String sql="delete from Article where aid=?";
		int num=0;
		try{
			num=this.temp.update(sql,aid);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public Article getArticleByAid(int aid) {
		// TODO Auto-generated method stub
		String sql="select * from article where aid=?";
		Article art=null;
		try{
			art=this.temp.queryForObject(sql, new BeanPropertyRowMapper<Article>(Article.class),aid);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return art;
	}

	@Override
	public int getNewAid(int uid) {
		// TODO Auto-generated method stub
		String sql="select aid from article where uid=? order by aid DESC limit 1";
		int aid=0;
		try{
			aid=this.temp.queryForObject(sql,Integer.class,uid);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return aid;
	}
	
}
