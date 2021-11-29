package git.snippets.jdk14;

/**
 * switch 增强
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 14
 */
public class SwitchInJdk14 {
    public static void main(String[] args) {
        test("apple");
        test2("june");
        System.out.println(test3("apple"));
        System.out.println(test3("abc"));
    }

    // 在jdk12是预览特性，在14正式引入
    static void test(String c) {
        switch (c) {
            case "apple", "Apple" -> System.out.println("苹果");
            case "banana", "Banana" -> System.out.println("香蕉");

        }
    }

    static void test2(String day) {
        String season = switch (day) {
            case "march", "april", "may" -> "春天";
            case "june", "july", "august" -> "夏天";
            case "september", "october", "november" -> "秋天";
            case "december", "january", "february" -> "冬天";
            default -> {
                throw new RuntimeException("day error");
            }
        };
        System.out.println("当前季节是:" + season);
    }


    private static String test3(String c) {
        return switch (c) {
            case "apple", "Apple":
                yield "苹果";
            case "banana":
                yield "香蕉";
            default:
                yield "无法识别";
        };
    }
}
