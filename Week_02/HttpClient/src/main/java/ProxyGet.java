import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @program: HttpClient
 * @description:
 * @author: Shiwp
 * @create: 2020-10-26 21:54
 **/

public class ProxyGet {
    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpHost target = new HttpHost("localhost", 8801, "http");
            HttpHost proxy = new HttpHost("localhost", 8802, "http");
            RequestConfig config = RequestConfig.custom()
                    .setConnectionRequestTimeout(1000)
                    .setConnectTimeout(1000)
                    .setProxy(proxy)
                    .build();
            HttpGet request = new HttpGet("http://localhost:8802");
            request.setConfig(config);
            String result = httpClient.execute(request, new ResponseHandler<String>() {
                @Override
                public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                    int statusCode = response.getStatusLine().getStatusCode();
                    if (statusCode >= 200 && statusCode < 300) {
                        return EntityUtils.toString(response.getEntity());
                    }
                    return "Hello World";
                }
            });
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
