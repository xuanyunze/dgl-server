<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
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
	 <table class="formtable" style="width:60%;margin:0 auto;">
	  <tr>
	   <td class="tdLabel" width="20%">用户ID：</td>
	   <td class="tdContent" width="80%"><input name="uid" value="${mObject.uid}" disabled/></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">用户名：</td>
	   <td class="tdContent"><input name="uname" value="${mObject.uname}"/></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">用户邮箱：</td>
	   <td class="tdContent"><input name="umail" value="${mObject.umail}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">用户手机：</td>
	   <td class="tdContent"><input name="uphone" value="${mObject.uphone}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">固定电话：</td>
	   <td class="tdContent"><input name="utelephone" value="${mObject.utelephone}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">用户职位：</td>
	   <td class="tdContent"><input name="uposition" value="${mObject.uposition}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">用户身份：</td>
	   <td class="tdContent">
	   <span class="styled-select">
	   	<select name="uroleid"></select>
	   	</span>
	   </td>
	  </tr>
	  <tr>
	   <td class="tdLabel">所属机构：</td>
	   <td class="tdContent"><span>${mObject.uorgid}(ID:${mObject.uorgid})</span><input style="display:none" name="uorgid" readonly value="${mObject.uorgid}" /></td>
	  </tr>
	 </table>
	</form>
	  <div id="btnarea">
	<div class="btncommon" id="btnresetpwd">重置密码</div>
  	<div class="btncommon" id="btnsubmit">保存修改</div>
  	<div class="btncommon" id="btnclose">关闭页面</div>
  </div>
  <script type="text/javascript">
  	$(function(){
  		var targetotype = "${targetotype}";
  		if(targetotype==1||targetotype==2){
  			//vhtml = "<option value='1'>管理机构</option><option value='2'>管理机构-部门</option><option value='3'>运营机构(OEM)</option><option value='5'>分销机构(代理)</option>";
  			vhtml = "<option value='1000000110'>系统管理员</option>"
  				+"<option value='1000000102'>客服管理员</option>"
  				+"<option value='1000000103'>清算管理员</option>"
  				+"<option value='1000000000'>普通员工</option>";
  			$("select[name=uroleid]").html(vhtml);
  		}else if(targetotype==3||targetotype==5){
  			vhtml = "<option value='1000000301'>机构管理员</option><option value='1000000000'>普通员工</option>";
  			$("select[name=uroleid]").html(vhtml);
  		}
  		$("select[name=uroleid]").val("${mObject.uroleid}");
  	});
  	$("#btnsubmit").click(function(){
		window.parent.submitEditCheck($("#dlgform"),"${mObject.uuid}");
	});
	$("#btnclose").click(function(){
		window.parent.closeEditDialog();
	});
	$("#btnresetpwd").click(function(){
		submitResetpwd();
	});
	
	function submitResetpwd(){
		var saveurl = "/"+basepath+"/dbmgr/sysuser/resetpwd.json/normal/${mObject.uuid}";
		startDealing();
		$.ajax({
			cache: false,
			type: "POST",
			url:saveurl,
			data:$("#dlgform").serialize(),
			dataType: "json",
			async: true,
			error: function(request) {
				 stopDealing();
				alert("提交失败～");
			},
			success: function(data) {
				 stopDealing();
				 alert("重置成功～");
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