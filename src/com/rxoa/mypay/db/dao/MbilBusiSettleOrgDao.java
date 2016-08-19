package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilBusiSettleOrgDao;
import com.rxoa.mypay.db.po.MbilBusiSettleOrg;

/**
 * mbil_busi_settle_org DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilBusiSettleOrgDao")
public class MbilBusiSettleOrgDao extends AbstractHibernateDao<MbilBusiSettleOrg> implements IMbilBusiSettleOrgDao {
	public MbilBusiSettleOrgDao() {
		super();
		setClazz(MbilBusiSettleOrg.class);
	}

}

