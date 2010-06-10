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
	// ���� �Ϻ� ���� ���� �Ͼ� ���� �ϲ� �Ϸ� ���� ֣�� ���� ����
	public static Map<String, Integer> CITY_ID = new TreeMap<String, Integer>();
	static {
		CITY_ID.put("ȫ��", 0);
		CITY_ID.put("����", 1);
		CITY_ID.put("�Ϻ�", 2);
		CITY_ID.put("����", 3);
		CITY_ID.put("����", 4);
		CITY_ID.put("�Ͼ�", 5);
		CITY_ID.put("����", 6);
		CITY_ID.put("�ϲ�", 7);
		CITY_ID.put("�Ϸ�", 8);
		CITY_ID.put("����", 9);
		CITY_ID.put("֣��", 10);
		CITY_ID.put("����", 11);
		CITY_ID.put("����", 12);
	}

	public static Map<String, Integer> FROM_ID = new TreeMap<String, Integer>();
	static {
		FROM_ID.put("������", 0);
	}
	public static Map<String, String> FROM_PARSER = new TreeMap<String, String>();
	static {
		FROM_PARSER.put("������", "lashouParser");
	}

}