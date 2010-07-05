function addVisit(url,id){
	$.ajax({
   		type: "POST",
   		url: "ajax/addVisit",
   		data: "id="+id,
  		success: function(msg){
   		}
	});
}

function addFeedback(name,content){	
	var url = "ajax/addFeedback";
	var param = {};
	param.name = name;
	param.content = content;
	$.ajax({
		type: "POST",
		url: url,
		async: true,
		data: param,
		success: function(data){	
			if(data == 1 || data == '1')
				alert("感谢您的建议");
			else
				alert("不好意思，出错了");
		}
	});
}

function bookmark(title, url){
	if (document.all) {
		window.external.AddFavorite(url, title)}
	else {
		if (window.sidebar) 
			window.sidebar.addPanel(title, url, "")
	}
}

function changeCity(val){
	var obj = document.getElementById("cityList");
	if(obj.style.display == 'none' || obj.style.display==''){
		$("#mask").css("height",$(document).height()+"px");
		$("#mask").show();
		$("#cityList").css("left",$(window).width()/2-210);
		$("#cityList").css("top",$(window).height()/2-80);
		obj.style.display="block";
	}else if(obj.style.display == 'block'){
		obj.style.display="none";
		$("#mask").hide();
	}
	if(val != ''){
		$("#city").html(val);
		$("#cityList").find("li").each(function(i,n){
			$(n).css("color","");
			var str = $(n).html();
			if($.trim($(n).html()) == val){
				$(n).css("color","#BBD9F7");
			}
		});
	}
}