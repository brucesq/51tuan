/**
 * 
 */
package com.tuan.splider.parser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

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
public class ManzuoParser implements ArticleParser {

	public Article parse(String htmlurl, Integer cityId, Integer fromId)
			throws Exception {

		URL url = new URL(htmlurl);
		URLConnection urlcon = url.openConnection();
		urlcon.setConnectTimeout(10000);
		urlcon.setReadTimeout(10000);
		urlcon.setDoOutput(true);
		HttpURLConnection httpConn = (HttpURLConnection) urlcon;
		httpConn.setInstanceFollowRedirects(false);
		httpConn.setRequestProperty("user-agent",
			"Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
		InputStream in = null;
		in = httpConn.getInputStream();
		String content = IoUtils.pipe(in, "utf-8");

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
		int index = content.indexOf("class=\"con_title\"");
		if (index > 0) {
			content = content.substring(index + 17);
			index = content.indexOf("</span>");
			
			if (index >= 0) {
				content = content.substring(index + 7);
			
				index = content.indexOf("</h2>");
				String title = content.substring(0, index);
//				 System.out.println(title);
				article.setName(title);
			}

		}
		index = content.indexOf("class=\"new_con_buy_01\"");
		if (index > 0) {
			content = content.substring(index + 22);
			index = content.indexOf("<span>");
			if (index > 0) {
				content = content.substring(index + 6);
				index = content.indexOf("</span>");
				String nowPrice = content.substring(0, index);
				content = content.substring(index + 9);
//				nowPrice = getPrice(nowPrice);
//				System.out.println(nowPrice);
				article.setNowPrice(nowPrice);
				index = content.indexOf("class=\"new_con_06\"");
				if (index > 0) {
					content = content.substring(index + 17);
					index = content.indexOf("<b>");
//					content = content.substring(index + 3);
//					index = content.indexOf("<td>");
					if (index > 0) {
						content = content.substring(index + 3);
						index = content.indexOf("</b>");
						String oldPrice = content.substring(0, index);
//						oldPrice = getPrice(oldPrice);
//						 System.out.println(oldPrice);
						article.setOriginalPrice(oldPrice);

					}
					index = content.indexOf("<td>");
					if (index >= 0) {
						content = content.substring(index + 4);
						index = content.indexOf("</td>");
						String discount = content.substring(0, index);
//						 System.out.println(discount);
						article.setDiscount(discount);

					}
					index = content.indexOf("<td>");

					if (index >= 0) {
						content = content.substring(index + 4);
						index = content.indexOf("</td>");
						String saveMoney = content.substring(0, index);
						saveMoney = getPrice(saveMoney);
//						 System.out.println(saveMoney);
						article.setSaveMoney(saveMoney);

					}
					index = content.indexOf("class=\"con_05 flo_le\"");
					if (index >= 0) {
						content = content.substring(index + 21);
						index = content.indexOf("src=\"");
						content = content.substring(index + 5);
						index = content.indexOf("\"");
						String url = content.substring(0, index);
//						 System.out.println(url);
						article.setImgurl( url);
					}
				}
			}
		}
	}

	private static String getPrice(String str) {
//		int index = str.indexOf("¥");
//		if (index >= 0) {
//			str = str.substring(index + 1);
			String price = "";
			for (int i = 0; i < str.length(); i++) {
				if (StringUtils.isNumeric("" + str.charAt(i))) {
					price += str.charAt(i);
				} else {
					continue;
				}
			}
			str = price;
//		}
		return str;
	}

	public static void main(String[] args) {

		String content = 
			"<div class=\"new_shade\"></div>"+
			"        <div class=\"con_02\">"+
			""+
			"          <h2 class=\"con_title\"><span>当日精选</span> 超低价40元！立享原价125元东篱文艺沙龙DIY陶艺粘土5件套！</h2>"+
			"            <div class=\"con_04 flo_le\">"+
			"              <div class=\"new_con_buy pngFix\">"+
			"                  <div class=\"new_con_buy_01\">"+
			"                      <span>40</span>元"+
			"                    </div>"+
			"                    "+
			"                    <span class=\"dis new_con_buy_02\" onclick=\"javascript:startDeal(false);\"></span>"+
			""+
			"                    "+
			"                </div>"+
			"                <div class=\"new_con_06\">"+
			"                  <table cellspacing=\"0\" cellpadding=\"0\">"+
			"                      <tr>"+
			"                        <th>原价</th><th>折扣</th><th>节省金额</th>"+
			"                      </tr>"+
			"                      <tr>"+
			""+
			"                        <td><b>125</b>元</td><td>3.2折</td><td>85元</td>"+
			"                      </tr>"+
			"                  </table>"+
			"            <span class=\"new_con_07 dis\">"+
			"              "+
			"            <input class=\"new_for_buybut\" type=\"button\" onclick=\"javascript:startDeal(true);\"/>"+
			"              "+
			"              "+
			"            </span>"+
			"              </div>"+
			""+
			"              <!-- 剩余时间 -->"+
			"              "+
			"              <div class=\"con_08\">"+
			"                  <h3>本次活动剩余时间</h3>"+
			"                  <div style=\"float:left; margin:-15px 0 0 6px;\">"+
			"                <div id=\"TimeCounter_0\" class=\"day_num\">"+
			"                    <ul>"+
			"                      <li><font><span id=\"TimeCounter_0_d\"></span></font> 天</li>"+
			""+
			"                        <li><font><span id=\"TimeCounter_0_h\"></span></font> 小时</li>"+
			"                        <li><font><span id=\"TimeCounter_0_m\"></span></font> 分钟 <font><span id=\"TimeCounter_0_s\"></span></font> 秒</li>"+
			"                    </ul>"+
			"                </div>"+
			"<script language=\"javascript\">"+
			"            //target[target.length]=new Date(2010,00,04,0,0,0).getTime();"+
			"            var displayStyle = \"split\";"+
			"            "+
			"            var sourceStr = '2010-06-16 23:59:59.0';"+
			"            "+
			"            "+
			"            var dateStr = sourceStr.split(\" \")[0];"+
			"            target[target.length] = new Date(dateStr.split(\"-\")[0],parseInt(dateStr.split(\"-\")[1])-1,dateStr.split(\"-\")[2],23,59,59).getTime();"+
			"            time_id[time_id.length]=\"TimeCounter_0\""+
			"          </script>"+
			""+
			"              </div>"+
			"                  <div id=\"ldImg\" style=\"float:left; margin-left:5px; margin-top:8px; display:inline;\">"+
			"                      <img src=\"http://www.manzuo.com/html/images/l1.gif\"/>"+
			"                  </div>"+
			"              </div>"+
			"              <div class=\"con_09\">"+
			"                  <h3><b style=\"color:#ff390b;font-size:30px;\"><span id=\"currentdealcountId\">27</span></b>人已购买</h3>"+
			"                  <div style=\"margin:4px 0px 0px 0px;color:#666;font-size:12px;line-height:18px;text-align:center;\">名额有限，动作要快哦</div>"+
			""+
			"                  "+
			"                  "+
			"                    <div class=\"con_10\">"+
			"                      <input type=\"hidden\" id=\"hasRefreshed\"/>"+
			"                      <div class=\"con_11_new\" align=\"center\">"+
			"                        <p style=\"color:#ff390b;font-size:14px; font-weight:bold;padding-left:0px; text-align:left;margin:0px 0px 0px 0px;padding-left:65px;width:150px;line-height:22px;\">团购已成功<br />可继续购买...</p>"+
			"                      </div>"+
			"                      <div class=\"con_11\" align=\"center\">"+
			"                        "+
			"                      </div>"+
			"                      <p style=\"width:220px;margin:0px;color:#666;font-size:12px;text-align:center;padding:0px;\"><span style=\"color:#007fc2;\">2010-06-12 12:42</span>达到成功人数<strong>20</strong>人</p>"+
			""+
			"                    </div>"+
			"                  "+
			"              </div>"+
			"              "+
			"              "+
			"            </div>"+
			"            <div class=\"con_05 flo_le\">"+
			"              <div class=\"con_12\">"+
			"                "+
			"                <div id=\"mainImgSlideShow\">"+
			"                "+
			"                  <img src=\"http://www.manzuo.com/html/promote/128/dongliart_main.jpg\" width=\"440\" height=\"300\" />"+
			"                  "+
			"                "+
			"                  "+
			"                  <img src=\"http://www.manzuo.com/html/promote/128/dongliart_main1.jpg\" width=\"440\" height=\"300\" />"+
			"                "+
			"                </div>"+
			""+
			"                "+
			"                "+
			"              </div>";

		Article article = new Article();
		parserContent(content,article);
		
	}
}
