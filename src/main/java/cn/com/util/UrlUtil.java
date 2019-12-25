package cn.com.util;

import java.util.HashMap;
import java.util.Map;

/**
 * The type UrlUtil.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/12
 */
public class UrlUtil {
    public static Map<String, String> analysisUrl(String url) {
        Map<String, String> result = new HashMap<>(16);
        for (String param : url.split(";")) {
            String[] split = param.split("=");
            result.put(split[0].trim(), split[1]);
        }

        return result;
    }
}
