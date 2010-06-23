/**
 * 
 */
package com.tuan.web.action.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hunthawk.reader.enhance.util.ToolDateUtil;
import com.tuan.domain.Article;
import com.tuan.service.SpliderService;
import com.tuan.web.framework.ajax.AjaxAction;
import com.tuan.web.framework.ajax.AjaxServlet;

/**
 * @author sunquanzhi
 *
 */
public class EditArticleItemAction  implements AjaxAction{

	private SpliderService spliderService;

	public void setSpliderService(SpliderService spliderService) {
		this.spliderService = spliderService;
	}   
	
	public void execute(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
//		Enumeration eu =  request.getParameterNames();
//		while(eu.hasMoreElements()){	
//			String s = (String)eu.nextElement();
//			System.out.println(s+":"+request.getParameter(s));
//		}
		String oper = request.getParameter("oper");
		String id =request.getParameter("id");
		String url = request.getParameter("url");
		String city = request.getParameter("city");
		String parser = request.getParameter("parser");
		String from = request.getParameter("from");
		String time = request.getParameter("time");
		String nowPrice = request.getParameter("nowPrice");
		
		String originalPrice = request.getParameter("originalPrice");
		String discount = request.getParameter("discount");
		String saveMoney = request.getParameter("saveMoney");
		String imgurl = request.getParameter("imgurl");
		
		if("edit".equals(oper)){
			Article item = spliderService.getArticle(Integer.parseInt(id));
			item.setCityId(Integer.parseInt(city));
			item.setUrl(url);
			item.setName(parser);
			item.setFromId(Integer.parseInt(from));
			item.setEndTime(ToolDateUtil.stringToDate(time));
			item.setNowPrice(nowPrice);
			item.setOriginalPrice(originalPrice);
			item.setDiscount(discount);
			item.setSaveMoney(saveMoney);
			item.setImgurl(imgurl);
			spliderService.editArticle(item);
		}else{
			Article item = new Article();
			item.setCityId(Integer.parseInt(city));
			item.setUrl(url);
			item.setName(parser);
			item.setFromId(Integer.parseInt(from));
			item.setEndTime(ToolDateUtil.stringToDate(time));
			item.setNowPrice(nowPrice);
			item.setOriginalPrice(originalPrice);
			item.setDiscount(discount);
			item.setSaveMoney(saveMoney);
			item.setImgurl(imgurl);
			spliderService.addArticle(item);
		}
		response.setContentType(AjaxServlet.JSON_CONTENT_TYPE);
		PrintWriter out = response.getWriter();		
		out.println("");	
		out.flush();
		
	}
}
