var $ = require('jquery');
var $validator = require('libs/validator');
var $countDown = require('libs/count-down');
var $alert = require('libs/alert');

//绑定：刷新页面时 提示
$(window).on('beforeunload', function () {
    return '';
});
//取消绑定：刷新页面时 提示
function unbind() {
    $(window).off('beforeunload');//这个是取消提醒
    location.reload();
}
$(function () {
    init();
    //表单验证：发送邮件
    sendEmailValidatorInit();
    registerValidatorInit();
    $('#step1 button:last').on('click', function (e) {
        $('#step1 form').submit;
    });
   /* $('#step2 button:last').on('click', function (e) {
       $('#myTabs li:eq(2) a').tab('show');
    });*/
    $('#step3 button:last').on('click', function (e) {
        $('#step3 form').submit;
    });
    $('#drag').drag();
    $('#resend').on('click', function (e) {
        $countDown($(this));
    })
});
window.onresize = function () {
    $('#drag').html("");
    $('#drag').drag();
}
function init() {
    var validStatus = $("#validStatus").val();
    var message = $("#message").val();
    if( validStatus=="400"){
        $('#step2 .row').find('div').eq(0).find('img').eq(0).hide();
        $('#step2 .row').find('div').eq(0).find('img').eq(1).show();
        $('#step2 .row').find('div').eq(1).html("<strong style='color: #d81b1b'>链接失效</strong> <p style='margin-top: 10px'>"+message+"</p>");
        $('#resend').find("span").html("");
        $('#resend').removeAttr("disabled");
        $('#myTabs li:eq(1) a').tab('show');
    }else if( validStatus=="200"){
        $('#myTabs li:eq(2) a').tab('show');
    }else {
        $('#myTabs li:eq(0) a').tab('show');
    }
    $('#step1 form').attr("action", "api/v1/p/ftisp/unlogin/sendEmail");
    $('#step3 form').attr("action", "api/v1/p/ftisp/unlogin/register");
}
function sendEmailValidatorInit() {
    $validator(
        {form: '#step1 form', button: '#step1 button:last'},
        {
            email: {
                required: true,
                email: true
            },
            agreement: "required"
        },
        {},
        sendEmailAsyfun,
        function (result) {
            if (result.code == 200) {
                $('#myTabs li:eq(1) a').tab('show');
                $countDown($('#resend'));
            } else {
                $alert(result.message);
            }
        })
}
function sendEmailAsyfun() {
    var json = $('#step1 form').serializeObject();
    if ($("#drag").find("div").eq(1).text() != "验证通过") {
        $("#drag").find("div").eq(1).attr("style", "color:#a94442");
        return false;
    }
    delete json["agreement"];
    return json;
}
function registerValidatorInit() {
    $validator(
        {form: "#step3 form", button: "#step3 button:last"},
        {name: {
            required: true,
            rangelength: [2, 100]
        }, password: {
            required: true,
            rangelength: [6, 500]
        }, passwordAgain: {
            required: true,
            equalTo: "#password"
        }, entName: {
            maxlength: 50
        }, mobile: {
            required: true,
            maxlength: 50
        }, fax: {
            rangelength: [0, 50]
        }
        },
        {},
        registerAsyfun,
        function (result) {
            if (result.code == 200) {
                $('#myTabs li:eq(3) a').tab('show');
                var suffix = $('#email').val().split("@")[1];
                $("#step4 span").html("***@"+suffix);
            } else {
                $alert(result.message);
            }
        })
}
function registerAsyfun() {
    var json = $('#step3 form').serializeObject();
    delete json["passwordAgain"];
    return json;
}