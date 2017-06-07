/**
 * Created by csy on 2017/5/2.
 */
require("jquery");
var $alert = require('libs/alert');
var table;
$(function () {
    //返回
    $('#instoreAdd_back').on('click',function () {
        window.history.back();
    });
    $("#instore_form input[name!=boxes]").attr("disabled","true");
    $("#instore_form select").attr("disabled","true");
    queryDetail();
    //物流产品 select添加数据
    //增加详情
    $('#instoreAdd_table').on('click', 'a[name=open]',function() {
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
    $("#instore_form span.form_date span.delete").off("click");

    $('#instoreAdd_table').on('click','span.glyphicon-print',function () {
        var selectData = table.row($(this).parents("tr")).data();
        var orderNo = $("#instore_form input[name=orderNo]").val();
        var boxes = [{"id":selectData.id}]
        var obj = {};
        obj["boxes"]=boxes;
        obj["orderNo"]=orderNo;
        $("#instore_form input[name=boxes]").val(JSON.stringify(obj));
        $("#instore_form").attr("action","api/v1/p/ftisp/box/printBoxLabel");
        $("#instore_form").attr("target","_blank")
        $("#instore_form").submit();
    })
})

//查询详情
function queryDetail() {
    var url =window.location.href;
    var i =url.indexOf('orderNo=');
    var orderNo =url.substr(i+8,url.length);
    $.ajax({
        url:'api/v1/p/ftisp/order/load',
        type:'post',
        data:{orderNo:orderNo},
        dataType:'json',
        success:function (result) {
            if(result.code == 200){
                if(result.data.pickupType == 'delivery' ){
                    $("#instore_form div[name=pickup]").hide();
                    $("#instore_form div[name=delivery]").show();
                }else if(result.data.pickupType == 'pickup' ){
                    result.data.pickupDate = result.data.pickupDate.substr(0,result.data.pickupDate.length-9);
                }
                loadAddress(result.data.pickupAddressId );
                $("#instore_form").setForm(result.data );
                $("#totalGoods").html(result.data.tGoodsNums);
                tableInit();
                appendTrack(result.data.orderOpts);
            }else{
                $alert(result.message);
            }
        },
        error:function (e) {
            $alert("加载数据失败！");
        }
    })
}
//goodstable
function tableInit() {
  table=$("#instoreAdd_table").DataTable({
      dom: '<"top"f >rt<"bottom"ilp><"clear">',//dom定位
      dom: 'tiprl',//自定义显示项
      bServerSide: true,
      sAjaxSource: "api/v1/p/ftisp/box/orderBoxList",// post地址
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
          sUrl: "",
          //多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
          oPaginate: {
              sFirst: "首页",
              sPrevious: " 上一页 ",
              sNext: " 下一页 ",
              sLast: " 尾页 "
          }
      },
      //向服务器传额外的参数
      fnServerParams: function (aoData) {
          queryParm(aoData);
      },
      fnServerData: function (sSource, aoData, fnCallback) {
          $.ajax({
              type: "post",
              url: sSource,
              dataType: "json",
              data: aoData,
              success: function (resp) {
                  var obj = {};
                  if(resp.code == 200){
                      obj["recordsTotal"] = resp.data.total;
                      obj["recordsFiltered"] =resp.data.total;
                      obj["data"] = resp.data.rows;
                      //count(resp.data.rows);
                      $("#totalBox").html(resp.data.total);
                      fnCallback(obj);
                  }else{
                      obj["data"] = {};
                      fnCallback(obj); //服务器端返回的对象的returnObject部分是要求的格式
                  }
              }
          });
      },//执行方法
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
          {data:"boxCode","targets":2},
          { data: "regWeight" ,"targets": 3},
          { data: "regLength" ,"targets": 4},
          {data:null,"targets":5}
      ],
      columnDefs:[
          {
              targets: [1],
              data:'boxNo',
              render:function (data,type,full) {
                  return "<span class='row-details row-details-close' data_id='" + full.id + "'>"+data+"</span>&nbsp;";
              }
          },{
              targets:[2],
              data:'boxCode',
              render:function (data,type,full) {
                  return data+"&nbsp;<span class='glyphicon glyphicon-print' style='cursor:pointer'></span>";
              }
          },
          {
              targets: [4],
              data:"regLength",
              render: function(data, type, full) { // 返回自定义内容
                  if(full.factLength!=''&&full.factWidth!=''&&full.factHeight!=''){
                      return full.factLength+"X"+full.factWidth +"X"+full.factHeight;
                  }else{
                      return data+"X"+full.regWidth +"X"+full.regHeight ;
                  }
              }
          },{
              targets: [5],
              data:null,
              render:function (data,type,full) {
                  return "<a href='javascript:;' name='open' class='row-details-close' >展开</a>"
              }
          }
      ],

  })
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
//参数添加
function queryParm(aoData) {
    var start = aoData[3].value;
    var length = aoData[4].value;
    aoData.push({ name: "orderId", value: $('#id').val() })
    aoData.push({ name: "rows", value: length })
    aoData.push({ name: "page", value: (start/length)+1 })
}

//添加详情
function appendDetail(data) {
    var trs = "<tr><td colspan='6'><table class='table'><thead>" +
        "<th>商品编码</th><th>商品名称</th><th>商品数量</th><th width='40%'>包装码</th></thead><tbody>" ;
    $.each(data.goods,function (index,obj) {
        var inCodes = obj.inCodeList;
        var inCodeString = '';
        var simpleCode = '';
        for(var i = 0; i < inCodes.length; i ++){
            inCodeString += ',' + inCodes[i].inCode;
        }
        if(inCodeString.length > 30){
            simpleCode = inCodeString.substring(1,30) + "...";
        }else {
            simpleCode = inCodeString.substring(1,inCodeString.length);
        }
        trs+="<tr><td>"+obj.goodsCode+"</td><td>"+obj.goodsName+"</td><td>"+obj.num+"</td><td title='" + inCodeString.substring(1,inCodeString.length) + "'>"+simpleCode+"</td></tr>"
    })
    trs+="</tbody></table></td></tr>"
    return trs;
}

function loadAddress(addressId) {
    $.ajax({
        url:'api/v1/p/ftisp/address/load',
        type:'post',
        data:{
            id:addressId
        },
        dataType:'json',
        success:function (result) {
            if(result.code == 200){
                var span = "<span class='iteam'>联系人:"+result.data.linkMan+"&nbsp;"+result.data.country+result.data.province +result.data.city
                    +result.data.area+result.data.address+"</span>"
                $("#showAddress").append(span);
            }else{
                $alert(result.message);
            }
        }
    })
}

function appendTrack(orderOpts) {
    var divs = "";
    $.each(orderOpts,function (index,obj) {
        var sts = "";
        switch (obj.opsStatus){
            case 'draft': sts = '创建订单';break ;case 'commit': sts = '提交订单';break ; case 'c_collect': sts='揽收';break ;case 'c_receive': sts='收货';break ;
            case 'c_goods_check': sts='新品检查';break ;case 'c_check':sts='验收';break ;case 'c_volume':sts='称重量体积';break ;
            case 'c_ourtoom':sts='集货出库';break ;case 'p_inroom': sts = '转运入库'; break ;case 'p_packet':sts='转运打托';break ;
            case 'p_outroom':sts = '转运出库';break ;
            case 'o_inroom': sts = '海外入库';break ;
            case 'o_shelve': sts = '海外上架';break ;
            default :'';
        };
        divs +='<div class="list col-xs-12 active"><span class="yuan"></span><div class="times col-xs-3">'+obj.optDt +
            '</div><div class="add col-xs-2">'+obj.warehouseName+'</div><div class="info col-xs-7">'+sts+'</div></div>';
    })
    divs+='<div class="line"></div>';
    $('#instore_form div.log-track').append(divs);
}




