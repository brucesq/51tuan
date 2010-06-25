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