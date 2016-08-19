package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDealTransDao;
import com.rxoa.mypay.db.po.DealTrans;

/**
 * deal_trans DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("dealTransDao")
public class DealTransDao extends AbstractHibernateDao<DealTrans> implements IDealTransDao {
	public DealTransDao() {
		super();
		setClazz(DealTrans.class);
	}

}

