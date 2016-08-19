package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysVisitLogDao;
import com.rxoa.mypay.db.po.SysVisitLog;

/**
 * sys_visit_log DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysVisitLogDao")
public class SysVisitLogDao extends AbstractHibernateDao<SysVisitLog> implements ISysVisitLogDao {
	public SysVisitLogDao() {
		super();
		setClazz(SysVisitLog.class);
	}

}

