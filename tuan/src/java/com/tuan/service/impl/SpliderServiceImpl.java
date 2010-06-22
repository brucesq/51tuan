/**
 * 
 */
package com.tuan.service.impl;

import java.util.Collection;
import java.util.List;

import com.hunthawk.framework.HibernateGenericController;
import com.hunthawk.framework.hibernate.HibernateExpression;
import com.tuan.domain.Article;
import com.tuan.domain.SpliderItem;
import com.tuan.service.SpliderService;

/**
 * @author sunquanzhi
 * 
 */
public class SpliderServiceImpl implements SpliderService {

	private HibernateGenericController controller;

	public void setHibernateGenericController(
			HibernateGenericController controller) {
		this.controller = controller;
	}

	public List<SpliderItem> getSpliderItems() {
		return controller.getAll(SpliderItem.class);
	}

	public void addArticle(Article article) {
		controller.save(article);
	}

	public List<Article> getArticleList(int pageNo, int pageSize,
			String orderBy, boolean isAsc,
			Collection<HibernateExpression> expressions) {
		return controller.findBy(Article.class, pageNo, pageSize, orderBy,
				isAsc, expressions);
	}
	
	public Long getArticleListCount(Collection<HibernateExpression> expressions){
		return controller.getResultCount(Article.class, expressions);
	}

	public SpliderItem getSpliderItem(Integer id) {
		return controller.get(SpliderItem.class, id);
	}

	public void addSpliderItem(SpliderItem item) {
		controller.save(item);
	}

	public void editSpliderItem(SpliderItem item) {
		controller.update(item);
	}
	
	public List<SpliderItem> getSpliderItem(int pageNo, int pageSize,
			String orderBy, boolean isAsc,
			Collection<HibernateExpression> expressions){
		return controller.findBy(SpliderItem.class, pageNo, pageSize, orderBy,
				isAsc, expressions);
	}
	
	public Long getSpliderItemCount(Collection<HibernateExpression> expressions){
		return controller.getResultCount(SpliderItem.class, expressions);
	}
}
