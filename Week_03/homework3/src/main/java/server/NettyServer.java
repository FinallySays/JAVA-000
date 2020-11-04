package server;

import filters.HttpClientFilter;
import handlers.httpclient.HttpClientHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.CharsetUtil;

/**
 * @program: HttpClient
 * @description:
 * @author: Shiwp
 * @create: 2020-11-03 19:37
 **/

public class NettyServer extends Thread {

    public static String ADDRESS;

    private int port;

    private Class<?> handlerClass;

    private Class<?> filterClass;


    public NettyServer(int port, Class<?> handlerClass, Class<?> filterClass) {
        this.port = port;
        this.handlerClass = handlerClass;
        this.filterClass = filterClass;
    }

    @Override
    public synchronized void start() {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(2);

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast("httpServerCodec", new HttpServerCodec());
                            pipeline.addLast("stringDecoder", new StringDecoder(CharsetUtil.UTF_8));
                            pipeline.addLast("stringEncoder", new StringEncoder(CharsetUtil.UTF_8));
                            if (filterClass != null)
                                pipeline.addLast("filter", (ChannelHandler) filterClass.getConstructor().newInstance());
                            if (handlerClass != null)
                                pipeline.addLast("handler", (ChannelHandler) handlerClass.getConstructor().newInstance());
                        }
                    });
            ChannelFuture future = serverBootstrap.bind(port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void setADDRESS(String addr) {
        ADDRESS = addr;
    }


    public static void main(String[] args) {
        NettyServer.setADDRESS("http://localhost:8803");

//        Without filter
        new NettyServer(8810, HttpClientHandler.class, null).start();

//        With filter
//        new NettyServer(8810, HttpClientHandler.class, HttpClientFilter.class).start();
    }
}
