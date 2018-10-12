package cn.com.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type MecResponse.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/10
 */
public class MecResponse {
    private String tid;
    private String businessSubType;
    private String businessType;
    private List<Map<String, Object>> buyCommodityList;
    private String commodityParams = "2|12520407^1^9100004";
    private Integer deliveryType = 1;
    private Map<String, Object> frontPivilege;
    private String groupId;
    private String insurance;
    private String invoice;
    private String isVerification = "0";
    private String note;
    private Long orderId = 0L;
    private Long payKind = 1L;
    private Long payMethod = 0L;
    private Long performId;
    private Long projectId;
    private List<String> sKULimit = new ArrayList<>(0);
    private String sellChannel;
    private Map<String, Object> trader;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getBusinessSubType() {
        return businessSubType;
    }

    public void setBusinessSubType(String businessSubType) {
        this.businessSubType = businessSubType;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public List<Map<String, Object>> getBuyCommodityList() {
        return buyCommodityList;
    }

    public void setBuyCommodityList(List<Map<String, Object>> buyCommodityList) {
        this.buyCommodityList = buyCommodityList;
    }

    public String getCommodityParams() {
        return commodityParams;
    }

    public void setCommodityParams(String commodityParams) {
        this.commodityParams = commodityParams;
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Map<String, Object> getFrontPivilege() {
        return frontPivilege;
    }

    public void setFrontPivilege(Map<String, Object> frontPivilege) {
        this.frontPivilege = frontPivilege;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getIsVerification() {
        return isVerification;
    }

    public void setIsVerification(String isVerification) {
        this.isVerification = isVerification;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getPayKind() {
        return payKind;
    }

    public void setPayKind(Long payKind) {
        this.payKind = payKind;
    }

    public Long getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Long payMethod) {
        this.payMethod = payMethod;
    }

    public Long getPerformId() {
        return performId;
    }

    public void setPerformId(Long performId) {
        this.performId = performId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public List<String> getsKULimit() {
        return sKULimit;
    }

    public void setsKULimit(List<String> sKULimit) {
        this.sKULimit = sKULimit;
    }

    public String getSellChannel() {
        return sellChannel;
    }

    public void setSellChannel(String sellChannel) {
        this.sellChannel = sellChannel;
    }

    public Map<String, Object> getTrader() {
        return trader;
    }

    public void setTrader(Map<String, Object> trader) {
        this.trader = trader;
    }
}
