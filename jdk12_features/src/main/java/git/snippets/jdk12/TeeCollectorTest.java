package git.snippets.jdk12;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 分流收集器
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/8/19
 * @since 12
 */
public class TeeCollectorTest {
    public static void main(String[] args) {
        // 以下会报错， 只能终止流一次
//        Stream<Integer> numbers = new Random().ints(100).boxed();
//
//        int min = numbers.collect(Collectors.minBy(Integer::compareTo)).orElseThrow();
//        int max = numbers.collect(Collectors.maxBy(Integer::compareTo)).orElseThrow();
//        long range = (long) max - min;

        // 方法1：写一个自定义的收集器，将最小值和最大值累积到一个2元素的int数组中。
        Stream<Integer> numbers = new Random().ints(100).boxed();

        int[] result = numbers.collect(() -> new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}, (minMax, i) -> {
            if (i < minMax[0]) {
                minMax[0] = i;
            }
            if (i > minMax[1]) {
                minMax[1] = i;
            }
        }, (minMax1, minMax2) -> {
            if (minMax2[0] < minMax1[0]) {
                minMax1[0] = minMax2[0];
            }
            if (minMax2[1] > minMax1[1]) {
                minMax1[1] = minMax2[1];
            }
        });

        long range = (long) result[1] - result[0];
        System.out.println(range);

        // 方法2，使用Tee Collector
        numbers = new Random().ints(100).boxed();

        range = numbers.collect(Collectors.teeing(Collectors.minBy(Integer::compareTo), Collectors.maxBy(Integer::compareTo), (min, max) -> (long) max.orElseThrow() - min.orElseThrow()));
        System.out.println(range);
    }
}
