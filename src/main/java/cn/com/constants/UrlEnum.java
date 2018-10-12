package cn.com.constants;

import cn.com.pojo.BaseResponse;
import cn.com.pojo.TicketInfoResponse;

/**
 * The type UrlEnum.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/8
 */
public enum UrlEnum {
    /**
     * ticket信息
     */
    TICKET_INFO_URL("https://piao.damai.cn/ajax/getInfo.html?projectId=%s", TicketInfoResponse.class),
    CHECK_TASK_URL("https://buy.damai.cn/multi/ajaxhandler/checkTaskId?&sellChannel=100100010001&businessType=107001&businessSubType=2&_=1539086032410"),
    MEC("https://dui.dmcdn.cn/mec_tradeportal/pc/common/js/index.1.0.0.js?da789ca45014c7f1a781"),
    TOKEN("https://online.damai.cn/alime/getDialogToken"),
    GO_SHOPPING("https://www.damai.cn/GotoShopping.aspx?_action=Immediately&proId=12520407&optype=1&companyId=1377&num=1&n=0"),
    CONFIRM("https://buy.damai.cn/multi/confirm1?bef=%s&businessType=%s&cityId=%s&commodity=%s&oid=%s&projectId=%s&ref=%s&sign=%s&tid=%s&tradePlatform=%s&tradeSubPlatform=%s&tradeThreePlatfrom=%s"),
    SUBMIT_ORDER("https://buy.damai.cn/multi/trans/submitOrderInfo");

    String url;
    Class<? extends BaseResponse> clazz;

    UrlEnum(String url) {
        this.url = url;
    }

    UrlEnum(String url, Class<? extends BaseResponse> clazz) {
        this.url = url;
        this.clazz = clazz;
    }

    public String getUrl() {
        return url;
    }

    public Class<? extends BaseResponse> getClazz() {
        return clazz;
    }
}
