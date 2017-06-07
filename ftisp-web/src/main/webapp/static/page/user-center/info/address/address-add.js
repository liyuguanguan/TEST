define('page/user-center/info/address/address-add', ['require', 'exports', 'module', 'components/jquery/jquery', 'static/libs/validator', 'static/libs/alert', 'static/libs/confirm'], function(require, exports, module) {

  /**
   * author zzy 2017-4-18
   */
  var $ = require('components/jquery/jquery');
  var $validator = require('static/libs/validator');
  var $alert = require('static/libs/alert');
  var $confirm = require('static/libs/confirm');
  $(function () {
      isAddOrUpdate();
      formValide();
      $("#submit").on("click",function () {
          $("#address_form").submit();
      });
      //四级联动
      $("#countryId").on("change",function () {
          if(this.value !=''){
              queryArea(2,this.value);
          }else{
              $("#provinceId").empty();
          }
          $("#provinceId").change();
      });
      $("#provinceId").on("change",function () {
          if(this.value !=''){
              queryArea(3,this.value);
              //     $("#areaId").change();
          }else{
              $("#cityId").empty();
          }
          $("#cityId").change();
      });
      $("#cityId").on("change",function () {
          if(this.value !=''){
              queryArea(4,this.value);
          }else{
              $("#areaId").empty();
          }
      });
  });
  function formValide() {
      $validator({form:"#address_form",button:'#submit'},{
          address:{required:true,maxlength:125},zipCode:{required:true,number:true,maxlength:6},email:{required:true,email:true,maxlength:30},
          linkMan:{required:true},linkPhone:{required:true,number:true,maxlength:13}
      },{
          address:{required:'地址为必填字段'},zipCode:{required:'邮编为必填字段',number:'邮编必须为数字'},
          email:{required:'邮箱地址为必填字段',email:'请填写正确的邮箱地址'},linkMan:{required:'联系人姓名为必填字段'},
          linkPhone:{required:'联系人手机号为必填字段',number:'联系人手机号必须为数字'}
      },function () { return  $("#address_form").serializeObject()},function (result) {
          if(result.code == 200){
              window.location.href = "address";
          }else{
              $alert(result.message);
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
  $("#countryId").trigger("change");
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
  //判断地址更新
  function isAddOrUpdate() {
      queryArea(1,0);
      var url =window.location.href;
      if(url.indexOf("id=")>0){
          var i = url.indexOf("id=");
          var id = url.substr(i+3,url.length);
          loadAddress(id);
          $("span.tap-name").html("地址修改");
          $("#submit_form").html("确认修改");
          $("#address_form").attr("action","api/v1/p/ftisp/address/update");
      }else{
          $("span.tap-name").html("地址新增");
          queryArea(2,4);
          queryArea(3,1);
          queryArea(4,2);
      }
  }
  
  //load address
  function loadAddress(id) {
      $.ajax({
          url:'api/v1/p/ftisp/address/load',
          type:'post',
          data:{
              id:id
          },
          dataType:'json',
          success:function (result) {
              if(result.code == 200){
                  queryArea(2,result.data.countryId);
                  queryArea(3,result.data.provinceId );
                  queryArea(4,result.data.cityId );
                  $("#address_form").setForm(result.data);
              }else{
                  $alert(result.message);
              }
          },
          error:function () {
              $alert("加载数据失败");
          }
      })
  }

});