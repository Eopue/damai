package cn.com;

import org.apache.logging.log4j.util.Strings;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import cn.com.constants.UrlEnum;
import cn.com.pojo.ConfirmTicket;
import cn.com.pojo.MecResponse;
import cn.com.pojo.SecurityInfo;
import cn.com.service.TicketService;
import cn.com.service.impl.TicketServiceImpl;
import cn.com.util.JsonUtil;
import cn.com.util.UrlUtil;

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
        String cookie = "cna=EwWEFH63VnkCAWpbBSenPgkS; t=8e21925a054eee5f87ec8308c9dd1860; damai.cn_nickName=%E9%BA%A6%E5%AD%906WWHc; cpSTAT_ok_times=1; UM_distinctid=1676eff02d91161-0dbff54426637e-3f674706-144000-1676eff02da73; __utma=143517098.1114342932.1543756824.1543756824.1543756824.1; __utmz=143517098.1543756824.1.1.utmcsr=buy.damai.cn|utmccn=(referral)|utmcmd=referral|utmcct=/multi/confirm; cn_7415364c9dab5n09ff68_dplus=%7B%22distinct_id%22%3A%20%221676eff02d91161-0dbff54426637e-3f674706-144000-1676eff02da73%22%2C%22sp%22%3A%20%7B%22%24_sessionid%22%3A%200%2C%22%24_sessionTime%22%3A%201543760202%2C%22%24dp%22%3A%200%2C%22%24_sessionPVTime%22%3A%201543760202%7D%2C%22initial_view_time%22%3A%20%221543750147%22%2C%22initial_referrer%22%3A%20%22https%3A%2F%2Fsearch.damai.cn%2Fsearch.htm%3Fspm%3Da2oeg.home.category.ditem_0.591b23e1HBlEEx%26ctl%3D%25E6%25BC%2594%25E5%2594%25B1%25E4%25BC%259A%26order%3D1%26cty%3D%22%2C%22initial_referrer_domain%22%3A%20%22search.damai.cn%22%7D; x_hm_tuid=d18ej9sGWLqcA76swEi086Hw9VCV5iHPwOS4d37pjoul5rQ+ImXAFq3rjLtSj6it; cookie2=11fbe86540357796d86f1ae814b6385a; _tb_token_=fea867673ee53; _hvn_login=18; csg=1a00ff19; munb=4198135964; damai.cn_user=NTcLkcVCPiI7qnMY3AV/rVViSs3GiRDy8l+QKr62iNt7+SBwd++X2dDTVnHBHNz3Gxb2+Rjuqig=; damai.cn_user_new=NTcLkcVCPiI7qnMY3AV%2FrVViSs3GiRDy8l%2BQKr62iNt7%2BSBwd%2B%2BX2dDTVnHBHNz3Gxb2%2BRjuqig%3D; h5token=d83bd4652f0a41cfbf4a6c43a225195a_1_1; damai_cn_user=NTcLkcVCPiI7qnMY3AV%2FrVViSs3GiRDy8l%2BQKr62iNt7%2BSBwd%2B%2BX2dDTVnHBHNz3Gxb2%2BRjuqig%3D; loginkey=d83bd4652f0a41cfbf4a6c43a225195a_1_1; user_id=116726841; isg=BKys97jH3AzZ_shAYEjQEMWPfYoezVBo9QybYAbsI9e_EUkbL3aGnyDpMJkMp4hn";
        map.put("cookie", cookie);

        Map<String, String> analysisUrl = UrlUtil.analysisUrl(cookie);
        ticketService.priceClick(map, analysisUrl.get("cna"));

        ConfirmTicket confirmTicket = new ConfirmTicket();
        // 固定值
        confirmTicket.setBef(Strings.EMPTY);
        confirmTicket.setRef(Strings.EMPTY);
        confirmTicket.setBusinessType("107001");
        confirmTicket.setOid("0");
        confirmTicket.setTradePlatform("106002");
        confirmTicket.setTradeSubPlatform("0");
        confirmTicket.setTradeThreePlatfrom("0");

        // 用户提供
        confirmTicket.setProjectId("175058");
        // 演唱会地点ID 用户提供
        confirmTicket.setCityId("906");
//        String shopping = ticketService.goShopping(map, confirmTicket.getProjectId(), confirmTicket.getCityId());
        // 问题： 1. 演唱会价格 2.演唱会名字错误
        // Commodity `2|commodityID^1^batchID`
        confirmTicket.setCommodity("2%7C12683317%5E1%5E9139091");
        confirmTicket.setSign("4ced9fc930a03d7eb6e1746b340f90a0");
        confirmTicket.setTid("27741C60EBF3E0D680FFF9D7C37965DBC15821089EAF6C1E34062B436CE25CFAA8A6F22938BC57778BA68EA4A097D1AF");

        MecResponse mecResponse = ticketService.confirmTicket(map, confirmTicket.getParams());

        Map<String, String> querySecurityInfo = new HashMap<>(16);
        querySecurityInfo.put("sellChannel", mecResponse.getSellChannel());
        querySecurityInfo.put("businessType", confirmTicket.getBusinessType());
        querySecurityInfo.put("businessSubType", "2");
        querySecurityInfo.put("commodity", mecResponse.getCommodityParams());
        querySecurityInfo.put("cityId", confirmTicket.getCityId());
        querySecurityInfo.put("tid", mecResponse.getTid());
        querySecurityInfo.put("idTypes", "1");
        querySecurityInfo.put("oid", "0");
        map.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        map.put("data", JsonUtil.toJson(querySecurityInfo));
        map.put("refer", String.format(UrlEnum.CONFIRM_SUBMIT.getUrl(), confirmTicket.getParams()));

        // 获取实名信息
//        SecurityInfo securityInfo = new SecurityInfo();
//        securityInfo.setHashIdCard("110006f9bec27df183af567c08501a218831b54c7780f");
//        securityInfo.setIdCard("500383199409190206");
//        securityInfo.setIdType(1);
//        securityInfo.setValid(true);
//        securityInfo.setViewPeople("刘晓露");
        List<SecurityInfo> securityInfos = ticketService.querySecurityInfo(map);
        SecurityInfo securityInfo = securityInfos.get(0);
        mecResponse.getsKULimit().add(securityInfo);

        mecResponse.getTrader().put("idCard", securityInfo.getIdCard());
        mecResponse.setProjectId(Long.parseLong(confirmTicket.getProjectId()));
        // 演唱会时间
        mecResponse.setPerformId(9120073L);
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