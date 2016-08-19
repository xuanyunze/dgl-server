package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysNavigationDao;
import com.rxoa.mypay.db.po.SysNavigation;

/**
 * sys_navigation DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysNavigationDao")
public class SysNavigationDao extends AbstractHibernateDao<SysNavigation> implements ISysNavigationDao {
	public SysNavigationDao() {
		super();
		setClazz(SysNavigation.class);
	}

}

