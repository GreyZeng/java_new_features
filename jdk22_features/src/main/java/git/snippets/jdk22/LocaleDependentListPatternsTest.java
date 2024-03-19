package git.snippets.jdk22;

import static java.text.ListFormat.*;

import java.text.ListFormat;
import java.util.List;
import java.util.Locale;

public class LocaleDependentListPatternsTest {
    void main() {
        List<String> list = List.of("Earth", "Wind", "Fire");
        System.out.println(ListFormat.getInstance(Locale.CHINA, Type.STANDARD, Style.FULL).format(list));
        System.out.println(ListFormat.getInstance(Locale.US, Type.STANDARD, Style.FULL).format(list));
        System.out.println(ListFormat.getInstance(Locale.GERMAN, Type.STANDARD, Style.FULL).format(list));
        System.out.println(ListFormat.getInstance(Locale.FRANCE, Type.STANDARD, Style.FULL).format(list));
    }
}
