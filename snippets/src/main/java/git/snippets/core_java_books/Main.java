package git.snippets.core_java_books;

import java.util.*;

public class Main {
    void main() {
        System.out.println("Hello world!");
        var generator = new Random();
        System.out.println(generator.nextDouble());
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                doWork();
            }
        };
        task.run();
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add(null);
        names.add("Bob");
        names.add("Mary");
        names.add(null);
        System.out.println(names);
        names.removeIf(Objects::isNull);
        System.out.println(names);
        names.forEach(System.out::println);
        System.out.println("");
        names.forEach(x -> System.out.println(x));
    }

    private void doWork() {
        System.out.println("Hello world!");
    }


}