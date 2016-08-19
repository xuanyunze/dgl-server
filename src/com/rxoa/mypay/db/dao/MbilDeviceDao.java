package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilDeviceDao;
import com.rxoa.mypay.db.po.MbilDevice;

/**
 * mbil_device DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilDeviceDao")
public class MbilDeviceDao extends AbstractHibernateDao<MbilDevice> implements IMbilDeviceDao {
	public MbilDeviceDao() {
		super();
		setClazz(MbilDevice.class);
	}

}

