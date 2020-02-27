package service;

import java.util.List;
import domain.Article;
public interface ArticleServiceInter {
	public int getArticleNumber(int uid);
	public List<Article> getArticleByTimes(int uid);
	public List<Article> getArticleByCreate(int uid);
	public List<Article> getArticleId(int uid);
	public Article getArticleOne(int cid);
	public Article getArticle(int aid);
	public int createArticle(Article art);
	public boolean deleteArticle(int aid);
}
