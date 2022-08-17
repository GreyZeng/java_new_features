package git.snippets.jdk10;

/**
 * 类型推断
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/8/17
 * @since 10
 */
public class TypeRefEnhance {
    public static void main(String[] args) {
        var a = 2; // a表示int
        System.out.println(a);
        var b = "hello"; // b 表示String
        System.out.println(b);
        var date = new java.util.Date();
        System.out.println(date);
        var obj = new Customer("Grey"); // 自定义对象
        System.out.println(obj);
        var sum = new TypeRefEnhance().add(1, 23);
        System.out.println(sum);
        var var = 3;
        System.out.println(var);
    }

    public int add(int a, int b) {
        return a + b;
    }

    static class Customer {
        String name;

        public Customer(String n) {
            name = n;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name=" + name +
                    '}';
        }
    }
}
