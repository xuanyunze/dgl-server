package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilWfRealnameService;
import com.rxoa.mypay.db.dao.in.IMbilWfRealnameDao;
import com.rxoa.mypay.db.po.MbilWfRealname;

/**
 * mbil_wf_realname Service服务类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Service("mbilWfRealnameService")
public class MbilWfRealnameService extends AbstractService<MbilWfRealname> implements IMbilWfRealnameService {
	@Resource(name="mbilWfRealnameDao")
	private IMbilWfRealnameDao dao;

	public MbilWfRealnameService() {
		super();
	}
	@Override
	protected IOperations<MbilWfRealname> getDao() {
		return this.dao;
	}

}

