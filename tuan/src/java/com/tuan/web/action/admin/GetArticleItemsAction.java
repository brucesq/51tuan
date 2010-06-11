/**
 * 
 */
package com.tuan.web.action.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuan.domain.SpliderItem;
import com.tuan.service.SpliderService;
import com.tuan.web.framework.ajax.BaseAction;

/**
 * @author sunquanzhi
 *
 */
public class GetArticleItemsAction  extends BaseAction {
	
	private SpliderService spliderService;

	public void setSpliderService(SpliderService spliderService) {
		this.spliderService = spliderService;
	}   

	@Override
	public String getTemplatePath() {
		return "GetArticleItemsAction.xml"; 
	}

	@Override
	public Map<String, Object> action(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("q"));
		System.out.println("PAGE="+page);
		List<SpliderItem> list = spliderService.getSpliderItems();
		Map<String, Object> map = new HashMap<String,Object>(); 
		map.put("list", list);
		map.put("currentPage",page);
		map.put("totalPage",1);
		map.put("records",list.size());
		return map;
	}
}
