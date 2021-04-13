package netty;

/**
 *  netty配置
 *
 * @author gym
 * @date 2021/4/6
 */
public class NettyConfig {

    public static final int DEFAULT_SERVER_CONNECTION_PORT = 1;

    public static final int DEFAULT_BOSS_THREAD_NUM = 1;

    public static final int DEFAULT_LENGTH_SIZE = 4;

    public static final String SERVER_CONFIG_PROPERTIES_NAME = "test.properties";

    /** 最大消息体大小 4MB **/
    public static final int MAX_PACKAGE_SIZE = 4 * 1024 * 1024;
}
