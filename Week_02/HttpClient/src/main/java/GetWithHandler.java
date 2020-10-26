import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @program: HttpClient
 * @description:
 * @author: Shiwp
 * @create: 2020-10-26 20:59
 **/

public class GetWithHandler {
    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet getRequest = new HttpGet("http://localhost:8802");
            ResponseHandler<String> handler = new ResponseHandler<>() {
                @Override
                public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                    int code = response.getStatusLine().getStatusCode();
                    System.out.println("Status code : " + code);
                    if (code >= 200 && code < 300) {
                        return EntityUtils.toString(response.getEntity());
                    }
                    return "Hello world";
                }
            };
            String result = httpClient.execute(getRequest, handler);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
