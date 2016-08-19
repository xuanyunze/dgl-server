package com.rxoa.mypay.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

import com.rxoa.mypay.util.DbConnector;

public class SyncUser {
	private static Logger logger  = Logger.getLogger(SyncUser.class.getName());
	public static void syncUser(){
		Connection conn = null;
		Statement stmt = null;
		Statement qstmt = null;
		Statement instmt = null;
		try{
			conn = DbConnector.getConnection("mysql");
			stmt = conn.createStatement();
			instmt = conn.createStatement();
			qstmt = conn.createStatement();
			String sql = "select * from mbil_user order by cre_time desc";
			ResultSet rs = stmt.executeQuery(sql);
			int count = 0;int lcount = 0;int bcount = 0;
			System.out.println("begin");
			while(rs.next()){
				count++;
				System.out.println(count);
				String uid = rs.getString("u_id");
				String qsql = "select count(*) as count from mbil_user_blance where ub_uid='"+uid+"'";
				ResultSet qu = qstmt.executeQuery(qsql);
				qu.next();
				if(qu.getInt("count")==0){
					String insql = "insert into mbil_user_blance (uuid,ub_uid) values ('"+getLen32Uuid()+"','"+uid+"')";
					int irow = instmt.executeUpdate(insql);
					if(irow>0){
						bcount++;	
					}
				}
				
				qsql = "select count(*) as count from mbil_user_limit where ul_uid='"+uid+"'";
				ResultSet gu = qstmt.executeQuery(qsql);
				gu.next();
				if(gu.getInt("count")==0){
					String insql = "insert into mbil_user_limit (uuid,ul_uid) values ('"+getLen32Uuid()+"','"+uid+"')";
					int irow = instmt.executeUpdate(insql);
					if(irow>0){
						lcount++;	
					}
				}
			}
			System.out.println(bcount + "|" + lcount);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
				qstmt.close();
				instmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				stmt = null;
				qstmt = null;
				instmt = null;
			}
		}
	}
	public static String getLen32Uuid(){
		return java.util.UUID.randomUUID().toString().replace("-", "");
	}
	public static void main(String[] args){
		syncUser();
	}
}
