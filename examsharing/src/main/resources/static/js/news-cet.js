// ------------ 鼠标点击按钮切换课程--------
 
$(document).ready(function(){
	//默认让第一页显示
	$("#cet-article-box1").addClass('cet-article-box-show');

	$("#news-cet-button1").click(function(){
		$("#cet-article-box2,#cet-article-box3,#cet-article-box4").addClass('cet-article-box-hide');
		if($("#cet-article-box1").hasClass('cet-article-box-hide')){
			$("#cet-article-box1").removeClass('cet-article-box-hide');
		}else {
			$("#cet-article-box1").addClass('cet-article-box-show');
		}
		$("#news-cet-button1").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});

	$("#news-cet-button2").click(function(){
		$("#cet-article-box1,#cet-article-box3,#cet-article-box4").addClass('cet-article-box-hide');
		if($("#cet-article-box2").hasClass('cet-article-box-hide')){
			$("#cet-article-box2").removeClass('cet-article-box-hide');	
		}else {
			$("#cet-article-box2").addClass('cet-article-box-show');
		}
		$("#news-cet-button2").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});

	$("#news-cet-button3").click(function(){
		$("#cet-article-box2,#cet-article-box1,#cet-article-box4").addClass('cet-article-box-hide');
		if($("#cet-article-box3").hasClass('cet-article-box-hide')){
			$("#cet-article-box3").removeClass('cet-article-box-hide');
		}else {
			$("#cet-article-box3").addClass('cet-article-box-show');
		}
		$("#news-cet-button3").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});

	$("#news-cet-button4").click(function(){
		$("#cet-article-box2,#cet-article-box3,#cet-article-box1").addClass('cet-article-box-hide');
		if($("#cet-article-box4").hasClass('cet-article-box-hide')){
			$("#cet-article-box4").removeClass('cet-article-box-hide');
		}else {
			$("#cet-article-box4").addClass('cet-article-box-show');
		}
		$("#news-cet-button4").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});
});
 