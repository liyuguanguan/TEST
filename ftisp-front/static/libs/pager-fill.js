/**
 * author zzy 2017-4-18
 */
require('bootstrap');
var modalTplFn = __inline('./_pager.tmpl');
var $ = require('jquery');

var pagerFill = module.exports = function(pagination, target) {
    var dom = $(modalTplFn({
        pagination: pagination
    }));

    $(target).html(dom);
};
