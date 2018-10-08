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
    TICKET_INFO_URL("https://piao.damai.cn/ajax/getInfo.html", TicketInfoResponse.class);

    String url;
    Class<? extends BaseResponse> clazz;

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
