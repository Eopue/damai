package cn.com.pojo;

/**
 * The type ConfirmTicket.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/11
 */
public class ConfirmTicket {

    private String bef;
    private String businessType;
    private String cityId;
    private String commodity;
    private String oid;
    private String projectId;
    private String ref;
    private String sign;
    private String tid;
    private String tradePlatform;
    private String tradeSubPlatform;
    private String tradeThreePlatfrom;

    public String getBef() {
        return bef;
    }

    public void setBef(String bef) {
        this.bef = bef;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTradePlatform() {
        return tradePlatform;
    }

    public void setTradePlatform(String tradePlatform) {
        this.tradePlatform = tradePlatform;
    }

    public String getTradeSubPlatform() {
        return tradeSubPlatform;
    }

    public void setTradeSubPlatform(String tradeSubPlatform) {
        this.tradeSubPlatform = tradeSubPlatform;
    }

    public String getTradeThreePlatfrom() {
        return tradeThreePlatfrom;
    }

    public void setTradeThreePlatfrom(String tradeThreePlatfrom) {
        this.tradeThreePlatfrom = tradeThreePlatfrom;
    }

    public String[] getParams() {
        return new String[]{bef, businessType, cityId, commodity, oid, projectId, ref
                , sign, tid, tradePlatform, tradeSubPlatform, tradeThreePlatfrom};
    }
}
