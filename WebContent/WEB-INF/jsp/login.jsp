<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>系统登录</title>
<link rel="stylesheet" type="text/css" href="../static/rxwebui/css/login.css">
<style>
#mtable {width:360px;height:260px;border:1px solid #ccc;margin-top:120px;font-size:12px;}
#mtable .mlabel{font-size:12px;color:#333;text-align:right;}
#mtable .minput{font-size:12px;}
#mtable tr{height:50px;}
</style>
<style type="text/css">
	.login-item {margin-bottom:18px;height:22px;}
	.login-item label {padding:0px 1em 0 5px;position:relative;right:-10px;top:4px;}
	[lang=en] .login-item label {right:10px;}
	.login-item input {position:absolute;right:25px;}
	.login-control {height:35px;padding-top:15px;}
	.login-control input {position:relative;right:-17px;}
	.login-control label {position:relative;right:-16px;bottom:2px;}
	.login-btn {margin-left:0;position:absolute;right:25px;bottom:67px;font-family:Tahoma,Geneva,simsun;}
	.remember {font-family:Tahoma,Geneva,simsun;}
</style>
<script type="text/javascript">
	function fnLogin(){
		var form = document.getElementById("loginform");
		form.submit();
	}
	if(window!=top){
		top.location.href = window.location.href;
	}
</script>
</head>
<body style="margin:auto;">	
	<%
		String code = request.getParameter("errcode");
		String tipinfo = "";
		if(code!=null&&code.equals("1")){
			tipinfo = "<b>提　示：</b>用户名或密码不正确！";
		}else if(code!=null&&code.equals("2")){
			tipinfo = "<b>提　示：</b>请先登录进行操作！";
		}
	%>
	<form id="loginform" name="loginform" action="login" method="post">
	<div class="header">
	<div class="header-content">
		<h1 class="logo">login-logo</h1>
	</div>
	</div>

	<div class="main">
		<div class="login">
		<div id="download"><a href="#"><span>[应用程序安装]</span></a></div>
		<div class="locale" style=""><span data-string-id="indiplatform.workplace.selectlocale">语言选择</span>
			<input name="%%Surrogate_locale" type="hidden" value="1">
			<select name="locale">
			<option value="zh-cn">简体中文
			</option><option value="en">English</option></select>
		</div>
    	<div class="login-content">
         	<!--[if lt IE 8]>
				<div style="visibility: hidden;">
         	<![endif]-->
        	<div class="login-list">
        		<div class="login-item">
        			<label for="un"><span>用户名</span></label><input name="userId" id="un" type="text" onkeypress="if(getKeyCodePressed(event)==13) {document.getElementsByName('Password')[0].focus();document.getElementsByName('Password')[0].select();}">
        		</div>
        		<div class="login-item">
        			<label for="pwd"><span>密 码</span></label><input name="userPwd" id="pwd" type="password" onkeypress="if(getKeyCodePressed(event)==13) {tologin();return false;} else capsDetect(event);">
        		</div>
        	</div>
            <div class="login-control">
        		<input name="savePWD" id="savePWD" type="checkbox" onclick="return fnSavePSW(this)"><label class="remember" for="savePWD"><span data-string-id="indiplatform.workplace.rembpw">记住密码</span></label>
        		<div class="login-btn" onselectstart="return false;" onclick="fnLogin()"><span data-string-id="indiplatform.workplace.signin">登 录</span></div>
        	</div>
			<!--[if lt IE 8]>
				</div>
			<![endif]-->
            <div class="login-msg"><%=tipinfo %>
				<em id="msg-caps-lock" style="display:none;"><span data-string-id="indiplatform.workplace.upper">键盘已启动大写锁！</span></em>
				<!--[if lt IE 8]>
					<em id="msg-browser"><span data-string-id="indiplatform.workplace.browserInfo">当前使用的浏览器版本过低，建议您使用Firefox或IE8以上版本</span></em>
				<![endif]-->
		  	</div>
        	</div>
        	<div class="login-shadow"></div>
    	</div>
	</div>
	<div class="footer"><span>支持浏览器版本</span>IE11.0.9600.17501、chrome39.0.2171.71、firefox34.0.5<br>
		<span>登录时遇到问题，请联系系统支持管理员：400-6456-606</span>
	</div>

<!--
<input type="submit" value="">-->
<input name="RedirectTo" value="/indishare/securtrac.nsf/agttrac?openagent&amp;url=/indishare/office.nsf/(frame)/index" type="hidden"></form>

</body>
</html>