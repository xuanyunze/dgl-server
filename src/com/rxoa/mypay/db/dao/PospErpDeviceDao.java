package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IPospErpDeviceDao;
import com.rxoa.mypay.db.po.PospErpDevice;

/**
 * posp_erp_device DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("pospErpDeviceDao")
public class PospErpDeviceDao extends AbstractHibernateDao<PospErpDevice> implements IPospErpDeviceDao {
	public PospErpDeviceDao() {
		super();
		setClazz(PospErpDevice.class);
	}

}

