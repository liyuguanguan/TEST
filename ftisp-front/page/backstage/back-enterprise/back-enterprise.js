/**
 * author:zzy,csy
 */
var $ = require('jquery');
var tableSetting = require('libs/table-init');
var table;
var $alert = require('libs/alert');
var reviewId;
$(function(){
    tableInit();
    $("#search").on("click",function (e) {
        e.preventDefault();
        table.draw();
    });
    $(document).on('click','a[name=review]',function () {
        reviewId = $(this).data('id');
        $.ajax({
            url: 'api/v1/p/ftisp/manage/enterpriseInfo/load',
            type: 'get',
            data: {
                id: reviewId
            },
            dataType: 'json'
        })
            .done(function (response) {
                if(response.code == 200){
                    var data = response.data;
                    $('#r_name').text(data.name);
                    $('#r_address').text(data.address);
                    $('#r_phone').text(data.linkPhone);
                    $('#r_license').text(data.busiLicense);
                    if(data.type == 'E'){
                        $('#r_type').text('企业客户');
                    }else if(data.type == 'P'){
                        $('#r_type').text('个人客户');
                    }
                    $('#r_linkman').text(data.linkMan);
                    $('#r_zipcode').text(data.zipcode);
                    $('#r_social').text(data.corpSocialNo);
                    if(data.auditSts == 'R'){
                        $('#result').val('R');
                        $('#reason').val(data.rejectReason?data.rejectReason:'');
                        $('#bottom-body').show();
                    }else{
                        $('#result').val('P');
                        $('#reason').val('');
                        $('#bottom-body').hide();
                    }
                    $('#review').modal('show');
                }else{
                    $alert('数据加载失败，请重试');
                }
            });
    });
    $('#result').on('change',function () {
        if($(this).val() != 'P'){
            $('#review textarea').val('');
            $('#review .error').text('');
            $('#bottom-body').removeClass('has-error').show();
        }else{
            $('#bottom-body').hide();
        }
    });
    $('#r_submit').on('click',function (e) {
        var result = $('#result').val();
        var reason = $('#reason').val();
        if(result != 'P'){
            if($('#reason').val()){
                $('#bottom-body').removeClass('has-error');
                $('#bottom-body .error').text('');
            }else{
                $('#bottom-body').addClass('has-error');
                $('#bottom-body .error').text('不能为空');
                return false;
            }
        }
        $.ajax({
            url: 'api/v1/p/ftisp/manage/enterpriseInfo/auditEnt',
            type: 'post',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify({
                id: reviewId,
                auditSts: result,
                rejectReason: reason
            }),
            dataType: 'json'
        })
            .done(function (response) {
                if(response.code == 200){
                    reviewClear();
                    $('#review').modal('hide');
                    table.draw(false);
                }else{
                    $alert('审核异常，请重试');
                }
            })
    })
});
function reviewClear() {
    reviewId = '';
    $('#review p').text('');
    $('#review textarea').val('');
    $('#review .error').text('');
    $('#result').val('P');
    $('#bottom-body').removeClass('has-error').hide();
}
function tableInit() {
    table = $("#main-table").DataTable(
        $.extend({},tableSetting,{
            ajax: {
                url: "api/v1/p/ftisp/manage/enterpriseInfo/list",
                data: function (d) {
                    var start = d.start;
                    var length = d.length;
                    d.name = $('#name').val();
                    d.linkMan = $('#linkMan').val();
                    d.audiSts  = $('#audiSts').val();
                    d.rows = length;
                    d.page = (start / length) + 1;
                },
                dataSrc: function (res) {
                    var obj = {};
                    if(res.code == 200){
                        $.extend(res, {
                            recordsTotal: res.data.total,
                            recordsFiltered: res.data.total
                        });
                        return res.data.rows;
                    }else{
                        return [];
                    }
                }
            },
            columns: [
                {data: null},
                {data: null},
                {data: 'name'},
                {data: "address"},
                {data: "linkMan"},
                {data: "linkPhone"},
                {data: "corpSocialNo"},
                {data: "auditSts"},
                {data: null}
            ],
            columnDefs: [
                {
                    targets: 1,
                    searchable: false,
                    render: function (data, type, full) {
                        return "<input type='checkbox' name='checkList'>";
                    }
                },{
                    targets: 2,
                    render: function (data, type, full) {
                        return "<a href='back-enterprise-detail?id="+full.id+"' name='detail'>"+data+"</a>";
                    }
                },{
                    targets: 7,
                    render:function (data,type,full) {
                        switch (data){
                            case 'U':
                                return "待审核";break;
                            case 'C':
                                return "待审核";break;
                            case 'P':
                                return "审核通过";break;
                            case 'R':
                                return "审核失败";break;
                            default:
                                return "";
                        }
                    }
                },{
                    targets: 8,
                    render:function (data,type,full) {
                        switch (full.auditSts){
                            case 'C':
                                return '<a href="javascript:;" name="review" class="btn btn-default" data-id="'+full.id+'">审核</a>';break;
                            case 'U':
                                return '<a href="javascript:;" name="review" class="btn btn-default" data-id="'+full.id+'">审核</a>';break;
                            default:
                                return "";
                        }
                    }
                }
            ]
        })
    );
}