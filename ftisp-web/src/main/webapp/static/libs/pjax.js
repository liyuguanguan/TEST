define('static/libs/pjax', ['require', 'exports', 'module', 'components/jquery/jquery'], function(require, exports, module) {

  /**
   * Created by zzy on 2017/4/12.
   * pjax
   */
  var $ = require('components/jquery/jquery');
  module.exports = function () {
      $.ajax({
  
      })
          .then(function(response) {
              // 我不确认是否都支持。
              history.replaceState && history.replaceState({}, document.title, href);
              $container.html(response);
          });
  };
  
  

});