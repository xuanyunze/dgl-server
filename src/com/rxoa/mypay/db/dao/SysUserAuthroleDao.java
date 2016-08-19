package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysUserAuthroleDao;
import com.rxoa.mypay.db.po.SysUserAuthrole;

/**
 * sys_user_authrole DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysUserAuthroleDao")
public class SysUserAuthroleDao extends AbstractHibernateDao<SysUserAuthrole> implements ISysUserAuthroleDao {
	public SysUserAuthroleDao() {
		super();
		setClazz(SysUserAuthrole.class);
	}

}

