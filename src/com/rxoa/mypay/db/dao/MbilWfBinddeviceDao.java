package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilWfBinddeviceDao;
import com.rxoa.mypay.db.po.MbilWfBinddevice;

/**
 * mbil_wf_binddevice DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("mbilWfBinddeviceDao")
public class MbilWfBinddeviceDao extends AbstractHibernateDao<MbilWfBinddevice> implements IMbilWfBinddeviceDao {
	public MbilWfBinddeviceDao() {
		super();
		setClazz(MbilWfBinddevice.class);
	}

}

