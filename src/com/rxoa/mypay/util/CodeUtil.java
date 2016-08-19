package com.rxoa.mypay.util;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeUtil {

	public static Field[] GetClassFields(String className){
		Field[] fields = null;
		try {
			Class<?> clazz = Class.forName(className);//根据类名获得其对应的Class对象 写上你想要的类名就是了 注意是全名 如果有包的话要加上 比如java.Lang.String
			fields = clazz.getDeclaredFields();//根据Class对象获得属性 私有的也可以获得
		} catch(Exception e) {
			e.printStackTrace();
		}
		return fields;
	}
	public static List<Map<String,String>> getPoFields(String className){
		Field[] fields = GetClassFields(className);
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		try{
			for(Field f : fields) {
				Map<String,String> map = new HashMap<String,String>();
				if(f.getName().equalsIgnoreCase("serialVersionUID")){continue;}
				if(f.getName().equalsIgnoreCase("uuid")){continue;}
				//if(f.getName().toLowerCase().contains("time")){continue;}
				map.put("varname",f.getName());
				map.put("vartype", f.getType().getName());
				list.add(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
