var PageInfo = {
	init:function(){
		var page = {};
		page.searchType = "";
		page.searchString = "";
		page.searchform = "";
		page.cateString = "";
		page.ordertype = "";
		page.orderkey = "";
		page.curpage = "1";
		page.psize = "15";
		page.pageUrl = "";
		page.styleJson = "";
		page.crumbString = "";
		
		page.refresh = function(mObject){
			page.searchType = mObject.mObject.searchType;
			page.order = mObject.mObject.order;
			page.curpage = mObject.mObject.curpage;
			page.psize = mObject.mObject.psize;
		};
		return page;
	}
};
TreeInfo = {
	init:function(curnode){
		var tree = {};
		tree.curnode = curnode;
		tree.refresh = function(){
			
		};
		return tree;
	}
};
function resizePage(){
	if(window.parent.document){
		$("#maintablediv").css("height",$('#divrightwindow', window.parent.document).outerHeight()-150+"px");
	}
}
function fnExpandTreeNav(){
if($("#lcatetree").css("display")=="none"){
	$("#lcatetree").css("display","");
	$("#ucontent").css("left","200px");
}else{
	$("#lcatetree").css("display","none");
	$("#ucontent").css("left","0px");
}
}
function selall(){
	$(".selcheckbox").each(function(){
		this.checked = true; //新版本jQuery已不可设置checked事件,改用原生JS
	});
}

