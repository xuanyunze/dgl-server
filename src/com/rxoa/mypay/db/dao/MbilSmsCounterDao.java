package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilSmsCounterDao;
import com.rxoa.mypay.db.po.MbilSmsCounter;

/**
 * mbil_sms_counter DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilSmsCounterDao")
public class MbilSmsCounterDao extends AbstractHibernateDao<MbilSmsCounter> implements IMbilSmsCounterDao {
	public MbilSmsCounterDao() {
		super();
		setClazz(MbilSmsCounter.class);
	}

}

