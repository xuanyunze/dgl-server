package com.rxoa.mypay.sys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rxoa.mypay.db.service.in.ISysOrgService;
import com.rxoa.mypay.db.service.in.ISysUserService;

@Service("userService")
public class UserService {
	@Resource(name="sysUserService")
	private ISysUserService sysUserService;
	@Resource(name="sysOrgService")
	private ISysOrgService sysOrgService;
	
	public void getUserByMchId(){
		
	}
}
