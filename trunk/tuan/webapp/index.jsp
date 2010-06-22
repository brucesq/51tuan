<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>百团网</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="description" content="">
<meta name="Keywords" content="">
<link href="css/index.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/boxOver.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
</head>

<body class="index">

<div class="w" style="text-align:right;font-size:14px;font-family:宋体">百团大战”吹响团购-集结号</div>
<div class="w">
	<div class="logo"><img src="image/logo.gif" width="120" height="90"></a></div>
	<div class="nav">
	<ul>
		<li class="selected"><a href="#">首&nbsp;页</a></li>
	</ul>
	</div>
	<span class="clr"></span>
	<div class="des">
		<div style="float:left;margin:18px;">
			当前所在城市：<span id="city" style="background-color:#FFF;padding:5px;color:#BBD9F7;">北京</span>
			<span style="padding-left:20px;cursor:pointer;" onclick="changeCity();">切换城市</span>
			<span class="share_span">分享此网站： <A class=share_qq onclick="window.prompt('请复制网址','www.100grouper.com');" href="javascript:void(0)">MSN/QQ</A> <A class=share_sina href="http://v.t.sina.com.cn/share/share.php?url=www.100grouper.com&title=%E7%99%BE%E5%9B%A2%E5%A4%A7%E8%B4%AD%EF%BC%8C%E6%AF%8F%E5%A4%A9%E9%83%BD%E5%9C%A8%E5%8F%98%E5%8F%98%E5%8F%98%EF%BC%8C%E8%B6%85%E4%BD%8E%E6%8A%98%E6%89%A3%E6%B0%B8%E8%BF%9C%E4%B8%8D%E4%BC%9A%E5%8F%98%EF%BC%81&pic=&type=0" target=_blank>新浪微博</A> <A class=share_kx href="http://www.kaixin001.com/repaste/share.php?rurl=www.100grouper.com&rcontent=www.100grouper.com%E7%99%BE%E5%9B%A2%E5%A4%A7%E8%B4%AD%EF%BC%8C%E6%AF%8F%E5%A4%A9%E9%83%BD%E5%9C%A8%E5%8F%98%E5%8F%98%E5%8F%98%EF%BC%8C%E8%B6%85%E4%BD%8E%E6%8A%98%E6%89%A3%E6%B0%B8%E8%BF%9C%E4%B8%8D%E4%BC%9A%E5%8F%98%EF%BC%81&rtitle=%E7%99%BE%E5%9B%A2%E5%A4%A7%E8%B4%AD%EF%BC%8C%E6%AF%8F%E5%A4%A9%E9%83%BD%E5%9C%A8%E5%8F%98%E5%8F%98%E5%8F%98%EF%BC%8C%E8%B6%85%E4%BD%8E%E6%8A%98%E6%89%A3%E6%B0%B8%E8%BF%9C%E4%B8%8D%E4%BC%9A%E5%8F%98%EF%BC%81" target=_blank>开心网</A> <A class=share_rr href="http://share.renren.com/share/buttonshare.do?link=www.100grouper.com&title=www.100grouper.com%20%E7%99%BE%E5%9B%A2%E5%A4%A7%E8%B4%AD%EF%BC%8C%E6%AF%8F%E5%A4%A9%E9%83%BD%E5%9C%A8%E5%8F%98%E5%8F%98%E5%8F%98%EF%BC%8C%E8%B6%85%E4%BD%8E%E6%8A%98%E6%89%A3%E6%B0%B8%E8%BF%9C%E4%B8%8D%E4%BC%9A%E5%8F%98%EF%BC%81&body=%E7%99%BE%E5%9B%A2%E5%A4%A7%E8%B4%AD%EF%BC%8C%E6%AF%8F%E5%A4%A9%E9%83%BD%E5%9C%A8%E5%8F%98%E5%8F%98%E5%8F%98%EF%BC%8C%E8%B6%85%E4%BD%8E%E6%8A%98%E6%89%A3%E6%B0%B8%E8%BF%9C%E4%B8%8D%E4%BC%9A%E5%8F%98" target=_blank>人人网</A> <A class=share_db href="http://www.douban.com/recommend/?url=www.100grouper.com&title=www.100grouper.com%20%E7%99%BE%E5%9B%A2%E5%A4%A7%E8%B4%AD%EF%BC%8C%E6%AF%8F%E5%A4%A9%E9%83%BD%E5%9C%A8%E5%8F%98%E5%8F%98%E5%8F%98%EF%BC%8C%E8%B6%85%E4%BD%8E%E6%8A%98%E6%89%A3%E6%B0%B8%E8%BF%9C%E4%B8%8D%E4%BC%9A%E5%8F%98%EF%BC%81" target=_blank>豆瓣</A> <A class=share_email href="mailto:?subject=www.100grouper.com%20%E7%99%BE%E5%9B%A2%E5%A4%A7%E8%B4%AD%EF%BC%8C%E6%AF%8F%E5%A4%A9%E9%83%BD%E5%9C%A8%E5%8F%98%E5%8F%98%E5%8F%98%EF%BC%8C%E8%B6%85%E4%BD%8E%E6%8A%98%E6%89%A3%E6%B0%B8%E8%BF%9C%E4%B8%8D%E4%BC%9A%E5%8F%98%EF%BC%81&body=%E7%99%BE%E5%9B%A2%E5%A4%A7%E8%B4%AD%EF%BC%8C%E6%AF%8F%E5%A4%A9%E9%83%BD%E5%9C%A8%E5%8F%98%E5%8F%98%E5%8F%98%EF%BC%8C%E8%B6%85%E4%BD%8E%E6%8A%98%E6%89%A3%E6%B0%B8%E8%BF%9C%E4%B8%8D%E4%BC%9A%E5%8F%98%EF%BC%81">Email</A></span>
			<span class="clr"></span>
			<div id="cityList">
				<ul>
					<li onclick="changeCity();" style="color:#BBD9F7;">北京</li>
					<li onclick="changeCity();">上海</li>
					<li onclick="changeCity();">武汉</li>
					<li onclick="changeCity();">广州</li>
					<li onclick="changeCity();">深圳</li>
					<li onclick="changeCity();">杭州</li>
					<li onclick="changeCity();">天津</li>
					<li onclick="changeCity();">南京</li>
					<li onclick="changeCity();">成都</li>
					<li onclick="changeCity();">长沙</li>
					<li onclick="changeCity();">西安</li>
					<li onclick="changeCity();">郑州</li>
					<li onclick="changeCity();">厦门</li>
					<li onclick="changeCity();">重庆</li>
					<li onclick="changeCity();">福州</li>
					<li onclick="changeCity();">石家庄</li>
					<li onclick="changeCity();">大连</li>
					<li onclick="changeCity();">青岛</li>
				</ul>
			</div>
		</div>
	</div>	

