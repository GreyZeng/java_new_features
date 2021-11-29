package git.snippets.jdk8;

import java.util.Optional;

/**
 * Optional用法
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/19
 * @since 1.8
 */
public class OptionalTest {
    public static void main(String[] args) {
        handleNull();
        orElseGet();
        emptyGetException();
        orElseException();
        funcOptional();
    }

    static void handleNull() {
        //String s = null;
        //Optional<String> s1 = Optional.of(s);
        // System.out.println(s1.isPresent());
        Optional<String> hello = Optional.of("hello");
        Optional<Object> empty = Optional.empty();
        Optional<Object> nullObj = Optional.ofNullable(null);
        System.out.println(hello.isPresent());
        System.out.println(empty.isPresent());
        System.out.println(nullObj.isPresent());

    }

    static void emptyGetException() {
        try {
            Optional<String> hello = Optional.of("hello");
            System.out.println(hello.get());
            Optional<Object> empty = Optional.empty();
            System.out.println(empty.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void orElseException() {
        try {
            Optional<String> emptyOptional = Optional.empty();
            String value = emptyOptional.orElseThrow(() -> new Exception("发现空值"));
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void orElseGet() {
        Optional<Object> empty = Optional.empty();
        Object o = empty.orElseGet(() -> "default");
        System.out.println(o);
        Object aDefault = empty.orElse("default");
        System.out.println(aDefault);
    }

    static void funcOptional() {
        Optional<Integer> optional123 = Optional.of(123);
        optional123.filter(num -> num == 123).ifPresent(num -> System.out.println(num));

        Optional<Integer> optional456 = Optional.of(456);
        optional456.filter(num -> num == 123).ifPresent(num -> System.out.println(num));

        // map 转换
        Optional<Integer> optional789 = Optional.of(789);
        optional789.map(String::valueOf).map(String::length).ifPresent(length -> System.out.println(length));
    }

}
