package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilBusinessDao;
import com.rxoa.mypay.db.po.MbilBusiness;

/**
 * mbil_business DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilBusinessDao")
public class MbilBusinessDao extends AbstractHibernateDao<MbilBusiness> implements IMbilBusinessDao {
	public MbilBusinessDao() {
		super();
		setClazz(MbilBusiness.class);
	}

}

