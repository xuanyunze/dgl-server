<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<%@ page import="com.rxoa.mypay.sys.auth.SessionMgr"%>
<%@ page import="com.rxoa.mypay.base.security.WebSessionEntity"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../sections/page_header.jsp" %>
<script type="text/javascript">
	var basepath = "<%=WebConfig.getProperty("web.path")%>";
	var sessioninfo = SessionInfo.init("/"+basepath+"/websession/session.json",fnStrtoJson('<%=SessionMgr.getWebSession(request).toJson()%>'));
	var treeinfo = TreeInfo.init(sessioninfo.orgid);
	var pageinfo = PageInfo.init();
	pageinfo.pageUrl = "/<%=WebConfig.getProperty("web.path")%>/dbmgr/sysuser/page.json/normal";
	pageinfo.styleJson = "{'pStyle':{'tableStyle':{'tableCol':[{'colName':'uid','colText':'用户ID','colWidth':'100px;','linkStat':'0','orderStat':'0'},{'colName':'uname','colText':'用户姓名','colWidth':'100px;','linkStat':'0','orderStat':'0'},{'colName':'umail','colText':'用户邮箱','colWidth':'150px;','linkStat':'0','orderStat':'0'},{'colName':'uphone','colText':'手机号码','colWidth':'100px','linkStat':'0','orderStat':'0'},{'colName':'creTime','colText':'注册时间','colWidth':'150px;','linkStat':'0','orderStat':'0'}]}}}";
	pageinfo.crumbString = "系统管理,用户管理";
</script>
<title>Insert title here</title>
</head>
<body style="margin:0;pdding:0px;auto;width:100%;height:inherit;overflow:hidden;">
 <div id="progressBar" class="progressBar" style="display: none; ">数据加载中，请稍等...</div>
 <div id="divpage">
  <div id="lcatetree" style="display:none;position:absolute;margin:0;padding:0;left:0;top:0;bottom:0;width:200px;overflow:hidden;;border-right:1px dashed #ccc;">
   <div id="orgtree" style="width:100%;height:100%;overflow:auto;margin:0;padding:0;border:none;white-space:nowrap;">
    <ul id="uorgtree" class="filetree" style="overflow:visiable"></ul>
   </div>
  </div>
  <div id="ucontent" style="position:absolute;left:0;top:0;bottom:0;right:0;">
    <%@ include file="../sections/page_search.jsp" %>
    <%@ include file="../sections/page_supersearch.jsp" %>
	<%@ include file="../sections/page_pagination_top.jsp" %>
	<div id="mtmaindiv" style="width:100%;overflow-x:auto;position:absolute;top:125px;bottom:40px;left:0;overflow-y:hidden;">
     <div id="maintablediv" style="width:900px;">
 	  <div style="width:900px;"><table id="titletable"></table></div>
 	  <div id="naintabledivx" style="width:900px;position:absolute;top:28px;bottom:0;left:0;overflow-y:auto;"><table id="maintable"></table></div>
	 </div>
	</div>
	<%@ include file="../sections/page_pagination_bottom.jsp" %>
   </div>
  </div>
  <div id="dialog-form" title="Dialog" style="margin:0;padding:0;"></div>
<script type="text/javascript">
$(document).ready(function(){
	//resizePage();
	//window.onresize = resizePage;
	fnExpandTreeNav();
	$(function(){
		if(pageinfo.cateString==""){
			pageinfo.cateString = "uorgid='"+sessioninfo.orgid+"'";
		}
		$.ajax({
			type:"POST",
			url:pageinfo.pageUrl+"/"+pageinfo.curpage+"/"+pageinfo.psize,
			data:"cateString="+pageinfo.cateString+"&searchType="+pageinfo.searchType+"&order="+pageinfo.order+"&searchString="+encodeURIComponent(pageinfo.searchString),
			dataType:"json",
			success:function(msg){
				fnCreateTable(msg);
			}
		});
	});
});

