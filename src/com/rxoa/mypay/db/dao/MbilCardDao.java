package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilCardDao;
import com.rxoa.mypay.db.po.MbilCard;

/**
 * mbil_card DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilCardDao")
public class MbilCardDao extends AbstractHibernateDao<MbilCard> implements IMbilCardDao {
	public MbilCardDao() {
		super();
		setClazz(MbilCard.class);
	}

}

