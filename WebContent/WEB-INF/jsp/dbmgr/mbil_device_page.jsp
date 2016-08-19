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
	pageinfo.pageUrl = "/<%=WebConfig.getProperty("web.path")%>/dbmgr/mbildevice/page.json/normal";
	pageinfo.styleJson = "{'pStyle':{'tableStyle':{'tableCol':[{'colName':'deTid','colText':'设备编号(TID)','colWidth':'100px;','linkStat':'0','orderStat':'0'},{'colName':'deSn','colText':'序列号(SN)','colWidth':'150px;','linkStat':'0','orderStat':'0'},{'colName':'deType','colText':'设备类型','colWidth':'60px;','linkStat':'0','orderStat':'0'},{'colName':'deStat','colText':'设备状态','colWidth':'60px','linkStat':'0','orderStat':'0'},{'colName':'deUid','colText':'绑定用户','colWidth':'100px;','linkStat':'0','orderStat':'0'},{'colName':'creTime','colText':'注册时间','colWidth':'150px;','linkStat':'0','orderStat':'0'}]}}}";
	pageinfo.crumbString = "系统管理,移动设备管理";
</script>
<title>Insert title here</title>
</head>
<body style="margin:0;padding:0px;auto;width:100%;height:inherit;overflow:hidden;">
<div id="progressBar" class="progressBar" style="display:none;">数据加载中，请稍等...</div>
 <div id="divpage">
  <table id="mtable">
   <tr>
	<td id="tdtree" valign=top>
	 <div id="orgtree" style="height:100%;overflow:auto;margin:0;padding:0;">
  	  <ul id="uorgtree" class="filetree"></ul>
 	 </div>
	</td>
	<td id="ucontenttd">
	 <div id="users-contain">
	   <%@ include file="../sections/page_search.jsp" %>
	   <%@ include file="../sections/page_pagination_top.jsp" %>
	   <div id="tmaindiv" style="width:100%;overflow-x:auto;">
		<div id="maintablediv" style="width:1000px;">
 			<table id="titletable"></table>
 			<div id="naintablediv" style="width:1000px;">
  				<table id="maintable"></table>
  			</div>
		</div>
	   </div>
       <%@ include file="../sections/page_pagination_bottom.jsp" %>
     </div>
	</td>
   </tr>
  </table>
 </div>
  <div id="dialog-form" title="Dialog" style="margin:0;padding:0;"></div>
<script type="text/javascript">
$(document).ready(function(){
	resizePage();
	window.onresize = resizePage;
	
	$(function(){
		if(pageinfo.cateString==""){
			pageinfo.cateString = "deOrg='"+sessioninfo.orgid+"'";
		}
		$.ajax({
			type:"POST",
			url:pageinfo.pageUrl+"/"+pageinfo.curpage+"/"+pageinfo.psize,
			data:"cateString="+pageinfo.cateString+"&searchType="+pageinfo.searchType+"&order="+pageinfo.order+"&searchString="+encodeURIComponent(pageinfo.searchString),
			dataType:"json",
			success:function(msg){
				fnCreateTable(msg);
				addButton();
			}
		});
	});
	
});

$(function(){
	resizePage();
	window.onresize = resizePage;
	//addButton();
	$("#topnew").click(function(){fnCreateItem();});
	$("#bottomnew").click(function(){fnCreateItem();});
	var mtype = "oemhq";
	if(sessioninfo.usertype=="1"){mtype="omgr";}
	$.ajax({
    	type : "GET", 
		url : "/"+basepath+"/org/showtree.json/"+mtype,
		data : "",
		dataType: "text",
		success : function(msg){
			fnCreateTree(msg);
			addButton();
		}
	});
});
function addButton(){
	var batBtn = "<span class=\"btn-new\" id=\"btnoper\"><span class=\"btn btn-default\"><span class=\"btn-content\">批量操作</span></span></span>";
	if($("#btnoper").length>0){$("#btnoper").remove();}
	$("#btntop").append(batBtn);
	$("#btnoper").click(function(){
		fnCreateEditDlg(
				"self","dialog-form","批量操作设备～",
				"/"+basepath+"/device/batch/normal/"+treeinfo.curnode,
				"/"+basepath+"/device/batch/save.json/normal",
				"保存成功！","提交失败！"
			);
	});
}
function fnCreateItem(){
	fnCreateEditDlg(
			"self","dialog-form","创建新设备",
			"/"+basepath+"/dbmgr/mbildevice/add/normal/"+treeinfo.curnode,
			"/"+basepath+"/dbmgr/mbildevice/save.json/normal",
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
 			url : "/"+basepath+"/dbmgr/mbildevice/del.json/manage/"+itemid,
			data : "",
			dataType: "text", 
			error: function(request){
				alert("发送请求失败！");
			},
			success : function(msg) {
				alert("删除数据成功！");
				fnRefreshPage();
			}
		});
	}
}
function fnOrgTreeClick(obj){
	var orgid = obj.parentNode.id;
	pageinfo.cateString = "deOrg = '"+orgid.substring(2)+"'";
	treeinfo.curnode = orgid.substring(2);
	fnRefreshPagex();
}
function fnRefreshPagex(){
startLoading();
$.ajax({
	type:"POST",
	url:pageinfo.pageUrl+"/"+pageinfo.curpage+"/"+pageinfo.psize,
	data:"cateString="+pageinfo.cateString+"&searchType="+pageinfo.searchType+"&order="+pageinfo.order+"&searchString="+encodeURIComponent(pageinfo.searchString),
	dataType:"json",
	success:function(msg){
		fnCreateTable(msg);
		stopLoading();
		addButton();
	}
});
}
function submitBatchCheck(obj,itemid){
	var saveurl = "/"+basepath+"/device/batch/save.json/normal"
	//var isn = $('#dlgframe').contents().find("input[name=deSn]").val();
	//if(isn==""){
	//	alert("请填写设备序列号(SN)！");return false;
	//}
	startLoading();
	$.ajax({
		cache: false,
		type: "POST",
		url:saveurl,//"dbmgr/sysuser/save.json",
		data:$('#dlgframe').contents().find("#dlgform").serialize(),
		dataType: "json",
		async: false,
		error: function(request) {
			stopLoading();
			alert("提交失败！");
		},
		success: function(data) {
			stopLoading();
			var succ = data.success;
			var fail = data.fail;
			if(fail==""&&succ!=""){
				FormDialog.init($("#dialog-form")).close("提交成功...",4);
			}else if(fail==""&&succ==""){
				alert("录入失败！");
			}else if(fail!=""&succ!=""){
				alert("录入失败：部分录入失败["+fail+"]");
			}else{
				alert("录入失败：生成过程出错，请联系管理员！");
			}
		}
	});
}
function submitAddCheck(obj,itemid){
	var saveurl = "/"+basepath+"/dbmgr/mbildevice/save.json/normal";
	var isn = $('#dlgframe').contents().find("input[name=deSn]").val();
	if(isn==""){
		alert("请填写设备序列号(SN)！");return false;
	}
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
				alert("录入失败：设备SN已存在！");
			}else if(res=="3"){
				alert("录入失败：终端TID池已满，无法生成！");
			}else if(res=="1"){
				alert("录入失败：生成过程出错，请联系管理员！");
			}
		}
	});
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