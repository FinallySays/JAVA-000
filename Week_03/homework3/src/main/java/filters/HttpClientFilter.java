package filters;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObject;

/**
 * @program: HttpClient
 * @description:
 * @author: Shiwp
 * @create: 2020-11-03 21:05
 **/

public class HttpClientFilter extends SimpleChannelInboundHandler<HttpObject> implements HttpRequestFilter {
    @Override
    public void filter(HttpMessage httpMessage, ChannelHandlerContext ctx) {
        httpMessage.headers().add("Nio", "Shiwp");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
        if (httpObject instanceof HttpMessage) {
            HttpMessage httpMessage = (HttpMessage) httpObject;
            filter(httpMessage, channelHandlerContext);
        }
        channelHandlerContext.fireChannelRead(httpObject);
    }
}
