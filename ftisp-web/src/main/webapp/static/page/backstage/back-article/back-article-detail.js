define('page/backstage/back-article/back-article-detail', ['require', 'exports', 'module', 'components/jquery/jquery', 'static/libs/alert', 'static/modules/ueditor/third-party/zeroclipboard/ZeroClipboard'], function(require, exports, module) {

  /**
   * author zzy 2017-4-18
   */
  var $ = require('components/jquery/jquery');
  var $alert = require('static/libs/alert');
  var articleId;
  require(["static/modules/ueditor/ueditor.all","static/modules/ueditor/ueditor.config"],function () {
      var zeroClipboard = require('static/modules/ueditor/third-party/zeroclipboard/ZeroClipboard');
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

});