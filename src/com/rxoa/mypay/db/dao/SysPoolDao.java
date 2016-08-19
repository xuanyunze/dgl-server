package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysPoolDao;
import com.rxoa.mypay.db.po.SysPool;

/**
 * sys_pool DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysPoolDao")
public class SysPoolDao extends AbstractHibernateDao<SysPool> implements ISysPoolDao {
	public SysPoolDao() {
		super();
		setClazz(SysPool.class);
	}

}

