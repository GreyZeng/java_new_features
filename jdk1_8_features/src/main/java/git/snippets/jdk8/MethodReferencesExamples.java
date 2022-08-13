package git.snippets.jdk8;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * @since 1.8
 */
public class MethodReferencesExamples {

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(SOURCE sourceCollection, Supplier<DEST> collectionFactory) {

        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }

    public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> merger) {
        return merger.apply(a, b);
    }

    public static String appendStrings(String a, String b) {
        return a + b;
    }

    public String appendStrings2(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {

        MethodReferencesExamples myApp = new MethodReferencesExamples();

        // 使用 lambda 表达式
        System.out.println(MethodReferencesExamples.mergeThings("Hello ", "World!", (a, b) -> a + b));

        // 静态方法
        System.out.println(MethodReferencesExamples.mergeThings("Hello ", "World!", MethodReferencesExamples::appendStrings));

        // 实例方法
        System.out.println(MethodReferencesExamples.mergeThings("Hello ", "World!", myApp::appendStrings2));

        // 对一个特定类型的任意对象的实例方法的引用
        System.out.println(MethodReferencesExamples.mergeThings("Hello ", "World!", String::concat));
        List<Person> roster = Person.createRoster();
        // 构造方法
        Set<Person> rosterSet = transferElements(roster, HashSet::new);
    }
}
