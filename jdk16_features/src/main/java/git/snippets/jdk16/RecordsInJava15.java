package git.snippets.jdk16;

/**
 * Records功能
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 16
 */
public class RecordsInJava15 {
    public static void main(String[] args) {
        test();
    }

    // record 是一种全新的类型，它本质上是一个 final 类，
    // 同时所有的属性都是 final 修饰，它会自动编译出 public get hashcode 、equals、toString 等方法，减少了代码编写量。
    private static void test() {
        Cat c1 = new Cat("tomcat", 1);
        Cat c3 = new Cat("tomcat", 1);
        Cat c2 = new Cat("jerry", 2);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1 == c3);
    }
}

record Cat(String name, Integer age) {
}
