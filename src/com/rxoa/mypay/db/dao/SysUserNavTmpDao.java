package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysUserNavTmpDao;
import com.rxoa.mypay.db.po.SysUserNavTmp;

/**
 * sys_user_nav_tmp DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysUserNavTmpDao")
public class SysUserNavTmpDao extends AbstractHibernateDao<SysUserNavTmp> implements ISysUserNavTmpDao {
	public SysUserNavTmpDao() {
		super();
		setClazz(SysUserNavTmp.class);
	}

}

