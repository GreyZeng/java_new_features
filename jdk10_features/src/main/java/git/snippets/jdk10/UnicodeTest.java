package git.snippets.jdk10;

import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;

/**
 * unicode扩展
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 10
 */
public class UnicodeTest {
    public static void main(String[] args) {
        Currency chinaCurrency = Currency.getInstance(Locale.CHINA);
        Currency usCurrency = Currency.getInstance(Locale.US);
        System.out.println("本地货币：" + chinaCurrency);
        System.out.println("US.货币：" + usCurrency);

        String displayName = Locale.getDefault().getDisplayName();
        String displayLanguage = Locale.getDefault().getDisplayLanguage();
        String displayCountry = Locale.getDefault().getDisplayCountry();
        System.out.println("本地名称：" + displayName);
        System.out.println("本地语言：" + displayLanguage);
        System.out.println("本地国家：" + displayCountry);
        int firstDayOfWeek = Calendar.getInstance().getFirstDayOfWeek();
        System.out.println("本地每周第一天：" + firstDayOfWeek);
    }
}
