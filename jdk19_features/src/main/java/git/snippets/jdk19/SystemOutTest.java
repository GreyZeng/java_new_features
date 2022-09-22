package git.snippets.jdk19;

/**
 * VM options when calling the application:
 *
 * -Dstdout.encoding=utf8 -Dstderr.encoding=utf8
 *
 * or
 *
 * following environment variable (yes, it begins with an underscore):
 *
 * _JAVA_OPTIONS="-Dstdout.encoding=utf8 -Dstderr.encoding=utf8"
 * @since 19
 */
public class SystemOutTest {
    public static void main(String[] args) {
        System.out.println("世界你好！");
    }
}