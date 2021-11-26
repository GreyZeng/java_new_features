package git.snippets.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer测试
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/26
 * @since 1.8
 */
public class ConsumerTest {
    public static void main(String[] args) {
        t1();
        t2();
    }

    private static void t2() {
        List<String> list = Arrays.asList("ab", "cd");
        Consumer<String> consumer = System.out::println;
        foreach(list, consumer);
    }

    private static <T> void foreach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    static void t1() {
        Consumer<String> c = System.out::println;
        Consumer<String> len = s -> System.out.println(s.length());
        len.andThen(c).accept("hello");
    }


}
