package git.snippets.jdk16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/8/21
 * @since 16
 */
public class StreamToListMethodDemo {
    public static void main(String[] args) {
        List<String> integersAsString = Arrays.asList("1", "2", "3");
        // before jdk 16
        List<Integer> ints = integersAsString.stream().map(Integer::parseInt).collect(Collectors.toList());
        // jdk 16+
        List<Integer> intsEquivalent = integersAsString.stream().map(Integer::parseInt).toList();
    }
}
