package dao;
import java.util.List;

import domain.Article;
public interface ArticleDaoInter {
	public int getNumber(int uid);
	public List<Article> getArticleByTimes(int uid);   //�������������
	public List<Article> getArticleByCreate(int uid,int locpage);  //������ʱ�����
	public List<Article> getArticleById(int uid);
	public Article getArticleNewOne(int cid);             //�������´���������
	public Article getArticleByAid(int aid);
	public int createArticle(Article art);
	public int deleteArticle(int aid);
	public int getNewAid(int uid);
}
