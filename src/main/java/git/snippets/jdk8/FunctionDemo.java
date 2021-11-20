package git.snippets.jdk8;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/20
 * @since 1.8
 */
@FunctionalInterface
public interface FunctionDemo {
    void say(String name, int age);

    default void hi(String name, int age) {
        say(name, age);
    }
}
