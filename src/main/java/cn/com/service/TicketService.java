package cn.com.service;

import cn.com.pojo.BaseResponse;

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
     * @return 返回结果
     */
    <T extends BaseResponse> T getTicketInfo(String productId);
}
