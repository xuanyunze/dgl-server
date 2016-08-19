package com.rxoa.mypay.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.rxoa.mypay.base.config.BaseConfig;

public class DbConnector {
	public static Connection getConnection(String type){
		String url=null,user=null,pwd=null;
		Connection conn = null;
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
			if(type.equals("mysql")){
				url = BaseConfig.getProperty("jdbc.url");
				user = BaseConfig.getProperty("jdbc.user");
				pwd = BaseConfig.getProperty("jdbc.pass");
			}
		    conn = DriverManager.getConnection(url,user, pwd);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
