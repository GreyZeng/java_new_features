package git.snippets.jdk15;

/**
 * text block正式启用
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 15
 */
public class BlockTestInJava15 {
    public static void main(String[] args) {
        String content = """
                {
                    "hello": 1,\
                    "world": 2,
                    "hello world": "1\s2",
                }
                 """;
        System.out.println(content);
        String java15 = """
                <html>
                    <body>
                        <p>Hello, World</p>
                    </body>
                </html>
                """;
        System.out.println(java15);
    }
}
