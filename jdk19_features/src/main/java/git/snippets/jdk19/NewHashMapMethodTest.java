package git.snippets.jdk19;

import java.util.*;

/**
 * HashMap新的构造方法
 *
 * @since 19
 */
public class NewHashMapMethodTest {
    public static void main(String[] arg) {
        // jdk 19之前
        // 由于有 扩容因子 0.75 的设置，所以如果要开辟一个120的哈希表，需要如下定义
        Map<Integer, Integer> map1 = new HashMap<>(160);
        for (int i = 0; i < 10; i++) {
            map1.put(i, i);
        }
        System.out.println(map1);
        // jdk 19及以后
        // 可以用newHashMap直接指定具体大小，不需要提前做换算
        Map<Integer, Integer> map2 = HashMap.newHashMap(120);
        for (int i = 0; i < 10; i++) {
            map2.put(i, i);
        }
        System.out.println(map2);
    }
}