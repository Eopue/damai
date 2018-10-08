package cn.com;

import cn.com.pojo.BaseResponse;
import cn.com.service.TicketService;
import cn.com.service.impl.TicketServiceImpl;

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
        BaseResponse ticketInfo = ticketService.getTicketInfo("164911");

        System.out.println(JsonUtil.toJson(ticketInfo));
    }
}