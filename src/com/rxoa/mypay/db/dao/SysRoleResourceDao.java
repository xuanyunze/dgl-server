package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysRoleResourceDao;
import com.rxoa.mypay.db.po.SysRoleResource;

/**
 * sys_role_resource DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysRoleResourceDao")
public class SysRoleResourceDao extends AbstractHibernateDao<SysRoleResource> implements ISysRoleResourceDao {
	public SysRoleResourceDao() {
		super();
		setClazz(SysRoleResource.class);
	}

}

