var FormDialog = {
	init:function(objdlg){
		var dialog = {};
		dialog.dlg = objdlg;		
		dialog.prepare = function(msg){
			if(msg==null||msg==""){
				msg = "正在处理，请待心等待...";
			}
			dialog.dlg.html(msg);
			return dialog;
		};
		dialog.open = function(){
			dialog.dlg.dialog("open");
			return dialog;
		};
		dialog.close = function(msg,delay){
			if(msg==null||msg==""){
				dialog.dlg.dialog("close");
			}else if(delay==null||delay==0){
				dialog.dlg.dialog("close");
			}else{
				if(delay>0&&dialog.dlg.dialog("isOpen")){
					setTimeout(function(){
						dialog.dlg.html("提交成功，"+(delay-1)+"秒后关闭页面！");
						delay--;
						dialog.close(msg,delay);
					},1000);
				}else{
					dialog.dlg.dialog("close");
					fnRefreshTable();
				}
			}
		};
		return dialog;
	}
};

var FormUtil = {
    init:function(){
    	var instance = {};
		instance.genItem = function(itemobj){
		    var itemtype = itemobj.itemType;
		    var strResult = "";
		    switch(itemtype){
		    	case "Input":
		    		inputValue = itemobj.inputValue==null?"":itemobj.inputValue;
		    		strResult+="<input name=\""+itemobj.inputName+"\" id=\""+itemobj.inputName+"\" class=\"\" value=\""+inputValue+"\" />";
		    		break;
		    	case "Radio":
		    		break;
		    	case "CheckBox":
		    		break;
		    	case "Select":
		    		break;
		    	case "TextArea":
		    		break;
		    	default:break;
		    }
		    return strResult;
		};
    	instance.wrapItem = function(itemObj,objtype){
    		var strResult = "";
    		switch(objtype){
    			case "Input":
    				strResult+='"'+itemObj.name+'":{"inputName":"'+itemObj.name+'","inputValue":"'+itemObj.value+'","inputStat":"","itemType":"'+objtype+'"}';
    				break;
    			case "Radio":
    				break;
    			case "CheckBox":
    				break;
    			case "Select":
    				break;
    			case "TextArea":
    				break;
    		}
    		return strResult;
    		//return eval('(' + strResult + ')');
    	};
    	return instance;
    }
};
    