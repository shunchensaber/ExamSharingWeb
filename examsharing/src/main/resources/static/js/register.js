$(document).ready(function () {
   
    $("#re_button").click(function(event) {
        /* Act on the event */
        // alert("点击事件");
        validateForm();
    });
   function validateForm(){
    // checkUserName();
    // checkPassword();
    // checkRepassword();
     if(checkUserName()&&checkPassword()&&checkRepassword()){
         alert("恭喜您！注册成功！");
     }else {
        alert("注册失败！");
     }
}
});



//验证用户名（为3~16个字符，且不能包含”@”和”#”字符）
function checkUserName(){
    var name=document.getElementById("username").value.trim();
    var nameRegex=/^[^@#]{3,16}$/;
    if(!nameRegex.test(name)){
        document.getElementById("info_msg").innerHTML="用户名为3~16个字符，且不能包含”@”和”#”字符";
    }else{
        document.getElementById("info_msg").innerHTML="";
        return true;
    }

}


//验证密码（长度在8个字符到16个字符）
function checkPassword(){
    var password=document.getElementById("password").value.trim();
    //var password=$("#password").value;
    $("#password").innerHTML="";
    //密码长度在8个字符到16个字符，由字母、数字和".""-""_""@""#""$"组成
    //var passwordRegex=/^[0-9A-Za-z.\-\_\@\#\$]{8,16}$/;
    //密码长度在8个字符到16个字符，由字母、数字和"_"组成
    var passwordRegex=/^[0-9A-Za-z_]\w{7,15}$/;
    if(!passwordRegex.test(password)){
        document.getElementById("info_msg").innerHTML="密码长度必须在8个字符到16个字符之间";
    }else{
        document.getElementById("info_msg").innerHTML="";
        return true;
    }
}

//验证校验密码（和上面密码必须一致）
function checkRepassword(){
    alert("验证已执行");
    var password=document.getElementById("password").value.trim();
    var repassword=document.getElementById("cpassword").value.trim();

    //校验密码和上面密码必须一致
    if(repassword == password){
        document.getElementById("info_msg").innerHTML=" ";
       
        alert("if相同");
        return true;
    }else{
       document.getElementById("info_msg").innerHTML="两次输入密码不正确";
        alert("else不同");
    }
}