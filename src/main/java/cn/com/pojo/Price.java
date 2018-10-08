package cn.com.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Price.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
public class Price {
    @JsonProperty("PriceID")
    private Integer priceId;

    @JsonProperty("PriceName")
    private String priceName;

    @JsonProperty("SellPrice")
    private Integer sellPrice;

    @JsonProperty("Status")
    private Boolean status;

    @JsonProperty("IsTaoPiao")
    private Boolean isTaoPiao;

    @JsonProperty("IsAppPrice")
    private Boolean isAppPrice;

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getTaoPiao() {
        return isTaoPiao;
    }

    public void setTaoPiao(Boolean taoPiao) {
        isTaoPiao = taoPiao;
    }

    public Boolean getAppPrice() {
        return isAppPrice;
    }

    public void setAppPrice(Boolean appPrice) {
        isAppPrice = appPrice;
    }
}