function deselall(){
	$(".selcheckbox").each(function(){
		if(this.checked == true){
			this.checked = false;
		}else{
			this.checked = true;
		}
	});
}
function fnCreateTable(objjson){
	try{if(isExitsFunction(setAvator)==true){objjson=setAvator(objjson);}}catch(e){}
	var stylejson = pageinfo.styleJson;
	var avatarJson = objjson.avatar;
	var isItemNew = objjson.mObject.btnItemNew;
	var isItemDel = objjson.mObject.btnItemDel;
	var isItemEdit = objjson.mObject.btnItemEdit;
	var isItemShow = objjson.mObject.btnItemShow;
	
	var colstyle = null;
	if(stylejson==null||stylejson==""){
		colstyle = objjson.pStyle.tableStyle.tableCol;
	}else{
		colstyle = fnStrtoJson(stylejson).pStyle.tableStyle.tableCol;
	}
	//表头
	var titlestr = "<tr id=\"titletabletr\">"
		+"<td style=\"width:20px;\"></td>"
		+"<td style=\"width:30px;\"></td>";
	titlestr+="<td class=\"mtabletitletd\" sytle=\"width:140px;text-align:center;\" align=center>操作区间</td>";
	for (var i=0;i<fnGetJsonLength(colstyle);i++){
		titlestr+="<td style=\"width:"+colstyle[i].colWidth+"\">"+colstyle[i].colText+"</td>";
	}
	titlestr+="</tr>";
	$('#titletable').html("");
	$('#titletable').append(titlestr);
	//表主体
	var tablestr = "";
	var opwidth = 10;
	if(isItemNew){opwidth+=45;}if(isItemEdit){opwidth+=45;}if(isItemDel){opwidth+=45;}if(isItemShow){opwidth+=45;}
	for(var j=0;j<fnGetJsonLength(objjson.mObject.list);j++){
		var btnstr = "";
		if(j%2==0){
			tablestr += "<tr class=\"mtablestr\"><td class=\"mtableordertd\">"+(j+1)+"</td>";
		}else{
			tablestr += "<tr class=\"mtabledtr\"><td class=\"mtableordertd\">"+(j+1)+"</td>";
		}
		tablestr+="<td class=\"mtablechecktd\"><input class=\"selcheckbox\" type=\"checkbox\" name=\""+objjson.mObject.list[j]['uuid']+"\" value=\""+objjson.mObject.list[j]['uuid']+"\" /></td>";
		if(isItemNew){
			btnstr+="";
		}
		if(isItemEdit){
			btnstr+="<button class=\"EditButton\" onclick=\"fnEditItem('"+objjson.mObject.list[j].uuid+"')\" >编辑</button>";
		}
		if(isItemDel){
			btnstr+="<button class=\"DeleteButton\" onclick=\"fnDeleteItem('"+objjson.mObject.list[j].uuid+"')\">删除</button>";
		}
		if(isItemShow){
			btnstr+="<button class=\"ShowButton\" onclick=\"fnShowItem('"+objjson.mObject.list[j].uuid+"')\" >查看</button>";
		}
		tablestr+="<td align=center class=\"mtablebuttontd\">"+btnstr+"</td>";
		
		for(var m=0;m<fnGetJsonLength(colstyle);m++){
			tablestr+="<td class=\"mtablevaluetd\" style=\"width:"+colstyle[m].colWidth+"\">"+textFromCode(avatarJson,colstyle[m].colName,objjson.mObject.list[j][colstyle[m].colName])+"</td>";
		}
		tablestr+="</tr>";
	}
	$('#maintable').html("");
	if(tablestr==""){tablestr = "<div style=\"width:100%;text-align:center;padding-top:30px;color:#6666DD\">【抱歉，没有符合条件的数据】</div>";}
	$('#maintable').append(tablestr);
	if(opwidth==10){
		$(".mtablebuttontd").css("display","none");
		$(".mtabletitletd").css("display","none");
	}else{
		$(".mtablebuttontd").width(opwidth);
		$(".mtabletitletd").width(opwidth);
	}
	//批量操作区
	fnSetBatBtnArea(objjson.mObject);
	
	//换页区
	fnCreatePageController(objjson.mObject);
	
	//面包屑
	fnSetCrumb($("#pagecrumb"));
	
	//搜索区
	
	//刷新页面信息
	pageinfo.refresh(objjson);
}
function fnCreatePageController(mobj){
	var total = mobj.total;
	var cur = mobj.curpage;
	var haspre = mobj.hasPre;
	var hasnext = mobj.hasNext;
	var psize = mobj.psize;
	var totalpage = mobj.totalPage;

	var firstcss="first",precss="pre",nextcss="next",lastcss="last";
	if(!haspre){precss="first disable";}
	if(!hasnext){nextcss="next disable";}
	if(cur=="1"){firstcss="first disable";}
	if(cur==totalpage){lastcss="last disable";}
	var pagestr = "<span class=\"page-info\">共"+total+"条/每页"+psize+"条</span>"
    +"<span class=\"page-cur\">第"+cur+"/"+totalpage+"页</span>"
    +"<span class=\"pager\">"
     +"<span class=\""+firstcss+"\" onclick=\"fnGoPage('1')\"></span>"
     +"<span class=\""+precss+"\" onclick=\"fnGoPage('"+(parseInt(cur)-1)+"')\"></span>"
     +"<span class=\"pager-cur\"></span>"
     +"<span class=\""+nextcss+"\" onclick=\"fnGoPage('"+(parseInt(cur)+1)+"')\"></span>"
     +"<span class=\""+lastcss+"\" onclick=\"fnGoPage('"+totalpage+"')\"></span>"
    +"</span>"
    +"<span class=\"page-go\">"
     +"跳转到";
     var vstr = "<input id=\"topjpageinput\" name=\"jpageto\" style=\"width:30px;text-align:center;\" />"
     +"页"
    +"</span>"
    +"<span class=\"page-submit\">"
     +"<span class=\"btn btn-default\">"
      +"<span class=\"btn-content\" onclick=\"fnGoPage($('#topjpageinput').val())\">确定</span>"
     +"</span>"
    +"</span>";
     $("#topcontrol .page-control").empty();
     $("#topcontrol .page-control").append(pagestr+vstr);
     vstr = "<input id=\"bottomjpageinput\" name=\"jpageto\" style=\"width:30px;text-align:center;\" />"
         +"页"
        +"</span>"
        +"<span class=\"page-submit\">"
         +"<span class=\"btn btn-default\">"
          +"<span class=\"btn-content\" onclick=\"fnGoPage($('#bottomjpageinput').val())\">确定</span>"
         +"</span>"
        +"</span>";
     $("#bottomcontrol .page-control").empty();
     $("#bottomcontrol .page-control").append(pagestr+vstr);	
}
function fnSetBatBtnArea(mobj){
	var isBtnNew = mobj.btnNew;
	var isBtnBatDel = mobj.btnBatDel;
	var isBtnCheckbox = mobj.btnCheckbox;

	if(!isBtnCheckbox){
		$(".tdselall").css("display","none");
	}else{
		$(".tdselall").css("display","");
	}
	if(!isBtnBatDel){
		$(".btn-batchdel").css("display","none");
	}else{
		$(".btn-batchdel").css("display","");
	}
	if(!isBtnNew){
		$(".btn-new").css("display","none");	
	}else{
		$(".btn-new").css("display","");
	}
}
function fnSetCrumb(target){
	var crs = pageinfo.crumbString.split(",");
	var crumbstr = "";
	for(var i=0;i<crs.length;i++){
		if(crumbstr==""){
			crumbstr=crs[i];
		}else{
			crumbstr+="》"+crs[i];
		}
	}
	target.html(crumbstr);
}
function fnGoPage(page){
	if(page==null||page==""){return false;}
	pageinfo.curpage = page;
	fnRefreshPage();
}

