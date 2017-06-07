define('static/libs/pager-fill', ['require', 'exports', 'module', 'components/bootstrap/bootstrap', 'components/jquery/jquery'], function(require, exports, module) {

  /**
   * author zzy 2017-4-18
   */
  require('components/bootstrap/bootstrap');
  var modalTplFn = function(obj){
var __t,__p='',__j=Array.prototype.join,print=function(){__p+=__j.call(arguments,'');};
with(obj||{}){
__p+=''+
((__t=( pagination ))==null?'':__t)+
'';
}
return __p;
};
  var $ = require('components/jquery/jquery');
  
  var pagerFill = module.exports = function(pagination, target) {
      var dom = $(modalTplFn({
          pagination: pagination
      }));
  
      $(target).html(dom);
  };
  

});