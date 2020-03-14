package transaction;

import java.sql.SQLException;

import utils.ConnectionUtils;


public class TransactionManager {
	public static void startTransaction() throws Exception{
		System.out.println("¿ªÆôÊÂÎñ");
		ConnectionUtils.getConnection().setAutoCommit(false);
	}
	public static  void commit() throws Exception{
//		System.out.println("commit"+ConnectionUtils.getConnection());
		ConnectionUtils.getConnection().commit();
	}
	public static  void rollback() throws Exception{
//		System.out.println("rollback"+ConnectionUtils.getConnection());
		ConnectionUtils.getConnection().rollback();
	}
	public static  void close() throws Exception {
//		System.out.println("close"+ConnectionUtils.getConnection());
		ConnectionUtils.getConnection().close();
		ConnectionUtils.remove();
	}
}
