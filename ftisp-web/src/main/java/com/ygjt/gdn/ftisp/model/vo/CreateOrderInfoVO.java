package com.ygjt.gdn.ftisp.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 入库单信息
 * crm_order_info
 */
public class CreateOrderInfoVO implements Serializable {
    /**
     * id
     * crm_order_info.id
     */
    private Integer id;

    /**
     * 订单号
     * crm_order_info.order_no
     */
    private String orderNo;

    /**
     * 入库单类型 
            SD 
            标准入库单
     * crm_order_info.order_type
     */
    private String orderType;

    /**
     * 下单：            commit
            揽收：            c_collect
            收货：            c_receive
            集货出库：    c_ourtoom
            转运入库：p_inroom
            转运出库：p_outroom
            海外入库：o_inroom
            海外上架：o_shelves
     * crm_order_info.order_status
     */
    private String orderStatus;

    /**
     * 订单来源
     * crm_order_info.order_source
     */
    private String orderSource;

    /**
     * 目的仓编号
     * crm_order_info.to_warehouse_id
     */
    private Integer toWarehouseId;

    /**
     * 客户订单号
     * crm_order_info.custom_order_no
     */
    private String customOrderNo;

    /**
     * 所属物流产品
     * crm_order_info.logistics_id
     */
    private Integer logisticsId;

    /**
     * 港口仓编号
     * crm_order_info.port_warehouse_id
     */
    private Integer portWarehouseId;

    /**
     * 收货仓编号
     * crm_order_info.collect_warehouse_id
     */
    private Integer collectWarehouseId;

    /**
     * 所属进口商
     * crm_order_info.importer_id
     */
    private Integer importerId;

    /**
     * 所属出口商
     * crm_order_info.exporter_id
     */
    private Integer exporterId;

    /**
     * 所属物流计划编号
     * crm_order_info.logistics_plan_id
     */
    private Integer logisticsPlanId;

    /**
     * 所属企业
     * crm_order_info.ent_id
     */
    private Integer entId;

    /**
     * 企业账户
     * crm_order_info.billing_account_id
     */
    private Integer billingAccountId;

    /**
     * 创建时间
     * crm_order_info.create_dt
     */
    private Date createDt;

    /**
     * 创建人
     * crm_order_info.create_by
     */
    private Integer createBy;

    /**
     * 最后更新时间
     * crm_order_info.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 最后更新人
     * crm_order_info.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 状态
     * crm_order_info.sts
     */
    private String sts;

    /**
     * 预计离港时间
     * crm_order_info.estimate_leave_dt
     */
    private Date estimateLeaveDt;

    /**
     * 截至收货时间
     * crm_order_info.last_collect_dt
     */
    private Date lastCollectDt;

    /**
     * 自抬头
            统一报关
     * crm_order_info.is_self_declare
     */
    private String isSelfDeclare;

    /**
     * 报关名称
     * crm_order_info.declare_name
     */
    private String declareName;

    /**
     * pickup：上门取件
            delivery ：客户送件
            transport：集货转运
     * crm_order_info.pickup_type
     */
    private String pickupType;

    /**
     * 提货预定日期
     * crm_order_info.pickup_date
     */
    private Date pickupDate;

    /**
     * 提货预定时间
     * crm_order_info.pickup_time
     */
    private String pickupTime;

    /**
     * 提货地址
     * crm_order_info.pickup_address_id
     */
    private Integer pickupAddressId;

    /**
     * 发货物流商名称
     * crm_order_info.express_provider_name
     */
    private String expressProviderName;

    /**
     * 快递单号
     * crm_order_info.express_no
     */
    private String expressNo;

    /**
     * 揽收时间
     * crm_order_info.collect_dt
     */
    private Date collectDt;

    /**
     * 揽收人
     * crm_order_info.collect_by
     */
    private Integer collectBy;

    /**
     * 收货时间
     * crm_order_info.receive_dt
     */
    private Date receiveDt;

