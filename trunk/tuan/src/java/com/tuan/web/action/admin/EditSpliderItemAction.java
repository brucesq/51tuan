/**
 * 
 */
package com.tuan.web.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuan.domain.SpliderItem;
import com.tuan.service.SpliderService;
import com.tuan.web.framework.ajax.AjaxAction;
import com.tuan.web.framework.ajax.AjaxServlet;

/**
 * @author sunquanzhi
 *
 */
public class EditSpliderItemAction implements AjaxAction{

	private SpliderService spliderService;

	public void setSpliderService(SpliderService spliderService) {
		this.spliderService = spliderService;
	}   
	
	public void execute(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
		Enumeration eu =  request.getParameterNames();
		while(eu.hasMoreElements()){	
			String s = (String)eu.nextElement();
			System.out.println(s+":"+request.getParameter(s));
		}
		String oper = request.getParameter("oper");
		String id =request.getParameter("id");
		String url = request.getParameter("url");
		String city = request.getParameter("city");
		String parser = request.getParameter("parser");
		String from = request.getParameter("from");
		if("edit".equals(oper)){
			SpliderItem item = spliderService.getSpliderItem(Integer.parseInt(id));
			item.setCityId(Integer.parseInt(city));
			item.setUrl(url);
			item.setParserName(parser);
			item.setFromId(Integer.parseInt(from));
			spliderService.editSpliderItem(item);
		}else{
			SpliderItem item = new SpliderItem();
			item.setCityId(Integer.parseInt(city));
			item.setUrl(url);
			item.setParserName(parser);
			item.setFromId(Integer.parseInt(from));
			spliderService.addSpliderItem(item);
		}
		response.setContentType(AjaxServlet.JSON_CONTENT_TYPE);
		PrintWriter out = response.getWriter();		
		out.println("");	
		out.flush();
		
	}
}