$(function(){
	//resizePage();
	//window.onresize = resizePage;
	
	$("#topnew").click(function(){fnCreateItem();});
	$("#bottomnew").click(function(){fnCreateItem();});

	$.ajax({
    	type : "GET", 
		url : "/"+basepath+"/org/showtree.json/oemhq",
		data : "",
		dataType: "text",
		success : function(msg){
			fnCreateTree(msg);
		}
	});
	
});

function fnCreateItem(){
	fnCreateEditDlg(
			"self","dialog-form","创建新用户",
			"/"+basepath+"/dbmgr/sysuser/add/normal/"+treeinfo.curnode,
			"/"+basepath+"/dbmgr/sysuser/save.json/normal",
			"保存成功！","提交失败！"
		);
}
function fnEditItem(itemid){
	fnCreateEditDlg(
		"self","dialog-form","编辑用户",
		"/"+basepath+"/dbmgr/sysuser/edit/normal/"+itemid,
		"/"+basepath+"/dbmgr/sysuser/update.json/normal/"+itemid,
		"保存成功","保存失败"
	);
}
function fnShowItem(itemid){
	fnCreateShowDlg(
		"self","dialog-form","查看用户信息",
		"/"+basepath+"/dbmgr/sysuser/show/normal/"+itemid
	);
}
function fnDeleteItem(itemid){
	if(confirm("要删除该条数据吗?")){
		$.ajax({
        	type : "GET", 
 			url : "/"+basepath+"/dbmgr/sysuser/del.json/normal/"+itemid,
			data : "",
			dataType: "text", 
			error: function(request){
				alert("发送请求失败！");
			},
			success : function(msg) {
				alert("删除数据成功！");
				fnRefreshTable("/"+basepath+"/dbmgr/sysuser/page.json/normal/1/30");
			}
		});
	}
}
function fnOrgTreeClick(obj){
	var orgid = obj.parentNode.id;
	pageinfo.cateString = "uorgid = '"+orgid.substring(2)+"'";
	treeinfo.curnode = orgid.substring(2);
	fnRefreshPage();
}
function submitAddCheck(obj){
	var saveurl = "/"+basepath+"/dbmgr/sysuser/save.json/normal";	
	$.ajax({
		cache: false,
		type: "POST",
		url:saveurl,//"dbmgr/sysuser/save.json",
		data:$('#dlgframe').contents().find("#dlgform").serialize(),
		dataType: "json",
		async: false,
		error: function(request) {
			alert("提交失败！");
		},
		success: function(data) {
			var res = data.result;
			if(res=="0"){
				FormDialog.init($("#dialog-form")).close("提交成功...",4);
			}else if(res=="2"){
				alert("添加失败：用户已存在！");
			}else{
				alert("提交失败：过程出错，请联系管理员！");
			}
		}
	});
}
function submitEditCheck(obj,itemid){
	var saveurl = "/"+basepath+"/dbmgr/sysuser/update.json/normal/"+itemid;	
	$.ajax({
		cache: false,
		type: "POST",
		url:saveurl,//"dbmgr/sysuser/save.json",
		data:$('#dlgframe').contents().find("#dlgform").serialize(),
		dataType: "json",
		async: false,
		error: function(request) {
			alert("提交失败！");
		},
		success: function(data) {
			var res = data.result;
			if(res=="0"){
				FormDialog.init($("#dialog-form")).close("提交成功...",4);
			}else{
				alert("添加失败：请联系管理员！");
			}
		}
	});
}
function closeEditDialog(){
	$("#dialog-form").dialog("close");
}
function closeEditDialog(obj,sec){
	if(typeof(obj)=="undefined"||typeof(sec)=="undefined"){
		$("#dialog-form").dialog("close");
	}else{
		FormDialog.init($("#dialog-form")).close("提交成功...",4);
	}
}
</script>
</body>
</html>