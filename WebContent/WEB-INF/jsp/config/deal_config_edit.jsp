<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-form.css">
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/dictjson.js"></script>
<script type="text/javascript">
	var basepath = "<%=WebConfig.getProperty("web.path")%>";
</script>
<title>风控配置</title>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
	<form id="dlgform">
	 <table class="formtable" style="width:90%;margin:0 auto;margin-top:50px;">
	  <tr>
	   <td class="tdLabel" width="20%">普通收款交易时间：</td>
	   <td class="tdContent" width="30%"><input type="text" name="cfDt1zone" value="${dealConfig.cfDt1zone}" /></td>
	   <td class="tdLabel" width="20%">普通收款交易状态：</td>
	   <td class="tdContent" width="30%">
	   		<input type="radio" name="cfDt1stat" value="1" style="width:20px;border:none;" <c:out value="${dealConfig.cfDt1stat==1?'checked':'' }"/> />允许交易
	   		<input type="radio" name="cfDt1stat" value="0" style="width:20px;border:none;" <c:out value="${dealConfig.cfDt1stat==0?'checked':'' }"/> />交易关闭
	   </td>
	  </tr>
	  <tr>
	   <td class="tdLabel">普通收款单笔限额：</td>
	   <td class="tdContent"><input type="text" name="cfDt1pertran" value="${dealConfig.cfDt1pertran}" /></td>
	   <td class="tdLabel">普通收款单日限额：</td>
	   <td class="tdContent"><input type="text" name="cfDt1perday" value="${dealConfig.cfDt1perday}" /></td>
	  </tr>
	  <tr><td colspan=4 style="height:1px;"></td></tr>
	  <tr>
	   <td class="tdLabel">快速收款交易时间：</td>
	   <td class="tdContent"><input type="text" name="cfDs0zone" value="${dealConfig.cfDs0zone}" /></td>
	   <td class="tdLabel">快速收款交易状态：</td>
	   <td class="tdContent">
	   	   	<input type="radio" name="cfDs0stat" value="1" style="width:20px;border:none;" <c:out value="${dealConfig.cfDs0stat==1?'checked':'' }"/> />允许交易
	   		<input type="radio" name="cfDs0stat" value="0" style="width:20px;border:none;" <c:out value="${dealConfig.cfDs0stat==0?'checked':'' }"/> />交易关闭
		</td>
	  </tr>
	  <tr>
	   <td class="tdLabel">快速收款单笔限额：</td>
	   <td class="tdContent"><input type="text" name="cfDs0perday" value="${dealConfig.cfDs0perday}" /></td>
	   <td class="tdLabel">快速收款单日限额：</td>
	   <td class="tdContent"><input type="text" name="cfDs0pertran" value="${dealConfig.cfDs0pertran}" /></td>
	  </tr>
	 </table>
	</form>
    <div id="btnarea">
  	<div class="btncommon" id="btnsubmit">立即修改</div>
  </div>
</body>
<script type="text/javascript">
	$("#btnclose").click(function(){
		window.parent.closeEditDialog();
	});
	$("#btnsubmit").click(function(){
		var saveurl = "/"+basepath+"/config/dealconfig/save/normal";	
		$.ajax({
			cache: false,
			type: "POST",
			url:saveurl,//"dbmgr/sysuser/save.json",
			data:$("#dlgform").serialize(),
			dataType: "text",
			async: false,
			error: function(request) {
				alert("提交失败！");
			},
			success: function(data) {alert(data);
				var res = data.result;
				if(res=="0"){
					alert("修改提示：配置更新成功！");
				}else{
					alert("修改失败：请联系管理员！");
				}
			}
		});
	});
</script>
</html>