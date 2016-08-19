package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilOrderTransaccountDao;
import com.rxoa.mypay.db.po.MbilOrderTransaccount;

/**
 * mbil_order_transaccount DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilOrderTransaccountDao")
public class MbilOrderTransaccountDao extends AbstractHibernateDao<MbilOrderTransaccount> implements IMbilOrderTransaccountDao {
	public MbilOrderTransaccountDao() {
		super();
		setClazz(MbilOrderTransaccount.class);
	}

}

