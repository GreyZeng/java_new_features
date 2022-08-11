package git.snippets.jdk7;

/**
 * @since jdk1.7
 */
public class BinaryTest {
    public static void main(String[] args) {
        // 0b是二进制的开头
        int b = 0b111;
        System.out.println(b);

        int i = -32;
        System.out.println((i >>> 2));
        System.out.println((i >> 2));
    }
}