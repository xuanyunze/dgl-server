package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilFeecodeService;
import com.rxoa.mypay.db.dao.in.IMbilFeecodeDao;
import com.rxoa.mypay.db.po.MbilFeecode;

/**
 * mbil_feecode Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilFeecodeService")
public class MbilFeecodeService extends AbstractService<MbilFeecode> implements IMbilFeecodeService {
	@Resource(name="mbilFeecodeDao")
	private IMbilFeecodeDao dao;

	public MbilFeecodeService() {
		super();
	}
	@Override
	protected IOperations<MbilFeecode> getDao() {
		return this.dao;
	}

}

