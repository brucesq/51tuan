<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
</head>
<body>

<table id="main">
	<tr>
		<td>
		<table id="headers">
			<tr>
				<th>Log In</th>
			</tr>
		</table>
		<br />
		<table id="input">
			<tr>
				<th>username:</th>
				<td><input id="name" size="15" maxLength="12" /></td>
			</tr>
			<tr>
				<th>password:</th>
				<td><input type="password" id="password" size="15"
					maxLength="12" /></td>
			</tr>
		</table>
		<div class="buttons"><input type="button" id="loginbutton"
			value="Login" /></div>
		</td>
	</tr>
</table>
<div id="bottom1"><span id="message"></span></div>

</body>
<script type="text/javascript">

$("#loginbutton").click(function() {
 	var name = $("#name").val();
  	var password = $("#password").val();
  	$.ajax({
  		url: "../ajax/login?username="+name+"&password="+password,
  		cache: false,
  		success: function(o){
    		var msg = $.parseJSON(o);  
			if(msg.result=='true'){
				document.location.href = '<%=request.getContextPath()%>/admin/index.html';
			}else{
				 $("#message")[0].innerHTML = msg.message;
			}
  		}
  	});
  	
});

</script>
</html>