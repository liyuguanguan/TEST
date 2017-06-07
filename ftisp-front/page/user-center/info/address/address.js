/**
 * author zzy 2017-4-18
 */
var $ = require('jquery');
var $confirm = require('libs/confirm');
var $alert = require('libs/alert');
var tableSetting = require('libs/table-init');
var table;
var $validator = require('libs/validator');
$(function () {
    tableinit();
    $("#search").on("click",function (event) {
        event.preventDefault();
        table.draw();
    });
    $("#main-table").on("change","input[name=default]",function () {
        var selectData= table.row($(this).parents("tr")).data();
        if(selectData.isDefault == 'Y'){ return false;}
        $.ajax({
            url:'api/v1/p/ftisp/address/isDefault',
            type:'post',
            contentType: "application/json; charset=utf-8",
            data:JSON.stringify({"id":selectData.id,"isDefault":'Y'}),
            dataType:'json',
            success:function (result) {
                if(result.code != 200){
                    $alert(result.message);
                }else{
                    table.draw(false);
                }
            }
        })
    });
    $("#main-table").on("click","a[name=delete]",function () {
        var selectData= table.row($(this).parents("tr")).data();
        $confirm("是否确认删除此条地址",function () {
            var data = [{"id":selectData.id}];
            $.ajax({
                url:'api/v1/p/ftisp/address/delete',
                type:'post',
                data:JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType:'json',
                success:function (result) {
                    if(result.code == 200){
                        table.draw(false);
                    }else{
                        $alert(result.message);
                    }
                }
            })
        })
    });
});
//表格初始化
function tableinit() {
    table = $('#main-table').DataTable(
        $.extend({},tableSetting,{
            ajax: {
                url: "api/v1/p/ftisp/address/list",
                data: function ( d ) {
                    var start = d.start;
                    var length = d.length;
                    d.linkMan = $('#linkMan').val();
                    d.type = $('#type').val();
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
                {data: null},
                {data: "isDefault"},
                {data: "linkMan"},
                {data: "address"},
                {data: "linkPhone"},
                {data: "type"},
                {data: null}
            ],
            columnDefs: [ {
                targets: 1, // 目标列位置，下标从0开始
                searchable: false,
                render: function (data, type, full) { // 返回自定义内容
                    if(data == 'Y'){
                        return "<input type='radio' name='default' readonly checked >";
                    }else{
                        return "<input type='radio' name='default' readonly title='设置为默认提货地址'>";
                    }
                }
            },{
                targets:2,
                render:function (data,type,full) {
                    return "<a href='address-detail?id="+full.id+"'>"+data+"</a>"
                }
            },
                {
                    targets: 5,
                    render: function (data, type, full) {
                        if (data == 'pickup')  return '提货地址';
                    }
                },
                {
                    targets: 6, // 目标列位置，下标从0开始
                    render: function (data, type, full) {
                        return "<a href='address-update?id=" + full.id + "'  class='btn btn-default'><i class='glyphicon glyphicon-pencil'></i>修改</a>&nbsp;" +
                            "<a href='javascript:;' class='btn btn-default' name='delete'><i class='glyphicon glyphicon-remove'></i>删除</a>" ;
                    }
                }]
        })
     )
}
