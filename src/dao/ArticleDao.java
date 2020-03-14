package dao;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.Article;
import utils.ConnectionUtils;
import utils.DButils;
public class ArticleDao implements ArticleDaoInter{
	private QueryRunner runner=DButils.getRunner();
//    public static void main(String args[]){
//		Long number=0l;
//		QueryRunner runner=DButils.getRunner();
//		String sql="select count(aid) from article where uid=?";
//		try{
//			number=(Long)runner.query(ConnectionUtils.getConnection(),sql,new ScalarHandler<Long>(),1);
//		}catch(Exception e){
//			e.printStackTrace();
//			throw new RuntimeException("sql÷¥–– ß∞‹");
//		}
//		System.out.println(number);
//    }
	public Long getNumber(int uid){
		Long number=0l;
		String sql="select count(aid) from article where uid=?";
		try{
			number=runner.query(ConnectionUtils.getConnection(),sql,new ScalarHandler<Long>(),uid);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("sql÷¥–– ß∞‹");
		}
//		System.out.println("number  "+number);
		return number;
	}

	@Override
	public List<Article> getArticleByTimes(int uid) {

		String sql="select aname,viewTimes from article where uid=? order by viewTimes DESC";
		List<Article> art=null;
		try{
			art=runner.query(ConnectionUtils.getConnection(),sql, new BeanListHandler<Article>(Article.class),uid);
		}catch(Exception e){
			throw new RuntimeException("sql÷¥–– ß∞‹");
		}
		return art;
	}

	@Override
	public List<Article> getArticleByCreate(int uid,int locpage) {
//		String sql="select * from article where uid=? order by aid DESC"; //∞¥aid Ωµ–Ú
		String sql="select article.aid,article.time,article.viewTimes,article.aname,classify.cname from article inner join classify on article.cid=classify.cid where article.uid=? order by article.aid DESC limit ?,4";
		int param=4*locpage-4;
		List<Article> art=null;
		try{
			art=runner.query(ConnectionUtils.getConnection(),sql,new BeanListHandler<Article>(Article.class),uid,param);
		}catch(Exception e){
			throw new RuntimeException("sql÷¥–– ß∞‹");
		}
		return art;
	}

	@Override
	public Article getArticleNewOne(int cid) {
		// TODO Auto-generated method stub
		String sql="select aname,time,viewTimes from article where cid=? order by aid DESC limit 1";
		List<Article> art=null;
		try{
			art=runner.query(ConnectionUtils.getConnection(),sql,new BeanListHandler<Article>(Article.class),cid);
		}catch(Exception e){
			throw new RuntimeException("sql÷¥–– ß∞‹");
			
		}
		return art.get(0);
	}

	@Override
	public Long createArticle(Article art) {
		// TODO Auto-generated method stub
		Long aid=art.getAid();
		String sql;
		sql="insert into article(uid,time,cid,content,viewTimes,aname) values(?,?,?,?,0,?)";
		Object [] params={art.getAid(),art.getTime(),art.getCid(),art.getContent(),art.getViewTimes(),art.getAname()};
		Long flag;
		try{
			flag=runner.query(ConnectionUtils.getConnection(),sql,new ScalarHandler<Long>(),params);
		}catch(Exception e){
			throw new RuntimeException("sql÷¥–– ß∞‹");
		}
		return flag;
	}

	@Override
	public List<Article> getArticleById(int uid) {
		// TODO Auto-generated method stub
		String sql="select aname,time,viewTimes,aid from article where uid=? order by aid DESC";
		List<Article> list=null;
		try{
			list=runner.query(ConnectionUtils.getConnection(),sql, new BeanListHandler<Article>(Article.class),uid);
		}catch(Exception e){
			throw new RuntimeException("sql÷¥––¥ÌŒÛ");
		}
		return list;
	}

	@Override
	public int deleteArticle(int aid) {
		// TODO Auto-generated method stub
		String sql="delete from Article where aid=?";
		int num=0;
		try{
			num=runner.update(ConnectionUtils.getConnection(),sql, aid);
		}catch(Exception e){
			throw new RuntimeException("sql÷¥––¥ÌŒÛ");
		}
		return num;
	}

	@Override
	public Article getArticleByAid(int aid) {
		// TODO Auto-generated method stub
		String sql="select article.* ,classify.cname from article inner join classify where article.cid=classify.cid and article.aid=?";
		List<Article> art=null;
		try{
			art=runner.query(ConnectionUtils.getConnection(),sql,new BeanListHandler<Article>(Article.class),aid);
		}catch(Exception e){
			throw new RuntimeException("sql÷¥–– ß∞‹");
		}
		return art.get(0);
	}

	@Override
	public Long getNewAid(int uid) {
		// TODO Auto-generated method stub
		String sql="select aid from article where uid=? order by aid DESC limit 1";
		Long aid=0l;
		try{
			aid=runner.query(ConnectionUtils.getConnection(),sql,new ScalarHandler<Long>(),uid);
		}catch(Exception e){
			throw new RuntimeException("sql÷¥––¥ÌŒÛ");
		}
		return aid;
	}

	@Override
	public void addViewTimes(int aid,int orignalViewTimes) {
		// TODO Auto-generated method stub
		String sql="update article set viewTimes=? where aid=?";
		try{
			runner.execute(ConnectionUtils.getConnection(),sql,aid,orignalViewTimes);
		}catch(Exception e){
			throw new RuntimeException("sql÷¥––¥ÌŒÛ");
		}
		
	}

	@Override
	public Long getAppointArticleNumber(int cid) {
		// TODO Auto-generated method stub
		String sql="select count(*) from article where cid=?";
		Long num=0l;
		try{
			num=runner.query(ConnectionUtils.getConnection(),sql, new ScalarHandler<Long>(),cid);
		}catch(Exception e){
			System.out.println("∏√∑÷¿‡œ¬µƒŒƒ’¬ ˝¡øŒ™¡„");
			throw new RuntimeException("sql÷¥––¥ÌŒÛ");
		}
		return num;
	}

	@Override
	public List<Article> getArticleByCid(int cid,int locpage) {
		// TODO Auto-generated method stub
		String sql="select article.aname,article.aid,classify.cid,article.viewTimes,article.time,classify.cname from article inner join classify on article.cid=classify.cid where article.cid=? order by article.aid DESC limit ?,4";
		int param=4*locpage-4;
		List<Article> list=null;
		try{
			list=runner.query(ConnectionUtils.getConnection(),sql, new BeanListHandler<Article>(Article.class),cid,locpage);
		}catch(Exception e){
			throw new RuntimeException("sql÷¥––¥ÌŒÛ");
		}
		return list;
	}
	
}
