package dao;
import java.util.List;

import domain.Article;
public interface ArticleDaoInter {
	public Long getNumber(int uid);
	public List<Article> getArticleByTimes(int uid);   //�������������
	public List<Article> getArticleByCreate(int uid,int locpage);  //������ʱ�����
	public List<Article> getArticleById(int uid);
	public Article getArticleNewOne(int cid);             //�������´���������
	public Article getArticleByAid(int aid);
	public Long createArticle(Article art);
	public int deleteArticle(int aid);
	public Long getNewAid(int uid);
	public void addViewTimes(int aid,int orignalViewTimes);
	public Long getAppointArticleNumber(int cid);
	public List<Article> getArticleByCid(int cid,int locpage);
}
