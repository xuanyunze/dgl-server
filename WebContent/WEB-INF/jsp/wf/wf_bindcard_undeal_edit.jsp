<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../sections/page_header.jsp" %>
<title>银行卡绑定审批</title>
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
	   <td class="tdLabel">开户名称：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="uname" value="${mObject.wfAccname}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">银行卡号：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="umail" value="${mObject.wfAccno}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">银行卡类型：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="uphone" value="${mObject.wfCardtyp}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">认证方式：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="uphone" value="${mObject.wfIsmaincard}" /></td>
	  </tr>
	  <tr><td class="tdLabel" colspan=2>银行卡正面图片：</td></tr>
	  <tr><td class="tdLael" colspan=2><img src="/<%=WebConfig.getProperty("web.path")%>/image/bankcard/all/pos/${mObject.wfUid}/${mObject.wfAccno}" /></td></tr>
	  <tr><td class="tdLabel" colspan=2>银行卡反面图片：</td></tr>
	  <tr><td class="tdLael" colspan=2><img src="/<%=WebConfig.getProperty("web.path")%>/image/bankcard/all/nag/${mObject.wfUid}/${mObject.wfAccno}" /></td></tr>
	  <tr>
	   <td class="tdLabel">审批结果：</td>
	   <td class="tdContent">
	   	<select name="result">
	   	 <option value="1">通过</option>
	   	 <option value="0">驳回</option>
	   	</select>
	   </td>
	  </tr>
	  <tr>
	   <td class="tdLabel">审批意见：</td>
	   <td class="tdContent">
	   	<textarea id="spyj" name="spyj" rows=3 style="width:100%;"></textarea>
	   </td>
	  </tr>
	 </table>
	</form>
  <div id="btnarea">
  	<div class="btncommon" id="btnsubmit">提交审批</div>
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