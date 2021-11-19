package git.snippets.jdk11;

import java.util.Optional;

/**
 * Optional用法
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/19
 * @since 11
 */
public class OptionalTest {
    public static void main(String[] args) {
        testIfPresent();
    }

    static void testIfPresent() {
        Optional<String> helloOptional = Optional.of("Hello");
        Optional<String> emptyOptional = Optional.empty();
        helloOptional.ifPresent(s -> System.out.println(s.length()));
        emptyOptional.ifPresent(s -> System.out.println(s.length()));
    }
}
