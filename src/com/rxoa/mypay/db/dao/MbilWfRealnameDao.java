package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilWfRealnameDao;
import com.rxoa.mypay.db.po.MbilWfRealname;

/**
 * mbil_wf_realname DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("mbilWfRealnameDao")
public class MbilWfRealnameDao extends AbstractHibernateDao<MbilWfRealname> implements IMbilWfRealnameDao {
	public MbilWfRealnameDao() {
		super();
		setClazz(MbilWfRealname.class);
	}

}

