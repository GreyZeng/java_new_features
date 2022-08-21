package git.snippets.jdk14;

/**
 * NullPointerException提示信息优化
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @see NullPointerException
 * @since 14
 */
public class NullPointerTest {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s.isEmpty());
    }
}

// Java SE 14 之前的报错信息如下
//    Exception in thread "main" java.lang.NullPointerException
//        at git.snippets.jdk7.NullPointerTest.main(NullPointerTest.java:11)
// Java SE 14 的报错信息如下

