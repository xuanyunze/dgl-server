function initIndex() { //函数：获取尺寸
	//获取窗口宽度
	if (window.innerWidth) {
		winWidth = window.innerWidth;
    }else if ((document.body) && (document.body.clientWidth)) {
        winWidth = document.body.clientWidth;
    }
    //获取窗口高度
    if (window.innerHeight) {
        winHeight = window.innerHeight;
    }else if ((document.body) && (document.body.clientHeight)) {
        winHeight = document.body.clientHeight;
    }
    //通过深入Document内部对body进行检测，获取窗口大小
    if (document.documentElement && document.documentElement.clientHeight && document.documentElement.clientWidth) {
        winHeight=document.documentElement.clientHeight;
        winWidth=document.documentElement.clientWidth;
    }
    //结果输出至两个文本框
    topHeight = $("#divtop").outerHeight();
    bottomHeight = $("#divbottom").outerHeight();
    //document.form1.availWidth.value = winWidth;
    //设置div的具体宽度=窗口的宽度的%
    if (document.getElementById("divmiddle")) {
        document.getElementById("divmiddle").style.height = (winHeight-topHeight-bottomHeight) + "px";
        $("#divright").css("width",($("#divmiddle").width()-$("#divleft").outerWidth()-5) + "px");
        $("#divright").css("width",(window.innerWidth-$("#divleft").outerWidth()-5) + "px");
        $("#divrightwindow").css("height",(window.innerHeight-120)+"px");
        //$("#maintablediv").css("height",($("#divright").height() -120) + "px");
     }
}
function fnExpandNav(){
	if($("#divlefttree").css("display")=="none"){
		$("#divlefttree").css("display","block");
		$("#divleft").css("width","200px");
		$("#divright").css("left","200px");
		$(".sidebar-toggle").removeClass("toggle-hide").addClass("toggle-show");
	}else{
		$("#divlefttree").css("display","none");
		$("#divleft").css("width","15px");
		$("#divright").css("left","15px");
		$(".sidebar-toggle").removeClass("toggle-show").addClass("toggle-hide");
	}
}
/*
function fnExpandNav(){
	if($("#divlefttree").css("display")=="none"){
		$("#divlefttree").css("display","block");
		$("#divleft").css("width","200px");
		$("#divright").css("width",($("#divmiddle").outerWidth()-$("#divleft").outerWidth()-5) + "px");
		$("#divright").css("width",(window.innerWidth-$("#divleft").outerWidth()-5) + "px");
		$(".sidebar-toggle").removeClass("toggle-hide").addClass("toggle-show");
	}else{
		$("#divlefttree").css("display","none");
		$("#divleft").css("width","15px");
		$("#divright").css("width",($("#divmiddle").width()-$("#divleft").outerWidth()-5) + "px");
		$(".sidebar-toggle").removeClass("toggle-show").addClass("toggle-hide");
	}
}
*/
function fnCreateNav(strjson){
	var objjson = fnStrtoJson(strjson);
	fnCreateTopNav(objjson);
	var navobj = objjson.navtree.topCate[0];
	fnCreateLeftNav(navobj,"init");
}
function fnCreateTopNav(objjson){
	var target = $("#nav_main");
	for(var i=0;i<fnGetJsonLength(objjson.navtree.topCate);i++){
		target.append("<li class=\"nav_main_item\">"+
				"<a href=\"javascript:fnTopNavGo('"+objjson.navtree.topCate[i].topCateId+"');\">"+objjson.navtree.topCate[i].topCateName+"</a></li>"
		);
	}
	target.append("<li class=\"nav_main_item\">"
			+"<a href=\"#\">帮助</a></li>"
     );
}
function fnCreateLeftNav(navobj,type){
	if(type!="init"){
		navobj = navobj.navtree.topCate[0];
	}
	$(".subNavBox").html("");
	for(var i=0;i<fnGetJsonLength(navobj.leftCate);i++){
		var nul = "";
		if(i==0){
			$(".subNavBox").append("<div class=\"subNav currentDd currentDt\">"+navobj.leftCate[i].cateName+"</div>");
			nul+="<ul class=\"navContent\" style=\"display:block\">";
		}else{
			$(".subNavBox").append("<div class=\"subNav\">"+navobj.leftCate[i].cateName+"</div>");
			nul+="<ul class=\"navContent\">";
		}
		for(var j=0;j<fnGetJsonLength(navobj.leftCate[i].leftNode);j++){
			nul+="<li><a href=\"javascript:fnLeftNavGo('"+navobj.leftCate[i].leftNode[j].nodeHref+"')\">"+navobj.leftCate[i].leftNode[j].nodeName+"</a></li>";
		}
		$(".subNavBox").append(nul+"</ul>");
	}
    $(function(){
        $(".subNav").click(function(){
        	$(this).toggleClass("currentDd").siblings(".subNav").removeClass("currentDd");
            $(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt");
            $(this).next(".navContent").slideToggle(300).siblings(".navContent").slideUp(500);
          });
    });
}
function fnTopNavGo(cateId){
	$.ajax({
    	type : "GET",
		url : "nav/navone.json/"+cateId,
		data : "",
		dataType: "text",
		success : function(msg) {
			fnCreateLeftNav(fnStrtoJson(msg));
		}
	});
}
function fnLeftNavGo(strHref){
	fnLoadMainPage(strHref);
}
function fnLoadMainPage(strHref){
	$("#win1").html("");
	$("#win1").append("<iframe src=\""+strHref+"\" style=\"width:100%;height:100%;margin:0;padding:0;border:none;\" scrolling=\"no\";></iframe>");
}
var Calendar = {
	init:function(){
		var calendar = {};
		var date = new Date();
		calendar.year = date.getFullYear();
		calendar.month = date.getMonth() + 1;
		calendar.date = date.getDate();
		calendar.day = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")[date.getDay()];
		calendar.hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
		calendar.minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
		calendar.second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
		calendar.getDateText = function(){
			return calendar.year+"年"+calendar.month+"月"+calendar.date+"日";
		};
		calendar.getDayText = function(){
			return calendar.day;
		};
		return calendar;
	}
};
