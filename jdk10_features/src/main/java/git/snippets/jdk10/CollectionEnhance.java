package git.snippets.jdk10;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 集合API增强
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 10
 */
public class CollectionEnhance {
    public static void main(String[] args) {
        testCopy();
        unmodifiedTest();
    }

    private static void testCopy() {
        var list = new ArrayList<String>();
        list.add("abc");
        list.add("bcd");
        List<String> copyList = List.copyOf(list);
        list.add("test");
        System.out.println(copyList);
    }

    static void unmodifiedTest() {
        List<String> list = List.of("b", "a", "b", "c");
        List<String> c1 = list.stream().collect(Collectors.toUnmodifiableList());
        System.out.println(c1);
        // 会报错
//        c1.add("c");
//        System.out.println(c1);
        Set<String> c2 = list.stream().collect(Collectors.toUnmodifiableSet());
        System.out.println(c2);
        // 会报错
//        c2.add("a");
//        System.out.println(c2);
        // 会报错
//        c2.add("e");
//        System.out.println(c2);
    }
}
