package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.IMbilSmsRecordDao;
import com.rxoa.mypay.db.po.MbilSmsRecord;

/**
 * mbil_sms_record DAO操作类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Repository("mbilSmsRecordDao")
public class MbilSmsRecordDao extends AbstractHibernateDao<MbilSmsRecord> implements IMbilSmsRecordDao {
	public MbilSmsRecordDao() {
		super();
		setClazz(MbilSmsRecord.class);
	}

}

