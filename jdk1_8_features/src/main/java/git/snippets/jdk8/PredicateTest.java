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
        predicateTest();
        predicateTest2();
        predicateTest3();
        predicateTest4();

    }

    private static void predicateTest4() {
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

    private static <T> List<T> filter(List<T> numberList, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : numberList) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    private static void predicateTest3() {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Predicate<Integer> p = n -> n > 3;
        // negate() -》 相反条件
        number = number.stream().filter(p.negate()).collect(Collectors.toList());
        System.out.println(number);
    }

    static void predicateTest() {
        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test(" "));
        System.out.println(predicate.test(""));
        System.out.println(predicate.test("abc"));
    }

    static void predicateTest2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> p1 = number -> number > 3;
        Predicate<Integer> p2 = number -> number < 5;
        Predicate<Integer> filter = p1.and(p2);

        list = list.stream().filter(filter).collect(Collectors.toList());
        System.out.println(list);
    }

}
