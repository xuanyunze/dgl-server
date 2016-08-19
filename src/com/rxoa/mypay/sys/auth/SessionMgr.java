package com.rxoa.mypay.sys.auth;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.rxoa.mypay.base.auth.AuthResultEnum;
import com.rxoa.mypay.base.security.SessionEntity;
import com.rxoa.mypay.base.security.WebSessionEntity;
import com.rxoa.mypay.base.util.MD5Util;
import com.rxoa.mypay.db.po.SysUser;
import com.rxoa.mypay.sys.config.SysConfig;
import com.rxoa.mypay.sys.entity.AuthUserEntity;
import com.rxoa.mypay.sys.vo.UserLoginVo;

public class SessionMgr {
	private static String createToken(String userid,Date logintime){
		try{
			return MD5Util.encrypt(MD5Util.encrypt(userid)+logintime);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	private static boolean checkToken(String token,String userid,Date logintime){
		try{
			if(createToken(userid,logintime).equals(token)){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public static void setSession(HttpServletRequest req,UserLoginVo user,SysUser sysuser,AuthUserEntity authUser,HttpSession session){
		try{
			Date logintime = new Date();
			SessionEntity entity = new SessionEntity();
			String token = createToken(user.getUserId(),logintime);
			
			entity.setUserId(sysuser.getUid());
			entity.setUserName(sysuser.getUname());
			entity.setUserRoleid(sysuser.getUroleid());
			entity.setUserType(sysuser.getUtype());
			entity.setOrgId(sysuser.getUorgid());
			entity.setTopOrgId(authUser.getTopOrgId());
			entity.setVorgId(authUser.getvOrgId());
			entity.setLoginTime(logintime);
			entity.setClientIp("");
			entity.setClientLocal("");
			entity.setClientKey("");
			entity.setToken(token);
			
			session.setAttribute("vsession", entity);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static boolean clearSession(HttpSession session){
		try{
			session.removeAttribute("vsession");
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public static AuthResultEnum checkSession(HttpServletRequest req){
		try{
			if(req.getSession().getAttribute("vsession")==null){
				return AuthResultEnum.CHECK_SESSION_NEEDLOGIN;
			}else{
				SessionEntity entity = (SessionEntity) req.getSession().getAttribute("vsession");
				if(entity.getUserId()==null||entity.getUserId().equals("")
						||entity.getLoginTime()==null||entity.getToken()==null||entity.getToken().equals("")){
					return AuthResultEnum.CHECK_SESSION_NEEDLOGIN;
				}else if(!checkToken(entity.getToken(),entity.getUserId(),entity.getLoginTime())){
					return AuthResultEnum.CHECK_SESSION_TOKENVALID;
				}else if(new Date().getTime() - entity.getLoginTime().getTime() > SysConfig.session_timeout){
					return AuthResultEnum.CHECK_SESSION_TIMEOUT;
				}else{
					return AuthResultEnum.CHECK_SESSION_SUCCESS;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return AuthResultEnum.CHECK_SESSION_ERROR;
	}
	public static SessionEntity getCurSession(HttpServletRequest req){
		try{
			return (SessionEntity) req.getSession().getAttribute("vsession");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new SessionEntity();
	}
	public static WebSessionEntity getWebSession(HttpServletRequest req){
		try{
			SessionEntity session = SessionMgr.getCurSession(req);
			WebSessionEntity websession = new WebSessionEntity();
			websession.setUserId(session.getUserId());
			websession.setUserName(session.getUserName());
			websession.setOrgId(session.getOrgId());
			websession.setUserType(session.getUserType());
			websession.setLoginTime(session.getLoginTime().toString());
			return websession;
		}catch(Exception e){
			e.printStackTrace();
		}
		return new WebSessionEntity();
	}
}
