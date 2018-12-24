// ------------ 鼠标点击按钮切换课程--------
 
$(document).ready(function(){
	//默认让第一页显示
	$("#exam-article-box1").addClass('exam-article-box-show');

	$("#news-button1").click(function(){
		$("#exam-article-box2,#exam-article-box3,#exam-article-box4").addClass('exam-article-box-hide');
		if($("#exam-article-box1").hasClass('exam-article-box-hide')){
			$("#exam-article-box1").removeClass('exam-article-box-hide');
		}else {
			$("#exam-article-box1").addClass('exam-article-box-show');
		}
		$("#news-button1").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});

	$("#news-button2").click(function(){
		$("#exam-article-box1,#exam-article-box3,#exam-article-box4").addClass('exam-article-box-hide');
		if($("#exam-article-box2").hasClass('exam-article-box-hide')){
			$("#exam-article-box2").removeClass('exam-article-box-hide');	
		}else {
			$("#exam-article-box2").addClass('exam-article-box-show');
		}
		$("#news-button2").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});

	$("#news-button3").click(function(){
		$("#exam-article-box2,#exam-article-box1,#exam-article-box4").addClass('exam-article-box-hide');
		if($("#exam-article-box3").hasClass('exam-article-box-hide')){
			$("#exam-article-box3").removeClass('exam-article-box-hide');
		}else {
			$("#exam-article-box3").addClass('exam-article-box-show');
		}
		$("#news-button3").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});

	$("#news-button4").click(function(){
		$("#exam-article-box2,#exam-article-box3,#exam-article-box1").addClass('exam-article-box-hide');
		if($("#exam-article-box4").hasClass('exam-article-box-hide')){
			$("#exam-article-box4").removeClass('exam-article-box-hide');
		}else {
			$("#exam-article-box4").addClass('exam-article-box-show');
		}
		$("#news-button4").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});
});
