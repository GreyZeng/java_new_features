package git.snippets.jdk19;

import java.util.Locale;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/9/22
 * @since 19
 */
public class LocaleTest {
    public static void main(String[] args) {
        Locale german1 = new Locale("de"); // deprecated
        Locale germany1 = new Locale("de", "DE"); // deprecated

        Locale german2 = Locale.of("de");
        Locale germany2 = Locale.of("de", "DE");

        System.out.println("german1 == Locale.GERMAN = " + (german1 == Locale.GERMAN));
        System.out.println("germany1 == Locale.GERMANY = " + (germany1 == Locale.GERMANY));
        System.out.println("german2 == Locale.GERMAN = " + (german2 == Locale.GERMAN));
        System.out.println("germany2 == Locale.GERMANY = " + (germany2 == Locale.GERMANY));
    }
}
