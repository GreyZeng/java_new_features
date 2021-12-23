package git.snippets.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 * @author Young
 */
public class MonoTest {
    public static void main(String[] args) {
        Mono.just("Craig").map(String::toUpperCase).map(n -> "hello " + n + " !").subscribe(System.out::print);
    }
}
