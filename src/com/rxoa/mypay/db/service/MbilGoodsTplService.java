package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilGoodsTplService;
import com.rxoa.mypay.db.dao.in.IMbilGoodsTplDao;
import com.rxoa.mypay.db.po.MbilGoodsTpl;

/**
 * mbil_goods_tpl Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilGoodsTplService")
public class MbilGoodsTplService extends AbstractService<MbilGoodsTpl> implements IMbilGoodsTplService {
	@Resource(name="mbilGoodsTplDao")
	private IMbilGoodsTplDao dao;

	public MbilGoodsTplService() {
		super();
	}
	@Override
	protected IOperations<MbilGoodsTpl> getDao() {
		return this.dao;
	}

}

