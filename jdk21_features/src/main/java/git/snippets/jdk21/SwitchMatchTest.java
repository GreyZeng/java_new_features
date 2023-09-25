package git.snippets.jdk21;


/**
 * switch类型增强匹配
 * 无须增加预览参数
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2023/09/25
 * @since 21
 */
public class SwitchMatchTest {
    public static void main(String[] args) {
        switchMatch(3);
        switchMatch("HELLO");
        switchMatch("hello world");
        switchMatch(null);
    }

    static void switchMatch(Object obj) {
        switch (obj) {
            case String s when s.length() > 5 -> System.out.println(s.toUpperCase());
            case String s -> System.out.println(s.toLowerCase());
            case Integer i -> System.out.println(i * i);
            case null -> System.out.println("null obj");
            default -> {
            }
        }
    }
}
