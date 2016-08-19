package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysPositionDao;
import com.rxoa.mypay.db.po.SysPosition;

/**
 * sys_position DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysPositionDao")
public class SysPositionDao extends AbstractHibernateDao<SysPosition> implements ISysPositionDao {
	public SysPositionDao() {
		super();
		setClazz(SysPosition.class);
	}

}

