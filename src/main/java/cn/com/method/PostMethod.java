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
        //region
//        String test = "{\n" +
//                "    \"businessSubType\":\"2\",\n" +
//                "    \"businessType\":\"107001\",\n" +
//                "    \"buyCommodityList\":[\n" +
//                "        {\n" +
//                "            \"batchID\":\"9102589\",\n" +
//                "            \"buyNum\":1,\n" +
//                "            \"cityID\":\"1377\",\n" +
//                "            \"commodityID\":12513094\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"commodityParams\":\"2|12513094^1^9102589\",\n" +
//                "    \"deliveryType\":1,\n" +
//                "    \"frontPivilege\":{\n" +
//                "        \"flag\":false,\n" +
//                "        \"groupId\":\"\",\n" +
//                "        \"limitBank\":0,\n" +
//                "        \"privilegeAmount\":0,\n" +
//                "        \"privilegeId\":\"\",\n" +
//                "        \"privilegeName\":\"\",\n" +
//                "        \"privilegeType\":0,\n" +
//                "        \"providerId\":\"\",\n" +
//                "        \"usable\":0\n" +
//                "    },\n" +
//                "    \"groupId\":\"defaultCommodityGroupId\",\n" +
//                "    \"insurance\":null,\n" +
//                "    \"invoice\":null,\n" +
//                "    \"isVerification\":\"0\",\n" +
//                "    \"note\":null,\n" +
//                "    \"orderId\":0,\n" +
//                "    \"payKind\":1,\n" +
//                "    \"payMethod\":0,\n" +
//                "    \"performId\":9102589,\n" +
//                "    \"projectId\":164911,\n" +
//                "    \"sKULimit\":[\n" +
//                "\n" +
//                "    ],\n" +
//                "    \"sellChannel\":\"100100010001\",\n" +
//                /////// 找到tid决定能否下单 可能要js和java结合 src/top/buy.damai.cn/multi/ 搜索tid  也是sessionId
//                "    \"tid\":\"mec_68b2b96c-b63b-40c1-8c45-c57fba9ca31a\",\n" +
//                "    \"trader\":{\n" +
//                "        \"address\":\"医学院路V8区3-8-4\",\n" +
//                "        \"addressId\":87826540,\n" +
//                "        \"cityId\":200,\n" +
//                "        \"cityName\":\"重庆市\",\n" +
//                "        \"countyId\":203,\n" +
//                "        \"districtName\":\"渝中区\",\n" +
//                "        \"idCard\":\"\",\n" +
//                "        \"idType\":0,\n" +
//                "        \"mobilePhone\":\"18996360418\",\n" +
//                "        \"prefix\":\"86\",\n" +
//                "        \"provinceId\":199,\n" +
//                "        \"provinceName\":\"重庆\",\n" +
//                "        \"tel\":\"\",\n" +
//                "        \"userCode\":116726841,\n" +
//                "        \"userName\":\"刘晓露\"\n" +
//                "    }\n" +
//                "}";
        //endregion
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
            entity.setContentType("application/json");
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
