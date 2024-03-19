package git.snippets.jdk22;

/**
 * since 22
 * 直接运行 java Hello.java
 */
public class Hello {
    public static void main(String[] args) {
        System.out.println(Greetings.greet(args[0]));
    }
}