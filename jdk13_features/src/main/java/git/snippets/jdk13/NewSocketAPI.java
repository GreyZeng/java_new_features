package git.snippets.jdk13;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 新版Socket API 使用了新的实现 NioSocketImpl 来代替老旧的 PlainSocketImpl 实现。
 * 需要增加-XX:+TraceClassLoading参数
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/8/20
 * @since 13
 */
public class NewSocketAPI {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            boolean running = true;
            while (running) {
                Socket clientSocket = serverSocket.accept();
                //do something with clientSocket
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}