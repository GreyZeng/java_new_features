package git.snippets.jdk9;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since
 */
public class InterfacePrivateTest {
    public static void main(String[] args) {
        ChinaPeople chinaPeople = new ChinaPeople();
        chinaPeople.sleep();
        chinaPeople.eat();
        chinaPeople.doXxx();
    }
}

class ChinaPeople implements People {
    @Override
    public void sleep() {
        System.out.println("躺着睡");
    }
}

interface People {
    void sleep();

    default void eat() {
        drink();
    }

    default void doXxx() {
        drink();
    }

    private void drink() {
        System.out.println("喝水");
    }
}
