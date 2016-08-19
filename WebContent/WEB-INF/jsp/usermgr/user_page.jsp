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
	pageinfo.pageUrl = "/<%=WebConfig.getProperty("web.path")%>/order/receivemoney/page.json/service";
	pageinfo.styleJson = "{'pStyle':{'tableStyle':{'tableCol':["
		+"{'colName':'odTime','colText':'交易时间','colWidth':'150px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'odUid','colText':'用户手机','colWidth':'100px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'odUname','colText':'用户姓名','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'odValue','colText':'订单金额','colWidth':'60px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'odType','colText':'订单类型','colWidth':'80px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'odFeecode','colText':'交易类型','colWidth':'80px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'odFeerate','colText':'交易费率','colWidth':'80px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'odIstop','colText':'是否封顶','colWidth':'60px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'odTopvalue','colText':'封顶值','colWidth':'60px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'odBenefit','colText':'应扣手续费','colWidth':'80px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'tranAccno','colText':'交易卡号','colWidth':'140px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'odStat','colText':'交易状态','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
	    +"{'colName':'odId','colText':'交易编号','colWidth':'150px;','linkStat':'0','orderStat':'0'}"
        +"]}}}";
	pageinfo.crumbString = "交易信息,收款交易信息";
</script>
<title>Insert title here</title>
</head>
<body style="margin:0;pdding:0px;auto;width:100%;height:inherit;overflow:hidden;">
 <div id="progressBar" class="progressBar" style="display: none; ">数据加载中，请稍等...</div>
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
		<div id="maintablediv" style="width:2000px;">
 			<table id="titletable"></table>
 			<div id="naintablediv" style="width:2000px;">
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
	$("#tdtree").css("display","none");
	$("#tree-toggle").click(function(){return false;});
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
/*
$(function(){
	resizePage();
	window.onresize = resizePage;
	
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
		}
	});
	
});
*/
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
		if(bobj.odType=='1'){bobj.odType='当面收款';}else if(bobj.odType=='8'){bobj.odType='零手续费';}
		if(bobj.odFeecode=='1001'){bobj.odFeecode='民生服务';}
		else if(bobj.odFeecode=='1002'){bobj.odFeecode='餐饮娱乐';}
		else if(bobj.odFeecode=='1003'){bobj.odFeecode='大宗批发';}
		if(bobj.odStat=='5'){bobj.odStat='交易成功';}
		else if(bobj.odStat=='6'){bobj.odStat='交易失败';}
		else if(bobj.odStat=='7'){bobj.odStat='已提交清算';}
		else if(bobj.odStat=='8'){bobj.odStat='清算成功';}
		else if(bobj.odStat=='9'){bobj.odStat='清算失败';}
		if(bobj.odIstop=='0'){bobj.odIstop='否';}else{bobj.odIstop='是';}
		//if(bobj.trType=='1'){bobj.trType='消费交易';}else{bobj.trType='查询交易';}
		bobj.tranAccno = hideCardno(bobj.tranAccno);
	}
	return objjson;
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