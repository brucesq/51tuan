/**
 * 
 */
package com.tuan.web.action.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuan.domain.Article;
import com.tuan.service.SpliderService;
import com.tuan.web.framework.ajax.BaseAction;

/**
 * @author sunquanzhi
 *
 */
public class GetAdminArticlesAction  extends BaseAction {
	
	private SpliderService spliderService;

	public void setSpliderService(SpliderService spliderService) {
		this.spliderService = spliderService;
	}   

	@Override
	public String getTemplatePath() {
		return "admin/GetAdminArticlesAction.json"; 
	}

	@Override
	public Map<String, Object> action(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		List<Article> list = spliderService.getArticleList(page,50,"id",false,new ArrayList());
		int totalPage = spliderService.getArticleListCount(new ArrayList()).intValue()/50 +1;
		Map<String, Object> map = new HashMap<String,Object>(); 
		map.put("list", list);
		map.put("currentPage",page);
		map.put("totalPage",totalPage);
		map.put("records",list.size());
		return map;
	}
}
