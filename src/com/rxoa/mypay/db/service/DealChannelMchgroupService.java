package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IDealChannelMchgroupService;
import com.rxoa.mypay.db.dao.in.IDealChannelMchgroupDao;
import com.rxoa.mypay.db.po.DealChannelMchgroup;

/**
 * deal_channel_mchgroup Service服务类
 * Tue Apr 05 11:23:27 CST 2016 baiyu
 */ 

@Service("dealChannelMchgroupService")
public class DealChannelMchgroupService extends AbstractService<DealChannelMchgroup> implements IDealChannelMchgroupService {
	@Resource(name="dealChannelMchgroupDao")
	private IDealChannelMchgroupDao dao;

	public DealChannelMchgroupService() {
		super();
	}
	@Override
	protected IOperations<DealChannelMchgroup> getDao() {
		return this.dao;
	}

}

