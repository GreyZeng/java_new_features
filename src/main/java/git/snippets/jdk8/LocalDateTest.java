package git.snippets.jdk8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/18
 * @since 1.8
 */
public class LocalDateTest {
    public static void main(String[] args) {
        try {
            errorDate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        until();
    }

    static void errorDate() {
        // 不合法的日期
        LocalDate invalidDate = LocalDate.of(2021, 2, 29);
        invalidDate.minusYears(1);
        System.out.println(invalidDate.minusYears(1));
    }

    static void until() {
        LocalDate birthday = LocalDate.of(1989, 9, 27);
        System.out.println(birthday.until(LocalDate.now(), ChronoUnit.DAYS));
    }

    // 有时区的精确时间
    static void zone() {
        ZonedDateTime nowZone = LocalDateTime.now().atZone(ZoneId.systemDefault());
        System.out.println("当前精确时间（有时区）：" + nowZone);
        System.out.println("当前精确时间（有时区）：" + nowZone.getYear() + "-" + nowZone.getMonthValue() + "-" + nowZone.getDayOfMonth() + " " + nowZone.getHour() + "-" + nowZone.getMinute() + "-" + nowZone.getSecond());
    }

}
