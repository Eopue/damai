package cn.com.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;

import cn.com.JsonUtil;
import cn.com.MethodFactory;
import cn.com.pojo.BaseResponse;
import cn.com.pojo.Constants;
import cn.com.pojo.TicketInfo;
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
        T t = MethodFactory
                .methodFactory()
                .method(Constants.HTTP_METHOD.GET)
                .execute(Constants.Url.TICKET_INFO_URL + "?projectId=" + productId);

        return JsonUtil.fromJson(JsonUtil.toJson(t.getData()), new TypeReference<TicketInfo>() {});
    }
}
