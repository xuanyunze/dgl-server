package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilWfActivateDao;
import com.rxoa.mypay.db.po.MbilWfActivate;

/**
 * mbil_wf_activate DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilWfActivateDao")
public class MbilWfActivateDao extends AbstractHibernateDao<MbilWfActivate> implements IMbilWfActivateDao {
	public MbilWfActivateDao() {
		super();
		setClazz(MbilWfActivate.class);
	}

}

