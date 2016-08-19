package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilVersionDao;
import com.rxoa.mypay.db.po.MbilVersion;

/**
 * mbil_version DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilVersionDao")
public class MbilVersionDao extends AbstractHibernateDao<MbilVersion> implements IMbilVersionDao {
	public MbilVersionDao() {
		super();
		setClazz(MbilVersion.class);
	}

}

