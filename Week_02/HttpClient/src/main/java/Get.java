import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @program: HttpClient
 * @description: get request
 * @author: Shiwp
 * @create: 2020-10-26 18:48
 **/

public class Get {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet("http://localhost:8802");
            System.out.println(request.getRequestLine());
            CloseableHttpResponse response = httpClient.execute(request);
            try {
                System.out.println(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                handler(entity);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }

    }

    private static void handler(HttpEntity entity) {
        try (
                InputStreamReader isr = new InputStreamReader(entity.getContent());
                BufferedReader br = new BufferedReader(isr)) {
            System.out.println(entity.getContent());
            char[] chars = new char[1024];
            int length;
            while ((length = br.read(chars)) > 0) {
                System.out.print(String.valueOf(chars, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
