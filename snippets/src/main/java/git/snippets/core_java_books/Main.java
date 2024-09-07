package git.snippets.core_java_books;

import java.util.Random;

public class Main {
    void main() {
        System.out.println("Hello world!");
        var generator = new Random();
        System.out.println(generator.nextDouble());
    }
}