package git.snippets.jdk20;

/**
 * record 模式匹配增强（二次预览）
 * 需要增加 --enable-preview参数
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2023/05/03
 * @since 20
 */
public class RecordTest {
    public static void main(String[] args) {
        Points points = new Points(1, 2);
        Line line = new Line(new Points(1, 2), new Points(3, 4));
        printPoints(points);
        printLine(line);
    }


    private static void printPoints(Object object) {
        if (object instanceof Points(int x, int y)) {
            System.out.println("jdk 19 object is a position, x = " + x + ", y = " + y);
        }
        if (object instanceof Points points) {
            System.out.println("pre jdk 19 object is a position, x = " + points.x()
                    + ", y = " + points.y());
        }
        switch (object) {
            case Points position -> System.out.println("pre jdk 19 object is a position, x = " + position.x()
                    + ", y = " + position.y());
            default -> throw new IllegalStateException("Unexpected value: " + object);
        }
        switch (object) {
            case Points(int x, int y) -> System.out.println(" jdk 19 object is a position, x = " + x
                    + ", y = " + y);
            default -> throw new IllegalStateException("Unexpected value: " + object);
        }

    }

    public static void printLine(Object object) {
        if (object instanceof Line(Points(int x1, int y1), Points(int x2, int y2))) {
            System.out.println("object is a path, x1 = " + x1 + ", y1 = " + y1
                    + ", x2 = " + x2 + ", y2 = " + y2);
        }
        switch (object) {
            case Line(Points(int x1, int y1), Points(int x2, int y2)) ->
                    System.out.println("object is a path, x1 = " + x1 + ", y1 = " + y1
                            + ", x2 = " + x2 + ", y2 = " + y2);
            // other cases ...
            default -> throw new IllegalStateException("Unexpected value: " + object);
        }
    }

}

record Points(int x, int y) {
}

record Line(Points from, Points to) {
}
