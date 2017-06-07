define('page/user-center/info/enterprise/enterprise', ['require', 'exports', 'module', "components/jquery/jquery", 'static/libs/alert'], function(require, exports, module) {

  /**
   * Created by csy on 2017/4/24.
   */
  require("components/jquery/jquery")
  var $alert = require('static/libs/alert');
  $(function () {
      isHasCompany();
  })
  
  function isHasCompany() {
      var  id = $("#id").val();
      if(id==''){
          $("div.no-messages").show();
          $("#company_add").on("click",function () {
              window.location.href = "enterprise-update"
          })
      }else{
          $("#company_update").show();
          $("div.company-info").show();
          $("#company_update").on("click",function () {
              window.location.href = "enterprise-update?id="+id;
          })
          queryCompany(id);
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
                  appendInfo(result.data);
              }else{
                  $alert(result.message);
              }
          },
          error:function (e) {
              $alert("加载企业信息失败！请联系管理员。")
          }
      })
  };
  //填写企业信息
  function appendInfo(data) {
      $("#info_company strong:first").html(data.linkMan);
      $("#linkPhone").html(data.linkPhone )
      if(data.linkTel.indexOf("-") == 0){
          data.linkTel = data.linkTel.substr(1,data.linkTel.length);
      }
      $("#info_company span[name=linkTel]").html(data.linkTel);
      $("#info_company span[name=address]").html(data.province +data.city +data.area +data.address);
      $("#info_company span[name=zipCode]").html(data.zipCode);
      $("#info_company div[name=corpSocialNo]").html("社会征信号: "+data.corpSocialNo);
      if(data.type=='E'){
          $("#info_company span[name=type]").html("企业客户");
      }  else{
          $("#info_company span[name=type]").html("个人客户");
      }
      $("#info_company span[name=name]").html(data.name);
      $("#info_company span[name=linkmanDuty]").html(data.linkmanDuty  );
      $("#info_company span[name=fax]").html(data.fax );
      $("#info_company span[name=email]").html(data.email );
      $("#info_company span[name=QQ]").html(data.qq);
      $("#info_company span[name=email]").html(data.email );
      $("#info_company span[name=emergencyLinkMan]").html(data.emergencyLinkMan  );
      $("#info_company span[name=emergencyLinkTel]").html(data.emergencyLinkTel );
      $("#info_company span[name=saleEmail]").html(data.saleEmail);
      $("#info_company span[name=busiLicense]").html(data.busiLicense );
      var enterBsLicense=0,enterTax=0,enterOrganCode=0;
      $.each(data.enterPics ,function (index,obj) {
          if(obj.objectType == 'EnterBsLicense'){
              enterBsLicense++
              if(enterBsLicense<3){
                  $("#info_company img[name=enterBsLicense"+enterBsLicense+"]").show().attr("src",obj.filePath);
              }
          }else if(obj.objectType == 'EnterTax'){
              enterTax++;
              if(enterBsLicense<3){
                  $("#info_company img[name=enterTax"+enterTax+"]").show().attr("src",obj.filePath);
              }
          }else if(obj.objectType == 'EnterOrganCode'){
              enterOrganCode++;
              if(enterBsLicense<3){
                  $("#info_company img[name=enterOrganCode"+enterOrganCode+"]").show().attr("src",obj.filePath);
              }
          }
      })
  }
  

});