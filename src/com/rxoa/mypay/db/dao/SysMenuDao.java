package com.rxoa.mypay.db.dao;

import org.springframework.stereotype.Repository;

import com.rxoa.mypay.base.AbstractHibernateDao;
import com.rxoa.mypay.db.dao.in.ISysMenuDao;
import com.rxoa.mypay.db.po.SysMenu;

/**
 * sys_menu DAO操作类
 * Tue Apr 05 11:23:29 CST 2016 baiyu
 */ 

@Repository("sysMenuDao")
public class SysMenuDao extends AbstractHibernateDao<SysMenu> implements ISysMenuDao {
	public SysMenuDao() {
		super();
		setClazz(SysMenu.class);
	}

}

