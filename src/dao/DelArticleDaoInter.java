package dao;
import java.util.List;

import domain.Article;
public interface DelArticleDaoInter {
	public int addRow(Article art);
	public List<Article> getDelArticle(int uid);
	public int deleteRow(int aid);
	public Article getDelArticleOne(int aid);
}
