package dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import utils.C3p0Utils;

import domain.Article;

public class DelArticleDao implements DelArticleDaoInter {
	JdbcTemplate temp=new JdbcTemplate(C3p0Utils.getDataSource());
	@Override
	public int addColumn(Article art) {
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
	
}
