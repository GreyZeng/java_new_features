package git.snippets.jdk8;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/20
 * @since 1.8
 */
public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        FunctionDemo demo = (name, age) -> System.out.println("我叫" + name + "我今年" + age + "岁");
        demo.say("zhangsan", 20);
        demo.hi("zhanshang", 20);
    }
}
