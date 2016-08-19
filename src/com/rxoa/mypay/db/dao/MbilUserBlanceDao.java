package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilUserBlanceDao;
import com.rxoa.mypay.db.po.MbilUserBlance;

/**
 * mbil_user_blance DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilUserBlanceDao")
public class MbilUserBlanceDao extends AbstractHibernateDao<MbilUserBlance> implements IMbilUserBlanceDao {
	public MbilUserBlanceDao() {
		super();
		setClazz(MbilUserBlance.class);
	}

}

