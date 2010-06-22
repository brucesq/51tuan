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
public class TuanmeiParser    implements ArticleParser{

	public Article parse(String htmlurl, Integer cityId,Integer fromId) throws Exception {

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
//		System.out.println(content);
		parserContent(content,article);
		return article;
	}
	
	public static void parserContent(String content,Article article){
		int index = content.indexOf("id=\"deal_brief\"");
		if(index > 0 ){
			content = content.substring(index+10);
			index = content.indexOf("<h1>");
			if(index >= 0){
				content = content.substring(index+4);
				index = content.indexOf("</h1>");
				String title  = content.substring(0,index);
//				System.out.println(title);
				article.setName(title);
			}
				
		}
		index = content.indexOf("class=\"buyit\"");
		if(index > 0 ){
			content = content.substring(index+13);
			index = content.indexOf("</em>");
			if(index > 0){
				content = content.substring(index+5);
				index = content.indexOf("</strong>");
				String nowPrice  = content.substring(0,index);
				content = content.substring(index+9);
//				nowPrice = getPrice(nowPrice);
//				System.out.println(nowPrice);
				article.setNowPrice(nowPrice);
				index = content.indexOf("<td class=\"market_price\">");
				if(index > 0){
					content = content.substring(index+25);
					index = content.indexOf("</td>");
					String oldPrice  = content.substring(0,index);
					oldPrice = getPrice(oldPrice);
					article.setOriginalPrice(oldPrice);
//					System.out.println(oldPrice);
				
					index = content.indexOf("<td>");
					if(index >= 0){
						content = content.substring(index+4);
						index = content.indexOf("</td>");
						String discount  = content.substring(0,index);
//						System.out.println(discount);
						article.setDiscount(discount);
						
					}
					index = content.indexOf("<td>");
					content = content.substring(index+4);
					index = content.indexOf("</td>");
					String saveMoney  = content.substring(0,index);
					saveMoney = getPrice(saveMoney);
//					System.out.println(saveMoney);
					article.setSaveMoney(saveMoney);
						
					
					index = content.indexOf("id=\"deal_title_pic\"");
					if(index >= 0){
						content = content.substring(index+20);
						index = content.indexOf("src=\"");
						content = content.substring(index+5);
						index= content.indexOf("\"");
						String url = content.substring(0,index);
//						System.out.println(url);
						article.setImgurl(url);
					}
				}
			}
		}
	}
	
	private static String getPrice(String str){
		int index = str.indexOf("¥");
		if(index >= 0){
			str = str.substring(index+1);
			String price = "";
			for(int i=0;i<str.length();i++){
				if(StringUtils.isNumeric(""+str.charAt(i))){
					price += str.charAt(i);
				}else if('.' == str.charAt(i) || '-' == str.charAt(i)){
					price += str.charAt(i);
				}else{
					continue;
				}
			}
			str = price;
		}
		return str;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		String content = 
//			" <div id=\"share_address_top\" class=\"share_address\">"+
//			"       <p>把下面的内容通过 MSN 或 QQ 发送给好友：</p>"+
//			"       <p><input type=\"text\" class=\"f-input\" size=\"40\" value=\"http://tuanmei.net/i/deal/eyeshadow.html?r=i0\" id=\"share_address_link_top\"></p>"+
//			" </div>"+
//			" <div id=\"deal_brief\">"+
//			"   <h1>1折！29.9元抢购倩碧缤纷炫彩双色眼影美国专柜中样，让你轻松拥有真实饱满炫耀色彩，两种颜色适合多变的你！一单买两盒就包邮！</h1>"+
//			"   <div id=\"deal_info\">"+
//			"     <div class=\"ribbon\">               "+
//			"           <div class=\"bg\">&nbsp;</div>"+
//			""+
//			"           <div class=\"buyit\">"+
//			"               <strong><em>??</em>29.9</strong> "+
//			"                               <span><a href=\"/i/order/new/eyeshadow\"><img src=\"./templates/tuanmei/images/purchase_button.png\"/></a></span>"+
//			"                           </div>                 "+
//			"     </div>"+
//			"     <div class=\"price\">"+
//			"       <table>"+
//			"         <tr>"+
//			"           <th class=\"market_price\">市场价</th>"+
//			""+
//			"           <th class=\"discount\">折扣</th>"+
//			"           <th>您节省</th>"+
//			"         </tr>"+
//			"         <tr>"+
//			"           <td class=\"market_price\">¥200</td>"+
//			"           <td>1.4折</td>"+
//			"           <td>¥170.1</td>"+
//			""+
//			"         </tr>"+
//			"       </table>"+
//			"     </div>"+
//			"           <div class=\"countdown\">"+
//			"       <input type=\"hidden\" id=\"time_left\" value=\"34193\" />"+
//			"       <h4></h4>"+
//			"       <div id=\"timer\"> 11<em>时</em>50<em>分</em>33<em class=\"dot\">&nbsp;</em>1<em>秒</em> </div>"+
//			""+
//			"     </div>"+
//			"                   <div class=\"deal_status\">"+
//			"            <div class=\"purhcase_number\"><strong>1722</strong>人已经购买</div>"+
//			"            <div class=\"progress no_stock_soon\">"+
//			"                         <strong>数量有限</strong><br />"+
//			"                         下手要快哦"+
//			"            </div>"+
//			"                      </div>"+
//			""+
//			"                     "+
//			"   </div>"+
//			"   <div id=\"deal_highlight\">"+
//			"     <div id=\"deal_title_pic\"> <img src=\"http://images.tuanmei.net/eyeshadow/eyeshadow-title.jpg\" /> </div>"+
//			"     <div id=\"deal_note\">倩碧COLOUR SURGE EYE SHADOW DUO缤纷炫彩双色眼影，贴心2g小盒装，价格算下来仅仅是正装的1.4折！更有两种颜色适合多变的你~</div>"+
//			"   </div>"+
//			"   <div class=\"clear\"></div>"+
//			" </div>"+
//			""+
//			" <ul id=\"deal_tabs\" class=\"tabs\">"+
//			"   <li class=\"selected\" tab=\"deal_desc\" value=\"deal_desc\"><a href=\"javascript:void(0);\" value=\"deal_desc\">本单详情</a></li>"+
//			"   <li tab=\"deal_shipping_info\"><a href=\"javascript:void(0);\">免邮指南</a></li>"+
//			"   <div class=\"clear\"></div>"+
//			" </ul>";
		
		Article article = new Article();
		TuanmeiParser p = new TuanmeiParser();
		p.parse("http://www.tuanmei.net/", 1, 5);
//		parserContent(content,article);

	}

}
