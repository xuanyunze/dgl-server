package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysUserOrgtreeTmpDao;
import com.rxoa.mypay.db.po.SysUserOrgtreeTmp;

/**
 * sys_user_orgtree_tmp DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysUserOrgtreeTmpDao")
public class SysUserOrgtreeTmpDao extends AbstractHibernateDao<SysUserOrgtreeTmp> implements ISysUserOrgtreeTmpDao {
	public SysUserOrgtreeTmpDao() {
		super();
		setClazz(SysUserOrgtreeTmp.class);
	}

}

