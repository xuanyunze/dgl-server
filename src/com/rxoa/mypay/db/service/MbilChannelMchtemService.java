package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilChannelMchtemService;
import com.rxoa.mypay.db.dao.in.IMbilChannelMchtemDao;
import com.rxoa.mypay.db.po.MbilChannelMchtem;

/**
 * mbil_channel_mchtem Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilChannelMchtemService")
public class MbilChannelMchtemService extends AbstractService<MbilChannelMchtem> implements IMbilChannelMchtemService {
	@Resource(name="mbilChannelMchtemDao")
	private IMbilChannelMchtemDao dao;

	public MbilChannelMchtemService() {
		super();
	}
	@Override
	protected IOperations<MbilChannelMchtem> getDao() {
		return this.dao;
	}

}

