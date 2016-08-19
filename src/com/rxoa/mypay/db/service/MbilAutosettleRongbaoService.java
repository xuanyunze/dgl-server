package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilAutosettleRongbaoService;
import com.rxoa.mypay.db.dao.in.IMbilAutosettleRongbaoDao;
import com.rxoa.mypay.db.po.MbilAutosettleRongbao;

/**
 * mbil_autosettle_rongbao Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("mbilAutosettleRongbaoService")
public class MbilAutosettleRongbaoService extends AbstractService<MbilAutosettleRongbao> implements IMbilAutosettleRongbaoService {
	@Resource(name="mbilAutosettleRongbaoDao")
	private IMbilAutosettleRongbaoDao dao;

	public MbilAutosettleRongbaoService() {
		super();
	}
	@Override
	protected IOperations<MbilAutosettleRongbao> getDao() {
		return this.dao;
	}

}

