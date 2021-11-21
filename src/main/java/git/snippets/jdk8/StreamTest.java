package git.snippets.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stream使用
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/21
 * @since 1.8
 */
public class StreamTest {
    // 数据源（source） -> 数据处理 / 转换（intermedia） -> 结果处理（terminal ）
    public static void main(String[] args) {
        demo1();
        demo2();
    }

    static void demo1() {
        List<String> nameList = Arrays.asList("Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter");
        nameList.stream()
                .filter(name -> name.length() == 4)
                .map(name -> "This is " + name)
                .forEach(System.out::println);
    }

    static void demo2() {
        List<String> nameList = Arrays.asList("Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter");
        List<String> upperCaseNameList = nameList.stream()
                .map(String::toUpperCase).toList();
        upperCaseNameList.forEach(name -> System.out.println(name + ","));
    }
    // TODO short-circuiting


}
