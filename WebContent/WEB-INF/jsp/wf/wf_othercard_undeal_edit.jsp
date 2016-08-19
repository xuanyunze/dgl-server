<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../sections/page_header.jsp" %>
<script type="text/javascript">
	var basepath = "<%=WebConfig.getProperty("web.path")%>";
</script>
<title>超级认证审核</title>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
<div id="in_progressBar" class="progressBar" style="z-index:99;display:none;">数据处理中，请稍等...</div>
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
	   <td class="tdLabel">真实姓名：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="realname" value="${mObject.wfAccname}" /></td>
	   <td class="tdLabel">身份证号：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="idcardno" value="${idcardno}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">银行卡号：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="cardno" value="${mObject.wfAccno}" /></td>
	   <td class="tdLabel">银行卡类型：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="cardtype" value="信用卡" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">有效日期：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="validate" value="${mObject.wfVdate}" /></td>
	   <td class="tdLabel">安全码：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="vcode" value="${mObject.wfVcode}" /></td>
	  </tr>
	  <tr><td class="tdLabel" colspan=4>银行卡正面图片：</td></tr>
	  <tr><td class="tdLael" colspan=4><img src="/<%=WebConfig.getProperty("web.path")%>/image/bankcard/all/pos/${mObject.wfUid}/${mObject.wfAccno}" /></td></tr>
	  <tr>
	   <td class="tdLabel">联网信息：</td><td colspan=3 id="certifyinfo" style="color:red"></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">审批结果：</td>
	   <td class="tdContent" colspan=3>
	   	 <input type="radio" name="result" value="1" checked />通过
	   	 <input type="radio" name="result" value="0" />驳回
	   </td>
	  </tr>
	  <tr>
	   <td class="tdLabel">常用意见：</td>
	   <td class="tdContent" colspan=3>
	   	<select name="cyyj" onchange="fnSwitchYj(this)">
	   	 <option>---选择常用意见---</option>
	   	 <option>信用卡有效期格式填写错误～</option>
	   	 <option>信用卡安全码填写错误～</option>
	   	 <option>信用卡照片拍摄不清晰～</option>
	   	</select>
	   </td>
	  </tr>
	  <tr>
	   <td class="tdLabel">审批意见：</td>
	   <td class="tdContent" colspan=3>
	   	<textarea id="spyj" name="spyj" rows=3 style="width:100%;"></textarea>
	   </td>
	  </tr>
	 </table>
	</form>
  <div id="btnarea">
    <div class="btncommon" id="btncertify">联网认证</div>
  	<div class="btncommon" id="btnsubmit">提交审批</div>
  	<div class="btncommon" id="btnclose">关闭页面</div>
  </div>
<script type="text/javascript">
$("#btncertify").click(function(){
	fnDoCertify();
});
$("#btnsubmit").click(function(){
	window.parent.submitEditCheck($("#dlgform"),$("input[name=uuid]").val());
});
$("#btnclose").click(function(){
	window.parent.closeEditDialog();
});
function fnSwitchYj(obj){
	if(obj.options[obj.selectedIndex].text=="---选择常用意见---"){
		$("#spyj").val("");
	}else{
		$("#spyj").val(obj.options[obj.selectedIndex].text);
	}
}
function fnDoCertify(){
	var saveurl = "/"+basepath+"/certify/bankcard3/json/manage";
	var uname = $("input[name=uname]").val();
	var idcard = $("input[name=idcardno]").val();
	var cardno = $("input[name=cardno]").val();
	startDealing();
	$.ajax({
		cache: false,
		type: "POST",
		url:saveurl,
		data:"&uname="+uname+"&uidcard="+idcard+"&cardno="+cardno,
		dataType: "json",
		async: true,
		error: function(request) {
			 stopDealing();
			alert("提交请求失败～");
		},
		success: function(data) {
			 stopDealing();
			 $("#certifyinfo").html(data.res);
		}
	});
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