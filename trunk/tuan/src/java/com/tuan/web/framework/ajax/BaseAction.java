/**
 * 
 */
package com.tuan.web.framework.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuan.util.StringUtil;
import com.tuan.util.TemplateUtil;

/**
 * BaseCommand class providing some base methods.
 * 
 * @author BruceSun
 * 
 */
public abstract class BaseAction implements AjaxAction {

	private TemplateUtil templateUtil;

	/**
	 * Command template file path.
	 * 
	 * @return
	 */
	public abstract String getTemplatePath();

	/**
	 * Command execute action.
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public abstract Map<String, Object> action(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException;

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
		Map<String, Object> map = action(request, response);
		map.put("json", new StringUtil());
		String content = getTemplateUtil()
				.parseTemplate(getTemplatePath(), map);
		response.setContentType(AjaxServlet.JSON_CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println(content);
		out.flush();
		// System.out.println(content);
	}

	public static Integer getCityId(HttpServletRequest req) {
		Cookie authCookie = null;
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			int len = cookies.length;
			for (int i = 0; i < len; i++) {
				if (COOKIE_BANCKLE_CITY.equals(cookies[i].getName())) {
					// found cookie
					authCookie = cookies[i];
					break;
				}
			}
		}
		if (authCookie != null) {
			try {
				return Integer.parseInt(authCookie.getValue());
			} catch (Exception e) {

			}
		}
		return 1;

	}

	public static void changeCityId(HttpServletRequest req,HttpServletResponse res, Integer cid) {
		Cookie cityCookie = new Cookie(COOKIE_BANCKLE_CITY, cid.toString());
		cityCookie.setPath(req.getContextPath());
		cityCookie.setMaxAge(7 * 24 * 60 * 60);
		res.addCookie(cityCookie);
	}

	public static final String COOKIE_BANCKLE_CITY = "tuan_100_cid";
}
