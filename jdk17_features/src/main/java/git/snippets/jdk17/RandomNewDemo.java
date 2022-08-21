package git.snippets.jdk17;

import java.util.random.RandomGeneratorFactory;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/8/21
 * @since 17
 */
public class RandomNewDemo {
    public IntStream getPseudoInts(String algorithm, int streamSize) {
        // returns an IntStream with size @streamSize of random numbers generated using the @algorithm
        // where the lower bound is 0 and the upper is 100 (exclusive)
        return RandomGeneratorFactory.of(algorithm)
                .create()
                .ints(streamSize, 0, 100);
    }
}
