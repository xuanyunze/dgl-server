<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#dlgform input{border:none;readonly}
</style>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
	<form id="dlgform">
		用户ID：<span>${mObject.uid}</span>
		用户名：<span>${mObject.uname}</span>
		密　码：<span>${mObject.upwd}</span>
		手　机：<span>${mObject.uphone}</span>
	</form>
</body>
</html>