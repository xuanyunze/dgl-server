package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDealMchGroupDao;
import com.rxoa.mypay.db.po.DealMchGroup;

/**
 * deal_mch_group DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("dealMchGroupDao")
public class DealMchGroupDao extends AbstractHibernateDao<DealMchGroup> implements IDealMchGroupDao {
	public DealMchGroupDao() {
		super();
		setClazz(DealMchGroup.class);
	}

}

