package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilChannelService;
import com.rxoa.mypay.db.dao.in.IMbilChannelDao;
import com.rxoa.mypay.db.po.MbilChannel;

/**
 * mbil_channel Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilChannelService")
public class MbilChannelService extends AbstractService<MbilChannel> implements IMbilChannelService {
	@Resource(name="mbilChannelDao")
	private IMbilChannelDao dao;

	public MbilChannelService() {
		super();
	}
	@Override
	protected IOperations<MbilChannel> getDao() {
		return this.dao;
	}

}

