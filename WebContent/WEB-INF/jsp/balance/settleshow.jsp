<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-form.css">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-page.css">
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/common.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/rxwebui-page.js"></script>
<script type="text/javascript">
	var basepath = "<%=WebConfig.getProperty("web.path")%>";
</script>
<style>
table.report{
	width:98%;border:1px solid #CCDDCC;margin:0 auto;
}
table.report td{
	font-size:12px;height:24px;border-top:1px dashed #CCC;
}
table.report tr.title td{
	font-weight:bold;font-size:13px;border-top:none;
}
#reportcontent ul,li{
	list-style-type:none;list-style-image:url("/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/jquery-treeview/images/minus.gif");margin:10px;padding:0;text-indent:0;
}
#reportcontent span.content{
	display:-moz-inline-box;
	display:inline-block;
	width:150px;
}
</style>
<title>清算报表查询</title>
</head>
<body style="margin:5px 5px auto;padding:0 0 auto;">
  <div id="progressBar" class="progressBar" style="display: none; ">数据加载中，请稍等...</div>
  	<table class="report" id="vreport" style="padding:0;margin-bottom:20px;">
		<tr><td style="font-size:16px;text-align:center;background:#FCFCFC;font-weight:bold;border-bottom:1px solid #ccc;"colspan=8>清算金额7日预测</td></tr>
		<tr class="title">
			<td style="width:100px;" nowrap>日期</td>
			<td nowrap>待清算T1笔数</td>
			<td nowrap>待清算T1金额</td>
			<td nowrap>待清算T0笔数</td>
			<td nowrap>待清算T0金额</td>
			<td nowrap>待清算T7笔数</td>
			<td nowrap>待清算T7金额</td>
			<td nowrap>待清算总金额</td>
			</tr>
	</table>
	<form id="dlgform">
	 <table class="formtable" style="width:98%;margin:0 auto;margin-top:10px;">
	  <tr>
	   <td class="tdLabel" width="50%">
	   交易时间范围：<input type="text" name="startDate" style="width:100px;" value="2015-07-01"/>
	   至 <input type="text" name="endDate" style="width:100px;margin-right:60px;" value="2015-07-31"/>
	   <input type="checkbox" name="withChild" checked style="border:none;display:none;width:15px;height:15px;line-height:15px;"/>
	   <button type="button" id="btnquery" style="width:100px;height:24px;margin-left:30px;float:right;cursor:pointer;">查询历史</button></td>
	  </tr>
	  <tr>
	 </table>
	</form>
	<div style="margin:10px;font-size:12px;color:#8888EE">提示：清算报表反映交易和清算数据的实际信息！</div>
	<table class="report" id="report">
		<tr class="title">
			<td style="width:100px;" nowrap>日期</td>
			<td nowrap>T1交易笔数</td>
			<td nowrap>T0交易笔数</td>
			<td nowrap>T7交易笔数</td>
			<td nowrap>T0清算笔数</td>
			<td nowrap>T1清算笔数</td>
			<td nowrap>T7清算笔数</td>
			<td nowrap>交易总计</td>
			<td nowrap>清算总计</td>
			</tr>
	</table>
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
		var saveurl = "/"+basepath+"/balance/profitquery/normal";
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
				fnCreateReport(data);
				stopLoading();
			}
		});
	});
function fnCreateReport(objjson){
	var strHtml = "<tr class=\"title\"><td style=\"width:250px;\" nowrap>机构名称</td><td nowrap>收款直属收益</td><td nowrap>收款分销收益</td><td nowrap>收款总计收益</td><td nowrap>提现直属收益</td><td nowrap>提现分销收益</td><td nowrap>提现总计收益</td><td nowrap>收益总计</td></tr>";
	var objlist =  objjson.list;
	var vc = objlist[0].orgId.length/2;
	for(var i=0;i<fnGetJsonLength(objlist);i++){
		padding = (objlist[i].orgId.length/2 - vc)*10+"px";
		strHtml+="<tr><td style=\"padding-left:"+padding+"\">"+objlist[i].orgName+"</td>";
		strHtml+="<td>"+objlist[i].selfFee+"（共"+objlist[i].selfFeeCount+"笔）</td>";
		strHtml+="<td>"+objlist[i].childFee+"（共"+objlist[i].childFeeCount+"笔）</td>";
		strHtml+="<td>"+objlist[i].totalFee+"（共"+objlist[i].totalFeeCount+"笔）</td>";
		strHtml+="<td>"+objlist[i].selfT0+"（共"+objlist[i].selfT0Count+"笔）</td>";
		strHtml+="<td>"+objlist[i].childT0+"（共"+objlist[i].childT0Count+"笔）</td>";
		strHtml+="<td>"+objlist[i].totalT0+"（共"+objlist[i].totalT0Count+"笔）</td>";
		strHtml+="<td>"+objlist[i].totalAll+"（共"+objlist[i].totalCount+"笔）</td></tr>";
	}
	$("#report").html("");
	$("#report").append(strHtml);
}
</script>
</html>