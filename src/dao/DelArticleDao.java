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
		String sql="select aname,time from delArticle where uid=?";
		List<Article> list=null;
		try{
			list=this.temp.query(sql,new BeanPropertyRowMapper<Article>(Article.class),uid);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return list;
	}
	
}
