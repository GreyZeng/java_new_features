package git.snippets.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 惰性计算
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/23
 * @since 1.8
 */
public class LazyTest {
    public static void main(String[] args) {
        lazyTest();
    }

    private static void lazyTest() {
        List<Integer> numberLIst = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 找出偶数
        Stream<Integer> integerStream = numberLIst.stream()
                .filter(number -> {
                    int temp = number % 2;
                    if (temp == 0) {
                        System.out.println(number);
                    }
                    return temp == 0;
                });

        System.out.println("分割线");
        // 到这里才调用
        List<Integer> collect = integerStream.collect(Collectors.toList());
    }
}
