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
        func0();
        func1();
        func3();
        func4();
        func5();
        func6();
        bifunc1();
        bifunc2();
        // 实现工厂模式
        factory();
        filter();
        biPredicate();
        // BiPredicate实现过滤器
        biPredicateFilter();
    }

    private static void biPredicateFilter() {
        List<Cat> list = new ArrayList<>();
        list.add(new Cat(1, "abc"));
        list.add(new Cat(2, "bcd"));
        list.add(new Cat(3, "ccc"));
        // 筛选id为2的cat
        BiPredicate<Integer, String> identify = (id, name) -> id == 2;
        // 选名字为ccc的cat
        BiPredicate<Integer, String> name = (id, n) -> "ccc".equals(n);

        BiPredicate<Integer, String> idAndName = (id, n) -> "ccc".equals(n) || id == 2;
        System.out.println(filter(list, identify));
        System.out.println(filter(list, name));
        System.out.println(filter(list, idAndName));
    }

    public static <T extends Cat> List<T> filter(List<T> list, BiPredicate<Integer, String> biPredicate) {
        return list.stream().filter(cat -> biPredicate.test(cat.getId(), cat.getName()))
                .collect(Collectors.toList());
    }

    private static void biPredicate() {
        BiPredicate<String, Integer> biPredicate = (s, i) -> s.length() == i;
        System.out.println(biPredicate.test("abc", 3));
        System.out.println(biPredicate.test("abc", 4));

        BiPredicate<String, String> startsWith = String::startsWith;
        BiPredicate<String, String> endsWith = String::endsWith;
        System.out.println(startsWith.and(endsWith).test("33abb", "b"));
        System.out.println(startsWith.and(endsWith).test("33abb3", "3"));
        System.out.println(startsWith.test("abc", "a"));
        System.out.println(startsWith.test("abc", "ab"));
        System.out.println(startsWith.test("abc", "abc"));
        System.out.println(startsWith.test("abc", "abD"));
    }

    // 构建一个可以过滤指定集合条件的 filter 方法。
    private static void filter() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        // 筛选 2 的倍数
        List<Integer> result1 = filter(list, 2, FunctionInterfaceDemo::divisible);
        System.out.println(result1);
        // 筛选 3 的倍数
        List<Integer> result2 = filter(list, 3, FunctionInterfaceDemo::divisible);
        System.out.println(result2);
        // 筛选 4 的倍数
        List<Integer> result3 = filter(list, 4, FunctionInterfaceDemo::divisible);
        System.out.println(result3);

        // 筛选长度为 4 的字符串
        List<String> stringList = Arrays.asList("java", "node", "c++", "rust", "www.wdbyte.com");
        List<String> stringList1 = filter(stringList, 4, (s, n) -> s.length() == 4 ? true : null);
        System.out.println(stringList1);
    }


    private static <T, U, R> List<T> filter(List<T> list, U u, BiFunction<T, U, R> biFunction) {

        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (biFunction.apply(t, u) != null) {
                result.add(t);
            }
        }
        return result;
    }

    private static Boolean divisible(Integer i1, Integer i2) {
        if (i1 % i2 == 0) {
            return true;
        }
        return null;
    }

    private static void factory() {
        System.out.println(catFactory(1, "tomcat", Cat::new));
        System.out.println(catFactory(2, "jerrycat", Cat::new));
    }

    public static <R extends Cat> Cat catFactory(int id, String name, BiFunction<Integer, String, R> biFunction) {
        return biFunction.apply(id, name);
    }

    static class Cat {
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

        public Cat(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Cat{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }


    private static void bifunc2() {
        String result = convert("Hello", "World", (s1, s2) -> s1.length() + s2.length(), r1 -> "长度和:" + r1);
        System.out.println(result);

        String convert = convert(1, 2, (a1, a2) -> a1 + a2, r1 -> "和为：" + r1);
        System.out.println(convert);
    }

    public static <T1, T2, R1, R2> R2 convert(T1 t1, T2 t2, BiFunction<T1, T2, R1> biFunction, Function<R1, R2> function) {
        return biFunction.andThen(function).apply(t1, t2);
    }

    private static void bifunc1() {
        BiFunction<String, String, Integer> lenOf = (s1, s2) -> s1.length() + s2.length();
        System.out.println(lenOf.apply("abc", "bcd"));


        BiFunction<Integer, Integer, Double> pow = Math::pow;
        Double apply = pow.apply(2, 10);
        System.out.println(apply);


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
        Function<String, Integer> lenFunc = s -> s.length();
        Map<String, Integer> stringIntegerMap = listToMap(list, lenFunc);
        System.out.println(stringIntegerMap);
        Function<String, String> upperFunc = s -> s.toUpperCase();
        System.out.println(listToMap(list, upperFunc));
    }

    static <T, R> Map<T, R> listToMap(List<T> list, Function<T, R> function) {
        Map<T, R> map = new HashMap<>();
        for (T t : list) {
            map.put(t, function.apply(t));
        }
        return map;
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
