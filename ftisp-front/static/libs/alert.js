/**
 * author zzy 2017-4-18
 */
require('bootstrap');
var modalTplFn = __inline('./_alert.tmpl');
var $ = require('jquery');

// errorLevel 至少支持 danger、info、sucess、warning
var alert = module.exports = function(content, errorLevel, title, confirmTxt) {
    var dom = $(modalTplFn({
        title: title || '提示信息',
        content: content,
        errorLevel: errorLevel || 'info',
        confirmTxt: confirmTxt || '确定'
    }));

    dom
        .appendTo('body')
        .modal({
            backdrop: 'static'
        })
        .on('hide.bs.modal', function() {
            dom.remove();
        });
};
