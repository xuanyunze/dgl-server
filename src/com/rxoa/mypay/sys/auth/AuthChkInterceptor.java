package com.rxoa.mypay.sys.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import com.rxoa.mypay.base.auth.AuthResultEnum;
import com.rxoa.mypay.base.auth.SessionPermission;
import com.rxoa.mypay.base.interceptor.AuthCheckInterceptor;

public class AuthChkInterceptor extends AuthCheckInterceptor{
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {  
        
        //处理Permission Annotation，实现方法级权限控制  
        HandlerMethod method = (HandlerMethod)handler;  
        //AuthPermission authPermission = method.getMethodAnnotation(AuthPermission.class);  
        SessionPermission sessionPermission = method.getMethodAnnotation(SessionPermission.class); 
        //如果为空则表示该方法不需要进行登陆  
        if (sessionPermission == null) {  
            return true;  
        }
        
        //验证是否具已登陆
        AuthResultEnum auth = SysAuthChecker.authCheck(request);
        if(auth.equals(AuthResultEnum.CHECK_AUTH_SUCCESS)){
        	return true;
        }else if(auth.equals(AuthResultEnum.CHECK_SESSION_NEEDLOGIN)){
            response.sendRedirect(request.getContextPath()+"/auth/login");  
            return false;  
        }else if(auth.equals(AuthResultEnum.CHECK_SESSION_TIMEOUT)){
        	 
        }
        return true;
    }
}
