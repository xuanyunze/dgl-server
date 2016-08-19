package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IPospFeeMccDao;
import com.rxoa.mypay.db.po.PospFeeMcc;

/**
 * posp_fee_mcc DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("pospFeeMccDao")
public class PospFeeMccDao extends AbstractHibernateDao<PospFeeMcc> implements IPospFeeMccDao {
	public PospFeeMccDao() {
		super();
		setClazz(PospFeeMcc.class);
	}

}

