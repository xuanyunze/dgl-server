<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<%@ page import="com.rxoa.mypay.util.DateUtil"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../sections/page_header.jsp" %>
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-form.css">
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/dictjson.js"></script>
<script type="text/javascript">
	var basepath = "<%=WebConfig.getProperty("web.path")%>";
</script>
<title>查看交易信息</title>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
<div id="in_progressBar" class="progressBar" style="z-index:99;display:none;">数据处理中，请稍等...</div>
	<form id="dlgform">
	<input name="uuid" value="${mObject.uuid}" style="display:none;"/>
	 <table class="formtable" style="width:90%;margin:0 auto;">
	  <tr>
	   <td class="tdLabel" width="15%">手机号码：</td>
	   <td class="tdContent" width="35%">${mObject.odUid}</td>
	   <td class="tdContent" width="15%">交易时间：</td>
	   <td class="tdContent" width="35%">${mObject.creTime}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel">交易卡号：</td>
	   <td class="tdContent">${mObject.odPayaccno}</td>
	   <td class="tdContent">交易金额：</td>
	   <td class="tdContent">${mObject.odValue}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel">用户签名：</td>
	   <td class="tdContent" colspan=3><img src="/<%=WebConfig.getProperty("web.path")%>/image/manage/sig/${mObject.odUid}/${mObject.odFlowid}" style="width:350px;"/></td>
	  </tr>
	  <tr>
	   <td class="tdLabel" colspan=4>☆右击图片可以保存用户签名到本地～</td>
	  </tr>
	 </table>
	</form>
  <div id="btnarea">
  	<div class="btncommon" id="btnclose">关闭页面</div>
  </div>
  <script type="text/javascript">
  	$(function(){
		var ustat = ${mUser.ustat};
		if(ustat=='1'){$("#ustat").html("正常");}
		else if(ustat=='2'){$("#ustat").html("已锁定");}
		$("#btnCleardevice").click(function(){fnClearRealname();});
  	});
	$("#btnclose").click(function(){
		window.parent.closeEditDialog();
	});
function changeDeal(tovalue){
	if(tovalue==0){
		if(!confirm("确定要禁止该用户交易吗？")) return false;
	}else{
		if(!confirm("确定要解除该用户交易冻结吗？")) return false;
	}
	var saveurl = "/"+basepath+"/mch/changedstat/manage/"+tovalue+"/"+${mUser.uid};
	startDealing();
	$.ajax({
		cache: false,
		type: "GET",
		url:saveurl,
		data:'',
		dataType: "json",
		async: true,
		error: function(request) {
			 stopDealing();
			alert("提交请求失败～");
		},
		success: function(data) {
			 stopDealing();
			 alert("已提交请求～");
			 closeDialog();
		}
	});
}
function changeSettle(tovalue){
	if(tovalue==0){
		if(!confirm("确定要冻结该用户自动清算吗？")) return false;
	}else{
		if(!confirm("确定要解除该用户清算冻结吗？")) return false;
	}
	var saveurl = "/"+basepath+"/mch/changesstat/manage/"+tovalue+"/"+${mUser.uid};
	startDealing();
	$.ajax({
		cache: false,
		type: "GET",
		url:saveurl,
		data:'',
		dataType: "json",
		async: true,
		error: function(request) {
			 stopDealing();
			alert("提交请求失败～");
		},
		success: function(data) {
			 stopDealing();
			 alert("已提交请求～");
			 closeDialog();
		}
	});
}

	function closeDialog(obj,sec){
		window.parent.closeEditDialog(obj,sec);
	}
	function startDealing(){
		$("#in_progressBar").css("display","");
	}
	function stopDealing(){
		$("#in_progressBar").css("display","none");
	}
  </script>
</body>
</html>