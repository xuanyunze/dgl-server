package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysUserRoleDao;
import com.rxoa.mypay.db.po.SysUserRole;

/**
 * sys_user_role DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysUserRoleDao")
public class SysUserRoleDao extends AbstractHibernateDao<SysUserRole> implements ISysUserRoleDao {
	public SysUserRoleDao() {
		super();
		setClazz(SysUserRole.class);
	}

}

