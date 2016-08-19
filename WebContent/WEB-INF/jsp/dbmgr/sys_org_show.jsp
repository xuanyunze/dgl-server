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
<title>查看机构</title>
<style type="text/css">
 .innerTable{
 	border:none;border-collapse:collapse;
 }
 .innerTable td{border:1px solid #CCC;height:20px;}
</style>
<script type="text/javascript">
function switchOrgtype(){
	var mvalue = $("select[name=orelform] option:selected").val();
	$("#info_per").css("display","none");
	$("#info_com").css("display","none");
	$("#info_stu").css("display","none");
	if(mvalue==1){
		$("#info_per").css("display","");
	}else if(mvalue==2){
		$("#info_com").css("display","");
	}else if(mvalue==3){
		$("#info_stu").css("display","");
	}
}
function switchFeemode(obj){
	$("input[name=feeMsValue]").attr("value","");
	$("input[name=feeYbValue]").attr("value","");
	$("input[name=feePfValue]").attr("value","");
	$("input[name=feeCyValue]").attr("value","");
	$("input[name=feeFcValue]").attr("value","");
	if(obj.value==2){
		$("input[name=feeMsValue]").attr("value","0.38");
		$("input[name=feeYbValue]").attr("value","0.78");
		$("input[name=feePfValue]").attr("value","1.25");
		$("input[name=feeCyValue]").attr("value","26");
		$("input[name=feeFcValue]").attr("value","80");
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
	<div id="hideform" style="display:none;">
		<input name="orelformId" value="${mOrg.orelid}">
	</div>
	 <table class="formtable" style="width:90%;margin:0 auto;">
	  <tr>
	   <td class="tdLabel" width="15%">机构名称：</td>
	   <td class="tdContent" width="35%"><input name="oname" value="${mOrg.oname}" /></td>
	   <td class="tdLabel" width="15%">机构简称：</td>
	   <td class="tdContent" width="35%"><input name="onamebref" value="${mOrg.onamebref}" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">机构级别：</td>
	   <td class="tdContent"><input name="olevel" value="${mOrg.olevel }" /></td>
	   <td class="tdLabel">机构排序：</td>
	   <td class="tdContent"><input name="oweight" value="${mOrg.oweight }" /></td>
	  </tr>
	  <tr>
	  </tr>
	  <tr style="display:none">
	   <td class="tdLabel">机构代码：</td>
	   <td class="tdContent" colspan=3><input name="ocode" value="${mOrg.ocode }" /></td>
	  </tr>
	  <tr>
	   <td class="tdLabel">机构类别：</td>
	   <td class="tdContent">
	   <span class="styled-select">
	   	<select name="otype"></select>
	   	</span>
	   </td>
	   <td class="tdLabel">所属机构：</td>
	   <td class="tdContent"><span>${mOrg.oparentid}(ID:${mOrg.oparentid})</span><input style="display:none" name="oparentid" readonly value="${mOrg.oid}" /></td>
	  </tr>
	  <tr id="info_oform">
	   <td class="tdLabel">机构形态：</td>
	   <td class="tdContent" colspan=3>
	   <span class="styled-select">
	   	<select name="orelform" onchange="switchOrgtype();">
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
	  	  <tr><td width="15%">真实姓名：</td><td width="35%"><input name="pperName" value="${mPerson.pperName}"/></td><td width="15%">身份证号：</td><td width="35%"><input name="pperIdcard" value="${mPerson.pperIdcard }"/></td></tr>
	  	  <tr><td>结算卡户名：</td><td><input name="pperBankaccname" value="${mPerson.pperBankaccname}"/></td><td>手机号码：</td><td><input name="pperPhone" value="${mPerson.pperPhone}"/></td></tr>
	  	  <tr><td>结算卡开户行：</td><td><input name="pperBankname" value="${mPerson.pperBankname}" /></td><td>结算卡账号：</td><td><input name="pperBankaccno" value="${mPerson.pperBankaccno}" /></td></tr>
	  	  <tr><td>开户分行：</td><td><input name="pperBankbranch" value="${mPerson.pperBankbranch}" /></td><td>开户支行：</td><td><input name="pperBankdistr" value="${mPerson.pperBankdistr}" /></td></tr>
	  	  <tr><td>开户行号：</td><td colspan=3><input name="pperBankno" value="${mPerson.pperBankno}"/></td></tr>
	  	 </table>
	  	</td>
	  </tr>
	  <tr id="info_com" style="display:none">
	  	<td colspan=4>
	  	 <table width="100%" class="innerTable">
	  	  <tr><td width="15%">公司名称：</td><td width="85%" colspan=3><input name="pcomName" value="${mEnterprise.pcomName}" /></td></tr>
	  	  <tr><td>机构代码：</td><td><input name="pcomCode" value="${mEnterprise.pcomCode}" /></td><td>法人姓名：</td><td><input name="pcomLawname" value="${mEnterprise.pcomLawname}" /></td></tr>
	  	  <tr><td>法人手机号：</td><td><input name="pcomLawphone" value="${mEnterprise.pcomLawphone}" /></td><td>法人身份证：</td><td><input name="pcomLawidcard" value="${mEnterprise.pcomLawidcard}" /></td></tr>
	  	  <tr><td>财务联系人：</td><td><input name="pcomFinname" value="${mEnterprise.pcomFinname}" /></td><td>联系人手机号：</td><td><input name="pcomFinphone" value="${mEnterprise.pcomFinphone}" /></td></tr>
	  	  <tr><td>结算卡户名：</td><td><input name="pcomBankaccname" value="${mEnterprise.pcomBankaccname}" /></td><td>结算卡账号：</td><td><input name="pcomBankaccno" value="${mEnterprise.pcomBankaccno}" /></td></tr>
	  	  <tr><td>结算卡开户行：</td><td><input name="pcomBankname" value="${mEnterprise.pcomBankname}" /></td><td>开户分行：</td><td><input name="pcomBankbranch" value="${mEnterprise.pcomBankbranch}" /></td></tr>
	  	  <tr><td>开户支行：</td><td><input name="pcomBankdistr" value="${mEnterprise.pcomBankdistr}" /></td><td>开户行号：</td><td><input name="pcomBankno" value="${mEnterprise.pcomBankno}" /></td></tr>
	  	 </table>
	  	</td>
	  </tr>
	  <tr id="info_stu" style="display:none">
	  	<td colspan=4>
	  	 <table width="100%" class="innerTable">
	  	  <tr><td width="15%">工商注册名称：</td><td width="85%" colspan=3><input name="pstuName"  value="${mStudio.pstuName}"/></td></tr>
	  	  <tr><td>代表人姓名：</td><td><input name="pstuLawname"  value="${mStudio.pstuLawname}"/></td><td>工商注册代码：</td><td><input name="pstuCode"  value="${mStudio.pstuCode}"/></td></tr>
	  	  <tr><td>代表人手机号：</td><td><input name="pstuLawphone"  value="${mStudio.pstuLawphone}"/></td><td>代表人身份证：</td><td><input name="pstuLawidno"  value="${mStudio.pstuLawidcard}"/></td></tr>
	  	  <tr><td>结算卡户名：</td><td><input name="pstuBankaccname" value="${mStudio.pstuBankaccname}" /></td><td>结算卡账号：</td><td><input name="pstuBankaccno" value="${mStudio.pstuBankaccno}" /></td></tr>
	  	  <tr><td>结算卡开户行：</td><td><input name="pstuBankname" value="${mStudio.pstuBankname}" /></td><td>开户分行：</td><td><input name="pstuBankbranch" value="${mStudio.pstuBankbranch}" /></td></tr>
	  	  <tr><td>开户支行：</td><td><input name="pstuBankdistr" value="${mStudio.pstuBankdistr}" /></td><td>开户行号：</td><td><input name="pstuBankno" value="${mStudio.pstuBankno}" /></td></tr>
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
	  	  	<td><input name="feeMsfwid" value="1001" style="display:none"/><input style="width:90%;" name="feeMsfwValue" value="${mFee.get('1001').bsofRate}"/></td>
	  	  	<td>不封顶</td>
	  	  	<td><input disabled name="feeMsfwTop" style="width:90%;" value="${mFee.get('1001').bsofToprate}"/></td>
	  	  	<td><input disabled name="feeMsfwAnnx" style="width:90%;" /></td>
	  	  	<td><input style="width:90%;" name="feeDMsfwValue" value="${mFee.get('1001').bsofDrate}"/></td>
	  	  </tr>
	  	  <tr>
	  	  	<td>餐饮娱乐类</td>
	  	  	<td><input name="feeBmbhid" value="1002" style="display:none"/><input style="width:90%;" name="feeBmbhValue" value="${mFee.get('1002').bsofRate}"/></td>
	  	  	<td>不封顶</td>
	  	  	<td><input disabled name="feeBmbhTop" style="width:90%;" value="${mFee.get('1002').bsofToprate}"/></td>
	  	  	<td><input disabled name="feeBmbhAnnx" style="width:90%;" /></td>
	  	  	<td><input style="width:90%;" name="feeDBmbhValue" value="${mFee.get('1002').bsofDrate}"/></td>
	  	  </tr>
	  	  <tr>
	  	  	<td>大宗批发类</td>
	  	  	<td><input name="feeDzpfid" value="1003" style="display:none"/><input style="width:90%;" name="feeDzpfValue" value="${mFee.get('1003').bsofRate}"/></td>
	  	  	<td>封顶</td>
	  	  	<td><input name="feeDzpfTop" style="width:90%;" value="${mFee.get('1003').bsofToprate}"/></td>
	  	  	<td><input disabled name="feeDzpfAnnx" style="width:90%;" /></td>
	  	  	<td><input style="width:90%;" name="feeDDzpfValue" value="${mFee.get('1003').bsofDrate}"/></td>
	  	  </tr>
	  	  <tr>
	  	  	<td>S0专用业务</td>
	  	  	<td><input name="feeS0id" value="1101" style="display:none"/><input style="width:90%;" name="feeS0Value" value="${mFee.get('1101').bsofRate}"/></td>
	  	  	<td>不封顶</td>
	  	  	<td><input disabled name="feeS0Top" style="width:90%;" value="${mFee.get('1101').bsofToprate}"/></td>
	  	  	<td><input disabled name="feeS0Annx" style="width:90%;"/></td>
	  	  	<td><input style="width:90%;" name="feeDS0Value" value="${mFee.get('1101').bsofDrate}"/></td>
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
	  	  <tr><td width="15%">T+0清算费率：</td><td width="35%"><input name="settleT0id" value="1001" style="display:none"/><input style="width:80px;" name="settleT0Value" value="${mSettle.get('1001').bsosRate}"/>四位小数</td><td width="15%">结算百分比：</td><td width="35%"><input style="width:60px;" name="settleT0DValue" value="${mSettle.get('1001').bsosDrate}"/>(0.00-1.00)</td></tr>
	  	  <tr><td>D+0清算费率：</td><td><input name="settleD0id" value="1004" style="display:none"/><input style="width:80px;" name="settleD0Value" value="${mSettle.get('1004').bsosRate}"/>四位小数</td><td>结算百分比：</td><td><input style="width:60px;" name="settleD0DValue" value="${mSettle.get('1004').bsosDrate}"/>(0.00-1.00)</td></tr>
	  	  <tr><td>S+0清算费率：</td><td><input name="settleS0id" value="1006" style="display:none"/><input style="width:80px;" name="settleS0Value" value="${mSettle.get('1006').bsosRate}"/>四位小数</td><td>结算百分比：</td><td><input style="width:60px;" name="settleS0DValue" value="${mSettle.get('1006').bsosDrate}"/>(0.00-1.00)</td></tr>
	  	 </table>
	  	</td>
	  </tr>
	 </table>
	</form>
	<div id="btnarea">
  	<div class="btncommon" id="btnclose">关闭页面</div>
  </div>
<script type="text/javascript">
fnInitProvince($("select[name=areaPro]"));
$("select[name=areaPro]").change(function(){fnSwitchProvince();});
$("select[name=areaArea]").change(function(){fnInitCity(null);});
$("select[name=orelform]").val("${mOrg.orelform}");
$("select[name=otype]").val("${mOrg.otype}");
$("select[name=feeType]").val("${feetype}");

$("#btnsubmit").click(function(){
	window.parent.submitEditCheck($("#dlgform"),"${mOrg.uuid}");
});
$("#btnclose").click(function(){
	window.parent.closeEditDialog();
});
var targetotype = "${mOrg.otype}";
if(targetotype==1||targetotype==2){
	vhtml = "<option value='1'>管理机构</option><option value='2'>管理机构-部门</option><option value='3'>运营机构(OEM)</option><option value='5'>分销机构(代理)</option>";
	$("select[name=otype]").html(vhtml);
	$("select[name=otype]").val(targetotype);
	switchOtype();
}else if(targetotype==3||targetotype==5){
	vhtml = "<option value='5'>分销机构(代理)</option>";
	$("select[name=otype]").html(vhtml);
}
$("select[name=otype]").change(function(){switchOtype();});
function switchOtype(){
	otype = $("select[name=otype] option:selected").val();
	if(otype==1||otype==2){
		$("tr[id^=info_]").css("display","none");
	}else{
		$("tr[id^=info_]").css("display","");
	}
}
$("select[name=otype]").change(function(){switchOtype();});
switchOrgtype();
$("input").attr("disabled","true");
$("input").css("color","#999");
$("select").attr("disabled","true");
</script>
</body>
</html>