package git.snippets.jdk9;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since
 */
public class InterfacePrivateTest {
    public static void main(String[] args) {
        X x = new X();
        x.sleep();
        x.eat();
        x.doXxx();
        A.x();
    }
}

class X implements A {
    @Override
    public void sleep() {
        System.out.println("sleep");
    }
}

interface A {
    void sleep();

    default void eat() {
        sleep();
    }

    default void doXxx() {
        drink();
        x();
    }

    static void x() {
        System.out.println("x");
    }

    private void drink() {
        System.out.println("drink");
        x();
    }
}
