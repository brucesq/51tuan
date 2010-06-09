/**
 * 
 */
package com.tuan.splider;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.tuan.domain.Article;
import com.tuan.util.IoUtils;

/**
 * @author sunquanzhi
 * 
 */
public class LashouParser implements ArticleParser{

	public Article parse(String htmlurl, Integer cityId,Integer fromId) throws Exception {

		URL url = new URL(htmlurl);
		URLConnection urlcon = url.openConnection();
		urlcon.setConnectTimeout(10000);
		urlcon.setReadTimeout(10000);
		urlcon.setDoOutput(true);
		InputStream in = null;
		in = url.openStream();
		String content = IoUtils.pipe(in, "utf-8");
		
		Article article = new Article();
		article.setUrl(htmlurl);
		article.setCategoryId(1);
		article.setCityId(cityId);
		article.setEndTime(new Date());
		article.setFromId(fromId);
		parserContent(content,article);
		return article;
	}
	
	public static void parserContent(String content,Article article){
		int index = content.indexOf("class=\"mid\"");
		article.setEndTime(new Date());
		if(index > 0 ){
			content = content.substring(index+12);
			index = content.indexOf("<h1>");
			if(index >= 0){
				content = content.substring(index+4);
				index = content.indexOf("</h1>");
				String title  = content.substring(0,index);
				System.out.println(title);
				article.setName(title);
			}
				
		}
		index = content.indexOf("class=\"buy\"");
		if(index > 0 ){
			content = content.substring(index+12);
			index = content.indexOf(">");
			if(index > 0){
				content = content.substring(index+1);
				index = content.indexOf("</div>");
				String nowPrice  = content.substring(0,index);
				content = content.substring(index+6);
				nowPrice = getPrice(nowPrice);
				System.out.println(nowPrice);
				article.setNowPrice(nowPrice);
				index = content.indexOf("class=\"shuzi\"");
				if(index > 0){
					content = content.substring(index+13);
					index = content.indexOf("<h4");
					content = content.substring(index+3);
					index = content.indexOf(">");
					if(index > 0){
						content = content.substring(index+1);
						index = content.indexOf("</h4>");
						String oldPrice  = content.substring(0,index);
						oldPrice = getPrice(oldPrice);
						System.out.println(oldPrice);
						article.setOriginalPrice(oldPrice);
						
					}
					index = content.indexOf("<h3");
					content = content.substring(index+3);
					index = content.indexOf(">");
					if(index >= 0){
						content = content.substring(index+1);
						index = content.indexOf("</h3>");
						String discount  = content.substring(0,index);
						System.out.println(discount);
						article.setDiscount(discount);
						
					}
					index = content.indexOf("<h3");
					content = content.substring(index+3);
					index = content.indexOf(">");
					if(index >= 0){
						content = content.substring(index+1);
						index = content.indexOf("</h3>");
						String saveMoney  = content.substring(0,index);
						saveMoney = getPrice(saveMoney);
						System.out.println(saveMoney);
						article.setSaveMoney(saveMoney);
						
					}
					index = content.indexOf("class=\"image\"");
					if(index >= 0){
						content = content.substring(index+13);
						index = content.indexOf("src=\"");
						content = content.substring(index+5);
						index= content.indexOf("\"");
						String url = content.substring(0,index);
						System.out.println(url);
						article.setImgurl(url);
					}
				}
			}
		}
	}
	
	private static String getPrice(String str){
		int index = str.indexOf("￥");
		if(index >= 0){
			str = str.substring(index+1);
			String price = "";
			for(int i=0;i<str.length();i++){
				if(StringUtils.isNumeric(""+str.charAt(i))){
					price += str.charAt(i);
				}else{
					break;
				}
			}
			str = price;
		}
		return str;
	}
	
	public static void main(String[] args){
		String content = "<div class=\"mid\">"+
		 " <h1>今日团购: 仅售49元！原价188元的“玛雅蛋糕DIY教室”制作九颗装造型巧克力礼盒一盒</h1>"+
		 " <div class=\"dealinfo\">"+
		 "   <div class=\"l deal_l\">"+
		"	  <div class=\"buybox\">"+
			" <div class=\"buy\">"+

		 " <div class=\"l price\" style=\"text-align:center;font-size:30px;\">"+
		  	"			  ￥49				  				  </div>"+
		  	"																				<a href=\"buy.php?id=307\"><div class=\"r btn_buy\"></div></a>"+
								"							  					</div>"+
		"<div class=\"shuzi\">"+
		" <ul>"+
	    "<li>原价<br /><h4 title=\"188.00\">￥188</h4></li>"+

	    "<li>折扣<br /><h3>2.6折</h3></li>"+
		"<li class=\"red\">节省<br /><h3>￥139</h3></li>"+
	 " </ul>"+
	"</div>"+
	"<div class=\"r deal_r\">"+
	"  <div class=\"image\">"+
	 " <img src=\"http://img.lashou.com/lasho_pic/go/00/00/00/03/307\" />"
;

		
//		parserContent(content);

	}
}
