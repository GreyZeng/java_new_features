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
        test2();
        test3();
    }

    static void test() {
        System.out.println("Compact Formatting is:");
        NumberFormat upvotes = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);

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
        System.out.println(upvotes.format(123456789));
    }

    static void test2() {
        System.out.println("Compact Formatting is:");
        NumberFormat upvotes = NumberFormat.getCompactNumberInstance(Locale.CHINA, NumberFormat.Style.SHORT);

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
        System.out.println(upvotes.format(123456789));
    }

    static void test3() {
        System.out.println("Compact Formatting is:");
        NumberFormat nfShort =
                NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        NumberFormat nfLong =
                NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);

        System.out.println("        1,000 short -> " + nfShort.format(1_000));
        System.out.println("      456,789 short -> " + nfShort.format(456_789));
        System.out.println("    2,000,000 short -> " + nfShort.format(2_000_000));
        System.out.println("3,456,789,000 short -> " + nfShort.format(3_456_789_000L));
        System.out.println();
        System.out.println("        1,000 long -> " + nfLong.format(1_000));
        System.out.println("      456,789 long -> " + nfLong.format(456_789));
        System.out.println("    2,000,000 long -> " + nfLong.format(2_000_000));
        System.out.println("3,456,789,000 long -> " + nfLong.format(3_456_789_000L));
    }
}
