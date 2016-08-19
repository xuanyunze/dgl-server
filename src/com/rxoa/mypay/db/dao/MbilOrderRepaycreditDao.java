package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilOrderRepaycreditDao;
import com.rxoa.mypay.db.po.MbilOrderRepaycredit;

/**
 * mbil_order_repaycredit DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilOrderRepaycreditDao")
public class MbilOrderRepaycreditDao extends AbstractHibernateDao<MbilOrderRepaycredit> implements IMbilOrderRepaycreditDao {
	public MbilOrderRepaycreditDao() {
		super();
		setClazz(MbilOrderRepaycredit.class);
	}

}

