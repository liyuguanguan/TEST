define('static/libs/global', ['require', 'exports', 'module'], function(require, exports, module) {

  /**
   * author zzy 2017-4-18
   */
  /*
  var $ = require('jquery');
  var $alert = require("libs/alert");
  var menuData = sessionStorage.getItem('ftispUserMenu');
  if(!menuData){
      $.ajax({
          url: "api/v1/m/user/menus",
          type: "get",
          dataType: "json",
          async: false
      })
          .done(function (response) {
              if(response.code == 200){
                  sessionStorage.setItem('ftispUserMenu',JSON.stringify(response.data));
              }else{
                  $alert("菜单初始化失败,请刷新页面重试或联系平台管理员");
              }
          })
  }
  if(menuData){
      menuData = JSON.parse(menuData);
      var menuStr = "";
      menuStr.append("<div>").append("<div class='title'></div>");
      $.each(menuData,function (index,obj) {
          menuStr.append("<a class='item' href='javascript:;'><span>"+obj.moduleName+"</span></a>");
          $.each(obj.childs,function (i,o) {
              menuStr.append('<a class="item child#if($menuKey == '+obj.moduleName+') active#end" href="'+obj.moduleUrl+'"><i class="iconfont icon-geren"></i><span>'+obj.moduleName+'</span></a>');
          })
      })
  }*/
  

});