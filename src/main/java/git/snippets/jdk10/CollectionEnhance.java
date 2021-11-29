package git.snippets.jdk10;

import java.util.ArrayList;
import java.util.List;
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
        List<String> list = List.of("a", "b", "c");
        list.stream().collect(Collectors.toUnmodifiableList());
        list.stream().collect(Collectors.toUnmodifiableSet());
        list.stream().collect(Collectors.toUnmodifiableSet());
    }
}
