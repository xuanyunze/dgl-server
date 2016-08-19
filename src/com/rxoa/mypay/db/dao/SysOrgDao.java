package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysOrgDao;
import com.rxoa.mypay.db.po.SysOrg;

/**
 * sys_org DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysOrgDao")
public class SysOrgDao extends AbstractHibernateDao<SysOrg> implements ISysOrgDao {
	public SysOrgDao() {
		super();
		setClazz(SysOrg.class);
	}

}