function fnRefreshPage(){
	startLoading();
	$.ajax({
		type:"POST",
		url:pageinfo.pageUrl+"/"+pageinfo.curpage+"/"+pageinfo.psize,
		data:"cateString="+pageinfo.cateString+"&searchType="+pageinfo.searchType+"&order="+pageinfo.order+"&searchString="+encodeURIComponent(pageinfo.searchString)+pageinfo.searchform,
		dataType:"json",
		success:function(msg){
			fnCreateTable(msg);
			stopLoading();
		}
	});
}

function startLoading(msg){
	$("#progressBar").css("display","");
}
function stopLoading(msg){
	$("#progressBar").css("display","none");
}
function fnDoSearch(){
	pageinfo.searchType = "1";
	pageinfo.curpage = "1";
	var searchstr = fnGenSearchString();
	pageinfo.searchString = searchstr;
	fnRefreshPage();
}
function fnClearSearch(){
	pageinfo.searchString = "";
	pageinfo.searchform = "";
	fnRefreshPage();
}
function fnGenSearchString(){
	var options = $("#searchkeytype option");
	var keyvalue = $("#searchkey").val();
	var searchstr = "";
	if(keyvalue==""){return;}
	
	for(var i=0;i<options.length;i++){
		if(options[i].value!="index"){
			if(searchstr==""){
				searchstr=options[i].value+"@'%"+keyvalue+"%'";
			}else{
				searchstr+="||"+options[i].value+"@'%"+keyvalue+"%'";
			}
		}
		if(options[i].selected){
			if(options[i].value!="index"){
				return options[i].value+"@'%"+keyvalue+"%'";
			}
		}
	}
	return searchstr;
}
function fnCreateTree(strjson){
	var objjson = fnStrtoJson(strjson);
	fnAddSubNode(objjson.tree,"uorgtree");
	$("#uorgtree").treeview({
		unique:true
	});
	$("#uorgtree .folder").click(function(){
		fnOrgTreeClick(this);
	});
}
function fnAddSubNode(objjson,parid){
	var curid = objjson.orgId;
	$("#"+parid).append("<li id=\"li"+curid+"\"><span class=\"folder\">"+objjson.orgName+"</span>");
	if(objjson.subNode!=null&&objjson.subNode!=""){
		$("#li"+curid).append("<ul id=\"ul"+curid+"\">");
		for(var i=0;i<fnGetJsonLength(objjson.subNode);i++){
			fnAddSubNode(objjson.subNode[i],"ul"+curid);
		}
		$("#li"+curid).append("</ul>");
	}
	$("#ul"+parid).append("</li>");
}

function fnCreateEditDlg(tar,targetid,title,geturl,saveurl,sucmsg,failmsg){
	var target = null;
	if(tar=="self"){
		target = $("#"+targetid);
	}
	target.html("");
    target.append("<iframe id=\"dlgframe\" style=\"width:100%;height:100%;border:none;overflow:auto;\" src=\""+geturl+"\"></iframe>");
	target.dialog({
        autoOpen: false,
        height: 400,
        title: title,
        width: 800,
        modal: true,
        close:function(){
            ;
        }
    });
    var dialog = FormDialog.init(target).open();
}
function fnCreateShowDlg(tar,targetid,title,geturl){
	var target = null;
	if(tar=="self"){
		target = $("#"+targetid);
	}
	target.html("");
    target.append("<iframe id=\"dlgframe\" style=\"width:100%;height:100%;border:none;overflow:auto;\" src=\""+geturl+"\"></iframe>");
	target.dialog({
        autoOpen: false,
        height: 400,
        title: title,
        width: 800,
        modal: true,
        //buttons: {
          //  关闭:function(){
            //    $(this).dialog("close");
        	//}
        //},
        close:function(){
            ;
        }
    });
    var dialog = FormDialog.init(target).open();
}