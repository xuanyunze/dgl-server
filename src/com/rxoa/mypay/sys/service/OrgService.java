package com.rxoa.mypay.sys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rxoa.mypay.db.po.SysOrg;
import com.rxoa.mypay.db.service.in.ISysOrgService;
import com.rxoa.mypay.sys.combx.OrgTree;
import com.rxoa.mypay.sys.combx.OrgTreeEntity;
import com.rxoa.mypay.util.StringUtil;

@Service("orgService")
public class OrgService {
	@Resource(name="sysOrgService")
	private ISysOrgService mService;
	
	public OrgTreeEntity getTreeByTopNode(String level,String topNode){
		OrgTreeEntity entity = null;
		try{
			entity = OrgTree.getTree(topNode, level);
		}catch(Exception e){
			e.printStackTrace();
		}
		return entity;
	}
	
	public void getParentNode(){
		
	}
	public void getAllChildNode(){
		
	}
	public String getManageNode(String curNode,String mType){
		String topOrgid = "";
		try{
			SysOrg curOrg = mService.findOneByCondition(" and oid='"+curNode+"'");
			if(curOrg!=null){
				if(!curOrg.getOtype().equals(mType)){
					topOrgid = getManageNode(curOrg.getOparentid(),mType);
				}else{
					topOrgid = curOrg.getOid();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return topOrgid;
	}
	public String getManageOrgId(String curNode){
		return getManageNode(curNode,"1");
	}
	public String getOemHqOrgId(String curNode){
		return getManageNode(curNode,"3");
	}
	public String getAgencyOrgId(String curNode){
		return getManageNode(curNode,"5");
	}
	public String getUserType(String orgid){
		try{
			SysOrg curOrg = mService.findOneByCondition(" and oid='"+orgid+"'");
			if(curOrg!=null){
				String orgtype = curOrg.getOtype();
				if(orgtype.equals("1")||orgtype.equals("2")){
					return "1";
				}else if(orgtype.equals("3")||orgtype.equals("4")){
					return "2";
				}else if(orgtype.equals("5")||orgtype.equals("6")){
					return "3";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public String genOrgId(String parentid){
		try{
			List<SysOrg> list = mService.queryHql("from SysOrg where oparentid = '"+parentid+"' order by creTime desc,oid desc");
			if(list.size()>0){
				String maxid = list.get(0).getOid();
				String snum = maxid.substring(parentid.length());
				if(snum.equals("00")){
					snum = "A0";
				}
				String nnum = StringUtil.inttod36(StringUtil.d36toint(snum)+1);
				return parentid+nnum;
			}else{
				return parentid+"10";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public boolean isSubOrg(String parid,String oid){
		try{
			if(StringUtil.isDbNull(parid)||StringUtil.isDbNull(oid)) return false;
			if(parid.equals(oid)) return true;
			SysOrg org = null,porg = null;
			do{
				org = mService.findOneByCondition(" and oid = '"+oid+"'");
				if(org!=null&&org.getOparentid().equals(parid)) return true;
				oid = org.getOparentid();
			}while(org!=null&&porg!=null&&porg.getOid()!=org.getOid());
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
