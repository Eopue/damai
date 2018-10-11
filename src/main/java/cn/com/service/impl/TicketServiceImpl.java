package cn.com.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpMethod;

import java.util.IdentityHashMap;

import cn.com.constants.UrlEnum;
import cn.com.method.MethodFactory;
import cn.com.pojo.BaseResponse;
import cn.com.pojo.MecResponse;
import cn.com.pojo.TicketInfoResponse;
import cn.com.service.TicketService;
import cn.com.util.JsonUtil;

/**
 * The type TicketServiceImpl.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
public class TicketServiceImpl implements TicketService {
    @Override
    public <T extends BaseResponse> T getTicketInfo(String productId, IdentityHashMap<String, String> header) {
        String execute = MethodFactory
                .methodFactory()
                .method(HttpMethod.GET)
                .execute(UrlEnum.TICKET_INFO_URL.getUrl() + "?projectId=" + productId, header);
        return JsonUtil.fromJson(execute, new TypeReference<TicketInfoResponse>() {});
    }

    @Override
    public <T extends BaseResponse> T confirmTicket(IdentityHashMap<String, String> header) {
        String execute = MethodFactory
                .methodFactory()
                .method(HttpMethod.GET)
                .execute(UrlEnum.CONFIRM.getUrl(), header);

        Document doc = Jsoup.parse(execute);
        Elements elements = doc.select("script");
        Elements allElements = elements.get(0).getAllElements();
        Element element = allElements.get(0);
        String tid = element.data().substring(element.data().indexOf("tid") + 7, element.data().indexOf("tid") + 47);

        MecResponse mecResponse = new MecResponse();
        mecResponse.setTid(tid);
        return (T) mecResponse;
    }
}
