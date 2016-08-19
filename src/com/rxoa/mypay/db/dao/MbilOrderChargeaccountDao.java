package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilOrderChargeaccountDao;
import com.rxoa.mypay.db.po.MbilOrderChargeaccount;

/**
 * mbil_order_chargeaccount DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilOrderChargeaccountDao")
public class MbilOrderChargeaccountDao extends AbstractHibernateDao<MbilOrderChargeaccount> implements IMbilOrderChargeaccountDao {
	public MbilOrderChargeaccountDao() {
		super();
		setClazz(MbilOrderChargeaccount.class);
	}

}

