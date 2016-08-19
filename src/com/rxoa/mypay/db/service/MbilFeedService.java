package com.rxoa.mypay.db.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.rxoa.mypay.base.AbstractService;
import com.rxoa.mypay.base.IOperations;
import com.rxoa.mypay.db.service.in.IMbilFeedService;
import com.rxoa.mypay.db.dao.in.IMbilFeedDao;
import com.rxoa.mypay.db.po.MbilFeed;

/**
 * mbil_feed Service服务类
 * Tue Apr 05 11:23:28 CST 2016 baiyu
 */ 

@Service("mbilFeedService")
public class MbilFeedService extends AbstractService<MbilFeed> implements IMbilFeedService {
	@Resource(name="mbilFeedDao")
	private IMbilFeedDao dao;

	public MbilFeedService() {
		super();
	}
	@Override
	protected IOperations<MbilFeed> getDao() {
		return this.dao;
	}

}

