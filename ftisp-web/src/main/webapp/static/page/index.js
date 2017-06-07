define('page/index', ['require', 'exports', 'module', 'components/jquery/jquery', 'static/libs/alert'], function(require, exports, module) {

  /**
   * author zzy 2017-4-18
   */
  var $ = require('components/jquery/jquery');
  var $alert = require('static/libs/alert');
  $(function () {
      pageOnLoad();
      $(document).on('click','.news-headlines',function () {
          var id = $(this).data('id');
          window.location.href = "article-detail?id="+id;
      })
  });
  function pageOnLoad() {
      $('.service-cards a').mouseover(function () {
          $(this).addClass('animated pulse')
      });
      $('.service-cards a').mouseleave(function () {
          $(this).removeClass('animated pulse')
      });
      var option = {
          isHead: 1,
          page: 1,
          rows: 4
      };
      var callback = function (response) {
          showArticle(response);
      };
      articleAjax(option,callback);
  }
  function showArticle(response) {
      if(response.code == 200){
          var data = response.data;
          var html = "";
          html += "<p class='title1'>NEWS CENTER</p>"+
          "<p class='title2'>资讯中心</p>"+
              "<p class='title3'><small>服务于天津跨境电商外贸综合事业</small></p>";
          $.each(data.rows,function (index,obj) {
              var time = obj.releaseTime?new Date(obj.releaseTime).format("yyyy-MM-dd"):"";
              html += "<div class='news-headlines' data-id='"+obj.id+"'>"+
              "<p class='text-center'>"+obj.title+"</p>"+
              "<p class='date'><small>"+time+"</small></p>"+
                  "<div class='news-content-limit'><small>"+obj.summary+"</small></div>";
              if(obj.picturePath){
                  html += "<img src='"+obj.picturePath+"'>"+
                      "</div>";
              }else{
                  html += "<img style='display: none;' src='"+obj.picturePath+"'>"+
                      "</div>";
              }
          });
          $('#top-article').html(html);
      }else{
          $alert(response.message);
      }
  }
  function articleAjax(option,callback) {
      var defaultOption = {
          isHead: 0,
          page: 1,
          rows: 3
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