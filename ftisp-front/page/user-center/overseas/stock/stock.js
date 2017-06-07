/**
 * Created by zlj on 2016/11/20.
 */
var $ = require('jquery')
var tableSetting = require('libs/table-init');
var table
$(function () {
    tableinit();
    appendOption('api/v1/p/ftisp/warehouse/query', {warehouseType: 'DEST'}
        , $("#goodsStock_form select[name=warehouseId]"));

    $("#goodsStock_form button").on("click", function () {
        table.draw();
    });
})

//表格初始化
function tableinit() {
    table = $("#main-table").DataTable(
        $.extend({}, tableSetting, {
            ajax: {
                url: "api/v1/p/ftisp/stock/list",
                data: function (d) {
                    var start = d.start;
                    var length = d.length;
                    d.warehouseId = $('#goodsStock_form select[name=warehouseId]').val();
                    d.goodsName = $('#goodsStock_form input[name=goodsName]').val();
                    d.goodsCode = $('#goodsStock_form input[name=goodsCode]').val();
                    d.rows = length;
                    d.page = (start / length) + 1;
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
                {data: null},
                {data: null},
                {data: 'warehouseName'},
                {data: "goodsCode"},
                {data: "goodsName"},
                {data: "spec"},
                {data: "stockNums"},
                {data: "wayNums"},
                {data: "totalSales"}
            ],
            columnDefs: [
                {// 目标列位置，下标从0开始
                    targets: 1,
                    searchable: false,
                    render: function (data, type, full) { // 返回自定义内容
                        return "<input type='checkbox' name='checkList'>";
                    }
                }
            ]
        })
    );
}
//海外仓：添加参数
function appendOption(url, data, $select) {
    $.ajax({
        url: url,
        type: 'post',
        data: data,
        dataType: 'json',
        success: function (result) {
            if (result.code == 200) {
                var options = '<option value="">请选择</option>';
                $.each(result.data, function (index, obj) {
                    if (obj.warehouseId != undefined) {
                        options += "<option value='" + obj.warehouseId + "'>" + obj.warehouseName + "</option>";
                    }
                });
                $select.empty();
                $select.append(options);
            } else {
                console.error(result.message);
            }
        },
        error: function (e) {
            console.log('接口错误');
        }
    })
}




