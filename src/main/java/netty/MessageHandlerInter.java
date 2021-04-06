package netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;

/**
 *  netty服务消息处理类
 *
 * @author gym
 * @date 2021/4/6
 */
public interface MessageHandlerInter extends ChannelInboundHandler{

    void handle(ChannelHandlerContext ctx);
}