/**
 * Created by csy on 2016/11/2.
 */
var $ = require('jquery');
require('datetimepicker');
require('datetimepicker.zh-CN')
var $alert = require("libs/alert")
var $confirm = require("libs/confirm")
var tableSetting = require('libs/table-init');
var table;
$(function () {
    tableinit();
    appendOption('api/v1/p/ftisp/logistics/query', {}
        , $("#instoreList_form select[name=logisticsId]"));
    appendOption('api/v1/p/ftisp/warehouse/query', {logisticsId: this.value, warehouseType: 'INSJ'}
        , $("#instoreList_form select[name=collectWarehouseId]"));
    appendOption('api/v1/p/ftisp/warehouse/query', {warehouseType: 'DEST'}
        , $("#instoreList_form select[name=toWarehouseId]"))
    //时间控件
    $("span.form_date").datetimepicker({
        format: "yyyy-mm-dd",
        language: 'zh-CN',
        autoclose: true,
        todayBtn: true,
        minView: 2,
        pickerPosition: "bottom-left"
    });
    $('#instoreList_search').on('click', function () {
        table.draw();
    });
    //
    $("#instore_add").on('click', function () {
        window.location.href = 'orderAdd';
    })
    //提交单条
    $("#main-table").on('click', 'a[name=commit]', function () {
        var selectData = table.row($(this).parents("tr")).data();
        updateRow(1, selectData.id);
    });
    //提交单条
    $("#main-table").on('click', 'a[name=delete]', function () {
        var selectData = table.row($(this).parents("tr")).data();
        $confirm("确认删除此入库单？", function () {
            updateRow(0, selectData.id);
        })
    });
    //打印所有标签
    $("#main-table").on('click', 'a[name=print]', function () {
        var selectData = table.row($(this).parents("tr")).data();
        $("#instoreList_form input[name=boxes]").val(JSON.stringify({"orderNo": selectData.orderNo}));
        $("#instoreList_form").attr("action", "api/v1/p/ftisp/box/printBoxLabel");
        $("#instoreList_form").attr("target", "_blank")
        $("#instoreList_form").submit();
    })
})

