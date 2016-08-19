package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilOrderTakemoneyDao;
import com.rxoa.mypay.db.po.MbilOrderTakemoney;

/**
 * mbil_order_takemoney DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilOrderTakemoneyDao")
public class MbilOrderTakemoneyDao extends AbstractHibernateDao<MbilOrderTakemoney> implements IMbilOrderTakemoneyDao {
	public MbilOrderTakemoneyDao() {
		super();
		setClazz(MbilOrderTakemoney.class);
	}

}

