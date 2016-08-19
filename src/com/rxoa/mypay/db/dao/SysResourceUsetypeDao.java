package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysResourceUsetypeDao;
import com.rxoa.mypay.db.po.SysResourceUsetype;

/**
 * sys_resource_usetype DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysResourceUsetypeDao")
public class SysResourceUsetypeDao extends AbstractHibernateDao<SysResourceUsetype> implements ISysResourceUsetypeDao {
	public SysResourceUsetypeDao() {
		super();
		setClazz(SysResourceUsetype.class);
	}

}

