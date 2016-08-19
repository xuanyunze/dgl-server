package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilBankDao;
import com.rxoa.mypay.db.po.MbilBank;

/**
 * mbil_bank DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("mbilBankDao")
public class MbilBankDao extends AbstractHibernateDao<MbilBank> implements IMbilBankDao {
	public MbilBankDao() {
		super();
		setClazz(MbilBank.class);
	}

}

