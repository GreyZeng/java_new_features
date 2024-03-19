package git.snippets.jdk22;

/**
 * Unnamed Patterns And Variables
 * 预览功能
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2023/09/25
 * @since 21
 */
public class UnnamedPatternsAndVariablesTest {
    public static void main(String[] args) {
        String string = "a";
        try {
            int number = Integer.parseInt(string);
        } catch (NumberFormatException _) {
            System.err.println("Not a number");
        }
        Object object = null;
        if (object instanceof Points(int x, int _)) {
            System.out.println("object is a position, x = " + x);
        }
        Object obj = null;
        switch (obj) {
            case Byte    _ -> System.out.println("Integer number");
            case Short   _ -> System.out.println("Integer number");
            case Integer _ -> System.out.println("Integer number");
            case Long    _ -> System.out.println("Integer number");

            case Float  _ -> System.out.println("Floating point number");
            case Double _ -> System.out.println("Floating point number");

            default -> System.out.println("Not a number");
        }
    }
}

