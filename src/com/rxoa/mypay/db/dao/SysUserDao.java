package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysUserDao;
import com.rxoa.mypay.db.po.SysUser;

/**
 * sys_user DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysUserDao")
public class SysUserDao extends AbstractHibernateDao<SysUser> implements ISysUserDao {
	public SysUserDao() {
		super();
		setClazz(SysUser.class);
	}

}

