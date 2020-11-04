package filters;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObject;

/**
 * @program: HttpClient
 * @description:
 * @author: Shiwp
 * @create: 2020-11-03 21:05
 **/

public interface HttpRequestFilter {
    void filter(HttpMessage httpMessage, ChannelHandlerContext ctx);
}
