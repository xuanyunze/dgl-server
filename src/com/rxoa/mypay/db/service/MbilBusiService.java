package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilBusiService;
import com.rxoa.mypay.db.dao.in.IMbilBusiDao;
import com.rxoa.mypay.db.po.MbilBusi;

/**
 * mbil_busi Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("mbilBusiService")
public class MbilBusiService extends AbstractService<MbilBusi> implements IMbilBusiService {
	@Resource(name="mbilBusiDao")
	private IMbilBusiDao dao;

	public MbilBusiService() {
		super();
	}
	@Override
	protected IOperations<MbilBusi> getDao() {
		return this.dao;
	}

}

