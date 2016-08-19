package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDealMchinfoDao;
import com.rxoa.mypay.db.po.DealMchinfo;

/**
 * deal_mchinfo DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("dealMchinfoDao")
public class DealMchinfoDao extends AbstractHibernateDao<DealMchinfo> implements IDealMchinfoDao {
	public DealMchinfoDao() {
		super();
		setClazz(DealMchinfo.class);
	}

}

