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
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/js/jquery.fn.js"></script>
<script type="text/javascript">
	var basepath = "<%=WebConfig.getProperty("web.path")%>";
</script>
<title>实名认证审批</title>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
<div id="in_progressBar" class="progressBar" style="z-index:99;display:none;">数据处理中，请稍等...</div>
	<form id="dlgform">
	<div style="display:none"><input name="uuid" value="${mObject.uuid}"></div>
	 <table class="formtable" style="width:90%;margin:0 auto;">
	  <tr>
	   <td class="tdLabel" width="15%">用户ID：</td>
	   <td class="tdContent" width="35%"><input style="border:none;background:none;" readonly name="uid" value="${mObject.wfUid}" /></td>
	   <td class="tdLabel" width="15%">真实姓名：</td>
	   <td class="tdContent" width="35%"><input style="border:none;background:none;" readonly name="uname" value="${mObject.wfRealname}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">证件类型：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="uidtype" value="${mObject.wfIdtype}" /></td>
	   <td class="tdLabel">证件号码：</td>
	   <td class="tdContent"><input style="border:none;background:none;" readonly name="uidcard" value="${mObject.wfIdno}" /></td>
	  </tr>
	  <tr>
	  </tr>
	  <tr><td class="tdLabel" colspan=3>身份证正面图片：</td><td style="text-align:right;cursor:pointer;"><img src="/<%=WebConfig.getProperty("web.path")%>/static/images/roleft.png" style="width:25px;height:25px;margin-right:10px;" onclick="fnRotate('left','img_pos')" /><img src="/<%=WebConfig.getProperty("web.path")%>/static/images/roright.png" style="width:25px;height:25px;" onclick="fnRotate('right','img_pos')"/></td></tr>
	  <tr><td class="tdLael" colspan=4><img id="img_pos" src="/<%=WebConfig.getProperty("web.path")%>/image/all/pos/${mObject.wfUid}" /></td></tr>
	  <tr><td class="tdLabel" colspan=3>身份证背面图片：</td><td style="text-align:right;cursor:pointer;"><img src="/<%=WebConfig.getProperty("web.path")%>/static/images/roleft.png" style="width:25px;height:25px;margin-right:10px;" onclick="fnRotate('left','img_nag')" /><img src="/<%=WebConfig.getProperty("web.path")%>/static/images/roright.png" style="width:25px;height:25px;" onclick="fnRotate('right','img_nag')"/></td></tr>
	  <tr><td class="tdLael" colspan=4><img id="img_nag" src="/<%=WebConfig.getProperty("web.path")%>/image/all/nag/${mObject.wfUid}" /></td></tr>
	  <tr><td class="tdLabel" colspan=3>手持身份证图片：</td><td style="text-align:right;cursor:pointer;"><img src="/<%=WebConfig.getProperty("web.path")%>/static/images/roleft.png" style="width:25px;height:25px;margin-right:10px;" onclick="fnRotate('left','img_self')" /><img src="/<%=WebConfig.getProperty("web.path")%>/static/images/roright.png" style="width:25px;height:25px;" onclick="fnRotate('right','img_self')"/></td></tr>
	  <tr><td class="tdLael" colspan=4><img id="img_self" src="/<%=WebConfig.getProperty("web.path")%>/image/all/self/${mObject.wfUid}" /></td></tr>
	  <tr>
	   <td class="tdLabel">联网信息：</td><td colspan=3 id="certifyinfo" style="color:red"></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">审批结果：</td>
	   <td class="tdContent" colspan=3>
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
    <div class="btncommon" id="btncertify">联网认证</div>
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
	$("#btncertify").click(function(){
		fnDoCertify();
	});
function fnDoCertify(){
	var saveurl = "/"+basepath+"/certify/realname/json/manage";
	var uname = $("input[name=uname]").val();
	var idcard = $("input[name=uidcard]").val();
	startDealing();
	$.ajax({
		cache: false,
		type: "POST",
		url:saveurl,
		data:"&uname="+uname+"&uidcard="+idcard,
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
function fnRotate(dirct,imgid){
	if(dirct=='left'){
		$("#"+imgid).rotate(-90);
	}else if(dirct=='right'){
		$("#"+imgid).rotate(90);
	}
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