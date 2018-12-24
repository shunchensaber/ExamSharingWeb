// ------------ 鼠标点击按钮切换课程--------

$(document).ready(function(){
	//默认让第一页显示
	$("#course-window1").addClass('course-window-show');

	$("#exam-button1").click(function(){
		$("#course-window2,#course-window3,#course-window4").addClass('course-window-hide');
		if($("#course-window1").hasClass('course-window-hide')){
			$("#course-window1").removeClass('course-window-hide');
		}else {
			$("#course-window1").addClass('course-window-show');
		}
		$("#exam-button1").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});

	$("#exam-button2").click(function(){
		$("#course-window1,#course-window3,#course-window4").addClass('course-window-hide');
		if($("#course-window2").hasClass('course-window-hide')){
			$("#course-window2").removeClass('course-window-hide');	
		}else {
			$("#course-window2").addClass('course-window-show');
		}
		$("#exam-button2").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});

	$("#exam-button3").click(function(){
		$("#course-window2,#course-window1,#course-window4").addClass('course-window-hide');
		if($("#course-window3").hasClass('course-window-hide')){
			$("#course-window3").removeClass('course-window-hide');
		}else {
			$("#course-window3").addClass('course-window-show');
		}
		$("#exam-button3").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});

	$("#exam-button4").click(function(){
		$("#course-window2,#course-window3,#course-window1").addClass('course-window-hide');
		if($("#course-window4").hasClass('course-window-hide')){
			$("#course-window4").removeClass('course-window-hide');
		}else {
			$("#course-window4").addClass('course-window-show');
		}
		$("#exam-button4").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});
});
