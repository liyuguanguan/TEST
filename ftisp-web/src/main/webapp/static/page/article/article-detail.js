define('page/article/article-detail', ['require', 'exports', 'module', 'components/jquery/jquery', 'static/libs/alert'], function(require, exports, module) {

  /**
   * author zzy 2017-4-18
   */
  var $ = require('components/jquery/jquery');
  var $alert = require('static/libs/alert');
  $(function () {
      pageOnLoad();
  });
  function pageOnLoad() {
      var articleId = $.getUrlParam('id');
      var option1 = {
          id: articleId
      };
      var callback1 = function (response) {
          showDetail(response);
      };
      detailAjax(option1,callback1);
      var option2 = {
          isHead: 1,
          page: 1,
          row: 8
      };
      var callback2 = function (response) {
          showTopArticle(response);
      };
      articleAjax(option2,callback2);
  }
  function showDetail(response) {
      if(response.code == 200){
          var data = response.data;
          var type = data.type;
          switch (type){
              case 1: $('#categary').text('平台公告');break;
              case 2: $('#categary').text('平台动态');break;
              case 3: $('#categary').text('行业动态');break;
              case 4: $('#categary').text('行业知识库');break;
              default: break;
          }
          $('#title').text(data.title);
          $('#article-from').text(data.url);
          $('#date').text(data.releaseTime?new Date(data.releaseTime).format("yyyy-MM-dd"):"");
          $('#content').html(data.content);
      }else{
          $alert(response.message);
      }
  }
  function showTopArticle(response) {
      if(response.code == 200){
          var data = response.data;
          var html = "";
          $.each(data.rows,function (index,obj) {
              html += "<li><p><a href='article-detail?id="+obj.id+"'>"+obj.title+"</a></p></li>"
          });
          $('#top-article').html(html);
      }else{
          $alert(response.message);
      }
  }
  function detailAjax(option,callback) {
      $.ajax({
          url:'api/v1/p/ftisp/unlogin/article/load',
          type:'get',
          data: option,
          dataType:'json'
      })
          .done(function(response) {
              callback(response);
          });
  }
  function articleAjax(option,callback) {
      var defaultOption = {
          isHead: 0,
          page: 1,
          row: 3
      };
      option = $.extend({},defaultOption,option);
      $.ajax({
          url:'api/v1/p/ftisp/unlogin/article/list',
          type:'get',
          data: option,
          dataType:'json'
      })
          .done(function(response) {
              callback(response);
          });
  }

});