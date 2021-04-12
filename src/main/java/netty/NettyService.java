package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 *  netty服务器
 *
 * @author gym
 * @date 2021/4/6
 */
public class NettyService {

    private int port;

    public NettyService(int port, final MessageHandlerInter messageHandler) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        this.port = port;
        NioEventLoopGroup boss = new NioEventLoopGroup();
        int cpuNum = Runtime.getRuntime().availableProcessors();
        NioEventLoopGroup worker = new NioEventLoopGroup(cpuNum);
        try {
            bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline()
                            .addLast(new LengthFieldBasedFrameDecoder(
                                NettyConfig.MAX_PACKAGE_SIZE, 0, NettyConfig.DEFAULT_LENGTH_SIZE, 0 ,NettyConfig.DEFAULT_LENGTH_SIZE))
                            .addLast(new LengthFieldPrepender(NettyConfig.DEFAULT_LENGTH_SIZE))
                            .addLast(messageHandler);
                    }
                })
                .bind(this.port).addListener(
                    new ChannelFutureListener() {
                        @Override
                        public void operationComplete(ChannelFuture channelFuture) throws Exception {

                        }
                    }
            ).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
