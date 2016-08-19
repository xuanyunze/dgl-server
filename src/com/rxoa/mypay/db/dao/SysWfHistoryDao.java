package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysWfHistoryDao;
import com.rxoa.mypay.db.po.SysWfHistory;

/**
 * sys_wf_history DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysWfHistoryDao")
public class SysWfHistoryDao extends AbstractHibernateDao<SysWfHistory> implements ISysWfHistoryDao {
	public SysWfHistoryDao() {
		super();
		setClazz(SysWfHistory.class);
	}

}

