package git.snippets.jdk16;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 详见：https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/time/format/DateTimeFormatter.html
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/8/21
 * @since 16
 */
public class DayPeriodTest {
    public static void main(String[] args) {
        LocalTime date = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("B h:m");
        System.out.println(date.format(formatter));
    }
}
