package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDealMchChlmapDao;
import com.rxoa.mypay.db.po.DealMchChlmap;

/**
 * deal_mch_chlmap DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("dealMchChlmapDao")
public class DealMchChlmapDao extends AbstractHibernateDao<DealMchChlmap> implements IDealMchChlmapDao {
	public DealMchChlmapDao() {
		super();
		setClazz(DealMchChlmap.class);
	}

}

