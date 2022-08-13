package git.snippets.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
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
        List<String> list = Arrays.asList("abcddd", "12233243");
        // 将List元素先转大写，然后截取前3位，最后打印出来
        mapAndConsumer(list, System.out::println, String::toUpperCase, s -> s.substring(0, 3));
        unaryOperator2();
    }

    // 接收多个`UnaryOperator`对List元素进行处理，得到的结果执行传入consumer中
    public static <T> void mapAndConsumer(List<T> list, Consumer<T> consumer, UnaryOperator<T>... unaryOperator) {
        for (T t : list) {
            for (UnaryOperator<T> operator : unaryOperator) {
                t = operator.apply(t);
            }
            consumer.accept(t);
        }
    }

    static void unaryOperator2() {
        Function<String, String> upperFun1 = String::toUpperCase;
        UnaryOperator<String> upperFun2 = String::toUpperCase;
        List<String> list = Arrays.asList("abc", "efg");
        // Function.identity() 和  UnaryOperator.identity()都不对结果进行任何操作
        Map<String, String> map1 = list.stream().collect(Collectors.toMap(upperFun1, Function.identity()));
        Map<String, String> map2 = list.stream().collect(Collectors.toMap(upperFun2, UnaryOperator.identity()));
        Map<String, String> map3 = list.stream().collect(Collectors.toMap(upperFun2, t -> t));
        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);
    }
}
