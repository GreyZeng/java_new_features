package git.snippets.jdk15;

/**
 * 被 sealed 修饰的类可以指定子类。这样这个类就只能被指定的类继承。
 * <p>
 * 在jdk15中是预览功能，在jdk17中被正式启用
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 15
 */
public class SealedClassTest {
    public static void main(String[] args) {

    }
}

//sealed interface Dog permits Collie, TuGou {
//    //...
//}
//
//sealed class Collie implements Dog permits BorderCollie {
//
//}
//
//final class BorderCollie extends Collie {
//}
//
//// 使用 non-sealed 关键字，表示可以被任意继承
//non-sealed class TuGou implements Dog {
//}