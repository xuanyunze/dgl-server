package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysUserOrgtreeDao;
import com.rxoa.mypay.db.po.SysUserOrgtree;

/**
 * sys_user_orgtree DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysUserOrgtreeDao")
public class SysUserOrgtreeDao extends AbstractHibernateDao<SysUserOrgtree> implements ISysUserOrgtreeDao {
	public SysUserOrgtreeDao() {
		super();
		setClazz(SysUserOrgtree.class);
	}

}

