function addVisit(url,id){
	$.ajax({
   		type: "POST",
   		url: "ajax/addVisit",
   		data: "id="+id,
  		success: function(msg){
   		}
	});
}