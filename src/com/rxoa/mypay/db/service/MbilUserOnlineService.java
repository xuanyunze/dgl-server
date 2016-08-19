package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilUserOnlineService;
import com.rxoa.mypay.db.dao.in.IMbilUserOnlineDao;
import com.rxoa.mypay.db.po.MbilUserOnline;

/**
 * mbil_user_online Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilUserOnlineService")
public class MbilUserOnlineService extends AbstractService<MbilUserOnline> implements IMbilUserOnlineService {
	@Resource(name="mbilUserOnlineDao")
	private IMbilUserOnlineDao dao;

	public MbilUserOnlineService() {
		super();
	}
	@Override
	protected IOperations<MbilUserOnline> getDao() {
		return this.dao;
	}

}

