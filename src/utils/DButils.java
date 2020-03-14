package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DButils {
	private static  QueryRunner runner;
	private static DataSource ds=new ComboPooledDataSource();
	static{
		runner=new QueryRunner(ds);
	}
	public static QueryRunner getRunner(){
		return runner;
	}
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}
