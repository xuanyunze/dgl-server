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
<style>
table.report{
	width:98%;border:1px solid #CCDDCC;margin:0 auto;
}
table.report td{
	font-size:12px;height:24px;border-top:1px dashed #CCC;text-align:center;
}
table.report tr.title td{
	font-weight:bold;font-size:13px;border-top:none;
}

</style>
<title>分润查询</title>
</head>
<body style="margin:5px 5px auto;padding:0 0 auto;">
  <div id="progressBar" class="progressBar" style="display: none; ">数据加载中，请稍等...</div>
	<form id="dlgform">
	 <table class="formtable" style="width:98%;margin:0 auto;margin-top:10px;">
	  <tr>
	   <td class="tdLabel" width="50%">
	   交易时间范围：<input type="text" name="startDate" style="width:100px;" value="<%=DateUtil.getDateOnly(new Date()) %>" onfocus="HS_setDate(this)"/>
	   至 <input type="text" name="endDate" style="width:100px;margin-right:60px;" value="<%=DateUtil.getDateOnly(new Date()) %>" onfocus="HS_setDate(this)"/>
	   <select name="reporttype">
	   	<option value="byorg">机构分润报表</option>
	   	<option value="bydate">机构日期报表</option>
	   </select>
	   <button type="button" id="btndown" style="width:100px;height:24px;margin-left:15px;float:right;cursor:pointer;">下载报表</button>
	   <button type="button" id="btnquery" style="width:100px;height:24px;margin-left:15px;float:right;cursor:pointer;">查询分润</button>
	   </td>
	  </tr>
	  <tr>
	 </table>
	</form>
	<div style="margin:10px;font-size:12px;color:#8888EE">提示：由于交易实时性会导致数据误差，此收益查询仅用作即时对账使用，实际收益结算以最终的结算报表文件为准！</div>
	<div style="position:absolute;left:0;top:80px;bottom:0;right:0;overflow:auto;"><table class="report" id="report"></table></div>
	<table class="report" id="reportx" style="display:none;">
		<tr>
			<td style="text-align:left;padding:0;margin:0;width:250px;">
				<ul id="reportcontent" style="margin:0;padding:0;margin-left:10px;width:100%;"></ul>
			</td>
			<td style="border-left:1px solid #CCC;">&nbsp;
				<table>
				</table>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
$("#btnquery").click(function(){
	var saveurl = "/"+basepath+"/report/benefit/normal/json";
	startLoading();
	$.ajax({
		cache: false,
		type: "GET",
		url:saveurl,
		data:$("#dlgform").serialize(),
		dataType: "json",
		async: true, //注意异步，否则无法加载等待
		error: function(request) {
			alert("加载信息失败！");
		},
		success: function(data) {
			stopLoading();
			fnCreateReport(data);
		}
	});
});
$("#btndown").click(function(){
	
});
function fnCreateReport(objjson){
	var strHtml = "<tr class=\"title\"><td style=\"width:250px;\" nowrap>机构名称</td><td nowrap>S0笔数</td><td nowrap>S0金额</td><td nowrap>S0收益</td><td nowrap>T1笔数</td><td nowrap>T1金额</td><td nowrap>T1收益</td><td nowrap>总笔数</td><td nowrap>总金额</td><td nowrap>总收益</td></tr>";
	var objlist =  objjson.list;
	var vc = objlist[0].oid.length/2;
	for(var i=0;i<fnGetJsonLength(objlist);i++){
		padding = (objlist[i].oid.length/2 - vc)*10+"px";
		strHtml+="<tr><td style=\"padding-left:"+padding+"\">"+objlist[i].oname+"</td>";
        strHtml+="<td>"+objlist[i].s0Count+"</td>";
        strHtml+="<td>"+objlist[i].s0Value.toFixed(2)+"</td>";
        strHtml+="<td>"+objlist[i].s0Benefit.toFixed(2)+"</td>";
        strHtml+="<td>"+objlist[i].t1Count+"</td>";
        strHtml+="<td>"+objlist[i].t1Value.toFixed(2)+"</td>";
        strHtml+="<td>"+objlist[i].t1Benefit.toFixed(2)+"</td>";
        strHtml+="<td>"+objlist[i].totalCount+"</td>";
        strHtml+="<td>"+objlist[i].totalValue.toFixed(2)+"</td>";
        strHtml+="<td>"+objlist[i].totalBenefit.toFixed(2)+"</td></tr>";
	}
	$("#report").html("");
	$("#report").append(strHtml);
}
</script>
</html>