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
	pageinfo.pageUrl = "/<%=WebConfig.getProperty("web.path")%>/channel/mch/page.json/all";
	pageinfo.styleJson = "{'pStyle':{'tableStyle':{'tableCol':["
        +"{'colName':'nscmRmid','colText':'商户号','colWidth':'120px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'nscmRtid','colText':'终端号','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'nscmRmchname','colText':'商户名称','colWidth':'200px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'nscmChlid','colText':'渠道号','colWidth':'60px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'nscmAreacode','colText':'地区编号','colWidth':'60px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'nscmRfeecode','colText':'渠道费率号','colWidth':'80px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'nscmStat','colText':'状态','colWidth':'50px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'creTime','colText':'创建时间','colWidth':'150px;','linkStat':'0','orderStat':'0'}]}}}";
	pageinfo.crumbString = "渠道管理,渠道商户配置";
</script>
<title>Insert title here</title>
</head>
<body style="margin:0;pdding:0px;auto;width:100%;height:inherit;overflow:hidden;">
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
     <div id="maintablediv" style="width:2000px;">
 	  <div style="width:2000px;"><table id="titletable"></table></div>
 	  <div id="naintabledivx" style="width:2000px;position:absolute;top:28px;bottom:0;left:0;overflow-y:auto;"><table id="maintable"></table></div>
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
	//resizePage();
	//window.onresize = resizePage;
	
	$("#topnew").click(function(){fnCreateItem();});
	$("#bottomnew").click(function(){fnCreateItem();});
	//$("#tdtree").css("display","none");
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
			"self","dialog-form","创建新商户",
			"/"+basepath+"/channel/mch/add/manage",
			"/"+basepath+"/channel/mch/save.json/manage",
			"保存成功！","提交失败！"
		);
}
function fnEditItem(itemid){
	fnCreateEditDlg(
		"self","dialog-form","编辑通道商户",
		"/"+basepath+"/channel/mch/edit/manage"+itemid,
		"/"+basepath+"/channel/mch/update.json/manage"+itemid,
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
 			url : "/"+basepath+"/dbmgr/dealchannelmchinfo/del.json/normal/"+itemid,
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