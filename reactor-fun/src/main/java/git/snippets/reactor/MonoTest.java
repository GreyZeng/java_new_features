package git.snippets.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


/**
 * Hello world!
 *
 * @author Young
 */
public class MonoTest {
    public static void main(String[] args) {
        monoHello();
        monoLogic();
    }

    private static void monoLogic() {
        Flux<String> just = Flux.just("Ax", "Bx", "Cx");
        Mono<Boolean> x = just.all(s -> s.contains("x"));
        StepVerifier.create(x).expectNext(true).verifyComplete();


        Mono<Boolean> m1 = just.all(m -> m.contains("M"));
        StepVerifier.create(m1).expectNext(false).verifyComplete();

        Mono<Boolean> a = just.any(c -> c.contains("A"));
        StepVerifier.create(a).expectNext(true).verifyComplete();

    }

    private static void monoHello() {
        Mono.just("Craig").map(String::toUpperCase).map(n -> "hello " + n + " !").subscribe(System.out::print);
    }

}
