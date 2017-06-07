define('components/jquery-validation/localization/messages_el', ['require', 'exports', 'module', 'components/jquery/jquery', 'components/jquery-validation/jquery.validate'], function(require, exports, module) {

  
  (function (factory) {
      
      module.exports = factory(require('components/jquery/jquery'), require('components/jquery-validation/jquery.validate')) || module.exports;;
  }(function ($) {
      /*
   * Translated default messages for the jQuery validation plugin.
   * Locale: EL (Greek; ελληνικά)
   */
      $.extend($.validator.messages, {
          required: '\u0391\u03C5\u03C4\u03CC \u03C4\u03BF \u03C0\u03B5\u03B4\u03AF\u03BF \u03B5\u03AF\u03BD\u03B1\u03B9 \u03C5\u03C0\u03BF\u03C7\u03C1\u03B5\u03C9\u03C4\u03B9\u03BA\u03CC.',
          remote: '\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B4\u03B9\u03BF\u03C1\u03B8\u03CE\u03C3\u03C4\u03B5 \u03B1\u03C5\u03C4\u03CC \u03C4\u03BF \u03C0\u03B5\u03B4\u03AF\u03BF.',
          email: '\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03BC\u03B9\u03B1 \u03AD\u03B3\u03BA\u03C5\u03C1\u03B7 \u03B4\u03B9\u03B5\u03CD\u03B8\u03C5\u03BD\u03C3\u03B7 email.',
          url: '\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03AD\u03BD\u03B1 \u03AD\u03B3\u03BA\u03C5\u03C1\u03BF URL.',
          date: '\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03BC\u03B9\u03B1 \u03AD\u03B3\u03BA\u03C5\u03C1\u03B7 \u03B7\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1.',
          dateISO: '\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03BC\u03B9\u03B1 \u03AD\u03B3\u03BA\u03C5\u03C1\u03B7 \u03B7\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 (ISO).',
          number: '\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03AD\u03BD\u03B1\u03BD \u03AD\u03B3\u03BA\u03C5\u03C1\u03BF \u03B1\u03C1\u03B9\u03B8\u03BC\u03CC.',
          digits: '\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03BC\u03CC\u03BD\u03BF \u03B1\u03C1\u03B9\u03B8\u03BC\u03B7\u03C4\u03B9\u03BA\u03AC \u03C8\u03B7\u03C6\u03AF\u03B1.',
          creditcard: '\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03AD\u03BD\u03B1\u03BD \u03AD\u03B3\u03BA\u03C5\u03C1\u03BF \u03B1\u03C1\u03B9\u03B8\u03BC\u03CC \u03C0\u03B9\u03C3\u03C4\u03C9\u03C4\u03B9\u03BA\u03AE\u03C2 \u03BA\u03AC\u03C1\u03C4\u03B1\u03C2.',
          equalTo: '\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03C4\u03B7\u03BD \u03AF\u03B4\u03B9\u03B1 \u03C4\u03B9\u03BC\u03AE \u03BE\u03B1\u03BD\u03AC.',
          extension: '\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03BC\u03B9\u03B1 \u03C4\u03B9\u03BC\u03AE \u03BC\u03B5 \u03AD\u03B3\u03BA\u03C5\u03C1\u03B7 \u03B5\u03C0\u03AD\u03BA\u03C4\u03B1\u03C3\u03B7 \u03B1\u03C1\u03C7\u03B5\u03AF\u03BF\u03C5.',
          maxlength: $.validator.format('\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03BC\u03AD\u03C7\u03C1\u03B9 \u03BA\u03B1\u03B9 {0} \u03C7\u03B1\u03C1\u03B1\u03BA\u03C4\u03AE\u03C1\u03B5\u03C2.'),
          minlength: $.validator.format('\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03C4\u03BF\u03C5\u03BB\u03AC\u03C7\u03B9\u03C3\u03C4\u03BF\u03BD {0} \u03C7\u03B1\u03C1\u03B1\u03BA\u03C4\u03AE\u03C1\u03B5\u03C2.'),
          rangelength: $.validator.format('\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03BC\u03B9\u03B1 \u03C4\u03B9\u03BC\u03AE \u03BC\u03B5 \u03BC\u03AE\u03BA\u03BF\u03C2 \u03BC\u03B5\u03C4\u03B1\u03BE\u03CD {0} \u03BA\u03B1\u03B9 {1} \u03C7\u03B1\u03C1\u03B1\u03BA\u03C4\u03AE\u03C1\u03C9\u03BD.'),
          range: $.validator.format('\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03BC\u03B9\u03B1 \u03C4\u03B9\u03BC\u03AE \u03BC\u03B5\u03C4\u03B1\u03BE\u03CD {0} \u03BA\u03B1\u03B9 {1}.'),
          max: $.validator.format('\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03BC\u03B9\u03B1 \u03C4\u03B9\u03BC\u03AE \u03BC\u03B9\u03BA\u03C1\u03CC\u03C4\u03B5\u03C1\u03B7 \u03AE \u03AF\u03C3\u03B7 \u03C4\u03BF\u03C5 {0}.'),
          min: $.validator.format('\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03BC\u03B9\u03B1 \u03C4\u03B9\u03BC\u03AE \u03BC\u03B5\u03B3\u03B1\u03BB\u03CD\u03C4\u03B5\u03C1\u03B7 \u03AE \u03AF\u03C3\u03B7 \u03C4\u03BF\u03C5 {0}.')
      });
  }));

});