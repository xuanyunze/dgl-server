<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-form.css">
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/jquery-1.11.2.min.js"></script>
<title>新增激活码</title>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
	<form id="dlgform">
	 <table class="formtable" style="width:60%;margin:0 auto;">
	  <tr>
	   <td class="tdLabel" width="20%">设备TID：</td>
	   <td class="tdContent" width="80%" style="color:#CCC;"><i>系统自动生成</i></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">设备SN：</td>
	   <td class="tdContent"><input name="deSn" value="" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">设备类型：</td>
	   <td class="tdContent">
	    <select name="deType">
	     <option value="0">音频设备</option>
	     <option value="1">蓝牙设备</option>
	    </select>
	   </td>
	  </tr>
	  <tr>
	   <td class="tdLabel">设备状态：</td>
	   <td class="tdContent">未绑定</td>
	  </tr>
	  <tr>
	   <td class="tdLabel">所属机构：</td>
	   <td class="tdContent"><span>${targetoname}(ID:${targetoid})</span><input style="display:none" name="deOrg" readonly value="${targetoid}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">设备备注：</td>
	   <td class="tdContent"><textarea name="deDescribe" rows="5" style="width:100%;"></textarea></td>
	  </tr>
	 </table>
	</form>
  <div id="btnarea">
  	<div class="btncommon" id="btnsubmit">立即创建</div>
  	<div class="btncommon" id="btnclose">关闭页面</div>
  </div>
<script type="text/javascript">
	$("#btnsubmit").click(function(){
		window.parent.submitAddCheck($("#dlgform"));
	});
	$("#btnclose").click(function(){
		window.parent.closeEditDialog();
	});
</script>
</body>
</html>