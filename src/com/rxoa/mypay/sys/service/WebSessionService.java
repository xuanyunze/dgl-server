package com.rxoa.mypay.sys.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.rxoa.mypay.base.security.WebSessionEntity;
import com.rxoa.mypay.sys.auth.SessionMgr;

@Service("webSessionService")
public class WebSessionService {
	
	public WebSessionEntity getWebSession(HttpServletRequest req){
		try{
			return SessionMgr.getWebSession(req);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
