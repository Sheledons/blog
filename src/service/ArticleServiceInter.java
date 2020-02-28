package service;

import java.util.List;
import domain.Article;
import domain.ResultInfo;

public interface ArticleServiceInter {
	public int getArticleNumber(int uid);

	public List<Article> getArticleByTimes(int uid);

	public List<Article> getArticleByCreate(int uid, int locpage);

	public List<Article> getArticleId(int uid);

	public Article getArticleOne(int cid);

	public Article getArticle(int aid);

	public int createArticle(Article art);

	public Article deleteArticle(int aid, int uid);

	public List<Article> getDelArticle(int uid);

	public Article recoverArticle(int aid, int uid);

	public void entireClear(int uid);

	public Article showArticle(int aid);

	public ResultInfo showAppointArticle(int cid,int locpage);
}
