package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilOrderTypeDao;
import com.rxoa.mypay.db.po.MbilOrderType;

/**
 * mbil_order_type DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilOrderTypeDao")
public class MbilOrderTypeDao extends AbstractHibernateDao<MbilOrderType> implements IMbilOrderTypeDao {
	public MbilOrderTypeDao() {
		super();
		setClazz(MbilOrderType.class);
	}

}

