package git.snippets.jdk11;

import java.util.HashMap;
import java.util.Map;

/**
 * lambda类型推断
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 11
 */
public class LambdaInfer {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(2);
        map.put("hello", 1);
        map.put("world", 2);
        map.forEach((var s, var i) -> System.out.println(s + " " + i));
    }
}
