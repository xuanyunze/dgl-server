package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilBusiFeeOrgDao;
import com.rxoa.mypay.db.po.MbilBusiFeeOrg;

/**
 * mbil_busi_fee_org DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("mbilBusiFeeOrgDao")
public class MbilBusiFeeOrgDao extends AbstractHibernateDao<MbilBusiFeeOrg> implements IMbilBusiFeeOrgDao {
	public MbilBusiFeeOrgDao() {
		super();
		setClazz(MbilBusiFeeOrg.class);
	}

}

