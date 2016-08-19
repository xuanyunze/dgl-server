package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDictBlistPhoneDao;
import com.rxoa.mypay.db.po.DictBlistPhone;

/**
 * dict_blist_phone DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("dictBlistPhoneDao")
public class DictBlistPhoneDao extends AbstractHibernateDao<DictBlistPhone> implements IDictBlistPhoneDao {
	public DictBlistPhoneDao() {
		super();
		setClazz(DictBlistPhone.class);
	}

}

