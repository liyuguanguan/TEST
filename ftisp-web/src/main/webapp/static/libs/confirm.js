define('static/libs/confirm', ['require', 'exports', 'module', 'components/bootstrap/bootstrap', 'components/jquery/jquery'], function(require, exports, module) {

  /**
   * author zzy 2017-4-18
   */
  require('components/bootstrap/bootstrap');
  var modalTplFn = function(obj){
var __t,__p='',__j=Array.prototype.join,print=function(){__p+=__j.call(arguments,'');};
with(obj||{}){
__p+='<div class="modal fade" role="dialog" aria-labelledby="exampleModalLabel">\r\n  <div class="modal-dialog" role="document">\r\n    <div class="modal-content">\r\n      <div class="modal-header">\r\n        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>\r\n        <h4 class="modal-title" id="exampleModalLabel">'+
((__t=( title ))==null?'':__t)+
'</h4>\r\n      </div>\r\n      <div class="modal-body">\r\n        <p>'+
((__t=( content ))==null?'':__t)+
'</p>\r\n      </div>\r\n      <div class="modal-footer">\r\n        <button type="button" class="btn btn-default" data-dismiss="modal">'+
((__t=( cancelTxt ))==null?'':__t)+
'</button>\r\n        <button type="button" class="btn btn-primary">'+
((__t=( confirmTxt ))==null?'':__t)+
'</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n';
}
return __p;
};
  var noop = function() {};
  var $ = require('components/jquery/jquery');
  var defaultOptions = {
      title: '',
      confirmed: noop,
      canceled: noop,
      confirmTxt: '确认',
      cancelTxt: '取消'
  }
  
  var confirm = module.exports = function(content, opt) {
      if (typeof opt === 'function') {
          opt = {
              confirmed: opt
          };
      }
  
      opt = $.extend({}, defaultOptions, opt);
  
      var dom = $(modalTplFn({
          content: content,
          title: opt.title || '提示信息',
          confirmTxt: opt.confirmTxt,
          cancelTxt: opt.cancelTxt
      }));
  
      dom
          .appendTo('body')
          .on('click', '.btn-primary', function() {
              opt.confirmed.apply(this, arguments);
              dom.modal('hide');
          })
          .on('click', '.btn-default', opt.canceled)
          .modal({
              backdrop: 'static'
          })
          .on('hide.bs.modal', function() {
              dom.remove();
          });
  };
  

});