package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IPospFeeModeDao;
import com.rxoa.mypay.db.po.PospFeeMode;

/**
 * posp_fee_mode DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("pospFeeModeDao")
public class PospFeeModeDao extends AbstractHibernateDao<PospFeeMode> implements IPospFeeModeDao {
	public PospFeeModeDao() {
		super();
		setClazz(PospFeeMode.class);
	}

}

