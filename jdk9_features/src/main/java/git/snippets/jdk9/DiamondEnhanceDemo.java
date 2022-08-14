package git.snippets.jdk9;

/**
 * 匿名类支持钻石操作符
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/8/14
 * @since 9
 */
public class DiamondEnhanceDemo {
    public static void main(String[] args) {
        // jdk9之前
        Handler<Integer> preJdk9 = new Handler<Integer>(1) {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };
        // jdk9及以上版本
        Handler<Integer> jdk9Above = new Handler<>(1) {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };
    }
}

abstract class Handler<T> {
    public T content;

    public Handler(T content) {
        this.content = content;
    }

    abstract void handle();
}

