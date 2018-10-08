package cn.com.service.impl;

import org.springframework.http.HttpMethod;

import cn.com.UrlEnum;
import cn.com.method.MethodFactory;
import cn.com.pojo.BaseResponse;
import cn.com.service.TicketService;

/**
 * The type TicketServiceImpl.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
public class TicketServiceImpl implements TicketService {
    @Override
    public <T extends BaseResponse> T getTicketInfo(String productId) {
        return MethodFactory
                .methodFactory()
                .method(HttpMethod.GET)
                .execute(UrlEnum.TICKET_INFO_URL.getUrl() + "?projectId=" + productId, UrlEnum.TICKET_INFO_URL.getClazz());
    }
}
