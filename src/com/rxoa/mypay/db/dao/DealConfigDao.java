package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDealConfigDao;
import com.rxoa.mypay.db.po.DealConfig;

/**
 * deal_config DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("dealConfigDao")
public class DealConfigDao extends AbstractHibernateDao<DealConfig> implements IDealConfigDao {
	public DealConfigDao() {
		super();
		setClazz(DealConfig.class);
	}

}

