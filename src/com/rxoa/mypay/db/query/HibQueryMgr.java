package com.rxoa.mypay.db.query;


public class HibQueryMgr {
	public static String dbtype = "mysql";
	
	public static QueryContext getQueryContext(){
		if(dbtype.equals("mysql")){
			return new QueryMysql();
		}else{
			return null;
		}
	}
}
