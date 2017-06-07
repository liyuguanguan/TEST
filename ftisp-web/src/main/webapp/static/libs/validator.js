define('static/libs/validator', ['require', 'exports', 'module', 'components/jquery/jquery', 'static/libs/ajaxfileupload', 'components/jquery-validation/jquery.validate', 'components/jquery-validation/localization/messages_zh'], function(require, exports, module) {

  /**
   * Created by zzy csy on 2017/4/12.
   * 表单验证
   */
  var $ = require('components/jquery/jquery');
  require('static/libs/ajaxfileupload');
  require('components/jquery-validation/jquery.validate');
  require('components/jquery-validation/localization/messages_zh');
  $.validator.setDefaults({
      ignore: 'input[type=hidden]',
      highlight: function(element) {
          $(element).parents(".form-group").addClass('has-error');
      },
      unhighlight: function(element) {
          $(element).parents(".form-group").removeClass('has-error');
      },
      errorElement: 'span',
      errorPlacement: function(error, element) {
          var $target = element.parents(".form-group").find(".error");
          $target.append(error);
  
        //  error.appendTo($target);
         // $target.html(error);
      }
  });
  //小数0.12
  jQuery.validator.addMethod("isFlot", function(value, element) {
      var tel = /^0.\d+$/;
      return this.optional(element) || (tel.test(value));
  }, "请正确填写出口退税率");
  //包含特殊字符
  jQuery.validator.addMethod('hasSpecial',function (value,element) {
      value = $.trim(value)
      var tel = /((?=[\x21-\x7e]+)[^A-Za-z0-9])/;
      var sp = /\s/
      return  (!tel.test(value))&&!sp.test(value);
  },"该字段不能有特殊字符和空格");
  
  //电话验证
  jQuery.validator.addMethod('phoneVerify',function (value,element) {
      value = $.trim(value)
      var tel = /^1[34578]\d{9}$/;
      var sp = /^((0\d{2,3}\d{7,8})|(1[3584]\d{9}))$/;
      return  ((tel.test(value))||(sp.test(value))) && (value.length == 11);
  },"联系电话格式不正确");
  
  //邮箱验证
  jQuery.validator.addMethod('emailVerify',function (value,element) {
      value = $.trim(value);
      var reg = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
      return (reg.test(value));
  },"邮箱格式不正确")
  //小数点保留位数
  jQuery.validator.addMethod("dPlaces",function (value,element,parms) {
      var   i = value.indexOf('.');
      if(i<0){
          return true;
      }else{
          var places = value.length-1-i;
          if(parseInt(places) > parseInt(parms)){
              return false;
          }else{
              return true;
          }
      }
  })
  //小数0.12
  jQuery.validator.addMethod("isFlot", function(value, element) {
      var tel = /^0.\d+$/;
      return this.optional(element) || (tel.test(value));
  }, "请正确填写出口退税率");
  //包含特殊字符
  jQuery.validator.addMethod('hasSpecial',function (value,element) {
      value = $.trim(value)
      var tel = /((?=[\x21-\x7e]+)[^A-Za-z0-9])/;
      var sp = /\s/
      return  (!tel.test(value))&&!sp.test(value);
  },"该字段不能有特殊字符和空格");
  
  //电话验证
  jQuery.validator.addMethod('phoneVerify',function (value,element) {
      value = $.trim(value)
      var tel = /^1[34578]\d{9}$/;
      var sp = /^((0\d{2,3}\d{7,8})|(1[3584]\d{9}))$/;
      return  ((tel.test(value))||(sp.test(value))) && (value.length == 11);
  },"联系电话格式不正确");
  
  //邮箱验证
  jQuery.validator.addMethod('emailVerify',function (value,element) {
      value = $.trim(value);
      var reg = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
      return (reg.test(value));
  },"邮箱格式不正确")
  //小数点保留位数
  jQuery.validator.addMethod("dPlaces",function (value,element,parms) {
      var   i = value.indexOf('.');
      if(i<0){
          return true;
      }else{
          var places = value.length-1-i;
          if(parseInt(places) > parseInt(parms)){
              return false;
          }else{
              return true;
          }
      }
  });
  $.validator.addMethod('ltHundred',function (value,element) {
      value = $.trim(value);
      var numericRegex = /^[0-9]+$/;
      var flag = 1*value <= 100&&1*value >0;
      return  numericRegex.test(value)&&flag;
  },"该字段必须为0-100的整数");
  module.exports = function(opt,rule,msg,asyfun,callback) {
      var $thisForm = $(opt.form);
      var $btn = $(opt.button);
      var isAjax = opt.ajax || true;
      var url = $thisForm.attr('action');
      //是否为图片上传
      var pic = opt.pic;
      $thisForm.validate({
          rules:rule,
          messages:msg,
          submitHandler: function(form) {
              // 已经通过了验证
              if(isAjax){
                  var data = asyfun();
                  if(!data){
                      return false;
                  }
                  $btn.button('loading');
                  if(pic){
                      $.ajaxFileUpload({
                          url: url,
                          secureuri: false,
                          dataType: 'json',
                          fileElementId: pic,
                          data: data,
                          success: function (response){
                              callback(response);
                              $btn.button('reset');
                          }
                      });
                  }else{
                      if(callback!=undefined){
                          if (url!=''&&url!=undefined){
                              $.ajax(url, {
                                  method: 'POST',
                                  contentType: "application/json; charset=utf-8",
                                  data: JSON.stringify(data)
                              })
                                  .then(function(response) {
                                      callback(response);
                                      $btn.button('reset');
                                  });
                          }else{
                              callback();
                          }
                      }
                  }
              }else{
                  form.submit();
                  if(callback != undefined){
                      callback();
                  }
              }
          }
      });
  };
  

});