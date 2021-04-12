package netty;

import io.netty.buffer.ByteBuf;

/**
 *  netty服务通信消息
 *
 * @author gym
 * @date 2021/4/6
 */
public interface MessageInter {

    void writeByte(ByteBuf outStream);
}