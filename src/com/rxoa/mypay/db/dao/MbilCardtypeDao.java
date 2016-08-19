package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilCardtypeDao;
import com.rxoa.mypay.db.po.MbilCardtype;

/**
 * mbil_cardtype DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilCardtypeDao")
public class MbilCardtypeDao extends AbstractHibernateDao<MbilCardtype> implements IMbilCardtypeDao {
	public MbilCardtypeDao() {
		super();
		setClazz(MbilCardtype.class);
	}

}

