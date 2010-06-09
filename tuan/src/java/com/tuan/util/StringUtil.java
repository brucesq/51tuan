/**
 * 
 */
package com.tuan.util;

import java.util.Date;

/**
 * String utility methods.
 * @author BruceSun
 *
 */
public class StringUtil {

	
	/**
	 * Judge string whether string is null or empty.
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return str == null || str.trim().length() == 0;
	}
	
	/**
	 * Escape special characters with their JSON equivalents.
	 * @param str
	 * @return
	 */
	public static String escapeJson(String str){
		if(isEmpty(str)){
			return "";
		}
		char         b;
	    char         c = 0;
	    int          i;
	    int          len = str.length();
	    String       t;
		StringBuilder sb = new StringBuilder(len+4);
		for (i = 0; i < len; i += 1) {
	            b = c;
	            c = str.charAt(i);
	            switch (c) {
	            case '\\':
	            case '"':
	                sb.append('\\');
	                sb.append(c);
	                break;
	            case '/':
	                if (b == '<') {
	                    sb.append('\\');
	                }
	                sb.append(c);
	                break;
	            case '\b':
	                sb.append("\\b");
	                break;
	            case '\t':
	                sb.append("\\t");
	                break;
	            case '\n':
	                sb.append("\\n");
	                break;
	            case '\f':
	                sb.append("\\f");
	                break;
	            case '\r':
	                sb.append("\\r");
	                break;
	            default:
	                if (c < ' ' || (c >= '\u0080' && c < '\u00a0') ||
	                               (c >= '\u2000' && c < '\u2100')) {
	                    t = "000" + Integer.toHexString(c);
	                    sb.append("\\u" + t.substring(t.length() - 4));
	                } else {
	                    sb.append(c);
	                }
	           }
	    }
		return sb.toString();
	}
	/**
	 * Escape special characters with their HTML equivalents.
	 * @param text
	 * @return
	 */
	public static String escapeHtml(String text) {
        if (text == null || text.length() == 0) return "";
		StringBuilder result = new StringBuilder(text.length());
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			switch (c) {
				case '<' : result.append("&lt;"); break;
				case '>' : result.append("&gt;"); break;
				case '&' : result.append("&amp;"); break;
				case '\"' : result.append("&quot;"); break;
				case '\'' : result.append("&#039;"); break;
				case 0x0a : // Follow through...
				case 0x0d : result.append(" "); break;
				default: result.append(c); break;
			}
		}
		return result.toString();
    }
	
	
	/**
	 * Format email date, if is today return hour and second ,else return date.
	 * @param date
	 * @return
	 */
	public static String formatEmailDate(Date date){
		return DateUtil.formatEmailDate(date);
	}
	/**
	 * Trim a designated string
	 * @param str
	 * @param trimStr
	 * @return
	 */
	public static String extendedTrim(String str, String trimStr) {
		if (str == null || str.length() == 0)
			return str;
		for (str = str.trim(); str.startsWith(trimStr); str = str.substring(trimStr.length()).trim());
		for (; str.endsWith(trimStr); str = str.substring(0, str.length() - trimStr.length()).trim());
		return str;
	}
}
