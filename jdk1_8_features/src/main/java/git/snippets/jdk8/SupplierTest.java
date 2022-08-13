package git.snippets.jdk8;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * Supplier使用
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/27
 * @since
 */
public class SupplierTest {
    public static void main(String[] args) throws InterruptedException {
        s1();
        //  Supplier实现工厂模式
        System.out.println(factory(() -> new Sharp("abc")));
    }

    private static void s1() throws InterruptedException {
        // 定义一个Supplier，可以生成区间为[0,10)的随机数
        Supplier<Integer> supplier = () -> new Random().nextInt(10);
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        // 获取当前时间
        Supplier<LocalDateTime> s2 = LocalDateTime::now;
        System.out.println(s2.get());
        Thread.sleep(1000);
        System.out.println(s2.get());
    }

    // supplier实现工厂模式
    static Sharp factory(Supplier<? extends Sharp> supplier) {
        Sharp sharp = supplier.get();
        sharp.name = sharp.name + UUID.randomUUID();
        return sharp;
    }

}


class Sharp {
    String name;

    Sharp(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sharp{" + "name='" + name + '\'' + '}';
    }
}