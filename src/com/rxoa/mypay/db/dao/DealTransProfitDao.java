package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDealTransProfitDao;
import com.rxoa.mypay.db.po.DealTransProfit;

/**
 * deal_trans_profit DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("dealTransProfitDao")
public class DealTransProfitDao extends AbstractHibernateDao<DealTransProfit> implements IDealTransProfitDao {
	public DealTransProfitDao() {
		super();
		setClazz(DealTransProfit.class);
	}

}

