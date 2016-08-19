package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilWfBindcardDao;
import com.rxoa.mypay.db.po.MbilWfBindcard;

/**
 * mbil_wf_bindcard DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilWfBindcardDao")
public class MbilWfBindcardDao extends AbstractHibernateDao<MbilWfBindcard> implements IMbilWfBindcardDao {
	public MbilWfBindcardDao() {
		super();
		setClazz(MbilWfBindcard.class);
	}

}

