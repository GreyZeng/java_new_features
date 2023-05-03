package git.snippets.jdk20;

import java.net.URI;
import java.net.URL;

/**
 * URL的构造方法被彻底废弃
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2023/05/03
 * @since 20
 */
public class URLConstructorTest {
    public static void main(String[] args) throws Exception {
        // 以下构造方法在 Java SE 20 被彻底废弃
        // URL url = new URL("xxx");
        // Java SE 20 用如下方法构造 URL
        URL url = URI.create("xxx").toURL();
    }
}
