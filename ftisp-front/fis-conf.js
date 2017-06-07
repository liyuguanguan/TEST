fis.require('jello')(fis);
fis.set('project.ignore', ['node_modules/**', 'output/**', '.git/**', 'fis-conf.js','prod/**','out/**']);
fis.config.set('project.watch.usePolling', true);
// 标记 staitc/libs 下面的 js 为模块化代码。
fis.match('/static/libs/**.js', {
    isMod: true
});

// jello 里面默认用的 commonjs 这里改成 amd 方案。
fis.unhook('commonjs');
fis.hook('amd', {
    packages: [
        // 用来存放 libs 库
        {
            name: 'libs',
            location: 'static/libs/',
            main: 'index'
        },{
            name: 'css',
            location: 'static/css/',
            main: 'index'
        },
        {
            name: 'layout',
            location: 'page/layout/',
            main: 'index'
        },
        {
            name: 'dataTables',
            location: 'static/modules/dataTables/js/',
            main: 'jquery.dataTables.min.js'
        },
        {
            name: 'dataTables-css',
            location: 'static/modules/dataTables/css/',
            main: 'jquery.dataTables.min.css'
        },
        {
            name: 'datetimepicker',
            location: 'static/modules/bootstrap-datetimepicker/',
            main: 'bootstrap-datetimepicker.min.js'
        },
        {
            name: 'datetimepicker-css',
            location: 'static/modules/bootstrap-datetimepicker/',
            main: 'bootstrap-datetimepicker.min.css'
        },
        {
            name: 'datetimepicker.zh-CN',
            location: 'static/modules/bootstrap-datetimepicker/locales/',
            main: 'bootstrap-datetimepicker.zh-CN.js'
        },
        {
            name: 'summernote',
            location: 'static/modules/summernote/',
            main: 'summernote.js'
        },
        {
            name: 'summernote-css',
            location: 'static/modules/summernote/',
            main: 'summernote.css'
        },
        {
            name: 'summernote-zh-CN',
            location: 'static/modules/summernote/lang/',
            main: 'summernote-zh-CN.js'
        },
        {
            name: 'uploadify',
            location: 'static/modules/uploadify/',
            main: 'jquery.uploadify.js'
        },
        {
            name: 'uploadify-css',
            location: 'static/modules/uploadify/',
            main: 'uploadify.css'
        },{
            name: 'ueditor',
            location: 'static/modules/ueditor',
            main: 'ueditor.all.js'
        }
    ],
    shim: {
        'dataTables': {
            deps: ['jquery']
        },
        'datetimepicker': {
            deps: ['jquery']
        },
        'datetimepicker.zh-CN':{
            deps: ['datetimepicker']
        },
        'summernote': {
            deps: ['jquery']
        },
        'summernote-zh-CN': {
            deps: ['jquery']
        }
    }
});
// 设置 *.scss 配置配置项
fis.match('*.scss', {
    rExt: '.css',
    parser: fis.plugin('node-sass', {
        include_paths: [
            './static/scss',
            './components/compass-mixins'
        ]
    })
});
fis.match('/page/**/(*.{png,gif})', {
    release: '/static/img/$1$2'
});
fis.match('/page/**/(*.{scss,css})', {
    release: '/static/css/$1$2'
});
fis.match('/page/(*.{scss,css})', {
    release: '/static/css/$1$2'
});
fis.match('/page/**/(*.{js})', {
    release: '/static/js/$1$2'
});
fis.match('_*.scss', {
    // 设置 release 为 FALSE，不再产出此文件
    release: false
});

// 不启用 less
fis.match('*.less', {
    parser: null
});
fis.media('prod').match('/page/**/(*.{png,gif})', {
    url: '/ftisp/static/img/$1$2'
});
/*fis.media('prod').match('/static/!**!/(*.{png,gif})', {
 url: '/ftisp/img$1s2'
 });*/
fis.media('prod').match('/page/**/(*.js)', {
    url: '/ftisp/static$0'
});
fis.media('prod').match('/page/(*.js)', {
    url: '/ftisp/static$0'
});
fis.media('prod').match('/page/**/(*.{css,scss})', {
    url: '/ftisp/static/css/$1$2'
});
fis.media('prod').match('/page/(*.{css,scss})', {
    url: '/ftisp/static/css/$1$2'
});
/*fis.media('prod').match('/static/!**.{js,css,scss}', {
 url: '/ftisp$0'
 });*/
/*fis.media('prod').match('/pkg/!**.{js,css,scss}', {
 url: '/ftisp/static$0'
 });*/
fis.media('prod').match('/components/**', {
    url: '/ftisp/static$0'
});
fis.media('prod').match('/static/**', {
    url: '/ftisp$0'
});
fis.media('prod').match('*.js', {
    optimizer: null
});