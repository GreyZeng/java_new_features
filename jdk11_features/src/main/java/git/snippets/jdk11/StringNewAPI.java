package git.snippets.jdk11;

/**
 * String 新增API
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @see String
 * @since 11
 */
public class StringNewAPI {
    public static void main(String[] args) {
        isBlankTest();
        linesTest();
        repeatTest();
        stripTest();
    }
    // 按行打印
    private static void linesTest() {
        String abcd = "\na\nb\tc\td";
        abcd.lines().forEach(System.out::println);
    }
    // String.isBlank()
    private static void isBlankTest() {
        String blank = "   ";
        System.out.println(blank.isBlank());
    }

    static void repeatTest() {
        String repeat = "abcd";
        // repeat(n) 表示复制几次
        String repeat3 = repeat.repeat(3);
        System.out.println(repeat3);
    }

    //trim 只能去除半角空格，而 strip 是去除各种空白符。
    static void stripTest() {
        String a = "   bbbd a  ";
        String b = a.strip();
        System.out.println(b);
        System.out.println(a);
        String strip = "    我是       ";
        // 去前面空白字符，如全角空格，TAB
        System.out.println("==" + strip.stripLeading() + "==");
// 去后面空白字符，如全角空格，TAB
        System.out.println("==" + strip.stripTrailing() + "==");
    }
}
