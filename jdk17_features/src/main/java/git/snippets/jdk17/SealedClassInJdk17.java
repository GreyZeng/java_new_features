package git.snippets.jdk17;

/**
 * 密封类（Sealed Classes）
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 17
 */
public class SealedClassInJdk17 {
    public static void main(String[] args) {

    }
}

sealed interface Dog permits Collie, TuGou {
    //...
}

sealed class Collie implements Dog permits BorderCollie {

}

final class BorderCollie extends Collie {
}

// 使用 non-sealed 关键字，表示可以被任意继承
non-sealed class TuGou implements Dog {
}
