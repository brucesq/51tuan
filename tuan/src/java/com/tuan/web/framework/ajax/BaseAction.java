/**
 * 
 */
package com.tuan.web.framework.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuan.util.StringUtil;
import com.tuan.util.TemplateUtil;

/**
 * BaseCommand class providing some base methods.
 * @author BruceSun
 *
 */
public abstract class BaseAction implements AjaxAction {

	private TemplateUtil templateUtil ;
	/**
	 * Command template file path.
	 * @return
	 */
	public abstract String getTemplatePath();
	/**
	 * Command execute action. 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public abstract Map<String,Object> action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException ;

	public TemplateUtil getTemplateUtil() {
		return templateUtil;
	}

	public void setTemplateUtil(TemplateUtil templateUtil) {
		this.templateUtil = templateUtil;
	}
	/**
	 * Common process.
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Map<String,Object> map = action(request,response);
		map.put("json", new StringUtil());
		String content = getTemplateUtil().parseTemplate(getTemplatePath(), map);
		response.setContentType(AjaxServlet.JSON_CONTENT_TYPE);
		PrintWriter out = response.getWriter();		
		out.println(content);	
		out.flush();
		System.out.println(content);
	}
}
