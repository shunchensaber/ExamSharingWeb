
$(document).ready(function(){
	$("#schedule-class1").click(function() {
	/* Act on the event */
	
		// 自动播放代码
	    var myPlayer = videojs('my_video_1');
	    videojs("my_video_1").ready(function(){
	        var myPlayer = this;
	        myPlayer.play();
	    });
 	});
 	$("#schedule-class2").click(function(){
 		alert("active");
 		var videoSrc = "../video/snow.mp4";
 		$("#my_video_1").prop("src",videoSrc);
 		// $("#video-box video").prop("src",src)
 	});

})
