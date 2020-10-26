import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: HttpClient
 * @description:
 * @author: Shiwp
 * @create: 2020-10-26 20:28
 **/

public class Post {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost request = new HttpPost("http://localhost:8802");
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("type", "post"));
            pairs.add(new BasicNameValuePair("Date", new Date().toString()));
            request.setEntity(new UrlEncodedFormEntity(pairs));
            CloseableHttpResponse response = httpClient.execute(request);
            try {
                handler(response.getEntity());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }
    }

    private static void handler(HttpEntity entity) {
        try (
                InputStreamReader isr = new InputStreamReader(entity.getContent());
                BufferedReader br = new BufferedReader(isr)) {
//            System.out.println(entity.getContentType());
//            System.out.println(entity.getContentLength());
//            System.out.println(entity.getContentEncoding());
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
