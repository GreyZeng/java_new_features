package git.snippets.jdk7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:410486047@qq.com">GreyZeng</a>
 * @version 1.0, 2022/8/12
 */
public class HeapPollution {
    public static void main(String[] args) {
        List l = new ArrayList<Number>();
        List<String> ls = l;       // unchecked warning
        l.add(0, new Integer(42)); // another unchecked warning
        String s = ls.get(0);      // ClassCastException is thrown
    }
}
