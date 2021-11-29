package git.snippets.jdk9;

import java.util.stream.IntStream;

/**
 * Iterate增强
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 9
 */
public class IterateEnhanceTest {
    public static void main(String[] args) {
        IntStream.iterate(0, x -> x < 10, x -> x + 1).forEach(System.out::print);
    }
}
