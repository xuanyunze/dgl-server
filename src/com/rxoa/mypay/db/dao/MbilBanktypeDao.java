package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilBanktypeDao;
import com.rxoa.mypay.db.po.MbilBanktype;

/**
 * mbil_banktype DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("mbilBanktypeDao")
public class MbilBanktypeDao extends AbstractHibernateDao<MbilBanktype> implements IMbilBanktypeDao {
	public MbilBanktypeDao() {
		super();
		setClazz(MbilBanktype.class);
	}

}

