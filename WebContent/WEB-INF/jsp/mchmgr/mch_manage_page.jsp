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
	pageinfo.pageUrl = "/<%=WebConfig.getProperty("web.path")%>/mch/page.json/manage";
	pageinfo.styleJson = "{'pStyle':{'tableStyle':{'tableCol':["
		+"{'colName':'userRegtime','colText':'注册时间','colWidth':'130px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'userId','colText':'手机号码','colWidth':'100px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'userName','colText':'真实姓名','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'userIdcard','colText':'身份证号','colWidth':'150px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'userMcardname','colText':'银行账户','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'userMcardno','colText':'银行卡号','colWidth':'150px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'userMcardbank','colText':'开户银行','colWidth':'150px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'userMcardbankbranch','colText':'开户支行','colWidth':'180px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'userMcardbankcode','colText':'联行号码','colWidth':'120px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'userDevicesn','colText':'设备编号','colWidth':'300px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'userOname','colText':'所属机构','colWidth':'300px;','linkStat':'0','orderStat':'0'}"
        +"]}}}";
	pageinfo.crumbString = "商户管理,商户信息";
</script>
<title>商户信息管理</title>
</head>
<body style="margin:0;pdding:0px;auto;overflow:hidden;">
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
	//$("#tdtree").css("display","none");
	$("#tree-toggle").click(function(){return false;});
	fnCreateSuperSearch();
	$(function(){
		if(pageinfo.cateString==""){
			pageinfo.cateString = "";
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
function fnCreateSuperSearch(){
	var sstr = ""
  	    +"<tr>"
   	    +"<td>注册时间<input name=\"qrStartDate\" onfocus=\"HS_setDate(this)\" style=\"width:70px;\"/>&nbsp;-<input name=\"qrEndDate\" onfocus=\"HS_setDate(this)\" style=\"width:70px;\"/></td>"
   	    +"<td>手机号码<input name=\"qrUid\"/></td>"
   	    +"<td>真实姓名<input name=\"qrUname\"/></td>"
   	 	+"<td>设备编号<input name=\"qrDsn\"/></td>"
   	   +"</tr>";
   	   $("#s_searchtable").html(sstr);
}
function fnCreateItem(){
	fnCreateEditDlg(
			"self","dialog-form","创建新设备",
			"/"+basepath+"/dbmgr/mbildevice/add/normal/"+treeinfo.curnode,
			"/"+basepath+"/dbmgr/mbildevice/save.json/normal",
			"保存成功！","提交失败！"
		);
}
function setAvator(objjson){
	for(var i=0;i<fnGetJsonLength(objjson.mObject.list);i++){
		bobj = objjson.mObject.list[i];
		if(bobj.userDevicesn.indexOf(",")!=-1){bobj.userDevicesn=bobj.userDevicesn.substring(0,bobj.userDevicesn.indexOf(","))+"[...]";}
		bobj.userOname = bobj.userOname+"["+bobj.uesrOid+"]";
	}
	return objjson;
}
function fnEditItem(itemid){
	fnCreateEditDlg(
		"self","dialog-form","用户信息",
		"/"+basepath+"/mch/edit/manage/"+itemid,
		"/"+basepath+"/mch/update.json/manage/"+itemid,
		"保存成功~","保存失败~"
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
	pageinfo.cateString = "odOid = '"+orgid.substring(2)+"'";
	treeinfo.curnode = orgid.substring(2);
	fnRefreshPage();
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
function fnGoCompxSearch(){
	pageinfo.searchType = "1";
	pageinfo.curpage = "1";
	var searchstr = fnGenSearchString();
	pageinfo.searchString = searchstr;
	pageinfo.searchform = "&qrStartDate="+$("#s_search input[name=qrStartDate]").val()
		+"&qrEndDate="+$("#s_search input[name=qrEndDate]").val()
		+"&qrUid="+$("#s_search input[name=qrUid]").val()
		+"&qrUname="+$("#s_search input[name=qrUname]").val()
		+"&qrDsn="+$("#s_search input[name=qrDsn]").val();
	fnRefreshPage();
}
function closeEditDialog(){
	$("#dialog-form").dialog("close");
}
</script>
</body>
</html>