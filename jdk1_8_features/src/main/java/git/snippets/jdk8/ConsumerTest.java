package git.snippets.jdk8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/**
 * Consumer测试
 * BiConsumer 传入两个任意类型参数，无返回值
 * DoubleConsumer	传入一个 double 参数，无返回值
 * IntConsumer	传入一个 int 参数，无返回值
 * LongConsumer	传入一个 long 参数，无返回值
 * ObjDoubleConsumer	传入一个任意类型参数，一个 double 参数，无返回值
 * ObjIntConsumer	传入一个任意类型参数，一个 int 参数，无返回值
 * ObjLongConsumer	传入一个任意类型参数，一个 long 参数，无返回值
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/26
 * @since 1.8
 */
public class ConsumerTest {


    public static void main(String[] args) {
        t1();
        t2();
        t3();
        t4();
    }

    private static void t4() {
        List<String> list = Arrays.asList("ab", "abcd");
        ObjIntConsumer<String> consumer = (s, value) -> {
            if (s.length() > value) {
                System.out.println(s);
            }
        };
        foreach(list, consumer, 3);
    }

    private static <T> void foreach(List<T> list, ObjIntConsumer<T> consumer, int i) {
        for (T t : list) {
            consumer.accept(t, i);
        }
    }

    //

    private static void t3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zhangshang", 17);
        map.put("list", 21);
        map.put("wangwu", 18);
        BiConsumer<String, Integer> consumer = (s, i) -> {
            // 打印指定长度的字符串
            if (i >= 18) {
                System.out.println(s);
            }
        };
        map.forEach(consumer);
    }


    private static void t2() {
        List<String> list = Arrays.asList("ab", "cd");
        Consumer<String> consumer = System.out::println;
        foreach(list, consumer);

        Consumer<String> consumer1 = s -> System.out.println(s.length());
        foreach(list, consumer1);
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
