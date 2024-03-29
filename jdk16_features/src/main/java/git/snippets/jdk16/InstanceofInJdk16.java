package git.snippets.jdk16;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * instanceof
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 16
 */
public class InstanceofInJdk16 {
    public static void main(String[] args) {
        Object o = new ArrayList<String>();
        // jdk 16
        if (o instanceof ArrayList list) {
            list.add("a");
        }

        // before jdk 16
        if (o instanceof ArrayList) {
            ArrayList list = (ArrayList) o;
            list.add("a");
        }
    }
}
