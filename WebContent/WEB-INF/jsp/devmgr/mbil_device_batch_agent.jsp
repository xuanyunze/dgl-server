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
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-form.css">
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	var basepath = "<%=WebConfig.getProperty("web.path")%>";
</script>
<title>分配设备</title>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
<div id="in_progressBar" class="progressBar" style="z-index:99;display:none;">数据处理中，请稍等...</div>
	<form id="dlgform">
	 <table class="formtable" style="width:90%;margin:0 auto;">
	 <tr>
	   <td class="tdLabel">温馨提示：</td>
	   <td class="tdContent" style="padding-bottom:5px;">
		[为保证操作稳定性，建议每次操作个数不要超过200个~]
	   </td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="15%">操作方式：</td>
	   <td class="tdContent" width="85%" style="color:#CCC;" nowrap>
	    <input type="radio" name="inType" value="2" checked style="width:20px;border:none;"/>分配设备[将设备划拨到其它子机构]
	    <input type="radio" name="inType" value="3" style="width:20px;border:none;"/>重置状态[重置设备为未绑定状态]
	   </td>
	  </tr>
	  <tr>
	   <td class="tdLabel">设备类型：</td>
	   <td class="tdContent">
	    <select name="deType">
	     <option value="1">蓝牙设备</option>
	     <option value="0">音频设备</option>
	    </select>
	   </td>
	  </tr>
	  <tr id="tjg1">
	   <td class="tdLabel">目标机构：</td>
	   <td class="tdContent"><span>${targetoname}(ID:${targetoid})</span><input style="display:none" name="deOrg" readonly value="${targetoid}" /></td>
	  </tr>
	  <tr id="tjg2">
	   <td class="tdLabel">目标机构：</td>
	   <td class="tdContent"><select name="deOrgNew" id="deOrgNew">
	   	 <c:forEach items="${list}" var="item" varStatus="status">
	   	  <option value="${item.oid}">${item.oname}[${item.oid}]</option>
	     </c:forEach> 
	   </select></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">起始SN号：</td>
	   <td class="tdContent">
	   	前缀：<input name="preSn" style="width:120px;"/>&nbsp;后缀位数：<input name="snNum" style="width:30px;"/>&nbsp;起止序号：<input name="startSn" style="width:60px;"/> — <input name="endSn" style="width:60px;"/>
	   </td>
	  </tr>
	  <tr>
	   <td class="tdLabel">多个任意SN号<br>(半角逗号分开)：</td>
	   <td class="tdContent"><textarea name="anySn" rows="5" style="width:100%;"></textarea></td>
	  </tr>
	 </table>
	</form>
  <div id="btnarea">
  	<div class="btncommon" id="btnsubmit">执行操作</div>
  	<div class="btncommon" id="btnclose">关闭页面</div>
  </div>
<script type="text/javascript">
$(function(){
	var oval = $("input[name=deOrg]").val();
	if(oval==""){
		$("#tjg1").css("display","none");
	}else{
		$("#tjg2").css("display","none");
	}
	
});
	$("#btnsubmit").click(function(){
		submitBatchCheck();
	});
	$("#btnclose").click(function(){
		window.parent.closeEditDialog();
	});
	
	function submitBatchCheck(obj,itemid){
		var intype = $('input[name="inType"]:checked').val();
		if(intype=='1'){
			if(!confirm("您正在执行【设备登记】操作，确认执行吗?")) return false;
		}else if(intype=='2'){
			if(!confirm("您正在执行【设备分配】操作，确认执行吗?")) return false;
		}else if(intype=='3'){
			if(!confirm("您正在执行【设备重置】操作，确认执行吗?")) return false;
		}else{
			alert("错误的操作类型～");return false;
		}
		var saveurl = "/"+basepath+"/device/batch/save.json/normal";
		startDealing();
		$.ajax({
			cache: false,
			type: "POST",
			url:saveurl,
			data:$("#dlgform").serialize(),
			dataType: "json",
			async: true,
			error: function(request) {
				 stopDealing();
				alert("提交失败！");
			},
			success: function(data) {
				 stopDealing();
				var succ = data.success;
				var fail = data.fail;
				if(fail==""&&succ!=""){
					closeDialog("提交成功~",4);
				}else if(fail==""&&succ==""){
					alert("操作失败！");
				}else if(fail!=""){
					alert("操作失败：部分操作失败["+fail+"]");
				}else{
					alert("操作失败：生成过程出错，请联系管理员！");
				}
			}
		});
	}
function closeDialog(obj,sec){
	window.parent.closeEditDialog(obj,sec);
}
function startDealing(){
	$("#in_progressBar").css("display","");
}
function stopDealing(){
	$("#in_progressBar").css("display","none");
}
function addLeft(src,apx,len){
	while(src.length<len){
		src = apx+src;
		if(src.length>30) return null;
	}
	return src;
}
</script>
</body>
</html>