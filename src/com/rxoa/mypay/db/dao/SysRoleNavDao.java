package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysRoleNavDao;
import com.rxoa.mypay.db.po.SysRoleNav;

/**
 * sys_role_nav DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysRoleNavDao")
public class SysRoleNavDao extends AbstractHibernateDao<SysRoleNav> implements ISysRoleNavDao {
	public SysRoleNavDao() {
		super();
		setClazz(SysRoleNav.class);
	}

}