</div>

<div class="w main">
	<div class="left">
		<!--begin-->
		<!--
		<div style="background-color:#BBD9F7;font-size:14px;font-weight:bold;color:#FFF;padding-top:5px;padding-left:5px;height:20px;">
			<div style="float:left;">商品分类</div>
			<div style="text-align:right;padding-right:5px;"><a href="#" style="font-size:14px;font-weight:normal;color:#FFF;">全部分类&gt;&gt;</a></div>
		</div>
		<div style="margin-top:15px;padding-left:5px;">
			<div style="margin-top:10px;">
				<a href="#" style="font-size:14px;font-weight:bold;color:#BBD9F7;">家用电器</a>
			</div>
			<div style="margin-top:10px;">
				<div style="float:left;width:106px;"><a href="#" style="font-size:12px;font-weight:normal;">平板电视</a></div>
				<div style=""><a href="#" style="font-size:12px;font-weight:normal;">家电配件</a></div>
			</div>
			<div style="margin-top:10px;">
				<div style="float:left;width:106px;"><a href="#" style="font-size:12px;font-weight:normal;">平板电视</a></div>
				<div style=""><a href="#" style="font-size:12px;font-weight:normal;">家电配件</a></div>
			</div>
			<div style="margin-top:10px;">
				<div style="float:left;width:106px;"><a href="#" style="font-size:12px;font-weight:normal;">平板电视</a></div>
				<div style=""><a href="#" style="font-size:12px;font-weight:normal;">家电配件</a></div>
			</div>
			<div style="margin-top:10px;">
				<div style="float:left;width:106px;"><a href="#" style="font-size:12px;font-weight:normal;">平板电视</a></div>
				<div style=""><a href="#" style="font-size:12px;font-weight:normal;">家电配件</a></div>
			</div>
			<div style="margin-top:10px;">
				<div style="float:left;width:106px;"><a href="#" style="font-size:12px;font-weight:normal;">平板电视</a></div>
				<div style=""><a href="#" style="font-size:12px;font-weight:normal;">家电配件</a></div>
			</div>
			<div style="margin-top:10px;">
				<div style="float:left;width:106px;"><a href="#" style="font-size:12px;font-weight:normal;">平板电视</a></div>
				<div style=""><a href="#" style="font-size:12px;font-weight:normal;">家电配件</a></div>
			</div>
		</div>
		-->
		<!--end-->

		<div style="background-color:#BBD9F7;font-size:14px;font-weight:bold;color:#FFF;padding-top:5px;padding-left:5px;height:20px;">
			<div style="padding-left:5px;">团购导航</div>
		</div>
		<div style="margin-top:15px;padding-left:15px;">
			<div style="margin:5px;">
				<div><a target="_blank" href="http://www.meituan.com/beijing" style="font-size:24px;font-family:华文彩云">美团网</a></div>
			</div>
			<div style="margin:5px;">
				<div><a target="_blank" href="http://www.lashou.com/beijing" style="font-size:24px;font-family:华文彩云">拉手网</a></div>
			</div>
			<div style="margin:5px;">
				<div><a target="_blank" href="http://t.58.com/index_cbj.html" style="font-size:24px;font-family:华文彩云">58团购</a></div>
			</div>
			<div style="margin:5px;">
				<div><a target="_blank" href="http://www.manzuo.com/his/musicboxktv__xNcQ4Q_HiVw.htm" style="font-size:24px;font-family:华文彩云">满座网</a></div>
			</div>
			<div style="margin:5px;">
				<div><a target="_blank" href="http://www.24quan.com/index.php" style="font-size:24px;font-family:华文彩云">24券</a></div>
			</div>
			<div style="margin:5px;">
				<div><a target="_blank" href="http://www.ftuan.com/index.php" style="font-size:24px;font-family:华文彩云">F团</a></div>
			</div>
			<div style="margin:5px;">
				<div><a target="_blank" href="http://www.aibang.com/" style="font-size:24px;font-family:华文彩云">爱帮网</a></div>
			</div>
			<div style="margin:5px;">
				<div><a target="_blank" href="http://www.jiapintuan.com/" style="font-size:24px;font-family:华文彩云">佳品团</a></div>
			</div>
			<div style="margin:5px;">
				<div><a target="_blank" href="http://www.liketuan.com/index.php?m=Goods&a=show&id=138" style="font-size:24px;font-family:华文彩云">橘子团</a></div>
			</div>
			<div style="margin:5px;">
				<div><a target="_blank" href="http://www.cocotuan.com/Product/75-ShangYuZuoTaQingYuGuo.aspx" style="font-size:24px;font-family:华文彩云">可可团</a></div>
			</div>
		</div>


	</div>

	<div class="middle">
		<!--begin-->
		<div style="margin-top:15px;padding-left:5px;">
			<div>
				<div style="float:left;background-color:#BBD9F7;color:#FFF;height:24px;line-height:24px;overflow:hidden;width:80px;font-size:16px;font-weight:bold;padding-left:12px;">精品推荐</div>
				<div style="background-color:#E0E0E0;height:24px;">&nbsp;</div>
			</div>
			<div style="margin-top:10px;">
				<ul class="list-h">
					<li>
					<div class="p-img"><a target="_blank" href="#"><img src="product/056a6a61-aa69-4495-b31e-fc078fc8744e.jpg" alt="亚都（YADU）LG03-SA 冷风机 风爽" height="100" width="100"></a></div>
					<div class="p-name"><a target="_blank" href="#">亚都（YADU）LG03-SA 冷风机 风爽<font color="#ff6600">超低特价再送乐扣三件套！厂家支持，限时限量！</font></a></div>
					<div class="p-price">京东价：<strong>￥299.00</strong></div>
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="#"><img src="product/056a6a61-aa69-4495-b31e-fc078fc8744e.jpg" alt="亚都（YADU）LG03-SA 冷风机 风爽" height="100" width="100"></a></div>
					<div class="p-name"><a target="_blank" href="#">亚都（YADU）LG03-SA 冷风机 风爽<font color="#ff6600">超低特价再送乐扣三件套！厂家支持，限时限量！</font></a></div>
					<div class="p-price">京东价：<strong>￥299.00</strong></div>
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="#"><img src="product/056a6a61-aa69-4495-b31e-fc078fc8744e.jpg" alt="亚都（YADU）LG03-SA 冷风机 风爽" height="100" width="100"></a></div>
					<div class="p-name"><a target="_blank" href="#">亚都（YADU）LG03-SA 冷风机 风爽<font color="#ff6600">超低特价再送乐扣三件套！厂家支持，限时限量！</font></a></div>
					<div class="p-price">京东价：<strong>￥299.00</strong></div>
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="#"><img src="product/056a6a61-aa69-4495-b31e-fc078fc8744e.jpg" alt="亚都（YADU）LG03-SA 冷风机 风爽" height="100" width="100"></a></div>
					<div class="p-name"><a target="_blank" href="#">亚都（YADU）LG03-SA 冷风机 风爽<font color="#ff6600">超低特价再送乐扣三件套！厂家支持，限时限量！</font></a></div>
					<div class="p-price">京东价：<strong>￥299.00</strong></div>
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="#"><img src="product/056a6a61-aa69-4495-b31e-fc078fc8744e.jpg" alt="亚都（YADU）LG03-SA 冷风机 风爽" height="100" width="100"></a></div>
					<div class="p-name"><a target="_blank" href="#">亚都（YADU）LG03-SA 冷风机 风爽<font color="#ff6600">超低特价再送乐扣三件套！厂家支持，限时限量！</font></a></div>
					<div class="p-price">京东价：<strong>￥299.00</strong></div>
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="#"><img src="product/056a6a61-aa69-4495-b31e-fc078fc8744e.jpg" alt="亚都（YADU）LG03-SA 冷风机 风爽" height="100" width="100"></a></div>
					<div class="p-name"><a target="_blank" href="#">亚都（YADU）LG03-SA 冷风机 风爽<font color="#ff6600">超低特价再送乐扣三件套！厂家支持，限时限量！</font></a></div>
					<div class="p-price">京东价：<strong>￥299.00</strong></div>
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="#"><img src="product/056a6a61-aa69-4495-b31e-fc078fc8744e.jpg" alt="亚都（YADU）LG03-SA 冷风机 风爽" height="100" width="100"></a></div>
					<div class="p-name"><a target="_blank" href="#">亚都（YADU）LG03-SA 冷风机 风爽<font color="#ff6600">超低特价再送乐扣三件套！厂家支持，限时限量！</font></a></div>
					<div class="p-price">京东价：<strong>￥299.00</strong></div>
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="#"><img src="product/056a6a61-aa69-4495-b31e-fc078fc8744e.jpg" alt="亚都（YADU）LG03-SA 冷风机 风爽" height="100" width="100"></a></div>
					<div class="p-name"><a target="_blank" href="#">亚都（YADU）LG03-SA 冷风机 风爽<font color="#ff6600">超低特价再送乐扣三件套！厂家支持，限时限量！</font></a></div>
					<div class="p-price">京东价：<strong>￥299.00</strong></div>
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="#"><img src="product/056a6a61-aa69-4495-b31e-fc078fc8744e.jpg" alt="亚都（YADU）LG03-SA 冷风机 风爽" height="100" width="100"></a></div>
					<div class="p-name"><a target="_blank" href="#">亚都（YADU）LG03-SA 冷风机 风爽<font color="#ff6600">超低特价再送乐扣三件套！厂家支持，限时限量！</font></a></div>
					<div class="p-price">京东价：<strong>￥299.00</strong></div>
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="#"><img src="product/056a6a61-aa69-4495-b31e-fc078fc8744e.jpg" alt="亚都（YADU）LG03-SA 冷风机 风爽" height="100" width="100"></a></div>
					<div class="p-name"><a target="_blank" href="#">亚都（YADU）LG03-SA 冷风机 风爽<font color="#ff6600">超低特价再送乐扣三件套！厂家支持，限时限量！</font></a></div>
					<div class="p-price">京东价：<strong>￥299.00</strong></div>
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="#"><img src="product/056a6a61-aa69-4495-b31e-fc078fc8744e.jpg" alt="亚都（YADU）LG03-SA 冷风机 风爽" height="100" width="100"></a></div>
					<div class="p-name"><a target="_blank" href="#">亚都（YADU）LG03-SA 冷风机 风爽<font color="#ff6600">超低特价再送乐扣三件套！厂家支持，限时限量！</font></a></div>
					<div class="p-price">京东价：<strong>￥299.00</strong></div>
					</li>
				</ul>
			</div>
		</div>
		<!--end-->

		<!--下面开始重复-->
		<div style="margin-top:15px;padding-left:5px;">
			<div>
				<div style="float:left;background-color:#BBD9F7;color:#FFF;height:24px;line-height:24px;overflow:hidden;width:80px;font-size:16px;font-weight:bold;padding-left:12px;">团购信息</div>
				<div style="background-color:#E0E0E0;height:24px;">&nbsp;</div>
			</div>
			<div style="margin-top:10px;" id="center_content">
				
			</div>
		</div>

	</div>

	<!--
	<div class="right">
		<div style="border:solid #E6E6E6;border-width:0 1px 1px;margin-bottom:5px;">
			<div style="background-color:#E0E0E0;font-size:14px;font-weight:bold;padding-top:5px;padding-left:5px;height:20px;">
				<div style="float:left;">百团快报</div>			
				<div style="text-align:right;padding-right:5px;"><a href="#" style="font-size:14px;font-weight:normal;color:#7F7F7F;">更多&gt;&gt;</a></div>
			</div>
			<div>
				<ul>
					<li>·<a href="#">京东12年，疯狂618，疯抢开锣!</a></li>
					<li>·<a href="#">京东12年，疯狂618，疯抢开锣!</a></li>
					<li>·<a href="#">京东12年，疯狂618，疯抢开锣!</a></li>
					<li>·<a href="#">京东12年，疯狂618，疯抢开锣!</a></li>
					<li>·<a href="#">京东12年，疯狂618，疯抢开锣!</a></li>
					<li>·<a href="#">京东12年，疯狂618，疯抢开锣!</a></li>
					<li>·<a href="#">京东12年，疯狂618，疯抢开锣!</a></li>
					<li>·<a href="#">京东12年，疯狂618，疯抢开锣!</a></li>
					<li>·<a href="#">京东12年，疯狂618，疯抢开锣!</a></li>
				</ul>
			</div>
		</div>
	</div>
	-->

</div>

<span class="clr"></span>

<div class="w">
	<div class="footer">
		<a href="#" target="_blank">关于我们</a>|
		<a href="#" target="_blank">联系我们</a>|
		<a href="#" target="_blank">友情链接</a>
	</div>
	<div class="copyright">Copyright&#169;2010-2012&nbsp;&nbsp;百团网&nbsp;版权所有
	</div>
</div>

</body>
</html>
<script type="text/javascript">

$(document).ready(function(){
	$("#center_content").load("ajax/getArticleList?page=1");
});

function changeCity(){
	var obj = document.getElementById("cityList");
	if(obj.style.display == 'none' || obj.style.display=='')
		obj.style.display="block";
	else if(obj.style.display == 'block')
		obj.style.display="none";
}
</script>