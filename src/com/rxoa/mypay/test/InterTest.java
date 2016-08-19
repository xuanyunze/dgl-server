package com.rxoa.mypay.test;

import java.lang.reflect.Field;
import java.util.Map;

import com.rxoa.mypay.db.po.MbilOrderTakemoney;

public class InterTest {
	public MbilOrderTakemoney parseout(Map<String,String> avator){
		try{
			MbilOrderTakemoney money = new MbilOrderTakemoney();
			for (String key : avator.keySet()) {
				Field field = MbilOrderTakemoney.class.getDeclaredField(key);
				field.setAccessible(true);
				field.set(money, avator.get(key));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