//添加参数
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
                    } else if (obj.id != undefined) {
                        options += "<option value='" + obj.id + "'>" + obj.name + "</option>";
                    } else {
                        options += "<option value='" + obj.logisticsId + "'>" + obj.name + "</option>";
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
//表格初始化
function tableinit() {
    table = $("#main-table").DataTable(
        $.extend({}, tableSetting, {
            ajax: {
                url: "api/v1/p/ftisp/order/list",
                data: function (d) {
                    var start = d.start;
                    var length = d.length;
                    d.orderNo = $('#instoreList_form input[name=orderNo]').val();
                    d.orderStatus = $('#instoreList_form select[name=orderStatus]').val();
                    d.starDate = $('#starDate').val();
                    d.endDate = $('#endDate').val();
                    d.toWarehouseId = $('#instoreList_form select[name=toWarehouseId]').val();
                    d.collectWarehouseId = $('#instoreList_form select[name=collectWarehouseId]').val();
                    d.logisticsId = $('#instoreList_form select[name=logisticsId]').val();
                    d.rows = length;
                    d.page = (start / length) + 1;
                },
                dataSrc: function (res) {
                    var obj = {};
                    if (res.code == 200) {
                        $.extend(res, {
                            recordsTotal: res.data.total,
                            recordsFiltered: res.data.total
                        });
                        return res.data.rows;
                    } else {
                        return [];
                    }
                }
            },
            //配置列要显示的数据
            columns: [
                {data: null},
                {data: null},
                {data: "orderNo"},
                {data: "createDt"},
                {data: "collectWarehouseName"},
                {data: "logisticsName"},
                {data: "tNums"},
                {data: "cWeight"},
                {data: "cVolumn"},
                {data: "cFeeWeight"},
                {data: "cGoodsNums"},
                {data: "orderStatus"},
                {data: null}
            ],
            columnDefs: [
                {// 目标列位置，下标从0开始
                    targets: 1,
                    searchable: false,
                    render: function(data, type, full) { // 返回自定义内容
                        return "<input type='checkbox' name='checkList'>";
                    }
                },
                {
                    targets: 2,
                    render: function (data, type, full) {
                        return "<a  href='in-order-detail?orderNo=" + data + "'>" + data + "</a>";
                    }
                },
                {
                    targets: 4,
                    render: function (data, type, full) {
                        return data + "--to--" + full.toWarehouseName;
                    }
                },
                {
                    targets: 6,
                    render: function (data, type, full) { // 返回自定义内容
                        if (data == '') {
                            return full.cNums == undefined ? '' : full.cNums;
                        } else {
                            return data + (full.cNums == '' ? "" : "/" + full.cNums );
                        }

                    }
                },
                {
                    targets: 7,
                    render: function (data, type, full) { // 返回自定义内容
                        if (data == '') {
                            return full.tWeight;
                        } else {
                            return data + (full.tWeight == '' ? '' : '/' + full.tWeight);
                        }

                    }
                },
                {
                    targets: 8,
                    render: function (data, type, full) { // 返回自定义内容
                        if (data == '') {
                            return full.tVolumn;
                        } else {
                            return data + (full.tVolumn == '' ? '' : '/' + full.tVolumn);
                        }
                    }
                }, {
                    targets: 9,
                    render: function (data, type, full) { // 返回自定义内容
                        if (data == '') {
                            return full.tFeeWeight
                        } else {
                            return data + (full.tFeeWeight == '' ? '' : '/' + full.tFeeWeight);
                        }
                    }
                },
                {
                    targets: 10,
                    render: function (data, type, full) { // 返回自定义内容
                        if (data == '') {
                            return full.tGoodsNums;
                        } else {
                            return data + (full.tGoodsNums == '' ? '' : '/' + full.tGoodsNums)
                        }
                    }
                },
                {
                    targets: 11,
                    render: function (data, type, full) {
                        switch (data) {
                            case 'draft':
                                return '新建';
                            case 'commit':
                                return '已提交';
                            case 'c_collect':
                                return '揽收';
                            case 'c_receive':
                                return '收货';
                            case 'c_ourtoom':
                                return '集货出库';
                            case 'p_inroom':
                                return '转运入库';
                            case 'p_outroom':
                                return '转运出库';
                            case 'o_inroom':
                                return '海外入库';
                            case 'o_shelve':
                                return '海外上架';
                            case 'cancelled':
                                return '报废';
                            default :
                                return '';
                        }
                    }
                }, {
                    targets: 12,
                    render: function (data, type, full) {
                        if (full.orderStatus == "draft") {
                            return "<a class='btn btn-default' href='javascript:;' name='commit'><i class='glyphicon glyphicon-pencil'></i>提交</a><br>" +
                                "<a class='btn btn-default' href='in-order-add?orderNo=" + full.orderNo + "' name='edit'><i class='glyphicon glyphicon-pencil'></i>修改</a><br>" +
                                "<a class='btn btn-default' href='javascript:;' name='delete'><i class='glyphicon glyphicon-remove'></i>删除</a>";
                        } else if (full.orderStatus == "commit") {
                            return "<a class='btn btn-default' href='javascript:;' name = 'print'><i class='glyphicon glyphicon-print'></i>打印包裹号</a>";
                        } else {
                            return '';
                        }
                    }
                }
            ]
        })
    );
}


//删除或提交 默认提交 type 0删除
function updateRow(type, id) {
    var url = "api/v1/p/ftisp/order/commit";
    if (type == 0) {
        url = "api/v1/p/ftisp/order/delete"
    }
    ;
    $.ajax({
        url: url,
        type: 'post',
        data: {
            id: id
        },
        dataType: 'json',
        success: function (result) {
            if (result.code == 200) {
                table.draw(false);
            } else {
                $alert(result.message);
            }
        }
    })
};




