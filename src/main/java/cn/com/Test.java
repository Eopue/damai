package cn.com;

import org.json.JSONException;
import org.json.JSONObject;

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
    public static void main(String[] args) throws JSONException {
        TicketService ticketService = new TicketServiceImpl();
        IdentityHashMap<String, String> map = new IdentityHashMap<>();
        // 需要cookie, 用户提供
        map.put("cookie", "_uab_collina=153891072366174427335543; cna=bycxFCL9YgACAbfkd19CcZrM; t=3eb922162a90bba53aecdbfd9078b80f; munb=4198135964; UM_distinctid=1664e39cc44e9-04f8199b9966c3-36664c08-e1000-1664e39cc45ac; cporder=ordervalue=j4D5Cn7OB7sS5YHDHb3q9dGiSvkTFhqwus8XDdmKkEnFqv64nflBYR78Twdgn8gKdHMJlNOgIHbCxsoZDSywyak0bj%2bsKh5H4YT3vU4Hf%2bT4OYrnVIG6hF0AwXA8VIy%2fwlD2rRUw1pm5C%2bGMuCewkQ%3d%3d; cporderV2=j4D5Cn7OB7sS5YHDHb3q9dGiSvkTFhqwus8XDdmKkEnFqv64nflBYR78Twdgn8gKdHMJlNOgIHbCxsoZDSywyak0bj%2bsKh5H4YT3vU4Hf%2bT4OYrnVIG6hF0AwXA8VIy%2fwlD2rRUw1pm5C%2bGMuCewkQ%3d%3d; _damai_sour=u2DQ6M02CVixwTpGHTtlXr8cqmJQX0ml+DvV9ypGGgwLa6dR5Mh39zkz8i16Z9L+; damai.cn_nickName=%E9%BA%A6%E5%AD%906WWHc; x_hm_tuid=/JZajQHaNxe6X6vsO47XaF5RzUIdkIAlVB9Sp+6l9XJimAzAS+sHAss3ngaWzcMG; cookie2=1b3a3f3ead3eee75d5e7a643145e5687; _tb_token_=6ee7d5e97f6b; _hvn_login=18; csg=111b0627; damai.cn_user=+OOpmSqA+rpTdpPx/TxefAE0LQPRZaKXtp5gH8I26k97+SBwd++X2dDTVnHBHNz3Gxb2+Rjuqig=; damai.cn_user_new=%2BOOpmSqA%2BrpTdpPx%2FTxefAE0LQPRZaKXtp5gH8I26k97%2BSBwd%2B%2BX2dDTVnHBHNz3Gxb2%2BRjuqig%3D; h5token=429de7bc5b574a69ae48bb1783f3bf9a_1_1; damai_cn_user=%2BOOpmSqA%2BrpTdpPx%2FTxefAE0LQPRZaKXtp5gH8I26k97%2BSBwd%2B%2BX2dDTVnHBHNz3Gxb2%2BRjuqig%3D; loginkey=429de7bc5b574a69ae48bb1783f3bf9a_1_1; user_id=116726841; c_csrf=2a98178f-5304-4551-95bd-e41403d343ab; lang=zh-cn; cn_7415364c9dab5n09ff68_dplus=%7B%22distinct_id%22%3A%20%221664e39cc44e9-04f8199b9966c3-36664c08-e1000-1664e39cc45ac%22%2C%22sp%22%3A%20%7B%22%24_sessionid%22%3A%200%2C%22%24_sessionTime%22%3A%201539271181%2C%22%24dp%22%3A%200%2C%22%24_sessionPVTime%22%3A%201539271181%2C%22%24recent_outside_referrer%22%3A%20%22%24direct%22%7D%2C%22initial_view_time%22%3A%20%221538908390%22%2C%22initial_referrer%22%3A%20%22https%3A%2F%2Fwww.damai.cn%2F%22%2C%22initial_referrer_domain%22%3A%20%22www.damai.cn%22%7D; _fmdata=6zLT6mP8nN9GUXce6axig%2BkUBEmGdKoWaEU95JPZ1UY1ggwYYCkP9TYsy2Vrhhk5VxnxB7Hmn%2FFqrNueYjhLJajku2KjWW72t3gOda1yNvQ%3D; isg=BPDwKDtrX0zMJQNOc6uzu5lvwb6CkdTlrcnjXepBh8tfpZRPkkpME9XD-O1gXoxb");

        ConfirmTicket confirmTicket = new ConfirmTicket();
        // 空值
        confirmTicket.setBef("");
        confirmTicket.setRef("");
        // 用户提供
        confirmTicket.setProjectId("165374");
        // 演唱会地点ID 用户提供
        confirmTicket.setCityId("848");


        confirmTicket.setBusinessType("107001");
        confirmTicket.setCommodity("2%7c12520407%5e1%5e9100004");
        confirmTicket.setOid("0");
        confirmTicket.setSign("920F60300C8A1FB54FE4B13A511B39B8");
        confirmTicket.setTid("1e827c33240be3d6a2725b892523b3189bc9447761bc538132ff43623439856a38ca02e724df5cca04a7c1413387175b");
        confirmTicket.setTradePlatform("106002");
        confirmTicket.setTradeSubPlatform("0");
        confirmTicket.setTradeThreePlatfrom("0");

        MecResponse mecResponse = ticketService.confirmTicket(map, confirmTicket.getParams());

        mecResponse.setProjectId(165374L);
        mecResponse.setPerformId(9104078L);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("groupId", "");
        jsonObject.put("limitBank", 0);
        jsonObject.put("privilegeAmount", 0);
        jsonObject.put("privilegeId", "");
        jsonObject.put("privilegeName", "");
        jsonObject.put("privilegeType", 0);
        jsonObject.put("providerId", "");
        jsonObject.put("usable", 0);
        jsonObject.put("flag", false);
        mecResponse.setFrontPivilege(JsonUtil.fromJson(jsonObject.toString()));
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