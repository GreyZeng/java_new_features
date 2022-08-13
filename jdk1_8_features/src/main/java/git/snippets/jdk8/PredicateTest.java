package git.snippets.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/24
 * @since 1.8
 */
public class PredicateTest {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> lessThan5 = number -> number <= 5;
        Predicate<Integer> greaterThan9 = number -> number >= 9;
        // 小于等于 5
        System.out.println(filter(numberList, lessThan5));
        // 大于 5
        System.out.println(filter(numberList, lessThan5.negate()));
        // 小于等于 5 或者大于等于 9
        System.out.println(filter(numberList, lessThan5.or(greaterThan9)));
        // ! (小于等于 5 AND 大于等于 9)
        System.out.println(filter(numberList, lessThan5.and(greaterThan9).negate()));
    }

    // 过滤出满足条件（条件可以自定义）的特定集合元素
    private static <T> List<T> filter(List<T> numberList, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : numberList) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
