package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IBaseDictDao;
import com.rxoa.mypay.db.po.BaseDict;

/**
 * base_dict DAO操作类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Repository("baseDictDao")
public class BaseDictDao extends AbstractHibernateDao<BaseDict> implements IBaseDictDao {
	public BaseDictDao() {
		super();
		setClazz(BaseDict.class);
	}

}

