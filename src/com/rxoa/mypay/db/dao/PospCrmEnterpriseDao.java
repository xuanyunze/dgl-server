package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IPospCrmEnterpriseDao;
import com.rxoa.mypay.db.po.PospCrmEnterprise;

/**
 * posp_crm_enterprise DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("pospCrmEnterpriseDao")
public class PospCrmEnterpriseDao extends AbstractHibernateDao<PospCrmEnterprise> implements IPospCrmEnterpriseDao {
	public PospCrmEnterpriseDao() {
		super();
		setClazz(PospCrmEnterprise.class);
	}

}

