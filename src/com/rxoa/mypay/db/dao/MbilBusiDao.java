package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilBusiDao;
import com.rxoa.mypay.db.po.MbilBusi;

/**
 * mbil_busi DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("mbilBusiDao")
public class MbilBusiDao extends AbstractHibernateDao<MbilBusi> implements IMbilBusiDao {
	public MbilBusiDao() {
		super();
		setClazz(MbilBusi.class);
	}

}

