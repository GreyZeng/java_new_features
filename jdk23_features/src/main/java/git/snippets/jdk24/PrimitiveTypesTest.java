package git.snippets.jdk24;

/**
 * @since 23
 */
public class PrimitiveTypesTest {
    void main() {
        test1("hello world");
        test2("hello world");
        test1(56);
        test2(56);
        test1(java.time.LocalDate.now());
        test2(java.time.LocalDate.now());
        test3(3);
        test3(9);
        test3(90); // 打印任何输出，switch中没有找到匹配项目
    }

    private static void test1(Object obj) {
        if (obj instanceof String s && s.length() >= 5) {
            System.out.println(s.toUpperCase());
        } else if (obj instanceof Integer i) {
            System.out.println(i * i);
        } else {
            System.out.println(obj);
        }
    }

    private static void test2(Object obj) {
        switch (obj) {
            case String s when s.length() >= 5 -> System.out.println(s.toUpperCase());
            case Integer i -> System.out.println(i * i);
            case null, default -> System.out.println(obj);
        }
    }

    private static void test3(int x) {
        switch (x) {
            case 1, 2, 3 -> System.out.println("Low");
            case 4, 5, 6 -> System.out.println("Medium");
            case 7, 8, 9 -> System.out.println("High");
        }
    }
}
