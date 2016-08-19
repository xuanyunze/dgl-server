package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilFeecodeDao;
import com.rxoa.mypay.db.po.MbilFeecode;

/**
 * mbil_feecode DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilFeecodeDao")
public class MbilFeecodeDao extends AbstractHibernateDao<MbilFeecode> implements IMbilFeecodeDao {
	public MbilFeecodeDao() {
		super();
		setClazz(MbilFeecode.class);
	}

}

