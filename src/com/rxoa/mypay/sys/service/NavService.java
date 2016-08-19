package com.rxoa.mypay.sys.service;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.rxoa.mypay.db.po.SysRoleNav;
import com.rxoa.mypay.db.po.SysUser;
import com.rxoa.mypay.db.po.SysUserNav;
import com.rxoa.mypay.db.po.SysUserNavTmp;
import com.rxoa.mypay.db.query.HibQueryMgr;
import com.rxoa.mypay.db.query.QueryContext;

@Service("navService")
public class NavService {
	
	public String getNavContent(String uid,String roleid){
		String navString = "";
		String navTmpid = "";
		String vhql = "";
		QueryContext qContext = HibQueryMgr.getQueryContext();
		try{
			//String hql = "from SysUserNav where nav_userid = '"+uid+"' and nav_stat = 0";
			String hql = "from SysRoleNav where nav_roleid = '"+roleid+"' and nav_stat = '1'";
			Query query = qContext.getHibSession().createQuery(hql);
			if(query.list().size() > 0){
				navString = ((SysRoleNav)query.list().get(0)).getNavContent();
				//navTmpid = ((SysUserNav)query.list().get(0)).getNavTmpcode();
			}
			/*
			if(navString==null||navString.equals("null")||navString.equals("")){
				if(navTmpid==null||navTmpid.equals("null")||navTmpid.equals("")){
					vhql = "from SysUserNavTmp where ntCode = 'default' and ntStat = 0";
				}else{
					vhql = "from SysUserNavTmp where ntCode = '"+navTmpid+"' and ntStat = 0";
				}
				Query vquery = qContext.getHibSession().createQuery(vhql);
				if(vquery.list().size() > 0){
					navString = ((SysUserNavTmp)vquery.list().get(0)).getNtValue();
				}
			}
			*/
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			qContext.closeHibSession();
		}
		return navString;
	}
}
