/**
 * author zzy 2017-4-18
 */
var $ = require('jquery');
var $validator = require('libs/validator');
var $alert = require('libs/alert');
require('libs/bootstrap-typeahead');
var table;
$(function () {
    //出库单表单验证
    formValidationinit();
    //商品添加表单初始化
    goodsValidationinit();
    //国家下拉框初始化
    areainit('country',1,0);
    //海外仓下拉框初始化
    warehouseinit();
    //加载数据初始化
    updateinit();
    //出库商品table 初始化
    tableinit([]);
    //隐藏id列
    table.column(1).visible(false);
    //商品添加表单提交
    $('#goods_add_table button:last').on("click",function () {
        $('#goods_add_table').submit();
    });
    $('#goods_add_table button:first').on("click",function () {
        if($("#goods_add_table").valid()){
            $('#goods_add_table').submit();
            $('#goods_add_table input').val('');
            $("#tableAdd").modal("hide");
        }
    });
    $('#submit_form').on('click',function (e) {
        $('#outstore_form').submit();
    })
    $('#tableAdd').on('hidden.bs.modal', function () {
        // 执行一些动作...
        $('#goods_add_table input').val('');
        $('#goods_add_table input').removeClass('error');
        $('#goods_add_table .is-error').html('');
        //解决自动补全不选
        $('#goods_add_table input:eq(0)').attr("disabled",false);
        $('#goods_add_table button:last').html('下一件');
        $('#myModalLabel').html('商品添加');
    });
    //删除商品
    $("#outstore_table").on("click",'a[name=delete]',function () {
        var $this = $(this);
        $('.form-goods-info span strong').text(1*$('.form-goods-info span strong').html()-1);
        table.row($this.parents("tr")).remove().draw();
    });
    //解决自动补全不选
    $('#goods_add_table input:eq(0)').on("input",function(){
        $('#goods_add_table input').not(this).val('');
    });
    //更新商品
    $("#outstore_table").on("click",'a[name=update]',function () {
        var $this = $(this);
        $(this).parents("tbody").find("a.update").removeClass("update");
        $(this).addClass("update");
        var selectData =  table.row($(this).parents("tr")).data();
        $('#goods_add_table input:eq(0)').val(selectData.code);
        //解决自动补全不选
        $('#goods_add_table input:eq(0)').attr("disabled","disabled");
        $('#goods_add_table input:eq(2)').val(selectData.chName);
        $('#goods_add_table input:eq(3)').val(selectData.spec);
        $('#goods_add_table input:eq(4)').val(selectData.nums);
        $('#goods_add_table input:eq(5)').val(selectData.weightKg);
        $('#goods_add_table input:eq(7)').val(selectData.weightLbs);//2.204623
        if(selectData.nums==0){
            $('#goods_add_table input:eq(6)').val(0);
            $('#goods_add_table input:eq(8)').val(0);
        }else{
            $('#goods_add_table input:eq(6)').val(selectData.weightKg/selectData.nums);
            $('#goods_add_table input:eq(8)').val(selectData.weightLbs/selectData.nums);
        }
        $('#goods_add_table input:eq(9)').val(selectData.goodsId);
        $('#goods_add_table input:eq(10)').val(selectData.code);
        $('#goods_add_table button:last').html('保存');
        $('#myModalLabel').html('商品修改');
        var warehouseId = $('#warehouseId').val();
        $.post("api/v1/p/ftisp/goodsStock/queryGoodsNotSubCode", { subCode : selectData.code,warehouseId : warehouseId }, function (result) {
            if(result.code==200){
                if(result.data!=null){
                    $('#goods_add_table input:eq(1)').val(result.data[0].stockNums);
                }
            }else{
                $alert(result.message);
            }
        });
        $('#tableAdd').modal("show");
    });
    $('#goods_add_table input:eq(4)').on("input",function () {
        var $this = $('#goods_add_table input:eq(4)');
        var $ndiv = $this.parent().next("div");
        if($this.val()==''){
            $('#goods_add_table input:eq(5)').val('');
            $('#goods_add_table input:eq(7)').val('');
        }else if(isNaN($this.val())){
            $('#goods_add_table input:eq(5)').val('');
            $('#goods_add_table input:eq(7)').val('');
        }else{
            if($this.val()*1>$('#goods_add_table input:eq(1)').val()*1){
                $this.parents('.form-group').addClass("error");
                $ndiv.empty();
                $ndiv.append('<span id="stock-error" class="error-info">不得大于库存</span>')
            }else{
                $this.parents('.form-group').removeClass("error");
                $ndiv.empty();
                $('#goods_add_table input:eq(5)').val(Number($('#goods_add_table input:eq(6)').val()*$('#goods_add_table input:eq(4)').val()).toFixed(4));
                $('#goods_add_table input:eq(7)').val(Number($('#goods_add_table input:eq(8)').val()*$('#goods_add_table input:eq(4)').val()).toFixed(4));
            }
        }
    });
    //商品编码自动补全
    $('#goods_add_table input:eq(0)').typeahead({
        source:function (query, process){
            var warehouseId = $('#warehouseId').val();
            if(warehouseId==''){
                $('#goods_add_table input:eq(0)').val('');
                $alert("请先选择海外仓");
                return;
            }else{
                $.post("api/v1/p/ftisp/goodsStock/queryGoods", { subCode : query,warehouseId : warehouseId }, function (result) {
                    if(result.code==200){
                        var data = [];
                        if(result.data!=null){
                            $.each(result.data,function (index,obj) {
                                data.push(obj.code+"-"+obj.chName+":"+obj.stockNums+"件");
                            });
                        }
                        process(data);
                    }else{
                        $alert(result.message);
                    }
                });
            }
        },
        items: 15,
        updater:function (item) {
            var obj = item.split('-');
            var stock = item.substring(item.indexOf(":")+1,item.indexOf("件"));
            $.ajax({
                url:'api/v1/p/ftisp/goods/queryByCode',
                type:'post',
                async: false,
                data:{
                    code:obj[0]
                },
                dataType:'json',
                success:function (result) {
                    if(result.code == 200){
                        var data = result.data;
                        $('#goods_add_table input:eq(1)').val(stock);
                        $('#goods_add_table input:eq(2)').val(data.chName);
                        $('#goods_add_table input:eq(3)').val(data.spec+","+data.model);
                        if(data.factGrossWeight!=null&&data.factGrossWeight!=''){
                            $('#goods_add_table input:eq(5)').val(data.factGrossWeight);
                            $('#goods_add_table input:eq(6)').val(data.factGrossWeight);
                            $('#goods_add_table input:eq(7)').val(Number(2.204623*data.factGrossWeight).toFixed(4));//2.204623
                            $('#goods_add_table input:eq(8)').val(Number(2.204623*data.factGrossWeight).toFixed(4));
                        }else{
                            $('#goods_add_table input:eq(5)').val(data.regGrossWeight);
                            $('#goods_add_table input:eq(6)').val(data.regGrossWeight);
                            $('#goods_add_table input:eq(7)').val(Number(2.204623*data.regGrossWeight).toFixed(4));
                            $('#goods_add_table input:eq(8)').val(Number(2.204623*data.regGrossWeight).toFixed(4));
                        }
                        $('#goods_add_table input:eq(9)').val(data.id);
                        $('#goods_add_table input:eq(4)').val('');
                    }else{
                        $alert(result.message);
                    }
                }
            });
            return obj[0];
        },
        delay: 800 //延迟时间
    });
    $('#warehouseId').on("change",function () {
        if($('#warehouseId').val()==''){
            $('#delivery').text('');
            $('#doorplate').css('display','none');
        }else{
            deliveryinit($('#warehouseId').val());
            $('#doorplate').css('display','block');
        }
    });
    $('#delivery').on("change",function () {
        if($('#delivery').val()=='1'){
            $('#doorplate').css('display','block');
        }else{
            $('#doorplate').css('display','none');
        }
    });
    $('#outstore_form button:last').on("click",function () {
        if($('.form-goods-info span strong').html()==0){
            $alert("商品不能为空");
        }
    });
    $('#outstore_submit').on("click",function () {
        if($('.form-goods-info span strong').html()==0){
            $alert("商品不能为空");
        }
    });
});
function updateinit() {
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
function datainit(data) {
    $('#recipientRegionName').val(data.recipientRegionName);
    $('#recipientCityName').val(data.recipientCityName);

    $('#id').val(data.id);
    $('#warehouseId').val(data.warehouseId);
    $('#platType').val(data.platType);
    $('#platOrderNo').val(data.platOrderNo);
    $('#name').val(data.recipientName);
    $("#country").val(data.recipientCountryId);
    $("#region").val(data.recipientRegionId);
    $("#city").val(data.recipientCityId);
    $('#recipientZipcode').val(data.recipientZipcode);
    $("#recipientAddress1").val(data.recipientAddress1);
    $("#recipientAddress2").val(data.recipientAddress2);
    $('#recipientPhone').val(data.recipientPhone);
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
            { data: null,"targets": 8}
        ],
        columnDefs:[
            {
                targets: [8],
                data:null,
                render: function(data, type, full) { // 返回自定义内容
                    return "<a href='javascript:;' name='update'>修改</a>|<a href='javascript:;' name='delete'>删除</a>" ;
                }
            }
        ]
    })
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
//表单验证
function  formValidationinit() {
    $validator({form:'#outstore_form'},{
        warehouseId:{required:true},platType:{required:true},nameFirst:{required:true},
        nameSecond:{required:true},recipientCountryId:{required:true},recipientRegionId:{required:true},
        recipientCityId:{required:true},recipientZipcode:{required:true},recipientAddress1:{required:true},
        recipientPhone:{required:true},deliveryWayId:{required:true}
    },{warehouseId:{required:'海外仓不能为空'},platType:{required:'电商平台不能为空'},
        nameFirst:{required:'姓不能为空'},nameSecond:{required:'名不能为空'},
        recipientCountryId:{required:'国家不能为空'},recipientRegionId:{required:'州不能为空'},
        recipientCityId:{required:'城市不能为空'},recipientZipcode:{required:'邮编不能为空'},
        recipientAddress1:{required:'地址一不能为空'},recipientPhone:{required:'联系电话不能为空'},deliveryWayId:{required:'发货方式不能为空'}
    },asyfun,function (result) {
        if(result.code == 200){
            window.location.href="deliver-order";
        }else{
            $alert(result.message);
        }
    });
}
//商品编码相同判断
function goodsValid() {
    var $this = $("#goods_add_table input[name=code]");
    var codeFlag =true;
    if($this.val()!=''){
        table.data().each(function (v,k) {
            if($this.val() == v.code){
                codeFlag = false;
                return false;
            }
        })
    }
    if($('#goods_add_table input:eq(10)').val()!=''&&codeFlag==false){
        if($('#goods_add_table input:eq(10)').val()==$this.val()){
            codeFlag = true;
        }
    }
    var $ndiv = $this.parent().next("div");
    if(!codeFlag){
        $this.parents('.form-group').addClass("error");
        $ndiv.append('<span id="boxNo-error" class="error-info">该商品已添加</span>')
    }else{
        $this.parents('.form-group').removeClass("error")
        $ndiv.empty();
    }
    var $this1 = $('#goods_add_table input:eq(4)');
    var $ndiv1 = $this1.parent().next("div");
    var numsFlag =true;
    if($this1.val()*1<=0){
        $this1.parents('.form-group').addClass("error");
        $ndiv1.append('<span id="stock-error" class="error-info">库存必须大于0</span>')
        numsFlag = false;
    }else {
        if($this1.val()*1>$('#goods_add_table input:eq(1)').val()*1) {
            $this1.parents('.form-group').addClass("error");
            $ndiv1.append('<span id="stock-error" class="error-info">不得大于库存</span>')
            numsFlag = false;
        }else{
            $this1.parents('.form-group').removeClass("error");
            $ndiv1.empty();
        }
    }
    return codeFlag&&numsFlag;
}
//商品添加表单验证
function goodsValidationinit() {
    $validator({form:'#goods_add_table'},{
        code:{required:true},nums:{required:true,number:true}},{
        code:{required:'商品编码不能为空'},nums:{required:'数量不能为空',number:'数量为数字格式'}},
        function(){
            return true;
        },
        function () {
        var flag =goodsValid(); if(!flag){ return false;}
        var stockNums = $('#goods_add_table input:eq(1)').val();
        //解决自动补全不选
        if(stockNums==''){
            $alert("该商品不存在或没有库存");
            $('#goods_add_table input').val('');
            return false;
        }
        var data = {};
        data["goodsId"]= $('#goods_add_table input:eq(9)').val();
        data["code"]= $('#goods_add_table input:eq(0)').val();
        data["chName"]= $('#goods_add_table input:eq(2)').val();
        data["spec"]= $('#goods_add_table input:eq(3)').val();
        data["nums"]= $('#goods_add_table input:eq(4)').val();
        data["weightKg"]= $('#goods_add_table input:eq(5)').val();
        data["weightLbs"]= $('#goods_add_table input:eq(7)').val();
        if($('#goods_add_table input:eq(10)').val()==''){
            $('.form-goods-info span strong').text(1*$('.form-goods-info span strong').html()+1);
            table.row.add(data);
        }else{
            var $a = $("#outstore_table a.update");
            var odata =table.row($a.parents("tr")).data();
            odata.goodsId = $('#goods_add_table input:eq(9)').val();
            odata.code = $('#goods_add_table input:eq(0)').val();
            odata.chName = $('#goods_add_table input:eq(2)').val();
            odata.spec = $('#goods_add_table input:eq(3)').val();
            odata.nums = $('#goods_add_table input:eq(4)').val();
            odata.weightKg = $('#goods_add_table input:eq(5)').val();
            odata.weightLbs = $('#goods_add_table input:eq(7)').val();
            table.row($a.parents("tr")).data(odata) ;
            $('#tableAdd').modal("hide");
            $('#goods_add_table button:last').html('下一件');
            $('#myModalLabel').html('商品添加');
        }
        $('#goods_add_table input').val('');
        table.draw(false);
    });
}

//组装信息
function asyfun() {
    var json = $('#outstore_form').serializeObject();
    var data = [];
    table.data().each(function (v,k) {
        data.push(v);
    });
    json["goods"] = data;
    json["recipientName"] = json["name"];
    return json;
}