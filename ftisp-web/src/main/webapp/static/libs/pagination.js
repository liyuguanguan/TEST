define('static/libs/pagination', ['require', 'exports', 'module', 'components/bootstrap/bootstrap'], function(require, exports, module) {

  /**
   * author zzy 2017-4-18
   */
  require('components/bootstrap/bootstrap');
  $(document).on('click','.page-num',function () {
      $(this).parent('.pager').children().removeClass('active');
      $(this).addClass('active');
  });
  module.exports = function pagination(response,type){
      var data = response.data;
      var pageInfo = {
          page: data.page,
          count: data.count,
          total: data.total
      };
      var html = "";
      var totalNum = parseInt((pageInfo.total-1)/pageInfo.count)+1;
      var currentNum = pageInfo.page;
      var preNum = pageInfo.page-1;
      var nextNum = pageInfo.page+1;
      var startNum;
      var endNum;
      html += "<div class='page-num top' data-page='1' data-type='"+type+"'>首页</div>";
      /*if(preNum<1){
          html += "<div class='page-num top disabled'>首页</div>";
          //target.append("<li class='disabled'><a href='#'>&laquo;</a></li>");
      }else{
          html += "<div class='page-num top'>首页</div>";
          //target.append("<li><a href='#' onclick='newsList("+preNum+","+newstype+")'>&laquo;</a></li>");
      }*/
      if(totalNum<=5){
          if(totalNum<=0){
              html += "<div class='page-num active' data-page='1' data-type='"+type+"'>1</div>";
              //target.append("<li class='active'><a href='#'>1</a></li>");
          }else {
              for (var i = 1; i <= totalNum; i++) {
                  if (currentNum == i) {
                      html += "<div class='page-num active' data-page='"+i+"' data-type='"+type+"'>"+i+"</div>";
                      //target.append("<li class='active'><a href='#'>" + i + "</a></li>");
                  } else {
                      html += "<div class='page-num' data-page='"+i+"' data-type='"+type+"'>"+i+"</div>";
                      //target.append("<li><a href='#' onclick='newsList(" + i + "," + newstype + ")'>" + i + "</a></li>");
                  }
              }
          }
      }else{
          startNum = currentNum-2;
          endNum = currentNum+2;
          if(startNum<1){
              endNum = startNum+5;
              if(startNum<0){
                  endNum = startNum+6;
              }
              startNum = 1;
          }
          if(endNum>totalNum){
              startNum = endNum-5;
              if(endNum>totalNum+1){
                  startNum = endNum-6;
              }
              endNum = totalNum;
          }
          for(var j=startNum;j<=endNum;j++){
              if(currentNum==j){
                  html += "<div class='page-num active' data-page='"+j+"' data-type='"+type+"'>"+j+"</div>";
                  //target.append("<li class='active'><a href='#'>"+j+"</a></li>");
              }else{
                  html += "<div class='page-num' data-page='"+j+"' data-type='"+type+"'>"+j+"</div>";
                  //target.append("<li><a href='#'onclick='newsList("+j+","+newstype+")'>"+j+"</a></li>");
              }
          }
      }
      html += "<div class='page-num end' data-page='"+totalNum+"' data-type='"+type+"'>尾页</div>";
      /*if(nextNum>totalNum){
          html += "<div class='page-num end disabled'>尾页</div>";
          //target.append("<li class='disabled'><a href='#'>&raquo;</a></li>");
      }else{
          html += "<div class='page-num end'>尾页</div>";
          //target.append("<li><a href='#' onclick='newsList("+nextNum+","+newstype+")'>&raquo;</a></li>");
      }*/
      return html;
  };

});