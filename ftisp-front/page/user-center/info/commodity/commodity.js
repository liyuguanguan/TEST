/**
 * author zzy 2017-4-18
 */
require('jquery');
require("uploadify")
var $confirm = require('libs/confirm');
var $alert = require('libs/alert');
var tableSetting = require('libs/table-init');
var table;
var $validator = require('libs/validator');

$(function () {
    uploadinit();
    uploadinit2();
    tableinit();
    $validator(
        { form:'#print_form',button:'#print',ajax:false},
        { num: {required:true,ltHundred:true}},
        { num: {required:'数目为必填项',ltHundred:'数目必须为0-100的整数'}},
        function () {
            $("#printLable").modal("hide");
        }
    );
    $('#search').on('click', function (event) {
        event.preventDefault();
        table.draw();
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
    //导出
    $("#goods_export").on("click",function () {
        var selectRow = table.rows('.selected').data(); //得到被选中的数据
        if (selectRow.length == 0){
            $confirm("确认导出所有数据吗？",function () {
                var $form  = $("#search-form");
                $form.attr("action" ,'api/v1/p/ftisp/goods/export')
                $form.submit();
            });
        }else{
            $confirm("确认导出选择行吗？",function () {
                var jsonString =installId(selectRow);
                var $form  = $("#search-form");
                $form.find("input[name=jsonString]").val(JSON.stringify(jsonString));
                $form.attr("action" ,'api/v1/p/ftisp/goods/export')
                $form.submit();
                $form.find("input[name=jsonString]").val('');
            });
        }
    });
    //删除
    $("#main-table").on("click","a[name=delete]",function () {
        var selectRow = table.row($(this).parent().parent()).data();
        var obj = {"id":selectRow.id};
        var data = [obj];
        $confirm("你确认删除此列数据？",function () {
            deleteRow(data);
        });
    });
    //修改
    $("#main-table").on("click","a[name=edit]",function () {
        var selectRow = table.row($(this).parent().parent()).data();
        window.location.href = "commodity-update?id="+selectRow.id;
    });
    //提交
    $("#main-table").on("click","a[name=commit]",function () {
        var selectRow = table.row($(this).parent().parent()).data();
        var obj = {"id":selectRow.id};
        var data = [obj];
        $confirm("确认提交此商品信息？",function () {
            optfun('api/v1/p/ftisp/goods/commit',data);
        });
    });

    //关闭上传页面
    $("#export").on("hide.bs.modal",function () {
        table.draw();
    });

    //商品详情
    $("#main-table").on("click","a[name=detail]",function () {
        var selectRow = table.row($(this).parent().parent()).data();
        window.location.href="commodity-detail?id="+selectRow.id;
    });

    $("#main-table").on("click","a[name=print]",function () {
        var selectRow = table.row($(this).parent().parent()).data();
        $("#goodsCode").html(selectRow.code);
        $("#print_form input[name=code]").val(selectRow.code);
        $("#printLable").modal("show");
    });
    $("#print").on("click",function () {
        $("#print_form1").submit();
    })

});
//表格初始化
function tableinit() {
    table = $('#main-table').DataTable(
        $.extend({},tableSetting,{
            ajax: {
                url: "api/v1/p/ftisp/goods/list",
                data: function ( d ) {
                    var start = d.start;
                    var length = d.length;
                    d.code = $('#code').val();
                    d.chName = $('#chName').val();
                    d.orderAuditSts = $('#orderAuditSts').val();
                    d.isFoam = $('#isFoam').val();
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
                { data: "code"},
                { data: "chName"},
                { data: "enName"},
                { data: "spec"},
                { data: "factLength"},
                { data: "factGrossWeight"},
                { data: "isFoam"},
                { data: "feeWeight"},
                { data: "orderAuditSts"},
                { data: null}
            ],
            columnDefs: [ {
                targets: 1,
                searchable: false,
                render: function(data, type, full) { // 返回自定义内容
                    return " <input type='checkbox' name='checkList'>";
                }
            },{
                targets:2 ,
                render:function (data,type,full) {
                    return "<a href='javascript:;' name='detail'>"+data+"</a>";
                }
            },
                {
                    targets:5,
                    render: function (data,type,full) {
                        return data+","+full.model;
                    }
                },
                {
                    targets: 6, // 目标列位置，下标从0开始
                    render: function(data, type, full) { // 返回自定义内容

                        return data+"X"+full.factWidth +"X"+full.factHigh ;

                    }
                },
                {
                    targets: 8, // 目标列位置，下标从0开始
                    render: function(data, type, full) { // 返回自定义内容
                        if(data =='Y' ){
                            return '是';
                        }else if(data = 'N'){
                            return '否';
                        }
                    }
                },
                {
                    targets: 10, // 目标列位置，下标从0开始
                    render: function(data, type, full) { // 返回自定义内容
                        switch (data){
                            case 'U':
                                return '未提交';
                            case 'C':
                                return '已提交';
                            case 'P':
                                return '审核通过';
                            case 'R':
                                return '<span  title="'+full.orderRejectReason+'">审核失败</span>';
                            default:
                                return '';
                        }
                    }
                },{
                targets: 11,
                searchable: false,
                render: function(data, type, full) { // 返回自定义内容
                    switch (full.orderAuditSts){
                        case 'U':
                            return "<a class='btn btn-default' href='javascript:;' name='commit'><i class='glyphicon glyphicon-ok'></i>提交</a><br>" +
                                "<a class='btn btn-default' href='javascript:;' name='edit'><i class='glyphicon glyphicon-pencil'></i>修改" +
                                "</a><br><a class='btn btn-default' href='javascript:;' name='delete'><i class='glyphicon glyphicon-remove'></i>删除</a>";
                        case 'C':
                            return '';
                        case 'P':
                            return "<a class='btn btn-default' href='javascript:;' name='print'><i class='glyphicon glyphicon-print'></i>打印标签</a>";
                        case 'R':
                            return  "<a href='javascript:;' class='btn btn-default' name='edit'><i class='glyphicon glyphicon-pencil'></i>修改</a><br>" +
                                "<a class='btn btn-default' href='javascript:;' name='delete'><i class='glyphicon glyphicon-remove'></i>删除</a>";
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
        'uploader' : 'api/v1/p/ftisp/goods/import',
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

            }else{
                $alert(obj.message);
            }
            table.draw(false);
        }
    });
}
function uploadinit2() {
    $("#uploadify2").uploadify({
        'uploader' : 'api/v1/p/ftisp/goods/importPrint',
        'fileObjName':'Filedata',
        'method':'post',
        'swf' : 'static/modules/uploadify/uploadify.swf',
        'queueID' : 'fileQueue2',//与下面的id对应
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
            if(obj.code == 400){
                $alert("单次打印条码数量不能超过100条");
            }else if(obj.code ==200){
                /*$("#printSubmit input[name=madeAddress]").val($("select[name=madeAddress]").val());
                $("#printSubmit input[name=labelSize]").val($("select[name=labelSize]").val());*/
                $("#printSubmit input[name=id]").val(obj.data.id);
                if ( obj.data.id != undefined
                    && obj.data.id != ""){
                    $("#printSubmit").submit();
                    return false;
                }
                $alert("请先上传打印文件");
            }
        }
    });
}
//组装id
function installId(selectRow) {
    var jsonString = [];
    $.each(selectRow,function (index,obj) {
        jsonString[index] = {"id":obj.id};
    })
    return jsonString;
}

//删除
function deleteRow(data) {
    $.ajax({
        url:'api/v1/p/ftisp/goods/delete',
        type:'post',
        contentType: "application/json; charset=utf-8",
        data:JSON.stringify(data),
        dataType:'json',
        success:function (result) {
            if(result.code!='200'){
                $alert(result.message);
            }else{
                table.draw(false);
            }
        }
    });
}
//ajax操作通用 url 地址 data 数据
function optfun(url,data) {
    $.ajax({
        url:url,
        type:'post',
        contentType: "application/json; charset=utf-8",
        data:JSON.stringify(data),
        dataType:'json',
        success:function (result) {
            if(result.code!='200'){
                $alert(result.message);
            }else{
                table.draw(false);
            }
        },
        error:function (e) {
            $alert("删除列表失败，请联系管理员")
        }
    });
}

