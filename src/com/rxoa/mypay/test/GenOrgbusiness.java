package com.rxoa.mypay.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.rxoa.mypay.db.query.HibQueryMgr;
import com.rxoa.mypay.util.DbConnector;

public class GenOrgbusiness {
	
	public static void genBusiness(){
		Connection conn = null;
		Statement stmt = null;
		Statement qstmt = null;
		Statement instmt = null;
		try{
			conn = DbConnector.getConnection("mysql");
			stmt = conn.createStatement();
			instmt = conn.createStatement();
			qstmt = conn.createStatement();
			String sql = "select * from sys_org where length(o_id)>4 and left(o_id,4)='1011' order by length(o_id) asc,o_id asc";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			int count = 0;
			while(rs.next()){
				String xsql = "select * from mbil_busi_fee_org where bsof_oid='"+rs.getString("o_id")+"' and bsof_feeid='1101'";
				ResultSet q = qstmt.executeQuery(xsql);
				System.out.println("q="+xsql);
				if(!q.next()){
					if(count>0) break;
					String f_s0track = HibQueryMgr.getQueryContext().getDistributionInfo(rs.getString("o_id"), "1101");
					String in_s0 = "insert into mbil_busi_fee_org (uuid,bsof_oid,bsof_feeid,bosf_rate,bsof_istop,bsof_toprate,bsof_minvalue,bsof_maxvalue,bsof_distrack) "
							+ "values ('"+getLen32Uuid()+"','"+rs.getString("o_id")+"','1101',0.0045,0,0,0,0,'"+f_s0track+"')";
					instmt.executeQuery(in_s0);
					System.out.println(rs.getString("o_id")+"|"+rs.getString("o_name"));
					count++;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
				instmt.close();
				qstmt.close();
				conn.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			stmt = null;
			instmt = null;
			qstmt = null;
			conn = null;
		}
	}
	public static String getLen32Uuid(){
		return java.util.UUID.randomUUID().toString().replace("-", "");
	}
	public static void main(String[] args){
		genBusiness();
	}
}
