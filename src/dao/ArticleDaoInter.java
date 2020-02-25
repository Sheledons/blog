package dao;
import java.util.List;

import domain.Article;
public interface ArticleDaoInter {
	public int getNumber(int uid);
	public List<Article> getArticleByTimes(int uid);
	public List<Article> getArticleByCreate(int uid);
}
