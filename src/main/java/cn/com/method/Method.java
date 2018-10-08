package cn.com.method;

import cn.com.pojo.BaseResponse;

/**
 * The type Method.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
public interface Method {
    /**
     * 执行方法
     */
    <T extends BaseResponse> T execute(String url, Class<? extends BaseResponse> clazz);
}
