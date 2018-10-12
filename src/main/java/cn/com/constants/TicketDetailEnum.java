package cn.com.constants;

/**
 * The type TicketDetailEnum.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/11
 */
public enum TicketDetailEnum {
    GROUP_ID("t_groupId", "groupId"),
    BUSINESS_TYPE("t_businessType", "businessType"),
    BUSINESS_SUB_TYPE("t_businessSubType", "businessSubType"),
    BUY_COMMODITY_LIST("t_buyCommoditys", "buyCommodityList"),
    T_SELL_CHANNEL("t_sellChannel", "sellChannel"),
    T_COMMODITY_GROUPS("t_commodityGroups", "trader", "consignee");

    String htmlPro;
    String pojoPro;
    String subPro;

    TicketDetailEnum(String htmlPro, String pojoPro) {
        this.htmlPro = htmlPro;
        this.pojoPro = pojoPro;
    }

    TicketDetailEnum(String htmlPro, String pojoPro, String subPro) {
        this.htmlPro = htmlPro;
        this.pojoPro = pojoPro;
        this.subPro = subPro;
    }

    public String getHtmlPro() {
        return htmlPro;
    }

    public String getPojoPro() {
        return pojoPro;
    }

    public String getSubPro() {
        return subPro;
    }
}
