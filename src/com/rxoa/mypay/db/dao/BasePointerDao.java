package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IBasePointerDao;
import com.rxoa.mypay.db.po.BasePointer;

/**
 * base_pointer DAO操作类
 * Tue Apr 05 11:23:26 CST 2016 baiyu
 */ 

@Repository("basePointerDao")
public class BasePointerDao extends AbstractHibernateDao<BasePointer> implements IBasePointerDao {
	public BasePointerDao() {
		super();
		setClazz(BasePointer.class);
	}

}

