package cn.com.method;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.nio.charset.Charset;

import cn.com.pojo.BaseResponse;

/**
 * The type PostMethod.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
public class PostMethod implements Method {
    @Override
    public <T extends BaseResponse> T execute(String url, Class<? extends BaseResponse> clazz) {
        String test = "{\n" +
                "    \"businessSubType\":\"2\",\n" +
                "    \"businessType\":\"107001\",\n" +
                "    \"buyCommodityList\":[\n" +
                "        {\n" +
                "            \"batchID\":\"9102589\",\n" +
                "            \"buyNum\":1,\n" +
                "            \"cityID\":\"1377\",\n" +
                "            \"commodityID\":12513094\n" +
                "        }\n" +
                "    ],\n" +
                "    \"commodityParams\":\"2|12513094^1^9102589\",\n" +
                "    \"deliveryType\":1,\n" +
                "    \"frontPivilege\":{\n" +
                "        \"flag\":false,\n" +
                "        \"groupId\":\"\",\n" +
                "        \"limitBank\":0,\n" +
                "        \"privilegeAmount\":0,\n" +
                "        \"privilegeId\":\"\",\n" +
                "        \"privilegeName\":\"\",\n" +
                "        \"privilegeType\":0,\n" +
                "        \"providerId\":\"\",\n" +
                "        \"usable\":0\n" +
                "    },\n" +
                "    \"groupId\":\"defaultCommodityGroupId\",\n" +
                "    \"insurance\":null,\n" +
                "    \"invoice\":null,\n" +
                "    \"isVerification\":\"0\",\n" +
                "    \"note\":null,\n" +
                "    \"orderId\":0,\n" +
                "    \"payKind\":1,\n" +
                "    \"payMethod\":0,\n" +
                "    \"performId\":9102589,\n" +
                "    \"projectId\":164911,\n" +
                "    \"sKULimit\":[\n" +
                "\n" +
                "    ],\n" +
                "    \"sellChannel\":\"100100010001\",\n" +
                /////// 找到tid决定能否下单 可能要js和java结合 src/top/buy.damai.cn/multi/ 搜索tid  也是sessionId
                "    \"tid\":\"mec_68b2b96c-b63b-40c1-8c45-c57fba9ca31a\",\n" +
                "    \"trader\":{\n" +
                "        \"address\":\"医学院路V8区3-8-4\",\n" +
                "        \"addressId\":87826540,\n" +
                "        \"cityId\":200,\n" +
                "        \"cityName\":\"重庆市\",\n" +
                "        \"countyId\":203,\n" +
                "        \"districtName\":\"渝中区\",\n" +
                "        \"idCard\":\"\",\n" +
                "        \"idType\":0,\n" +
                "        \"mobilePhone\":\"18996360418\",\n" +
                "        \"prefix\":\"86\",\n" +
                "        \"provinceId\":199,\n" +
                "        \"provinceName\":\"重庆\",\n" +
                "        \"tel\":\"\",\n" +
                "        \"userCode\":116726841,\n" +
                "        \"userName\":\"刘晓露\"\n" +
                "    }\n" +
                "}";
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

        try {
            // 消息头
            httpPost.setHeader(":authority", "buy.damai.cn");
            httpPost.setHeader(":path", "/multi/trans/submitOrderInfo");
            httpPost.setHeader(":scheme", "https");
            httpPost.setHeader("accept", "text/plain, */*; q=0.01");
            httpPost.setHeader("accept-encoding", "gzip, deflate, br");
            httpPost.setHeader("accept-language", "zh-CN,zh;q=0.9");
            httpPost.setHeader("content-type", "application/json;charset=UTF-8");
            httpPost.setHeader("origin", "https://buy.damai.cn");
            httpPost.setHeader("referer", "https://buy.damai.cn/multi/confirm?bef=&businessType=107001&cityId=1377&commodity=2%7C12513094%5E1%5E9102589&oid=0&projectId=164911&ref=&sign=a6595af2f662f947bb94daf7e384876c&tid=EE2D72A83AB9F68D263358EBC0110BF5DF43E8D7327BB043850043DBE8D0EBDE79D9772E2B517A6A777C1132237BFE03&tradePlatform=106002&tradeSubPlatform=0&tradeThreePlatfrom=0");
            httpPost.setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
            httpPost.setHeader("x-requested-with", "XMLHttpRequest");
            httpPost.setHeader("cookie", "_uab_collina=153891072366174427335543; x_hm_tuid=buVqUaqGhK5Zu5HyhUJNh50YOxATGfSsZuONGDRu8Fg9BdV3c8j9lcvojBTcl5/O; cporder=ordervalue=j4D5Cn7OB7sS5YHDHb3q9R1QugeVUMlUyHwRouKRtA3ygBsGkzf%2b898WGT46SQdOCdgIt4Rb5sHLmLI%2fFYK0a3Vq0tSg4NcLbZc5RGeNs815V23L5D3PtD2fa9ALNVCVB3eiaIwjRr4Hf8Y7igFdHQ%3d%3d; cporderV2=j4D5Cn7OB7sS5YHDHb3q9R1QugeVUMlUyHwRouKRtA3ygBsGkzf%2b898WGT46SQdOCdgIt4Rb5sHLmLI%2fFYK0a3Vq0tSg4NcLbZc5RGeNs815V23L5D3PtD2fa9ALNVCVB3eiaIwjRr4Hf8Y7igFdHQ%3d%3d; _damai_sour=u2DQ6M02CVixwTpGHTtlXr8cqmJQX0mlZNKkKydjqirIepH/hMOQraRo91LAG+Vq; cna=bycxFCL9YgACAbfkd19CcZrM; cookie2=122de3deffe3e667466d048cc2be3c50; t=3eb922162a90bba53aecdbfd9078b80f; _tb_token_=7ee43d3ad3159; _hvn_login=18; csg=7ce4fefb; munb=4198135964; damai.cn_nickName=%E9%BA%A6%E5%AD%906WWHc; damai.cn_user=m1aRoo0iRhp2FDyLjciwqb5stqXSo6UWO2tBMVeGQ097+SBwd++X2dDTVnHBHNz3Gxb2+Rjuqig=; damai.cn_user_new=m1aRoo0iRhp2FDyLjciwqb5stqXSo6UWO2tBMVeGQ097%2BSBwd%2B%2BX2dDTVnHBHNz3Gxb2%2BRjuqig%3D; h5token=635e48d269d64b64be9896fb99616936_1_1; damai_cn_user=m1aRoo0iRhp2FDyLjciwqb5stqXSo6UWO2tBMVeGQ097%2BSBwd%2B%2BX2dDTVnHBHNz3Gxb2%2BRjuqig%3D; loginkey=635e48d269d64b64be9896fb99616936_1_1; user_id=116726841; UM_distinctid=1664e39cc44e9-04f8199b9966c3-36664c08-e1000-1664e39cc45ac; c_csrf=94cdb5b2-cbdc-4478-b40f-6f9caedd1639; lang=zh-cn; cn_7415364c9dab5n09ff68_dplus=%7B%22distinct_id%22%3A%20%221664e39cc44e9-04f8199b9966c3-36664c08-e1000-1664e39cc45ac%22%2C%22sp%22%3A%20%7B%22%24_sessionid%22%3A%200%2C%22%24_sessionTime%22%3A%201538923323%2C%22%24dp%22%3A%200%2C%22%24_sessionPVTime%22%3A%201538923323%2C%22%24recent_outside_referrer%22%3A%20%22%24direct%22%7D%2C%22initial_view_time%22%3A%20%221538908390%22%2C%22initial_referrer%22%3A%20%22https%3A%2F%2Fwww.damai.cn%2F%22%2C%22initial_referrer_domain%22%3A%20%22www.damai.cn%22%7D; _fmdata=6zLT6mP8nN9GUXce6axig%2BkUBEmGdKoWaEU95JPZ1UY1ggwYYCkP9TYsy2Vrhhk5dh7hhHtuHZ8Tqmui2FNDyko%2BYh6TdbeoRF65b47%2Bsps%3D; isg=BDAwaxHcH4n9CcOOM-tz-1kvAf5C0RSlbYmjHSqBxgt35dGP0opWU-aDOK0gn8yb");

            // 消息
            StringEntity entity = new StringEntity(test, Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");

            // 发送Json格式的数据请求
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            System.out.println(httpResponse);
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
