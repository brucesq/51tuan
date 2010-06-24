/**
 * 
 */
package com.tuan.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuan.domain.Article;
import com.tuan.service.SpliderService;
import com.tuan.web.framework.ajax.AjaxAction;
import com.tuan.web.framework.ajax.AjaxServlet;

/**
 * @author sunquanzhi
 *
 */
public class AddVisitAction  implements AjaxAction{

	private SpliderService spliderService;

	public void setSpliderService(SpliderService spliderService) {
		this.spliderService = spliderService;
	}   
	
	public void execute(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{

		String id =request.getParameter("id");
		Article item = spliderService.getArticle(Integer.parseInt(id));
		if(item.getOlderNum() == null){
			item.setOlderNum(1);
		}else{
			item.setOlderNum(item.getOlderNum()+1);
		}
		spliderService.editArticle(item);
		response.setContentType(AjaxServlet.JSON_CONTENT_TYPE);
		PrintWriter out = response.getWriter();		
		out.println("");	
		out.flush(); 
		
	}
}