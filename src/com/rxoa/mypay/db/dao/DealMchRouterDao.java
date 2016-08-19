package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDealMchRouterDao;
import com.rxoa.mypay.db.po.DealMchRouter;

/**
 * deal_mch_router DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("dealMchRouterDao")
public class DealMchRouterDao extends AbstractHibernateDao<DealMchRouter> implements IDealMchRouterDao {
	public DealMchRouterDao() {
		super();
		setClazz(DealMchRouter.class);
	}

}

