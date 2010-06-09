/**
 * 
 */
package com.tuan.splider;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.tuan.domain.Article;
import com.tuan.domain.SpliderItem;
import com.tuan.service.SpliderService;

/**
 * @author sunquanzhi
 * 
 */
public class SpliderJob implements ApplicationContextAware {

	private static ApplicationContext ac;

	public static void setSpringContext(ApplicationContext ac){
		SpliderJob.ac = ac;
	}
	public void setApplicationContext(ApplicationContext ac)
			throws BeansException {
		SpliderJob.ac = ac;
	}
	public static ApplicationContext getApplicationContext() {
		return ac;
	}
	
	private SpliderService spliderService;
	
	public void setSpliderService(SpliderService spliderService){
		this.spliderService = spliderService;
	}
	
	public void doJob(){
		List<SpliderItem> items = spliderService.getSpliderItems();
		for(SpliderItem item : items){
			ArticleParser parser = (ArticleParser)ac.getBean(item.getParserName());
			try{
				Article article = parser.parse(item.getUrl(), item.getCityId(), item.getFromId());
				spliderService.addArticle(article);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
