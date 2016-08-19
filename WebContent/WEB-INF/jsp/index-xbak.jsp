<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<%@ page import="com.rxoa.mypay.sys.auth.SessionMgr"%>
<%@ page import="com.rxoa.mypay.base.security.WebSessionEntity"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache" />  
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" /> 
<link rel="stylesheet" type="text/css" href="static/rxwebui/jquery-ui-1.11.3/jquery-ui.min.css">
<link rel="stylesheet" type="text/css" href="static/rxwebui/jquery-treeview/jquery.treeview.css">
<link rel="stylesheet" type="text/css" href="static/rxwebui/css/global.css">
<link rel="stylesheet" type="text/css" href="static/rxwebui/css/index.css">
<link rel="stylesheet" type="text/css" href="static/rxwebui/css/navleft.css">
<script type="text/javascript" src="static/rxwebui/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="static/rxwebui/jquery-ui-1.11.3/jquery-ui.min.js"></script>
<script type="text/javascript" src="static/rxwebui/jquery-treeview/jquery.treeview.js"></script>
<script type="text/javascript" src="static/rxwebui/js/common.js"></script>
<script type="text/javascript" src="static/rxwebui/js/rxwebui-1.0.min.js"></script>
<script type="text/javascript" src="static/rxwebui/js/rxwebui-form.js"></script>
<script type="text/javascript" src="static/rxwebui/js/rxwebui-index.js"></script>
<script type="text/javascript" src="static/js/index.js"></script>
<title><%=WebConfig.getProperty("web.title")%></title>
<script type="text/javascript">
	var basepath = "<%=WebConfig.getProperty("web.path")%>";
	var sessioninfo = SessionInfo.init("/"+basepath+"/websession/session.json",fnStrtoJson('<%=SessionMgr.getWebSession(request).toJson().toString()%>'));
	//var sessioninfo = SessionInfo.init("/"+basepath+"/websession/session.json",<%=request.getAttribute("mObject") %>);
</script>
</head>
<body style="margin:0 auto;">
 <div style="display:none;" id="dialog" title="basic dialog"><p>这是一个采用默认样式的对话框</p></div>
 <!-- 页面框架主体 -->
 <div id="divmain">
 <!-- 顶部信息区 -->
  <div id="divtop">
   <div id="logo">
    <div id="logoimg" style="margin-left:30px;float:left;margin-top:5px;"><img src="static/images/mp-logo2.png" style="height:45px;"></div>
    <div id="logotext" style="float:left;font-size:22px;padding-top:16px;padding-left:10px;color:#F0F0F0;font-family:KaiTi">综合金融管理平台</div>
      <div id="topbtn" style="float:right;padding-right:20px;padding-top:5px;display:inline;">
    <div id="logohello" style="font-size:12px;float:left;margin-right:10px;color:#CCCC00">您好，李白！</div>
    <div id="divlogout" onclick="fnLogout()" style="float:left;font-size:12px;cursor:pointer;color:#FCFCFC;">
	 <a href="javascript:fnLogout();return false;">退出系统</a>
	</div>
   	<div id="logonow" style="font-size:12px;color:#222;clear:both;margin-top:30px;text-align:right;font-family:隶书"></div>
   </div>
    <ul id="nav_main">
     <li class="nav_main_item">
      <a href="#">首页</a>
     </li>
    </ul>
   </div>
  </div>
  <!-- 中间信息区 -->
  <div id="divmiddle">
   <!-- 左侧导航区 -->
   <div id="divleft" style="overflow-x:auto;">
   	<div id="divlefttree">
   	 <div id="leftwiget" style="height:30px;"></div>
   	 <div class="subNavBox" style="height:330px;"></div>
   	  <div id="msgpush" style="dispaly:block;">
   	   <div id="leftmsgbox">
   	    <h2>消息控制台</h2>
   	    <div id="msg_push_content">
   	     <div style="word-wrap: break-word; word-break: normal;"><p>
   	     <em style="height:5.4em;overflow:hidden;text-overflow:ellipsis;">
   	      金融综合平台V3.0正式发布，该平台致力于打造金融支付、理财、电商业务综合生态圈，通过多业务综合集成的模式，已在交通、美容、物业等行业取得良好的业绩和影响力。
   	     </em>2015-11-26 17:29:35</p></div>
   	    </div>
   	   </div>
   	  </div>
   	 </div>
   	<div id="divleftbutton" style="background:transparent;">
   	 <a class="sidebar-toggle toggle-show"></a>
   	</div>
   </div>
   <!-- 右侧主体区 -->
   <div id="divright" style="overflow-y:hidden;">
	<div id="divrighttab">
		
	</div>
	<div id="divrightwindow" style="border:none;margin:0;padding:0;font-size:13px;">
	 <div id="win1" style="margin:0;padding:0;border:none;width:inherit;height:inherit;">
	 </div>
	 <div id="win2">
	 </div>
	</div>
   </div>
  </div>
  <!-- 底部信息区 -->
  <div id="divbottom">
  </div>
  <div id="index-dialog-form" title="Dialog" style="margin:0;padding:0;"></div>
 </div>
 
<script type="text/javascript">
    var winWidth=0;
    var winHeight=0;
    initIndex(); //初始化框架页面；
    $("#divleftbutton").click(fnExpandNav); //绑定边栏事件
    window.onresize = initIndex;
    $(document).ready(function(){
    	//fnLoadMainPage("/"+basepath+"/dbmgr/sysorg/page/normal/1/15");
    	fnLoadMainPage("/"+basepath+"/user/showinfo/normal");
    });
	
    $(document).ready(function(){
    	$.ajax({
        	type : "GET",
 			url : "nav/navall.json",
			data : "",
			dataType: "text",
			success : function(msg) {
				fnCreateNav(msg);
			}
    	});
    });
	
    $("#click").click(function(){
    	alert(sessioninfo.userid);
    	alert(sessioninfo.logintime);
    	$("#logohello").html(sessioninfo.username+",欢迎登陆系统!");
    });
    $("#logonow").html(Calendar.init().getDateText()+" "+Calendar.init().getDayText());
    $("#logohello").html(sessioninfo.username+"，欢迎登陆～");
    initIndex();
</script>
</body>
</html>