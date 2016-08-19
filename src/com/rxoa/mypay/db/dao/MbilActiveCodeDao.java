package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilActiveCodeDao;
import com.rxoa.mypay.db.po.MbilActiveCode;

/**
 * mbil_active_code DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("mbilActiveCodeDao")
public class MbilActiveCodeDao extends AbstractHibernateDao<MbilActiveCode> implements IMbilActiveCodeDao {
	public MbilActiveCodeDao() {
		super();
		setClazz(MbilActiveCode.class);
	}

}

