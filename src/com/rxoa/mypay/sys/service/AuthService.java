package com.rxoa.mypay.sys.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.rxoa.mypay.base.security.PasswordMgr;
import com.rxoa.mypay.db.po.SysUser;
import com.rxoa.mypay.db.service.in.ISysUserService;
import com.rxoa.mypay.sys.auth.SessionMgr;
import com.rxoa.mypay.sys.entity.AuthUserEntity;
import com.rxoa.mypay.sys.vo.UserLoginVo;

@Service("authService")
public class AuthService {
	@Resource(name="sysUserService")
	private ISysUserService sysUserService;
	@Resource(name="orgService")
	private OrgService orgService;
	
	public static enum AuthCode{
		LOGIN_WRONGPWD,
		LOGIN_USER_NOTFOUND,
		LOGIN_SUCCESS,
		LOGIN_USERLOCKED,
		LOGIN_IPFORBID,
		LOGIN_ERROR,
		
		LOGOUT_SUCCESS,
		LOGOUT_ERROR
	}
	public AuthCode login(HttpServletRequest req,HttpSession session,UserLoginVo user){
		try{
			String encpwd = PasswordMgr.encrypt(user.getUserId(), user.getUserPwd());
			String conhql = " and uid = '"+user.getUserId()+"' and upwd = '"+encpwd+"'";
			System.out.println(encpwd);
			//String conhql = " and uid = '"+user.getUserId()+"'";
			SysUser sysuser = sysUserService.findOneByCondition(conhql);
			
			if(sysuser!=null&&!sysuser.equals(null)){
				AuthUserEntity authUser = new AuthUserEntity();
				String utype = orgService.getUserType(sysuser.getUorgid());
				if(utype.equals("1")){
					String tnode = orgService.getManageOrgId(sysuser.getUorgid());
					authUser.setTopOrgId(tnode);
					authUser.setvOrgId(tnode);
				}else if(utype.equals("2")){
					String tnode = orgService.getOemHqOrgId(sysuser.getUorgid());
					authUser.setTopOrgId(tnode);
					authUser.setvOrgId(tnode);
				}else if(utype.equals("3")){
					String tnode = orgService.getAgencyOrgId(sysuser.getUorgid());
					String vnode = orgService.getAgencyOrgId(sysuser.getUorgid());
					authUser.setTopOrgId(tnode);
					authUser.setvOrgId(vnode);
				}
				sysuser.setUtype(utype);
				SessionMgr.setSession(req, user, sysuser,authUser,session);
				return AuthCode.LOGIN_SUCCESS;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return AuthCode.LOGIN_ERROR;
	}
	public AuthCode logout(HttpSession session){
		try{
			SessionMgr.clearSession(session);
			return AuthCode.LOGOUT_SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
		}
		return AuthCode.LOGOUT_ERROR;
	}
	public boolean isManageOrg(HttpServletRequest req){
		try{
			String type = orgService.getUserType(SessionMgr.getCurSession(req).getOrgId());
			if(type.equals("1")) return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
