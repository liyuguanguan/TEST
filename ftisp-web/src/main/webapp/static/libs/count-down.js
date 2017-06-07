define('static/libs/count-down', ['require', 'exports', 'module', 'components/jquery/jquery'], function(require, exports, module) {

  /**
   * author csy,zzy 2017-4-18
   * 邮箱发送倒计时
   */
  var $ = require('components/jquery/jquery');
  module.exports = function ($button,maxCount) {
      var $span = $button.find('span:first');
      var count = maxCount||60;
      var _res = setInterval(function()
      {
          $button.attr("disabled", true);
          $span.text("("+count+")");
          if(count <= 0){
              $span.text("");
              $button.removeAttr("disabled");
              clearInterval(_res);
          }
          count--;
      },1000);
  };

});