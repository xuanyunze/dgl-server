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
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/jquery-ui-1.11.3/jquery-ui.min.css">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/jquery-treeview/jquery.treeview.css">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-page.css">
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/jquery-ui-1.11.3/jquery-ui.min.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/jquery-treeview/jquery.treeview.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/rxwebui-1.0.min.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/rxwebui-page.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/rxwebui-form.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/common.js"></script>
<script type="text/javascript">
	var basepath = "<%=WebConfig.getProperty("web.path")%>";
	var sessioninfo = SessionInfo.init("/"+basepath+"/websession/session.json",fnStrtoJson('<%=SessionMgr.getWebSession(request).toJson()%>'));
	var treeinfo = TreeInfo.init(sessioninfo.orgid);
	var pageinfo = PageInfo.init();
	pageinfo.pageUrl = "/<%=WebConfig.getProperty("web.path")%>/wf/takemoney/dealed/page.json/all";
	pageinfo.styleJson = "{'pStyle':{'tableStyle':{'tableCol':[{'colName':'odUid','colText':'用户ID','colWidth':'100px;','linkStat':'0','orderStat':'0'},{'colName':'odTaketype','colText':'提现方式','colWidth':'100px;','linkStat':'0','orderStat':'0'},{'colName':'odValue','colText':'提现金额','colWidth':'150px;','linkStat':'0','orderStat':'0'},{'colName':'odStat','colText':'审批状态','colWidth':'50px','linkStat':'0','orderStat':'0'},{'colName':'creTime','colText':'提交时间','colWidth':'100px;','linkStat':'0','orderStat':'0'}]}}}";
	pageinfo.crumbString = "流程管理,提现审核";
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
      <table id="searchtable" style="width:100%;text-align:right;padding-right:10px;">
       <tr>
        <td id="crumbtd" style="text-align:left;width:35%" nowrap>
         <div style="float:left;margin:0 3px;cursor:pointer;width:20px;height:20px;" onclick="javascript:fnExpandTreeNav();">
          <a id="tree-toggle" style="width:20px;height:20px;" href="#"></a>
         </div>
         <div id="pagecrumb"></div>
        </td>
        <td style="width:65%;">
         <form id="searchform">
          <span class="search-condition">
           <span class="styled-select">
            <select id="searchkeytype">
         	 <option value="index">全文检索</option>
         	 <option value="odUid">用户ID</option>
         	 <option value="uname">用户姓名</option>
         	 <option value="uphone">用户手机</option>
         	</select>
           </span>
          </span>
          <div class="searchkey">
           <input id="searchkey" name="searchkey" value="" />
           <span id="gosearch" onclick="fnDoSearch()"></span>
          </div>
          <div class="btn-group" style="float:right;">
           <a id="search" class="btn-search" onclick="fnDoSearch();return false;"style="margin-left:-5px;">
         	<strong>查询</strong>
           </a>
           <a id="comxsearch" class="btn-compxsearch" onclick="fnGoCompxSearch();return false;" style="margin-left:-8px">
         	<strong>高级查询</strong>
           </a>
          </div>
         </form>
        </td>
       </tr>
      </table>
      <table id="pagetabletop" style="width:100%;">
       <tr>
        <td style="width:80px;">
         <div class="selbutton" id="selalltop" style="float:left;margin-left:8px;" onclick="javascript:selall();">
          <a>全选</a>
         </div>
         <div class="selbutton" id="dselalltop" onclick="javascript:deselall();" style="margin-left:5px;float:left;">
          <a>反选</a>
         </div>
        </td>
        <td style="width:200px;">
         <span class="btn-batchdel">
          <span class="btn btn-default">
           <span class="btn-content">批量删除</span>
          </span>
         </span>
         <span id="topnew" class="btn-new">
          <span class="btn btn-default">
           <span class="btn-content">新建</span>
          </span>
         </span>
        </td>
        <td style="text-align:right;float:right;">
		 <table style="border:none;padding:0;margin:0;"><tr>
		  <td id="topcontrol">
		   <div class="page-control"></div>
		  </td>
		  <td></td>
		  <td></td>
		 </tr></table>
        </td>
       </tr>
      </table>
      <div id="tmaindiv" style="width:100%;overflow-x:auto;">
      <table id="titletable" style="width:1200px;"></table>
       <div id="maintablediv" style="overflow-y:auto;width:1200px;height:300px;">
        <table id="maintable"></table>
       </div>
      </div>
      <div id="bottompagediv">
       <table id="pagetablebottom" style="width:100%;">
        <tr>
         <td style="width:80px;">
          <div class="selbutton" id="selalltop" style="float:left;margin-left:8px;" onclick="javascript:selall();">
           <a>全选</a>
          </div>
          <div class="selbutton" id="dselalltop" onclick="javascript:deselall();" style="margin-left:5px;float:left;">
           <a>反选</a>
          </div>
         </td>
         <td style="width:200px;">
          <span class="btn-batchdel">
           <span class="btn btn-default">
            <span class="btn-content">批量删除</span>
           </span>
          </span>
          <span id="bottomnew" class="btn-new">
           <span class="btn btn-default">
            <span class="btn-content">新建</span>
           </span>
          </span>
         </td>
         <td style="text-align:right;float:right;">
          <table style="border:none;padding:0;margin:0;"><tr>
           <td id="bottomcontrol">
            <div class="page-control"></div>
           </td><td></td><td></td></tr>
          </table>
         </td>
         </tr>
        </table>
       </div>
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
			success:function(msg){//document.write(msg);
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
		"/"+basepath+"/wf/takemoney/undeal/edit/normal/"+itemid,
		"/"+basepath+"/wf/takemoney/undeal/update.json/normal/"+itemid,
		"保存成功","保存失败"
	);
}
function fnShowItem(itemid){
	fnCreateShowDlg(
		"self","dialog-form","查看用户信息",
		"/"+basepath+"/wf/takemoney/dealed/show/all/"+itemid
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
	var saveurl = "/"+basepath+"/wf/takemoney/undeal/update.json/normal/"+itemid;
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