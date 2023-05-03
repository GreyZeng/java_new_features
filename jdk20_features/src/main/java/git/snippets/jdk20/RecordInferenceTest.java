package git.snippets.jdk20;

import java.util.List;

/**
 * record 支持类型推断
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2023/05/03
 * @since 20
 */
public class RecordInferenceTest {

    // 需要指定类型
    static void preJDK20(Multi<String> multi) {
        if (multi instanceof Tuple<String>(var s1, var s2)) {
            System.out.println("Tuple: " + s1 + ", " + s2);
        } else if (multi instanceof Triple<String>(var s1, var s2, var s3)) {
            System.out.println("Triple: " + s1 + ", " + s2 + ", " + s3);
        }
    }

    static void JDK20(Multi<String> multi) {
        if (multi instanceof Tuple(var s1, var s2)) {
            System.out.println("Tuple: " + s1 + ", " + s2);
        } else if (multi instanceof Triple(var s1, var s2, var s3)) {
            System.out.println("Triple: " + s1 + ", " + s2 + ", " + s3);
        }
    }

    static void preJDK20Loop(List<Position> positions) {
        for (Position p : positions) {
            System.out.printf("(%d, %d)%n", p.x(), p.y());
        }
    }
    static void JDK20Loop(List<Position> positions) {
        for (Position(int x, int y) : positions) {
            System.out.printf("(%d, %d)%n", x, y);
        }
    }
    private record Position(int x, int y) {
    }

}


interface Multi<T> {
}

record Tuple<T>(T t1, T t2) implements Multi<T> {
}

record Triple<T>(T t1, T t2, T t3) implements Multi<T> {
}
