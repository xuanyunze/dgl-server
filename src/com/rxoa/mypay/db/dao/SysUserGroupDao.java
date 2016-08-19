package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysUserGroupDao;
import com.rxoa.mypay.db.po.SysUserGroup;

/**
 * sys_user_group DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysUserGroupDao")
public class SysUserGroupDao extends AbstractHibernateDao<SysUserGroup> implements ISysUserGroupDao {
	public SysUserGroupDao() {
		super();
		setClazz(SysUserGroup.class);
	}

}

