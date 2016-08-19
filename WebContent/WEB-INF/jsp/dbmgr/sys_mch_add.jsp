<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册新用户</title>
<style>
body{
	background:#FCFCFE
}
.formtable{
 	border:none;margin:0;font-size;13px;font-family:微软雅黒；
}
.formtable td{ font-size:13px;border-bottom:2px dotted #EEDDDD; height:30px;}
.formtable tdTitle{
}
.formtable input{border-radius:2px 2px 2px 2px;box-shadow:0 0 1px 0 rgba(0,0,0,0.1) inset;border:1px solid #BFBFBF;text-indent:0.2em;height:20px;line-height:20px;width:260px;}
.formtable tdLabel{
	text-align:right;padding-right:3px;
}
</style>
</head>
<body style="margin:5px 5px;pdding:0px;">
	<form id="dlgform">
	 <table class="formtable" style="width:60%;margin:0 auto;">
	  <tr>
	   <td class="tdLabel" width="20%">用户ID：</td>
	   <td class="tdContent" width="80%"><input name="uid" value="" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">用户名：</td>
	   <td class="tdContent"><input name="uname" value="" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">用户邮箱：</td>
	   <td class="tdContent"><input name="umail" value="" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">用户手机：</td>
	   <td class="tdContent"><input name="uphone" value="" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">固定电话：</td>
	   <td class="tdContent"><input name="utelephone" value="" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">默认密码：</td>
	   <td class="tdContent"><input type="password" name="upwd" value="" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">用户职位：</td>
	   <td class="tdContent"><input name="uposition" value="" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">所属机构：</td>
	   <td class="tdContent"><span>${targetoname}(ID:${targetoid})</span><input style="display:none" name="uorgid" readonly value="${targetoid}" /></td>
	  </tr>
	 </table>
	</form>
</body>
</html>