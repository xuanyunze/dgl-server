package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilAreacodeService;
import com.rxoa.mypay.db.dao.in.IMbilAreacodeDao;
import com.rxoa.mypay.db.po.MbilAreacode;

/**
 * mbil_areacode Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("mbilAreacodeService")
public class MbilAreacodeService extends AbstractService<MbilAreacode> implements IMbilAreacodeService {
	@Resource(name="mbilAreacodeDao")
	private IMbilAreacodeDao dao;

	public MbilAreacodeService() {
		super();
	}
	@Override
	protected IOperations<MbilAreacode> getDao() {
		return this.dao;
	}

}

