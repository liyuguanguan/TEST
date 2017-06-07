define('static/libs/jquery-extensions', ['require', 'exports', 'module', 'components/jquery/jquery'], function(require, exports, module) {

  var $ = require('components/jquery/jquery');
  /**
   * created by csy on 2017-4-14 20:26:19
   * drag modal
   * @param options
   */
  $.fn.drag = function (options) {
      var x, drag = this, isMove = false, defaults = {};
      var options = $.extend(defaults, options);
      //添加背景，文字，滑块
      var html = '<div class="drag-bg"></div>' +
          '<div class="drag-text" onselectstart="return false;" unselectable="on">拖动滑块验证</div>' +
          '<div class="handler handler-bg"></div>';
      this.append(html);
  
      var handler = drag.find('.handler');
      var drag_bg = drag.find('.drag-bg');
      var text = drag.find('.drag-text');
      var maxWidth = drag.width() - handler.width();  //能滑动的最大间距
  
      //鼠标按下时候的x轴的位置
      handler.mousedown(function (e) {
          isMove = true;
          x = e.pageX - parseInt(handler.css('left'), 10);
      });
  
      //鼠标指针在上下文移动时，移动距离大于0小于最大间距，滑块x轴位置等于鼠标移动距离
      $(document).mousemove(function (e) {
          var _x = e.pageX - x;
          if (isMove) {
              if (_x > 0 && _x <= maxWidth) {
                  handler.css({'left': _x});
                  drag_bg.css({'width': _x});
              } else if (_x > maxWidth) {  //鼠标指针移动距离达到最大时清空事件
                  dragOk();
              }
          }
      }).mouseup(function (e) {
          isMove = false;
          var _x = e.pageX - x;
          if (_x < maxWidth) { //鼠标松开时，如果没有达到最大距离位置，滑块就返回初始位置
              handler.css({'left': 0});
              drag_bg.css({'width': 0});
          }
      });
  
      //清空事件
      function dragOk() {
          handler.removeClass('handler-bg').addClass('handler-ok-bg');
          text.text('验证通过');
          drag.find("div").eq(1).removeAttr("style","color:#a94442");
          drag.css({'color': '#fff'});
          handler.unbind('mousedown');
          $(document).unbind('mousemove');
          $(document).unbind('mouseup');
      }
  };
  //扩展数组删除方法
  Array.prototype.indexOf = function(val) {
      for (var i = 0; i < this.length; i++) {
          if (this[i] == val) return i;
      }
      return -1;
  };
  
  Array.prototype.remove = function(val) {
      var index = this.indexOf(val);
      if (index > -1) {
          this.splice(index, 1);
      }
  };
  
  /**
   * 功能：序列化form表单数据成Json对象
   * 1.name均是简单的一级对象
   * 2.同名的name属性，值会被序列化为数组，例如checkbox等控件
   */
  $.fn.serializeObject = function() {
      var json = {};
      var arrObj = this.serializeArray();
      $.each(arrObj, function() {
          if (json[this.name]) {
              if (!json[this.name].push) {
                  json[this.name] = [ json[this.name] ];
              }
              json[this.name].push(this.value || '');
          } else {
              json[this.name] = this.value || '';
          }
      });
      return json;
  };
  /**
   * 功能：更具对象名称找到对应标签填充
   * 1.name均是简单的一级对象
   * 2.同名的name属性，值会被序列化为数组，例如checkbox等控件
   */
  $.fn.setForm = function (jsonObj) {
      var $this = $(this);
      $.each(jsonObj,function (k,v) {
          var $tag = $("[name="+k+"]",$this);
          if($tag.length != 0){
              var tagName = $tag[0].tagName;
              switch (tagName){
                  case 'INPUT' :
                      $tag.val(v);
                      break;
                  case 'SELECT':
                      $tag.val(v);
                      /* var $option = $tag.find("option[value="+v+"]");
                       if($option.length ==0){ $option.arrt("selected","selected")};*/
                      break;
                  default :
  
              }
          }
      });
  }
  /**
   * zzy
   * get url param
   * @param name
   */
  $.getUrlParam = function (name){
      //构造一个含有目标参数的正则表达式对象
      var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
      //匹配目标参数
      var r = window.location.search.substr(1).match(reg);
      //返回参数值
      if (r!=null) return decodeURI(r[2]);
      return null;
  };
  /**
   * zzy
   * date format
   * @param format
   */
  Date.prototype.format = function (format) {
      var o = {
          "M+": this.getMonth() + 1,
          "d+": this.getDate(),
          "h+": this.getHours(),
          "m+": this.getMinutes(),
          "s+": this.getSeconds(),
          "q+": Math.floor((this.getMonth() + 3) / 3),
          "S": this.getMilliseconds()
      };
      if (/(y+)/.test(format)) {
          format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
      }
      for (var k in o) {
          if (new RegExp("(" + k + ")").test(format)) {
              format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
          }
      }
      return format;
  }
  
  /**
   * js判断值是否不为空
   * csy
   * @param param
   */
  $.isNotNull = function (param) {
      if(typeof(param)!="undefined"&&param!=null&&param.length>0){
          return true;
      }
      return false;
  }
  

});