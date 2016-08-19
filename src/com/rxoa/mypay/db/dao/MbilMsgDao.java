package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilMsgDao;
import com.rxoa.mypay.db.po.MbilMsg;

/**
 * mbil_msg DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilMsgDao")
public class MbilMsgDao extends AbstractHibernateDao<MbilMsg> implements IMbilMsgDao {
	public MbilMsgDao() {
		super();
		setClazz(MbilMsg.class);
	}

}

