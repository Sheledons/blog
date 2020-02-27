package service;
import dao.DelArticleDao;
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
		return this.dao.getArticleNewOne(cid);
	}

	@Override
	public int createArticle(Article art) {
		return this.dao.createArticle(art);
	}

	@Override
	public List<Article> getArticleId(int uid) {
		// TODO Auto-generated method stub
		return this.dao.getArticleById(uid);
	}

	@Override
	public boolean deleteArticle(int aid) {
		Article art=this.dao.getArticleByAid(aid);
		boolean flag=false;
		int num=0;
		if(art!=null){
			num=this.dao.deleteArticle(aid);
			if(num!=0){
				DelArticleDao ddao=new DelArticleDao();
				ddao.addColumn(art);
				flag=true;
			}
		}
		return flag;
	}

	@Override
	public Article getArticle(int aid) {
		// TODO Auto-generated method stub
		return this.dao.getArticleByAid(aid);
	}
}
