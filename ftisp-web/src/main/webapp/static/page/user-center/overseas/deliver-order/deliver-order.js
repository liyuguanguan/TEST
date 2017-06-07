define('page/user-center/overseas/deliver-order/deliver-order', ['require', 'exports', 'module', 'components/jquery/jquery', "static/modules/uploadify/jquery.uploadify", 'static/libs/confirm', 'static/modules/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN', 'static/libs/alert', 'static/libs/table-init', 'static/libs/validator'], function(require, exports, module) {

  /**
   * author zzy 2017-4-18
   */
  var $ = require('components/jquery/jquery');
  require ("static/modules/uploadify/jquery.uploadify");
  var $confirm = require('static/libs/confirm');
  require('static/modules/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN');
  var $alert = require('static/libs/alert');
  var tableSetting = require('static/libs/table-init');
  var table;
  var $validator = require('static/libs/validator');
  $(function () {
      warehouseinit();
      uploadinit();
      tableinit();
      $("span.form_date").datetimepicker({
          format: "yyyy-mm-dd",
          language: 'zh-CN',
          autoclose: true,
          todayBtn: true,
          minView :2,
          pickerPosition: "bottom-left"
      });
      $("span.form_date span.delete").on("click",function () {
          $(this).prev("input").val("");
      });
      //checkbox全选
      $("#checkAll").on("click", function () {
          if ($(this).prop("checked") === true) {
              $("input[name='checkList']").prop("checked", $(this).prop("checked"));
              $('#main-table tbody tr').addClass('selected');
          } else {
              $("input[name='checkList']").prop("checked", false);
              $('#main-table tbody tr').removeClass('selected');
          }
      });
  
      $("#main-table").on("click","input[type=checkbox]",function () {
          var $this =  $(this);
          if($this.prop("checked")){
              $this.parent().parent().addClass('selected');
          }else {
              $this.parent().parent().removeClass('selected');
          }
      });
      //删除提交订单
      $("#main-table").on("click",'a[name=commit]',function () {
          var selectData =  table.row($(this).parents("tr")).data();
          if($(this).attr("name") == 'delete'){
              updateRow(0,selectData.id);
          }else{
              updateRow(1,selectData.id);
          }
      });
      $("#main-table").on("click",'a[name=delete]',function () {
          var selectData =  table.row($(this).parents("tr")).data();
          if($(this).attr("name") == 'delete'){
              updateRow(0,selectData.id);
          }else{
              updateRow(1,selectData.id);
          }
      });
      //查询
      $("#search").on('click',function (event) {
          event.preventDefault();
          table.draw(true);
      });
      //批量提交
      $("#bundle-submit").on("click",function () {
          var selectRow = table.rows('.selected').data(); //得到被选中的数据
          if (selectRow.length == 0){
              $alert("请选择要提交的订单");
          }else{
              var flag = true;
              $.each(selectRow,function (index,obj) {
                  if(obj.status!="uncommit"){
                      flag = false;
                      return false;
                  }
              });
              if(flag==false){
                  $alert("只能提交未提交的订单");
              }else{
                  $confirm("确认提交选择订单吗？",function () {
                      var ids =getSelectIds(selectRow);
                      $.ajax({
                          url:'api/v1/p/ftisp/outRoomOrder/commit',
                          type:'post',
                          contentType: "application/json; charset=utf-8",
                          data:JSON.stringify(ids),
                          dataType:'json',
                          success:function (result) {
                              if(result.code!='200'){
                                  $alert(result.message);
                              }else{
                                  $alert("提交成功")
                                  table.draw(false);
                              }
                          }
                      });
                  });
              }
          }
      });
      //批量导出
      $("#bundle-export").on("click",function () {
          var selectRow = table.rows('.selected').data(); //得到被选中的数据
          if (selectRow.length == 0){
              $confirm("确认导出所有订单吗?",function () {
                  var $form  = $("#search-form");
                  $form.find("input[name=jsonString]").val("ALL");
                  $form.attr("action" ,'api/v1/p/ftisp/outRoomOrder/export')
                  $form.submit();
                  $form.find("input[name=jsonString]").val('');
              });
          }else{
              $confirm("确认导出选择订单吗?",function () {
                  var ids =getSelectIds(selectRow);
                  var $form  = $("#search-form");
                  $form.find("input[name=jsonString]").val(JSON.stringify(ids));
                  $form.attr("action" ,'api/v1/p/ftisp/outRoomOrder/export')
                  $form.submit();
                  $form.find("input[name=jsonString]").val('');
              });
          }
      });
  });
  //删除或提交 默认提交 type 0删除
  function updateRow( type,id) {
      var url = type == 0?"api/v1/p/ftisp/outRoomOrder/delete":"api/v1/p/ftisp/outRoomOrder/commit";
      var confirmTxt = type == 0?"确定删除该订单吗？":"确定提交该订单吗？";
      $confirm(confirmTxt,function () {
          var data = [];
          data.push({"id":id});
          $.ajax({
              url:url,
              type:'post',
              contentType: "application/json; charset=utf-8",
              data:JSON.stringify(data),
              dataType:'json',
              success:function (result) {
                  if(result.code == 200){
                      table.draw(false);
                  }else{
                      $alert(result.message);
                  }
              }
          })
      });
  }
  function getSelectIds(selectRow) {
      var ids = [];
      $.each(selectRow,function (index,obj) {
          ids.push({"id":obj.id})
      });
      return ids;
  }
  function warehouseinit() {
      var url = "api/v1/p/ftisp/warehouse/query";
      $.ajax({
          url:url,
          type:'post',
          data:{
              warehouseType:'DEST'
          },
          dataType:'json',
          success:function (result) {
              if(result.code == 200){
                  $('#warehouseId').text('');
                  $('#warehouseId').append("<option value=''>请选择</option>");
                  $.each(result.data,function (index, obj) {
                      $('#warehouseId').append("<option value='"+obj.warehouseId+"'>"+obj.warehouseName+"</option>");
                  })
              }else{
                  $alert(result.message);
              }
          }
      })
  }
  //表格初始化
  function tableinit() {
      table = $('#main-table').DataTable(
          $.extend({},tableSetting,{
              ajax: {
                  url: "api/v1/p/ftisp/outRoomOrder/list",
                  data: function ( d ) {
                      var start = d.start;
                      var length = d.length;
                      var orderNoArr = $('#orderNo').val().split(',');
                      if(orderNoArr.length>30){
                          $alert("订单号最多30条");
                          return false;
                      }
                      d.orderNo = $('#orderNo').val();
                      d.warehouseId = $('#warehouseId').val();
                      d.platType = $('#platType').val();
                      d.status = $('#status').val();
                      d.page = start/length+1;
                      d.rows = length;
                      d.sort = "a.create_dt";
                      d.order = "desc";
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
                  { data: "orderNo"},
                  { data: "warehouseName"},
                  { data: "platType"},
                  { data: "recipientName"},
                  { data: "deliveryWayName"},
                  { data: "deliveryCode"},
                  { data: "status"},
                  { data: "createDt"},
                  { data: "outroomDate"},
                  { data: "deliveryWeight"},
                  { data: null}
              ],
              columnDefs: [ {
                  targets: 1,
                  searchable: false,
                  render: function(data, type, full) {
                      return "<input type='checkbox' name='checkList'>";
                  }
              },
                  {
                      targets: 2,
                      render: function(data, type, full) {
                          return "<a href='deliver-order-detail?id="+full.id+"'>"+data+"</a>";
                      }
                  },
                  {
                      targets: 5,
                      render: function(data, type, full) {
                          return data.replace('-',' ');
                      }
                  },
                  {
                      targets: 8,
                      render: function(data, type, full) {
                          switch (full.status){
                              case 'uncommit':
                                  return '未提交';
                              case 'commit':
                                  return '已提交';
                              case 'pick':
                                  return '已拣货';
                              case 'pack':
                                  return '已打包';
                              case 'weight':
                                  return '已称重';
                              case 'outroom':
                                  return '已出库';
                              case 'outstock':
                                  return '缺货';
                              default:
                                  return '';
                          }
                      }
                  },
                  {
                      targets: 12,
                      searchable: false,
                      render:function (data,type,full) {
                          switch (full.status){
                              case 'uncommit':
                                  return "<a class='btn btn-default' href='javascript:;' name='commit'><i class='glyphicon glyphicon-pencil'></i>提交</a><br><a class='btn btn-default' href='deliver-order-update?id="+full.id+"' name='edit'><i class='glyphicon glyphicon-pencil'></i>修改</a><br><a class='btn btn-default' href='javascript:;' name='delete'><i class='glyphicon glyphicon-remove'></i>删除</a>";
                              default:
                                  return '';
                          }
                      }
                  }]
          })
       )
  }
  //upload初始化
  function uploadinit() {
      $("#uploadify").uploadify({
          'uploader' : 'api/v1/p/ftisp/outRoomOrder/import',
          'fileObjName':'Filedata',
          'method':'post',
          'swf' : 'static/modules/uploadify/uploadify.swf',
          'queueID' : 'fileQueue',//与下面的id对应
          'queueSizeLimit' : 5,
          'fileTypeDesc' : '请选择xls和xlsx',
          'fileTypeExts' : '*.xls;*.xlsx', //控制可上传文件的扩展名，启用本项时需同时声明fileDesc
          'auto' : false,
          'multi' : true,
          'simUploadLimit' : 2,
          'buttonText' : '选择文件',
          'fileSizeLimit' : '10MB',
          'onUploadSuccess':function(file, data, response){
              var obj = JSON.parse(data);
              if(obj.code == 201){
                  $alert(obj.message);
                  window.open("api/v1/p/ftisp/fileoper/download?id="+obj.data.id);
              }else if(obj.code ==200){
                  $alert("导入成功!");
              }else{
                  $alert(obj.message);
              }
              table.draw(false);
          }
      });
  }

});