require("jquery")
$(function () {
    $("form button:last").on("click",function () {
        submit();
    })
    $("form").on("keydown",function (e) {
        if (e.keyCode==13){
            submit();
        }
    })
    $("form a:first").on("click",function () {
        $("#login-code").src('$!{request.contextPath}/getCode?t=' + Math.random());
    })
    $("#username").focus();
});
function submit() {
    var username =  $("#username").val();
    var password = $("#password").val();
    var validateCode = $("#validateCode").val();
    if(! $.isNotNull(username)){
        $(".login-error span").html("请填写用户名")
        $(".login-error").show();
        return;
    }
    else if(! $.isNotNull( password)){
        $(".login-error span").html("请填写密码");
        $(".login-error").show();
        return;
    }
    else if(! $.isNotNull( validateCode)){
        $(".login-error span").html("请填写验证码");
        $(".login-error").show();
        return;
    }
    //$("form").attr("action","login.do")
    $("form").submit();
}