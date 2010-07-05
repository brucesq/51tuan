<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!--顶部收藏部分开始-->

<div class="main_top_ssdv">
<div class="main_top_ssdv_left"></div>
<div class="main_top_ssdv_midd">
<div class="main_top_ssdv_midd_d1"><img src="image/main_top_img2.gif" width="10" height="9" /><a href="javascript:void(0);" onclick="bookmark('百团大战：吹响团购-集结号', 'http://www.100grouper.com/tg/index.html');">加入收藏</a></div>
<!-- 
<div class="main_top_ssdv_midd_d2"><img src="image/main_top_img1.gif" width="10" height="9" /><a href="#" target="_blank">设为首页</a></div>
<div class="main_top_ssdv_midd_d2"><img src="image/main_top_img1.gif" width="10" height="9" /><a href="#" target="_blank">设为首页</a></div>
-->
</div>
<div class="main_top_ssdv_right"></div>
</div>

<!--顶部收藏部分结束-->
<!--顶部导航部分开始-->

<div id="main_top_dh">
<div class="main_top_dh_left"></div>
<div class="main_top_dh_right">
<div class="main_top_dh_right_dv"><a href="<%=request.getContextPath() %>"><img src="image/main_top_dh_img1.gif" alt="首页" border="0" />首&nbsp;页</a></div>
<div class="main_top_dh_right_dv"><a href="#" target="_blank"><img src="image/main_top_dh_img2.gif" alt="团购" border="0" />购物车</a></div>
<div class="main_top_dh_right_dv"><a href="#" target="_blank"><img src="image/main_top_dh_img3.gif" alt="团购" border="0" />购物志</a></div>
<div class="main_top_dh_right_dv"><a href="#" target="_blank"><img src="image/main_top_dh_img4.gif" alt="团购" border="0" />新&nbsp;闻</a></div>
<div class="main_top_dh_right_dv"><a href="#" target="_blank"><img src="image/main_top_dh_img5.gif" alt="团购" border="0" />论&nbsp;坛</a></div>
<div class="main_top_dh_right_dv"><a href="#" target="_blank"><img src="image/main_top_dh_img6.gif" alt="团购" border="0" />帮&nbsp;助</a></div>
</div>
</div>

<!--顶部导航部分结束-->
<!--顶部banner部分开始-->

<div id="main_top_banner">
<div class="main_top_banner_left"></div>
<div class="main_top_banner_midd">
<div class="main_top_banner_midd_bo" id="city">北京</div>
<div class="main_top_banner_midd_qh"><b id="changeCityButton" style="cursor:pointer;" onclick="changeCity('');">切换城市</b>&nbsp;&nbsp;&nbsp;&nbsp;本网站已能搜索 <b><%=Constants.CITY_ID.entrySet().size() %></b> 个城市的  <b><%=Constants.FROM_ID.entrySet().size() %></b> 家团购网站的团购信息</div>
<div class="main_top_banner_midd_gx"><img src="image/main_top_banner_ico8.gif" align="absmiddle" />&nbsp;分享到：&nbsp;&nbsp;<img src="image/main_top_banner_ico1.gif" align="absmiddle" />&nbsp;<a onclick="window.prompt('请复制网址','www.100grouper.com');" href="javascript:void(0)">QQ/MSN</a>&nbsp;&nbsp;<img src="image/main_top_banner_ico2.gif" width="16" height="16" align="absmiddle" />&nbsp;<a href="http://www.kaixin001.com/repaste/share.php?rurl=www.100grouper.com&rcontent=www.100grouper.com%E2%80%9C%E7%99%BE%E5%9B%A2%E5%A4%A7%E6%88%98%E2%80%9D%E5%90%B9%E5%93%8D%E5%9B%A2%E8%B4%AD-%E9%9B%86%E7%BB%93%E5%8F%B7%EF%BC%81&rtitle=%E2%80%9C%E7%99%BE%E5%9B%A2%E5%A4%A7%E6%88%98%E2%80%9D%E5%90%B9%E5%93%8D%E5%9B%A2%E8%B4%AD-%E9%9B%86%E7%BB%93%E5%8F%B7%EF%BC%81" target="_blank">开心</a>&nbsp;&nbsp;<img src="image/main_top_banner_ico3.gif" align="absmiddle" />&nbsp;<a href="http://share.renren.com/share/buttonshare.do?link=www.100grouper.com&title=www.100grouper.com%20%E2%80%9C%E7%99%BE%E5%9B%A2%E5%A4%A7%E6%88%98%E2%80%9D%E5%90%B9%E5%93%8D%E5%9B%A2%E8%B4%AD-%E9%9B%86%E7%BB%93%E5%8F%B7%EF%BC%81&body=%E2%80%9C%E7%99%BE%E5%9B%A2%E5%A4%A7%E6%88%98%E2%80%9D%E5%90%B9%E5%93%8D%E5%9B%A2%E8%B4%AD-%E9%9B%86%E7%BB%93%E5%8F%B7" target="_blank">人人</a>&nbsp;&nbsp;<img src="image/main_top_banner_ico4.gif" align="absmiddle" />&nbsp;<a href="http://www.douban.com/recommend/?url=www.100grouper.com&title=www.100grouper.com%20%E2%80%9C%E7%99%BE%E5%9B%A2%E5%A4%A7%E6%88%98%E2%80%9D%E5%90%B9%E5%93%8D%E5%9B%A2%E8%B4%AD-%E9%9B%86%E7%BB%93%E5%8F%B7%EF%BC%81" target="_blank">豆瓣</a>&nbsp;&nbsp;<img src="image/main_top_banner_ico5.gif" align="absmiddle" />&nbsp;<a href="http://v.t.sina.com.cn/share/share.php?url=www.100grouper.com&title=%E2%80%9C%E7%99%BE%E5%9B%A2%E5%A4%A7%E6%88%98%E2%80%9D%E5%90%B9%E5%93%8D%E5%9B%A2%E8%B4%AD-%E9%9B%86%E7%BB%93%E5%8F%B7%EF%BC%81&pic=&type=0" target="_blank">新浪</a>&nbsp;&nbsp;<img src="image/main_top_banner_ico6.gif" align="absmiddle" />&nbsp;<a href="http://bai.sohu.com/share/blank/addbutton.do?from=bianews.com&link=http://www.100grouper.com/tg/index.html" target="_blank">白社会</a>&nbsp;&nbsp;<img src="image/main_top_banner_ico7.gif" align="absmiddle" />&nbsp;<a href="mailto:?subject=%A1%B0%B0%D9%CD%C5%B4%F3%D5%BD%A1%B1%B4%B5%CF%EC%CD%C5%B9%BA-%BC%AF%BD%E1%BA%C5&body=%B7%A2%CF%D6%D2%BB%BA%C3%CD%F8%D5%BE--%B0%D9%CD%C5%CD%F8%A3%AC%CB%FB%C3%C7%B5%C4%CD%C5%B9%BA%D0%C5%CF%A2%B3%AC%C8%AB%A3%A1%0A%0A%CE%D2%CF%EB%C4%FA%BB%E1%B8%D0%D0%CB%C8%A4%B5%C4%A3%BA%0A%0Ahttp%3A%2F%2Fwww.100grouper.com%2Ftg%2Findex.html">信箱</a></div>
</div>
<div class="main_top_banner_right"></div>
</div>

<!--顶部banner部分结束-->

