package cn.com.method;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.util.Map;

/**
 * The type GetMethod.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
public class GetMethodRe implements Method {

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
                .setRedirectsEnabled(false)
                .build();

        HttpContext httpContext = new BasicHttpContext();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            httpGet.setHeader(entry.getKey(), entry.getValue());
        }
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet, httpContext);
            //获取重定向之后的主机地址信息,即"http://127.0.0.1:8088"
            HttpEntity entity = httpResponse.getEntity();
            if(null != entity){
                String response = EntityUtils.toString(entity, ContentType.getOrDefault(entity).getCharset());
                System.out.println("响应内容:" + response);
                Document parse = Jsoup.parse(response);
                Elements elements = parse.select("a");
                String data = elements.get(0).attributes().get("href");
                MethodFactory.methodFactory().method(HttpMethod.DELETE).execute(data, headers);
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
