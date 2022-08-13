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
 * <p>
 * BiConsumer 传入两个任意类型参数，无返回值
 * <p>
 * DoubleConsumer	传入一个 double 参数，无返回值
 * <p>
 * IntConsumer	传入一个 int 参数，无返回值
 * <p>
 * LongConsumer	传入一个 long 参数，无返回值
 * <p>
 * ObjDoubleConsumer	传入一个任意类型参数，一个 double 参数，无返回值
 * <p>
 * ObjIntConsumer	传入一个任意类型参数，一个 int 参数，无返回值
 * <p>
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

    // 多个Consumer结合使用
    static void t1() {
        Consumer<String> c = System.out::println;
        Consumer<String> len = s -> System.out.print(s.length());
        len.andThen(c).accept("hello");
    }

    private static void t4() {
        List<String> list = Arrays.asList("ab", "abcd");
        // 某个字符串串的长度大于给定的value值，就打印
        list.forEach(s -> {
            if (s.length() > 3) {
                System.out.println(s);
            }
        });
    }

    // 打印map中的value满足条件的key值
    private static void t3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zhangshang", 17);
        map.put("list", 21);
        map.put("wangwu", 18);
        BiConsumer<String, Integer> consumer = (s, i) -> {
            // value大于18的记录，打印其value值
            if (i > 18) {
                System.out.println(s);
            }
        };
        map.forEach(consumer);
    }


    private static void t2() {
        List<String> list = Arrays.asList("ab", "cd");
        // 打印字符串
        list.forEach(System.out::println);

        // 打印每个字符串的长度
        list.forEach(s -> System.out.println(s.length()));
    }
}
