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

import org.apache.commons.lang.StringUtils;

import com.hunthawk.framework.hibernate.CompareExpression;
import com.hunthawk.framework.hibernate.CompareType;
import com.hunthawk.framework.hibernate.HibernateExpression;
import com.tuan.domain.Article;
import com.tuan.service.SpliderService;
import com.tuan.web.framework.ajax.BaseAction;

public class GetArticleDiscountListAction extends BaseAction{
	
	private SpliderService spliderService;

	public void setSpliderService(SpliderService spliderService) {
		this.spliderService = spliderService;
	}

	@Override
	public String getTemplatePath() {
		return "ArticleDiscountList.html";
	}
	
	@Override
	public Map<String, Object> action(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer cid = 1;
		String cityId = request.getParameter("cityid");
		if(StringUtils.isNotEmpty(cityId)){
			cid = Integer.parseInt(cityId); 
		}else{
			cid = getCityId(request);
		}
		List<Object> values = new ArrayList<Object>();
		String hql = "from Article where endTime >= ? and cityId=? order by  cast(saveMoney as integer) desc";
		values.add(new Date());
		values.add(cid);
		List<Article> newList = spliderService.getArticleListByHql(hql, values
				.toArray(), 1, 10);
		
		Map<String, Object> map = new HashMap<String,Object>(); 
		map.put("newList", newList);
	
		return map;
	}
}
