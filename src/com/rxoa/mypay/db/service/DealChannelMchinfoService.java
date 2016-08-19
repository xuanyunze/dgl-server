package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDealChannelMchinfoService;
import com.rxoa.mypay.db.dao.in.IDealChannelMchinfoDao;
import com.rxoa.mypay.db.po.DealChannelMchinfo;

/**
 * deal_channel_mchinfo Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("dealChannelMchinfoService")
public class DealChannelMchinfoService extends AbstractService<DealChannelMchinfo> implements IDealChannelMchinfoService {
	@Resource(name="dealChannelMchinfoDao")
	private IDealChannelMchinfoDao dao;

	public DealChannelMchinfoService() {
		super();
	}
	@Override
	protected IOperations<DealChannelMchinfo> getDao() {
		return this.dao;
	}

}

