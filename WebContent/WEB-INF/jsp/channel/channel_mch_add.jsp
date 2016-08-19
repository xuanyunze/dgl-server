<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../sections/page_header.jsp" %>
<title>通道商户配置</title>
<script type="text/javascript">
	var basepath = "<%=WebConfig.getProperty("web.path")%>";
function fnSwitchAreatype(){
	var x = $("input[name=mchLevel]:checked").val();
	if(x=="1"){
		$("select[name=mchProvince]").css("display","none");
		$("select[name=mchCity]").css("display","none");
	}else if(x=="2"){
		$("select[name=mchProvince]").css("display","");
		$("select[name=mchCity]").css("display","none");
	}else if(x=="3"){
		$("select[name=mchProvince]").css("display","");
		$("select[name=mchCity]").css("display","");
	}
}
function getMcclist(){
	chlid = $("select[name=mchChannelid] option:selected").val();
	$.ajax({
    	type : "GET", 
		url : "/"+basepath+"/channel/mch/dict/mcc/manage/"+chlid,
		data : "",
		dataType: "json", 
		error: function(request){
			alert("获取MCC信息失败~");
		},
		success : function(msg) {
			var strx = "";
			for (var i=0;i<fnGetJsonLength(msg.mccs);i++){
				strx+="<option value=\""+msg.mccs[i].cfeeId+"\">"+msg.mccs[i].cfeeName+"</option>";
			}
			$("#mccType").html(strx);
		}
	});
}
function fnSwitchProvince(){
	var x = $("input[name=mchLevel]:checked").val();
	if(x!="3") return false;
	var y = $("select[name=mchProvince] option:selected").val();
	if(y=="") return false;
	if(y=="1100"||y=="1200"||y=="3000"||y=="6500"){
		strx="<option value=\""+y+"\">"+$("select[name=mchProvince] option:selected").text()+"</option>";
		$("#mchCity").html(strx);return false;
	}
	$.ajax({
    	type : "GET", 
		url : "/"+basepath+"/channel/mch/dict/city/manage/"+y,
		data : "",
		dataType: "json", 
		error: function(request){
			alert("获取CITY信息失败~");
		},
		success : function(msg) {
			var strx = "<option value=\"\">---选择区市---</option>";
			for (var i=0;i<fnGetJsonLength(msg.cities);i++){
				strx+="<option value=\""+msg.cities[i].acCode+"\">"+msg.cities[i].acName+"</option>";
			}
			$("#mchCity").html(strx);
		}
	});
}
</script>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
	<form id="dlgform">
	<div style="display:none"><input name="uuid" value="${mObject.uuid}"></div>
	 <table class="formtable" style="width:90%;margin:0 auto;">
	  <tr>
	   <td class="tdLabel" width="15%">渠道编号：</td>
	   <td class="tdContent" width="35%">
	  	<select name="mchChannelid" onchange="getMcclist()">
	   	 <c:forEach items="${channels}" var="item" varStatus="status">
	   	  <option value="${item.chlId}">${item.chlName}[${item.chlId}]</option>
	     </c:forEach> 
	    </select>
	   </td>
	   <td class="tdLabel" width="15%">商户类型：</td>
	   <td class="tdContent" width="35%">
	    <select name="mccType" id="mccType">
	    </select>
	   </td>
	  </tr>
	  <tr>
	   <td class="tdLabel">商户级别：</td>
	   <td class="tdContent">
	   <input name="mchLevel" type="radio" value="1" checked onclick="fnSwitchAreatype()"/>全国
	   <input name="mchLevel" type="radio" value="2" onclick="fnSwitchAreatype()"/>省级
	   <input name="mchLevel" type="radio" value="3" onclick="fnSwitchAreatype()"/>市级
	   </td>
	   <td class="tdLabel">商户区域：</td>
	   <td class="tdContent">
	    <select name="mchProvince" style="display:none" onchange="fnSwitchProvince()">
	     <option value="">---选择省份---</option>
	     <c:forEach items="${areas}" var="item" varStatus="status">
	   	  <option value="${item.acCode}">${item.acName}</option>
	     </c:forEach> 
	    </select>
	    <select name="mchCity" style="display:none" id="mchCity">
	    </select>
	   </td>
	  </tr>
	  <tr>
	   <td class="tdLabel">商户名称：</td>
	   <td class="tdContent"><input name="mchName" value="" /></td>
	   <td class="tdLabel">商户编号：</td>
	   <td class="tdContent"><input name="mchMid" value="" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">终端号(TID)：</td>
	   <td class="tdContent"><input name="mchTid" value="" /></td>
	   <td class="tdLabel">终端编号(SN)：</td>
	   <td class="tdContent"><input name="mchTsn" value="" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">商户状态：</td>
	   <td class="tdContent">
	    <input name="mchStat" type="radio" value="1" checked/>启用
	    <input name="mchStat" type="radio" value="0"/>禁用
	   </td>
	   <td class="tdLabel"></td>
	   <td class="tdContent"></td>
	  </tr>
	 </table>
	</form>
  <div id="btnarea">
  	<div class="btncommon" id="btnsubmit">保存商户</div>
  	<div class="btncommon" id="btnclose">关闭页面</div>
  </div>
<script type="text/javascript">
$("#btnsubmit").click(function(){submitMch();});
$(function(){
	getMcclist();
});
function submitMch(){
	var areacode = "";
	var chid = $("select[name=mchChannelid] option:selected").val();
	var mcc = $("select[name=mccType] option:selected").val();
	var areatype = $("input[name=mchLevel]:checked").val();
	var province = $("select[name=mchProvince] option:selected").val();
	var city = $("select[name=mchCity] option:selected").val();
	if(mcc==""){alert("请选择费率类型~");return false;}
	if(areatype=="1"){areacode="0000";}else if(areatype=="2"){
		if(province==""){alert("请选择所属省份~");return false;}else{areacode=province;}
	}else if(areatype=="3"){
		if(province==""||city==""){alert("请选择所属省市~");return false;}else{areacode=city;}
	}
	if($("input[name=mchName]").val()==""){alert("请填写商户名称～");return false;}
	if($("input[name=mchMid]").val()==""){alert("请填写商户号～");return false;}
	if($("input[name=mchTid]").val()==""){alert("请填写商终端号～");return false;}
	var data = "chlId="+chid+"&chlMcc="+mcc+"&mchAreacode="+areacode+"&mchName="+$("input[name=mchName]").val()+"&mchMid="+$("input[name=mchMid]").val()+"&mchTid="+$("input[name=mchTid]").val()+"&mchTsn="+$("input[name=mchTsn]").val()+"&mchStat="+$("input[name=mchStat]:checked").val();;
	var saveurl = "/"+basepath+"/channel/mch/save.json/manage";
	$.ajax({
		cache: false,
		type: "POST",
		url:saveurl,
		data:data,
		dataType: "json",
		async: true,
		error: function(request) {
			alert("提交新商户失败~");
		},
		success: function(data) {
			var succ = data.resp;
			if(succ=="success"){
				window.parent.closeEditDialog();
			}else{
				alert("提交新商户失败~");
			}
		}
	});
}
	$("#btnclose").click(function(){
		window.parent.closeEditDialog();
	});
</script>
</body>
</html>