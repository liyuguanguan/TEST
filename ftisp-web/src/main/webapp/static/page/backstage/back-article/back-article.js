define('page/backstage/back-article/back-article', ['require', 'exports', 'module', 'components/jquery/jquery', 'static/libs/confirm', 'static/libs/alert', 'static/libs/table-init'], function(require, exports, module) {

  var $ = require('components/jquery/jquery');
  var $confirm = require('static/libs/confirm');
  var $alert = require('static/libs/alert');
  var tableSetting = require('static/libs/table-init');
  var table;
  $(function () {
      tableinit();
      $('#search').on('click',function (event) {
          event.preventDefault();
          table.draw();
      });
      $(document).on("click","a[name=release]",function(){
          var id = $(this).data('id');
          $.ajax({
              url:"api/v1/p/ftisp/manage/article/release",
              type:"post",
              dataType:"json",
              data:{
                  id:id
              },
              success:function (response) {
                  if(response.code=="200") {
                      $alert("发布成功!");
                      table.draw(false);
                  }else{
                      $alert(response.message);
                  }
              }
          })
      });
      $(document).on("click","a[name=delete]",function(){
          var id = $(this).data('id');
          $.ajax({
              url:"api/v1/p/ftisp/manage/article/delete",
              type:"post",
              dataType:"json",
              data:{
                  idStr:id
              },
              success:function (response) {
                  if(response.code=="200") {
                      $alert("删除成功!");
                      table.draw(false);
                  }else{
                      $alert(response.message);
                  }
              }
          })
      });
  });
  function tableinit() {
      table = $('#main-table').DataTable(
          $.extend({},tableSetting,{
              ajax: {
                  url: "api/v1/p/ftisp/manage/article/list",
                  data: function ( d ) {
                      var start = d.start;
                      var length = d.length;
                      d.title = $('#title').val();
                      d.isHead = $('#level').val();
                      d.page = start/length+1;
                      d.rows = length;
                  },
                  dataSrc: function (res) {
                      var obj = {};
                      if(res.code == 200){
                          $.extend(res, {
                              recordsTotal: res.data.total,
                              recordsFiltered: res.data.total
                          });
                          return res.data.rows;
                      }else{
                          return [];
                      }
                  }
              },
              columns: [
                  { data: null},
                  { data: null},
                  { data: "title"},
                  { data: "type"},
                  { data: "createdDt"},
                  { data: "releaseTime"},
                  { data: "stat"},
                  { data: null}
              ],
              columnDefs: [ {
                  targets: 1,
                  searchable: false,
                  render: function(data, type, full) { // 返回自定义内容
                      return "<input type='checkbox' name='checked'>";
                  }
              },{
                  targets:2 ,
                  render:function (data,type,full) {
                      return "<a href='back-article-detail?id="+full.id+"' name='detail'>"+data+"</a>";
                  }
              },{
                  targets:3 ,
                  render:function (data,type,full) {
                      switch (full.type){
                          case 1:
                              return "平台公告";
                          case 2:
                              return "平台动态";
                          case 3:
                              return "行业动态";
                          case 4:
                              return "行业知识库";
                          default:
                              return "";
                      }
                  }
              },{
                  targets:6 ,
                  render:function (data,type,full) {
                      switch (full.stat){
                          case '1':
                              return "已发布";
                          case '2':
                              return "未发布";
                          default:
                              return "";
                      }
                  }
              },{
                  targets: 7,
                  searchable: false,
                  render: function(data, type, full) { // 返回自定义内容
                      switch (full.stat){
                          case '2':
                              return "<a href='javascript:;' class='btn btn-default' data-id='"+full.id+"' name='release'>发布</a>&nbsp;<a href='back-article-add?id="+full.id+"' class='btn btn-default' name='edit'>编辑</a>&nbsp;<a href='javascript:;' class='btn btn-default' data-id='"+full.id+"' name='delete'>删除</a>";
                          default:
                              return "<a href='back-article-add?id="+full.id+"' class='btn btn-default' name='edit'>编辑</a>&nbsp;<a href='javascript:;' class='btn btn-default' data-id='"+full.id+"' name='delete'>删除</a>";
                      }
                  }
              }]
          })
      )
  }

});