package git.snippets.jdk7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:410486047@qq.com">GreyZeng</a>
 * @version 1.0, 2022/8/12
 * @since 1.7
 */
public class TypeRefTest {
    public static void main(String[] args) {
        // before jdk1.7
        Map<String, List<String>> myMap = new HashMap<String, List<String>>();

        // jdk1.7+
        Map<String, List<String>> myMap2 = new HashMap<>();


        List<_String> list = new ArrayList<>();
        list.add(new _String("A"));
        List<? extends _String> list2 = new ArrayList<>();
        list.addAll(list2);
        System.out.println(list);
    }
}
