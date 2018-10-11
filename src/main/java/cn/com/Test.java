package cn.com;

import java.util.IdentityHashMap;

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
        // 需要cookie
        ticketService.confirmTicket(new IdentityHashMap<>());
    }
}