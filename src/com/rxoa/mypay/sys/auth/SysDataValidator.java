package com.rxoa.mypay.sys.auth;

import javax.servlet.http.HttpServletRequest;

import com.rxoa.mypay.base.security.DataValidResult;

public class SysDataValidator {
	
	public static DataValidResult doValidate(HttpServletRequest req,String vid,boolean isClear){
		return new DataValidResult();
	}
}
