define('page/article/article', ['require', 'exports', 'module', 'components/jquery/jquery', 'static/libs/alert', 'static/libs/pagination', 'static/libs/pager-fill', 'static/libs/article-fill'], function(require, exports, module) {

  /**
   * author zzy 2017-4-18
   */
  var $ = require('components/jquery/jquery');
  var $alert = require('static/libs/alert');
  var pagination = require('static/libs/pagination');
  //分页插件填充器
  var pagerFill = require('static/libs/pager-fill');
  //文章主体填充器
  var articleFill = require('static/libs/article-fill');//            contentType: "application/json; charset=utf-8",
  $(function () {
      //页面初始化
      pageOnLoad();
      sliderInit();
      //平台公告
      $('#notice').on('click',function (event) {
          var option = {
              type: 1,
              page: 1,
              rows: 4
          };
          var callback = function (response) {
              showArticle(response,"平台公告",true);
          };
          articleAjax(option,callback);
      });
      //更多公告
      $(document).on('click','#more-notice',function (event) {
          var option = {
              type: 1,
              page: 1,
              rows: 4
          };
          var callback = function (response) {
              showArticle(response,"平台公告",true);
          };
          articleAjax(option,callback);
      });
      //平台动态
      $('#news').on('click',function (event) {
          var option = {
              type: 2,
              page: 1,
              rows: 4
          };
          var callback = function (response) {
              showArticle(response,"平台动态",true);
          };
          articleAjax(option,callback);
      });
      //行业动态
      $('#industry').on('click',function (event) {
          var option = {
              type: 3,
              page: 1,
              rows: 4
          };
          var callback = function (response) {
              showArticle(response,"行业动态",true);
          };
          articleAjax(option,callback);
      });
      //行业知识库
      $('#knowledge').on('click',function (event) {
          var option = {
              type: 4,
              page: 1,
              rows: 4
          };
          var callback = function (response) {
              showArticle(response,"行业知识库",true);
          };
          articleAjax(option,callback);
      });
      //分页点击
      $(document).on('click','.page-num',function () {
          var option = {
              type: $(this).data('type'),
              page: $(this).data('page'),
              rows: 4
          };
          var type = $(this).data('type');
          if(type == 0){
              option = $.extend({},option,{isHead: 1})
          }
          var callback = function (response) {
              switch (type){
                  case 0: showMainArticle(response,"热点资讯",true);break;
                  case 1: showArticle(response,"平台公告",true);break;
                  case 2: showArticle(response,"平台动态",true);break;
                  case 3: showArticle(response,"行业动态",true);break;
                  case 4: showArticle(response,"行业知识库",true);break;
                  default: break;
              }
          };
          articleAjax(option,callback);
      });
      $('#article-category').on('click','.item',function () {
          $('#article-category').children().removeClass('active');
          $(this).addClass('active');
      })
  });
  function sliderInit() {
      $.ajax({
          url: 'api/v1/p/ftisp/unlogin/slider/picture',
          type: 'get',
          data: {
              num: 3,
              type: 'C'
          },
          dataType: 'json'
      })
          .done(function (response) {
              if(response.code == 200){
                  $('.main-pic').css('visibility','visible');
                  var data = response.data;
                  var $carousel = $('#carousel-example-generic .carousel-inner img');
                  $.each(data,function (i,o) {
                      $carousel.eq(i).attr('src',o.picturePath?o.picturePath:'');
                  })
              }else{
                  console.error('轮播图初始化失败');
              }
          })
  }
  function showArticle(response,title,first) {
      if(response.code == 200){
          var data = response.data;
          var articleHtml = "";
          var paginationHtml = "";
          $.each(data.rows,function (index,obj) {
              var time = obj.releaseTime?new Date(obj.releaseTime).format("yyyy-MM-dd"):"";
              articleHtml += "<div class='item'>"+
                  "<div class='one-pic'>"+
                  "<img src='"+obj.picturePath+"' alt='无图'>"+
                  "</div>"+
                  "<div class='right'>"+
                  "<a href='article-detail?id="+obj.id+"' class='title'>"+obj.title+"</a>"+
                  "<small class='date'>来自：";
              if(!obj.url){
                  console.log(1)
                  articleHtml += "<a href='javascript:;'>"+title+"</a>";
              }else{
                  console.log(2)
                  articleHtml += "<a href='javascript:;'>"+obj.url+"</a>";
              }
              articleHtml +=
                  "<small>"+time+"</small><small>日期：</small></small>"+
                  "<p class='summary'>"+obj.summary+
                  "</p>"+
                  "</div>"+
                  "</div>";
          });
          //history.replaceState && history.replaceState({type:1}, document.title, "/article/notice");
          articleFill(title,articleHtml,'#dynamic-block');
          if(first){
              paginationHtml += pagination(response,data.rows[0].type);
              pagerFill(paginationHtml,'#pagination');
          }
      }else{
          $alert(response.message);
      }
  }
  function articleAjax(option,callback) {
      var defaultOption = {
          isHead: 0,
          page: 1,
          rows: 4
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
  function pageOnLoad(){
      var option1 = {
          type: 1,
          page: 1,
          rows: 8
      };
      var callback1 = function (response) {
          showHotArticle(response,"最新公告",true);
      };
      articleAjax(option1,callback1);
      var option2 = {
          isHead: 1,
          page: 1,
          rows: 4
      };
      var callback2 = function (response) {
          showMainArticle(response,"热点资讯",true);
      };
      articleAjax(option2,callback2);
  }
  function showHotArticle(response,title,first) {
      if(response.code == 200){
          var data = response.data;
          var hotHtml = "";
          hotHtml += "<h4>最新公告</h4>";
          $.each(data.rows,function (index,obj) {
              var time = obj.releaseTime?new Date(obj.releaseTime).format("yyyy-MM-dd"):"";
              hotHtml += "<a class='item' href='article-detail?id="+obj.id+"'>"+obj.title+"<small>"+time+"</small></a>"
          });
          hotHtml += "<div class='hot-article-footer'>"+
          "<button id='more-notice' class='btn btn-default default-button-fix'>更多公告</button>"+
          "</div>";
          $('#hot-article').html(hotHtml);
      }else{
          $alert(response.message);
      }
  }
  function showMainArticle(response,title,first) {
      if(response.code == 200){
          var data = response.data;
          var mainHtml = "";
          var paginationHtml = "";
          mainHtml += "<h4>热点资讯</h4>"+
              "<div class='items'>";
          $.each(data.rows,function (index,obj) {
              var url = obj.url?obj.url:title;
              mainHtml += "<div class='item item-index'>"+
              "<div class='one-pic index'>"+
                  "<img src='"+obj.picturePath+"' alt='无图'>"+
                  "</div>"+
                  "<div class='index-right'>"+
                  "<a href='article-detail?id="+obj.id+"' class='title'>"+obj.title+"</a>"+
              "<small class='date'>来自：<a href='javascript:;'>"+url+"</a><small>"+new Date(obj.releaseTime).format("yyyy-MM-dd")+"</small><small>日期：</small></small>"+
              "<p class='summary'>"+
                  obj.summary+
              "</p>"+
              "</div>"+
              "</div>";
          });
          mainHtml += "</div></div>";
          $('#main-article').html(mainHtml);
          if(first){
              paginationHtml += pagination(response,0);
              pagerFill(paginationHtml,'#pagination');
          }
      }else{
          $alert(response.message);
      }
  }

});