define('page/user-center/domestic/in-order/in-order-add', ['require', 'exports', 'module', "components/jquery/jquery", 'static/modules/uploadify/jquery.uploadify', 'static/libs/alert', 'static/libs/validator', 'static/modules/bootstrap-datetimepicker/bootstrap-datetimepicker.min', 'static/modules/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN', 'static/libs/bootstrap-typeahead'], function(require, exports, module) {

  /**
   * Created by csy on 2017/4/25.
   */
  require("components/jquery/jquery");
  require('static/modules/uploadify/jquery.uploadify');
  var $alert = require('static/libs/alert');
  var $form = require('static/libs/validator');
  require('static/modules/bootstrap-datetimepicker/bootstrap-datetimepicker.min');
  require('static/modules/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN')
  require('static/libs/bootstrap-typeahead')
  var table;
  var estimateTable;
  var isEstimate = false;
  var isSave = false;
  $(function () {
      estimateTableInit([]);
      isAddOrUpdate();
      formValidationinit();
      uploadinit();
      //返回
      $('#instoreAdd_back').on('click',function () {
          window.history.back();
      });
      //地址
      $('.tag-select .tag-select-btn').click(function () {
          $(this).next('.tag-select-box').fadeIn();
      });
      $('.tag-select-box .colsed').click(function () {
          $(this).parents('.tag-select-box').fadeOut();
      });
      //提交按钮
      $('#submit_form').on('click',function () {
          if($("#totalBox").html()==0){
              $alert("请先添加商品");
              return false;
          }
          isEstimate=false;
          isSave = true;
          $("#instore_form").submit();
      });
      //预估费用按钮
      $('#fee_estimate').on('click',function () {
          if($("#totalBox").html()==0){
              $alert("请先添加商品");
              return false;
          }
          estimateTable.rows('tr').remove();
  
          isEstimate=true;
          $("#instore_form").submit();
      });
      $('#instoreAdd_add').on('click',function () {
          if($("#totalBox").html()==0){
              $alert("请先添加商品");
              return false;
          }
          $("#instore_form").submit();
      });
      //物流产品 select添加数据
      $("#instore_form select[name=logisticsId]").on("change",function () {
          if(this.value!=''){
              appendOption('api/v1/p/ftisp/warehouse/query',{logisticsId:this.value,warehouseType:'INSJ'}
                  ,$("#instore_form select[name=collectWarehouseId]"));
          }
      });
      $("#instore_form select[name=collectWarehouseId]").on('change',function () {
          if(this.value!=''){
              var data = {logisticsId:$("#instore_form select[name=logisticsId]").val(),warehouseType:'DEST',inspectionWarehouseCode:this.value}
              appendOption('api/v1/p/ftisp/warehouse/query',data,$("#instore_form select[name=toWarehouseId]"));
          }
      });
      $("#instore_form select[name=toWarehouseId]").on("change",function () {
          if(this.value!=''){
              var data = {logisticsId:$("#instore_form select[name=logisticsId]").val(),
                  fromWarehouseId:$('#instore_form select[name=collectWarehouseId]').val(),
                  toWarehouseId:this.value}
              appendOption('api/v1/p/ftisp/logisticsChannelPlan/queryOption',data,$("#instore_form select[name=logisticsPlanId]"));
          }
      });
      $("#instore_form select[name=toWarehouseId]").on("change",function () {
          if(this.value!=''){
              var data = {
                  type:'I',
                  warehouseId:this.value}
              appendOption('api/v1/p/ftisp/merchant/query',data,$("#instore_form select[name=importerId]"));
          }else{
              $("#instore_form select[name=importerId]").html('<option value="">请选择</option>');
          }
      });
      //增加详情
      $('#instoreAdd_table').on('click', 'td span.row-details',function() {
          var $this = $(this);
          var selectData = table.row($this.parents("tr")).data();
          if ($this.hasClass('row-details-close')) //判断是否已打开
          {
              $this.removeClass('row-details-close');
              $this.addClass('row-details-open');
              $this.parents('tr').after(appendDetail(selectData));
          } else {
              $this.parents('tr').next("tr").remove();
              $this.removeClass('row-details-open');
              $this.addClass('row-details-close');
          }
      });
      //删除包裹
      $("#instoreAdd_table").on("click",'a[name=delete]',function () {
          var $this = $(this);
          var selectData = table.row($this.parents("tr")).data();
          $("#totalGoods").html( $("#totalGoods").html()-selectData.goods.length);
          table.row($this.parents("tr")).remove().draw();
          $("#totalBox").html(table.data().length);
      })
      //商品添加框
      $("#autocomplete").typeahead({
          source:function (query, process){
              $.post("api/v1/p/ftisp/goods/query", {
                  query : query,
                  toWarehouseId:$("#instore_form select[name=toWarehouseId]").val()
              }, function (result) {
                  if(result.code==200){
                      var data = [];
                      $.each(result.data,function (index,obj) {
                          data.push(obj.goodsCode+"-"+obj.goodsName);
                      })
                      process(data);
                  }
              });
          },
          items: 15,
          updater:function (item) {
              appendGoods(item);
              return '';
          },
          delay: 800 //延迟时间
      });
      //添加表单校验
      formGoodsInit();
      //添加一个商品
      $('#tableAdd_form button:first').on('click',function () {
          if($("#tableAdd_form tbody tr").length==0){
              var span = "<span class='error' id='goodsCode-error'>请添加审核通过的商品</span>";
              $("#autocomplete").parent().parent().addClass('has-error');
              $("#autocomplete").parent().next("div").empty().append(span);
              return false;
          }
          if($("#tableAdd_form").valid()){
              $("#tableAdd_form").submit();
              $("#tableAdd").modal("hide");
          }
      })
      $('#tableAdd_form button:last').on('click',function () {
          if($("#tableAdd_form tbody tr").length==0){
              var span = "<span class='error' id='goodsCode-error'>请添加审核通过的商品</span>";
              $("#autocomplete").parent().parent().addClass('has-error');
              $("#autocomplete").parent().next("div").empty().append(span)
              return false;
          }
          $('#tableAdd_form').submit();
      });
      $("#downExport").on("click",function () {
          window.location.href="/upload/template/boxImportTemple.xls";
      })
      //批量添加包裹按钮
      $("#instore_form").on("click","button[name=addAll]",function () {
          if(checkToWarehouseId()){
              $("#goodsExport").modal("show");
          }
      });
      //添加包裹按钮
      $("#instore_form").on("click","button[name=add]",function () {
          if(checkToWarehouseId()){
              $("#tableAdd").modal("show");
          }
      });
      //商品编辑
      $("#instoreAdd_table").on("click","a[name=edit]",function () {
          if(checkToWarehouseId()){
              var selectData = table.row($(this).parents("tr")).data();
              $("#flagTr").val($(this).attr("name"));
              $(this).parents("tbody").find("a.update").removeClass("update");
              $(this).addClass("update");
              $("#goodsCount").val(selectData.goods.length);
              $('#tableAdd_form input[name=boxNo]').val(selectData.boxNo);
              $('#tableAdd_form input[name=boxweight]').val(selectData.regWeight);
              $('#tableAdd_form input[name=regLength]').val(selectData.regLength);
              $('#tableAdd_form input[name=regWidth]').val(selectData.regWidth);
              $('#tableAdd_form input[name=regHigh]').val(selectData.regHeight);
              $("#tableAdd").modal("show");
              $.each(selectData.goods,function (index,obj) {
                  var tr ="<tr><td>"+obj.goodsCode+"</td><td>"+obj.goodsName+"</td><td><input type='text' class='form-control' value='"+obj.num+"'>" +
                      "</td><td><a href='javascript:;'>撤销</a></td></tr>";
                  $('#tableAdd_form tbody').append(tr);
              })
          }
      });
      //删除table 添加的商品
      $("#tableAdd_form tbody").on("click","a",function () {
          $(this).parent().parent().remove();
      })
      //地址选择
      $("#addressList").on("click","input[name=addressRadio]",function () {
          var $div = $(this).parent().clone();
          $div.find("input").remove();
          var span = "<span class='iteam'>"+$div.html()+"</span>"
          $("#addressShow").empty().append(span);
          $('#instore_form input[name=pickupAddressId]').val(this.value);
      });
      //提货方式
      $("#instore_form select[name=pickupType]").on("change",function () {
          if(this.value == 'pickup'){
              $("#instore_form div[name=pickup]").show();
              $("#instore_form div[name=delivery]").hide();
              $("#instore_form input[name=pickupDate]").rules("add",{required:true});
              $("#instore_form input[name=pickupAddressId]").rules("add",{required:true});
              $("#instore_form input[name=expressNo]").rules("remove",'required')
          }else if(this.value == 'delivery'){
              $("#instore_form div[name=pickup]").hide();
              $("#instore_form div[name=delivery]").show();
              $("#instore_form input[name=pickupDate]").rules("remove","required");
              $("#instore_form input[name=pickupAddressId]").rules("remove","required");
              $("#instore_form input[name=expressNo]").rules("add",{required:true,messages:{required:'订单号为必填字段'}})
          }
      });
      $("#tableAdd button:first").on('click',function () {
          cleanForm();
      })
  
      $('#tableAdd_form tbody').on('change','input',function () {
          var rel = /^\d+$/;
          if(!rel.test(this.value)){
              this.value = 1;
          }else if(this.value == 0){
              this.value = 1;
          }
      });
      //物流计划变更时，企业最迟送货时间放入lastCollectDt
      $('select[name=logisticsPlanId]').on('change',function () {
          var selectedIndex = document.getElementById("logisticsPlanId").selectedIndex;
          var options = document.getElementById("logisticsPlanId").options;
          var lastcollectdt = options[selectedIndex].getAttribute('lastcollectdt');
          var date = new Date(lastcollectdt.replace(/-/,"/"))
          //时间控件
          $("span.form_date").datetimepicker('endDate',date);
      });
      //时间控件X点击事件
      $("span.form_date span.delete").on("click",function () {
          $(this).prev("input").val("");
      });
     /* $(".datetime-picker").next().on("click",function () {
          $(".datetime-picker").val("");
      });*/
      $("span.form_date").datetimepicker({
          format: "yyyy-mm-dd",
          language: 'zh-CN',
          autoclose: true,
          todayBtn: true,
          minView :2,
          pickerPosition: "bottom-left",
          startDate: new Date()
      });
      //alert框确定时触发
      $(document).on('hide.bs.modal',"#alert_modal", function() {
          if(isSave){
              window.location.href="in-order";
          }
      });
  })
  //已选择目的仓-true 否则为false
  function checkToWarehouseId() {
      var toWarehouseId = $("#instore_form select[name=toWarehouseId]").val();
      if(toWarehouseId == null || toWarehouseId == ""){
          $alert("请先选择目的仓");
          return false;
      }
      return true;
  }
  //表单验证
  function  formValidationinit() {
      $form({form:'#instore_form',button:'#instore_form button:last'},{
          logisticsId:{required:true},collectWarehouseId:{required:true},toWarehouseId:{required:true},
          logisticsPlanId:{required:true},importerId:{required:true},exporterId:{required:true},
          pickupDate:{required:true}, pickupAddressId:{required:true}
      },{logisticsId:{required:'物流产品不能为空'},collectWarehouseId:{required:'验货仓不能为空'},
          toWarehouseId:{required:'目的仓不能为空'},logisticsPlanId:{required:'物流计划不能为空'},
          importerId:{required:'进口商不能为空'},exporterId:{required:'出口商不能为空'},
          pickupDate:{required:'预约提货时间为必填字段'},pickupAddressId:{required:'提货地址为必填字段'}
      },asyfun,function (result) {
          if(result.code == 200){
              window.location.href="in-order";
          }else if(result.code == 201){
              $alert(result.message);
          }else{
              $alert(result.message);
          }
      });
  }
  
  //组装信息
  function asyfun() {
      var json = $('#instore_form').serializeObject();
      json.addressRadio = undefined;
      var data = [];
      table.data().each(function (v,k) {
          data.push(v);
      });
      json["boxes"] = data;
      if(isEstimate){
          estimateAjax(json);
          return false;
      }else{
          return json;
      }
  }
  function estimateAjax(data){
      $.ajax({
          url:"api/v1/p/ftisp/order/feeEstimate",
          type:'post',
          data:JSON.stringify(data),
          contentType: "application/json; charset=utf-8",
          dataType:'json',
          success:function (result) {
              if(result.code=='200'){
                  var data = result.data;
                  $("#fee_total").html("合计("+data.currency+")："+Number(data.totalAmount).toFixed(2));
  
                  $.each(data.rows,function (index,obj) {
                      var data = {};
                      data["billProdName"]= obj.billProdName;
                      data["productCatalogName"]= obj.productCatalogName;
                      data["amount"]= obj.amount;
                      data["currency"]= obj.currency;
                      estimateTable.row.add(data);
                  });
                  estimateTable.draw(false);
                  $("#div_estimate").show();
              }else{
                  $alert(result.message);
              }
          }
      })
  }
  //添加参数
  function appendOption(url,data,$select,value) {
      $.ajax({
          url:url,
          type:'post',
          data:data,
          dataType:'json',
          success:function (result) {
              if(result.code==200){
                  var options =  '<option value="">请选择</option>';
                  if(result.data == ''||result.data == null){
                      var span = '<span  class="error-info"><span class="glyphicon glyphicon-remove">' +
                          '</span>未找到相关数据</span>';
                      $select.parent('div').next('div.col-xs-3').empty().append(span);
                      $select.html('<option value="">请选择</option>');
                      return false;
                  }
                  $.each(result.data,function (index,obj) {
                      var checked = "";
                      if(value){
                          if(value ==obj.warehouseId|| value ==obj.logisticsId|| value ==obj.id){
                              checked = "selected"
                          }
                      }
                      if(obj.warehouseId !=undefined){
                          options += "<option value='" + obj.warehouseId + "' "+checked+">" + obj.warehouseName + "</option>";
                      }else if(obj.id!=undefined){
                          if(obj.name != undefined){
                              if(obj.lastCollectDt != undefined){
                                  options += "<option lastcollectdt = '" + obj.lastCollectDt + "' value='" + obj.id + "' "+checked+">" + obj.name + "</option>";
                              }else{
                                  options += "<option value='" + obj.id + "' "+checked+">" + obj.name + "</option>";
                              }
                          }else{
                              options += "<option value='" + obj.id + "' "+checked+">" + obj.nameCn  + "</option>";
                          }
                      }else {
                          options += "<option value='" + obj.logisticsId  + "' "+checked+">" + obj.name + "</option>";
                      }
                  });
                  $select.empty();
                  $select.append(options);
              }else{
                  var span = '<span  class="error-info"><span class="glyphicon glyphicon-remove"></span>'+
                      result.message+'</span>';
                  $select.parent('div').next('div.col-xs-3').empty().append(span);
              }
          },
          error:function (e) {
              console.log(url+'接口错误');
          }
      })
  }
  function estimateTableInit(data) {
      estimateTable=$("#estimate_table").DataTable({
          dom: '<"top"f >rt<"bottom"ilp><"clear">',//dom定位
          dom: 'tiprl',//自定义显示项
          data:data,
          bPaginate: true, //翻页功能
          Info: true,//页脚信息
          autoWidth: false,//自动宽度
          oLanguage: {//国际语言转化
              oAria: {
                  sSortAscending: " - click/return to sort ascending",
                  sSortDescending: " - click/return to sort descending"
              },
              sLengthMenu: "显示 _MENU_ 记录",
              sZeroRecords: "数据查询错误",
              sEmptyTable: "<div style='text-align: center;'>请先添加商品</div>",
              sLoadingRecords: "正在加载数据-请等待...",
              sInfo: "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
              sInfoEmpty: "当前显示0到0条，共0条记录",
              sInfoFiltered: "（数据库中共为 _MAX_ 条记录）",
              sProcessing: "<img src='../resources/user_share/row_details/select2-spinner.gif'/> 正在加载数据...",
              sSearch: "模糊查询：",
              //    sUrl: "",
              //多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
              oPaginate: {
                  sFirst: "首页",
                  sPrevious: " 上一页 ",
                  sNext: " 下一页 ",
                  sLast: " 尾页 "
              }
          },
          fnDrawCallback: function () {//列筛选
              var api = this.api();
              //var startIndex= api.context[0]._iDisplayStart;//获取到本页开始的条数
              //console.log("startIndex:"+startIndex);
              api.column(0).nodes().each(function(cell, i) {
                  cell.innerHTML = i + 1;
              });
          },
          columns:[
              {data:null},
              { data: "billProdName" ,"targets": 1},
              { data: "productCatalogName" ,"targets": 2},
              { data: "amount" ,"targets": 3},
              { data: "currency" ,"targets": 4}
          ]
      })
  }
  //goodstable
  function tableInitAdd(data) {
      table=$("#instoreAdd_table").DataTable({
          dom: '<"top"f >rt<"bottom"ilp><"clear">',//dom定位
          dom: 'tiprl',//自定义显示项
          data:data,
          bPaginate: true, //翻页功能
          Info: true,//页脚信息
          autoWidth: true,//自动宽度
          oLanguage: {//国际语言转化
              oAria: {
                  sSortAscending: " - click/return to sort ascending",
                  sSortDescending: " - click/return to sort descending"
              },
              sLengthMenu: "显示 _MENU_ 记录",
              sZeroRecords: "数据查询错误",
              sEmptyTable: "<div style='text-align: center;'>请先添加商品</div>",
              sLoadingRecords: "正在加载数据-请等待...",
              sInfo: "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
              sInfoEmpty: "当前显示0到0条，共0条记录",
              sInfoFiltered: "（数据库中共为 _MAX_ 条记录）",
              sProcessing: "<img src='../resources/user_share/row_details/select2-spinner.gif'/> 正在加载数据...",
              sSearch: "模糊查询：",
              //    sUrl: "",
              //多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
              oPaginate: {
                  sFirst: "首页",
                  sPrevious: " 上一页 ",
                  sNext: " 下一页 ",
                  sLast: " 尾页 "
              }
          },
          fnDrawCallback: function () {//列筛选
              var api = this.api();
              var startIndex= api.context[0]._iDisplayStart;//获取到本页开始的条数
              api.column(0).nodes().each(function(cell, i) {
                  cell.innerHTML = startIndex + i + 1;
              });
          },
          columns:[
              {data:null},
              { data: "boxNo" ,"targets": 1},
              { data: "regWeight" ,"targets": 2},
              { data: "regLength" ,"targets": 3},
              { data: null,"targets": 4}
          ],
          columnDefs:[
              {
                  targets: [1],
                  data:'boxNo',
                  render:function (data,type,full) {
                      return "<span class='row-details row-details-close' data_id='" + full.id + "'>"+data+"<i class='glyphicon glyphicon-plus'></i></span>&nbsp;";
                  }
              },
              {
                  targets: [3],
                  data:"regLength",
                  render: function(data, type, full) { // 返回自定义内容
                      return data+"X"+full.regWidth +"X"+full.regHeight ;
                  }
              },
              {
                  targets: [4],
                  data:null,
                  render: function(data, type, full) { // 返回自定义内容
                      return "<a href='javascript:;' name='edit' >编辑</a>|<a href='javascript:;' name='delete'>删除</a>" ;
                  }
              }
          ],
  
      })
  }
  
  //upload初始化
  function uploadinit() {
      $("#uploadify").uploadify({
          'uploader' : 'api/v1/p/ftisp/order/importBox',
          'fileObjName':'file',
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
              if(obj.code==200){
                  table.rows.add(obj.data);
                  table.draw(false);
                  count(obj.data);
                  $("#totalBox").html(table.data().length);
              }else if(obj.code == 201){
                  $alert(obj.message);
                  window.open("api/v1/p/ftisp/fileoper/download?id="+obj.data.id);
              }else{
                  $alert(obj.message);
              }
  
          },
          //在onUploadStart事件中，也就是上传之前，把参数写好传递到后台。
          'onUploadStart': function (file) { $("#uploadify").uploadify(
              "settings", "formData", {'toWarehouseId':$("#instore_form select[name=toWarehouseId]").val()});
          }
      });
  }
  //添加详情
  function appendDetail(data) {
      var trs = "<tr><td colspan='4'><table class='table'><thead>" +
          "<th>商品编码</th><th>商品名称</th><th>商品数量</th></thead><tbody>" ;
      $.each(data.goods,function (index,obj) {
          trs+="<tr><td>"+obj.goodsCode+"</td><td>"+obj.goodsName+"</td><td>"+obj.num+"</td></tr>"
      })
      trs+="</tbody></table></td></tr>"
      return trs;
  }
  //商品表单验证
  function formGoodsInit() {
      $form({form:'#tableAdd_form'/*,button:'#tableAdd_form button:first-child'*/},
          {boxNo:{required:true},boxweight:{required:true,number:true},regLength:{required:true,number:true},
          regWidth:{required:true,number:true},regHigh:{required:true,number:true}},
          {boxNo:{required:'箱号不能为空'},boxweight:{required:'重量为必填项',number:'重量为数字格式'},regLength:{required:'长度为必填项',number:'长度为数字格式'},
          regWidth:{required:'宽度为必填字段',number:'宽度为数字格式'},regHigh:{required:'高度为必填字段',number:'高度为数字格式'}},
          function () {
              return true;
          },
          function () {
          var flag =boxValide(); if(!flag){ return false;}
          var data = {}; data["boxNo"]= $('#tableAdd_form input[name=boxNo]').val();data["regWeight"]= $('#tableAdd_form input[name=boxweight]').val();
          data["regLength"]= $('#tableAdd_form input[name=regLength]').val();data["regWidth"]= $('#tableAdd_form input[name=regWidth]').val();
          data["regHeight"]= $('#tableAdd_form input[name=regHigh]').val();var goodses = [];
          $("#tableAdd_form tbody tr").each(function () {
              var goods = {};
              goods["goodsCode"] = $(this).find("td:eq(0)").html();
              goods["goodsName"] = $(this).find("td:eq(1)").html();
              goods["num"] = $(this).find("input").val();
              goodses.push(goods);
          });
          data["goods"] = goodses;
          var editName = $("#flagTr").val()
          if(editName == ''){
              table.row.add(data);
              $("#totalGoods").html(1* $("#totalGoods").html()+data.goods.length);
              $("#totalBox").html(table.data().length);
          }else{
              var $a = $("#instoreAdd_table a.update");
              var odata =table.row($a.parents("tr")).data() ;
              odata.boxNo = data.boxNo;
              odata.regWeight = data.regWeight;
              odata.regLength = data.regLength;
              odata.regWidth = data.regWidth;
              odata.regHeight = data.regHeight;
              odata.goods = data.goods;
              table.row($a.parents("tr")).data(odata) ;
              if(data.goods.length != $("#goodsCount").val()){
                  var count = data.goods.length - $("#goodsCount").val();
                  $("#totalGoods").html(1* $("#totalGoods").html()+count);
              }
          }
          table.draw(false);
          cleanForm();
      });
  }
  //清空
  function cleanForm() {
      $('#tableAdd_form input').val('');
      $('#tableAdd_form tbody').empty();
      $('#goodsCode-error').empty();
  }
  
  //添加商品
  function  appendGoods(item) {
      var obj = item.split('-');
      var flag = true;
      $("#tableAdd_form tbody tr").each(function () {
          if($(this).find('td:eq(0)').html() == obj[0]){
              flag = false;
              return false;
          }
      })
      if(!flag){
          return false;
      }
      var tr ="<tr><td>"+obj[0]+"</td><td>"+obj[1]+"</td><td><input type='text' class='form-control' value='1'></td><td>" +
          "<a href='javascript:;'>撤销</a></td></tr>";
      $('#tableAdd_form tbody').append(tr);
      if($("#goodsCode-error").length !=0){
          $("#goodsCode-error").remove();
      }
  
  }
  
  //计算商品总数
  function count(data) {
      var totalGoods = $("#totalGoods").html();
      var count=0;
      $.each(data,function (index,obj) {
          count +=obj.goods.length;
      })
      $("#totalGoods").html(totalGoods*1+count);
  }
  
  //包裹号相同判断
  function boxValide() {
      var $this = $("#tableAdd_form input[name=boxNo]");
      var flag =true;
      if($("#flagTr").val() !=''){
          return true;
      }
      if($this.val()!=''){
          table.data().each(function (v,k) {
              if($this.val() == v.boxNo){
                  flag = false;
                  return false;
              }
          })
      }
      var $ndiv = $this.parent().next("div");
      if(!flag){
          $this.addClass("error")
          $ndiv.append('<span id="boxNo-error" class="error-info"><span class="glyphicon glyphicon-remove"></span>箱号已经存在</span>')
      }else{
          $this.removeClass("error")
          $ndiv.empty();
      }
      return flag;
  };
  
  //判断是更新还是新建
  function isAddOrUpdate() {
      var url = window.location.href;
      if(url.indexOf("orderNo=")>0){
          $("#instore_form").attr("action","api/v1/p/ftisp/order/update");
          var i = url.indexOf("orderNo=");
          var orderNo = url.substr(i+8,url.length);
          loadOrder(orderNo);
      }else{
          $("#instore_form").attr("action","api/v1/p/ftisp/order/create");
          appendOption('api/v1/p/ftisp/logistics/query',{},$("#instore_form select[name=logisticsId]"));
          // appendOption('api/v1/p/ftisp/merchant/query',{type:'I'},$("#instore_form select[name=importerId]"));
          appendOption('api/v1/p/ftisp/merchant/query',{type:'O'},$("#instore_form select[name=exporterId]"));
          queryAddress(false);
          tableInitAdd([]);
      }
  }
  
  //查询order信息
  function loadOrder(orderNo) {
      $.ajax({
          url:'api/v1/p/ftisp/order/load',
          type:'post',
          data:{
              orderNo:orderNo,
          },
          dataType:'json',
          success:function (result) {
              if(result.code == 200){
                  appendOption('api/v1/p/ftisp/logistics/query',{},$("#instore_form select[name=logisticsId]"),result.data.logisticsId);
                  appendOption('api/v1/p/ftisp/warehouse/query',{logisticsId:result.data.logisticsId,warehouseType:'INSJ'},
                      $("#instore_form select[name=collectWarehouseId]"),result.data.collectWarehouseId);
                  appendOption('api/v1/p/ftisp/warehouse/query',{logisticsId:result.data.logisticsId,warehouseType:'DEST',inspectionWarehouseCode:result.data.collectWarehouseId },
                      $("#instore_form select[name=toWarehouseId]"),result.data.toWarehouseId);
                  var data = {logisticsId:result.data.logisticsId, fromWarehouseId:result.data.collectWarehouseId,
                      toWarehouseId:result.data.toWarehouseId }
                  appendOption('api/v1/p/ftisp/logisticsChannelPlan/query',data,$("#instore_form select[name=logisticsPlanId]"),
                      result.data.logisticsPlanId );
                  appendOption('api/v1/p/ftisp/merchant/query',{type:'I'},$("#instore_form select[name=importerId]"),result.data.importerId);
                  appendOption('api/v1/p/ftisp/merchant/query',{type:'O'},$("#instore_form select[name=exporterId]"),result.data.exporterId);
                  writeValue(result.data );
              }else{
                  $alert(result.message);
              }
          },
          error:function (e) {
              $alert("订单号"+orderNo+"查询失败");
          }
      })
  }
  
  //复值
  function writeValue(data) {
      if(data.pickupType == 'delivery' ){
          $("#instore_form div[name=pickup]").hide();
          $("#instore_form div[name=delivery]").show();
          $("#instore_form input[name=pickupDate]").rules("remove","required");
          $("#instore_form input[name=pickupAddressId]").rules("remove","required");
          $("#instore_form input[name=expressNo]").rules("add",{required:true,messages:{required:'订单号为必填字段'}})
      }else if(data.pickupType == 'pickup'){
          data.pickupDate = data.pickupDate.substr(0,data.pickupDate.length-9);
      }
      $("#instore_form").setForm(data);
      $("#totalGoods").html(data.tGoodsNums);
      queryAddress(data.pickupAddressId);
      queryBoxList();
  };
  
  //查询boxList
  function queryBoxList() {
      var orderId = $("#id").val();
      $.ajax({
          url:'api/v1/p/ftisp/box/orderBoxList',
          type:'post',
          data:{
              orderId:orderId,
              rows:1000,
          },
          dataType:'json',
          success:function (result) {
              if(result.code == 200){
                  tableInitAdd(result.data.rows);
                  // count(result.data.rows);
                  $("#totalBox").html(table.data().length);
              }else{
                  $alert(result.message);
                  tableInitAdd([]);
              }
          },
          error:function (e) {
              $alert("api/v1/p/ftisp/box/orderBoxList数据加载失败");
          }
      })
  }
  
  //加载地址
  function queryAddress(addressId) {
      $.ajax({
          url:'api/v1/p/ftisp/address/list',
          type:'post',
          data:{
              rows:'1000',
              page:'1'
          },
          dataType:'json',
          success:function (resutl) {
              if(resutl.code == 200){
                  if(addressId){
                      appendAddress(resutl.data.rows,addressId);
                  }else{
                      appendAddress(resutl.data.rows);
                  }
              }else{
                  $alert(resutl.message);
              }
          },
          error:function (e) {
              $alert("加载地址数据接口失败 ")
          }
      })
  }
  
  //加载地址 addressId 更新的id
  function appendAddress(data,addressId) {
      var divs = "";
      $.each(data,function (index,obj) {
          var check = "";
          if(addressId){
              if(addressId == obj.id){
                  check = 'checked';
                  var span = "<span class='iteam'>"+ obj.province + obj.city + obj.area + obj.address+"</span>"
                  $("#addressShow").empty().append(span);
              }
          }else if(obj.isDefault == 'Y'){
              check = 'checked'
              $('#instore_form input[name=pickupAddressId]').val(obj.id);
              var span = "<span class='iteam'>"+ obj.province + obj.city + obj.area + obj.address+"</span>"
              $("#addressShow").empty().append(span);
          }
          divs += "<div><input type='radio' value='"+obj.id+"' name='addressRadio' "+check+" />"+ obj.province + obj.city + obj.area + obj.address+"</div>"
      })
      $("#addressList").append(divs);
  }
  
  
  

});