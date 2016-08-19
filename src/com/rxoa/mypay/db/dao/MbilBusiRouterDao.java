package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilBusiRouterDao;
import com.rxoa.mypay.db.po.MbilBusiRouter;

/**
 * mbil_busi_router DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilBusiRouterDao")
public class MbilBusiRouterDao extends AbstractHibernateDao<MbilBusiRouter> implements IMbilBusiRouterDao {
	public MbilBusiRouterDao() {
		super();
		setClazz(MbilBusiRouter.class);
	}

}

