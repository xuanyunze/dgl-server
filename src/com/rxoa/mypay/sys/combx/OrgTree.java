package com.rxoa.mypay.sys.combx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import com.rxoa.mypay.db.po.SysOrg;
import com.rxoa.mypay.db.query.HibQueryMgr;
import com.rxoa.mypay.db.query.QueryContext;

public class OrgTree {
	
	public static OrgTreeEntity getTree(String topNodeId,String level){
		OrgTree tree = new OrgTree();
		OrgTreeEntity entity = tree.getNodeById(topNodeId);
		try{
			if(level.equals("all")){
				return tree.getAllSubNode(entity);
			}else if(level.equals("direct")){
				return tree.getDirectSubNode(entity);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return entity;
	}
	public OrgTreeEntity getAllSubNode(OrgTreeEntity entity){
		List<OrgTreeEntity> list = new ArrayList<OrgTreeEntity>();
		QueryContext qContext = HibQueryMgr.getQueryContext();
		try{
			String hql = " from SysOrg where o_parentid = '"+entity.getOrgId()+"'";
			Query query = qContext.getHibSession().createQuery(hql);
			Iterator<?> it = query.list().iterator();
			while(it.hasNext()){
				OrgTreeEntity nentity = new OrgTreeEntity().initFromSysOrg((SysOrg)it.next());
				getAllSubNode(nentity);
				list.add(nentity);
			}
			entity.setSubNode(list);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			qContext.closeHibSession();
		}
		return entity;
	}
	public OrgTreeEntity getDirectSubNode(OrgTreeEntity entity){
		List<OrgTreeEntity> list = new ArrayList<OrgTreeEntity>();
		QueryContext qContext = HibQueryMgr.getQueryContext();
		try{
			String hql = " from SysOrg where o_parentid = '"+entity.getOrgId()+"'";
			Query query = qContext.getHibSession().createQuery(hql);
			Iterator<?> it = query.list().iterator();
			while(it.hasNext()){
				OrgTreeEntity nentity = new OrgTreeEntity().initFromSysOrg((SysOrg)it.next());
				list.add(nentity);
			}
			entity.setSubNode(list);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			qContext.closeHibSession();
		}
		return entity;
	}
	public OrgTreeEntity getNodeById(String oid){
		OrgTreeEntity tree = new OrgTreeEntity();
		QueryContext qContext = HibQueryMgr.getQueryContext();
		try{
			String hql = " from SysOrg where o_id = '"+oid+"'";
			Query query = qContext.getHibSession().createQuery(hql);
			if(query.list().size() > 0){
				tree.initFromSysOrg((SysOrg)query.list().get(0));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			qContext.closeHibSession();
		}
		return tree;
	}
	public static List<OrgTreeEntity> expandTree(OrgTreeEntity srcTree,List<OrgTreeEntity> destree){
		try{
			if(destree==null){
				destree = new ArrayList<OrgTreeEntity>();
			}
			OrgTreeEntity newNode = new OrgTreeEntity();
			newNode.setOrgId(srcTree.getOrgId());
			newNode.setOrgName(srcTree.getOrgName());
			newNode.setOrgNameBref(srcTree.getOrgNameBref());
			newNode.setParentId(srcTree.getParentId());
			destree.add(newNode);
			if(!(srcTree.getSubNode()==null||srcTree.getSubNode().size()==0)){
				Iterator<OrgTreeEntity> it = srcTree.getSubNode().iterator();
				while(it.hasNext()){
					expandTree(it.next(),destree);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return destree;
	}
}
