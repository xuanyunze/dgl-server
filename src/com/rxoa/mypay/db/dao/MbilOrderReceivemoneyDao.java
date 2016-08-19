package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilOrderReceivemoneyDao;
import com.rxoa.mypay.db.po.MbilOrderReceivemoney;

/**
 * mbil_order_receivemoney DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilOrderReceivemoneyDao")
public class MbilOrderReceivemoneyDao extends AbstractHibernateDao<MbilOrderReceivemoney> implements IMbilOrderReceivemoneyDao {
	public MbilOrderReceivemoneyDao() {
		super();
		setClazz(MbilOrderReceivemoney.class);
	}

}

