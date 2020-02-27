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
	public Article deleteArticle(int aid) {
		Article art=this.dao.getArticleByAid(aid);
		int num=0;
		if(art!=null){
			num=this.dao.deleteArticle(aid);
			if(num!=0){
				DelArticleDao ddao=new DelArticleDao();
				ddao.addRow(art);
			}
		}
		return art;
	}

	@Override
	public Article getArticle(int aid) {
		// TODO Auto-generated method stub
		return this.dao.getArticleByAid(aid);
	}

	@Override
	public List<Article> getDelArticle(int uid) {
		// TODO Auto-generated method stub
		DelArticleDao adao=new DelArticleDao();
		
		return adao.getDelArticle(uid);
	}

	@Override
	public Article recoverArticle(int aid) {
		// TODO Auto-generated method stub
		DelArticleDao adao=new DelArticleDao();
		Article art=adao.getDelArticleOne(aid);
		int num=adao.deleteRow(aid);
		System.out.print("num:   "+num);
		if(num!=0){
			System.out.print("½øÈë");
			this.dao.createArticle(art);
			art.setContent(null);
			art.setCid(0);
		}
		return art;
	}
}
