package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilLogDao;
import com.rxoa.mypay.db.po.MbilLog;

/**
 * mbil_log DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilLogDao")
public class MbilLogDao extends AbstractHibernateDao<MbilLog> implements IMbilLogDao {
	public MbilLogDao() {
		super();
		setClazz(MbilLog.class);
	}

}

