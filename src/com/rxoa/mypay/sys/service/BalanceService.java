package com.rxoa.mypay.sys.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rxoa.mypay.db.query.HibQueryMgr;
import com.rxoa.mypay.sys.combx.OrgTree;
import com.rxoa.mypay.sys.combx.OrgTreeEntity;
import com.rxoa.mypay.sys.entity.ProfitQueryEntity;
import com.rxoa.mypay.sys.entity.ProfitReportEntity;

@Service("balanceService")
public class BalanceService {
	
	public List<ProfitReportEntity>getProfitByOrgtree(OrgTreeEntity tree,ProfitQueryEntity query){
		List<ProfitReportEntity> list = new ArrayList<ProfitReportEntity>();
		try{
			List<OrgTreeEntity> plaintree = OrgTree.expandTree(tree, null);
			Iterator<OrgTreeEntity> it = plaintree.iterator();
			
			while(it.hasNext()){
				ProfitReportEntity profit = HibQueryMgr.getQueryContext().getProfitByOrgEntity(it.next(), query);
				list.add(profit);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
}
