package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysUserNavDao;
import com.rxoa.mypay.db.po.SysUserNav;

/**
 * sys_user_nav DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysUserNavDao")
public class SysUserNavDao extends AbstractHibernateDao<SysUserNav> implements ISysUserNavDao {
	public SysUserNavDao() {
		super();
		setClazz(SysUserNav.class);
	}

}

