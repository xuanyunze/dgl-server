package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysOrgConfigDao;
import com.rxoa.mypay.db.po.SysOrgConfig;

/**
 * sys_org_config DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysOrgConfigDao")
public class SysOrgConfigDao extends AbstractHibernateDao<SysOrgConfig> implements ISysOrgConfigDao {
	public SysOrgConfigDao() {
		super();
		setClazz(SysOrgConfig.class);
	}

}

