package git.snippets.jdk9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream增强
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 9
 */
public class StreamEnhanceTest {
    public static void main(String[] args) {
        // dropWhile方法,从头开始删除，遇到不满足的就结束，返回：[3,4,4,0]
        System.out.println(List.of(1, 2, 3, 4, 3, 0).stream().dropWhile(x -> x < 3).collect(Collectors.toList()));
        // takeWhile方法,从头开始筛选，遇到不满足的就结束，返回：[1,2]
        System.out.println(List.of(1, 2, 3, 4, 3, 0).stream().takeWhile(x -> x < 3).collect(Collectors.toList()));
        // iterate方法，收集[0,9] 十个数字，然后打印出来
        Stream.iterate(0, x -> x < 10, x -> x + 1).forEach(System.out::println);
//        ofNullable 用法
//        ofNullable 方法可以预防 NullPointerExceptions 异常， 可以通过检查流来避免 null 值。
//        如果指定元素为非 null，则获取一个元素并生成单个元素流，元素为 null 则返回一个空流。
        long count = Stream.ofNullable(100).count();
        // 非空，返回1
        System.out.println(count);
        count = Stream.ofNullable(null).count();
        // null，返回0
        System.out.println(count);
    }
}
