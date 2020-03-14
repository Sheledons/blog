package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import beanFactory.BeanFactory;

import service.UserService;
import service.UserServiceInter;
import transaction.TransactionManager;
import utils.ConnectionUtils;

public class UserServiceProxy {
	private UserServiceInter service=new UserService();
	public UserServiceInter getUserService(){
		return ((UserServiceInter)Proxy.newProxyInstance(UserServiceInter.class.getClassLoader(),new Class [] {UserServiceInter.class},new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				Object object=null;
				try{
					TransactionManager.startTransaction();
//					System.out.println(ConnectionUtils.getConnection());
					object=method.invoke(service, args);
					TransactionManager.commit();
				}catch(Exception e){
					System.out.println("user事务回滚");
					TransactionManager.rollback();
				}finally{
					System.out.println("user关闭连接，connection与线程解绑");
					TransactionManager.close();
				}
				return object;
			}
		}));
	}
}
