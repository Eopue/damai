package cn.com.pojo;

/**
 * The type Constants.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
public interface Constants {
    interface Url {
        String TICKET_INFO_URL = "https://piao.damai.cn/ajax/getInfo.html";
        String SUBMIT_ORDER_URL = "https://buy.damai.cn/multi/trans/submitOrderInfo";
    }

    interface HTTP_METHOD {
        String GET = "get";
        String POST = "post";
    }
}
