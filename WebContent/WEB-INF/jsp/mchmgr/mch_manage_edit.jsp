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
<title>编辑用户信息</title>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
<div id="in_progressBar" class="progressBar" style="z-index:99;display:none;">数据处理中，请稍等...</div>
	<form id="dlgform">
	<input name="uuid" value="${mObject.uuid}" style="display:none;"/>
	 <table class="formtable" style="width:90%;margin:0 auto;">
	  <tr>
	   <td class="tdLabel" width="15%">手机号码：</td>
	   <td class="tdContent" width="35%">${mUser.uid}</td>
	   <td class="tdContent" width="15%">注册时间：</td>
	   <td class="tdContent" width="35%">${mUser.creTime}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="15%">真实姓名：</td>
	   <td class="tdContent" width="35%">${mUser.urealname}</td>
	   <td class="tdContent" width="15%">身份证号：</td>
	   <td class="tdContent" width="35%">${mUser.uidno}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="15%">开户银行：</td>
	   <td class="tdContent" width="35%">${mCard.cdBankname}</td>
	   <td class="tdContent" width="15%">开户分行：</td>
	   <td class="tdContent" width="35%">${mCard.cdBankdistr}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="15%">开户支行：</td>
	   <td class="tdContent" width="35%">${mCard.cdBankbranch}</td>
	   <td class="tdContent" width="15%">联行号码：</td>
	   <td class="tdContent" width="35%">${mCard.cdBankcode}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="15%">开户账户：</td>
	   <td class="tdContent" width="35%">${mCard.cdAccname}</td>
	   <td class="tdContent" width="15%">银行卡号：</td>
	   <td class="tdContent" width="35%">${mCard.cdAccno}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="15%">设备编号：</td>
	   <td class="tdContent" width="35%" style="word-wrap:break-word;word-break:break-all;">${sns}</td>
	   <td class="tdContent" width="15%">用户状态：</td>
	   <td class="tdContent" width="35%" id="ustat">${mUser.ustat}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel">交易状态：</td>
	   <td class="tdContent"><c:choose><c:when test="${mLimit.ulDstat==0}">禁止交易</c:when><c:otherwise>正常交易</c:otherwise></c:choose></td>
	   <td class="tdContent">清算状态：</td>
	   <td class="tdContent"><c:choose><c:when test="${mLimit.ulSstat==0}">冻结清算</c:when><c:otherwise>正常清算</c:otherwise></c:choose></td>
	  </tr>
	 </table>
	</form>
  <div id="btnarea">
	<div class="btncommon" id="btnLockDeal" style="display:<c:choose><c:when test="${mLimit.ulDstat==0}">none</c:when><c:otherwise>block</c:otherwise></c:choose>">冻结交易</div>
	<div class="btncommon" id="btnUnlockDeal" style="display:<c:choose><c:when test="${mLimit.ulDstat==0}">block</c:when><c:otherwise>none</c:otherwise></c:choose>">恢复交易</div>
	<div class="btncommon" id="btnLockSettle" style="display:<c:choose><c:when test="${mLimit.ulSstat==0}">none</c:when><c:otherwise>block</c:otherwise></c:choose>">冻结清算</div>
	<div class="btncommon" id="btnUnlockSettle" style="display:<c:choose><c:when test="${mLimit.ulSstat==0}">block</c:when><c:otherwise>none</c:otherwise></c:choose>">恢复清算</div>
  	<div class="btncommon" id="btnClearname">清空实名</div>
  	<div class="btncommon" id="btnClearcard" style="display:none">清空主卡</div>
  	<div class="btncommon" id="btnCleardevice" style="display:none">清空设备</div>
  	<div class="btncommon" id="btnclose">关闭页面</div>
  </div>
  <script type="text/javascript">
  	$(function(){
		var ustat = ${mUser.ustat};
		if(ustat=='1'){$("#ustat").html("正常");}
		else if(ustat=='2'){$("#ustat").html("已锁定");}
		$("#btnClearname").click(function(){fnClearRealname();});
  	});
  	$("#btnsubmit").click(function(){
		submitReSettle();
	});
	$("#btnclose").click(function(){
		window.parent.closeEditDialog();
	});
	$("#btnresetpwd").click(function(){
		submitResetpwd();
	});
	$("#btnLockDeal").click(function(){changeDeal(0);});
	$("#btnUnlockDeal").click(function(){changeDeal(1);});
	$("#btnLockSettle").click(function(){changeSettle(0);});
	$("#btnUnlockSettle").click(function(){changeSettle(1);});
	
	function fnClearRealname(){
		if(!confirm("确定要清除该用户实名信息吗？")) return false;
		var saveurl = "/"+basepath+"/mch/clearrealname/manage/"+${mUser.uid};
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
				 alert("已提交清除用户信息请求～");
				 closeDialog();
			}
		});
	}
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