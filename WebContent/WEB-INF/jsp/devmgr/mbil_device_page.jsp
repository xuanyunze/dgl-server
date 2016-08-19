<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<%@ page import="com.rxoa.mypay.sys.auth.SessionMgr"%>
<%@ page import="com.rxoa.mypay.base.security.WebSessionEntity"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
	pageinfo.pageUrl = "/<%=WebConfig.getProperty("web.path")%>/device/page.json/manage";
	pageinfo.styleJson = "{'pStyle':{'tableStyle':{'tableCol':["
		+"{'colName':'deCretime','colText':'登记时间','colWidth':'130px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'deId','colText':'设备编号[TID]','colWidth':'90px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'deSn','colText':'设备序列号[SN]','colWidth':'200px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'deType','colText':'设备类型','colWidth':'80px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'deModel','colText':'设备型号','colWidth':'100px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'deStat','colText':'设备状态','colWidth':'80px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'deUid','colText':'当前用户','colWidth':'120px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'deoPath','colText':'所属机构','colWidth':'300px','linkStat':'0','orderStat':'0'}"
        +"]}}}";
	pageinfo.crumbString = "商户管理,设备信息";
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
     <div id="maintablediv" style="width:1300px;">
 	  <div style="width:1300px;"><table id="titletable"></table></div>
 	  <div id="naintabledivx" style="width:1300px;position:absolute;top:28px;bottom:0;left:0;overflow-y:auto;"><table id="maintable"></table></div>
	 </div>
	</div>
	<%@ include file="../sections/page_pagination_bottom.jsp" %>
   </div>
  </div>
  <div id="dialog-form" title="Dialog" style="margin:0;padding:0;"></div>
  <div id="olisttmp" style="display:none;">	   	 
  	<c:forEach items="${olist}" var="item" varStatus="status">
		<option value="${item.oname}">${item.oname}[${item.oid}]</option>
	</c:forEach>
  </div>
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
				addButton();
			}
		});
	});
});
function fnCreateSuperSearch(){
	var sstr = ""
  	    +"<tr>"
   	    +"<td>登记时间<input name=\"startDate\" onfocus=\"HS_setDate(this)\" style=\"width:70px;\"/>&nbsp;-<input name=\"endDate\" onfocus=\"HS_setDate(this)\" style=\"width:70px;\"/></td>"
   	    +"<td>设备类型<select name=\"deType\" style=\"width:120px;\"><option value=\"all\">全部类型</option><option value=\"1\">蓝牙设备</option><option value=\"0\">音频设备</option></select></td>"
   	    +"<td>设备状态<select name=\"deStat\" style=\"width:120px;\"><option value=\"all\">所有状态</option><option value=\"1\">已绑定</option><option value=\"0\">未绑定</option></select></td>"
   	    +"</tr>"
 	    +"<tr>"
   	    +"<td>所属机构<select id=\"selorg\" style=\"width:160px;height:30px;\" onchange=\"fnSelOrg()\">"+$("#olisttmp").html()+"</select>"
   	    +"<input name=\"orgName\" style=\"width:139px;margin-left:-160px;height:14px;\"/>"
   	    +"</td>"
   	    +"<td>当前用户<input name=\"uid\" style=\"width:120px;\"/></td>"
   	    +"<td>设备编号<input name=\"deSn\" style=\"width:120px;\"/></td>"
   	    +"</tr>";
   	   $("#s_searchtable").html(sstr);
}
function fnSelOrg(){
	$("#s_search input[name=orgName]").val($("#selorg option:selected").val());
}
function fnGoCompxSearch(){
	pageinfo.searchType = "1";
	pageinfo.curpage = "1";
	var searchstr = fnGenSearchString();
	pageinfo.searchString = searchstr;
	pageinfo.searchform = "&startDate="+$("#s_search input[name=startDate]").val()
		+"&endDate="+$("#s_search input[name=endDate]").val()
		+"&uid="+$("#s_search input[name=uid]").val()
		+"&deType="+$("#s_search select[name=deType] option:selected").val()
		+"&deStat="+$("#s_search select[name=deStat] option:selected").val()
		+"&orgName="+$("#s_search input[name=orgName]").val()
		+"&deSn="+$("#s_search input[name=deSn]").val();
	fnRefreshPage();
}
function addButton(){
	var batBtn = "<span class=\"btn-new\" id=\"btnoper\"><span class=\"btn btn-default\"><span class=\"btn-content\">批量操作</span></span></span>";
	if($("#btnoper").length>0){$("#btnoper").remove();}
	$("#btntop").append(batBtn);
	$("#btnoper").click(function(){
		fnCreateEditDlg(
				"self","dialog-form","批量操作设备～",
				"/"+basepath+"/device/batch/normal/1000",
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
function setAvator(objjson){
	for(var i=0;i<fnGetJsonLength(objjson.mObject.list);i++){
		bobj = objjson.mObject.list[i];
		if(bobj.deType=='1'){bobj.deType='蓝牙设备';}else{bobj.deType='音频设备';}
		if(bobj.deStat=='1'){bobj.deStat='已绑定';}else if(bobj.deStat=='0'){bobj.deStat='未绑定';}
		if(bobj.deModel==null){bobj.deModel='';}
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
function closeEditDialog(){
	$("#dialog-form").dialog("close");
}
</script>
</body>
</html>