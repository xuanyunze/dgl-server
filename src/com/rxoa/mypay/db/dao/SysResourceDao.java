package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysResourceDao;
import com.rxoa.mypay.db.po.SysResource;

/**
 * sys_resource DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysResourceDao")
public class SysResourceDao extends AbstractHibernateDao<SysResource> implements ISysResourceDao {
	public SysResourceDao() {
		super();
		setClazz(SysResource.class);
	}

}

