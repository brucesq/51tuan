/* 
 * GetArticleRandomAction.java
 * 
 * Created on 2010-7-6
 * 
 * Copyright(C) 2010, by Ambow Develop & Research Branch.
 * 
 * Original Author: liujia
 * Contributor(s):
 * 
 * Changes 
 * -------
 * $Log$
 */
package com.tuan.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuan.domain.Article;
import com.tuan.service.SpliderService;
import com.tuan.web.framework.ajax.BaseAction;

public class GetArticleRandomAction extends BaseAction {
	private SpliderService spliderService;

	public void setSpliderService(SpliderService spliderService) {
		this.spliderService = spliderService;
	}

	@Override
	public String getTemplatePath() {
		return "ArticleRandom.html";
	}

	@Override
	public Map<String, Object> action(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Object> values = new ArrayList<Object>();
		String hql = "from Article where endTime >= ? and cityId=? order by rand()";
		values.add(new Date());
		values.add(0);
		List<Article> newList = spliderService.getArticleListByHql(hql, values
				.toArray(), 1, 1);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("newList", newList);

		return map;
	}
}
