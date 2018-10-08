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
     *
     * @param url the url
     * @param clazz 返回时转换的类型
     * @param <T> 泛型
     * @return 泛型结果
     */
    <T extends BaseResponse> T execute(String url, Class<? extends BaseResponse> clazz);
}
