define('page/backstage/back-article/back-article-add', ['require', 'exports', 'module', 'components/jquery/jquery', 'static/libs/validator', 'static/libs/alert', 'static/libs/confirm', 'static/modules/ueditor/third-party/zeroclipboard/ZeroClipboard'], function(require, exports, module) {

  /**
   * author zzy 2017-4-18
   */
  var $ = require('components/jquery/jquery');
  var $validator = require('static/libs/validator');
  var $alert = require('static/libs/alert');
  var $confirm = require('static/libs/confirm');
  var defaultPic;
  var isUpdate;
  var articleId;
  var hasPic;
  require(["static/modules/ueditor/ueditor.all","static/modules/ueditor/ueditor.config"],function () {
      var zeroClipboard = require('static/modules/ueditor/third-party/zeroclipboard/ZeroClipboard');
      window.ZeroClipboard = zeroClipboard;
      UE.getEditor('editor');
  });
  $(function () {
      isUpdate = window.location.href.indexOf('id=')>0;
      if(isUpdate){
          $('#main_form').attr('action','api/v1/p/ftisp/manage/article/update');
          $('.title').text('文章修改');
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
      uploadFileInit();
      validatorInit();
      $("#submit").on("click",function () {
          $("#main_form").submit();
      });
  });
  function categoryInit(k) {
      $("#category").val(k);
  }
  function typeInit(parentId,k) {
      $("#type").val(k);
  }
  function formInit(data) {
      if(data.picturePath==null||data.picturePath==''){
          hasPic = 'N';
      }else{
          $(".file-view").attr("src",data.picturePath);
          hasPic = 'Y';
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
  function uploadFileInit() {
      var $fileView = $('.file-view');
      var $fileUpload = $('.file-upload');
      var $fileCancel = $('#file-cancel');
      var topPic = $('#one-pic');
      defaultPic = $fileView.attr('src');
      topPic.on('change',function () {
          var file = this.files[0];
          var url = createObjectURL(file);
          $fileView.attr('src',url);
          if(url != defaultPic){
              hasPic = 'Y';
          }
      });
      $fileUpload.mouseover(function () {
          var flag = $fileView.attr('src')!=''&&$fileView.attr('src').indexOf('add_ftisp')==-1;
          if(flag){
              $fileCancel.addClass('file-cancel');
          }
      });
      $fileUpload.mouseleave(function () {
          $fileCancel.removeClass('file-cancel');
      });
      $fileUpload.on('click','.file-cancel',function () {
          topPic.val('');
          $fileView.attr('src',defaultPic);
          $fileCancel.removeClass('file-cancel');
          hasPic = 'N';
      })
  }
  function createObjectURL(blob){
      return window[window.webkitURL ? 'webkitURL' : 'URL']['createObjectURL'](blob);
  }
  function validatorInit() {
      $validator({
          form: "#main_form",button: '#submit',pic: 'one-pic'
      },{
          title:{required:true}
      },{
          title:{required:'标题不能为空'}
      },function () {
          if(!isHeadValidate()){
              return false;
          }
          var title = $('#title').val();
          var isHead = $('#is-head').val();
          var url = $('#url').val();
          var auther = $('#auther').val();
          var summary = $('#summary').val();
          var category = $('#category').val();
          var type = $('#type').val();
          var content = UE.getEditor('editor').getContent();
          //将“替换为~
          content = content.replace(/"/gm,'~');
          var data = {
              title: title,
              isHead: isHead,
              url: url,
              auther: auther,
              summary: summary,
              category: category,
              type: type,
              content: content
          };
          if(isUpdate){
              data.hasPic = hasPic;
              data.id = articleId;
          }
          return data;
      },function (response) {
          if(response.code == 200){
              window.location.href = "back-article";
          }else{
              $alert(response.message);
          }
      })
  }
  //判断是否为头条新闻
  function isHeadValidate(){
      var $fileView = $('.file-view');
      var $isHead = $('#is-head');
      var pic = $fileView.attr("src");
      if($isHead.is(':checked')){
          $isHead.val("1");
      }else{
          $isHead.val("0");
      }
      if($isHead.val()=="1"){
          if($fileView.attr("src")==defaultPic){
              $alert('头条必须有版图');
              return false;
          }
      }
      return true;
  }

});