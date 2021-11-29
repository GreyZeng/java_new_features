package git.snippets.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * UnaryOperator使用
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/28
 * @see UnaryOperator
 * @since 1.8
 */
public class UnaryOperatorTest {
    public static void main(String[] args) {
        unaryOperator1();
        unaryOperator2();
        unaryOperator3();
    }

    public static void unaryOperator3() {
        List<String> list = Arrays.asList("abcddd", "12233243");
        // 转大写
        UnaryOperator<String> upperFun = s -> s.toUpperCase();
        // 截取 3 位
        UnaryOperator<String> subFun = s -> s.substring(0, 3);
        List<String> resultList = map(list, upperFun, subFun);
        System.out.println(resultList);
    }

    public static <T> List<T> map(List<T> list, UnaryOperator<T>... unaryOperator) {
        List<T> resultList = new ArrayList<>();
        for (T t : list) {
            for (UnaryOperator<T> operator : unaryOperator) {
                t = operator.apply(t);
            }
            resultList.add(t);
        }
        return resultList;
    }

    static void unaryOperator2() {
        Function<String, String> upperFun1 = String::toUpperCase;
        UnaryOperator<String> upperFun2 = String::toUpperCase;

        List<String> list = Arrays.asList("abc", "efg");

        Map<String, String> map1 = list.stream().collect(Collectors.toMap(upperFun1, Function.identity()));

        Map<String, String> map2 = list.stream().collect(Collectors.toMap(upperFun2, UnaryOperator.identity()));

        Map<String, String> map3 = list.stream().collect(Collectors.toMap(upperFun2, t -> t));

        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);
    }

    static void unaryOperator1() {
        Function<String, String> upper = String::toUpperCase;
        UnaryOperator<String> upper2 = String::toUpperCase;
        String res1 = upper.apply("abc");
        String res2 = upper2.apply("abc");
        System.out.println(res1);
        System.out.println(res2);
    }
    // 不做任何处理，直接返回参数本身，和 Function.identify() 效果一样。

}
