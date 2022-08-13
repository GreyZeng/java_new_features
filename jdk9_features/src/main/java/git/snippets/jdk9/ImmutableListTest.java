package git.snippets.jdk9;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 创建不可变集合
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/28
 * @since 9
 */
public class ImmutableListTest {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        List<String> list1 = List.of("a", "b");
        // 创建了不可变的List，不可以执行add操作
        System.out.println(list1); // true

        // 创建不可变的Set，不可以执行add操作
        Set<String> set = Set.of("ab", "bc");
        System.out.println(set.size());

        // 创建了不可变Map，无法put元素
        Map<String, Integer> map1 = Map.of("a", 2, "b", 3, "c", 4);
        System.out.println(map1);
        Map<String, Integer> map2 = Map.ofEntries(Map.entry("a", 1), Map.entry("b", 2));
        System.out.println(map2);
    }
}
