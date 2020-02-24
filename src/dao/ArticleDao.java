package dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.Article;
import utils.C3p0Utils;
public class ArticleDao implements ArticleDaoInter{

	@Override
	public int getNumber(int uid) {
		Integer number=null;
		JdbcTemplate temp=new JdbcTemplate(C3p0Utils.getDataSource());
		String sql="select count(aid) from article where uid=?";
		try{
			number=temp.queryForObject(sql,new BeanPropertyRowMapper<Integer>(Integer.class),uid);
		}
		catch(DataAccessException e){
			e.printStackTrace();
		}
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
