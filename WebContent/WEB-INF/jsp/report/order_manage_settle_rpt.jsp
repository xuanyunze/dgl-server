<%@ page language="java" contentType="application/msexcel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.rxoa.mypay.db.po.MbilSettleLog" %>
<%@ page import="java.lang.Double" %>
<%@ page import="com.rxoa.mypay.util.*" %>
<%
	String filename = request.getAttribute("filename").toString();
	List<Map<String,Object>> vlist = (List<Map<String,Object>>)request.getAttribute("mObject");
	if(vlist==null||vlist.size()==0){
		response.setContentType("text/html");
		response.getWriter().print("<script>alert('没有符合该条件的报表数据！');history.back();</script>");
		return;
	}
	response.setHeader("Content-disposition","attachment; filename="+filename+".xls");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 14">
<link rel=File-List href="%E5%B9%B3%E5%8F%B0-%E6%B8%85%E7%AE%97%E6%8A%A5%E8%A1%A8.files/filelist.xml">
<style>
<!--table
	{mso-displayed-decimal-separator:"\.";
	mso-displayed-thousand-separator:"\,";}
@page
	{margin:1.0in .75in 1.0in .75in;
	mso-header-margin:.5in;
	mso-footer-margin:.5in;}
.style0
	{mso-number-format:General;
	text-align:general;
	vertical-align:bottom;
	white-space:nowrap;
	mso-rotate:0;
	mso-background-source:auto;
	mso-pattern:auto;
	color:black;
	font-size:12.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体, sans-serif;
	mso-font-charset:134;
	border:none;
	mso-protection:locked visible;
	mso-style-name:普通;
	mso-style-id:0;}
td
	{mso-style-parent:style0;
	padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:black;
	font-size:12.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体, sans-serif;
	mso-font-charset:134;
	mso-number-format:General;
	text-align:general;
	vertical-align:bottom;
	border:none;
	mso-background-source:auto;
	mso-pattern:auto;
	mso-protection:locked visible;
	white-space:nowrap;
	mso-rotate:0;}
.xl65
	{mso-style-parent:style0;
	text-align:center;}
.xl66
	{mso-style-parent:style0;
	mso-number-format:"0\.00_ ";
	text-align:center;}
.xl67
	{mso-style-parent:style0;
	mso-number-format:"yyyy\\-mm\\-dd";
	text-align:center;}
.xl68
	{mso-style-parent:style0;
	mso-number-format:"\@";
	text-align:center;}
.xl69
	{mso-style-parent:style0;
	mso-number-format:"0\.0000_ ";
	text-align:center;}
ruby
	{ruby-align:left;}
rt
	{color:windowtext;
	font-size:9.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体, sans-serif;
	mso-font-charset:134;
	mso-char-type:none;
	display:none;}
-->
</style>
</head>

<body link=blue vlink=purple class=xl65>

