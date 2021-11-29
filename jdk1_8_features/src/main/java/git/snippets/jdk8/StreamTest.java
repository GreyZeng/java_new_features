package git.snippets.jdk8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream使用
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/21
 * @since 1.8
 */
public class StreamTest {
    // 数据源（source） -> 数据处理 / 转换（intermedia） -> 结果处理（terminal ）
    public static void main(String[] args) {
        demo1();
        mathTest();
        groupByTest();
        partitioningByTest();
        generateTest();
        diffOfUseStreamAndNot();
    }

    static void demo1() {
        List<String> nameList = Arrays.asList("Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter");
        nameList.stream()
                .filter(name -> name.length() == 4)
                .map(name -> "This is " + name)
                .forEach(System.out::println);
    }

    static void mathTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        IntSummaryStatistics stats = list.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("最小值：" + stats.getMin());
        System.out.println("最大值：" + stats.getMax());
        System.out.println("个数：" + stats.getCount());
        System.out.println("和：" + stats.getSum());
        System.out.println("平均数：" + stats.getAverage());
    }

    static void groupByTest() {
        List<Integer> ageList = Arrays.asList(11, 22, 13, 14, 25, 26);
        Map<String, List<Integer>> groupMap = ageList.stream()
                .collect(Collectors.groupingBy(age -> String.valueOf(age / 10)));
        groupMap.forEach((k, v) -> {
            System.out.println("年龄" + k + "0多岁的有：" + v);
        });
    }

    static void partitioningByTest() {
        List<Integer> ageList = Arrays.asList(11, 22, 13, 14, 25, 26);
        Map<Boolean, List<Integer>> ageMap = ageList.stream()
                .collect(Collectors.partitioningBy(age -> age > 18));
        System.out.println("未成年人：" + ageMap.get(false));
        System.out.println("成年人：" + ageMap.get(true));
    }

    static void diffOfUseStreamAndNot() {
        generateHandle();
        useStream();
    }

    private static void useStream() {
        List<String> names = Arrays.asList("Jack", "Jill", "Nate", "Kara", "Kim", "Jullie", "Paul", "Peter");
        String nameString = names.stream()
                .filter(num -> num.length() == 4)
                .collect(Collectors.joining(", "));
        System.out.println(nameString);
    }

    private static void generateHandle() {
        // 不使用流操作
        List<String> names = Arrays.asList("Jack", "Jill", "Nate", "Kara", "Kim", "Jullie", "Paul", "Peter");
        // 筛选出长度为4的名字
        List<String> subList = new ArrayList<>();
        for (String name : names) {
            if (name.length() == 4) {
                subList.add(name);
            }
        }
        // 把值用逗号分隔
        StringBuilder sbNames = new StringBuilder();
        for (int i = 0; i < subList.size() - 1; i++) {
            sbNames.append(subList.get(i));
            sbNames.append(", ");
        }
        // 去掉最后一个逗号
        if (subList.size() > 1) {
            sbNames.append(subList.get(subList.size() - 1));
        }
        System.out.println(sbNames);
    }


    static void generateTest() {
        // 生成自己的随机数流
        Random random = new Random();
        Stream<Integer> generateRandom = Stream.generate(random::nextInt);
        generateRandom.limit(5).forEach(System.out::println);
        // 生成自己的 UUID 流
        Stream<UUID> generate = Stream.generate(UUID::randomUUID);
        generate.limit(5).forEach(System.out::println);
    }


}
