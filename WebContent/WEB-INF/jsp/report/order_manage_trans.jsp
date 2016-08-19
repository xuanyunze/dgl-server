<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
    <%@ page import="java.util.Date"%>
    <%@ page import="com.rxoa.mypay.util.DateUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-form.css">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-page.css">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/calendar.css">
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/common.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/rxwebui-page.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/calendar.js"></script>
<script type="text/javascript">
	var basepath = "<%=WebConfig.getProperty("web.path")%>";
</script>
<title>平台报表查询</title>
</head>
<body style="margin:5px 5px auto;padding:0 0 auto;">
  <div id="progressBar" class="progressBar" style="display: none; ">数据加载中，请稍等...</div>
  	<div style="margin:10px;font-size:12px;color:#8888EE">提示：导出【成功的交易】信息，用于渠道对账~</div>
	<form id="dlgform_trans" action="/<%=WebConfig.getProperty("web.path")%>/report/order/manage/xls" method="get">
	 <table class="formtable" style="width:98%;margin:0 auto;margin-top:10px;">
	  <tr>
	   <td class="tdLabel" width="50%">
	   交易时间范围：
	   <input type="text" name="startDate" style="width:100px;" value="<%=DateUtil.getDateOnly(DateUtil.adjust(new Date(), 3, -1)) %>" onfocus="HS_setDate(this)"/>
	   至 <input type="text" name="endDate" style="width:100px;margin-right:60px;" value="<%=DateUtil.getDateOnly(DateUtil.adjust(new Date(), 3, -1)) %>" onfocus="HS_setDate(this)"/>
	   <input type="checkbox" name="withChild" checked style="border:none;display:none;width:15px;height:15px;line-height:15px;"/>
	   <!--
	   选择通道
	   <select name="channel">
	   	<option value="1000">所有通道</option>
	   </select>
	   -->
	   <button type="button" id="btnquery_trans" style="width:150px;height:24px;margin-left:30px;float:right;cursor:pointer;">渠道对账【下载报表】</button></td>
	  </tr>
	  <tr>
	 </table>
	</form>
	
	<div style="margin:10px;font-size:12px;color:#8888EE;margin-top:30px;">提示：导出【成功的自动下发】信息，用于和下发通道对账~</div>
	<form id="dlgform_settle" action="/<%=WebConfig.getProperty("web.path")%>/report/settle/manage/xls" method="get">
	 <table class="formtable" style="width:98%;margin:0 auto;margin-top:10px;">
	  <tr>
	   <td class="tdLabel" width="50%">
	   交易时间范围：<input type="text" name="startDate" style="width:100px;" value="<%=DateUtil.getDateOnly(new Date()) %>" onfocus="HS_setDate(this)"/>
	   至 <input type="text" name="endDate" style="width:100px;margin-right:60px;" value="<%=DateUtil.getDateOnly(new Date()) %>" onfocus="HS_setDate(this)"/>
	   <input type="checkbox" name="withChild" checked style="border:none;display:none;width:15px;height:15px;line-height:15px;"/>
	   <button type="button" id="btnquery_settle" style="width:150px;height:24px;margin-left:30px;float:right;cursor:pointer;">自动清算【下载报表】</button></td>
	  </tr>
	  <tr>
	 </table>
	</form>
	
	<div style="margin:10px;font-size:12px;color:#8888EE;margin-top:30px;">提示：导出【自动下发失败】的信息，用于和下发通道对账~</div>
	<form id="dlgform_settlefail" action="/<%=WebConfig.getProperty("web.path")%>/report/settlefail/manage/xls" method="get">
	 <table class="formtable" style="width:98%;margin:0 auto;margin-top:10px;">
	  <tr>
	   <td class="tdLabel" width="50%">
	   交易时间范围：<input type="text" name="startDate" style="width:100px;" value="<%=DateUtil.getDateOnly(new Date()) %>" onfocus="HS_setDate(this)"/>
	   至 <input type="text" name="endDate" style="width:100px;margin-right:60px;" value="<%=DateUtil.getDateOnly(new Date()) %>" onfocus="HS_setDate(this)"/>
	   <input type="checkbox" name="withChild" checked style="border:none;display:none;width:15px;height:15px;line-height:15px;"/>
	   <button type="button" id="btnquery_settlefail" style="width:150px;height:24px;margin-left:30px;float:right;cursor:pointer;">自动清算失败【下载】</button></td>
	  </tr>
	  <tr>
	 </table>
	</form>
	
	<div style="margin:10px;font-size:12px;color:#8888EE;margin-top:30px;">提示：导出【需要手动清分】的数据，用于当日清分对账～</div>
	<form id="dlgform_hsettle" action="/<%=WebConfig.getProperty("web.path")%>/report/hsettle/manage/xls" method="get">
	 <table class="formtable" style="width:98%;margin:0 auto;margin-top:10px;">
	  <tr>
	   <td class="tdLabel" width="50%">
	   交易时间范围：<input type="text" name="startDate" style="width:100px;" value="<%=DateUtil.getDateOnly(DateUtil.adjust(new Date(), 3, -1)) %>" onfocus="HS_setDate(this)"/>
	   至 <input type="text" name="endDate" style="width:100px;margin-right:60px;" value="<%=DateUtil.getDateOnly(DateUtil.adjust(new Date(), 3, -1)) %>" onfocus="HS_setDate(this)"/>
	   <input type="checkbox" name="withChild" checked style="border:none;display:none;width:15px;height:15px;line-height:15px;"/>
	   <button type="button" id="btnquery_hsettle" style="width:150px;height:24px;margin-left:30px;float:right;cursor:pointer;">手动清算【下载报表】</button></td>
	  </tr>
	  <tr>
	 </table>
	</form>
</body>
<script type="text/javascript">
$("#btnquery_trans").click(function(){
	document.getElementById("dlgform_trans").submit();return false;
});
$("#btnquery_settle").click(function(){
	document.getElementById("dlgform_settle").submit();return false;
});
$("#btnquery_hsettle").click(function(){
	document.getElementById("dlgform_hsettle").submit();return false;
});
$("#btnquery_settlefail").click(function(){
	document.getElementById("dlgform_settlefail").submit();return false;
});
</script>
</html>