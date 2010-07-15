<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.tuan.web.framework.AuthenticationHelper" %>
<%@ page import="com.tuan.domain.Constants"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html id="html" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>百团网 - 注册用户</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="description" content="百团网 - 高端放心团购搜索引擎">
<link rel="shortcut icon" href="favicon.ico" />
<meta name="Keywords" content="团购，百团，放心，高端，百团大战，集结号，搜索引擎，团购汇总，折扣，打折，团购网，团购，团购网站，团购吧，团购导航，baituan， baituanwang, tuangou">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/boxOver.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
</head>

<body>
<!--开始-->
<div class="main_alldv">

<%@ include file="/common/header.jsp"%>

<!--中部开始-->

<div id="main_mid">
<!--中部左开始-->

<div class="main_mid_left">



<!--中部今日团购开始-->

<div id="main_mid_tdtg">
<div class="main_mid_tdtg_title1">


</div>
<div class="main_mid_tdtg_product">
<div class="main_mid_tdtg_product_dv">
<div style="padding:10px 20px 10px 20px;height:500px;">
<h2>注册信息</h2>
<hr/>
<form id="form1">
<div class="main_mid_login_left_id">
<table class="register_table" width="100%">
	<tr>
		<td width="60">账号邮箱：</td>
		<td><input type="text" id="loginid" name="lgoinid"/><span id="loginid_err">请输入正确的邮箱</span></td>
	</tr>
	<tr>
		<td>账号称呼：</td>
		<td><input type="text" id="name" name="name" maxlength="10"/><span id="name_err">请输入称呼，最多10个字符</span></td>
	</tr>
	<tr>
		<td>账号密码：</td>
		<td><input type="password" id="password" name="password"/><span id="password_err">请输入密码，4-16位字符、数字或下划线</span></td>
	</tr>
	<tr>
		<td>确认密码：</td>
		<td><input type="password" id="password1" name="password1"/><span id="password1_err">请确认，两次密码不一致</span></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="button" value="提交" onclick="checkForm()"/>&nbsp;&nbsp;<input type="reset" value="重置"/></td>
	</tr>
</table>
</div>
</form>
</div>

</div>
</div>
</div>
<div class="main_mid_tdtg_bottom"></div>

<!--中部今日团购结束-->

</div>

<!--中部左结束-->

<!--中部右开始-->
<%@ include file="/common/right1.jsp"%>
<!--中部右结束-->

</div>

<!--中部结束-->

<%@ include file="/common/footer.jsp"%>

</div>
<!--结束-->


</body>
</html>
<script type="text/javascript">

$(document).ready(function(){
	$("#changeCityButton").hide();
	errInit();
});
function errInit(){
	$("#loginid_err").hide();
	$("#name_err").hide();
	$("#password_err").hide();
	$("#password1_err").hide();
}
function checkForm(){
	errInit();
	if(!isEmail($.trim($("#loginid").val()))){
		$("#loginid_err").show();
		return false;
	}
	if($("#name").val().length > 10){
		$("#name_err").show();
		return false;
	}
	if(!isPasswd($("#password").val())){
		$("#password_err").show();
		return false;
	}
	if($("#password").val() != $("#password1").val()){
		$("#password1_err").show();
		return false;
	}
	addUser($.trim($("#loginid").val()),$.trim($("#name").val()),$("#password").val());
}

function addUser(loginid,name,pwd){	
	var url = "ajax/registerUser";
	var param = {};
	param.loginid = loginid;
	param.name = name;
	param.password = pwd;
	$.ajax({
		type: "POST",
		url: url,
		async: true,
		data: param,
		success: function(data){	
			if(data == 1 || data == '1'){
				alert("注册成功，即将跳回主页");
				window.location.href = "index.html";
			}else
				alert("不好意思，出错了");
		}
	});
}
</script>
