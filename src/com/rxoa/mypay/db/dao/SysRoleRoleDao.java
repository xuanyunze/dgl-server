package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysRoleRoleDao;
import com.rxoa.mypay.db.po.SysRoleRole;

/**
 * sys_role_role DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysRoleRoleDao")
public class SysRoleRoleDao extends AbstractHibernateDao<SysRoleRole> implements ISysRoleRoleDao {
	public SysRoleRoleDao() {
		super();
		setClazz(SysRoleRole.class);
	}

}

