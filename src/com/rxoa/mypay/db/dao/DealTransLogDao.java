package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDealTransLogDao;
import com.rxoa.mypay.db.po.DealTransLog;

/**
 * deal_trans_log DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("dealTransLogDao")
public class DealTransLogDao extends AbstractHibernateDao<DealTransLog> implements IDealTransLogDao {
	public DealTransLogDao() {
		super();
		setClazz(DealTransLog.class);
	}

}

