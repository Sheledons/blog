package dao;
import java.util.List;

import domain.Article;
public interface ArticleDaoInter {
	public int getNumber(int uid);
	public List<Article> getArticleByTimes(int uid);   //按浏览次数检索
	public List<Article> getArticleByCreate(int uid,int locpage);  //按创建时间检索
	public List<Article> getArticleById(int uid);
	public Article getArticleNewOne(int cid);             //返回最新创建的文章
	public Article getArticleByAid(int aid);
	public int createArticle(Article art);
	public int deleteArticle(int aid);
	public int getNewAid(int uid);
}
