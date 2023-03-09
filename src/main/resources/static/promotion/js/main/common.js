$(document).on("click",".main-top-cate a",function(){
	var parents = $(this).parent();
	var index = parents.index();
	var box = $(".main-top-tab .tab-box");

	parents.addClass("active");
	parents.siblings().removeClass("active");
	box.eq(index).addClass("active");
	box.eq(index).siblings().removeClass("active");

});

$(document).on("change",".star input",function(){
	var parents = $(this).parent();

	if( $(this).is(":checked") ){
		parents.prevAll("div").find("input").prop("checked" , true);
	}else{
		parents.nextAll("div").find("input").prop("checked" , false);
	}
});

function menuOpen(){
	$("html , body , .gnb").addClass("fixed");
}

function menuClose(){
	$("html , body , .gnb").removeClass("fixed");
}

function reviewOpen(){
	$(".main-top-tab-01").hide();
	$(".main-top-tab-02").show();
}

function reviewClose(){
	$(".main-top-tab-02").hide();
	$(".main-top-tab-01").show();
}