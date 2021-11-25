package git.snippets.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/24
 * @since
 */
public class PredicateTest {
    public static void main(String[] args) {
        predicateTest();
        predicateTest2();
        predicateTest3();
    }

    private static void predicateTest3() {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Predicate<Integer> p = n -> n > 3;
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
