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
<title>分润查询</title>
</head>
<body style="margin:5px 5px auto;padding:0 0 auto;">
  <div id="progressBar" class="progressBar" style="display: none; ">数据加载中，请稍等...</div>
	<table class="report" id="reportx" style="width:40%;margin-top:100px;">
		<tr>
			<td style="font-size:14px;text-align:center;width:60%;padding-right:10px;">数据库连接</td>
			<td style="font-size:14px;color:green;border-left:1px solid #CCC;padding-left:10px;">正常</td>
		</tr>
		<tr>
			<td style="font-size:14px;text-align:center;width:60%;padding-right:10px;">工作连接池</td>
			<td style="font-size:14px;color:green;border-left:1px solid #CCC;padding-left:10px;">正常</td>
		</tr>
		<tr>
			<td style="font-size:14px;text-align:center;width:60%;padding-right:10px;">交易线程池</td>
			<td style="font-size:14px;color:green;border-left:1px solid #CCC;padding-left:10px;">正常</td>
		</tr>
		<tr>
			<td style="font-size:14px;text-align:center;width:60%;padding-right:10px;">清算模块</td>
			<td style="font-size:14px;color:green;border-left:1px solid #CCC;padding-left:10px;">正常</td>
		</tr>
		<tr>
			<td style="font-size:14px;text-align:center;width:60%;padding-right:10px;">逻辑模块</td>
			<td style="font-size:14px;color:green;border-left:1px solid #CCC;padding-left:10px;">正常</td>
		</tr>
		<tr>
			<td style="font-size:14px;text-align:center;width:60%;padding-right:10px;">交易巡检模块</td>
			<td style="font-size:14px;color:green;border-left:1px solid #CCC;padding-left:10px;">正常</td>
		</tr>
		<tr>
			<td style="font-size:14px;text-align:center;width:60%;padding-right:10px;">自动核算模块</td>
			<td style="font-size:14px;color:green;border-left:1px solid #CCC;padding-left:10px;">正常</td>
		</tr>
		<tr>
			<td style="font-size:14px;text-align:center;width:60%;padding-right:10px;">防伪检测模块</td>
			<td style="font-size:14px;color:green;border-left:1px solid #CCC;padding-left:10px;">正常</td>
		</tr>
		<tr>
			<td style="font-size:14px;text-align:center;width:60%;padding-right:10px;">路由模块</td>
			<td style="font-size:14px;color:green;border-left:1px solid #CCC;padding-left:10px;">正常</td>
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