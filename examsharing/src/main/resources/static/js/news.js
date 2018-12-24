
window.onload = function(){
	photoAnimate();
}
// ------------------------------ 图片轮播开始----------------------
 function photoAnimate(){  //图片轮播函数
	var contenter = document.getElementById("container");
	var list = document.getElementById("list");
	var buttons = document.getElementById("button").getElementsByTagName("span");
	var prev = document.getElementById("prev");
	var next = document.getElementById("next");
	var index = 1;
	var animated = false;  //判断是否是在运动
	var timer;

	// 圆点选中变扁
	function showButton(){
		for(var i = 0; i < buttons.length;i++){
			if(buttons[i].className == "on"){ //先判断button中的span标签是存在为on属性，是的话将其属性去除
				buttons[i].className = " ";
				break;
			}
		}
		buttons[index - 1].className = 'on';  //将button当前所在的span标签添加属性class="on"
	}

	function animate(offset){
		animated = true;
		newleft = parseInt(list.style.left) + offset;  //新的向左偏移量 = 原先的向左偏移量 + 预设值偏移值
		var time = 1180; //位移总时间
		var interval = 40; //位移间隔时间
		var speed = offset/(time/interval);//每次位移量
		function go(){ //仅animate内部的go（）函数  
			if((speed < 0 && parseInt(list.style.left) > newleft) || (speed > 0 && parseInt(list.style.left) < newleft)){
				//存在两种情况 1.speed < 0 && parseInt(list.style.left)> newleft 向左运动
				//             2.speed > 0 && parseInt(list.style.left) < newleft 向右运动
				list.style.left = parseInt(list.style.left) + speed + 'px';
				setTimeout(go,interval); //定时器 递归调用
			}else{
				animated = false;
				list.style.left = newleft +'px';
				if(newleft > -1180){  //第一张就返回最后张
					list.style.left = -4720 + 'px';
				} 
				if(newleft  < -4720){ //最后一张就返回第一张
					list.style.left = -1180 + 'px';
				}
			
			}
		}
		go();
		
	}
	// 箭头切换
	prev.onclick = function(){
		if(index == 1){
			index = 4;
		}else{
			index -= 1;
		}
		showButton();
		if(!animated){
			animate(1180);
		}
		// alert("左键");
	}
	next.onclick = function(){
		if(index == 4){
			index = 1;
		}else{
			index += 1;
		}
		showButton();
		if(!animated){
			animate(-1180);
		}
	
		// alert("右键");
	}

	// 按钮切换
	for(var i = 0; i < buttons.length;i++){
		buttons[i].onclick = function(){
			if(this.className == "on"){
				return ;
			}
			var myIndex = parseInt(this.getAttribute('index'));
			var offset = -1180 * ( myIndex - index );
			if(!animated){
				animate(offset);
			}
			index = myIndex;
			showButton();
		}
	}
	
}
// -------------------图片轮播结束---------------------




