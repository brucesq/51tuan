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
public class Juan24Parser implements ArticleParser {
	
	public static Map<Integer,Integer> cityMap = new HashMap<Integer,Integer>();
	static{
		cityMap.put(1, 1);
		cityMap.put(7, 2);
		cityMap.put(3, 14);
		cityMap.put(10, 30);
	}

	public Article parse(String htmlurl, Integer cityId, Integer fromId)
			throws Exception {
		
		URL url = new URL("http://www.24quan.com/index.php");
		URLConnection urlcon = url.openConnection();
		urlcon.setConnectTimeout(10000);
		urlcon.setReadTimeout(10000);
		urlcon.setDoOutput(true);
		HttpURLConnection httpConn = (HttpURLConnection) urlcon;
		httpConn.setInstanceFollowRedirects(false);
		httpConn.addRequestProperty("Cookie", "9f4d_city="+cityMap.get(cityId)+";");  
		httpConn.setRequestProperty("user-agent",
			"Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
		
		
		InputStream in = null;
		in = httpConn.getInputStream();
		String content = IoUtils.pipe(in, "utf-8");

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
		int index = content.indexOf("id=\"deal-title\"");
		if (index > 0) {
			content = content.substring(index + 17);
			index = content.indexOf(">");

			if (index >= 0) {
				content = content.substring(index + 1);

				index = content.indexOf("</a>");
				String title = content.substring(0, index);
//				System.out.println(title);
				article.setName(title);
			}

		}
		index = content.indexOf("class=\"deal-price\"");
		if (index > 0) {
			content = content.substring(index + 19);

			index = content.indexOf("<strong>");
			if (index >= 0) {
				content = content.substring(index + 8);
				index = content.indexOf("</strong>");
				String nowPrice = content.substring(0, index);
				content = content.substring(index + 9);
				nowPrice = getPrice(nowPrice);
//				System.out.println(nowPrice);
				article.setNowPrice(nowPrice);
				index = content.indexOf("class=\"deal-discount\"");
				if (index > 0) {
					content = content.substring(index + 15);
					index = content.indexOf("</tr>");
					content = content.substring(index + 5);
					index = content.indexOf("<td>");
					if (index > 0) {
						content = content.substring(index + 4);
						index = content.indexOf("</td>");
						String oldPrice = content.substring(0, index);
						oldPrice = getPrice(oldPrice);
//						System.out.println(oldPrice);
						article.setOriginalPrice(oldPrice);

					}
					index = content.indexOf("<td>");
					if (index >= 0) {
						content = content.substring(index + 4);
						index = content.indexOf("</td>");
						String discount = content.substring(0, index);
//						System.out.println(discount);
						article.setDiscount(discount);

					}
					index = content.indexOf("<td>");

					if (index >= 0) {
						content = content.substring(index + 4);
						index = content.indexOf("</td>");
						String saveMoney = content.substring(0, index);
						saveMoney = getPrice(saveMoney);
//						System.out.println(saveMoney);
						article.setSaveMoney(saveMoney);

					}
					index = content.indexOf("class=\"deal-buy-cover-img\"");
					if (index >= 0) {
						content = content.substring(index + 13);
						index = content.indexOf("src=\"");
						content = content.substring(index + 5);
						index = content.indexOf("\"");
						String url = content.substring(0, index);
//						System.out.println(url);
						article.setImgurl(url);
					}
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

		Juan24Parser p = new Juan24Parser();
		p.parse("http://www.24quan.com/index.php", 10, 1);

		// String content = "<div id=\"content\">"
		// + " <div class=\"box-top\"></div>"
		// + " <div id=\"deal-intro\" class=\"cf\" style=\"cursor:pointer;\"
		// onclick=\"window.location.href='/team/buy.php?id=155';\">"
		// + " <h1><a class=\"deal-today-link\"
		// href=\"/team.php?id=155\">今日团购：</a><a id=\"deal-title\"
		// href=\"/team/buy.php?id=155\"
		// >仅130元！原价620元圣心SPA会所女子舍宾形体训练10次卡（含运动后清爽沐浴一次），为您雕塑完美曲线</a></h1>"
		// + " <div class=\"main\">"
		// + " <div class=\"deal-buy\">"
		// + ""
		// + " <div class=\"deal-price-tag\"></div>"
		// + " <p class=\"deal-price\"><strong>￥130</strong><span><a
		// href=\"/team/buy.php?id=155\"><img
		// src=\"/static/css/i/button-deal-buy.gif\" /></a></span></p>"
		// + " </div>"
		// + " <table class=\"deal-discount\">"
		// + " <tr>"
		// + " <th>原价</th>"
		// + " <th>折扣</th>"
		// + ""
		// + " <th>节省</th>"
		// + " </tr>"
		// + " <tr>"
		// + " <td>￥620</td>"
		// + " <td>2.1折</td>"
		// + " <td>￥490</td>"
		// + " </tr>"
		// + ""
		// + " </table>"
		// + " <div class=\"deal-box deal-timeleft deal-on\"
		// id=\"deal-timeleft\" curtime=\"1276400969000\" diff=\"303031000\">"
		// + " <h3>剩余时间</h3>"
		// + " <div class=\"limitdate\"><ul
		// id=\"counter\"><li><span>12</span>小时</li><li><span>10</span>分钟</li><li><span>31</span>秒</li></ul></div>"
		// + " </div>"
		// + ""
		// + " "
		// + " <div class=\"deal-box deal-status deal-status-open\"
		// id=\"deal-status\">"
		// + " <p class=\"deal-buy-tip-top\"><strong id=\"pay_num\">162</strong>
		// 人已购买</p>"
		// + " <p class=\"deal-buy-tip-notice\">数量有限，下单要快哟</p>"
		// + " <p class=\"deal-buy-on\">团购已成功,<br/>可继续购买…</p>"
		// + " <p class=\"deal-buy-tip-btm\">09:15分达到最低团购人数：<strong>10</strong>
		// 人</p> </div>"
		// + ""
		// + " </div>"
		// + " <div class=\"side\">"
		// + " <div class=\"deal-buy-cover-img\" id=\"team_images\">"
		// + " <img
		// src=\"http://www.24quan.com/static/team/2010/0610/12761431866723.jpg\"/>"
		// + " </div>"
		// + " <div class=\"digest\"><p><span
		// style=\"font-family:Arial;\">外塑形美，内修神美，舍宾还女性内外兼修的美丽</span></p><p>&nbsp;</p></div>"
		// + " </div>" + " </div>" + ""
		// + " <div class=\"box-bottom\"></div>"
		// + " <div id=\"deal-stuff\" class=\"cf\">";
		//
		// Article article = new Article();
		// parserContent(content, article);

	}
}
