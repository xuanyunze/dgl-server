package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilSettlecateDao;
import com.rxoa.mypay.db.po.MbilSettlecate;

/**
 * mbil_settlecate DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilSettlecateDao")
public class MbilSettlecateDao extends AbstractHibernateDao<MbilSettlecate> implements IMbilSettlecateDao {
	public MbilSettlecateDao() {
		super();
		setClazz(MbilSettlecate.class);
	}

}

