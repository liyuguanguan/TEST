/**
 * Created by zzy on 2017/4/12.
 * pjax
 */
var $ = require('jquery');
module.exports = function () {
    $.ajax({

    })
        .then(function(response) {
            // 我不确认是否都支持。
            history.replaceState && history.replaceState({}, document.title, href);
            $container.html(response);
        });
};

