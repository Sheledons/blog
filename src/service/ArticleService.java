package service;

import java.util.List;
import dao.ArticleDao;
import domain.Article;
public class ArticleService implements ArticleServiceInter{
	private ArticleDao dao=new ArticleDao();
	@Override
	public int getArticleNumber(int uid) {
		
		int number=this.dao.getNumber(uid);
		return number;
	}

	@Override
	public List<Article> getArticleByTimes(int uid) {
		
		return this.dao.getArticleByTimes(uid);
	}

	@Override
	public List<Article> getArticleByCreate(int uid) {
		return this.dao.getArticleByCreate(uid);
	}

	@Override
	public Article getArticleOne(int cid) {
		return this.dao.getArticleOne(cid);
	}

	@Override
	public int createArticle(Article art) {
		return this.dao.createArticle(art);
	}

}
