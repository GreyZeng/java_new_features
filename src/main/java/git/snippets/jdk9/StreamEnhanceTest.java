package git.snippets.jdk9;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 增强Stream
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 9
 */
public class StreamEnhanceTest {
    public static void main(String[] args) {
        takeWhileTest();
        dropWhileTest();
        ofNullTest();
        optionToStream();
    }

    private static void dropWhileTest() {
        // dropWhile ,从头开始删除，遇到不满足的就结束
        List<Integer> list2 = List.of(1, 2, 3, 4, 3, 0);
        List<Integer> listResult2 = list2.stream().dropWhile(x -> x < 3).collect(Collectors.toList());
        System.out.println(listResult2);
    }

    static void takeWhileTest() {
// takeWhile ,从头开始筛选，遇到不满足的就结束
        List<Integer> list2 = List.of(1, 2, 3, 4, 3, 0);
        List<Integer> listResult2 = list2.stream().takeWhile(x -> x < 3).collect(Collectors.toList());
        System.out.println(listResult2);
    }

    static void ofNullTest() {
        Stream<Integer> stream = Stream.of(1, 2, null);
        stream.forEach(System.out::print);
        System.out.println();
// 空指针异常
// stream = Stream.of(null);
        stream = Stream.ofNullable(null);
        stream.forEach(System.out::print);
    }
    static void optionToStream() {
        Stream<Integer> s = Optional.of(1).stream();
        s.forEach(System.out::print);
    }
}
