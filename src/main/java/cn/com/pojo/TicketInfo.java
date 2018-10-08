package cn.com.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * The type TICKET_INFO_URL.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
@JsonRootName("Data")
public class TicketInfo extends BaseResponse {
    @JsonProperty("performs")
    private List<Perform> performs;

    @JsonProperty("prices")
    private List<Price> prices;

    @JsonProperty("performId")
    private Integer performId;

    @JsonProperty("ele")
    private Boolean ele;

    @JsonProperty("xz")
    private Boolean xz;

    @JsonProperty("b3")
    private Boolean b3;

    @JsonProperty("saleStatus")
    private Boolean saleStatus;

    public List<Perform> getPerforms() {
        return performs;
    }

    public void setPerforms(List<Perform> performs) {
        this.performs = performs;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public Integer getPerformId() {
        return performId;
    }

    public void setPerformId(Integer performId) {
        this.performId = performId;
    }

    public Boolean getEle() {
        return ele;
    }

    public void setEle(Boolean ele) {
        this.ele = ele;
    }

    public Boolean getXz() {
        return xz;
    }

    public void setXz(Boolean xz) {
        this.xz = xz;
    }

    public Boolean getB3() {
        return b3;
    }

    public void setB3(Boolean b3) {
        this.b3 = b3;
    }

    public Boolean getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Boolean saleStatus) {
        this.saleStatus = saleStatus;
    }
}
