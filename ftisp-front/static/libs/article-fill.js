/**
 * author zzy 2017-4-18
 */
require('bootstrap');
var modalTplFn = __inline('./_article.tmpl');
var $ = require('jquery');

var articleFill = module.exports = function(title, article, target) {
    var dom = $(modalTplFn({
        title: title,
        article: article
    }));

    $(target).html(dom);
};
