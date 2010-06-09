/**
 * 
 */
package com.tuan.domain;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author sunquanzhi
 *
 */
public class Constants {
	// 北京  上海  深圳  广州  南京  大庆  南昌  合肥  福州  郑州  大连  西安  
	private static Map<String, Integer> CITY_ID = new TreeMap<String, Integer>();
	static {
		CITY_ID.put("全国", 0);
		CITY_ID.put("北京", 1);
		CITY_ID.put("上海", 2);
		CITY_ID.put("深圳", 3);
		CITY_ID.put("广州", 4);
		CITY_ID.put("南京", 5);
		CITY_ID.put("大庆", 6);
		CITY_ID.put("南昌", 7);
		CITY_ID.put("合肥", 8);
		CITY_ID.put("福州", 9);
		CITY_ID.put("郑州", 10);
		CITY_ID.put("大连", 11);
		CITY_ID.put("西安", 12);
	}

	
}
