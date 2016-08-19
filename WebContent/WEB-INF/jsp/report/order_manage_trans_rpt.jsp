<%@ page language="java" contentType="application/msexcel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.rxoa.mypay.db.po.MbilOrderReceivemoney" %>
<%@ page import="com.rxoa.mypay.db.po.DealTrans" %>
<%@ page import="java.lang.Double" %>
<%@ page import="com.rxoa.mypay.util.*" %>
<%
	String filename = request.getAttribute("filename").toString();
	response.setHeader("Content-disposition","attachment; filename="+filename+".xls");
	List<Map<String,Object>> vlist = (List<Map<String,Object>>)request.getAttribute("mObject");
	if(vlist==null||vlist.size()==0){
		response.setContentType("text/html");
		response.getWriter().print("<script>alert('没有符合该条件的报表数据！');</script>");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 14">
<link rel=File-List href="%E5%B9%B3%E5%8F%B0-%E4%BA%A4%E6%98%93%E6%8A%A5%E8%A1%A8.files/filelist.xml">
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
	mso-number-format:"yyyy\\-mm\\-dd";
	text-align:center;}
.xl67
	{mso-style-parent:style0;
	mso-number-format:"\@";
	text-align:center;}
.xl68
	{mso-style-parent:style0;
	mso-number-format:"0\.00_ ";
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

<table border=0 cellpadding=0 cellspacing=0 width=1643 style='border-collapse:
 collapse;table-layout:fixed;width:1643pt'>
 <col class=xl65 width=77 style='mso-width-source:userset;mso-width-alt:3285;
 width:77pt'>
 <col class=xl65 width=108 style='mso-width-source:userset;mso-width-alt:4608;
 width:108pt'>
 <col class=xl65 width=57 style='mso-width-source:userset;mso-width-alt:2432;
 width:57pt'>
 <col class=xl65 width=68 style='mso-width-source:userset;mso-width-alt:2901;
 width:68pt'>
 <col class=xl65 width=51 span=2 style='mso-width-source:userset;mso-width-alt:
 2176;width:51pt'>
 <col class=xl65 width=49 style='mso-width-source:userset;mso-width-alt:2090;
 width:49pt'>
 <col class=xl65 width=70 style='mso-width-source:userset;mso-width-alt:2986;
 width:70pt'>
 <col class=xl65 width=82 style='mso-width-source:userset;mso-width-alt:3498;
 width:82pt'>
 <col class=xl65 width=71 style='mso-width-source:userset;mso-width-alt:3029;
 width:71pt'>
 <col class=xl65 width=165 style='mso-width-source:userset;mso-width-alt:7040;
 width:165pt'>
 <col class=xl65 width=130 style='mso-width-source:userset;mso-width-alt:5546;
 width:130pt'>
 <col class=xl65 width=90 style='mso-width-source:userset;mso-width-alt:3840;
 width:90pt'>
 <col class=xl65 width=116 style='mso-width-source:userset;mso-width-alt:4949;
 width:116pt'>
 <col class=xl65 width=75 span=4 style='mso-width-source:userset;mso-width-alt:
 3200;width:75pt'>
 <col class=xl65 width=83 style='mso-width-source:userset;mso-width-alt:3541;
 width:83pt'>
 <col class=xl65 width=75 style='mso-width-source:userset;mso-width-alt:3200;
 width:75pt'>
 <tr height=15 style='height:15.0pt'>
  <td height=15 class=xl65 width=77 style='height:15.0pt;width:77pt'>订单日期</td>
  <td class=xl65 width=108 style='width:108pt'>交易编号</td>
  <td class=xl65 width=57 style='width:57pt'>交易类型</td>
  <td class=xl65 width=68 style='width:68pt'>交易金额</td>
  <td class=xl65 width=51 style='width:51pt'>商户费率</td>
  <td class=xl65 width=51 style='width:51pt'>是否封顶</td>
  <td class=xl65 width=49 style='width:49pt'>封顶值</td>
  <td class=xl65 width=70 style='width:70pt'>应扣手续费</td>
  <td class=xl65 width=82 style='width:82pt'>结算金额</td>
  <td class=xl65 width=71 style='width:71pt'>交易通道</td>
  <td class=xl65 width=165 style='width:165pt'>通道商户</td>
  <td class=xl65 width=130 style='width:130pt'>商户编号</td>
  <td class=xl65 width=90 style='width:90pt'>终端编号</td>
  <td class=xl65 width=116 style='width:116pt'>交易卡号</td>
  <td class=xl65 width=75 style='width:75pt'>通道费率</td>
  <td class=xl65 width=75 style='width:75pt'>是否封顶</td>
  <td class=xl65 width=75 style='width:75pt'>封顶金额</td>
  <td class=xl65 width=75 style='width:75pt'>应扣手续费</td>
  <td class=xl65 width=83 style='width:83pt'>应到账金额</td>
  <td class=xl65 width=75 style='width:75pt'>平台状态</td>
 </tr>
  <%
 	Iterator<Map<String,Object>> it = vlist.iterator();
 	while(it.hasNext()){
 		Map<String,Object> obj = (Map<String,Object>)it.next();
 		MbilOrderReceivemoney order = (MbilOrderReceivemoney)obj.get("order");
 		DealTrans tran = (DealTrans)obj.get("trans");
 %>
 <tr height=15 style='height:15.0pt'>
  <td height=15 class=xl66 style='height:15.0pt'><%=DateUtil.format(order.getCreTime(),"yyyy-MM-dd")%></td>
  <td class=xl67><%=order.getOdFlowid()%></td>
  <td class=xl65><%=WebFormatUtil.getTrantype(order.getOdType())%></td>
  <td class=xl68><%=order.getOdValue()%></td>
  <td class=xl69><%=order.getOdFeerate()%></td>
  <td class=xl67><%=WebFormatUtil.getBlooean(order.getOdIstop()+"",new String[]{"0","1"},new String[]{"否","是"})%></td>
  <td class=xl68><%=order.getOdToprate()%></td>
  <td class=xl68><%=order.getOdBenefit()%></td>
  <td class=xl68><%=order.getOdChargevalue()%></td>
  <td class=xl65><%=tran.getTrChlid()%></td>
  <td class=xl65><%=tran.getTrRmchname()%></td>
  <td class=xl67><%=tran.getTrRmid()%></td>
  <td class=xl67><%=tran.getTrRtid()%></td>
  <td class=xl67><%=WebFormatUtil.hideCardNo(tran.getTrCardno(),"*")%></td>
  <td class=xl69><%=tran.getTrRfeerate()%></td>
  <td class=xl67><%=WebFormatUtil.getBlooean(tran.getTrRistop()+"",new String[]{"0","1"},new String[]{"否","是"})%></td>
  <td class=xl68><%=tran.getTrRtopvalue()%></td>
  <td class=xl68><%=tran.getTrRbenefit()%></td>
  <td class=xl68><%=Double.parseDouble(tran.getTrValue())-tran.getTrRbenefit()%></td>
  <td class=xl65>成功</td>
 </tr>
<%
 	}
%>
</table>

</body>

</html>
