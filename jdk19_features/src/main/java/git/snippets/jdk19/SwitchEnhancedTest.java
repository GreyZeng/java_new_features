package git.snippets.jdk19;

/**
 * switch 增强 第三次预览
 * 需要增加 --enable-preview参数
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/9/22
 * @since 19
 */
public class SwitchEnhancedTest {
    public static void main(String[] args) {
        checkObjSince19("hello world");
    }

    public static void checkObjSince19(Object when) {
        // // when 是一个所谓的 "上下文关键字"，因此只在一个 case 标签中具有意义。如果你的代码中有名称为 "when "的变量或方法，你不需要改变它们。
        switch (when) {
            case String s when s.length() > 5 -> System.out.println(s.toUpperCase());
            case String s -> System.out.println(s.toLowerCase());

            case Integer i -> System.out.println(i * i);

            default -> {
            }
        }
    }
}
