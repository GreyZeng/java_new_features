package git.snippets.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 参考：https://www.wdbyte.com/java8/java8-list-to-map/
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

    // key name, value age;
    static void sample1() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("牧羊犬", 1));
        list.add(new Dog("哈士奇", 2));
        list.add(new Dog("田园犬", 3));

        // to map,key dog name,value ,dog age
        Map<String, Integer> dogMap = list.stream().collect(Collectors.toMap(Dog::getName, Dog::getAge));

        System.out.println(dogMap);
    }

    // key name value object
    static void sample2() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("牧羊犬", 1));
        list.add(new Dog("哈士奇", 2));
        list.add(new Dog("田园犬", 3));

// to map,key dog name,value ,dog age
        Map<String, Dog> dogMap = list.stream().collect(Collectors.toMap(Dog::getName, dog -> dog));

        System.out.println(dogMap);
    }

    /**
     * 处理重复数据
     */
    static void sample3() {
        List<Dog> list = new ArrayList<>(4);
        list.add(new Dog("牧羊犬", 1));
        list.add(new Dog("牧羊犬", 2));
        list.add(new Dog("哈士奇", 2));
        list.add(new Dog("田园犬", 3));

        // 包含重复数据的时候，只保留最新的一条
        Map<String, Integer> dogMap = list.stream().collect(Collectors.toMap(Dog::getName, Dog::getAge, (oldData, newData) -> newData));
        System.out.println(dogMap);
    }

    /**
     * 重复数据->ConcurrentHashMap
     */
    static void sample4() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("牧羊犬", 1));
        list.add(new Dog("牧羊犬", 2));
        list.add(new Dog("哈士奇", 2));
        list.add(new Dog("田园犬", 3));
        Map<String, Integer> dogMap = list.stream().collect(Collectors.toMap(Dog::getName, Dog::getAge, (oldData, newData) -> newData, ConcurrentHashMap::new));
        System.out.println(dogMap.getClass());
    }
}

class Dog {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;

    public Dog() {
    }

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
