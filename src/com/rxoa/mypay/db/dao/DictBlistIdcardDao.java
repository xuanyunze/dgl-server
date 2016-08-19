package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDictBlistIdcardDao;
import com.rxoa.mypay.db.po.DictBlistIdcard;

/**
 * dict_blist_idcard DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("dictBlistIdcardDao")
public class DictBlistIdcardDao extends AbstractHibernateDao<DictBlistIdcard> implements IDictBlistIdcardDao {
	public DictBlistIdcardDao() {
		super();
		setClazz(DictBlistIdcard.class);
	}

}

