package cn.com.service;

import java.util.IdentityHashMap;

/**
 * The type TicketService.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
public interface TicketService {
    /**
     * 根据产品ID查询日期，价格
     *
     * @param productId 产品ID
     * @param header 请求头
     * @param <T> 泛型
     * @return 返回结果
     */
    <T> T getTicketInfo(String productId, IdentityHashMap<String, String> header);

    /**
     * 获取mec
     *
     * @param urlParam url路径参数
     * @param header 请求头
     * @param <T> 泛型
     * @return 返回结果
     */
    <T> T confirmTicket(IdentityHashMap<String, String> header, String... urlParam);

    /**
     * 提交
     *
     * @param header header
     * @return 提交结果
     */
    String submitOrder(IdentityHashMap<String, String> header);
}
