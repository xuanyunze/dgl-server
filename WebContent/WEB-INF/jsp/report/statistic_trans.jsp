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
	font-size:16px;height:35px;border-top:1px dashed #CCC;text-align:center;color:#888;font-family:微软雅黑;
}
table.report tr.title td{
	font-weight:bold;font-size:18px;border-top:none;color:#666;
}
</style>
<title>交易数据统计</title>
</head>
<body style="margin:5px 5px auto;padding:0 0 auto;">
  <div id="progressBar" class="progressBar" style="display: none; ">数据加载中，请稍等...</div>
	<form id="dlgform">
	 <table class="formtable" style="width:98%;margin:0 auto;margin-top:10px;">
	  <tr>
	   <td class="tdLabel" width="50%">☆点击按钮以获取相应统计信息～
	   	<button type="button" id="btnquery" style="width:120px;height:24px;margin-left:30px;float:right;cursor:pointer;">7日交易信息统计</button></td>
	  </tr>
	  <tr>
	 </table>
	</form>
	<table class="report" id="report"></table>
</body>
<script type="text/javascript">
	$("#btnquery").click(function(){
		var saveurl = "/"+basepath+"/report/statis/trans.json/normal";
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
function fnCreateReport(objjson){
	var strHtml = "<tr class=\"title\"><td style=\"width:150px;\" nowrap>交易日期</td><td nowrap>交易总笔数</td><td nowrap>交易总金额</td><td nowrap>S0总笔数</td><td nowrap>S0总金额</td><td nowrap>T1总笔数</td><td nowrap>T1总金额</td></tr>";
	var objlist =  objjson.list;
	for(var i=0;i<fnGetJsonLength(objlist);i++){
		strHtml+="<tr><td>"+objlist[i].date+"</td>";
		strHtml+="<td>"+objlist[i].succount+"</td>";
		strHtml+="<td>"+objlist[i].sucvalue+"</td>";
		strHtml+="<td>"+objlist[i].s0count+"</td>";
		strHtml+="<td>"+objlist[i].s0value+"</td>";
		strHtml+="<td>"+objlist[i].t1count+"</td>";
		strHtml+="<td>"+objlist[i].t1value+"</td>";
	}
	$("#report").html("");
	$("#report").append(strHtml);
}
</script>
</html>