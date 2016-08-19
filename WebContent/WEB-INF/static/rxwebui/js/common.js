function fnStrtoJson(strjson){
	return eval('(' + strjson + ')');
}
function fnGetJsonLength(objjson){
    var length = 0;
    for (item in objjson) {
        length++;
    }
    return length;
}
function textFromCode(avatarJson,item,code){
	if(item=="creTime"||item=="modTime"){
		return new Date(parseFloat(code)).format("yyyy-MM-dd hh:mm:ss");
	}else if(item=="odValue"||item=="trValue"){
		return parseFloat(code).toFixed(2);
	}
	if(typeof(avatarJson)!="undefined"&&avatarJson!=null){
		var vitem = avatarJson[item];
		if(typeof(vitem)!="undefined"&&vitem!=null){
			var ctext = vitem[code];
			if(typeof(ctext)!="undefined"){
				return ctext;
			}
		}
	}
	return code;
}
function disableItem(item){
	item.attr("disabled","true");
	item.css("color","#999");
}
function hideCardno(cno){
	pre = cno.substring(0,6);
	anx = cno.substring(cno.length-4);
	px = "";
	for(var i=0;i<cno.length-10;i++){
		px+="*";
	}
	return pre+px+anx;
}
function hidePhoneno(cno){
	pre = cno.substring(0,3);
	anx = cno.substring(cno.length-4);
	px = "";
	for(var i=0;i<cno.length-7;i++){
		px+="*";
	}
	return pre+px+anx;
}
function hideName(cno){
	var px = cno.substring(0,1);
	for(var i=1;i<cno.length;i++){
		px+="*";
	}
	return px;
}
Date.prototype.format = function(format) {
    var o = {
        "M+": this.getMonth() + 1,
        // month
        "d+": this.getDate(),
        // day
        "h+": this.getHours(),
        // hour
        "m+": this.getMinutes(),
        // minute
        "s+": this.getSeconds(),
        // second
        "q+": Math.floor((this.getMonth() + 3) / 3),
        // quarter
        "S": this.getMilliseconds()
        // millisecond
    };
    if (/(y+)/.test(format) || /(Y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
};
function isExitsFunction(funcName) {
    try {
        if (typeof(eval(funcName)) == "function") {
            return true;
        }
    } catch(e) {}
    return false;
}
