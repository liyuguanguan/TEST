/**
 * author zzy 2017-4-18
 */
var $ = require('jquery');
var $validator = require('libs/validator');
var $alert = require('libs/alert');
require('libs/bootstrap-typeahead');
var table;
$(function () {
    //国家下拉框初始化
    areainit('country',1,0);
    //海外仓下拉框初始化
    warehouseinit();
    //页面数据初始化
    detailinit();
    //出库商品table 初始化
    tableinit([]);
    //隐藏id列
    table.column(1).visible(false);
});
function detailinit() {
    var href = window.location.href;
    var i =href.indexOf('id=');
    var id =href.substr(i+3,href.length);
    //查询数据
    $.ajax({
        url:'api/v1/p/ftisp/outRoomOrder/load',
        type:'post',
        data:{
            id:id
        },
        dataType:'json',
        success:function (result) {
            if(result.code == 200){
                datainit(result.data);
            }else{
                $alert(result.message);
            }
        }
    });
}
function areainit(id,level,parentId) {
    var url = "api/v1/p/ftisp/area/query";
    $.ajax({
        url:url,
        type:'post',
        async: false,
        data:{
            level:level,
            parentId:parentId
        },
        dataType:'json',
        success:function (result) {
            if(result.code == 200){
                $('#'+id).text('');
                $('#'+id).append("<option value=''>请选择</option>");
                $.each(result.data,function (index, obj) {
                    $('#'+id).append("<option value='"+obj.id+"'>"+obj.name+"</option>");
                })
            }else{
                $alert(result.message);
            }
        }
    })
}
function warehouseinit() {
    var url = "api/v1/p/ftisp/warehouse/query";
    $.ajax({
        url:url,
        type:'post',
        async: false,
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

function datainit(data) {
    $('#recipientCityName').val(data.recipientCityName);
    $('#recipientRegionName').val(data.recipientRegionName);
    $('#warehouseId').val(data.warehouseId);
    $('#platType').val(data.platType);
    $('#platOrderNo').val(data.platOrderNo);
    $('#name').val(data.recipientName);
    $("#country").val(data.recipientCountryId);
    $("#region").val(data.recipientRegionId);
    $("#city").val(data.recipientCityId);
    $("#recipientAddress1").val(data.recipientAddress1);
    $("#recipientAddress2").val(data.recipientAddress2);
    $('#recipientPhone').val(data.recipientPhone);
    $('#recipientZipcode').val(data.recipientZipcode);
    deliveryinit(data.warehouseId);
    $('#delivery').val(data.deliveryWayId);
    if($('#delivery').val()=='1'){
        $('#doorplate').css('display','block');
        $('#doorplatenumbers').val(data.doorplatenumbers);
    }else{
        $('#doorplate').css('display','none');
    }
    $.each(data.goods,function (index,obj) {
        var data = {};
        data["goodsId"]= obj.goodsId;
        data["code"]= obj.code;
        data["chName"]= obj.chName;
        data["spec"]= obj.spec;
        data["nums"]= obj.nums;
        data["weightKg"]= obj.weightKg;
        data["weightLbs"]= obj.weightLbs;
        var inCodeList = obj.inCodeList;
        var inCodes = '';
        for(var i = 0; i < inCodeList.length; i ++){
            inCodes += ',' + inCodeList[i].inCode;
        }
        data["inCodes"] = inCodes.substring(1,inCodes.length);
        table.row.add(data);
    });
    table.draw(false);
    $('.form-goods-info span strong').text(data.goods.length);
}
function deliveryinit(warehouseId) {
    var url = "api/v1/p/ftisp/warehouseDelivery/query";
    $.ajax({
        url:url,
        type:'post',
        async: false,
        data:{
            warehouseId:warehouseId
        },
        dataType:'json',
        success:function (result) {
            if(result.code == 200){
                $('#delivery').text('');
                $('#delivery').append("<option value=''>请选择</option>");
                $.each(result.data,function (index, obj) {
                    $('#delivery').append("<option value='"+obj.deliveryId+"'>"+obj.deliveryName+"</option>");
                });

            }else{
                $alert(result.message);
            }
        }
    })
}
function tableinit(data) {
    table=$("#outstore_table").DataTable({
        dom: "rt<'row row-fix'<'col-xs-3 length-fix'l><'col-xs-9 paginate-fix'p>>",
        lengthMenu: [[10, 25, 50], [10, 25, 50]],
        pagingType: "simple_numbers",
        ordering: false,
        data:data,
        language: {
            lengthMenu: "显示 _MENU_ 记录",
            zeroRecords: "<div style='text-align: center'>请先添加商品</div>",
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
        },
        columns:[
            {data:null},
            { data: "goodsId" ,"targets": 1},
            { data: "code" ,"targets": 2},
            { data: "chName" ,"targets": 3},
            { data: "spec" ,"targets": 4},
            { data: "nums" ,"targets": 5},
            { data: "weightKg" ,"targets": 6},
            { data: "weightLbs" ,"targets": 7},
            { data: "inCodes" ,"targets": 8},
            { data: null,"targets": 9}
        ],
        columnDefs:[
            {
                targets: [9],
                data:null,
                render: function(data, type, full) { // 返回自定义内容
                    return "" ;
                }
            }
        ]
    })
}