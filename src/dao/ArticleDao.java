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

		String sql="select * from article where uid=? order by viewTimes DESC";
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

}
