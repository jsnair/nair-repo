/*
      * @author HYD30-H143-Group B     
      * @version 1.0
      * @Class name ConnectionAdmin
      * @Creation Date 20/05/2012
     * @ History Common Java Class for Connecting to Oracle DB
*/

package com.tcs.ilp.ims.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionAdmin {

	public Connection getConnection(){
		Connection conn = null;
		ResourceBundle bundle  = ResourceBundle.getBundle("oraDB"); 
		
		String driver = bundle.getString("DRIVER");
		
		String url = bundle.getString("URL");
		
		String ip = bundle.getString("IP");
		
		String port = bundle.getString("PORT");
		
		String dbname = bundle.getString("dbname");
		
		String username = bundle.getString("username");
		
		String pwd = bundle.getString("password");
		try {
			if(conn==null){
			Class.forName(driver);
			conn = DriverManager.getConnection(url+ip+port+dbname,username,pwd);
			conn.setAutoCommit(true);
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return conn;
	}
	
}
