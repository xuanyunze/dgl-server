package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilGoodsTplDao;
import com.rxoa.mypay.db.po.MbilGoodsTpl;

/**
 * mbil_goods_tpl DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilGoodsTplDao")
public class MbilGoodsTplDao extends AbstractHibernateDao<MbilGoodsTpl> implements IMbilGoodsTplDao {
	public MbilGoodsTplDao() {
		super();
		setClazz(MbilGoodsTpl.class);
	}

}

