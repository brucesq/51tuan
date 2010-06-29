/**
 * 
 */
package com.tuan.domain;

import java.util.Map;
import java.util.TreeMap;

import com.tuan.util.PropertiesReaderUtil;

/**
 * @author sunquanzhi
 * 
 */
public class Constants {

	public static Map<String, Integer> CITY_ID = new TreeMap<String, Integer>();
	static {
		String citystr = PropertiesReaderUtil.getInstance("constants.properties").getProperty("CITY_ID");
		String[] citys = citystr.split(";");
		for(String city : citys){
			String[] kv = city.split(":");
			CITY_ID.put(kv[0], Integer.parseInt(kv[1]));
		}
	}
	
	public static String getCityString(){
		StringBuilder builder = new StringBuilder();
		for(Map.Entry<String, Integer> entry : CITY_ID.entrySet()){
			builder.append(";");
			builder.append(entry.getValue());
			builder.append(":");
			builder.append(entry.getKey());
		}
		return builder.toString().substring(1);
	}
	
	public static String getParserNameString(){
		StringBuilder builder = new StringBuilder();
		for(Map.Entry<String, String> entry : FROM_PARSER.entrySet()){
			builder.append(";");
			builder.append(entry.getValue());
			builder.append(":");
			builder.append(entry.getKey());
		}
		return builder.toString().substring(1);
	}
	
	public static String getFromNameString(){
		StringBuilder builder = new StringBuilder();
		for(Map.Entry<String, Integer> entry : FROM_ID.entrySet()){
			builder.append(";");
			builder.append(entry.getValue());
			builder.append(":");
			builder.append(entry.getKey());
		}
		return builder.toString().substring(1);
	}

	public static Map<String, Integer> FROM_ID = new TreeMap<String, Integer>();
	static {
		String fromstr = PropertiesReaderUtil.getInstance("constants.properties").getProperty("FROM_ID");
		String[] froms = fromstr.split(";");
		for(String from : froms){
			String[] kv = from.split(":");
			FROM_ID.put(kv[0], Integer.parseInt(kv[1]));
		}
	}
	public static Map<String, String> FROM_PARSER = new TreeMap<String, String>();
	static {
		String fromstr = PropertiesReaderUtil.getInstance("constants.properties").getProperty("FROM_PARSER");
		String[] froms = fromstr.split(";");
		for(String from : froms){
			String[] kv = from.split(":");
			FROM_PARSER.put(kv[0], kv[1]);
		}
	}
	
	public static String getCityName(String cityId) {
		for (Map.Entry<String, Integer> entry : CITY_ID.entrySet()) {
			if (entry.getValue().equals(cityId)) {
//				System.out.println(entry.getKey()+":"+cityId);
				return entry.getKey();
			}
		}
		return "";
	}

}
