package com.rxoa.mypay.db.query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.rxoa.mypay.db.po.DealChannelMcc;
import com.rxoa.mypay.db.po.DealTrans;
import com.rxoa.mypay.db.po.MbilBusiFeeOrg;
import com.rxoa.mypay.db.po.MbilBusiSettleOrg;
import com.rxoa.mypay.db.po.MbilCard;
import com.rxoa.mypay.db.po.MbilDevice;
import com.rxoa.mypay.db.po.MbilFeecode;
import com.rxoa.mypay.db.po.MbilOrderReceivemoney;
import com.rxoa.mypay.db.po.MbilOrderTakemoney;
import com.rxoa.mypay.db.po.MbilSettleLog;
import com.rxoa.mypay.db.po.MbilSettlecate;
import com.rxoa.mypay.db.po.MbilUser;
import com.rxoa.mypay.db.po.PospCrmEnterprise;
import com.rxoa.mypay.db.po.PospCrmPerson;
import com.rxoa.mypay.db.po.PospCrmStudio;
import com.rxoa.mypay.db.po.SysOrg;
import com.rxoa.mypay.sys.combx.OrgTreeEntity;
import com.rxoa.mypay.sys.entity.ProfitQueryEntity;
import com.rxoa.mypay.sys.entity.ProfitReportEntity;
import com.rxoa.mypay.sys.entity.ReportQueryEntity;
import com.rxoa.mypay.sys.vo.BenefitEntityVo;
import com.rxoa.mypay.sys.vo.DevicelistRespVo;
import com.rxoa.mypay.sys.vo.MbilUserlistRespVo;
import com.rxoa.mypay.sys.vo.OrderlistRespVo;
import com.rxoa.mypay.sys.vo.OrglistRespVo;
import com.rxoa.mypay.sys.vo.TakemoneylistRespVo;
import com.rxoa.mypay.util.DateUtil;
import com.rxoa.mypay.util.StringUtil;

@Repository("queryMysql")
public class QueryMysql extends QueryContext{
	private Logger logger = Logger.getLogger(getClass());
	
	@Override
	public void getUserInfo() {
		// TODO Auto-generated method stub
	//	String sql = "select * from tbluser";
		
		//SQLQuery sqlQuery = getHibSession().createSQLQuery(sql);
		//sqlQuery.addEntity(TblUser.class);
		//@SuppressWarnings("unchecked")
		//List<TblUser> list = sqlQuery.list();
		//for(int i=0;i<list.size();i++){
			//System.out.println("ppppp=="+list.get(i).getName());
		//}
	}
	
