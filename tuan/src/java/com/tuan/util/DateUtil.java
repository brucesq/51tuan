/**
 * 
 */
package com.tuan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date utility methods.
 * @author BruceSun
 *
 */
public class DateUtil {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm");
	/**
	 * Format email date, if is today return hour and second ,else return date.
	 * @param date
	 * @return
	 */
	public static String formatEmailDate(Date date){
		if(isToday(date)){
			return TIME_FORMAT.format(date);
		}else{
			return DATE_FORMAT.format(date);
		}
	}
	/**
	 * Is today date.
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date){
		Calendar today = Calendar.getInstance();
		Calendar ca = Calendar.getInstance();
		today.setTime(new Date());
		ca.setTime(date);
		if(today.get(Calendar.DATE)==ca.get(Calendar.DATE)&&
				today.get(Calendar.MONTH)==ca.get(Calendar.MONTH)&&
				today.get(Calendar.YEAR)==ca.get(Calendar.YEAR))
			return true;
		return false;
	}
	/**
	 * Date to String 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date){
		return DATE_FORMAT.format(date);
	}
	/**
	 * Date to String
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(Date date,String format){
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	/**
	 * String to Date
	 * @param str
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String str,String format) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(str);
	}
}
