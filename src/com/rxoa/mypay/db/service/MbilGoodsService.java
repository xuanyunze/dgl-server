package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilGoodsService;
import com.rxoa.mypay.db.dao.in.IMbilGoodsDao;
import com.rxoa.mypay.db.po.MbilGoods;

/**
 * mbil_goods Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilGoodsService")
public class MbilGoodsService extends AbstractService<MbilGoods> implements IMbilGoodsService {
	@Resource(name="mbilGoodsDao")
	private IMbilGoodsDao dao;

	public MbilGoodsService() {
		super();
	}
	@Override
	protected IOperations<MbilGoods> getDao() {
		return this.dao;
	}

}

