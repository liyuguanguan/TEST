/**
 * author zzy 2017-4-18
 */
var $ = require('jquery');
var $alert = require('libs/alert');
require('summernote-zh-CN');
$(function () {
    queryGoods();
    $(".radio").off("click");
    appendOption('api/v1/p/ftisp/area/query',{'level':'1','parentId':'0'}
        ,$("#importCountryId"));
});
function queryGoods() {
    var href = window.location.href;
    var i =href.indexOf('id=');
    var id =href.substr(i+3,href.length);
    //查询数据
    $.ajax({
        url:'api/v1/p/ftisp/goods/load',
        type:'post',
        data:{
            id:id
        },
        dataType:'json',
        success:function (result) {
            if(result.code == 200){
                appendDate(result.data);
            }else{
                $alert(result.message);
            }
        }
    });
}


//添加数据
function appendDate(data) {
    $("#goodsDetail_form input[name=factGrossWeight]").val(data.factGrossWeight);
    $("#goodsDetail_form input[name=factLength]").val(data.factLength);
    $("#goodsDetail_form input[name=factWidth]").val(data.factWidth);
    $("#goodsDetail_form input[name=factHigh]").val(data.factHigh);

    $("#goodsDetail_form input[name=chName]").val(data.chName);
    $("#goodsDetail_form input[name=enName ]").val(data.enName );
    $("#goodsDetail_form input[name=code]").val(data.code);
    $("#goodsDetail_form input[name=spec]").val(data.spec);
    $("#goodsDetail_form input[name=model]").val(data.model );
    $("#goodsDetail_form input[name=brand]").val(data.brand);
    $("#goodsDetail_form input[name=regLength]").val(data.regLength );
    $("#goodsDetail_form input[name=regWidth]").val(data.regWidth );
    $("#goodsDetail_form input[name=regHeight]").val(data.regHeight );
    $("#goodsDetail_form input[name=regGrossWeight ]").val(data.regGrossWeight );
    $("#goodsDetail_form input[name=hsCode ]").val(data.hsCode );
    $("#goodsDetail_form input[name=manageType ]").val(data.manageType );
    $("#goodsDetail_form input[name=exportGoodsTax ]").val(data.exportGoodsTax );
    $("#goodsDetail_form select[name=importCountryId ]").val(data.importCountryId );
    $("#goodsDetail_form input[name=declaredPrice  ]").val(data.declaredPrice  );
    $("#goodsDetail_form input[name=importGoodsPrice  ]").val(data.importGoodsPrice  );
    $("#goodsDetail_form input[name=deliveryCycle  ]").val(data.deliveryCycle  );
    $("#goodsDetail_form input[name=detailWebsite  ]").val(data.detailWebsite  );
    if(data.hasBattery =='Y'){
        $("span.radio:first").removeClass("radio_on")
        $("span.radio:eq(1)").addClass("radio_on")
        $("#typeBatt").show();
        if(data.batteryType =='lithium'){
            $("span.radio:eq(2)").removeClass("radio_on")
            $("span.radio:eq(3)").addClass("radio_on")
        }
    }
    $("#goodsDetail_form input[name=keyWord]").val(data.keywords.length);
    var $span = $('#goodsDetail_form span.show-list')
    $.each(data.keywords ,function (index,str) {
        var span = "<span name='"+str+"' class='iteam'>"+str+"<i class='glyphicon glyphicon-remove'></i></span>"
        $span.append(span);
    });
    $.each(data.pics,function (index,obj) {
        appendImage(obj);
    });
    $('#summernote').summernote({
        lang:'zh-CN',
    });
    $('#summernote').summernote('code',data.summary );
    $('#summernote').summernote('disable');
}

//上传图片填加
function  appendImage(data) {
    var image = "<div class='pic-list'><img src='"+data.filePath+"'>" +
        "<i class='glyphicon glyphicon-remove-sign delate'></i></div>";
    $("div.pic-upload").append(image);
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
                            options += "<option value='" + obj.id + "' "+checked+">" + obj.name + "</option>";
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
                    result.data.message+'</span>';
                $select.parent('div').next('div.col-xs-3').append(span);
            }
        }
    })
}
