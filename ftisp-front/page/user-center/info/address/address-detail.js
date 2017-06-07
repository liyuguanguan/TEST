/**
 * author zzy 2017-4-18
 */
var $ = require('jquery');
var $alert = require('libs/alert');
var $confirm = require('libs/confirm');
$(function () {
    isAddOrUpdate();
    $("#address_back").on("click",function () {
        window.history.go(-1);
    });
    $("#address_form input").attr("disabled","true");
    $("#address_form select").attr("disabled","true");
});
//判断地址更新
function isAddOrUpdate() {
    var url =window.location.href;
    if(url.indexOf("id=")>0){
        var i = url.indexOf("id=");
        var id = url.substr(i+3,url.length);
        loadAddress(id);
    }
}

//load address
function loadAddress(id) {
    $.ajax({
        url:'api/v1/p/ftisp/address/load',
        type:'post',
        data:{
            id:id
        },
        dataType:'json',
        success:function (result) {
            if(result.code == 200){
                $("#address_form").setForm(result.data);
            }else{
                $alert(result.message);
            }
        }
    })
}