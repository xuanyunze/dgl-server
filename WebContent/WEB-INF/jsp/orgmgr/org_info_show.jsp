<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
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
<title>机构信息</title>
<style>
.otable {margin:0 auto;margin-top:20px;border:2px solid #999;font-size:13px;border-collapse:collapse;padding:0px;}
.otable td{border:1px solid #aaa;height:30px;padding:0px;margin:0px;}
.intable {border-collapse:collapse;border:none;border:0px;border-style:hidden;}
.intable td{border:1px solid #aaa;text-align:center;}
</style>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
	<form id="dlgform">
	 <table class="otable" style="width:95%;">
	  <tr>
	   <td class="tdLabel" colspan=4 style="font-size:18px;text-align:center;">机构信息详情</td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="15%">机构名称：</td>
	   <td class="tdContent" width="35%">${org.oname}</td>
	   <td class="tdLabel" width="15%">机构编号：</td>
	   <td class="tdContent" width="35%">${org.oid}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel" width="15%">机构类别：</td>
	   <td class="tdContent" width="35%">${org.oname}</td>
	   <td class="tdLabel" width="15%">机构形态：</td>
	   <td class="tdContent" width="35%">${org.oid}</td>
	  </tr>
	  <tr>
	   <td class="tdLabel">收单业务配置：</td>
	   <td class="tdContent" colspan=3>
	    <table class="intable" width="100%">
	     <tr><td>业务名称</td><td>业务费率</td><td>是否封顶</td><td>封顶金额</td><td>分润比例</td></tr>
	     <c:forEach items="${fees}" var="item" varStatus="status">
	   	  <tr>
	   	  <td><c:if test="${item.bsofFeeid=='1001'}">民生服务</c:if><c:if test="${item.bsofFeeid=='1002'}">便民百货</c:if><c:if test="${item.bsofFeeid=='1003'}">大宗批发</c:if><c:if test="${item.bsofFeeid=='1101'}">S0专用业务</c:if></td>
	   	  <td><fmt:formatNumber value="${item.bsofRate}" pattern="0.0000"/></td><td><c:if test="${item.bsofIstop=='0'}">否</c:if><c:if test="${item.bsofIstop=='1'}">是</c:if></td><td><fmt:formatNumber value="${item.bsofToprate}" pattern="0.00"/></td><td><fmt:formatNumber value="${item.bsofDrate}" pattern="0.00"/></td>
	   	  </tr>
	     </c:forEach> 
	    </table>
	   </td>
	  </tr>
	 </table>
	</form>
</body>
</html>