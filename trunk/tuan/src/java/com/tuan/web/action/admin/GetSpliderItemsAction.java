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

import com.tuan.domain.SpliderItem;
import com.tuan.service.SpliderService;
import com.tuan.web.framework.ajax.BaseAction;

/**
 * @author sunquanzhi
 *
 */
public class GetSpliderItemsAction  extends BaseAction {
	
	private SpliderService spliderService;

	public void setSpliderService(SpliderService spliderService) {
		this.spliderService = spliderService;
	}   

	@Override
	public String getTemplatePath() {
		return "admin/GetSpliderItemsAction.json"; 
	}

	@Override
	public Map<String, Object> action(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
//		System.out.println("PAGE="+page);
//		Enumeration eu =  request.getParameterNames();
//		while(eu.hasMoreElements()){	
//			String s = (String)eu.nextElement();
//			System.out.println(s+":"+request.getParameter(s));
//		}
		List<SpliderItem> list = spliderService.getSpliderItem(page,50,"id",false,new ArrayList());
		int totalPage = spliderService.getSpliderItemCount(new ArrayList()).intValue()/50 +1;
		Map<String, Object> map = new HashMap<String,Object>(); 
		map.put("list", list);
		map.put("currentPage",page);
		map.put("totalPage",totalPage);
		map.put("records",list.size());
		return map;
	}
}
