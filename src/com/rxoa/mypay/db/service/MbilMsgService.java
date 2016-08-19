package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilMsgService;
import com.rxoa.mypay.db.dao.in.IMbilMsgDao;
import com.rxoa.mypay.db.po.MbilMsg;

/**
 * mbil_msg Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilMsgService")
public class MbilMsgService extends AbstractService<MbilMsg> implements IMbilMsgService {
	@Resource(name="mbilMsgDao")
	private IMbilMsgDao dao;

	public MbilMsgService() {
		super();
	}
	@Override
	protected IOperations<MbilMsg> getDao() {
		return this.dao;
	}

}