    /**
     * 收货人
     * crm_order_info.receive_by
     */
    private Integer receiveBy;

    /**
     * 验货时间
     * crm_order_info.check_dt
     */
    private Date checkDt;

    /**
     * 验货人
     * crm_order_info.check_by
     */
    private Integer checkBy;

    /**
     * 出库时间
     * crm_order_info.outroom_dt
     */
    private Date outroomDt;

    /**
     * 出库人
     * crm_order_info.outroom_by
     */
    private Integer outroomBy;

    /**
     * 未揽货是否已打印
     * crm_order_info.is_collect_print
     */
    private String isCollectPrint;

    /**
     * 订单总体积
     * crm_order_info.t_volumn
     */
    private Double tVolumn;

    /**
     * 订单总重量
     * crm_order_info.t_weight
     */
    private Double tWeight;

    /**
     * 订单总件数
     * crm_order_info.t_nums
     */
    private Double tNums;

    /**
     * 总揽收数量
     * crm_order_info.t_collect_nums
     */
    private Double tCollectNums;

    /**
     * 总收货数量
     * crm_order_info.t_receive_nums
     */
    private Double tReceiveNums;

    /**
     * 总验收数量
     * crm_order_info.t_check_nums
     */
    private Double tCheckNums;

    /**
     * 总出库数量
     * crm_order_info.t_outroom_nums
     */
    private Double tOutroomNums;

    /**
     * 订单总商品数
     * crm_order_info.t_goods_nums
     */
    private Double tGoodsNums;

    /**
     * 订单计费总重量
     * crm_order_info.t_fee_weight
     */
    private Double tFeeWeight;

    /**
     * 确认总重量
     * crm_order_info.c_weight
     */
    private Double cWeight;

    /**
     * 确认总体积
     * crm_order_info.c_volumn
     */
    private Double cVolumn;

    /**
     * 确认总商品数
     * crm_order_info.c_goods_nums
     */
    private Double cGoodsNums;

    /**
     * 确认包裹总件数
     * crm_order_info.c_nums
     */
    private Double cNums;

    /**
     * 确认计费总重量
     * crm_order_info.c_fee_weight
     */
    private Double cFeeWeight;

    /**
     * Y:已装载
            N:未装载
     * crm_order_info.is_load
     */
    private String isLoad;

    /**
     * 当前操作仓库
     * crm_order_info.opt_warehouse_id
     */
    private Integer optWarehouseId;

    /**
     * crm_order_info
     */
    private static final long serialVersionUID = 1L;

    /**
     * crm_order_info.id
     * @return the value of crm_order_info.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * crm_order_info.id
     * @param id the value for crm_order_info.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * crm_order_info.order_no
     * @return the value of crm_order_info.order_no
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * crm_order_info.order_no
     * @param orderNo the value for crm_order_info.order_no
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * crm_order_info.order_type
     * @return the value of crm_order_info.order_type
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * crm_order_info.order_type
     * @param orderType the value for crm_order_info.order_type
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    /**
     * crm_order_info.order_status
     * @return the value of crm_order_info.order_status
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * crm_order_info.order_status
     * @param orderStatus the value for crm_order_info.order_status
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    /**
     * crm_order_info.order_source
     * @return the value of crm_order_info.order_source
     */
    public String getOrderSource() {
        return orderSource;
    }

