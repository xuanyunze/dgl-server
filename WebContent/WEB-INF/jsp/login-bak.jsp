<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ϵͳ��¼</title>
<style>
#mtable {width:360px;height:260px;border:1px solid #ccc;margin-top:120px;font-size:12px;}
#mtable .mlabel{font-size:12px;color:#333;text-align:right;}
#mtable .minput{font-size:12px;}
#mtable tr{height:50px;}
</style>
<script type="text/javascript">
	function fnLogin(){
		var form = document.getElementById("loginform");
		form.submit();
	}
</script>
</head>
<body style="background:#eee;margin:auto;">
	<%
		String code = request.getParameter("errcode");
		String tipinfo = "";
		if(code!=null&&code.equals("1")){
			tipinfo = "<b>�ᡡʾ��</b>�û��������벻��ȷ��";
		}else if(code!=null&&code.equals("2")){
			tipinfo = "<b>�ᡡʾ��</b>���ȵ�¼���в�����";
		}
	%>
	<form id="loginform" name="loginform" action="login" method="post">
	<table id="mtable" align=center>
		<tr style="height:20px;">
			<td colspan=2></td>
		</tr>
		<tr style="height:30px;">
			<td colspan=2 style="padding-left:65px;color:red;"><%=tipinfo%></td>
		</tr>
		<tr style="height:30px;">
			<td class="mlabel" width=30%><b>�û���</b></td>
			<td class="minput" width=70% style="padding-left:10px;"><input name="userId" /></td>
		</tr>
		<tr style="height:30px;">
			<td class="mlabel"><b>�ܡ���</b></td>
			<td style="padding-left:10px;"><input type="password" name="userPwd" /></td>
		</tr>
		<tr style="height:60px;">
			<td></td>
			<td>
				<input type="button" value="�ǡ�¼" onclick="fnLogin()" />
				<span style="wdith:60px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<input type="button" value="ȡ����" onclick="fnCancel()" />
			</td>
		</tr>
	</table>
	<div style="width:360px;text-align:center;margin-top:20px;margin-left:auto;margin-right:auto;"><font color="#ff666666">��ܰ��ʾ��</font>ϵͳ���������У�����¼����������...<br><br>�Ƽ�ʹ�ùȸ������<a href="https://www.baidu.com/link?url=cv74pXRIyQ4ii06iskwjpOyZ0Nupduy3HDsr6RGmIMZSozuzClC087j4u0IAlwKfwdi1MGOiwmWTSM6IFjQZ6q&wd=&eqid=a3009f6c0001e94900000004555c5124&ie=utf-8">�������</a></div>
	</form>
</body>
</html>