package service;

import java.util.List;
import dao.ArticleDao;
import domain.Article;
public class ArticleService implements ArticleServiceInter{

	@Override
	public int getArticleNumber(int uid) {
		ArticleDao dao=new ArticleDao();
		int number=dao.getNumber(uid);
		return number;
	}

	@Override
	public List<Article> getArticleByTimes(int uid) {
		ArticleDao dao=new ArticleDao();
		return dao.getArticleByTimes(uid);
	}

}
