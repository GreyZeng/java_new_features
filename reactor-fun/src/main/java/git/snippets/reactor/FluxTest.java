package git.snippets.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

import java.io.Flushable;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/12/23
 * @since 11
 */
public class FluxTest {
    public static void main(String[] args) {
        collectMap();
        collectList();
        bufferAndFlatMap();
        fluxBuffer();
        fluxFlatMap();
        fluxMap();
        fluxDistinct();
        fluxFilter();
        fluxSkip();
        fluxTest();
        fluxTest2();
        fluxInterval();
        fluxMerge();
        fluxZip();
        fluxZip2();
        fluxFirst();
    }

    private static void collectMap() {
        Flux<String> just = Flux.just("Aa", "Bb", "Cc");
        Mono<Map<Character, String>> mapMono = just.collectMap(c -> c.charAt(0));
        StepVerifier.create(mapMono).expectNextMatches(m -> m.get('A').equals("Aa") && m.get('B').equals("Bb") && m.get('C').equals("Cc") && m.size() == 3).verifyComplete();
    }

    private static void collectList() {
        Flux<String> just = Flux.just("A", "B", "C");
        Mono<List<String>> listMono = just.collectList();
        StepVerifier.create(listMono).expectNext(Arrays.asList("A", "B", "C")).verifyComplete();
    }

    public static void bufferAndFlatMap() {
        Flux.just("apple", "orange", "banana", "kiwi", "strawberry").buffer(3).flatMap(x -> Flux.fromIterable(x).map(String::toUpperCase).subscribeOn(Schedulers.parallel()).log()).subscribe();
    }

    private static void fluxBuffer() {
        Flux<String> just = Flux.just("a", "b", "c", "d", "e");
        Flux<List<String>> buffer = just.buffer(3);
        StepVerifier.create(buffer).expectNext(Arrays.asList("a", "b", "c")).expectNext(Arrays.asList("d", "e")).verifyComplete();
    }

    private static void fluxFlatMap() {
        System.out.println("-----");
        Flux.just("M m", "Y y", "X x").flatMap(n -> Mono.just(n).map(c -> {
            Map<String, String> map = new HashMap<>();
            String[] s = c.split(" ");
            map.put(s[0], s[1]);
            return map;
        }).subscribeOn(Schedulers.parallel())).subscribe(System.out::println);
        System.out.println("---");
    }

    private static void fluxMap() {
        Flux.just("A a", "B b", "C c").map(c -> {
            Map<String, String> map = new HashMap<>();
            String[] s = c.split(" ");
            map.put(s[0], s[1]);
            return map;
        }).subscribe(System.out::println);

    }

    private static void fluxDistinct() {
        Flux<String> distinct = Flux.just("A", "A", "B", "B", "B", "C").distinct();
        StepVerifier.create(distinct).expectNext("A").expectNext("B").expectNext("C").verifyComplete();
    }

    private static void fluxFilter() {
        Flux<String> just = Flux.just("A", "B", "C");
        Flux<String> filter = just.filter(c -> !"C".equals(c));
        StepVerifier.create(filter).expectNext("A").expectNext("B").verifyComplete();
    }

    private static void fluxSkip() {
        Flux<String> just = Flux.just("A", "B", "C", "D");
        Flux<String> skip = just.skip(3);
        StepVerifier.create(skip).expectNext("D").verifyComplete();
    }

    private static void fluxFirst() {
        Flux<String> just = Flux.just("A", "B", "C");
        Flux<String> just1 = Flux.just("a", "b", "c");
        Flux.first(just, just1).subscribe(System.out::println);
    }

    private static void fluxZip2() {
        Flux<String> just = Flux.just("A", "B", "C");
        Flux<String> just1 = Flux.just("a", "b", "c");
        Flux<String> zip = Flux.zip(just, just1, (a, b) -> a + " " + b);
        zip.subscribe(System.out::println);
    }

    private static void fluxZip() {
        Flux<String> just = Flux.just("A", "B", "C");
        Flux<String> just1 = Flux.just("a", "b", "c");
        Flux<Tuple2<String, String>> zip = Flux.zip(just, just1);
        StepVerifier.create(zip).expectNextMatches(p -> "A".equals(p.getT1()) && "a".equals(p.getT2())).expectNextMatches(p -> "B".equals(p.getT1()) && "b".equals(p.getT2())).expectNextMatches(p -> "C".equals(p.getT1()) && "c".equals(p.getT2())).verifyComplete();
    }

    private static void fluxMerge() {
        Flux<String> characterFlux = Flux.just("Garfield", "Kojak", "Barbossa").delayElements(Duration.ofMillis(500));
        Flux<String> foodFlux = Flux.just("Lasagna", "Lollipops", "Apples").delaySubscription(Duration.ofMillis(250)).delayElements(Duration.ofMillis(500));
        Flux<String> mergedFlux = characterFlux.mergeWith(foodFlux);
        StepVerifier.create(mergedFlux).expectNext("Garfield").expectNext("Lasagna").expectNext("Kojak").expectNext("Lollipops").expectNext("Barbossa").expectNext("Apples").verifyComplete();

    }

    private static void fluxInterval() {
        Flux<Long> take = Flux.interval(Duration.ofSeconds(1)).take(5);
        StepVerifier.create(take).expectNext(0L).expectNext(1L).expectNext(2L).expectNext(3L).expectNext(4L).verifyComplete();
    }

    private static void fluxTest2() {
        Flux<Integer> range = Flux.range(1, 5);
        StepVerifier.create(range).expectNext(1).expectNext(2).expectNext(3).expectNext(4).expectNext(5).verifyComplete();
    }

    static void fluxTest() {
        Flux.just("A", "B", "C").subscribe(c -> System.out.println("Hello " + c));
        Flux<String> just = Flux.just("a", "b", "c");
        StepVerifier.create(just).expectNext("a").expectNext("b").expectNext("c").verifyComplete();
    }
}
