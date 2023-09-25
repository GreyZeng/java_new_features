package git.snippets.jdk21;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * String template 预览功能
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2023/09/25
 * @since 21
 */
public class StringTemplateTest {
    public static void main(String[] args) throws Exception {
        stringTestBefore21();
        stringTest21();
    }

    public static void stringTestBefore21() {
        int a = 1;
        int b = 2;

        String concatenated = a + " times " + b + " = " + a * b;
        String format = String.format("%d times %d = %d", a, b, a * b);
        String formatted = "%d times %d = %d".formatted(a, b, a * b);
        System.out.println(concatenated);
        System.out.println(format);
        System.out.println(formatted);
    }

    public static void stringTest21() {
        int a = 1;
        int b = 2;


        String interpolated = STR. "\{ a } times \{ b } = \{ a * b }" ;
        System.out.println(interpolated);

        String dateMessage = STR. "Today's date: \{
                LocalDate.now().format(
                        // We could also use DateTimeFormatter.ISO_DATE
                        DateTimeFormatter.ofPattern("yyyy-MM-dd")
                ) }" ;
        System.out.println(dateMessage);


        int httpStatus = 200;
        String errorMessage = "error pwd";

        String json = STR. """
    {
      "httpStatus": \{ httpStatus },
      "errorMessage": "\{ errorMessage }"
    }""" ;
        System.out.println(json);
    }
}
