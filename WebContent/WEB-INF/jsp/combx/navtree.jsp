<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache" />  
<meta http-equiv="Cache-Control" content="no-cache" />  
<meta http-equiv="Expires" content="0" /> 
<link rel="stylesheet" type="text/css" href="../static/rxwebui/jquery-ui-1.11.3/jquery-ui.min.css">
<link rel="stylesheet" type="text/css" href="../static/rxwebui/jquery-treeview/jquery.treeview.css">
<link rel="stylesheet" type="text/css" href="../static/rxwebui/css/global.css">
<link rel="stylesheet" type="text/css" href="../static/rxwebui/css/navleft.css">
<script type="text/javascript" src="../static/rxwebui/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="../static/rxwebui/jquery-ui-1.11.3/jquery-ui.min.js"></script>
<script type="text/javascript" src="../static/rxwebui/jquery-treeview/jquery.treeview.js"></script>
<script type="text/javascript" src="../static/rxwebui/js/common.js"></script>
<script type="text/javascript" src="../static/rxwebui/js/rxwebui-1.0.min.js"></script>
<script type="text/javascript" src="../static/js/index.js"></script>
<title>User List</title>
</head>
<body style="margin:0 auto;">
 <div style="display:none;" id="dialog" title="basic dialog"><p>这是一个采用默认样式的对话框</p></div>
 <!-- 页面框架主体 -->
 <div id="divlefttree">
  <div class="subNavBox">
  </div>	
 </div>
 
<script type="text/javascript">
    var winWidth=0;
    var winHeight=0;
    //initIndex(); //初始化框架页面；
    //$("#divleftbutton").click(fnExpandNav); //绑定边栏事件
    //window.onresize = initIndex;
    //$(function(){$("#dialog").dialog();});
    $(document).ready(function(){
    	$.ajax( {
        	type : "GET", 
 			url : "navone.json/t10",
			data : "",
			dataType: "text", 
			success : function(msg) { 
				fnCreateLeftNav(msg);
			}
    	});
    });
	function fnCreateLeftNav(strjson){
		var objjson = fnStrtoJson(strjson);
		$(".subNavBox").html("");
		var navobj = objjson.navtree.topCate[0];
		for(var i=0;i<fnGetJsonLength(navobj.leftCate);i++){
			var nul = "";
			if(objjson.navtree.curLeftCateId==navobj.leftCate[i].cateId){
				$(".subNavBox").append("<div class=\"subNav currentDd currentDt\">"+navobj.leftCate[i].cateName+"</div>");
				nul+="<ul class=\"navContent\" style=\"display:block\">";
			}else{
				$(".subNavBox").append("<div class=\"subNav\">"+navobj.leftCate[i].cateName+"</div>");
				nul+="<ul class=\"navContent\">";
			}
			for(var j=0;j<fnGetJsonLength(navobj.leftCate[i].leftNode);j++){
				nul+="<li><a href=\"#\">"+navobj.leftCate[i].leftNode[j].nodeName+"</a></li>";
			}
			$(".subNavBox").append(nul+"</ul>");
		}
	    $(function(){
	        $(".subNav").click(function(){
	        	$(this).toggleClass("currentDd").siblings(".subNav").removeClass("currentDd");
	            $(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt");
	            $(this).next(".navContent").slideToggle(300).siblings(".navContent").slideUp(500);
	          });
	    });
	}
</script>
</body>
</html>