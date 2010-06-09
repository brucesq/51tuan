/**
 * 
 */
package com.tuan.service;

import java.util.List;

import com.tuan.domain.Article;
import com.tuan.domain.SpliderItem;

/**
 * @author sunquanzhi
 *
 */
public interface SpliderService {

	public List<SpliderItem> getSpliderItems();
	
	public void addArticle(Article article);
}
