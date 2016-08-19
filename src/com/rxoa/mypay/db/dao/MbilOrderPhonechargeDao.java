package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilOrderPhonechargeDao;
import com.rxoa.mypay.db.po.MbilOrderPhonecharge;

/**
 * mbil_order_phonecharge DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilOrderPhonechargeDao")
public class MbilOrderPhonechargeDao extends AbstractHibernateDao<MbilOrderPhonecharge> implements IMbilOrderPhonechargeDao {
	public MbilOrderPhonechargeDao() {
		super();
		setClazz(MbilOrderPhonecharge.class);
	}

}

