package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilCardService;
import com.rxoa.mypay.db.dao.in.IMbilCardDao;
import com.rxoa.mypay.db.po.MbilCard;

/**
 * mbil_card Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilCardService")
public class MbilCardService extends AbstractService<MbilCard> implements IMbilCardService {
	@Resource(name="mbilCardDao")
	private IMbilCardDao dao;

	public MbilCardService() {
		super();
	}
	@Override
	protected IOperations<MbilCard> getDao() {
		return this.dao;
	}

}

