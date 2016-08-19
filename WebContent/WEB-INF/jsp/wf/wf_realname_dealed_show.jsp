<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-form.css">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/jquery-ui-1.11.3/jquery-ui.min.css">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/jquery-treeview/jquery.treeview.css">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-page.css">
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/jquery-ui-1.11.3/jquery-ui.min.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/jquery-treeview/jquery.treeview.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/rxwebui-1.0.min.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/rxwebui-page.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/rxwebui-form.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/common.js"></script>
<title>实名认证审批</title>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
	<form id="dlgform">
	<div style="display:none"><input name="uuid" value="${mObject.uuid}"></div>
	 <table class="formtable" style="width:60%;margin:0 auto;">
	  <tr>
	   <td class="tdLabel" width="20%">用户ID：</td>
	   <td class="tdContent" width="80%"><input style="border:none;background:none;" readonly name="uid" value="${mObject.wfUid}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">真实姓名：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="uname" value="${mObject.wfRealname}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">证件号码：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="umail" value="${mObject.wfIdno}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">证件类型：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="uphone" value="${mObject.wfIdtype}" /></td>
	  </tr>
	  <tr><td class="tdLabel" colspan=2>身份证正面图片：</td></tr>
	  <tr><td class="tdLael" colspan=2><img src="/<%=WebConfig.getProperty("web.path")%>/image/all/pos/${mObject.wfUid}" /></td></tr>
	  <tr><td class="tdLabel" colspan=2>身份证背面图片：</td></tr>
	  <tr><td class="tdLael" colspan=2><img src="/<%=WebConfig.getProperty("web.path")%>/image/all/nag/${mObject.wfUid}" /></td></tr>
	  <tr><td class="tdLabel" colspan=2>手持身份证图片：</td></tr>
	  <tr><td class="tdLael" colspan=2><img src="/<%=WebConfig.getProperty("web.path")%>/image/all/self/${mObject.wfUid}" /></td></tr>
	  <tr><td colspan=2>审批记录</td></tr>
	  <tr><td colspan=2>
	   <table id="hisrecord" style="width:100%;border:none;">
	   	<c:forEach items="${listObj}" var="record">
	     <tr>
	      <td>${record.whDealtime}</td>
	      <td>${record.whDealer}</td>
	      <td>${record.whDealresult}</td>
	      <td>${record.whDealyj}</td>
	     </tr>
		</c:forEach>
	   </table>
	  </td></tr>
	 </table>
	</form>
  <div id="btnarea">
  	<div class="btncommon" id="btnclose">关闭页面</div>
  </div>
<script type="text/javascript">
	$("#btnsubmit").click(function(){
		window.parent.submitEditCheck($("#dlgform"),$("input[name=uuid]").val());
	});
	$("#btnclose").click(function(){
		window.parent.closeEditDialog();
	});
</script>
</body>
</html>