package dao;
import java.util.List;

import domain.Article;
public interface ArticleDaoInter {
	public int getNumber(int uid);
	public List<Article> getArticle(int uid);
}