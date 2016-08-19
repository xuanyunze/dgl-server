<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../sections/page_header.jsp" %>
<script type="text/javascript">
	var basepath = "<%=WebConfig.getProperty("web.path")%>";
	var sessioninfo = SessionInfo.init("/"+basepath+"/websession/session.json",fnStrtoJson('<%=SessionMgr.getWebSession(request).toJson()%>'));
	var treeinfo = TreeInfo.init(sessioninfo.orgid);
	var pageinfo = PageInfo.init();
	pageinfo.pageUrl = "/<%=WebConfig.getProperty("web.path")%>/dbmgr/mbilbusi/page.json/all";
	pageinfo.styleJson = "{'pStyle':{'tableStyle':{'tableCol':[{'colName':'busiId','colText':'业务编号','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
        			   +"{'colName':'busiName','colText':'业务名称','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
	                   +"{'colName':'busiFeeid','colText':'费率编号','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
	                   +"{'colName':'busiSettleid','colText':'结算编号','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
	                   +"{'colName':'busiFeerate','colText':'收单费率','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
	                   +"{'colName':'busiIstop','colText':'是否封顶','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
	                   +"{'colName':'busiToprate','colText':'封顶值','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
	                   +"{'colName':'busiSettlerate','colText':'结算附加费率','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
	                   +"{'colName':'creTime','colText':'创建时间','colWidth':'120px;','linkStat':'0','orderStat':'0'}]}}}";
	pageinfo.crumbString = "配置管理,费率类型";
</script>
<title>Insert title here</title>
</head>
<body style="margin:0;pdding:0px;auto;width:100%;height:inherit;overflow:hidden;">
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
      <table id="titletable" style="width:1200px;"></table>
       <div id="maintablediv" style="overflow-y:auto;width:1200px;height:300px;">
        <table id="maintable"></table>
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
			//pageinfo.cateString = "uorgid='"+sessioninfo.orgid+"'";
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
	resizePage();
	window.onresize = resizePage;
	
	$("#topnew").click(function(){fnCreateItem();});
	$("#bottomnew").click(function(){fnCreateItem();});
	$("#tdtree").css("display","none");
	$("#tree-toggle").click(function(){return false;});
	/*
	$.ajax({
    	type : "GET", 
		url : "/"+basepath+"/org/showtree.json/oemhq",
		data : "",
		dataType: "text",
		success : function(msg){
			fnCreateTree(msg);
		}
	});
	*/
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
		"self","dialog-form","实名审核",
		"/"+basepath+"/wf/realname/undeal/edit/normal/"+itemid,
		"/"+basepath+"/wf/realname/undeal/update.json/normal/"+itemid,
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
function submitEditCheck(obj,itemid){
	var saveurl = "/"+basepath+"/wf/realname/undeal/update.json/normal/"+itemid;
	var tres = $('#dlgframe').contents().find("select[name=result] option:selected").text();
	var ires = $('#dlgframe').contents().find("select[name=result] option:selected").text();
	var iyj = $('#dlgframe').contents().find("textarea[name=spyj]").val();
	if(iyj==""){
		alert("请填写审批意见！");return false;
	}
	if(!confirm("您确定要【"+tres+"】该申请吗？")){
		return false;
	}
	$.ajax({
		cache: false,
		type: "POST",
		url:saveurl,//"dbmgr/sysuser/save.json",
		data:$('#dlgframe').contents().find("#dlgform").serialize(),
		async: false,
		error: function(request) {
			alert("提交失败！");
		},
		success: function(data) {
			FormDialog.init($("#dialog-form")).close("提交成功...",4);
		}
	});
}
function closeEditDialog(){
	$("#dialog-form").dialog("close");
}
</script>
</body>
</html>