package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilGoodsDao;
import com.rxoa.mypay.db.po.MbilGoods;

/**
 * mbil_goods DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilGoodsDao")
public class MbilGoodsDao extends AbstractHibernateDao<MbilGoods> implements IMbilGoodsDao {
	public MbilGoodsDao() {
		super();
		setClazz(MbilGoods.class);
	}

}

