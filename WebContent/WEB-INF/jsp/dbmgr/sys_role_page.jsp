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
	var pageinfo = PageInfo.init();
	pageinfo.pageUrl = "/<%=WebConfig.getProperty("web.path")%>/dbmgr/sysrole/page.json/normal";
	pageinfo.styleJson = "{'pStyle':{'tableStyle':{'tableCol':[{'colName':'roCode','colText':'角色代码','colWidth':'25%','linkStat':'0','orderStat':'0'},{'colName':'roName','colText':'角色名称','colWidth':'20%','linkStat':'0','orderStat':'0'},{'colName':'roType','colText':'角色类型','colWidth':'25%','linkStat':'0','orderStat':'0'}]}}}";
	pageinfo.crumbString = "配置管理,角色管理";
</script>
<title>Insert title here</title>
</head>
<body style="margin:0;pdding:0px;auto;width:100%;height:inherit;overflow:hidden;">
 <div id="divpage">
  <table style="width:100%;height:100%;border-collapse:collapse;border:none;margin:0;padding:0; table-layout:fixed;">
   <tr>
	    <td id="tdtree" style="display:;width:200px;height:100%;border:none;margin:0;padding:0;overflow:hidden;white-space:nowrap;" valign=top>
	     <div id="orgtree" style="height:100%;overflow:auto;">
  		  <ul id="uorgtree" class="filetree"></ul>
 		 </div>
	    </td>
	    <td style="height:100%;background:#FAFAFA;border:none;margin:0;padding:0;">
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
         	     <option value="oid">机构ID</option>
         	     <option value="oname">机构名称</option>
         	     <option value="onamebref">机构简称</option>
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
		       <div class="page-control">
		        <span class="page-info">共0条/每页15条</span>
		        <span class="page-cur">第1/1页</span>
		        <span class="pager">
		         <span class="first"></span>
		         <span class="pre"></span>
		         <span class="pager-cur"></span>
		         <span class="next"></span>
		         <span class="last"></span>
		        </span>
		        <span class="page-go">
		         跳转到
		         <input name="jpageto" style="width:35px;text-align:center;" />
		         页
		        </span>
		        <span class="page-submit">
		         <span class="btn btn-default">
		          <span class="btn-content">确定</span>
		         </span>
		        </span>
		       </div>
		      </td>
		      <td></td>
		      <td></td>
		     </tr></table>
            </td>
           </tr>
          </table>
          <table id="titletable" style="width:100%;">
           <tr class="ui-widget-header">
            <td style="width:2%;"></td>
            <td style="width:3%;"></td>
            <td style="width:70%;"></td>
            <td style="width:25%;"></td>
           </tr>
          </table>
          <div id="maintablediv" style="overflow:auto;height:300px;width:100%;">
           <table id="maintable" style="width:100%;"></table>
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
	$("#tdtree").css("display","none");
	$("#tree-toggle").click(function(){return false;});
	/*
	$.ajax({
    	type : "GET", 
		url : "/"+basepath+"/org/showtree.json/normal",
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
		"self","dialog-form","创建新机构",
		"/"+basepath+"/dbmgr/sysorg/add/normal",
		"/"+basepath+"/dbmgr/sysorg/save.json/normal",
		"保存成功！","提交失败！"
	);
}
function fnEditItem(itemid){
	fnCreateEditDlg(
		"self","dialog-form","编辑机构",
		"/"+basepath+"/dbmgr/sysorg/edit/normal/"+itemid,
		"/"+basepath+"/dbmgr/sysorg/update.json/normal/"+itemid,
		"保存成功","保存失败"
	);
}
function fnShowItem(itemid){
	fnCreateShowDlg(
		"self","dialog-form","查看机构信息",
		"/"+basepath+"/dbmgr/sysorg/show/normal/"+itemid
	);
}
function fnDeleteItem(itemid){
	if(confirm("要删除该条数据吗?")){
		$.ajax({
        	type : "GET", 
 			url : "/"+basepath+"/dbmgr/sysorg/del.json/normal/"+itemid,
			data : "",
			dataType: "text", 
			error: function(request) {
				alert("发送请求失败！");
			},
			success : function(msg) {
				alert("删除数据成功！");
				fnRefreshTable("/"+basepath+"/dbmgr/sysorg/page.json/normal/1/30");
			}
		});
	}
}
function fnOrgTreeClick(obj){
	var orgid = obj.parentNode.id;
	pageinfo.cateString = "oparentid = '"+orgid.substring(2)+"'";
	fnRefreshPage();
}
</script>
</body>
</html>