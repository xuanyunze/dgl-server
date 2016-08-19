<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-form.css">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-page.css">
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/common.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/rxwebui-page.js"></script>
<script type="text/javascript">
	var basepath = "<%=WebConfig.getProperty("web.path")%>";
</script>
<style>
table.report{
	width:98%;border:1px solid #CCDDCC;margin:0 auto;
}
table.report td{
	font-size:12px;height:24px;border-top:1px dashed #CCC;
}
table.report tr.title td{
	font-weight:bold;font-size:13px;border-top:none;
}
#reportcontent ul,li{
	list-style-type:none;list-style-image:url("/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/jquery-treeview/images/minus.gif");margin:10px;padding:0;text-indent:0;
}
#reportcontent span.content{
	display:-moz-inline-box;
	display:inline-block;
	width:150px;
}
</style>
<title>平台报表查询</title>
</head>
<body style="margin:5px 5px auto;padding:0 0 auto;">
	<div style="font-size:35px;color:#888;text-align:center;width:100%;padding-top:120px;">欢迎使用综合金融管理平台～</div>
</body>
<script type="text/javascript">

</script>
</html>