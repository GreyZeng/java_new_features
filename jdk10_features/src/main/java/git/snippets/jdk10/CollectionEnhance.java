package git.snippets.jdk10;

import java.util.ArrayList;
import java.util.Collections;
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
        var vegetables = new ArrayList<>(List.of("Brocolli", "Celery", "Carrot"));
        var unmodifiable = Collections.unmodifiableList(vegetables);
        vegetables.set(0, "Radish");
        var v = unmodifiable.get(0);
        unmodifiable.set(0, "XXX");
        System.out.println(v);
        System.out.println(unmodifiable);
    }

    static void copyOfTest() {
        var list = List.of("a", "b", "c");
        var copyList = List.copyOf(list);
        list.add("d");
        // 由于copyList是副本， 所以copyList不会受到list的影响，打印出[a,b,c]
        System.out.println(copyList);
        System.out.println(list);
        // 由于是不可变集合，所以这里会报错
        copyList.add("d");
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
