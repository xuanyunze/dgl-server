<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.rxoa.mypay.base.config.WebConfig"%>
<%@ page import="com.rxoa.mypay.util.DateUtil"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../sections/page_header.jsp" %>
<link rel="stylesheet" type="text/css" href="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/css/rxwebui-form.css">
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/<%=WebConfig.getProperty("web.path")%>/static/rxwebui/js/dictjson.js"></script>
<script type="text/javascript">
	var basepath = "<%=WebConfig.getProperty("web.path")%>";
</script>
<title>编辑清算信息</title>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
<div id="in_progressBar" class="progressBar" style="z-index:99;display:none;">数据处理中，请稍等...</div>
	<form id="dlgform">
	<input name="uuid" value="${mObject.uuid}" style="display:none;"/>
	 <table class="formtable" style="width:90%;margin:0 auto;">
	  <tr>
	   <td class="tdLabel" width="15%">交易时间：</td>
	   <td class="tdContent" width="35%">${mObject.slOrdertime}</td>
	   <td class="tdContent" width="15%">清算时间：</td>
	   <td class="tdContent" width="35%">${mObject.slSettletime}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="15%">交易类型：</td>
	   <td class="tdContent" width="35%" id="slOrdertype"></td>
	   <td class="tdContent" width="15%">交易金额：</td>
	   <td class="tdContent" width="35%">${mObject.slSettlevalue}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="15%">交易用户：</td>
	   <td class="tdContent" width="35%">${mObject.slStaccname}</td>
	   <td class="tdContent" width="15%">手机号码：</td>
	   <td class="tdContent" width="35%">${mObject.slUid}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="15%">开户银行：</td>
	   <td class="tdContent" width="35%">${mObject.slStbankname}</td>
	   <td class="tdContent" width="15%">开户分行：</td>
	   <td class="tdContent" width="35%">${mObject.slStbankdistr}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="15%">开户支行：</td>
	   <td class="tdContent" width="35%">${mObject.slStbankbranch}</td>
	   <td class="tdContent" width="15%">联行号码：</td>
	   <td class="tdContent" width="35%">${mObject.slStbankcode}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="15%">清算户名：</td>
	   <td class="tdContent" width="35%">${mObject.slStaccname}</td>
	   <td class="tdContent" width="15%">银行卡号：</td>
	   <td class="tdContent" width="35%">${mObject.slStaccno}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="15%">清算时间：</td>
	   <td class="tdContent" width="35%">${mObject.slSettletime}</td>
	   <td class="tdContent" width="15%">清算状态：</td>
	   <td class="tdContent" width="35%" id="slStat">${mObject.slStat}</td>
	  </tr>
	 </table>
	</form>
	  <div id="btnarea">
  	<div class="btncommon" id="btnsubmit">重试下发</div>
  	<div class="btncommon" id="btnclose">关闭页面</div>
  </div>
  <script type="text/javascript">
  	$(function(){
  		var slOrdertype = ${mObject.slOrdertype};
  		var slStat = ${mObject.slStat};
		if(slOrdertype=="11"){$("#slOrdertype").html("快速收款S0");}
		if(slStat=="0"||slStat=="-1"){$("#slStat").html("等待下发");}
		else if(slStat=="1"){$("#slStat").html("已提交清算");}
		else if(slStat=="3"){$("#slStat").html("清算成功");}
		else if(slStat=="4"){$("#slStat").html("清算失败");}
		if(slStat!="4"){$("#btnsubmit").css("display","none");}
  	});
  	$("#btnsubmit").click(function(){
		submitReSettle();
	});
	$("#btnclose").click(function(){
		window.parent.closeEditDialog();
	});
	$("#btnresetpwd").click(function(){
		submitResetpwd();
	});
	
	function submitReSettle(){
		if(!confirm("确定要尝试重新下发该笔交易清算吗？")) return false;
		var saveurl = "/"+basepath+"/report/settlelog/resettle.json/manage/${mObject.uuid}";
		startDealing();
		$.ajax({
			cache: false,
			type: "POST",
			url:saveurl,
			data:'',
			dataType: "json",
			async: true,
			error: function(request) {
				 stopDealing();
				alert("提交请求失败～");
			},
			success: function(data) {
				 stopDealing();
				 alert("已提交重试下发请求～");
				 closeDialog();
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
  </script>
</body>
</html>