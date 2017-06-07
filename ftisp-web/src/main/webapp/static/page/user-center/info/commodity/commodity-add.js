define('page/user-center/info/commodity/commodity-add', ['require', 'exports', 'module', 'components/jquery/jquery', "static/modules/uploadify/jquery.uploadify", 'static/libs/validator', 'static/modules/summernote/lang/summernote-zh-CN', 'static/libs/alert'], function(require, exports, module) {

  /**
   * author zzy 2017-4-18
   */
  require('components/jquery/jquery');
  require("static/modules/uploadify/jquery.uploadify")
  var $validator = require('static/libs/validator');
  require('static/modules/summernote/lang/summernote-zh-CN');
  var $alert = require('static/libs/alert');
  $(function () {
      $("#goodsAdd_form span.radio").on("click",function () {
          var $this = $(this).find("input");
          var $span = $(this).nextAll("span:last");
          if($this.val() =='Y'){
              $span.show();
          }else if($this.val()=='N'){
              $span.hide();
          }
      });
      $('.tag-select .tag-select-btn').click(function () {
          $(this).next('.tag-select-box').fadeIn();
      });
      $('.tag-select-box .colsed').click(function () {
          $(this).parents('.tag-select-box').fadeOut();
      });
      $('.checkbox').click(function(){
          if($(this).hasClass("checkbox_on")){
              $(this).find('input').attr("checked",false);
              $(this).removeClass('checkbox_on')
          }else{
              $(this).find('input').attr("checked",true);
              $(this).addClass('checkbox_on')
          }
      });
      $('.radio').click(function(){
          var raname = $(this).find('input').attr('name');
          $(this).parents('form').find(".radio input[name="+raname+"]").parents('.radio').removeClass("radio_on");
          $(this).parents('form').find(".radio input[name="+raname+"]").attr("checked",false);
          $(this).addClass("radio_on").find(":radio").attr("checked",true);
      });
      //框内添加关键词删除
      $("div.list-body").on("click","span.delete",function () {
          var name = $(this).parent().attr("name");
          $(this).parent().remove();
          reMoveKey(name,1);
      });
      //框外添加关键词删除
      $("span.show-list").on("click","i.glyphicon",function () {
          var name = $(this).parent().attr("name");
          $(this).parent().remove();
          reMoveKey(name,0);
      });
      //删除图片
      $(".pic-upload").on("click",'i.delete',function () {
          $(this).parents('.pic-list').remove();
      });
      //添加关键词
      $('.tag-select-box .info-box').find('.btn').click(function () {
          var $tagText = $(this).parents('.info-box').find('.text');
          if($tagText.val() != ''){
              var $listBody =$(this).parents('.info-box').next('.list-body');
              if(appenKey($listBody,$tagText.val())){
                  $listBody.append(' <div name="'+$tagText.val()+'" class="iteam">' +
                      '<span>'+$tagText.val()+'</span><span class="delete">删除</span></div>');
                  var span = "<span name='"+$tagText.val()+"' class='iteam'>"+$tagText.val()+"<i class='glyphicon glyphicon-remove'></i></span>";
                  $("span.show-list").append(span);
                  var $input = $('#goodsAdd_form input[name=keyWord]');
                  if($input.val()==''){
                      $input.val('1');
                      $('#keyWord-error').remove();
                  }else{
                      $input.val($input.val()*1+1);
                  }
              }
              $tagText.val('');
          }
      });
      //关键词回车键入
      $('#goodsKey').on('keypress',function (e) {
          if(e.keyCode ==13){
              if(this.value !=''){
                  $(this).parent().next().find('span.btn').click();
              }
          }
      })
      //上传页面
      $("div.pic-up").on("click",function () {
          $("#goodsUpload").modal("show");
      });
      $("#goodsAdd_add").on("click",function () {
          $("#goodsAdd_form").submit();
      });
      $('#submit_form').on('click',function () {
          $("#goodsAdd_form").submit();
      });
      appendOption('api/v1/p/ftisp/area/query',{'level':'1','parentId':'0'}
          ,$("#importCountryId"));
      init();//初始化控件
  });
  
  function  init() {
      //upload页面初始化
      uploadinit();
      //富文本框
      $('#summernote').summernote({
          height: 200,
          lang:'zh-CN'
      });
      jugeAdd();
      //表单验证
      formValidationinit();
  }
  //添加关键词
  function appenKey($listBody,text) {
      var flag = true;
      var tel = /((?=[\x21-\x7e]+)[^A-Za-z0-9])/;
      var sps = /\s/
      if(tel.test(text)|| sps.test(text)){
          return false;
      }
      $listBody.find("span:not(.delete)").each(function () {
          if($(this).html() == text){
              flag = false;
              return flag;
          }
      })
      return flag;
  }
  
  //删除关键词 name-删除名称 type -类型 0外部调用，1框内调用
  function reMoveKey(name ,type) {
      if (type == 0) {
          $("div.list-body").find("div[name=" + name + "]").remove();
      } else {
          $("span.show-list").find("span[name=" + name + "]").remove();
      }
      var $input = $('#goodsAdd_form input[name=keyWord]');
      if($input.val()=='1'){
          $input.val('');
      }else{
          $input.val($input.val()-1);
      }
  }
  
  //upload初始化
  function uploadinit() {
      $("#uploadify").uploadify({
          'uploader' : 'api/v1/p/ftisp/fileoper/doUpload',
          'method':'post',
          'swf' : 'static/modules/uploadify/uploadify.swf',
          'formData' : {type:'Goods'},
          'queueID' : 'fileQueue',//与下面的id对应
          'queueSizeLimit' : 5,
          'fileTypeDesc' : '请选择jpg,png,gif',
          'fileTypeExts' : '*.jpg;*.png;*.gif', //控制可上传文件的扩展名，启用本项时需同时声明fileDesc
          'auto' : false,
          'multi' : true,
          'simUploadLimit' : 2,
          'buttonText' : '选择文件',
          'fileSizeLimit' : '10MB',
          'onUploadSuccess':function(file, data, response){
              var obj = JSON.parse(data);
              appendImage(obj.data[0]);
          }
      });
  }
  
  //上传图片填加
  function  appendImage(data) {
      var image = "<div class='pic-list'><img src='"+data.filePath+"' text='"+data.id+"' ><i class='glyphicon glyphicon-remove-sign delete'></i></div>";
      $("div.pic-upload").append(image);
  }
  //表单验证初始化
  function  formValidationinit() {
      $validator({ form: '#goodsAdd_form',button:'#submit_form'},{
          chName:{required:true},enName:{required:true},code:{required:true,remote:{url:'api/v1/p/ftisp/goods/queryByCode', type: "post",
              data: { code : function(){ return $("#goodsAdd_form input[name=code]").val()}},dataFilter:function (result) {
                  var  obj = JSON.parse(result);
                  if(obj.code == '200' ){
                      if(obj.data.id == ''){return true} else { return false}
                  }else{
                      return false;
                  }
              }
          }},regGrossWeight:{required:true,number:true,dPlaces:3},
          regLength:{required:true,number:true,dPlaces:2},regWidth:{required:true,number:true,dPlaces:2},regHeight:{required:true,number:true,dPlaces:2},
          importCountryId:{required:true,},declaredPrice:{required:true,number:true,dPlaces:3},importGoodsPrice:{required:true,number:true,dPlaces:3},
          detailWebsite:{required:true,url:true},exportGoodsTax:{isFlot:true},deliveryCycle:{number:true},hsCode:{number:true}
      },{
          chName:{required:'中文名称为必填项'},enName:{required:'英文名称必填'},code:{required:'商品编码必填',remote:'商品编码已存在'},
          regGrossWeight:{required:'产品包装重量必填',dPlaces:'产品包装重量最多保留3位小数'},regLength:{required:'长度为必填',dPlaces:'长度最多保留2位小数'},
          regWidth:{required:'宽度为必填',dPlaces:'宽度最多保留2位小数'}, regHeight:{required:'高度为必填',dPlaces:'高度最多保留2位小数'},
          importCountryId:{required:'进口国必填'},declaredPrice:{required:'出口申报价必填',dPlaces:'出口申报价最多保留3位小数'},
          importGoodsPrice:{required:'进口申报价必填',dPlaces:'进口申报价最多保留3位小数'},detailWebsite:{required:'商品网址必填'},
          deliveryCycle:{number:'交货周期必须是数字'},hsCode:{number:'海关编码必须位数字'}
      },asyfun,function (data) {
          if(data.code == 200){
              $alert("商品备案成功");
              window.location.href='commodity';
          }else{
              $alert(data.message);
          }
      });
  }
  //组装数据
  function asyfun() {
      var json = $('#goodsAdd_form').serializeObject();
      var $span = $('#goodsAdd_form span.radio_on');
      json['hasBattery'] = $span.find("input:first").val();
      if(json.hasBattery == 'Y'){
          json['batteryType'] = $('#batteryType .radio_on input[name=batteryType]').val();
      }
      var $keyWord = $("#goodsAdd_form span.show-list span.iteam");
      var keyWords = [];
      $keyWord.each(function () {
          keyWords.push($(this).attr('name'));
      })
      json['keywords'] = keyWords;
      var picIds = [];
      $('div.pic-upload div.pic-list img').each(function () {
          picIds.push($(this).attr('text'));
      })
      json['picIds']=picIds;
      json['summary'] = $('#summernote').summernote('code');
      json['importCountryId'] = $('#importCountryId').val();
      return json;
  }
  
  //判断url是否为新增
  function jugeAdd() {
      var href = window.location.href;
      var $form = $('#goodsAdd_form');
      if(href.indexOf('id=')>0){
          var i =href.indexOf('id=');
          var id =href.substr(i+3,href.length);
          $form.attr('action','api/v1/p/ftisp/goods/update');
          $("#goodsAdd_form input[name=code]").attr("readOnly",true);
          queryGoods(id);
          $("span.tap-name").html('商品修改');
      }else{
          $("span.tap-name").html('商品备案');
          $form.attr('action','api/v1/p/ftisp/goods/create');
      }
  }
  //查询数据
  function queryGoods(id) {
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
                  $('#goodsAdd_form input[name=code]').rules('remove',"remote");
              }else{
                  $alert(result.message);
              }
          }
      })
  }
  
  //添加数据
  function appendDate(data) {
      $("#goodsAdd_form input[name=id]").val(data.id);
      $("#goodsAdd_form input[name=chName]").val(data.chName);
      $("#goodsAdd_form input[name=enName ]").val(data.enName );
      $("#goodsAdd_form input[name=code]").val(data.code);
      $("#goodsAdd_form input[name=spec]").val(data.spec);
      $("#goodsAdd_form input[name=model]").val(data.model );
      $("#goodsAdd_form input[name=brand]").val(data.brand);
      $("#goodsAdd_form input[name=regLength]").val(data.regLength );
      $("#goodsAdd_form input[name=regWidth]").val(data.regWidth );
      $("#goodsAdd_form input[name=regHeight]").val(data.regHeight );
      $("#goodsAdd_form input[name=regGrossWeight ]").val(data.regGrossWeight );
      $("#goodsAdd_form input[name=hsCode ]").val(data.hsCode );
      $("#goodsAdd_form input[name=manageType ]").val(data.manageType );
      $("#goodsAdd_form input[name=exportGoodsTax ]").val(data.exportGoodsTax );
      $("#goodsAdd_form select[name=importCountryId ]").val(data.importCountryId );
      $("#goodsAdd_form input[name=declaredPrice  ]").val(data.declaredPrice  );
      $("#goodsAdd_form input[name=importGoodsPrice  ]").val(data.importGoodsPrice  );
      $("#goodsAdd_form input[name=deliveryCycle  ]").val(data.deliveryCycle  );
      $("#goodsAdd_form input[name=detailWebsite  ]").val(data.detailWebsite  );
      if(data.hasBattery =='Y'){
          $('#goodsAdd_form span.radio:eq(1)').click();
          if(data.batteryType =='lithium'){
              $('#goodsAdd_form span.radio:last').click();
          }
      }
      $("#goodsAdd_form input[name=keyWord]").val(data.keywords.length);
      var $span = $('#goodsAdd_form span.show-list')
      $.each(data.keywords ,function (index,str) {
          var span = "<span name='"+str+"' class='iteam'>"+str+"<i class='glyphicon glyphicon-remove'></i></span>"
          $span.append(span);
      });
      $.each(data.pics,function (index,obj) {
          appendImage(obj);
      })
      $('#summernote').summernote('code',data.summary );
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
          },
          error:function (e) {
              console.log(url+'接口错误');
          }
      })
  }

});