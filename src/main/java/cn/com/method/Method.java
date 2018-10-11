package cn.com.method;

import java.util.Map;

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
     * @param headers headers
     * @return 泛型结果
     */
    String execute(String url, Map<String, String> headers);
}
