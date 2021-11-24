package git.snippets.jdk8;

import java.util.function.Function;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/20
 * @since 1.8
 */
public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        func0();
        func1();
        func3();
        func4();
    }

    static void func0() {
        FunctionDemo demo = (name, age) -> System.out.println("我叫" + name + "我今年" + age + "岁");
        demo.say("zhangsan", 20);
        demo.hi("zhanshang", 20);
    }

    static void func1() {
        Function<String, String> toUpperCase = (String::toUpperCase);
        String apply = toUpperCase.apply("hello,world");
        System.out.println(apply);
    }

    static void func3() {
        Function<String, Integer> lengthFunction = str -> str.length();
        Integer length = lengthFunction.apply("www.wdbyte.com");
        System.out.println(length);
    }

    static void func4() {
        Function<String, Integer> lengthFunction = str -> str.length();
        Function<Integer, Integer> doubleFunction = length -> length * 2;
        Integer doubleLength = lengthFunction.andThen(doubleFunction).apply("hello,world");
        System.out.println(doubleLength);
    }
}
