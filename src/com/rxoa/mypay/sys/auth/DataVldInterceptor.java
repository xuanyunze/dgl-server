package com.rxoa.mypay.sys.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;

import com.rxoa.mypay.base.interceptor.DataValidInterceptor;
import com.rxoa.mypay.base.security.DataValidResult;
import com.rxoa.mypay.base.security.DataValidator;

public class DataVldInterceptor extends DataValidInterceptor{
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {  
        
        //处理DataValidator Annotation，实现方法级权限控制  
        HandlerMethod method = (HandlerMethod)handler;  
        DataValidator validator = method.getMethodAnnotation(DataValidator.class);  
          
        //如果为空则表示该方法不需要验证数据
        if (validator == null) {  
            return true;  
        }  
        System.out.println("开始验证数据");
        //验证请求数据是否合法，及强制清理数据
        DataValidResult result = SysDataValidator.doValidate(request, validator.value(), validator.clear());
        if(result.getBadNum()>0&&!result.isLetGo()){
        	System.out.println("数据验证失败");
        	return false;
        }
        System.out.println("数据验证通过");
        return true;
    } 
}
