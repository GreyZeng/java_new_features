package git.snippets.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * list 转 map
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/16
 * @since 1.8
 */
public class List2Map {
    public static void main(String[] args) {
        sample1();
        sample2();
        sample3();
        sample4();
    }

    /**
     * key name, value number
     */
    static void sample1() {
        List<Car> list = new ArrayList<>();
        list.add(new Car("A", 1));
        list.add(new Car("B", 2));
        list.add(new Car("C", 3));

        // to map,key car name,value ,car number
        Map<String, Integer> carMap = list.stream().collect(Collectors.toMap(Car::getName, Car::getNum));

        System.out.println(carMap);
    }

    /**
     * key name value object
     */
    static void sample2() {
        List<Car> list = new ArrayList<>();
        list.add(new Car("A", 1));
        list.add(new Car("B", 2));
        list.add(new Car("C", 3));
        Map<String, Car> carMap = list.stream().collect(Collectors.toMap(Car::getName, car -> car));
        System.out.println(carMap);
    }

    /**
     * 处理重复数据 包含重复数据的时候，只保留最新的一条
     */
    static void sample3() {
        List<Car> list = new ArrayList<>(4);
        list.add(new Car("A", 1));
        list.add(new Car("A", 2));
        list.add(new Car("B", 2));
        list.add(new Car("C", 3));
        Map<String, Integer> carMap = list.stream().collect(Collectors.toMap(Car::getName, Car::getNum, (oldData, newData) -> newData));
        System.out.println(carMap);
    }

    /**
     * 重复数据,包含重复数据的时候，只保留最新的一条,并把结果保存到ConcurrentHashMap
     */
    static void sample4() {
        List<Car> list = new ArrayList<>();
        list.add(new Car("A", 1));
        list.add(new Car("A", 2));
        list.add(new Car("B", 2));
        list.add(new Car("C", 3));
        Map<String, Integer> carMap = list.stream().collect(Collectors.toMap(Car::getName, Car::getNum, (oldData, newData) -> newData, ConcurrentHashMap::new));
        System.out.println(carMap.getClass());
    }
}

class Car {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    private Integer num;

    public Car() {
    }

    public Car(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "car{" + "name='" + name + '\'' + ", number=" + num + '}';
    }
}
