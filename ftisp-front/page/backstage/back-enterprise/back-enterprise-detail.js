/**
 * Created by zzy on 2017/04/28.
 */
var $ = require("jquery");
var $alert = require('libs/alert');
$(function () {
    queryArea(1,0);
    queryCompany($.getUrlParam('id'));
});
//加载企业信息
function queryCompany(id) {
    $.ajax({
        url:'api/v1/p/ftisp/enterpriseInfo/load',
        type:'post',
        data:{
            id:id
        },
        dataType:'json',
        success:function (result) {
            if(result.code ==200){
                 var arr = result.data.linkTel.split("-");
                var no = 0;
                  result.data.linkTel  = arr[0];
                  result.data["linkTel1"] = arr[1];
                queryArea(2,result.data.countryId);
                queryArea(3,result.data.provinceId);
                queryArea(4,result.data.cityId);
                  $("#company_form").setForm(result.data);
                  $.each(result.data.enterPics,function (index,data) {
                      if(data.objectType =='EnterBsLicense'){
                          $("#company_form div.example:first").hide();
                          var $div =  $("#company_form div.certificates:first").show();
                          $div.find("img").attr("src",data.filePath);
                          $div.find("img").data("text",data.id);
                      }else if(data.objectType =='EnterTax'){
                         no++;
                          if(no >2){
                              return false;
                          }
                          $("#company_form div.example:eq("+no+")").hide();
                          var $div =  $("#company_form div.certificates:eq("+no+")").show();
                          $div.find("img").attr("src",data.filePath);
                          $div.find("img").data("text",data.id);
                      }else if(data.objectType =='EnterOrganCode'){
                          $("#company_form div.example:last").hide();
                          var $div =  $("#company_form div.certificates:last").show();
                          $div.find("img").attr("src",data.filePath);
                          $div.find("img").data("text",data.id);
                      }
                  })
            }else{
                $alert(result.message);
            }
        }
    })
}
//地域查询
function queryArea(level,parentId) {
    $.ajax({
        url:'api/v1/p/ftisp/area/query',
        type:'post',
        data:{
            level:level,
            parentId:parentId
        },
        async:false,
        dataType:'json',
        success:function (result) {
            if(result.code == 200){
                appendSelect(level,result.data);
            }else{
                console.error(result.message);
            }
        }
    })
}

//四级联动
function appendSelect(level,data) {
    var $select = null;
    if(level == 1){
        $select = $("#countryId");
    }else if(level ==2){
        $select = $("#provinceId");
    }else if(level ==3){
        $select = $("#cityId");
    }else{
        $select = $("#areaId");
    }
    $select.empty();
    var option ="";
   $.each(data,function (index,obj) {
       option +="<option value='"+obj.id+"'>"+obj.name+"</option>";
   })
    $select.append(option);
}


