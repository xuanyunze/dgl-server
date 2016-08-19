package com.rxoa.mypay.sys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rxoa.mypay.db.service.in.IMbilUserService;
import com.rxoa.mypay.db.service.in.IMbilWfRealnameService;

@Service("wfService")
public class WfService {
	@Resource(name="mbilWfRealnameService")
	private IMbilWfRealnameService wfService;
	@Resource(name="mbilUserService")
	private IMbilUserService userService;
	
	
}
