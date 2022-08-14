package git.snippets.jdk9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Optional增强
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/8/13
 * @since 9
 */
public class OptionalDemo {
    public static void main(String[] args) {
        // Optional的stream方法
        List<Optional<String>> list = Arrays.asList(Optional.empty(), Optional.of("A"), Optional.empty(), Optional.of("B"), Optional.ofNullable(null));
        // jdk 9 之前
        list.stream().flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty()).forEach(System.out::println);
        // jdk 9 优化后
        list.stream().flatMap(Optional::stream).forEach(System.out::println);

        // Optional的ifPresentOrElse方法
        Optional<Integer> optional = Optional.of(1);
        optional.ifPresentOrElse(x -> System.out.println("Value: " + x), () -> System.out.println("Not Present."));
        optional = Optional.empty();
        optional.ifPresentOrElse(x -> System.out.println("Value: " + x), () -> System.out.println("Not Present."));
        optional = Optional.ofNullable(null);
        optional.ifPresentOrElse(x -> System.out.println("Value: " + x), () -> System.out.println("Not Present."));


        // Optional的or方法
        Optional.empty().or(() -> Optional.of("Not Present")).ifPresent(x -> System.out.println("value:" + x));
        Optional.of("hello").or(() -> Optional.of("Not Present")).ifPresent(x -> System.out.println("value:" + x));
    }
}
