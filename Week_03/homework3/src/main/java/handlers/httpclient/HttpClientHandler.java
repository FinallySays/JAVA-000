package handlers.httpclient;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import server.NettyServer;

import java.io.IOException;
import java.util.Arrays;


/**
 * @program: HttpClient
 * @description:
 * @author: Shiwp
 * @create: 2020-11-03 19:56
 **/

public class HttpClientHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
        if (httpObject instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) httpObject;
            String uri = request.uri();
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet get = new HttpGet(NettyServer.ADDRESS + "/" + uri);
            request.headers().forEach(entry -> {
                get.setHeader(entry.getKey(), entry.getValue());
            });
            FullHttpResponse response = client.execute(get, new ResponseHandler<>() {
                @Override
                public FullHttpResponse handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                    String content = EntityUtils.toString(response.getEntity());
                    FullHttpResponse result = new  DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                            HttpResponseStatus.OK, Unpooled.copiedBuffer(content.getBytes()));
                    Arrays.asList(response.getAllHeaders()).forEach(pair -> {
                        result.headers().set(pair.getName(), pair.getValue());
                    });
                    return result;
                }
            });
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
            channelHandlerContext.writeAndFlush(response);
        }
    }


}
