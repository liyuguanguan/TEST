/**
 * author zzy 2017-4-18
 */
var $ = require('jquery');
var $alert = require('libs/alert');
var articleId;
require(["ueditor","ueditor/ueditor.config"],function () {
    var zeroClipboard = require('ueditor/third-party/zeroclipboard/ZeroClipboard');
    window.ZeroClipboard = zeroClipboard;
    UE.getEditor('editor',{readonly:true});
});
$(function () {
    pageOnLoad();
});
function pageOnLoad() {
    articleId = $.getUrlParam('id');
    $.ajax({
        url:'api/v1/p/ftisp/manage/article/load',
        type:'get',
        data:{
            id:articleId
        },
        dataType:'json',
        success:function (response) {
            if(response.code == 200){
                var data = response.data;
                categoryInit(data.category);
                typeInit(data.category,data.type+'');
                formInit(data);
            }else{
                $alert(response.message);
            }
        }
    })
}
function categoryInit(k) {
    $("#category").val(k);
}
function typeInit(parentId,k) {
    $("#type").val(k);
}
function formInit(data) {
    if(data.picturePath){
        $(".file-view").attr("src",data.picturePath);
    }
    if(data.isHead == 1){
        $("#is-head").attr("checked","checked");
    }else{
        $("#is-head").attr("checked",false);
    }
    $("#title").val(data.title);
    $("#url").val(data.url);
    $("#auther").val(data.auther);
    $("#summary").val(data.summary);
    $("#editor").html(data.content);
}