define('static/libs/article-fill', ['require', 'exports', 'module', 'components/bootstrap/bootstrap', 'components/jquery/jquery'], function(require, exports, module) {

  /**
   * author zzy 2017-4-18
   */
  require('components/bootstrap/bootstrap');
  var modalTplFn = function(obj){
var __t,__p='',__j=Array.prototype.join,print=function(){__p+=__j.call(arguments,'');};
with(obj||{}){
__p+='<div class="main-article-row">\r\n    <h4>'+
((__t=( title ))==null?'':__t)+
'</h4>\r\n    <div class="items">\r\n        '+
((__t=( article ))==null?'':__t)+
'\r\n    </div>\r\n</div>';
}
return __p;
};
  var $ = require('components/jquery/jquery');
  
  var articleFill = module.exports = function(title, article, target) {
      var dom = $(modalTplFn({
          title: title,
          article: article
      }));
  
      $(target).html(dom);
  };
  

});