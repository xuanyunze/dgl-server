package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IDictBlistCardDao;
import com.rxoa.mypay.db.po.DictBlistCard;

/**
 * dict_blist_card DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("dictBlistCardDao")
public class DictBlistCardDao extends AbstractHibernateDao<DictBlistCard> implements IDictBlistCardDao {
	public DictBlistCardDao() {
		super();
		setClazz(DictBlistCard.class);
	}

}

