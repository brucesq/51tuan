package com.tuan.web.action;

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

public class GetArticleListAction extends BaseAction {
	
	private SpliderService spliderService;

	public void setSpliderService(SpliderService spliderService) {
		this.spliderService = spliderService;
	}

	@Override
	public String getTemplatePath() {
		return "ArticleList.html";
	}

	@Override
	public Map<String, Object> action(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Article> newList = spliderService.getArticleList(1,6,"id",false,new ArrayList());
		List<Article> recommendedList = spliderService.getArticleList(1,3,"id",false,new ArrayList());
		Map<String, Object> map = new HashMap<String,Object>(); 
		map.put("newList", newList);
		map.put("recommendedList", recommendedList);
		return map;
	}
}