    /**
     * crm_order_info.order_source
     * @param orderSource the value for crm_order_info.order_source
     */
    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource == null ? null : orderSource.trim();
    }

    /**
     * crm_order_info.to_warehouse_id
     * @return the value of crm_order_info.to_warehouse_id
     */
    public Integer getToWarehouseId() {
        return toWarehouseId;
    }

    /**
     * crm_order_info.to_warehouse_id
     * @param toWarehouseId the value for crm_order_info.to_warehouse_id
     */
    public void setToWarehouseId(Integer toWarehouseId) {
        this.toWarehouseId = toWarehouseId;
    }

    /**
     * crm_order_info.custom_order_no
     * @return the value of crm_order_info.custom_order_no
     */
    public String getCustomOrderNo() {
        return customOrderNo;
    }

    /**
     * crm_order_info.custom_order_no
     * @param customOrderNo the value for crm_order_info.custom_order_no
     */
    public void setCustomOrderNo(String customOrderNo) {
        this.customOrderNo = customOrderNo == null ? null : customOrderNo.trim();
    }

    /**
     * crm_order_info.logistics_id
     * @return the value of crm_order_info.logistics_id
     */
    public Integer getLogisticsId() {
        return logisticsId;
    }

    /**
     * crm_order_info.logistics_id
     * @param logisticsId the value for crm_order_info.logistics_id
     */
    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
    }

    /**
     * crm_order_info.port_warehouse_id
     * @return the value of crm_order_info.port_warehouse_id
     */
    public Integer getPortWarehouseId() {
        return portWarehouseId;
    }

    /**
     * crm_order_info.port_warehouse_id
     * @param portWarehouseId the value for crm_order_info.port_warehouse_id
     */
    public void setPortWarehouseId(Integer portWarehouseId) {
        this.portWarehouseId = portWarehouseId;
    }

    /**
     * crm_order_info.collect_warehouse_id
     * @return the value of crm_order_info.collect_warehouse_id
     */
    public Integer getCollectWarehouseId() {
        return collectWarehouseId;
    }

    /**
     * crm_order_info.collect_warehouse_id
     * @param collectWarehouseId the value for crm_order_info.collect_warehouse_id
     */
    public void setCollectWarehouseId(Integer collectWarehouseId) {
        this.collectWarehouseId = collectWarehouseId;
    }

    /**
     * crm_order_info.importer_id
     * @return the value of crm_order_info.importer_id
     */
    public Integer getImporterId() {
        return importerId;
    }

    /**
     * crm_order_info.importer_id
     * @param importerId the value for crm_order_info.importer_id
     */
    public void setImporterId(Integer importerId) {
        this.importerId = importerId;
    }

    /**
     * crm_order_info.exporter_id
     * @return the value of crm_order_info.exporter_id
     */
    public Integer getExporterId() {
        return exporterId;
    }

    /**
     * crm_order_info.exporter_id
     * @param exporterId the value for crm_order_info.exporter_id
     */
    public void setExporterId(Integer exporterId) {
        this.exporterId = exporterId;
    }

    /**
     * crm_order_info.logistics_plan_id
     * @return the value of crm_order_info.logistics_plan_id
     */
    public Integer getLogisticsPlanId() {
        return logisticsPlanId;
    }

    /**
     * crm_order_info.logistics_plan_id
     * @param logisticsPlanId the value for crm_order_info.logistics_plan_id
     */
    public void setLogisticsPlanId(Integer logisticsPlanId) {
        this.logisticsPlanId = logisticsPlanId;
    }

    /**
     * crm_order_info.ent_id
     * @return the value of crm_order_info.ent_id
     */
    public Integer getEntId() {
        return entId;
    }

    /**
     * crm_order_info.ent_id
     * @param entId the value for crm_order_info.ent_id
     */
    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    /**
     * crm_order_info.billing_account_id
     * @return the value of crm_order_info.billing_account_id
     */
    public Integer getBillingAccountId() {
        return billingAccountId;
    }

    /**
     * crm_order_info.billing_account_id
     * @param billingAccountId the value for crm_order_info.billing_account_id
     */
    public void setBillingAccountId(Integer billingAccountId) {
        this.billingAccountId = billingAccountId;
    }

    /**
     * crm_order_info.create_dt
     * @return the value of crm_order_info.create_dt
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * crm_order_info.create_dt
     * @param createDt the value for crm_order_info.create_dt
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * crm_order_info.create_by
     * @return the value of crm_order_info.create_by
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * crm_order_info.create_by
     * @param createBy the value for crm_order_info.create_by
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * crm_order_info.last_update_dt
     * @return the value of crm_order_info.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * crm_order_info.last_update_dt
     * @param lastUpdateDt the value for crm_order_info.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * crm_order_info.last_update_by
     * @return the value of crm_order_info.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * crm_order_info.last_update_by
     * @param lastUpdateBy the value for crm_order_info.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * crm_order_info.sts
     * @return the value of crm_order_info.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * crm_order_info.sts
     * @param sts the value for crm_order_info.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * crm_order_info.estimate_leave_dt
     * @return the value of crm_order_info.estimate_leave_dt
     */
    public Date getEstimateLeaveDt() {
        return estimateLeaveDt;
    }

    /**
     * crm_order_info.estimate_leave_dt
     * @param estimateLeaveDt the value for crm_order_info.estimate_leave_dt
     */
    public void setEstimateLeaveDt(Date estimateLeaveDt) {
        this.estimateLeaveDt = estimateLeaveDt;
    }

    /**
     * crm_order_info.last_collect_dt
     * @return the value of crm_order_info.last_collect_dt
     */
    public Date getLastCollectDt() {
        return lastCollectDt;
    }

    /**
     * crm_order_info.last_collect_dt
     * @param lastCollectDt the value for crm_order_info.last_collect_dt
     */
    public void setLastCollectDt(Date lastCollectDt) {
        this.lastCollectDt = lastCollectDt;
    }

    /**
     * crm_order_info.is_self_declare
     * @return the value of crm_order_info.is_self_declare
     */
    public String getIsSelfDeclare() {
        return isSelfDeclare;
    }

    /**
     * crm_order_info.is_self_declare
     * @param isSelfDeclare the value for crm_order_info.is_self_declare
     */
    public void setIsSelfDeclare(String isSelfDeclare) {
        this.isSelfDeclare = isSelfDeclare == null ? null : isSelfDeclare.trim();
    }

    /**
     * crm_order_info.declare_name
     * @return the value of crm_order_info.declare_name
     */
    public String getDeclareName() {
        return declareName;
    }

    /**
     * crm_order_info.declare_name
     * @param declareName the value for crm_order_info.declare_name
     */
    public void setDeclareName(String declareName) {
        this.declareName = declareName == null ? null : declareName.trim();
    }

    /**
     * crm_order_info.pickup_type
     * @return the value of crm_order_info.pickup_type
     */
    public String getPickupType() {
        return pickupType;
    }

    /**
     * crm_order_info.pickup_type
     * @param pickupType the value for crm_order_info.pickup_type
     */
    public void setPickupType(String pickupType) {
        this.pickupType = pickupType == null ? null : pickupType.trim();
    }

    /**
     * crm_order_info.pickup_date
     * @return the value of crm_order_info.pickup_date
     */
    public Date getPickupDate() {
        return pickupDate;
    }

    /**
     * crm_order_info.pickup_date
     * @param pickupDate the value for crm_order_info.pickup_date
     */
    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    /**
     * crm_order_info.pickup_time
     * @return the value of crm_order_info.pickup_time
     */
    public String getPickupTime() {
        return pickupTime;
    }

    /**
     * crm_order_info.pickup_time
     * @param pickupTime the value for crm_order_info.pickup_time
     */
    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime == null ? null : pickupTime.trim();
    }

    /**
     * crm_order_info.pickup_address_id
     * @return the value of crm_order_info.pickup_address_id
     */
    public Integer getPickupAddressId() {
        return pickupAddressId;
    }

    /**
     * crm_order_info.pickup_address_id
     * @param pickupAddressId the value for crm_order_info.pickup_address_id
     */
    public void setPickupAddressId(Integer pickupAddressId) {
        this.pickupAddressId = pickupAddressId;
    }

    /**
     * crm_order_info.express_provider_name
     * @return the value of crm_order_info.express_provider_name
     */
    public String getExpressProviderName() {
        return expressProviderName;
    }

    /**
     * crm_order_info.express_provider_name
     * @param expressProviderName the value for crm_order_info.express_provider_name
     */
    public void setExpressProviderName(String expressProviderName) {
        this.expressProviderName = expressProviderName == null ? null : expressProviderName.trim();
    }

    /**
     * crm_order_info.express_no
     * @return the value of crm_order_info.express_no
     */
    public String getExpressNo() {
        return expressNo;
    }

    /**
     * crm_order_info.express_no
     * @param expressNo the value for crm_order_info.express_no
     */
    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo == null ? null : expressNo.trim();
    }

    /**
     * crm_order_info.collect_dt
     * @return the value of crm_order_info.collect_dt
     */
    public Date getCollectDt() {
        return collectDt;
    }

    /**
     * crm_order_info.collect_dt
     * @param collectDt the value for crm_order_info.collect_dt
     */
    public void setCollectDt(Date collectDt) {
        this.collectDt = collectDt;
    }

    /**
     * crm_order_info.collect_by
     * @return the value of crm_order_info.collect_by
     */
    public Integer getCollectBy() {
        return collectBy;
    }

    /**
     * crm_order_info.collect_by
     * @param collectBy the value for crm_order_info.collect_by
     */
    public void setCollectBy(Integer collectBy) {
        this.collectBy = collectBy;
    }

    /**
     * crm_order_info.receive_dt
     * @return the value of crm_order_info.receive_dt
     */
    public Date getReceiveDt() {
        return receiveDt;
    }

    /**
     * crm_order_info.receive_dt
     * @param receiveDt the value for crm_order_info.receive_dt
     */
    public void setReceiveDt(Date receiveDt) {
        this.receiveDt = receiveDt;
    }

    /**
     * crm_order_info.receive_by
     * @return the value of crm_order_info.receive_by
     */
    public Integer getReceiveBy() {
        return receiveBy;
    }

    /**
     * crm_order_info.receive_by
     * @param receiveBy the value for crm_order_info.receive_by
     */
    public void setReceiveBy(Integer receiveBy) {
        this.receiveBy = receiveBy;
    }

    /**
     * crm_order_info.check_dt
     * @return the value of crm_order_info.check_dt
     */
    public Date getCheckDt() {
        return checkDt;
    }

    /**
     * crm_order_info.check_dt
     * @param checkDt the value for crm_order_info.check_dt
     */
    public void setCheckDt(Date checkDt) {
        this.checkDt = checkDt;
    }

    /**
     * crm_order_info.check_by
     * @return the value of crm_order_info.check_by
     */
    public Integer getCheckBy() {
        return checkBy;
    }

    /**
     * crm_order_info.check_by
     * @param checkBy the value for crm_order_info.check_by
     */
    public void setCheckBy(Integer checkBy) {
        this.checkBy = checkBy;
    }

    /**
     * crm_order_info.outroom_dt
     * @return the value of crm_order_info.outroom_dt
     */
    public Date getOutroomDt() {
        return outroomDt;
    }

    /**
     * crm_order_info.outroom_dt
     * @param outroomDt the value for crm_order_info.outroom_dt
     */
    public void setOutroomDt(Date outroomDt) {
        this.outroomDt = outroomDt;
    }

    /**
     * crm_order_info.outroom_by
     * @return the value of crm_order_info.outroom_by
     */
    public Integer getOutroomBy() {
        return outroomBy;
    }

    /**
     * crm_order_info.outroom_by
     * @param outroomBy the value for crm_order_info.outroom_by
     */
    public void setOutroomBy(Integer outroomBy) {
        this.outroomBy = outroomBy;
    }

    /**
     * crm_order_info.is_collect_print
     * @return the value of crm_order_info.is_collect_print
     */
    public String getIsCollectPrint() {
        return isCollectPrint;
    }

    /**
     * crm_order_info.is_collect_print
     * @param isCollectPrint the value for crm_order_info.is_collect_print
     */
    public void setIsCollectPrint(String isCollectPrint) {
        this.isCollectPrint = isCollectPrint == null ? null : isCollectPrint.trim();
    }

    /**
     * crm_order_info.t_volumn
     * @return the value of crm_order_info.t_volumn
     */
    public Double gettVolumn() {
        return tVolumn;
    }

    /**
     * crm_order_info.t_volumn
     * @param tVolumn the value for crm_order_info.t_volumn
     */
    public void settVolumn(Double tVolumn) {
        this.tVolumn = tVolumn;
    }

    /**
     * crm_order_info.t_weight
     * @return the value of crm_order_info.t_weight
     */
    public Double gettWeight() {
        return tWeight;
    }

    /**
     * crm_order_info.t_weight
     * @param tWeight the value for crm_order_info.t_weight
     */
    public void settWeight(Double tWeight) {
        this.tWeight = tWeight;
    }

    /**
     * crm_order_info.t_nums
     * @return the value of crm_order_info.t_nums
     */
    public Double gettNums() {
        return tNums;
    }

    /**
     * crm_order_info.t_nums
     * @param tNums the value for crm_order_info.t_nums
     */
    public void settNums(Double tNums) {
        this.tNums = tNums;
    }

    /**
     * crm_order_info.t_collect_nums
     * @return the value of crm_order_info.t_collect_nums
     */
    public Double gettCollectNums() {
        return tCollectNums;
    }

    /**
     * crm_order_info.t_collect_nums
     * @param tCollectNums the value for crm_order_info.t_collect_nums
     */
    public void settCollectNums(Double tCollectNums) {
        this.tCollectNums = tCollectNums;
    }

    /**
     * crm_order_info.t_receive_nums
     * @return the value of crm_order_info.t_receive_nums
     */
    public Double gettReceiveNums() {
        return tReceiveNums;
    }

    /**
     * crm_order_info.t_receive_nums
     * @param tReceiveNums the value for crm_order_info.t_receive_nums
     */
    public void settReceiveNums(Double tReceiveNums) {
        this.tReceiveNums = tReceiveNums;
    }

    /**
     * crm_order_info.t_check_nums
     * @return the value of crm_order_info.t_check_nums
     */
    public Double gettCheckNums() {
        return tCheckNums;
    }

    /**
     * crm_order_info.t_check_nums
     * @param tCheckNums the value for crm_order_info.t_check_nums
     */
    public void settCheckNums(Double tCheckNums) {
        this.tCheckNums = tCheckNums;
    }

    /**
     * crm_order_info.t_outroom_nums
     * @return the value of crm_order_info.t_outroom_nums
     */
    public Double gettOutroomNums() {
        return tOutroomNums;
    }

    /**
     * crm_order_info.t_outroom_nums
     * @param tOutroomNums the value for crm_order_info.t_outroom_nums
     */
    public void settOutroomNums(Double tOutroomNums) {
        this.tOutroomNums = tOutroomNums;
    }

    /**
     * crm_order_info.t_goods_nums
     * @return the value of crm_order_info.t_goods_nums
     */
    public Double gettGoodsNums() {
        return tGoodsNums;
    }

    /**
     * crm_order_info.t_goods_nums
     * @param tGoodsNums the value for crm_order_info.t_goods_nums
     */
    public void settGoodsNums(Double tGoodsNums) {
        this.tGoodsNums = tGoodsNums;
    }

    /**
     * crm_order_info.t_fee_weight
     * @return the value of crm_order_info.t_fee_weight
     */
    public Double gettFeeWeight() {
        return tFeeWeight;
    }

    /**
     * crm_order_info.t_fee_weight
     * @param tFeeWeight the value for crm_order_info.t_fee_weight
     */
    public void settFeeWeight(Double tFeeWeight) {
        this.tFeeWeight = tFeeWeight;
    }

    /**
     * crm_order_info.c_weight
     * @return the value of crm_order_info.c_weight
     */
    public Double getcWeight() {
        return cWeight;
    }

    /**
     * crm_order_info.c_weight
     * @param cWeight the value for crm_order_info.c_weight
     */
    public void setcWeight(Double cWeight) {
        this.cWeight = cWeight;
    }

    /**
     * crm_order_info.c_volumn
     * @return the value of crm_order_info.c_volumn
     */
    public Double getcVolumn() {
        return cVolumn;
    }

    /**
     * crm_order_info.c_volumn
     * @param cVolumn the value for crm_order_info.c_volumn
     */
    public void setcVolumn(Double cVolumn) {
        this.cVolumn = cVolumn;
    }

    /**
     * crm_order_info.c_goods_nums
     * @return the value of crm_order_info.c_goods_nums
     */
    public Double getcGoodsNums() {
        return cGoodsNums;
    }

    /**
     * crm_order_info.c_goods_nums
     * @param cGoodsNums the value for crm_order_info.c_goods_nums
     */
    public void setcGoodsNums(Double cGoodsNums) {
        this.cGoodsNums = cGoodsNums;
    }

    /**
     * crm_order_info.c_nums
     * @return the value of crm_order_info.c_nums
     */
    public Double getcNums() {
        return cNums;
    }

    /**
     * crm_order_info.c_nums
     * @param cNums the value for crm_order_info.c_nums
     */
    public void setcNums(Double cNums) {
        this.cNums = cNums;
    }

    /**
     * crm_order_info.c_fee_weight
     * @return the value of crm_order_info.c_fee_weight
     */
    public Double getcFeeWeight() {
        return cFeeWeight;
    }

    /**
     * crm_order_info.c_fee_weight
     * @param cFeeWeight the value for crm_order_info.c_fee_weight
     */
    public void setcFeeWeight(Double cFeeWeight) {
        this.cFeeWeight = cFeeWeight;
    }

    /**
     * crm_order_info.is_load
     * @return the value of crm_order_info.is_load
     */
    public String getIsLoad() {
        return isLoad;
    }

    /**
     * crm_order_info.is_load
     * @param isLoad the value for crm_order_info.is_load
     */
    public void setIsLoad(String isLoad) {
        this.isLoad = isLoad == null ? null : isLoad.trim();
    }

    /**
     * crm_order_info.opt_warehouse_id
     * @return the value of crm_order_info.opt_warehouse_id
     */
    public Integer getOptWarehouseId() {
        return optWarehouseId;
    }

    /**
     * crm_order_info.opt_warehouse_id
     * @param optWarehouseId the value for crm_order_info.opt_warehouse_id
     */
    public void setOptWarehouseId(Integer optWarehouseId) {
        this.optWarehouseId = optWarehouseId;
    }



    /**
     * crm_order_info
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getOrderSource() == null) ? 0 : getOrderSource().hashCode());
        result = prime * result + ((getToWarehouseId() == null) ? 0 : getToWarehouseId().hashCode());
        result = prime * result + ((getCustomOrderNo() == null) ? 0 : getCustomOrderNo().hashCode());
        result = prime * result + ((getLogisticsId() == null) ? 0 : getLogisticsId().hashCode());
        result = prime * result + ((getPortWarehouseId() == null) ? 0 : getPortWarehouseId().hashCode());
        result = prime * result + ((getCollectWarehouseId() == null) ? 0 : getCollectWarehouseId().hashCode());
        result = prime * result + ((getImporterId() == null) ? 0 : getImporterId().hashCode());
        result = prime * result + ((getExporterId() == null) ? 0 : getExporterId().hashCode());
        result = prime * result + ((getLogisticsPlanId() == null) ? 0 : getLogisticsPlanId().hashCode());
        result = prime * result + ((getEntId() == null) ? 0 : getEntId().hashCode());
        result = prime * result + ((getBillingAccountId() == null) ? 0 : getBillingAccountId().hashCode());
        result = prime * result + ((getCreateDt() == null) ? 0 : getCreateDt().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getLastUpdateDt() == null) ? 0 : getLastUpdateDt().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        result = prime * result + ((getEstimateLeaveDt() == null) ? 0 : getEstimateLeaveDt().hashCode());
        result = prime * result + ((getLastCollectDt() == null) ? 0 : getLastCollectDt().hashCode());
        result = prime * result + ((getIsSelfDeclare() == null) ? 0 : getIsSelfDeclare().hashCode());
        result = prime * result + ((getDeclareName() == null) ? 0 : getDeclareName().hashCode());
        result = prime * result + ((getPickupType() == null) ? 0 : getPickupType().hashCode());
        result = prime * result + ((getPickupDate() == null) ? 0 : getPickupDate().hashCode());
        result = prime * result + ((getPickupTime() == null) ? 0 : getPickupTime().hashCode());
        result = prime * result + ((getPickupAddressId() == null) ? 0 : getPickupAddressId().hashCode());
        result = prime * result + ((getExpressProviderName() == null) ? 0 : getExpressProviderName().hashCode());
        result = prime * result + ((getExpressNo() == null) ? 0 : getExpressNo().hashCode());
        result = prime * result + ((getCollectDt() == null) ? 0 : getCollectDt().hashCode());
        result = prime * result + ((getCollectBy() == null) ? 0 : getCollectBy().hashCode());
        result = prime * result + ((getReceiveDt() == null) ? 0 : getReceiveDt().hashCode());
        result = prime * result + ((getReceiveBy() == null) ? 0 : getReceiveBy().hashCode());
        result = prime * result + ((getCheckDt() == null) ? 0 : getCheckDt().hashCode());
        result = prime * result + ((getCheckBy() == null) ? 0 : getCheckBy().hashCode());
        result = prime * result + ((getOutroomDt() == null) ? 0 : getOutroomDt().hashCode());
        result = prime * result + ((getOutroomBy() == null) ? 0 : getOutroomBy().hashCode());
        result = prime * result + ((getIsCollectPrint() == null) ? 0 : getIsCollectPrint().hashCode());
        result = prime * result + ((gettVolumn() == null) ? 0 : gettVolumn().hashCode());
        result = prime * result + ((gettWeight() == null) ? 0 : gettWeight().hashCode());
        result = prime * result + ((gettNums() == null) ? 0 : gettNums().hashCode());
        result = prime * result + ((gettCollectNums() == null) ? 0 : gettCollectNums().hashCode());
        result = prime * result + ((gettReceiveNums() == null) ? 0 : gettReceiveNums().hashCode());
        result = prime * result + ((gettCheckNums() == null) ? 0 : gettCheckNums().hashCode());
        result = prime * result + ((gettOutroomNums() == null) ? 0 : gettOutroomNums().hashCode());
        result = prime * result + ((gettGoodsNums() == null) ? 0 : gettGoodsNums().hashCode());
        result = prime * result + ((gettFeeWeight() == null) ? 0 : gettFeeWeight().hashCode());
        result = prime * result + ((getcWeight() == null) ? 0 : getcWeight().hashCode());
        result = prime * result + ((getcVolumn() == null) ? 0 : getcVolumn().hashCode());
        result = prime * result + ((getcGoodsNums() == null) ? 0 : getcGoodsNums().hashCode());
        result = prime * result + ((getcNums() == null) ? 0 : getcNums().hashCode());
        result = prime * result + ((getcFeeWeight() == null) ? 0 : getcFeeWeight().hashCode());
        result = prime * result + ((getIsLoad() == null) ? 0 : getIsLoad().hashCode());
        result = prime * result + ((getOptWarehouseId() == null) ? 0 : getOptWarehouseId().hashCode());
        return result;
    }
}