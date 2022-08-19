package git.snippets.jdk12;

import java.math.BigDecimal;

/**
 * String 新增API
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/8/19
 * @since 12
 */
public class StringNewAPIDemo {
    public static void main(String[] args) {
        String s = "I am\na multiline\nString.";
        System.out.println(s);
        // 缩进4个位置
        System.out.println(s.indent(4));

        // 将一个任意的函数应用于一个字符串
        // 效果等同于 String uppercase = "abcde".toUpperCase();
        String uppercase = "abcde".transform(String::toUpperCase);
        System.out.println(uppercase);
        
        // 效果等同于 Integer i  = Integer.valueOf("12345");
        Integer i = "12345".transform(Integer::valueOf);
        System.out.println(i);

        // 效果等同于 BigDecimal big = new BigDecimal("1234567891011121314151617181920");
        BigDecimal big = "1234567891011121314151617181920".transform(BigDecimal::new);
        System.out.println(big);
    }
}
