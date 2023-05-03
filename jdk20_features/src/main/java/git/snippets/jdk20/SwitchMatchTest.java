package git.snippets.jdk20;


/**
 * switch类型匹配(第四次预览)
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2023/05/03
 * @since 20
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
