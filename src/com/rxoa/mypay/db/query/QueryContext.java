package com.rxoa.mypay.db.query;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rxoa.mypay.base.SpringWiredBean;
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

public abstract class QueryContext {
    public SessionFactory sessionFactory = (SessionFactory) SpringWiredBean.getInstance().getBeanById("sessionFactory");
    private Session hibSession = sessionFactory.openSession();
    
    public Session getHibSession(){
    	if(this.hibSession==null||(!this.hibSession.isOpen())){
        	this.hibSession = sessionFactory.openSession();
    	}
    	return this.hibSession;
    }
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void closeHibSession(){
		try{
			this.hibSession.clear();
			this.hibSession.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.hibSession = null;
	}
	/********************************
	 * 功能：数据库查询-操作方法集
	 */
	abstract public void getUserInfo();
	abstract public boolean getResourceCheck(String userid,String srcid,String usetype);
	abstract public ProfitReportEntity getProfitByOrgEntity(OrgTreeEntity org,ProfitQueryEntity query);
	abstract public List<Map<String,Object>> getTransReport(ReportQueryEntity query);
	abstract public List<Map<String,Object>> getSettleReport(ReportQueryEntity query);
	abstract public List<Map<String,Object>> getHSettleReport(ReportQueryEntity query);
	abstract public List<Map<String,Object>> getSettlefailReport(ReportQueryEntity query);
	abstract public List<Map<String,Object>> getStatisTrans();
	abstract public String getDistributionInfo(String oid,String mccid);
	abstract public String getTakemoneyDistrInfo(String oid,String settleid);
	abstract public String getOrgtrack(String oid);
	abstract public List<OrderlistRespVo> getOrderlist(String sql);
	abstract public List<TakemoneylistRespVo> getTakemoneylist(String sql);
	abstract public int getCount(String countSql);
	abstract public List<DevicelistRespVo> getDevicelist(String uid,String oid);
	abstract public List<DevicelistRespVo> getDevicelist(String sql,int utype);
	abstract public List<MbilUserlistRespVo> getMbilUserlist(String sql,int utype);
	abstract public String getSubOrgs(String oid,boolean withChild);
	abstract public List<OrglistRespVo> getOrglist(String parentid,boolean withChild);
	
	abstract public Map<String,Object> getBusiConfig();
	abstract public Map<String,Object> getOrgBusiConfig(String oid);
	abstract public BenefitEntityVo getBenefitReport(ReportQueryEntity query,Map<String,Object> busiConfig,String oid,boolean useDiv);
}

