package com.mindasoft._08_net._04_netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/23 15:25
 */
public class NettyServer {

    public static int PORT_NUMBER = 1234;

    public static void main(String[] args) throws Exception {
        int port = PORT_NUMBER;
        if (args.length > 0)
        { // 覆盖默认的监听端口
            port = Integer.parseInt(args[0]);
        }
        System.out.println("Listening on port " + port);

        new NettyServer().bind(port);
    }

    public void bind(int port) throws Exception{
        // 配置服务端的NIO线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChildChannelHandler());

            // 绑定端口，同步等待成功
            ChannelFuture future =  bootstrap.bind(port).sync();

            // 等待服务端监听端口关闭
            future.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast( new TimeServerHandler());
        }
    }

    public class TimeServerHandler extends ChannelHandlerAdapter{

    }
}
