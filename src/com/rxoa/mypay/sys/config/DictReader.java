package com.rxoa.mypay.sys.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.rxoa.mypay.db.po.BaseDict;
import com.rxoa.mypay.db.service.in.IBaseDictService;

@Component
public class DictReader {
	public static DictReader dict = null;
	private Map<String,Map<String,String>> valueMap;
	private Map<String,Map<String,String>> textMap;
	private DictReader(){};
	
	@Resource(name="baseDictService")
	private IBaseDictService dictService;
	
	@PostConstruct
	private DictReader load(){
		try{
			dict = this;
			dict.dictService = this.dictService;
			valueMap = new HashMap<String,Map<String,String>>();
			textMap = new HashMap<String,Map<String,String>>();
			List<BaseDict> list = dictService.findByCondition(" and stat = 0 order by dcType asc,dcValue asc");
			Iterator<BaseDict> it = list.iterator();
			String type = "";
			Map<String,String> valuetmp = null,texttmp = null;
			while(it.hasNext()){
				BaseDict one = it.next();
				if(type.equals("")){
					type = one.getDcType();
					valuetmp = new HashMap<String,String>();
					texttmp = new HashMap<String,String>();
				}else if(!type.equals(one.getDcType())){
					valueMap.put(type, valuetmp);
					textMap.put(type, texttmp);
					type = one.getDcType();
					valuetmp = new HashMap<String,String>();
					texttmp = new HashMap<String,String>();
				}
				valuetmp.put(one.getDcValue(),one.getDcAvatar());
				texttmp.put(one.getDcAvatar(), one.getDcValue());
			}
			valueMap.put(type, valuetmp);
			textMap.put(type, texttmp);
		}catch(Exception e){
			e.printStackTrace();
		}
		return this;
	}
	public static String getText(String item,String value){
		if(dict==null){
			dict = new DictReader().load();
		}
		return dict.valueMap.get(item).get(value);
	}
	public static String getValue(String item,String text){
		if(dict==null){
			dict = new DictReader().load();
		}
		return dict.textMap.get(item).get(text);
	}
	public static Map<String,Map<String,String>> getTextMap(List<String> list){
		Map<String,Map<String,String>> map = new HashMap<String,Map<String,String>>();
		try{
			if(dict==null){
				dict = new DictReader().load();
			}
			Iterator<String> it = list.iterator();
			while(it.hasNext()){
				String key = it.next();
				map.put(key,dict.textMap.get(key));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	public static Map<String,Map<String,String>> getValueMap(List<String> list){
		Map<String,Map<String,String>> map = new HashMap<String,Map<String,String>>();
		try{
			if(dict==null){
				dict = new DictReader().load();
			}
			Iterator<String> it = list.iterator();
			while(it.hasNext()){
				String key = it.next();
				map.put(key,dict.valueMap.get(key));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	public static Map<String,Map<String,String>> getTextMap(Map<String,String> vmap){
		Map<String,Map<String,String>> map = new HashMap<String,Map<String,String>>();
		try{
			for(String key:vmap.keySet()){
				map.put(key,dict.textMap.get(vmap.get(key)));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	public static Map<String,Map<String,String>> getValueMap(Map<String,String> vmap){
		Map<String,Map<String,String>> map = new HashMap<String,Map<String,String>>();
		try{
			for(String key:vmap.keySet()){
				map.put(key,dict.valueMap.get(vmap.get(key)));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
}
