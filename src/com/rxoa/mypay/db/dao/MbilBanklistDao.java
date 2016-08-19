package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilBanklistDao;
import com.rxoa.mypay.db.po.MbilBanklist;

/**
 * mbil_banklist DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("mbilBanklistDao")
public class MbilBanklistDao extends AbstractHibernateDao<MbilBanklist> implements IMbilBanklistDao {
	public MbilBanklistDao() {
		super();
		setClazz(MbilBanklist.class);
	}

}

