package git.snippets.jdk8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * for each遍历方式
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/17
 * @since 1.8
 */
public class ForEachTest {
    public static void main(String[] args) {
        normForEach();
        newForEach();
        mapNormForEach();
        mapNewForEach();
        arrayForEach();
        parallelForEach();
        parallelForEachOrder();
        forEachUseConsumer();
    }

    // jdk8之前常规遍历操作
    static void normForEach() {
        List<String> list = Arrays.asList("a", "b", "c");
        for (String item : list) {
            System.out.println(item);
        }
    }

    static void newForEach() {
        List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(System.out::println);
        list.forEach(s -> {
            System.out.println("新的遍历方式");
            System.out.println(s);
        });
    }

    // Map的遍历 jdk1.8之前
    static void mapNormForEach() {
        Map<Integer, String> map = new HashMap<>(3);
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":\t" + entry.getValue());
        }
    }

    //jdk1.8新的Map遍历方法
    static void mapNewForEach() {
        Map<Integer, String> map = new HashMap<>(3);
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }

    // jdk1.8新增数组的遍历方法
    static void arrayForEach() {
        String[] array = {"a", "b", "c"};
        Arrays.stream(array).forEach(System.out::println);
    }

    //不保证有序
    static void parallelForEach() {
        Stream<String> stream = Stream.of("ab", "bc", "cd");
        stream.parallel().forEach(System.out::println);
    }

    // 可以保证有序
    static void parallelForEachOrder() {
        Stream<String> stream = Stream.of("ab", "bc", "cd");
        stream.parallel().forEachOrdered(System.out::println);
    }

    // 使用consumer
    static void forEachUseConsumer() {
        Stream<String> s = Stream.of("ab", "bc");
        List<String> l = Arrays.asList("ab", "cd");

        Consumer<String> consumer = s1 -> {
            System.out.println(s1.toUpperCase());
        };
        s.forEach(consumer);
        l.forEach(consumer);
    }
}
