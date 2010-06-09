/**
 * 
 */
package com.tuan.service.impl;

import java.util.List;

import com.hunthawk.framework.HibernateGenericController;
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
}
