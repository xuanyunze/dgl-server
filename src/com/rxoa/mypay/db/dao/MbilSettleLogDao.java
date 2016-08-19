package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilSettleLogDao;
import com.rxoa.mypay.db.po.MbilSettleLog;

/**
 * mbil_settle_log DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilSettleLogDao")
public class MbilSettleLogDao extends AbstractHibernateDao<MbilSettleLog> implements IMbilSettleLogDao {
	public MbilSettleLogDao() {
		super();
		setClazz(MbilSettleLog.class);
	}

}

