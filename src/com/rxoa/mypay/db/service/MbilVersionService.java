package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilVersionService;
import com.rxoa.mypay.db.dao.in.IMbilVersionDao;
import com.rxoa.mypay.db.po.MbilVersion;

/**
 * mbil_version Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilVersionService")
public class MbilVersionService extends AbstractService<MbilVersion> implements IMbilVersionService {
	@Resource(name="mbilVersionDao")
	private IMbilVersionDao dao;

	public MbilVersionService() {
		super();
	}
	@Override
	protected IOperations<MbilVersion> getDao() {
		return this.dao;
	}

}

