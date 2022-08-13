package git.snippets.jdk8;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/20
 * @since 1.8
 */
public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        function0();
        func1();
        func3();
        func4();
        func5();
        func6();

        // 实现工厂模式
        System.out.println(carFactory(1, "a", Car::new));
        filter();
        // 根据不同条件进行筛选或判断
        biPredicate();
        biFunction();
    }

    // 最简单的函数式接口
    static void function0() {
        FunctionDemo demo = (name, age) -> System.out.println("我叫" + name + "我今年" + age + "岁");
        demo.say("zhangsan", 20);
        demo.hi("zhanshang", 20);
    }

    // 根据不同条件进行筛选或判断
    private static void biPredicate() {
        List<Car> list = new ArrayList<>();
        list.add(new Car(1, "abc"));
        list.add(new Car(2, "bcd"));
        list.add(new Car(3, "ccc"));
        // 筛选id为2的记录
        BiPredicate<Integer, String> identify = (id, name) -> id == 2;
        System.out.println(list.stream().filter(cat -> identify.test(cat.getId(), cat.getName())).collect(Collectors.toList()));
        // 筛选name为ccc的记录
        BiPredicate<Integer, String> name = (id, n) -> "ccc".equals(n);
        System.out.println(list.stream().filter(cat -> name.test(cat.getId(), cat.getName())).collect(Collectors.toList()));
        // 筛选id为2或name为ccc的记录
        BiPredicate<Integer, String> idAndName = (id, n) -> "ccc".equals(n) || id == 2;
        System.out.println(list.stream().filter(cat -> idAndName.test(cat.getId(), cat.getName())).collect(Collectors.toList()));
        // 判断字段长度是否等于给定的值
        BiPredicate<String, Integer> biPredicate = (s, i) -> s.length() == i;
        System.out.println(biPredicate.test("abc", 3)); // true
        System.out.println(biPredicate.test("abc", 4)); // false

        BiPredicate<String, String> startsWith = String::startsWith;
        BiPredicate<String, String> endsWith = String::endsWith;
        // 判断某个字符串是否是另外一个字符串的前缀
        System.out.println(startsWith.test("abc", "ab")); // true
        System.out.println(startsWith.test("abc", "abcd")); // false
        // 使用逻辑表达式来判断
        // 是否既以某个字符串作为开头，又以这个字符串作为结尾
        System.out.println(startsWith.and(endsWith).test("33abb", "b"));
        // 以某个字符串作为开头，或者以某个字符串作为结尾
        System.out.println(startsWith.or(endsWith).test("33abb3", "3"));
    }


    // 构建一个可以过滤指定集合条件的 filter 方法。
    private static void filter() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        // 筛选2的倍数
        List<Integer> ans = list.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        System.out.println(ans);
        // 筛选长度为3的字符串
        List<String> stringList = Arrays.asList("a", "ab", "abc");
        List<String> ans2 = stringList.stream().filter(s -> s.length() == 3).collect(Collectors.toList());
        System.out.println(ans2);
    }

    // 实现工厂模式
    public static <R extends Car> Car carFactory(int id, String name, BiFunction<Integer, String, R> biFunction) {
        return biFunction.apply(id, name);
    }


    // T1和T2经过某个转换得到R1，R1经过某个转换得到R2
    public static <T1, T2, R1, R2> R2 convert(T1 t1, T2 t2, BiFunction<T1, T2, R1> biFunction, Function<R1, R2> function) {
        return biFunction.andThen(function).apply(t1, t2);
    }

    private static void biFunction() {
        // Hello字符串的长度
        // World字符串串的长度
        // 两个字符串的长度之和sum
        // 打印：长度和：sum
        String result = convert("Hello", "World", (s1, s2) -> s1.length() + s2.length(), r1 -> "长度和:" + r1);
        System.out.println(result);

        // 两个String经过某个处理逻辑返回一个Integer
        BiFunction<String, String, Integer> lenOf = (s1, s2) -> s1.length() + s2.length();
        System.out.println(lenOf.apply("abc", "bcd"));

        // 两个String经过lenOf规则后，再继续进行某种规则的处理
        String apply1 = lenOf.andThen(s -> "长度和" + s).apply("hello", "world");
        System.out.println(apply1);
    }


    // List -> List<Object>
    private static void func6() {
        List<String> list = Arrays.asList("a", "bc", "def");
        List<String> map = map(list, String::toUpperCase);
        System.out.println(map);
    }


    static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>(list.size());
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    private static void func5() {
        List<String> list = Arrays.asList("a", "bc", "dfg");
        Function<String, Integer> lenFunc = String::length;
        Map<String, Integer> stringIntegerMap = listToMap(list, lenFunc);
        System.out.println(stringIntegerMap);
        Function<String, String> upperFunc = String::toUpperCase;
        System.out.println(listToMap(list, upperFunc));
    }

    static <T, R> Map<T, R> listToMap(List<T> list, Function<T, R> function) {
        Map<T, R> map = new HashMap<>();
        for (T t : list) {
            map.put(t, function.apply(t));
        }
        return map;
    }


    static void func1() {
        Function<String, String> toUpperCase = (String::toUpperCase);
        String apply = toUpperCase.apply("hello,world");
        System.out.println(apply);
    }

    static void func3() {
        Function<String, Integer> lengthFunction = String::length;
        Integer length = lengthFunction.apply("www.wdbyte.com");
        System.out.println(length);
    }

    static void func4() {
        Function<String, Integer> lengthFunction = String::length;
        Function<Integer, Integer> doubleFunction = length -> length * 2;
        Integer doubleLength = lengthFunction.andThen(doubleFunction).apply("hello,world");
        System.out.println(doubleLength);
    }

    static class Car {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Car(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Car{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }
}
