package utils;
import java.sql.Connection;
import java.sql.SQLException;
public class ConnectionUtils {
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	public static Connection getConnection(){
		Connection con=tl.get();
		if(con==null){
			try {
				con=DButils.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tl.set(con);
		}
		return con;
	}
	public static void remove(){
		tl.remove();
	}
}
