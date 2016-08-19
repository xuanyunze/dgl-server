<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
	<form id="dlgform" action="" method = "post">
		<div style="display:none">
			<input name="uuid" value="${mObject.uuid}" />
		</div>
		用户ID：<input name="uid" value="${mObject.uid}" />
		用户名：<input name="uname" value="${mObject.uname}" />
		密　码：<input name="upwd" value="${mObject.upwd}" />
		手　机：<input name="uphone" value="${mObject.uphone}" />
	</form>
<script type="text/javascript">
	function fnSubmitCheck(){
		
	}
</script>
</body>
</html>