<table border=0 cellpadding=0 cellspacing=0 width=1455 style='border-collapse:
 collapse;table-layout:fixed;width:1455pt'>
 <col class=xl65 width=72 style='mso-width-source:userset;mso-width-alt:3072;
 width:72pt'>
 <col class=xl65 width=108 style='mso-width-source:userset;mso-width-alt:4608;
 width:108pt'>
 <col class=xl65 width=82 style='mso-width-source:userset;mso-width-alt:3498;
 width:82pt'>
 <col class=xl65 width=76 style='mso-width-source:userset;mso-width-alt:3242;
 width:76pt'>
 <col class=xl65 width=79 style='mso-width-source:userset;mso-width-alt:3370;
 width:79pt'>
 <col class=xl65 width=56 style='mso-width-source:userset;mso-width-alt:2389;
 width:56pt'>
 <col class=xl65 width=66 style='mso-width-source:userset;mso-width-alt:2816;
 width:66pt'>
 <col class=xl65 width=80 style='mso-width-source:userset;mso-width-alt:3413;
 width:80pt'>
 <col class=xl65 width=68 style='mso-width-source:userset;mso-width-alt:2901;
 width:68pt'>
 <col class=xl65 width=89 style='mso-width-source:userset;mso-width-alt:3797;
 width:89pt'>
 <col class=xl65 width=118 style='mso-width-source:userset;mso-width-alt:5034;
 width:118pt'>
 <col class=xl65 width=120 style='mso-width-source:userset;mso-width-alt:5120;
 width:120pt'>
 <col class=xl65 width=60 style='mso-width-source:userset;mso-width-alt:2560;
 width:60pt'>
  <col class=xl65 width=60 style='mso-width-source:userset;mso-width-alt:3560;
 width:60pt'>
 <col width=316 style='mso-width-source:userset;mso-width-alt:13482;width:316pt'>
 <col class=xl65 width=65 style='width:65pt'>
 <tr height=15 style='height:15.0pt'>
  <td height=15 class=xl65 width=72 style='height:15.0pt;width:72pt'>清算日期</td>
  <td class=xl65 width=108 style='width:108pt'>订单编号</td>
  <td class=xl65 width=82 style='width:82pt'>交易用户</td>
  <td class=xl65 width=76 style='width:76pt'>订单日期</td>
  <td class=xl65 width=79 style='width:79pt'>订单类型</td>
  <td class=xl65 width=56 style='width:56pt'>到账类型</td>
  <td class=xl65 width=66 style='width:66pt'>订单金额</td>
  <td class=xl65 width=80 style='width:80pt'>收益/手续费</td>
  <td class=xl65 width=68 style='width:68pt'>到账金额</td>
  <td class=xl66 width=89 style='width:89pt'>收款户名</td>
  <td class=xl65 width=118 style='width:118pt'>收款账号</td>
  <td class=xl65 width=120 style='width:120pt'>开户银行</td>
  <td class=xl65 width=60 style='width:60pt'>清算通道</td>
  <td class=xl65 width=60 style='width:60pt'>联行号</td>
  <td width=316 style='width:316pt'>清算序号</td>
  <td class=xl65 width=65 style='width:65pt'>平台状态</td>
 </tr>
<%
 	Iterator<Map<String,Object>> it = vlist.iterator();
 	while(it.hasNext()){
 		Map<String,Object> obj = (Map<String,Object>)it.next();
 		MbilSettleLog settle = (MbilSettleLog)obj.get("settle");
 %>
 <tr height=15 style='height:15.0pt'>
  <td height=15 class=xl67 style='height:15.0pt'><%=DateUtil.format(settle.getCreTime(),"yyyy-MM-dd")%></td>
  <td class=xl68><%=settle.getSlOrderid()%></td>
  <td class=xl68><%=settle.getSlUid()%></td>
  <td class=xl67><%=DateUtil.format(settle.getSlOrdertime(),"yyyy-MM-dd")%></td>
  <td class=xl65><%=WebFormatUtil.getTrantype(settle.getSlOrdertype())%></td>
  <td class=xl65><%=WebFormatUtil.replaceNull(settle.getSlOdarrivetype())%></td>
  <td class=xl66><%=settle.getSlSettlevalue()%></td>
  <td class=xl69><%=settle.getSlStvalue()-settle.getSlSettlevalue()%></td>
  <td class=xl66><%=settle.getSlStvalue()%></td>
  <td class=xl68><%=settle.getSlStaccname()%></td>
  <td class=xl68><%=settle.getSlStaccno()%></td>
  <td class=xl68><%=settle.getSlStbankname()%></td>
  <td class=xl65><%=settle.getSlStchannel()%></td>
  <td class=xl68><%=settle.getSlStbankcode()%></td>
  <td><%=settle.getSlRemoteid()%></td>
  <td class=xl65>成功</td>
 </tr>
 <%
 	}
 %>
</table>

</body>

</html>
