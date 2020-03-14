package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import dao.ClassifyDao;

import beanFactory.BeanFactory;

import service.ClassifyService;
import service.ClassifyServiceInter;
import transaction.TransactionManager;

public class ClassifyServiceProxy {
	private ClassifyServiceInter classify;
	public ClassifyServiceInter getClassifyService(){
		return (ClassifyServiceInter)Proxy.newProxyInstance(ClassifyServiceInter.class.getClassLoader(), new Class[]{ClassifyServiceInter.class},new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				classify=(ClassifyService)BeanFactory.getBean("classifyService");
				ClassifyDao dao=(ClassifyDao)BeanFactory.getBean("classifyDao");
				Object object=null;
				try{
					TransactionManager.startTransaction();
					classify.setDao(dao);
					object=method.invoke(classify, args);
					TransactionManager.commit();
				}catch(Exception e){
					System.out.println("����ع�");
					TransactionManager.rollback();
				}finally{
					System.out.println("�ر����ӣ�connection���߳̽��");
					TransactionManager.close();
				}
				return object;
			}
		});
	}
}
