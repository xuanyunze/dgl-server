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
<title>新增组织</title>
<style type="text/css">
 .innerTable{
 	border:none;border-collapse:collapse;
 }
 .innerTable td{border:1px solid #CCC;height:20px;}
</style>
<script type="text/javascript">
function switchOrgtype(obj){
	if(obj==null){obj=$("select[name=orelform]");}
	$("#info_per").css("display","none");
	$("#info_com").css("display","none");
	$("#info_stu").css("display","none");
	if(obj.value==1){
		$("#info_per").css("display","");
	}else if(obj.value==2){
		$("#info_com").css("display","");
	}else if(obj.value==3){
		$("#info_stu").css("display","");
	}else{
		$("#info_per").css("display","");
	}
}
function switchFeemode(obj){
	$("input[name=feeMsfwValue]").attr("value","");
	$("input[name=feeBmbhValue]").attr("value","");
	$("input[name=feeDzpfValue]").attr("value","");
	$("input[name=feeDzpfTop]").attr("value","");
	$("input[name=feeDMsfwValue]").attr("value","");
	$("input[name=feeDBmfwValue]").attr("value","");
	$("input[name=feeDDzpfValue]").attr("value","");
	if(obj.value==2){
		$("input[name=feeMsfwValue]").attr("value","0.0050");
		$("input[name=feeBmbhValue]").attr("value","0.0100");
		$("input[name=feeDzpfValue]").attr("value","0.0080");
		$("input[name=feeDzpfTop]").attr("value","30.00");
		$("input[name=feeDMsfwValue]").attr("value","1.00");
		$("input[name=feeDBmbhValue]").attr("value","1.00");
		$("input[name=feeDDzpfValue]").attr("value","1.00");
	}
}
function switchSettlemode(obj){
	$("input[name=settleT0Value]").attr("value","");
	$("input[name=settleD0Value]").attr("value","");
	$("input[name=settleT0DValue]").attr("value","");
	$("input[name=settleD0DValue]").attr("value","");
	if(obj.value==2){
		$("input[name=settleT0Value]").attr("value","0.0020");
		$("input[name=settleD0Value]").attr("value","0.0030");
		$("input[name=settleT0DValue]").attr("value","1.00");
		$("input[name=settleD0DValue]").attr("value","1.00");
	}
}
function fnInitProvince(obj){
	var ihtml = "";
	for(var i=0;i<objprovince.length;i++){
		ihtml+="<option value='"+objprovince[i].ProID+"'>"+objprovince[i].name+"</option>";
	}
	obj.html("");
	obj.html(ihtml);
}
function fnInitArea(proid){
	var obj =  $("select[name=areaArea]");
	var ihtml = "";
	for(var i=0;i<objarea.length;i++){
		if(proid==objarea[i].ProID){
			ihtml+="<option value='"+objarea[i].CityID+"'>"+objarea[i].name+"</option>";
		}else if(ihtml!=""){
			break;
		}
	}
	obj.html("");
	obj.html(ihtml);
	fnInitCity(null);
}
function fnInitCity(areaid){
	if(areaid==null){areaid=$("select[name=areaArea] option:selected").val();}
	var obj =  $("select[name=areaCity]");
	var ihtml = "";
	for(var i=0;i<objcity.length;i++){
		if(areaid==objcity[i].CityID){
			ihtml+="<option value='"+objcity[i].CityID+"'>"+objcity[i].DisName+"</option>";
		}else if(ihtml!=""){
			break;
		}
	}
	obj.html("");
	obj.html(ihtml);
}
function fnSwitchProvince(){
	var proid = $("select[name=areaPro] option:selected").val();
	fnInitArea(proid);
}
</script>
</head>
<body style="margin:5px 5px;pdding:0px;auto;">
	<form id="dlgform">
	 <table class="formtable" style="width:90%;margin:0 auto;">
	  <tr>
	   <td class="tdLabel" width="15%">机构名称：</td>
	   <td class="tdContent" width="35%"><input name="oname" value="" /></td>
	   <td class="tdLabel" width="15%">机构简称：</td>
	   <td class="tdContent" width="35%"><input name="onamebref" value="" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">机构级别：</td>
	   <td class="tdContent"><input name="olevel" value="" /></td>
	   <td class="tdLabel">机构排序：</td>
	   <td class="tdContent"><input name="oweight" value="" /></td>
	  </tr>
	  <tr style="display:none;">
	   <td class="tdLabel">机构代码：</td>
	   <td class="tdContent"><input name="ocode" value="" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">机构类别：</td>
	   <td class="tdContent">
	   <span class="styled-select">
	   	<select name="otype"></select>
	   	</span>
	   </td>
	   <td class="tdLabel">所属父机构：</td>
	   <td class="tdContent" colspan=3><span>${targetoname}(ID:${targetoid})</span><input style="display:none" name="oparentid" readonly value="${targetoid}" /></td>
	   
	  </tr>
	  <tr id="info_feeform">
	   <td class="tdLabel">机构形态：</td>
	   <td class="tdContent" colspan=3>
	   <span class="styled-select">
	   	<select name="orelform" onchange="switchOrgtype(this);">
	   		<option value="1">个人(自然人)</option>
	   		<option value="2">公司企业</option>
	   		<option value="3">工商户(个体、工作室)</option>
	   	</select>
	   	</span>
	   </td>
	  </tr>
	  <tr id="info_per" style="display:">
	  	<td colspan=4>
	  	 <table width="100%" class="innerTable">
	  	  <tr><td width="15%">真实姓名：</td><td width="35%"><input name="pperName" /></td><td width="15%">身份证号：</td><td><input name="pperIdcard" width="35%"/></td></tr>
	  	  <tr><td>手机号码：</td><td><input name="pperPhone" /></td><td>结算卡户名：</td><td><input name="pperBankaccname" /></td></tr>
	  	  <tr><td>结算卡账号：</td><td><input name="pperBankaccno" /></td><td>结算卡开户行：</td><td><input name="pperBankname" /></td></tr>
	  	  <tr><td>开户分行：</td><td><input name="pperBankbranch" /></td><td>开户支行：</td><td><input name="pperBankdistr" /></td></tr>
	  	  <tr><td>开户行号：</td><td colspan=3><input name="pperBankno" /></td></tr>
	  	 </table>
	  	</td>
	  </tr>
	  <tr id="info_com" style="display:none">
	  	<td colspan=4>
	  	 <table width="100%" class="innerTable">
	  	  <tr><td width="15%">公司名称：</td><td width="85%" colspan=3><input name="pcomName" /></td></tr>
	  	  <tr><td width="15%">机构代码：</td><td width="35%"><input name="pcomCode" /></td><td width="15">法人姓名：</td><td width="35%"><input name="pcomLawname" /></td></tr>
	  	  <tr><td>法人身份证：</td><td><input name="pcomLawidcard" /></td><td>法人手机号：</td><td><input name="pcomLawphone" /></td></tr>
	  	  <tr><td>财务联系人：</td><td><input name="pcomFinname" /></td><td>联系人手机号：</td><td><input name="pcomFinphone" /></td></tr>
	  	  <tr><td>结算卡户名：</td><td><input name="pcomBankaccname" /></td><td>结算卡账号：</td><td><input name="pcomBankaccno" /></td></tr>
	  	  <tr><td>结算卡开户行：</td><td><input name="pcomBankname" /></td><td>开户联行号：</td><td><input name="pcomBankno" /></td></tr>
	  	  <tr><td>开户分行：</td><td><input name="pcomBankbranch" /></td><td>开户支行：</td><td><input name="pcomBankdistr" /></td></tr>
	  	 </table>
	  	</td>
	  </tr>
	  <tr id="info_stu" style="display:none">
	  	<td colspan=4>
	  	 <table width="100%" class="innerTable">
	  	  <tr><td width="15%">工商注册名称：</td><td width="85%" colspan=3><input name="pstuName" /></td></tr>
	  	  <tr><td>代表人姓名：</td><td><input name="pstuLawname" /></td><td>工商注册代码：</td><td><input name="pstuCode" /></td></tr>
	  	  <tr><td>代表人手机号：</td><td><input name="pstuLawphone" /></td><td>代表人身份证：</td><td><input name="pstuLawidno" /></td></tr>
	  	  <tr><td>结算卡户名：</td><td><input name="pstuBankaccname" /></td><td>结算卡账号：</td><td><input name="pstuBankaccno" /></td></tr>
	  	  <tr><td>结算卡开户行：</td><td><input name="pstuBankname" /></td><td>开户分行：</td><td><input name="pstuBankbranch" /></td></tr>
	  	  <tr><td>开户支行：</td><td><input name="pstuBankdistr" /></td><td>开户行号：</td><td><input name="pstuBankno" /></td></tr>
	  	 </table>
	  	</td>
	  </tr>
	  <tr id="info_area">
	  	<td colspan=4>
	  	 <table width="100%" class="innerTable">
	  	  <tr>
	  	   <td width="15%">所在区域：</td>
	  	   <td width="85%">省市：<select name="areaPro"></select>
	  	  	地市：<select name="areaArea"></select>
	  	  	县区：<select name="areaCity"></select><br><br>
	  	  	详址：<input name="areaDetail" style="width:400px;"/>
	  	  </td>
	  	 </tr>
	  	</table>
	   </td>
	  </tr>
	  <tr id="info_feemode">
	   <td class="tdLabel" colspan=4>收单业务费率[请修改下表数据]</td>
	  </tr>
	  <tr id="info_fee">
	  	<td colspan=4 width="100%">
	  	 <table width="100%" style="border:none;" class="innerTable">
	  	  <tr>
	  	  	<td width="15%">业务类型</td>
	  	  	<td width="20%">业务费率(四位小数)</td>
	  	  	<td width="15%">是否封顶</td>
	  	  	<td width="15%">封顶值</td>
	  	  	<td width="15%">附加分润</td>
	  	  	<td width="20%">分润比例(0.00-1.00)</td>
	  	   </tr>
	  	   <tr>
	  	    <td>民生服务类</td>
	  	    <td><input name="feeMsfwid" value="1001" style="display:none"/><input style="width:90%;" name="feeMsfwValue" value="0.0035"/></td>
	  	    <td>不封顶</td>
	  	    <td><input name="feeMsfwTop" style="width:90%;" value="0.00" disabled/></td>
	  	  	<td><input name="feeMsfwAnnx" style="width:90%;" value="0.00" disabled/></td>
	  	    <td><input style="width:90%;" name="feeDMsfwValue" value="1.00"/></td>
	  	   </tr>
	  	   <tr>
	  	    <td>餐饮娱乐类</td>
	  	    <td><input name="feeBmbhid" value="1002" style="display:none"/><input style="width:90%;" name="feeBmbhValue" value="0.0100"/></td>
	  	    <td>不封顶</td>
	  	    <td><input name="feeBmbhTop" style="width:90%;" value="0.00" disabled/></td>
	  	  	<td><input name="feeBmbhAnnx" style="width:90%;" value="0.00" disabled/></td>
	  	    <td><input style="width:90%;" name="feeDBmbhValue" value="1.00"/></td>
	  	   </tr>
	  	   <tr>
	  	    <td>大宗批发类</td>
	  	    <td><input name="feeDzpfid" value="1003" style="display:none"/><input style="width:90%;" name="feeDzpfValue" value="0.0080"/></td>
	  	    <td>封顶</td>
	  	    <td><input name="feeDzpfTop" style="width:90%;" value="30.00"/></td>
	  	  	<td><input name="feeDzpfAnnx" style="width:90%;" value="0.00" disabled/></td>
	  	    <td><input style="width:90%;" name="feeDDzpfValue" value="1.00"/></td>
	  	   </tr>
	  	   <tr>
	  	    <td>S0专用业务</td>
	  	    <td><input name="feeS0id" value="1101" style="display:none"/><input style="width:90%;" name="feeS0Value" value="0.0045"/></td>
	  	    <td>不封顶</td>
	  	    <td><input name="feeS0Top" style="width:90%;" value="0.00" disabled/></td>
	  	  	<td><input name="feeS0Annx" style="width:90%;" value="0.00" disabled/></td>
	  	    <td><input style="width:90%;" name="feeDS0Value" value="1.00"/></td>
	  	   </tr>
	  	 </table>
	  	</td>
	  </tr>
	  <tr id="infox_settlemode" style="display:none">
	   <td class="tdLabel" colspan=4>清算业务费率[请修改下表数据]</td>
	  </tr>
	  <tr id="infox_settle" style="display:none;">
	  	<td colspan=4 width="100%">
	  	 <table width="100%" style="border:none;" class="innerTable">
	  	  <tr><td width="15%">T+0清算费率：</td><td width="35%"><input name="settleT0id" value="1001" style="display:none"/><input style="width:80px;" name="settleT0Value" value="0.0020"/>四位小数</td><td width="15%">结算百分比：</td><td width="35%"><input style="width:60px;" name="settleT0DValue" value="1.00"/>(0.00-1.00)</td></tr>
	  	  <tr><td>D+0清算费率：</td><td><input name="settleD0id" value="1004" style="display:none"/><input style="width:80px;" name="settleD0Value" value="0.0030"/>四位小数</td><td>结算百分比：</td><td><input style="width:60px;" name="settleD0DValue" value="1.00"/>(0.00-1.00)</td></tr>
	  	  <tr><td>S+0清算费率：</td><td><input name="settleS0id" value="1006" style="display:none"/><input style="width:80px;" name="settleS0Value" value="0.0050"/>四位小数</td><td>结算百分比：</td><td><input style="width:60px;" name="settleS0DValue" value="1.00"/>(0.00-1.00)</td></tr>
	  	 </table>
	  	</td>
	  </tr>
	 </table>
	</form>
	<div id="btnarea">
  	<div class="btncommon" id="btnsubmit">立即创建</div>
  	<div class="btncommon" id="btnclose">关闭页面</div>
  </div>
<script type="text/javascript">
fnInitProvince($("select[name=areaPro]"));
$("select[name=areaPro]").change(function(){fnSwitchProvince();});
$("select[name=areaArea]").change(function(){fnInitCity(null);});

$("#btnsubmit").click(function(){
	window.parent.submitAddCheck($("#dlgform"));
});
$("#btnclose").click(function(){
	window.parent.closeEditDialog();
});
var targetotype = "${targetotype}";
var targetoname = "${targetoname}";
if(targetotype==3||targetotype==5||targetoname=="平台运营机构"){
	vhtml = "<option value='5'>分销机构(代理)</option>";
	$("select[name=otype]").html(vhtml);
}else if(targetotype==2||targetoname=="平台管理机构"){
	//vhtml = "<option value='1'>管理机构</option><option value='2'>管理机构-部门</option><option value='3'>运营机构(OEM)</option><option value='5'>分销机构(代理)</option>";
	vhtml = "<option value='2'>管理机构-部门</option>";
	$("select[name=otype]").html(vhtml);
}else{
	vhtml = "<option value='1'>管理机构</option><option value='2'>管理机构-部门</option><option value='5'>分销机构(代理)</option>";
	$("select[name=otype]").html(vhtml);
}
function switchOtype(){
	otype = $("select[name=otype] option:selected").val();
	if(otype==1||otype==2){
		$("tr[id^=info_]").css("display","none");
	}else{
		$("tr[id^=info_]").css("display","");
		switchOrgtype(null);
	}
}
switchOtype();
$("select[name=otype]").change(function(){switchOtype();});
</script>
</body>
</html>