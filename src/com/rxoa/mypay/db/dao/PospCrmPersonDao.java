package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IPospCrmPersonDao;
import com.rxoa.mypay.db.po.PospCrmPerson;

/**
 * posp_crm_person DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("pospCrmPersonDao")
public class PospCrmPersonDao extends AbstractHibernateDao<PospCrmPerson> implements IPospCrmPersonDao {
	public PospCrmPersonDao() {
		super();
		setClazz(PospCrmPerson.class);
	}

}

