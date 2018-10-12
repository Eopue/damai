package cn.com.service.impl;

import com.google.common.base.Strings;

import com.fasterxml.jackson.core.type.TypeReference;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpMethod;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Map;

import cn.com.constants.TicketDetailEnum;
import cn.com.constants.UrlEnum;
import cn.com.method.MethodFactory;
import cn.com.pojo.MecResponse;
import cn.com.pojo.TicketInfoResponse;
import cn.com.service.TicketService;
import cn.com.util.JsonUtil;
import cn.com.util.ReflectionUtils;

/**
 * The type TicketServiceImpl.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
public class TicketServiceImpl implements TicketService {
    @Override
    public <T> T getTicketInfo(String productId, IdentityHashMap<String, String> header) {
        String execute = MethodFactory
                .methodFactory()
                .method(HttpMethod.GET)
                .execute(String.format(UrlEnum.TICKET_INFO_URL.getUrl(), productId), header);
        return JsonUtil.fromJson(execute, new TypeReference<TicketInfoResponse>() {
        });
    }

    @Override
    public <T> T confirmTicket(IdentityHashMap<String, String> header, String... urlParam) {
        String execute = MethodFactory
                .methodFactory()
                .method(HttpMethod.GET)
                .execute(String.format(UrlEnum.CONFIRM.getUrl(), urlParam), header);

        Document doc = Jsoup.parse(execute);
        Elements elements = doc.select("script");
        Elements allElements = elements.get(0).getAllElements();
        Element element = allElements.get(0);
        String tid = element.data().substring(element.data().indexOf("tid") + 7, element.data().indexOf("tid") + 47);

        MecResponse mecResponse = new MecResponse();
        mecResponse.setTid(tid);

        // 获取确认订单数据
        String orderHead = "window.document.domain = \"damai.cn\"";
        elements.forEach(ele -> {
            if (ele.data().contains(orderHead)) {
                String[] vars = ele.data().split("var");
                for (TicketDetailEnum detailEnum : TicketDetailEnum.values()) {
                    for (String var : vars) {
                        if (var.contains(detailEnum.getHtmlPro())) {
                            String[] split = var.split("=");
                            if (!Strings.isNullOrEmpty(detailEnum.getSubPro())) {
                                String result = split[1].split("]")[0].split("\\[")[1];
                                String s = result.replaceAll("\\\\", "");
                                ReflectionUtils.setFieldValue(mecResponse, detailEnum.getPojoPro(), JsonUtil.fromJson(s, new TypeReference<Map<String, Object>>() {}));
                            } else {
                                String result = split[1].trim().substring(1, split[1].trim().length() - 2);
                                String s = result.replaceAll("\\\\", "");
                                if (detailEnum.equals(TicketDetailEnum.BUY_COMMODITY_LIST)) {
                                    Map<String, Object> map = JsonUtil.fromJson(s.substring(1, s.length() - 1), new TypeReference<Map<String, Object>>() {});

                                    map.put("cityID", map.get("cityID").toString());
                                    ReflectionUtils.setFieldValue(mecResponse, detailEnum.getPojoPro(), new ArrayList<Map<String, Object>>(){{add(map);}});
                                } else {
                                    ReflectionUtils.setFieldValue(mecResponse, detailEnum.getPojoPro(), s);
                                }
                            }

                        }
                    }
                }
            }
        });
        return (T) mecResponse;
    }

    @Override
    public String submitOrder(IdentityHashMap<String, String> header) {
        return MethodFactory
                .methodFactory()
                .method(HttpMethod.POST)
                .execute(UrlEnum.SUBMIT_ORDER.getUrl(), header);
    }
}
