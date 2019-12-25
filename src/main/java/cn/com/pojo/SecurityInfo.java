package cn.com.pojo;

/**
 * The type SecurityInfo.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/12/2
 */
public class SecurityInfo {
    private String hashIdCard;
    private String idCard;
    private Integer idType;
    private String inValidStr;
    private Boolean valid;
    private String viewPeople;

    public String getHashIdCard() {
        return hashIdCard;
    }

    public void setHashIdCard(String hashIdCard) {
        this.hashIdCard = hashIdCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getInValidStr() {
        return inValidStr;
    }

    public void setInValidStr(String inValidStr) {
        this.inValidStr = inValidStr;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getViewPeople() {
        return viewPeople;
    }

    public void setViewPeople(String viewPeople) {
        this.viewPeople = viewPeople;
    }
}
