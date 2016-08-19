package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilUserBlanceLogDao;
import com.rxoa.mypay.db.po.MbilUserBlanceLog;

/**
 * mbil_user_blance_log DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilUserBlanceLogDao")
public class MbilUserBlanceLogDao extends AbstractHibernateDao<MbilUserBlanceLog> implements IMbilUserBlanceLogDao {
	public MbilUserBlanceLogDao() {
		super();
		setClazz(MbilUserBlanceLog.class);
	}

}

