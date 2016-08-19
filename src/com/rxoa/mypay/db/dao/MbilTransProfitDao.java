package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilTransProfitDao;
import com.rxoa.mypay.db.po.MbilTransProfit;

/**
 * mbil_trans_profit DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilTransProfitDao")
public class MbilTransProfitDao extends AbstractHibernateDao<MbilTransProfit> implements IMbilTransProfitDao {
	public MbilTransProfitDao() {
		super();
		setClazz(MbilTransProfit.class);
	}

}

