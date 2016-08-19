package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilAreacodeDao;
import com.rxoa.mypay.db.po.MbilAreacode;

/**
 * mbil_areacode DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("mbilAreacodeDao")
public class MbilAreacodeDao extends AbstractHibernateDao<MbilAreacode> implements IMbilAreacodeDao {
	public MbilAreacodeDao() {
		super();
		setClazz(MbilAreacode.class);
	}

}

