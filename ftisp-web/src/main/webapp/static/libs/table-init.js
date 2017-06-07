define('static/libs/table-init', ['require', 'exports', 'module'], function(require, exports, module) {

  /**
   * author zzy 2017-4-18
   */
  module.exports = {
      dom: "<'row row-fix'<'col-xs-3 length-fix'l><'col-xs-9 paginate-fix'p>>rt<'row row-fix'<'col-xs-3 length-fix'l><'col-xs-9 paginate-fix'p>>",
      lengthMenu: [[10, 25, 50], [10, 25, 50]],
      pagingType: "simple_numbers",
      ordering: false,
      scrollX: true,
      serverSide: true,
      language: {
          lengthMenu: "显示 _MENU_ 记录",
          zeroRecords: "<div style='text-align: center'>对不起，查询不到任何相关数据</div>",
          paginate: {
              first: "首页",
              previous: " 上一页 ",
              next: " 下一页 ",
              last: " 尾页 "
          }
      },
      drawCallback: function( settings ) {
          var api = this.api();
          var startIndex= api.context[0]._iDisplayStart;//获取到本页开始的条数
          api.column(0).nodes().each(function(cell, i) {
              cell.innerHTML = startIndex + i + 1;
          });
      }
  };

});