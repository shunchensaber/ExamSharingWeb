// ------------ 鼠标点击按钮切换课程--------

$(document).ready(function(){
	//默认让第一页显示
	$("#cet-window1").addClass('cet-window-show');
	//点击第一个按钮时触发的事件，将其他div先隐藏，然后判断第一个div是否有隐藏属性，有将其去除，并添加显示属性
	$("#cet-button1").click(function(){
		$("#cet-window2,#cet-window3,#cet-window4").addClass('cet-window-hide');
		if($("#cet-window1").hasClass('cet-window-hide')){
			$("#cet-window1").removeClass('cet-window-hide');
		}else {
			$("#cet-window1").addClass('cet-window-show');
		}
		$("#cet-button1").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});

	$("#cet-button2").click(function(){
		$("#cet-window1,#cet-window3,#cet-window4").addClass('cet-window-hide');
		if($("#cet-window2").hasClass('cet-window-hide')){
			$("#cet-window2").removeClass('cet-window-hide');	
		}else {
			$("#cet-window2").addClass('cet-window-show');
		}
		$("#cet-button2").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});

	$("#cet-button3").click(function(){
		$("#cet-window2,#cet-window1,#cet-window4").addClass('cet-window-hide');
		if($("#cet-window3").hasClass('cet-window-hide')){
			$("#cet-window3").removeClass('cet-window-hide');
		}else {
			$("#cet-window3").addClass('cet-window-show');
		}
		$("#cet-button3").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});

	$("#cet-button4").click(function(){
		$("#cet-window2,#cet-window3,#cet-window1").addClass('cet-window-hide');
		if($("#cet-window4").hasClass('cet-window-hide')){
			$("#cet-window4").removeClass('cet-window-hide');
		}else {
			$("#cet-window4").addClass('cet-window-show');
		}
		$("#cet-button4").css({"color":"#fff","background-color":"#fa9900"}).siblings().css({"color":"#fff","background-color":"#ccc"});
	});

});
