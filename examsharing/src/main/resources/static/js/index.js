
window.onload = function(){
	photoAnimate();
	moreAnimate();
	// addAmimate();
    onmouseUserlogo();
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
		var time = 1000; //位移总时间
		var interval = 20; //位移间隔时间
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
				if(newleft > -500){  //第一张就返回最后张
					list.style.left = -2500 + 'px';
				} 
				if(newleft  < -2500){ //最后一张就返回第一张
					list.style.left = -500 + 'px';
				}
			
			}
		}
		go();
		
	}
	// 箭头切换
	prev.onclick = function(){
		if(index == 1){
			index = 5;
		}else{
			index -= 1;
		}
		showButton();
		if(!animated){
			animate(500);
		}
		// alert("左键");
	}
	next.onclick = function(){
		if(index == 5){
			index = 1;
		}else{
			index += 1;
		}
		showButton();
		if(!animated){
			animate(-500);
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
			var offset = -500 * ( myIndex - index );
			if(!animated){
				animate(offset);
			}
			index = myIndex;
			showButton();
		}
	}
	
	//自动播放
	function play(){
		timer = setInterval(function(){
			next.onclick();
		},5000);
	}
	function stop(){
		clearInterval(timer);
	}
	container.onmouseover = stop;  //鼠标停留在其上，调用停止自动播放函数stop（）
	container.onmouseout = play;	//鼠标离开，调用自动播放函数play（）
	play();
}
// -------------------图片轮播结束---------------------


// -------------------箭头动画效果------------------
	function moreAnimate(){
		var more = document.getElementById('more');
		more.className='animated infinite flipInX slow';
	}

// -------------------箭头动画效果------------------


// --------------鼠标经过box时显示另一个div(使用JQuery)----------
	$(document).ready(function(){
		// 六级
	  $("#boxShow1").mouseover(function(){
	    $("#skuShow1").css("opacity","1");
	    addAmimate();
	  });
	  $("#boxShow1").mouseout(function(){
	    $("#skuShow1").css("opacity","0");
	    removeAnimate();
	  });
	  // 四级
	  $("#boxShow2").mouseover(function(){
	    $("#skuShow2").css("opacity","1");
	     addAmimate();
	  });
	  $("#boxShow2").mouseout(function(){
	    $("#skuShow2").css("opacity","0");
	     removeAnimate();
	  });
	  // 考研
	  $("#boxShow3").mouseover(function(){
	    $("#skuShow3").css("opacity","1");
	     addAmimate();
	  });
	  $("#boxShow3").mouseout(function(){
	    $("#skuShow3").css("opacity","0");
	     removeAnimate();
	  });
	  
	});

// --------------鼠标经过box时显示另一个div----------

// -------------iv刚出现div里面的内容进入效果--------
 	function addAmimate(){
 		 $('.kx-ad p').addClass('animated bounce');
 		 $('.kx-ad span').addClass('animated pulse');
 	}
 	// 必须清楚添加的动画，下次进入才能再次执行
 	function removeAnimate(){
 		 $('.kx-ad p').removeClass('animated  bounce');
 		 $('.kx-ad span').removeClass('animated pulse');
 	}
// -------------iv刚出现div里面的内容进入效果--------

//个人详情页

	function onmouseUserlogo(){
		$("#navbar-logo").mouseover(function(){
			$("#userDiv").css("opacity","1");
		});
		$("#userDiv").mouseover(function(){
			$("#userDiv").css("opacity","1");
		});
		$("#navbar-logo").mouseout(function(){
			$("#userDiv").css("opacity","0");
		});
		$("#userDiv").mouseout(function(){
			$("#userDiv").css("opacity","0");
		});
	}