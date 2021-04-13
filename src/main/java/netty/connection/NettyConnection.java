package netty.connection;

import io.netty.channel.Channel;

/**
 * netty连接建立
 *
 * @author gym
 * @date 2021/4/6
 */
public interface NettyConnection {



    Channel getChannel();

}
