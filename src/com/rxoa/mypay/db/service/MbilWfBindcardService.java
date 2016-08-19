package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilWfBindcardService;
import com.rxoa.mypay.db.dao.in.IMbilWfBindcardDao;
import com.rxoa.mypay.db.po.MbilWfBindcard;

/**
 * mbil_wf_bindcard Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilWfBindcardService")
public class MbilWfBindcardService extends AbstractService<MbilWfBindcard> implements IMbilWfBindcardService {
	@Resource(name="mbilWfBindcardDao")
	private IMbilWfBindcardDao dao;

	public MbilWfBindcardService() {
		super();
	}
	@Override
	protected IOperations<MbilWfBindcard> getDao() {
		return this.dao;
	}

}

