package db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	public static Connection conn = null;
	

	
	public  static Connection getConnection() {
		if(conn == null) {
			try {
			Properties props = loadProprreties();
			String url = props.getProperty("dburl");
			conn = DriverManager.getConnection(url, props);
			
			
			}
			catch (SQLException e) { 
			throw new DbExcepition(e.getMessage());
				
			}
			
		} 
		
		return conn;
		
	}
	
	public  static Properties loadProprreties()  {
		try( FileInputStream fs = new FileInputStream("Db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
			
			
		}
		catch (Exception e) {
			 throw  new DbExcepition(e.getMessage());
		}
		
	}
	
	public static void closeConnection() {
		if( conn != null) {
			try {
				  conn.close();
			}
			catch (Exception e) {
				throw new DbExcepition(e.getMessage());
				
			}
			
		}
	}
	public static void closeStaman(Statement st) {
		if(st != null) {
			try {
				st.close();
			}
			catch (SQLException  e) {
				throw new DbExcepition(e.getMessage());
			}
			
		}
		
		
	}
	public static void closeRsult(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}
			catch (SQLException  e) {
				throw new DbExcepition(e.getMessage());
			}
			
		}
		
		
	}
	

}
