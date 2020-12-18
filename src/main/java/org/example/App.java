package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("hello jdk8")).start();
    }
}
