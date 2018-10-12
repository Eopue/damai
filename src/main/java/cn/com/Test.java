package cn.com;

import java.util.HashMap;
import java.util.IdentityHashMap;

import cn.com.constants.UrlEnum;
import cn.com.pojo.ConfirmTicket;
import cn.com.pojo.MecResponse;
import cn.com.service.TicketService;
import cn.com.service.impl.TicketServiceImpl;
import cn.com.util.JsonUtil;

/**
 * The type Test.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
public class Test {
    public static void main(String[] args) {
        TicketService ticketService = new TicketServiceImpl();
        IdentityHashMap<String, String> map = new IdentityHashMap<>();
        // 需要cookie, 用户提供
        map.put("cookie", "cna=bycxFCL9YgACAbfkd19CcZrM; t=3eb922162a90bba53aecdbfd9078b80f; munb=4198135964; UM_distinctid=1664e39cc44e9-04f8199b9966c3-36664c08-e1000-1664e39cc45ac; cporder=ordervalue=j4D5Cn7OB7sS5YHDHb3q9dGiSvkTFhqwus8XDdmKkEnFqv64nflBYR78Twdgn8gKdHMJlNOgIHbCxsoZDSywyak0bj%2bsKh5H4YT3vU4Hf%2bT4OYrnVIG6hF0AwXA8VIy%2fwlD2rRUw1pm5C%2bGMuCewkQ%3d%3d; cporderV2=j4D5Cn7OB7sS5YHDHb3q9dGiSvkTFhqwus8XDdmKkEnFqv64nflBYR78Twdgn8gKdHMJlNOgIHbCxsoZDSywyak0bj%2bsKh5H4YT3vU4Hf%2bT4OYrnVIG6hF0AwXA8VIy%2fwlD2rRUw1pm5C%2bGMuCewkQ%3d%3d; _damai_sour=u2DQ6M02CVixwTpGHTtlXr8cqmJQX0ml+DvV9ypGGgwLa6dR5Mh39zkz8i16Z9L+; damai.cn_nickName=%E9%BA%A6%E5%AD%906WWHc; cookie2=1ebcf66ebdd486120f77c80c8ea41263; _tb_token_=f381feebeb315; _hvn_login=18; csg=fefcd369; damai.cn_user=fd4NZxsfVN8SYqyC79gE0S7dQHmUbnP5mYm1ZSSgU/F7+SBwd++X2dDTVnHBHNz3Gxb2+Rjuqig=; damai.cn_user_new=fd4NZxsfVN8SYqyC79gE0S7dQHmUbnP5mYm1ZSSgU%2FF7%2BSBwd%2B%2BX2dDTVnHBHNz3Gxb2%2BRjuqig%3D; h5token=a7cf69cef71a437bb0c8857c2a303026_1_1; damai_cn_user=fd4NZxsfVN8SYqyC79gE0S7dQHmUbnP5mYm1ZSSgU%2FF7%2BSBwd%2B%2BX2dDTVnHBHNz3Gxb2%2BRjuqig%3D; loginkey=a7cf69cef71a437bb0c8857c2a303026_1_1; user_id=116726841; x_hm_tuid=YBYPuJTQpcs+EdQZyiIF7OYb0zjVAbypUblPH0V25AX44X5AWCsH6rcIp8R0N8dt; DaMaiTicketHistory=ProList=163364%40%E6%BD%98%E7%8E%AE%E6%9F%8FAlpha%E5%88%9B%E4%BD%BF%E8%80%85%E5%B7%A1%E5%9B%9E%E6%BC%94%E5%94%B1%E4%BC%9A-%E6%AD%A6%E6%B1%89%E7%AB%99%40wuhan%7C165374%40%E5%BC%A0%E9%9D%93%E9%A2%96%E3%80%90%E7%8F%8D%E7%9B%B8%E3%80%91%E4%B8%96%E7%95%8C%E5%B7%A1%E8%BF%B4%E6%BC%94%E5%94%B1%E4%BC%9A2018%20-%20%E6%BE%B3%E9%97%A8%E7%AB%99%40hk%7C164259%40%E7%BB%9D%E8%89%B2%E8%8E%AB%E6%96%87%E8%94%9A%E5%B7%A1%E5%9B%9E%E6%BC%94%E5%94%B1%E4%BC%9A2018%E6%88%90%E9%83%BD%E7%AB%99%40cd%7C164824%40%E4%B8%8A%E6%B5%B7%E6%9E%97%E8%82%AF%E7%88%B5%E5%A3%AB%E4%B9%90%E4%B8%AD%E5%BF%83Pedrito%20Martinez%20Group%40sh%7C164825%40%E6%9D%8E%E7%8E%89%E5%88%9A%E5%8D%81%E5%B9%B4%E7%BB%8F%E5%85%B8%E6%BC%94%E5%94%B1%E4%BC%9A%E4%B8%8A%E6%B5%B7%E7%AB%99%40sh%7C164896%40%E3%80%8A%E8%AF%97%E9%AD%82%E8%AF%8D%E9%AD%84%E3%80%8B%E5%94%90%E8%AF%97%E5%AE%8B%E8%AF%8D%E8%AF%84%E5%BC%B9%E6%BC%94%E5%94%B1%E4%BC%9A%40sh%7C163711%40%E4%B8%8A%E6%B5%B7%E6%9E%97%E8%82%AF%E7%88%B5%E5%A3%AB%E4%B9%90%E4%B8%AD%E5%BF%83Andrew%20Latona%20Trio%20%2B%20Lena%20Seikaly%40sh%7C29571%40%E5%A4%A7%E9%BA%A6%E7%BD%91%E9%A1%B9%E7%9B%AE%E6%BC%94%E7%A4%BA%EF%BC%88%E9%80%89%E5%BA%A7%EF%BC%89%40bj%7C164911%40%E9%99%88%E5%B0%8F%E6%98%A5%20STOP%20ANGRY%20%E5%B7%A1%E5%9B%9E%E6%BC%94%E5%94%B1%E4%BC%9A%20%E6%88%90%E9%83%BD%E7%AB%99%40cd%7C162812%402018%E5%BC%A0%E9%9F%B6%E6%B6%B5%5B%E6%97%85%E7%A8%8B%5D%20%E4%B8%96%E7%95%8C%E5%B7%A1%E5%9B%9E%E6%BC%94%E5%94%B1%E4%BC%9A-%E9%87%8D%E5%BA%86%E7%AB%99%40cq; cpSTAT_ok_pages=1; cpSTAT_ok_times=8; page_tran_time=15.6428; cn_7415364c9dab5n09ff68_dplus=%7B%22distinct_id%22%3A%20%221664e39cc44e9-04f8199b9966c3-36664c08-e1000-1664e39cc45ac%22%2C%22sp%22%3A%20%7B%22%24_sessionid%22%3A%200%2C%22%24_sessionTime%22%3A%201539309025%2C%22%24dp%22%3A%200%2C%22%24_sessionPVTime%22%3A%201539309025%2C%22%24recent_outside_referrer%22%3A%20%22%24direct%22%7D%2C%22initial_view_time%22%3A%20%221538908390%22%2C%22initial_referrer%22%3A%20%22https%3A%2F%2Fwww.damai.cn%2F%22%2C%22initial_referrer_domain%22%3A%20%22www.damai.cn%22%7D; isg=BKqqAP5Rhdqt7gmwjUlZbe8t-xBGfSQfe0tpwzRjEv2IZ0ohHav7hfDW89Nel6YN");

        ConfirmTicket confirmTicket = new ConfirmTicket();
        // 空值
        confirmTicket.setBef("");
        confirmTicket.setRef("");
        // 用户提供
        confirmTicket.setProjectId("165374");
        // 演唱会地点ID 用户提供
        confirmTicket.setCityId("848");

        // 问题： 1. 演唱会价格 2.演唱会名字错误
        confirmTicket.setBusinessType("107001");
        confirmTicket.setCommodity("2%7c12520407%5e1%5e9100004");
        confirmTicket.setOid("0");
        confirmTicket.setSign("920F60300C8A1FB54FE4B13A511B39B8");
        confirmTicket.setTid("1e827c33240be3d6a2725b892523b3189bc9447761bc538132ff43623439856a38ca02e724df5cca04a7c1413387175b");
        confirmTicket.setTradePlatform("106002");
        confirmTicket.setTradeSubPlatform("0");
        confirmTicket.setTradeThreePlatfrom("0");

        MecResponse mecResponse = ticketService.confirmTicket(map, confirmTicket.getParams());

        mecResponse.setProjectId(Long.parseLong(confirmTicket.getProjectId()));
        // 演唱会时间
        mecResponse.setPerformId(9104078L);
        mecResponse.setFrontPivilege(new HashMap<String, Object>(9){{
            put("groupId", "");
            put("limitBank", 0);
            put("privilegeAmount", 0);
            put("privilegeId", "");
            put("privilegeName", "");
            put("privilegeType", 0);
            put("providerId", "");
            put("usable", 0);
            put("flag", false);
        }});
        map.put("data", JsonUtil.toJson(mecResponse));

        map.put("referer", String.format(UrlEnum.CONFIRM.getUrl(), confirmTicket.getParams()));
        map.put("origin", "https://buy.damai.cn");
        map.put(":path", "/multi/trans/submitOrderInfo");
        map.put(":method", "POST");
        map.put(":authority", "buy.damai.cn");
        map.put("accept", "text/plain, */*; q=0.01");
        map.put("accept-encoding", "gzip, deflate, br");
        map.put("accept-language", "zh-CN,zh;q=0.9");
        map.put("content-type", "application/json;charset=UTF-8");
        map.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        map.put("x-requested-with", "XMLHttpRequest");
        String result = ticketService.submitOrder(map);
        System.out.println(map.get("data"));
        System.out.println(result.contains("失败") || result.contains("异常")
                ? "很抱歉：下单失败！" : "恭喜你：下单成功！");
        System.out.println(result);
    }
}