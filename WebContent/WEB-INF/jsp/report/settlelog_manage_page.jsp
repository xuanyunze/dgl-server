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
	pageinfo.pageUrl = "/<%=WebConfig.getProperty("web.path")%>/report/settlelog/page.json/${utype}";
	pageinfo.styleJson = "{'pStyle':{'tableStyle':{'tableCol':["
		+"{'colName':'slOrdertime','colText':'交易时间','colWidth':'130px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'slUid','colText':'用户手机','colWidth':'100px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'slStaccname','colText':'用户姓名','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'slOrdertype','colText':'订单类型','colWidth':'80px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'slSettlevalue','colText':'订单金额','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'slOdarrivetype','colText':'清算方式','colWidth':'80px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'slStfeerate','colText':'清算费率','colWidth':'80px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'slStvalue','colText':'清算金额','colWidth':'80px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'slStchannel','colText':'清算通道','colWidth':'60px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'slStaccname','colText':'到账账户','colWidth':'80px','linkStat':'0','orderStat':'0'},"
        +"{'colName':'slStaccno','colText':'银行卡号','colWidth':'150px;','linkStat':'0','orderStat':'0'},"
        +"{'colName':'slStbankname','colText':'银行名称','colWidth':'150px;','linkStat':'0','orderStat':'0'},"
	    +"{'colName':'slStbankdistr','colText':'分行名称','colWidth':'80px;','linkStat':'0','orderStat':'0'},"
	    +"{'colName':'slStbankbranch','colText':'支行名称','colWidth':'150px;','linkStat':'0','orderStat':'0'},"
	    +"{'colName':'slStbankcode','colText':'联行号','colWidth':'120px;','linkStat':'0','orderStat':'0'},"
	    +"{'colName':'slSettletime','colText':'清算时间','colWidth':'130px;','linkStat':'0','orderStat':'0'},"
	    +"{'colName':'slStat','colText':'清算状态','colWidth':'80px;','linkStat':'0','orderStat':'0'}"
        +"]}}}";
	pageinfo.crumbString = "交易信息,清算信息";
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
       <div style="border-top:1px dashed #ccc;border-bottom:1px dashed #ccc;padding:5px 5px;padding-left:25px;">
 	   	<form id="s_search">
 	   	 <table style="border:none;" id="s_searchtable">
 	   	  <tr>
 	   	   <td>交易日期<input name="startDate" onfocus="HS_setDate(this)" style="width:70px;"/> -<input name="endDate" onfocus="HS_setDate(this)" style="width:70px;"/></td>
 	   	   <td>手机<input name="slUid" style="width:80px;"/></td>
 	   	   <td>姓名<input name="slUname" style="width:60px;"/></td>
 	   	   <td>收款卡号<input name="slUaccno" style="width:80px;"/></td>
 	   	   <td>清算状态<select name="slStat">
 	   	    <option value="all">所有状态</option>
 	   	    <option value="0">等待下发</option>
 	   	    <option value="-1">重置下发</option>
 	   	    <option value="1">已提交清算</option>
 	   	    <option value="3">清算成功</option>
 	   	    <option value="4">清算失败</option>
 	   	   </select></td>
 	   	  </tr>
 	   	 </table>
 	   	</form>
	   </div>
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
		if(bobj.slOrdertype=='9'){bobj.slOrdertype='普通收款';}else if(bobj.slOrdertype=='11'){bobj.slOrdertype='快速收款S0';}
		if(bobj.slStat=='0'){bobj.slStat='等待下发';}
		else if(bobj.slStat=='1'){bobj.slStat='已提交清算';}
		else if(bobj.slStat=='3'){bobj.slStat='清算成功';}
		else if(bobj.slStat=='4'){bobj.slStat='清算失败';}
		else if(bobj.slStat=='-1'){bobj.slStat='清算已重置';}
		bobj.slOrdertime=new Date(bobj.slOrdertime).format("yyyy-MM-dd hh:mm:ss");
		bobj.slSettletime=new Date(bobj.slOrdertime).format("yyyy-MM-dd hh:mm:ss");
		//if(bobj.trType=='1'){bobj.trType='消费交易';}else{bobj.trType='查询交易';}
		//bobj.tranAccno = hideCardno(bobj.tranAccno);
	}
	return objjson;
}
function fnEditItem(itemid){
	fnCreateEditDlg(
		"self","dialog-form","清算处理",
		"/"+basepath+"/report/settlelog/edit/manage/"+itemid,
		"/"+basepath+"/report/settlelog/update.json/manage/"+itemid,
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
	pageinfo.searchform = "&startDate="+$("#s_search input[name=startDate]").val()
		+"&endDate="+$("#s_search input[name=endDate]").val()
		+"&slUid="+$("#s_search input[name=slUid]").val()
		+"&slUname="+$("#s_search input[name=slUname]").val()
		+"&slUaccno="+$("#s_search input[name=slUaccno]").val()
		+"&slStat="+$("#s_search select[name=slStat] option:selected").val();
	fnRefreshPage();
}
function closeEditDialog(){
	$("#dialog-form").dialog("close");
}
</script>
</body>
</html>