package com.rxoa.mypay.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String format(Date date,String formatStr){
		SimpleDateFormat formatDateTime = new SimpleDateFormat(formatStr);
		String resDateTime = formatDateTime.format(date);
		return resDateTime;
	}
	public static String getDateOnly(Date date){
		return format(date,"yyyy-MM-dd");
	}
	public static String getTimeOnly(Date date){
		return format(date,"HH:mm:ss");
	}
	public static String getFullDateTime(Date date){
		return format(date,"yyyy-MM-dd HH:mm:ss");
	}
	public static String getDateString(Date date){
		return format(date,"yyyyMMdd");
	}
	public static String getTimeString(Date date){
		return format(date,"HHmmss");
	}
	public static String getFullString(Date date){
		return format(date,"yyyyMMddHHmmss");
	}
	public static String getNowDateOnly(){
		return format(new java.util.Date(),"yyyy-MM-dd");
	}
	public static String getNowTiemOnly(){
		return format(new java.util.Date(),"HH:mm:ss");
	}
	public static String getNowFullDateTime(){
		return format(new java.util.Date(),"yyyy-MM-dd HH:mm:ss");
	}
	public static String getNowFullString(){
		return format(new java.util.Date(),"yyyyMMddHHmmss");
	}
	public static String getNowDateString(){
		return format(new java.util.Date(),"yyyyMMdd");
	}
	public static String getNowTimeString(){
		return format(new java.util.Date(),"HHmmss");
	}
	
	/*
	 * 时间解析函数，将字符串格式为日期时间格式
	 */
	public static Date parse(String dateTimeString,String formatString){
		SimpleDateFormat formatDateTime = new SimpleDateFormat(formatString);
		try {
			return formatDateTime.parse(dateTimeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Date parseFromFullDateTime(String dateTimeString){
		return parse(dateTimeString,"yyyy-MM-dd HH:mm:ss");
	}
	/*
	 * 日期调整函数，根据参数对日期进行调整
	 */
	public static Date adjust(Date date,int type,int num){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		switch(type){
			case 1:calendar.add(Calendar.YEAR, num);break;
			case 2:calendar.add(Calendar.MONTH, num);break;
			case 3:calendar.add(Calendar.DATE, num);break;
			case 4:calendar.add(Calendar.HOUR, num);break;
			case 5:calendar.add(Calendar.MINUTE, num);break;
			case 6:calendar.add(Calendar.SECOND, num);break;
			case 7:calendar.add(Calendar.WEEK_OF_YEAR, num);break;
			default:break;
		}
		return calendar.getTime();
	}
	
	/*
	 * 日期比较函数，比较日期大小
	 */
	public static int compare(String d_one,String d_two){
		try {
			SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return compare(formatDateTime.parse(d_one),formatDateTime.parse(d_two));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int compare(Date d_one,Date d_two){
		try{
			if(d_one.getTime()>d_two.getTime()){
				return 1;
			}
			return -1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	/*
	 * 计算日期关值函数，计算两个日期之间的差值,日，时，分，秒
	 */
	public static double difference(Date d_one,Date d_two){
		return d_one.getTime() - d_two.getTime();
	}
	public static double differenceBySec(Date d_one,Date d_two){
		return difference(d_one,d_two)/1000;
	}
	public static double differenceByMin(Date d_one,Date d_two){
		return difference(d_one,d_two)/1000/60;
	}
	public static double differenceByHour(Date d_one,Date d_two){
		return difference(d_one,d_two)/1000/60/60;
	}
	public static double differenceByDay(Date d_one,Date d_two){
		return difference(d_one,d_two)/1000/60/60/24;
	}
}
