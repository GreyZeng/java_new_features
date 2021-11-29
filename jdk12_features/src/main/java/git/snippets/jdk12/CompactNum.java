package git.snippets.jdk12;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * 简化的数字格式可以直接转换数字显示格式，比如 1000 -> 1K，1000000 -> 1M 。
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 12
 */
public class CompactNum {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        System.out.println("Compact Formatting is:");
        NumberFormat upvotes = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);

        System.out.println(upvotes.format(100));
        System.out.println(upvotes.format(1000));
        System.out.println(upvotes.format(10000));
        System.out.println(upvotes.format(100000));
        System.out.println(upvotes.format(1000000));

// 设置小数位数
        upvotes.setMaximumFractionDigits(1);
        System.out.println(upvotes.format(1234));
        System.out.println(upvotes.format(123456));
        System.out.println(upvotes.format(12345678));
    }
}
