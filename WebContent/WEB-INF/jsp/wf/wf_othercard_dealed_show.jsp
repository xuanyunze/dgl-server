<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../sections/page_header.jsp" %>
<title>超级认证审批记录</title>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
	<form id="dlgform">
	<div style="display:none"><input name="uuid" value="${mObject.uuid}"></div>
	 <table class="formtable" style="width:90%;margin:0 auto;">
	  <tr>
	   <td class="tdLabel" width="15%">用户ID：</td>
	   <td class="tdContent" width="35%"><input style="border:none;background:none;" readonly name="uid" value="${mObject.wfUid}" /></td>
	   <td class="tdLabel" width="15%">开户名称：</td>
	   <td class="tdContent" width="35%"><input style="border:none;background:none;" readonly name="uname" value="${mObject.wfAccname}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">银行卡号：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="umail" value="${mObject.wfAccno}" /></td>
	   <td class="tdLabel">银行卡类型：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="uphone" value="信用卡" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">有效日期：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="umail" value="${mObject.wfVdate}" /></td>
	   <td class="tdLabel">安全码：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="uphone" value="${mObject.wfVcode}" /></td>
	  </tr>
	  <tr><td class="tdLabel" colspan=4>银行卡正面图片：</td></tr>
	  <tr><td class="tdLael" colspan=4><img src="/<%=WebConfig.getProperty("web.path")%>/image/bankcard/all/pos/${mObject.wfUid}/${mObject.wfAccno}" /></td></tr>
	  <tr><td colspan=4>审批记录</td></tr>
	  <tr><td colspan=4>
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