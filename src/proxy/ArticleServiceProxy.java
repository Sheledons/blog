package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import dao.ArticleDao;

import beanFactory.BeanFactory;

import service.ArticleService;
import service.ArticleServiceInter;
import transaction.TransactionManager;
import utils.ConnectionUtils;

public class ArticleServiceProxy {
	private ArticleService article;
	public ArticleServiceInter getArticleService(){
		return (ArticleServiceInter)Proxy.newProxyInstance(ArticleServiceProxy.class.getClassLoader(), new Class[]{ArticleServiceInter.class},new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				article=(ArticleService)BeanFactory.getBean("articleService");
				ArticleDao dao=(ArticleDao)BeanFactory.getBean("articleDao");
				Object object=null;
				try{
					TransactionManager.startTransaction();
//					System.out.println(ConnectionUtils.getConnection());
					article.setDao(dao);
					object=method.invoke(article, args);
					TransactionManager.commit();
				}catch(Exception e){
					System.out.println("事务回滚");
					TransactionManager.rollback();
				}finally{
					System.out.println("关闭连接，connection与线程解绑");
					TransactionManager.close();
				}
				return object;
			}
		});
	}
}
