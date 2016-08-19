package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilTransDao;
import com.rxoa.mypay.db.po.MbilTrans;

/**
 * mbil_trans DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilTransDao")
public class MbilTransDao extends AbstractHibernateDao<MbilTrans> implements IMbilTransDao {
	public MbilTransDao() {
		super();
		setClazz(MbilTrans.class);
	}

}

