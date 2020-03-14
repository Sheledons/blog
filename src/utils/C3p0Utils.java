package utils;

import java.sql.SQLException;

import javax.sql.DataSource;


import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	static private DataSource da=new ComboPooledDataSource();
	static public DataSource getDataSource() throws SQLException{
		return da;
	}
}
