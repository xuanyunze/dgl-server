package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilBusiRouterService;
import com.rxoa.mypay.db.dao.in.IMbilBusiRouterDao;
import com.rxoa.mypay.db.po.MbilBusiRouter;

/**
 * mbil_busi_router Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilBusiRouterService")
public class MbilBusiRouterService extends AbstractService<MbilBusiRouter> implements IMbilBusiRouterService {
	@Resource(name="mbilBusiRouterDao")
	private IMbilBusiRouterDao dao;

	public MbilBusiRouterService() {
		super();
	}
	@Override
	protected IOperations<MbilBusiRouter> getDao() {
		return this.dao;
	}

}

