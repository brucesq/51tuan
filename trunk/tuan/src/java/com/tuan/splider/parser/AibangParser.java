/**
 * 
 */
package com.tuan.splider.parser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import com.hunthawk.reader.enhance.util.ToolDateUtil;
import com.tuan.domain.Article;
import com.tuan.splider.ArticleParser;
import com.tuan.util.IoUtils;

/**
 * @author sunquanzhi
 * 
 */
public class AibangParser implements ArticleParser {
	public static Map<Integer,String> cityMap = new HashMap<Integer,String>();
	static{
		cityMap.put(1, "%E5%8C%97%E4%BA%AC");
	}

	public Article parse(String htmlurl, Integer cityId, Integer fromId)
			throws Exception {

		URL url = new URL("http://tuan.aibang.com/tuancity");
		URLConnection urlcon = url.openConnection();
		urlcon.setConnectTimeout(10000);
		urlcon.setReadTimeout(10000);
		urlcon.setDoOutput(true);
		HttpURLConnection httpConn = (HttpURLConnection) urlcon;
		httpConn.setInstanceFollowRedirects(false);
		httpConn.addRequestProperty("Cookie", "city="+cityMap.get(cityId)+";mid=9;");
		httpConn.setRequestProperty("user-agent",
				"Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
		InputStream in = null;
		in = httpConn.getInputStream();
		String content = IoUtils.pipe(in, "utf-8");

//		System.out.println(content);
		String key = "";
		String cookie = "";
		for (int i = 1; (key = httpConn.getHeaderFieldKey(i)) != null; i++) {
//			System.out.println(key);
			if ("set-cookie".equalsIgnoreCase(key)) {
				String cookieVal = httpConn.getHeaderField(i);
				cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));
				cookie = cookie + cookieVal + ";";
			}
		}
//		System.out.println(cookie);
		
		Article article = new Article();
		article.setUrl(htmlurl);
		article.setCategoryId(1);
		article.setCityId(cityId);

		Date date = new Date();
		date = DateUtils.addDays(date, 1);
		String strDate = ToolDateUtil.dateToString(date, "yyyyMMdd");
		date = ToolDateUtil.stringToDate(strDate, "yyyyMMdd");

		article.setEndTime(date);
		article.setFromId(fromId);
		parserContent(content, article);
		return article;
	}

	public static void parserContent(String content, Article article) {
		int index = content.indexOf("class=\"at_jrat\"");
		if (index > 0) {
			content = content.substring(index + 15);
			index = content.indexOf("<h1>");

			if (index >= 0) {
				content = content.substring(index + 4);

				index = content.indexOf("</h1>");
				String title = content.substring(0, index);
//				System.out.println(title);
				article.setName(title);
			}

		}
		index = content.indexOf("class=\"at_zk\"");
		if (index > 0) {
			content = content.substring(index + 13);
			index = content.indexOf(">");
			if (index >= 0) {
				content = content.substring(index + 1);
				index = content.indexOf("</div>");
				String discount = content.substring(0, index);
//				System.out.println(discount);
				article.setDiscount(discount);
				content = content.substring(index + 6);

				index = content.indexOf(">");
				if (index >= 0) {
					content = content.substring(index + 1);
					index = content.indexOf("</strong>");
					String oldPrice = content.substring(0, index);
					oldPrice = getPrice(oldPrice);
//					System.out.println(oldPrice);
					article.setOriginalPrice(oldPrice);
					content = content.substring(index + 9);
				}
				index = content.indexOf("<br/>");
				if (index >= 0) {
					content = content.substring(index + 5);
					index = content.indexOf("<div");
					String saveMoney = content.substring(0, index);
					saveMoney = getPrice(saveMoney);
//					System.out.println(saveMoney);
					article.setSaveMoney(saveMoney);
					content = content.substring(index + 4);
				}
				index = content.indexOf(">");
				if (index >= 0) {
					content = content.substring(index + 1);
					index = content.indexOf("<");
					String nowPrice = content.substring(0, index);
					nowPrice = getPrice(nowPrice);
//					System.out.println(nowPrice);
					article.setNowPrice(nowPrice);
				}

				index = content.indexOf("class=\"t_deal_r\"");
				if (index >= 0) {
					content = content.substring(index + 16);
					index = content.indexOf("src=\"");
					content = content.substring(index + 5);
					index = content.indexOf("\"");
					String url = content.substring(0, index);
//					 System.out.println(url);
					article.setImgurl(url);
				}
			}
		}

	}

	private static String getPrice(String str) {
		int index = str.indexOf("￥");
		if (index >= 0) {
			str = str.substring(index + 1);
			String price = "";
			for (int i = 0; i < str.length(); i++) {
				if (StringUtils.isNumeric("" + str.charAt(i))) {
					price += str.charAt(i);
				} else {
					continue;
				}
			}
			str = price;
		}
		return str;
	}

	public static void main(String[] args) throws Exception {
		AibangParser p = new AibangParser();
		p.parse("http://tuan.aibang.com/tuancity", 1, 5);
	}
}