	@Override
	public boolean getResourceCheck(String userid,String srcid,String usetype){
		try{
			String sql = "select resource.re_id as vcount from sys_resource as resource "
					+ "left join sys_resource_usetype as usetype on resource.re_id = usetype.rt_resourceid "
					+ "left join sys_role_resource as roleresource on resource.re_id = roleresource.rr_resourceid "
					+ "left join sys_user_role as userrole on roleresource.rr_roleid = userrole.ur_roleid "
					+ "where userrole.ur_uid = '"+userid+"' "
					+ "and resource.re_code = '"+srcid+"' "
					+ "and roleresource.rr_usetype = '"+usetype+"' "
					+ "order by usetype.rt_level";
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql);
			if(sqlQuery.list().size()>0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return false;
	}
	
	@Override
	public ProfitReportEntity getProfitByOrgEntity(OrgTreeEntity org,ProfitQueryEntity query){
		ProfitReportEntity profit = new ProfitReportEntity();
		try{
			String sql = "SELECT count(*) as count,ifnull(sum(dp_value),0) as sum FROM deal_trans_profit where dp_orgid='"+org.getOrgId()+"' and dp_transorgid='"+org.getOrgId()+"' and dp_transtime>='"+query.getStartDate()+"' and dp_transtime<='"+query.getEndDate()+"' "
					+ "union all SELECT count(*) as count,ifnull(sum(dp_value),0) as sum FROM deal_trans_profit where dp_orgid='"+org.getOrgId()+"' and dp_transorgid!='"+org.getOrgId()+"' and dp_transtime>='"+query.getStartDate()+"' and dp_transtime<='"+query.getEndDate()+"'";
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql);
			System.out.println(sql);
			List<?> vlist = sqlQuery.list();
			Iterator<?> it = vlist.iterator();
			
			profit.setOrgId(org.getOrgId());
			profit.setOrgName(org.getOrgName());
			
			Object[] obj = (Object[])it.next();
			profit.setSelfFeeCount(obj[0].toString());
			profit.setSelfFee(obj[1].toString());
			obj = (Object[])it.next();
			profit.setChildFeeCount(obj[0].toString());
			profit.setChildFee(obj[1].toString());
			profit.setTotalFeeCount((Integer.parseInt(profit.getSelfFeeCount())+Integer.parseInt(profit.getChildFeeCount()))+"");
			profit.setTotalFee((Float.parseFloat(profit.getSelfFee())+Float.parseFloat(profit.getChildFee()))+"");
			
			profit.setSelfT0Count("0");
			profit.setSelfT0("0");
			profit.setChildT0Count("0");
			profit.setChildT0("0");
			profit.setTotalT0Count((Integer.parseInt(profit.getSelfT0Count())+Integer.parseInt(profit.getChildT0Count()))+"");
			profit.setTotalT0((Float.parseFloat(profit.getSelfT0())+Float.parseFloat(profit.getChildT0()))+"");
			profit.setTotalCount((Integer.parseInt(profit.getTotalFeeCount())+Integer.parseInt(profit.getTotalT0Count()))+"");
			profit.setTotalAll((Float.parseFloat(profit.getTotalFee())+Float.parseFloat(profit.getTotalT0()))+"");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return profit;
	}
	//交易对帐报表
	public List<Map<String,Object>> getTransReport(ReportQueryEntity query){
		List<Map<String,Object>> rlist = new ArrayList<Map<String,Object>>();
		try{
			String sql = "select fod.*,ftran.*,frfee.* from mbil_order_receivemoney as fod "
					+ "left join deal_trans as ftran on fod.od_flowid=ftran.tr_orderid "
					+ "left join deal_channel_mcc as frfee on frfee.cfee_channelid=ftran.tr_chlid and frfee.cfee_id=ftran.tr_rfeecode "
					+ "where (fod.od_stat='5' or fod.od_stat='7' or fod.od_stat='8' or fod.od_stat='9') "
					+ "and fod.stat='0' and date(fod.cre_time)>=date('"+query.getStartDate()+"') and date(fod.cre_time)<=date('"+query.getEndDate()+"') "
					+ "and (not isnull(ftran.tr_rfeecode))"
					+ "order by fod.cre_time desc";
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql)
					.addEntity("order",MbilOrderReceivemoney.class)
					.addEntity("tran",DealTrans.class)
					.addEntity("fee",DealChannelMcc.class);
			List<?> vlist = sqlQuery.list();
			Iterator<?> it = (Iterator<?>) vlist.iterator();
			while(it.hasNext()){
				Object[] objs = (Object[])it.next();
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("order", objs[0]);
				map.put("trans", objs[1]);
				map.put("mcc",objs[2]);
				rlist.add(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return rlist;
	}
	//清算对账报表-T0自动
	public List<Map<String,Object>> getSettleReport(ReportQueryEntity query){
		List<Map<String,Object>> rlist = new ArrayList<Map<String,Object>>();
		try{
			String sql = "select settle.* from mbil_settle_log as settle where "
					+ "date(settle.cre_time)>=date('"+query.getStartDate()+"') and date(settle.cre_time)<=date('"+query.getEndDate()+"') "
					+ "and (sl_stat='1' or sl_stat='3') and sl_sttype='1' and stat='0' "
					+ "order by settle.cre_time desc";
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql)
					.addEntity("settle",MbilSettleLog.class);
			List<?> vlist = sqlQuery.list();
			Iterator<?> it = (Iterator<?>) vlist.iterator();
			while(it.hasNext()){
				Object obj = it.next();
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("settle", obj);
				rlist.add(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return rlist;
	}
	//清算对账报表-T0自动失败
	public List<Map<String,Object>> getSettlefailReport(ReportQueryEntity query){
		List<Map<String,Object>> rlist = new ArrayList<Map<String,Object>>();
		try{
			String sql = "select settle.*,card.* from mbil_settle_log as settle left join mbil_card as card on settle.sl_uid = card.cd_uid where "
					+ "card.cd_ismaincard='1' and card.cd_stat='1' "
					+ "and date(settle.cre_time)>=date('"+query.getStartDate()+"') and date(settle.cre_time)<=date('"+query.getEndDate()+"') "
					+ "and (settle.sl_stat='4' or settle.sl_querycount>720) and settle.sl_sttype='1' and settle.stat='0' "
					+ "order by settle.cre_time desc";
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql)
					.addEntity("settle",MbilSettleLog.class)
					.addEntity("card",MbilCard.class);
			List<?> vlist = sqlQuery.list();
			Iterator<?> it = (Iterator<?>) vlist.iterator();
			while(it.hasNext()){
				Object[] obj = (Object[]) it.next();
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("settle", obj[0]);
				map.put("card",obj[1]);
				rlist.add(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return rlist;
	}
	//清算对账报表-非自动
	public List<Map<String,Object>> getHSettleReport(ReportQueryEntity query){
		List<Map<String,Object>> rlist = new ArrayList<Map<String,Object>>();
		try{
			String sql = "select settle.* from mbil_settle_log as settle where "
					+ "date(settle.cre_time)>=date('"+query.getStartDate()+"') and date(settle.cre_time)<=date('"+query.getEndDate()+"') "
					+ "and sl_sttype='0' and stat='0' "
					+ "order by settle.cre_time desc";
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql)
					.addEntity("settle",MbilSettleLog.class);
			List<?> vlist = sqlQuery.list();
			Iterator<?> it = (Iterator<?>) vlist.iterator();
			while(it.hasNext()){
				Object obj = it.next();
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("settle", obj);
				rlist.add(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return rlist;
	}
	//获取部门分润配置-按部门
	public Map<String,Object> getBusiConfig(){
		Map<String,Object> resmap = new HashMap<String,Object>();
		try{
			String feesql = "select * from mbil_feecode where stat = 0";
			SQLQuery feesqlQuery = getHibSession().createSQLQuery(feesql)
					.addEntity("fee",MbilFeecode.class);
			List<?> vlist = feesqlQuery.list();
			Iterator<?> it = vlist.iterator();
			while(it.hasNext()){
				MbilFeecode obj = (MbilFeecode) it.next();
				resmap.put("fee_"+obj.getFcId(), obj);
			}
			
			String settlesql = "select * from mbil_settlecate where stat = 0";
			SQLQuery settlesqlQuery = getHibSession().createSQLQuery(settlesql)
					.addEntity("settle",MbilSettlecate.class);
			List<?> svlist = settlesqlQuery.list();
			Iterator<?> sit = svlist.iterator();
			while(sit.hasNext()){
				MbilSettlecate vobj = (MbilSettlecate) sit.next();
				resmap.put("settle_"+vobj.getScId(), vobj);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return resmap;
	}
	//获取部门分润配置-按部门
	public Map<String,Object> getOrgBusiConfig(String oid){
		Map<String,Object> resmap = new HashMap<String,Object>();
		try{
			String feesql = "select * from mbil_busi_fee_org where bsof_oid='"+oid+"' and stat=0";
			SQLQuery feesqlQuery = getHibSession().createSQLQuery(feesql)
					.addEntity("fee",MbilBusiFeeOrg.class);
			List<?> vlist = feesqlQuery.list();
			Iterator<?> it = vlist.iterator();
			while(it.hasNext()){
				MbilBusiFeeOrg obj = (MbilBusiFeeOrg) it.next();
				resmap.put("fee_"+obj.getBsofFeeid(), obj);
			}
			
			String settlesql = "select * from mbil_busi_settle_org where bsos_oid='"+oid+"' and stat=0";
			SQLQuery settlesqlQuery = getHibSession().createSQLQuery(settlesql)
					.addEntity("settle",MbilBusiSettleOrg.class);
			List<?> svlist = settlesqlQuery.list();
			Iterator<?> sit = svlist.iterator();
			while(sit.hasNext()){
				MbilBusiSettleOrg vobj = (MbilBusiSettleOrg) sit.next();
				resmap.put("settle_"+vobj.getBsosFeeid(), vobj);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return resmap;
	}
	//获取某个部门的分润信息-按部门
	public BenefitEntityVo getBenefitReport(ReportQueryEntity query,Map<String,Object> busiConfig,String oid,boolean useDiv){
		BenefitEntityVo benev = new BenefitEntityVo();
		try{
			Map<String,Object> orgBusi = getOrgBusiConfig(oid);
			String sql = "select morder.*,org.* from mbil_order_receivemoney as morder left join sys_org as org on org.o_id = morder.od_oid where find_in_set('"+oid+"',org.o_pathtrack) and morder.stat = '0' and (morder.od_stat='5' or morder.od_stat='7' or morder.od_stat='8' or morder.od_stat='9') and (morder.od_type='11' or morder.od_type='9') and date(morder.cre_time)>='"+query.getStartDate()+"' and date(morder.cre_time)<='"+query.getEndDate()+"'";
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql)
					.addEntity("order",MbilOrderReceivemoney.class);
			List<?> vlist = sqlQuery.list();
			Iterator<?> it = vlist.iterator();
			double div = 1D;
			int s0count = 0;int t1count = 0;int totalcount = 0;
			double s0value = 0D;double t1value = 0D;double totalvalue = 0D;
			double s0bene = 0D;double t1bene = 0D;double totalbene = 0D;
			while(it.hasNext()){
				MbilOrderReceivemoney order = (MbilOrderReceivemoney) it.next();
				MbilFeecode fee = (MbilFeecode) busiConfig.get("fee_"+order.getOdFeecode());
				MbilBusiFeeOrg ofee = (MbilBusiFeeOrg) orgBusi.get("fee_"+order.getOdFeecode());
				if(useDiv){div = ofee.getBsofDrate();}
				if(order.getOdType().equals("11")){
					s0count++;s0value+=order.getOdValue();
					s0bene+=computeBenefit(order.getOdValue(),fee.getFcIstop(),fee.getFcRate(),ofee.getBsofRate(),fee.getFcTopvalue(),ofee.getBsofToprate(),0D,div);
				}else if(order.getOdType().equals("9")){
					t1count++;t1value+=order.getOdValue();
					t1bene+=computeBenefit(order.getOdValue(),fee.getFcIstop(),fee.getFcRate(),ofee.getBsofRate(),fee.getFcTopvalue(),ofee.getBsofToprate(),0D,div);
				}
			}
			totalcount = s0count+t1count;
			totalvalue = s0value+t1value;
			totalbene = s0bene+t1bene;
			benev.setOid(oid);
			benev.setS0Count(s0count);
			benev.setS0Value(roundDown(s0value));
			benev.setS0Benefit(roundDown(s0bene));
			benev.setT1Count(t1count);
			benev.setT1Value(roundDown(t1value));
			benev.setT1Benefit(roundDown(t1bene));
			benev.setTotalCount(totalcount);
			benev.setTotalValue(roundDown(totalvalue));
			benev.setTotalBenefit(roundDown(totalbene));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return benev;
	}
	//计算分润函数；
	public Double computeBenefit(Double odValue,int istop,Double saleRate,Double pRate,Double saleTop,Double pTop,Double dropBene,Double div){
		Double bene = 0D;
		try{
			Double realFee = odValue*saleRate;
			System.out.println(odValue+"#"+realFee);
			if(istop==1&&realFee>saleTop) {bene = saleTop - pTop;System.out.println(odValue+"#top#"+bene);return bene*div;}
			System.out.println("salerate="+saleRate+",prate=="+pRate);
			bene = odValue*(saleRate-pRate);
			System.out.println(odValue+"#rate#"+bene);
			if(bene<dropBene){bene = 0.0D; return bene;}
			return bene*div;
		}catch(Exception e){
			e.printStackTrace();
		}
		return bene;
	}
	public String getOrgtrack(String oid){
		String strResult = null;
		try{
			String sql = "select group_concat(o_id) as path,group_concat(o_name) as names from(select * From sys_org as org where FIND_IN_SET(o_id, query_org_parents('"+oid+"')) order by o_id desc) as org";
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql).addScalar("path").addScalar("names");
			List<?> vlist = sqlQuery.list();
			Iterator<?> it = vlist.iterator();
			if(it.hasNext()){
				Object[] obj = (Object[]) it.next();
				String ids = obj[0].toString();
				String names = obj[1].toString();
				strResult = ids+"#*#"+names;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return strResult;
	}
	public String getDistributionInfo(String oid,String mccid){
		String strResult = "";
		try{
			String sql = "select * from(select * From sys_org as org where FIND_IN_SET(o_id, query_org_parents('"+oid+"')) order by o_id desc) as org"
					+ " left join posp_crm_enterprise as com on org.o_id = com.pcom_orgid and com.stat='0'"
					+ " left join posp_crm_person as per on org.o_id = per.pper_orgid and per.stat='0'"
					+ " left join posp_crm_studio as stu on org.o_id = stu.pstu_orgid and stu.stat='0'"
					+ " left join mbil_busi_fee_org as bfee on (bfee.bsof_oid = com.pcom_orgid or bfee.bsof_oid = per.pper_orgid or bfee.bsof_oid = stu.pstu_orgid) and bfee.bsof_feeid='"+mccid+"' and bfee.stat='0'"
					+ " left join mbil_feecode as fee on bfee.bsof_feeid=fee.fc_id";
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql)
					.addEntity("org",SysOrg.class)
					.addEntity("com",PospCrmEnterprise.class)
					.addEntity("per",PospCrmPerson.class)
					.addEntity("stu",PospCrmStudio.class)
					.addEntity("obusi",MbilBusiFeeOrg.class)
					.addEntity("busi",MbilFeecode.class);
			for(int i=0;i<sqlQuery.list().size();i++){
				Object[] objs = (Object[])sqlQuery.list().get(i);
				SysOrg org = (SysOrg) objs[0];
				PospCrmEnterprise com = (PospCrmEnterprise) objs[1];
				PospCrmPerson per = (PospCrmPerson) objs[2];
				PospCrmStudio stu = (PospCrmStudio) objs[3];
				MbilBusiFeeOrg ofee = (MbilBusiFeeOrg) objs[4];
				MbilFeecode bfee = (MbilFeecode) objs[5];
				if(ofee==null||bfee==null){
					logger.error("[查询TRACK失败]["+org.getOrelid()+"]");
					return null;
				}
				String orelform = org.getOrelform();
				String distrid = null,orgid=null;
				if(orelform.equals("1")){
					distrid = per.getPperId();
					orgid = per.getPperOrgid();
				}else if(orelform.equals("2")){
					distrid = com.getPcomId();
					orgid = com.getPcomOrgid();
				}else if(orelform.equals("3")){
					distrid = stu.getPstuId();
					orgid = stu.getPstuOrgid();
				}
				String defvalue = ofee.getBsofRate()+"";
				String topvalue = ofee.getBsofToprate()+"";
				String istop = ofee.getBsofIstop()+"";
				String salevalue = bfee.getFcRate()+"";
				String saleistop = bfee.getFcIstop()+"";
				String saletop = bfee.getFcTopvalue()+"";
						
				if(!StringUtil.isDbNull(distrid)&&!StringUtil.isDbNull(defvalue)&&!StringUtil.isDbNull(topvalue)){
					if(strResult.equals("")){
						strResult = orgid+"#"+orelform+"#"+distrid+"#"+defvalue+"#"+istop+"#"+topvalue+"#"+salevalue+"#"+saleistop+"#"+saletop;
					}else{
						strResult += ","+orgid+"#"+orelform+"#"+distrid+"#"+defvalue+"#"+istop+"#"+topvalue+"#"+salevalue+"#"+saleistop+"#"+saletop;
					}
				}else{
					logger.error("[查询TRACK失败][信息有误]"+org.getOid()+"]["+distrid+"]["+defvalue+"]["+topvalue+"]");
					return null;
				}
			}
			return strResult;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return null;
	}
	public String getTakemoneyDistrInfo(String oid,String settleid){
		String strResult = "";
		try{
			String sql = "select * from(select * From sys_org as org where FIND_IN_SET(o_id, query_org_parents('"+oid+"')) order by o_id desc) as org"
					+ " left join posp_crm_enterprise as com on org.o_id = com.pcom_orgid and com.stat='0'"
					+ " left join posp_crm_person as per on org.o_id = per.pper_orgid and per.stat='0'"
					+ " left join posp_crm_studio as stu on org.o_id = stu.pstu_orgid and stu.stat='0'"
					+ " left join mbil_busi_settle_org as bsettle on (bsettle.bsos_oid = com.pcom_orgid or bsettle.bsos_oid = per.pper_orgid or bsettle.bsos_oid = stu.pstu_orgid) and bsettle.bsos_feeid='"+settleid+"' and bsettle.stat='0'"
					+ " left join mbil_settlecate as settle on bsettle.bsos_feeid=settle.sc_id";
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql)
					.addEntity("org",SysOrg.class)
					.addEntity("com",PospCrmEnterprise.class)
					.addEntity("per",PospCrmPerson.class)
					.addEntity("stu",PospCrmStudio.class)
					.addEntity("obusi",MbilBusiSettleOrg.class)
					.addEntity("busi",MbilSettlecate.class);
					
			for(int i=0;i<sqlQuery.list().size();i++){
				Object[] objs = (Object[])sqlQuery.list().get(i);
				SysOrg org = (SysOrg) objs[0];
				PospCrmEnterprise com = (PospCrmEnterprise) objs[1];
				PospCrmPerson per = (PospCrmPerson) objs[2];
				PospCrmStudio stu = (PospCrmStudio) objs[3];
				MbilBusiSettleOrg osettle = (MbilBusiSettleOrg) objs[4];
				MbilSettlecate bsettle = (MbilSettlecate) objs[5];
				if(osettle==null||bsettle==null){return null;}
				String orelform = org.getOrelform();
				String distrid = null,orgid=null;
				if(orelform.equals("1")){
					distrid = per.getPperId();
					orgid = per.getPperOrgid();
				}else if(orelform.equals("2")){
					distrid = com.getPcomId();
					orgid = com.getPcomOrgid();
				}else if(orelform.equals("3")){
					distrid = stu.getPstuId();
					orgid = stu.getPstuOrgid();
				}
				String defvalue = osettle.getBsosRate()+"";
				String salevalue = bsettle.getScRate()+"";
				if(!StringUtil.isDbNull(distrid)&&!StringUtil.isDbNull(defvalue)){
					if(strResult.equals("")){
						strResult = orgid+"#"+orelform+"#"+distrid+"#"+defvalue+"#"+salevalue;
					}else{
						strResult += ","+orgid+"#"+orelform+"#"+distrid+"#"+defvalue+"#"+salevalue;
					}
				}else{
					return null;
				}
			}
			return strResult;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return null;
	}
	
	@Override
	public List<OrderlistRespVo> getOrderlist(String sql) {
		List<OrderlistRespVo> list = new ArrayList<OrderlistRespVo>();
		try{
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql)
					.addEntity("order",MbilOrderReceivemoney.class)
					.addEntity("tran",DealTrans.class)
					.addEntity("user",MbilUser.class);
			List<?> vlist = sqlQuery.list();
			Iterator<?> it = vlist.iterator();
			while(it.hasNext()){
				Object[] objs = (Object[]) it.next();
				MbilOrderReceivemoney order = (MbilOrderReceivemoney) objs[0];
				DealTrans tran = (DealTrans) objs[1];
				MbilUser user = (MbilUser) objs[2];
				
				OrderlistRespVo vo = new OrderlistRespVo();
				vo.setUuid(order.getUuid());
				vo.setOdTime(DateUtil.getFullDateTime(order.getCreTime()));
				vo.setOdUid(order.getOdUid());
				vo.setOdUname(user.getUrealname());
				vo.setOdOrg(order.getOdOid());
				vo.setOdId(order.getOdFlowid());
				vo.setOdType(order.getOdType());
				vo.setOdFeecode(order.getOdFeecode());
				vo.setOdFeerate(order.getOdFeerate()+"");
				vo.setOdIstop(order.getOdIstop()+"");
				vo.setOdTopvalue(order.getOdToprate()+"");
				vo.setOdValue(order.getOdValue()+"");
				vo.setOdBenefit(order.getOdBenefit()+"");
				vo.setOdSettlerate(order.getOdSettlerate()+"");
				vo.setOdSettlebene(order.getOdSettlebene()+"");
				vo.setOdStat(order.getOdStat());
				
				vo.setTranChlid(tran.getTrChlid());
				vo.setTranMchname(tran.getTrRmchname());
				vo.setTranFeerate(tran.getTrRfeerate()+"");
				vo.setTranIstop(tran.getTrRistop()+"");
				vo.setTranTopvalue(tran.getTrRtopvalue()+"");
				vo.setTranBenefit(tran.getTrRbenefit()+"");
				vo.setTranAccno(tran.getTrCardno());
				vo.setTranStat(tran.getTrStat());
				vo.setTranCode(tran.getTrRespcode());
				list.add(vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return list;
	}

	@Override
	public int getCount(String countSql) {
		int count = 0;
		try{
			count = Integer.parseInt(getHibSession().createSQLQuery(countSql).list().get(0).toString());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return count;
	}

	@Override
	public List<TakemoneylistRespVo> getTakemoneylist(String sql) {
		List<TakemoneylistRespVo> list = new ArrayList<TakemoneylistRespVo>();
		try{
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql)
					.addEntity("odrer",MbilOrderTakemoney.class)
					.addEntity("user",MbilUser.class);
			List<?> vlist = sqlQuery.list();
			Iterator<?> it = vlist.iterator();
			while(it.hasNext()){
				Object[] objs = (Object[]) it.next();
				MbilOrderTakemoney order = (MbilOrderTakemoney) objs[0];
				MbilUser user = (MbilUser) objs[1];
				
				TakemoneylistRespVo vo = new TakemoneylistRespVo();
				vo.setOdTime(DateUtil.getFullDateTime(order.getCreTime()));
				vo.setOdId(order.getOdFlowid());
				vo.setOdUid(order.getOdUid());
				vo.setOdUname(user.getUrealname());
				vo.setOdOid(order.getOdOid());
				vo.setOdType(order.getOdType());
				vo.setOdArriveType(order.getOdArrivetype());
				vo.setOdArriveDate(order.getOdArrivedate());
				vo.setOdValue(order.getOdValue()+"");
				vo.setOdBenefit(order.getOdBenefitvalue()+"");
				vo.setOdArriveValue(order.getOdArrivevalue()+"");
				vo.setOdArraccname(order.getOdArriveaccname());
				vo.setOdArraccno(order.getOdArriveaccno());
				vo.setOdBankname(order.getOdArrivebankname());
				vo.setOdStat(order.getOdStat());
				list.add(vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return list;
	}

	@Override
	public List<DevicelistRespVo> getDevicelist(String uid, String oid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MbilUserlistRespVo> getMbilUserlist(String sql,int dtype) {
		List<MbilUserlistRespVo> list = new ArrayList<MbilUserlistRespVo>();
		try{
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql)
					.addEntity("user",MbilUser.class)
					.addEntity("org",SysOrg.class)
					.addEntity("mcard",MbilCard.class)
					.addScalar("uid")
					.addScalar("ksn");
			List<?> vlist = sqlQuery.list();
			Iterator<?> it = vlist.iterator();
			while(it.hasNext()){
				Object[] objs = (Object[]) it.next();
				MbilUser user = (MbilUser) objs[0];
				SysOrg org = (SysOrg) objs[1];
				MbilCard card = (MbilCard) objs[2];
				String sn = StringUtil.isDbNull(objs[4])?"":objs[4].toString();
				MbilUserlistRespVo vo = new MbilUserlistRespVo();
				vo.setUuid(user.getUid());
				vo.setUserId(dtype==1?user.getUid():StringUtil.hidePhoneNo(user.getUid(),"*"));
				vo.setUserName(dtype==1?user.getUrealname():StringUtil.hideName(user.getUrealname(), "*"));
				vo.setUserRegtime(DateUtil.getFullDateTime(user.getCreTime()));
				vo.setUserStat(user.getUstat());
				vo.setUserIdcard(dtype==1?user.getUidno():StringUtil.hidePhoneNo(user.getUidno(), "*"));
				vo.setUesrOid(org.getOid());
				vo.setUserOname(org.getOname());
				vo.setUserOpath(org.getOpathtrack());
				vo.setUserOpathname(org.getOpathname());
				vo.setUserMcardname(dtype==1?card.getCdAccname():StringUtil.hideName(card.getCdAccname(), "*"));
				vo.setUserMcardno(dtype==1?card.getCdAccno():StringUtil.hideCardNo(card.getCdAccno(), "*"));
				vo.setUserMcardbank(card.getCdBankname());
				vo.setUserMcardbankbranch(card.getCdBankbranch());
				vo.setUserMcardbankcode(card.getCdBankcode());
				vo.setUserDevicesn(sn);
				list.add(vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return list;
	}

	@Override
	public String getSubOrgs(String oid, boolean withChild) {
		String strResult = "";
		try{
			String sql = "";
			if(withChild){
				sql = "select group_concat(o_id) as oids from sys_org where o_id!='"+oid+"' and find_in_set('"+oid+"',o_pathtrack) order by o_id asc";
			}else{
				sql = "select group_concat(o_id) as oids from sys_org where o_parentid='"+oid+"' order by o_id asc";
			}
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql).addScalar("oids");
			List<?> vlist = sqlQuery.list();
			Iterator<?> it = vlist.iterator();
			if(it.hasNext()){
				String obj = it.next().toString();
				strResult = obj;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return strResult;
	}
	@Override
	public List<OrglistRespVo> getOrglist(String parentid,boolean withChild) {
		List<OrglistRespVo> orgList = new ArrayList<OrglistRespVo>(); 
		try{
			String sql = "select * from sys_org where stat=0";
			if(withChild){sql+= " and find_in_set('"+parentid+"',o_pathtrack)";}
			else{sql+=" and o_parentid='"+parentid+"'";}
			sql+=" order by convert(o_name using gbk) asc";
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql).addEntity("org",SysOrg.class);
			List<?> vlist = sqlQuery.list();
			Iterator<?> it = vlist.iterator();
			while(it.hasNext()){
				SysOrg obj = (SysOrg) it.next();
				OrglistRespVo vo = new OrglistRespVo();
				vo.setOid(obj.getOid());
				vo.setOname(obj.getOname());
				vo.setObref(obj.getOnamebref());
				vo.setOparentid(obj.getOparentid());
				orgList.add(vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return orgList;
	}
	private Double roundDown(Double value){
		BigDecimal b = new BigDecimal(value);  
		double fvalue = b.setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue();  
		return fvalue;
	}

	@Override
	public List<DevicelistRespVo> getDevicelist(String sql,int dtype) {
		List<DevicelistRespVo> list = new ArrayList<DevicelistRespVo>();
		try{
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql)
					.addEntity("device",MbilDevice.class)
					.addEntity("org",SysOrg.class);
			List<?> vlist = sqlQuery.list();
			Iterator<?> it = vlist.iterator();
			while(it.hasNext()){
				Object[] objs = (Object[]) it.next();
				MbilDevice de = (MbilDevice) objs[0];
				SysOrg org = (SysOrg) objs[1];
				DevicelistRespVo vo = new DevicelistRespVo();
				vo.setDeCretime(DateUtil.getFullDateTime(de.getCreTime()));
				vo.setDeId(de.getDeTid());
				vo.setDeSn(de.getDeSn());
				vo.setDeType(de.getDeType());
				vo.setDeModel(de.getDeModel());
				vo.setDeStat(de.getDeStat());
				vo.setDeUid(dtype==1?de.getDeUid():StringUtil.hidePhoneNo(de.getDeUid(), "*"));
				vo.setDeoPath(org.getOname()+"["+org.getOid()+"]");
				list.add(vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getStatisTrans() {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try{
			String sql ="select a.dt as date,a.ct as totalcount,b.ct as succount,c.vt as totalvalue,d.vt as sucvalue,e.ct as s0count,f.ct as t1count,g.vt as s0value,h.vt as t1value from(select date(cre_time) as dt,count(*) as ct from mbil_order_receivemoney as morder where  date_sub(curdate(), INTERVAL 7 DAY) <= date(cre_time) group by date(cre_time) order by cre_time desc)a"
					+" left join (select date(cre_time) as dt,count(*) as ct from mbil_order_receivemoney as morder where date_sub(curdate(),interval 7 day) <= date(cre_time) and morder.od_stat in(5,7,8,9) group by date(cre_time) order by cre_time desc)b on a.dt=b.dt"
					+" left join (select date(cre_time) as dt,sum(od_value) as vt from mbil_order_receivemoney as morder where date_sub(curdate(),interval 7 day) <= date(cre_time) group by date(cre_time) order by cre_time desc)c on a.dt=c.dt"
					+" left join(select date(cre_time) as dt,sum(od_value) as vt from mbil_order_receivemoney as morder where date_sub(curdate(),interval 7 day) <= date(cre_time) and morder.od_stat in(5,7,8,9) group by date(cre_time) order by cre_time desc)d on a.dt=d.dt"
					+" left join (select date(cre_time) as dt,count(*) as ct from mbil_order_receivemoney as morder where date_sub(curdate(),interval 7 day) <= date(cre_time) and morder.od_stat in(5,7,8,9) and od_type='11' group by date(cre_time) order by cre_time desc)e on a.dt=e.dt" 
					+" left join (select date(cre_time) as dt,count(*) as ct from mbil_order_receivemoney as morder where date_sub(curdate(),interval 7 day) <= date(cre_time) and morder.od_stat in(5,7,8,9) and od_type='9' group by date(cre_time) order by cre_time desc)f on a.dt=f.dt"
					+" left join(select date(cre_time) as dt,sum(od_value) as vt from mbil_order_receivemoney as morder where date_sub(curdate(),interval 7 day) <= date(cre_time) and morder.od_stat in(5,7,8,9) and od_type='11' group by date(cre_time) order by cre_time desc)g on a.dt=g.dt"
					+" left join(select date(cre_time) as dt,sum(od_value) as vt from mbil_order_receivemoney as morder where date_sub(curdate(),interval 7 day) <= date(cre_time) and morder.od_stat in(5,7,8,9) and od_type='9' group by date(cre_time) order by cre_time desc)h on a.dt=h.dt";
			SQLQuery sqlQuery = getHibSession().createSQLQuery(sql)
					.addScalar("date")
					.addScalar("totalcount")
					.addScalar("succount")
					.addScalar("totalvalue")
					.addScalar("sucvalue")
					.addScalar("s0count")
					.addScalar("t1count")
					.addScalar("s0value")
					.addScalar("t1value");
			List<?> vlist = sqlQuery.list();
			Iterator<?> it = vlist.iterator();
			while(it.hasNext()){
				Object[] objs = (Object[]) it.next();
				Map<String,Object> omap = new HashMap<String,Object>();
				if(!StringUtil.isDbNull(objs[0])){omap.put("date", objs[0]);}else{omap.put("date", objs[0]);}
				if(!StringUtil.isDbNull(objs[1])){omap.put("totalcount", objs[1]);}else{omap.put("totalcount", "0");}
				if(!StringUtil.isDbNull(objs[2])){omap.put("succount", objs[2]);}else{omap.put("succount", "0");}
				if(!StringUtil.isDbNull(objs[3])){omap.put("totalvalue", objs[3]);}else{omap.put("totalvalue", "0");}
				if(!StringUtil.isDbNull(objs[4])){omap.put("sucvalue", objs[4]);}else{omap.put("sucvalue", "0");}
				if(!StringUtil.isDbNull(objs[5])){omap.put("s0count", objs[5]);}else{omap.put("s0count", "0");}
				if(!StringUtil.isDbNull(objs[6])){omap.put("t1count", objs[6]);}else{omap.put("t1count", "0");}
				if(!StringUtil.isDbNull(objs[7])){omap.put("s0value", objs[7]);}else{omap.put("s0value", "0");}
				if(!StringUtil.isDbNull(objs[8])){omap.put("t1value", objs[8]);}else{omap.put("t1value", "0");}
				list.add(omap);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeHibSession();
		}
		return list;
	}
}
