package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IPospCrmStudioDao;
import com.rxoa.mypay.db.po.PospCrmStudio;

/**
 * posp_crm_studio DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("pospCrmStudioDao")
public class PospCrmStudioDao extends AbstractHibernateDao<PospCrmStudio> implements IPospCrmStudioDao {
	public PospCrmStudioDao() {
		super();
		setClazz(PospCrmStudio.class);
	}

}

