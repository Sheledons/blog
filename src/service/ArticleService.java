package service;
import dao.DelArticleDao;

import java.util.Date;
import java.util.List;

import beanFactory.BeanFactory;
import dao.ArticleDao;
import domain.Article;
import domain.ResultInfo;
public class ArticleService implements ArticleServiceInter{
	private ArticleDao dao;
	@Override
	public void setDao(ArticleDao dao) {
		this.dao = dao;
	}
	public Long getArticleNumber(int uid) {
		
		Long number=this.dao.getNumber(uid);
		return number;
	}

	@Override
	public List<Article> getArticleByTimes(int uid) {
		
		return this.dao.getArticleByTimes(uid);
	}

	@Override
	public List<Article> getArticleByCreate(int uid,int locpage) {
		
		return this.dao.getArticleByCreate(uid,locpage);
	}

	@Override
	public Article getArticleOne(int cid) {
		
		return this.dao.getArticleNewOne(cid);
	}

	@Override
	public Long createArticle(Article art) {
		
		Date date=new Date();
		int year=date.getYear()+1900;
		int month=date.getMonth()+1;
		int day=date.getDate();
		String time=year+"-"+month+"-"+day;
		art.setTime(time);
		return this.dao.createArticle(art);
	}

	@Override
	public List<Article> getArticleId(int uid) {
		// TODO Auto-generated method stub
		return this.dao.getArticleById(uid);
	}

	@Override
	public Article deleteArticle(int aid,int uid) {
		Article art=this.dao.getArticleByAid(aid);
		int num=0;
		if(art!=null){
			num=this.dao.deleteArticle(aid);
			System.out.println("num  :"+num);
			if(num!=0){
				DelArticleDao ddao=new DelArticleDao();
				ddao.addRow(art);
				Long daid=ddao.getNewAid(uid);
				art.setAid(daid);
//				rart=ddao.getDelArticleOne(daid);
//				rart.setContent(null);
			}
		}
		return art;
	}

	@Override
	public Article getArticle(int aid) {
		// TODO Auto-generated method stub
		return this.dao.getArticleByAid(aid);
	}

	@Override
	public List<Article> getDelArticle(int uid) {
		// TODO Auto-generated method stub
		DelArticleDao adao=new DelArticleDao();
		
		return adao.getDelArticle(uid);
	}

	@Override
	public Article recoverArticle(int aid,int uid) {
		// TODO Auto-generated method stub
		DelArticleDao adao=new DelArticleDao();
		Article art=adao.getDelArticleOne(aid);
		int num=adao.deleteRow(aid);
		System.out.print("num:   "+num);
		if(num!=0){
			this.dao.createArticle(art);
			art.setAid(this.dao.getNewAid(uid));
			art.setContent(null);
			art.setCid(0);
		}
		return art;
	}

	@Override
	public void entireClear(int uid) {
		// TODO Auto-generated method stub
		DelArticleDao adao=new DelArticleDao();
		adao.deleteAllRow(uid);
	}

	@Override
	public Article showArticle(int aid) {
		// TODO Auto-generated method stub
		Article art=this.dao.getArticleByAid(aid);
		this.dao.addViewTimes(aid, art.getViewTimes());
		return art;
	}

	@Override
	public ResultInfo showAppointArticle(int cid,int locpage) {
		// TODO Auto-generated method stub
		ResultInfo info=new ResultInfo();
		Long num=this.dao.getAppointArticleNumber(cid);
		info.setNum(num);
		List<Article> list=this.dao.getArticleByCid(cid,locpage);
		info.setData(list);
		return info;
	}
}
