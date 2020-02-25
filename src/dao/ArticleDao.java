package dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.Article;
import utils.C3p0Utils;
public class ArticleDao implements ArticleDaoInter{

	@Override
	public int getNumber(int uid) {
		int number=0;
		JdbcTemplate temp=new JdbcTemplate(C3p0Utils.getDataSource());
		String sql="select count(aid) from article where uid=?";
		try{
			number=temp.queryForObject(sql,Integer.class,uid);
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
		JdbcTemplate temp=new JdbcTemplate(C3p0Utils.getDataSource());
		String sql="select * from article where uid=? order by viewTimes DESC";
		List<Article> art=null;
		try{
			art=temp.query(sql,new BeanPropertyRowMapper<Article>(Article.class),uid);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return art;
	}

}
