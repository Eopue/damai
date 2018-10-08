package cn.com;

import cn.com.pojo.TicketInfoResponse;
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
        TicketInfoResponse ticketInfoResponse = ticketService.getTicketInfo("164911");

        System.out.println(JsonUtil.toJson(ticketInfoResponse));
    }
}