package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilAutosettleRongbaoDao;
import com.rxoa.mypay.db.po.MbilAutosettleRongbao;

/**
 * mbil_autosettle_rongbao DAO操作类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Repository("mbilAutosettleRongbaoDao")
public class MbilAutosettleRongbaoDao extends AbstractHibernateDao<MbilAutosettleRongbao> implements IMbilAutosettleRongbaoDao {
	public MbilAutosettleRongbaoDao() {
		super();
		setClazz(MbilAutosettleRongbao.class);
	}

}

