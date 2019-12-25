package cn.com.method;

import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * The type PostMethod.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
public class PostMethod implements Method {
    @Override
    public String execute(String url, Map<String, String> headers) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                //设置连接超时时间
                .setConnectTimeout(5000)
                // 设置请求超时时间
                .setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000)
                //默认允许自动重定向
                .setRedirectsEnabled(true)
                .build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            if (!"data".equals(entry.getKey())) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }

        try {
            // 消息
            StringEntity entity = new StringEntity(headers.get("data"), Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");

            // 发送Json格式的数据请求
            if (headers.containsKey("content-type")) {
                entity.setContentType(headers.get("content-type"));
            } else {
                entity.setContentType("application/json;charset=UTF-8");
            }
            httpPost.setEntity(entity);
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            //获得返回的结果
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
