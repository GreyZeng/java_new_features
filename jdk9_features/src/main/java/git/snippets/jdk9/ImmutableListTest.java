package git.snippets.jdk9;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 集合工厂
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
        List<String> a = List.of("a", "b");
        List<String> b = List.of("a", "b");
        System.out.println(a.hashCode() == b.hashCode());

        // notes: 不能插入重复字符
        Set<String> ab = Set.of("ab", "bc");
        System.out.println(ab.size());


        Map<String, Integer> a1 = Map.of("a", 2, "b", 3, "c", 4);
        System.out.println(a1);

        Map<String, Integer> stringIntegerMap = Map.ofEntries(Map.entry("a", 1), Map.entry("b", 2));
        System.out.println(stringIntegerMap);
    }
}
