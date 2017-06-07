define('page/user-center/info/enterprise/enterprise-update', ['require', 'exports', 'module', "components/jquery/jquery", "static/modules/uploadify/jquery.uploadify", 'static/libs/alert', 'static/libs/validator'], function(require, exports, module) {

  /**
   * Created by csy on 2017/04/28.
   */
  var $ =require ("components/jquery/jquery")
  require ("static/modules/uploadify/jquery.uploadify")
  var $alert = require('static/libs/alert');
  var $form = require('static/libs/validator');
  $(function () {
      isAddOrUpdate();
      formInit();
      uploadinit();
      $("#company_back").on("click",function () {
          window.history.back();
      })
      $("#submit_form").on("click",function () {
          var $img = $("div.up-credentials div.certificates img");
          if(!$img.data('text')){
              $alert("请上传营业执照照片");
              return false;
          }
          $("#company_form").submit();
      })
  /*    $("#company_add").on("click",function () {
          var $img = $("div.up-credentials:first div.certificates img");
          if(!$img.data('text')){
              $alert("请上传营业执照照片");
              return false;
          }
          $("#company_form").submit();
      })*/
      $("#uploadEnterBsLicense").on("click",function () {
          $("#companyUpload").modal("show");
          $("#companyUpload input[name=type]").val('EnterBsLicense');
      })
      $("#uploadEnterTax1").on("click",function () {
          $("#companyUpload").modal("show");
          $("#companyUpload input[name=type]").val('EnterTax');
          $("#companyUpload input[name=no]").val('1');
      })
      $("#uploadEnterTax2").on("click",function () {
          $("#companyUpload").modal("show");
          $("#companyUpload input[name=type]").val('EnterTax');
          $("#companyUpload input[name=no]").val('2');
      })
      $("#uploadEnterOrganCode").on("click",function () {
          $("#companyUpload").modal("show");
          $("#companyUpload input[name=type]").val('EnterOrganCode');
      })
      //删除图片
      $("#company_form div.certificates span").on("click",function () {
          $(this).parent().hide();
          $(this).parent().prev("div").show();
          $(this).parent().find("img").removeData("text");
      })
      //四级联动
      $("#countryId").on("change",function () {
          if(this.value !=''){
              queryArea(2,this.value);
          //    $("#cityId").change();
          //    $("#areaId").change();
          }else{
              $("#provinceId").empty();
          }
          $("#provinceId").change();
      });
      $("#provinceId").on("change",function () {
          console.log(this.value);
          if(this.value !=''){
              queryArea(3,this.value);
         //     $("#areaId").change();
          }else{
              $("#cityId").empty();
          }
          $("#cityId").change();
      });
      $("#cityId").on("change",function () {
          console.log(this.value=='');
          if(this.value !=''){
              queryArea(4,this.value);
          }else{
              $("#areaId").empty();
          }
      });
  });
  
  function formInit() {
      $form({form:"#company_form"},{
          linkMan:{required:true},linkPhone:{required:true,number:true,maxlength:11},linkTel:{required:true,number:true},linkTel1:{required:true,number:true,maxlength:8},
          address:{required:true,maxlength:125},zipcode:{required:true,number:true,maxlength:6},busiLicense:{required:true},linkmanDuty:{required:true},
              email:{required:true,email:true,maxlength:30},emergencyLinkMan:{required:true},emergencyLinkTel:{required:true,maxlength:14},name:{required:true},
              corpSocialNo:{maxlength:30},qq:{digits:true},fax:{digits:true,maxlength:14},saleEmail:{email:true}
      },{linkMan:{required:'联系人为必填字段'},linkPhone:{required:'联系人手机号为必填字段'},linkTel:{number:''},linkTel1:{required:'固定电话为必填',number:'联系人电话为数字'},
          address:{required:'地址为必填字段'},zipcode:{required:'邮编不能为空',number:'邮编必须填写数字'},busiLicense:{required:'营业执照为必填字段'},
              linkmanDuty:{required:'联系人职务不能为空'},email:{required:'联系人邮箱不能为空'},emergencyLinkMan:{required:'紧急联系人不能为空'},qq:{digits:'qq号必须位数字'},
              emergencyLinkTel:{required:'紧急联系人电话不能为空',maxlength:'紧急联系人电话长度不能超过14个字符'},name:{required:'客户名称不能为空'},corpSocialNo:{maxlength:'社会征信号不能超过30个字符'}
              ,fax:{digits:'联系人传真必须为数字',maxlength:'联系人传真长度不能超过14个字符'},saleEmail:{email:'销售代表邮箱格式不正确'}
      },asyFun,
          function (result) {
              if(result.code ==200){
                  window.location.href="enterprise";
              }else{
                 $alert(result.message);
              }
      });
  }
  //组装数据
  function asyFun() {
      var json = $("#company_form").serializeObject();
      json.linkTel = json.linkTel+"-"+json.linkTel1;
      var picInfos = [];
      $("#company_form div.certificates img").each(function () {
          var pid = $(this).data("text");
          if(pid != undefined){
              var pids = {};
              pids["picId"]=pid;
              picInfos.push(pids);
          }
      })
      json["picInfos"] = picInfos;
      return json;
  }
  
  function isAddOrUpdate() {
     queryArea(1,0);
      var url =window.location.href;
      if(url.indexOf("id=")>0){
          $("#company_form").attr("action","api/v1/p/ftisp/enterpriseInfo/update");
          var i =url.indexOf('id=');
          var id =url.substr(i+3,url.length);
          queryCompany(id);
      }else{
          queryArea(2,4);
          queryArea(3,1);
          queryArea(4,2);
      }
  }
  
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
          },
          error:function (e) {
              $alert("加载企业信息失败！请联系管理员。")
          }
      })
  };
  
  //upload初始化
  function uploadinit() {
      $("#uploadify").uploadify({
          'uploader' : 'api/v1/p/ftisp/fileoper/doUpload',
          'method':'post',
          'swf' : 'static/modules/uploadify/uploadify.swf',
          'queueID' : 'fileQueue',//与下面的id对应
          'queueSizeLimit' : 1,
          'fileTypeDesc' : '请选择jpg,png,jpeg,gif',
          'fileTypeExts' : '*.jpg;*.png;*.jpeg;*.gif', //控制可上传文件的扩展名，启用本项时需同时声明fileDesc
          'auto' : false,
          'multi' : true,
          'simUploadLimit' : 1,
          'buttonText' : '选择文件',
          'fileSizeLimit' : '3MB',
          'onUploadStart':function (file) {
              $("#uploadify").uploadify('settings','formData',{type:$("#companyUpload input[name=type]").val()})
          },
          'onUploadSuccess':function(file, data, response){
              var obj = JSON.parse(data);
              var type = $("#companyUpload input[name=type]").val();
              if(type=='EnterBsLicense'){
                  $("#company_form div.example:first").hide();
                  var $div =  $("#company_form div.certificates:first").show();
                  $div.find("img").attr("src",obj.data[0].filePath);
                  $div.find("img").data("text",obj.data[0].id);
              }else if(type=='EnterTax'){
                  var no =$("#companyUpload input[name=no]").val();
                  $("#company_form div.example:eq("+no+")").hide();
                  var $div =  $("#company_form div.certificates:eq("+no+")").show();
                  $div.find("img").attr("src",obj.data[0].filePath);
                  $div.find("img").data("text",obj.data[0].id);
              }else if(type=='EnterOrganCode'){
                  $("#company_form div.example:last").hide();
                  var $div =  $("#company_form div.certificates:last").show();
                  $div.find("img").attr("src",obj.data[0].filePath);
                  $div.find("img").data("text",obj.data[0].id);
              }
          }
      });
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
          },
          error:function (e) {
              console.error("api/v1/p/ftisp/area/query 接口调用失败!");
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
  
  
  

});