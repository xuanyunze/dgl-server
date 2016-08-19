<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	   <td class="tdContent" width="80%"><input style="border:none;background:none;" readonly name="uid" value="${mObject.odUid}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="20%">订单编号：</td>
	   <td class="tdContent" width="80%"><input style="border:none;background:none;" readonly name="uid" value="${mObject.odFlowid}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="20%">订单类型：</td>
	   <td class="tdContent" width="80%">
	    <span class="styled-select">
	   	<select name="odType" onchange="switchOrdertype()">
	   		<option value="1">收款</option>
	   		<option value="2">提现</option>
	   		<option value="3">账户充值</option>
	   		<option value="4">卡卡转账</option>
	   		<option value="5">还信用卡</option>
	   		<option value="6">手机充值</option>
	   		<option value="7">账户查询</option>
	   	</select>
	   	</span>
	   </td>
	  </tr>
	  <tr>
	   <td class="tdLabel">提现账户：</td>
	   <td class="tdContent">
	   <span class="styled-select">
	   	<select name="odTakeaccount" onchange="switchAccount()">
	   		<option value="1">收款账户</option>
	   		<option value="2">充值账户</option>
	   	</select>
	   	</span>
	   </td>
	  </tr>
	  <tr>
	   <td class="tdLabel">提现金额：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="umail" value="${mObject.odValue}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">到账方式：</td>
	   <td class="tdContent">
	   <span class="styled-select">
	   	<select name="odTaketype" onchange="switchTaketype()">
	   		<option value="1">当日到账T+0</option>
	   		<option value="2">次日到账T+1</option>
	   	</select>
	   	</span>
	   </td>
	  </tr>
	  <tr><td class="tdLabel">账单签名图片：</td><td class="tdLabel"><img style="height:100px;" src="/<%=WebConfig.getProperty("web.path")%>/image/all/sig/${mObject.odUid}/${mObject.odFlowid}" /></td></tr>
	  <tr>
	   <td class="tdLabel">订单状态：</td>
	   <td class="tdContent">
	   	<span class="styled-select">
	   	<select name="odStat" onchange="switchOrderStat()">
	   		<option value="1">未支付</option>
	   		<option value="2">支付失败</option>
	   		<option value="3">未签名</option>
	   		<option value="4">正在处理</option>
	   		<option value="5">交易成功</option>
	   		<option value="6">交易失败</option>
	   	</select>
	   	</span>
	   </td>
	  </tr>
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
		//window.parent.submitEditCheck($("#dlgform"),$("input[name=uuid]").val());
	});
	$("#btnclose").click(function(){
		window.parent.closeEditDialog();
	});
	$("select[name=odTakeaccount]").val("${mObject.odTakeaccount}");
	$("select[name=odTaketype]").val("${mObject.odTaketype}");
	$("select[name=odType]").val("${mObject.odType}");
	$("select[name=odStat]").val("${mObject.odStat}");
	disableItem($("select[name=odTakeaccount]"));
	disableItem($("select[name=odTaketype]"));
	disableItem($("select[name=odType]"));
	disableItem($("select[name=odStat]"));
</script>
</body>
</html>