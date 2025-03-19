package git.snippets.jdk24;


/**
 * Patterns、instanceof 和 switch 可以匹配更多类型（第二次预览）
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2025/03/19
 * @since 24
 */
public class SwitchMatchTest {
    public static void main(String[] args) {
        switchMatch(3);
        switchMatch("HELLO");
        switchMatch("hello world");
        switchMatch(null);
        switchMatch(3l);
        switchMatch(3.0d);
    }

    // instanceof 同理
    static void switchMatch(Object obj) {
        switch (obj) {
            case String s when s.length() > 5 -> System.out.println(s.toUpperCase());
            case String s -> System.out.println(s.toLowerCase());
            case Integer i -> System.out.println(i * i);
            case null -> System.out.println("null obj");
            case byte b -> System.out.println(obj + " instanceof byte:   " + b);
            case short s -> System.out.println(obj + " instanceof short:  " + s);
            case char c -> System.out.println(obj + " instanceof char:   " + c);
            case long l -> System.out.println(obj + " instanceof long:   " + l);
            case float f -> System.out.println(obj + " instanceof float:  " + f);
            case double d -> System.out.println(obj + " instanceof double: " + d);
            default -> {
            }
        }
    }
}
