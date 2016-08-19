package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysRoleDao;
import com.rxoa.mypay.db.po.SysRole;

/**
 * sys_role DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysRoleDao")
public class SysRoleDao extends AbstractHibernateDao<SysRole> implements ISysRoleDao {
	public SysRoleDao() {
		super();
		setClazz(SysRole.class);
	}

}

