<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-form.css">
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/dictjson.js"></script>
<script type="text/javascript">
	var basepath = "<%=WebConfig.getProperty("web.path")%>";
</script>
<title>修改密码</title>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
	<form id="dlgform">
	 <table class="formtable" style="width:60%;margin:0 auto;margin-top:50px;">
	  <tr>
	   <td class="tdLabel" width="20%">输入原密码：</td>
	   <td class="tdContent" width="80%"><input type="password" name="oldpwd" value="" /></td>
	  </tr>
	  <tr>
	  <tr>
	   <td class="tdLabel">输入新密码：</td>
	   <td class="tdContent"><input type="password" name="newpwd" value="" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">重复新密码：</td>
	   <td class="tdContent"><input type="password" name="renewpwd" value="" /></td>
	  </tr>
	 </table>
	</form>
    <div id="btnarea">
  	<div class="btncommon" id="btnsubmit">立即修改</div>
  </div>
</body>
<script type="text/javascript">
	$("#btnclose").click(function(){
		window.parent.closeEditDialog();
	});
	$("#btnsubmit").click(function(){
		var saveurl = "/"+basepath+"/user/chgpwd/save/normal";	
		$.ajax({
			cache: false,
			type: "POST",
			url:saveurl,//"dbmgr/sysuser/save.json",
			data:$("#dlgform").serialize(),
			dataType: "json",
			async: false,
			error: function(request) {
				alert("提交失败！");
			},
			success: function(data) {
				var res = data.result;
				if(res=="0"){
					alert("修改提示：密码修改成功！");
				}else if(res=="2"){
					alert("修改失败：密码规则有误！");
				}else if(res=="3"){
					alert("修改失败：原密码不正确！");
				}else{
					alert("修改失败：请联系管理员！");
				}
			}
		});
	});
</script>
</html>