<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-form.css">
<script type="text/javascript" src="<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/jquery-1.11.2.min.js"></script>
<title>机构信息</title>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
	<form id="dlgform">
	 <table class="formtable" style="width:60%;margin:0 auto;">
	  <tr>
	   <td class="tdLabel" width="20%">用户ID：</td>
	   <td class="tdContent" width="80%"><input name="uid" value="${mObject.uid}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">用户名：</td>
	   <td class="tdContent"><input name="uname" value="${mObject.uname}" /></td>
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
	   <td class="tdLabel">默认密码：</td>
	   <td class="tdContent"><input type="password" name="upwd" value="${mObject.upwd}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">用户职位：</td>
	   <td class="tdContent"><input name="uposition" value="${mObject.uposition}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">所属机构：</td>
	   <td class="tdContent"><span>${mObject.uorgid}(ID:${mObject.uorgid})</span><input style="display:none" name="uorgid" readonly value="${mObject.uorgid}" /></td>
	  </tr>
	 </table>
	</form>
</body>
<script type="text/javascript">
	$(".formtable :input").addClass("input-disable");
	$(".formtable :input").attr("disabled",true);
</script>
</html>