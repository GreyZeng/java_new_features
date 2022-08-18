package git.snippets.jdk11;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Optional用法
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/19
 * @since 11
 */
public class OptionalAndPredicateTest {
    public static void main(String[] args) {
        Optional<String> helloOptional = Optional.of("Hello");
        Optional<String> emptyOptional = Optional.empty();
        helloOptional.ifPresent(s -> System.out.println(s.length()));
        emptyOptional.ifPresent(s -> System.out.println(s.length()));
        List<String> lines = Arrays.asList("a", "  ", "", null, "b");
        List<String> ans = lines.stream().filter(Objects::nonNull).filter(Predicate.not(String::isBlank)).collect(Collectors.toList());
        System.out.println(ans);
    }
}
