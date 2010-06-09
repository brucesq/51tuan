/**
 * 
 */
package com.tuan.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;



/**
 * Request utility methods.
 * @author BruceSun
 *
 */
public class RequestUtil {

	/**
	 * Get parameter int value . If has not return defaultNum.
	 * @param request
	 * @param paramName
	 * @param defaultNum
	 * @return
	 */
	public static int getIntParameter(HttpServletRequest request,String paramName,int defaultNum){
		String temp = request.getParameter(paramName);
		if(!StringUtil.isEmpty(temp)){
			try{
				return Integer.parseInt(temp);
			}catch(Exception e){ }
		}
		return defaultNum;
	}
	/**
	 * Get parameter int values.
	 * @param request
	 * @param paramName
	 * @return
	 */
	public static List<Integer> getIntParameters(HttpServletRequest request,String paramName){
		String[] tempArr = request.getParameterValues(paramName);
		System.out.println(tempArr.length);
		List<Integer> nums = new ArrayList<Integer>();
		if(tempArr != null){
			for(String temp : tempArr){
				try{
					nums.add(Integer.parseInt(temp));
				}catch(Exception e){ }
			}
		}
		return nums;
	}
	/**
	 * Get parameter boolean value
	 * @param request
	 * @param paramName
	 * @return
	 */
	public static boolean getBooleanParameter( HttpServletRequest request, String paramName ) {
		String temp = request.getParameter(paramName);
		if( temp != null && temp.equals("true") && temp.equals("1") ) {
			return true;
		} else {
			return false;
		}
	}   
	
	/**
	 * Get parameter value,if not return defaultValue.
	 * @param request
	 * @param paramName
	 * @return
	 */
	public static String getParameter(HttpServletRequest request, String paramName,String defaultValue ) {
		String temp = request.getParameter(paramName);
		if( !StringUtil.isEmpty(temp) ) {
			return temp;
		} else {
			return defaultValue;
		}
	}
	/**
	 * Set session attribute.
	 * @param request
	 * @param attributeName
	 * @param value
	 */
	public static void setSessionAttribute(HttpServletRequest request, String attributeName,Object value){
		request.getSession().setAttribute(attributeName, value);
	}
	/**
	 * Get sesion attribute.
	 * @param request
	 * @param attributeName
	 * @param defaultalue
	 * @return
	 */
	public static String getSessionAttribute(HttpServletRequest request, String attributeName,String defaultValue){
		String temp = (String)request.getSession().getAttribute(attributeName);
		if( !StringUtil.isEmpty(temp) ) {
			return temp;
		} else {
			return defaultValue;
		}
	}
	/**
	 * Get sesion int attribute. If not return default value.
	 * @param request
	 * @param attributeName
	 * @param defaultValue
	 * @return
	 */
	public static int getSessionIntAttribute(HttpServletRequest request, String attributeName,int defaultNum){
		Integer temp = (Integer)request.getSession().getAttribute(attributeName);
		if( temp != null ) {
			return temp;
		} else {
			return defaultNum;
		}
	}
}
