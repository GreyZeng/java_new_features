package git.snippets.jdk19;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/9/22
 * @since
 */
public class ThreadTest {
    public static void main(String[] args) {
        //ThreadGroup.destroy(); //- 该方法的调用将被忽略。
        //ThreadGroup.isDestroyed() ;//- 总是返回false。
        //ThreadGroup.setDaemon() ; //- 设置守护者标志，但这已经没有效果了。
        //ThreadGroup.suspend();//会抛出一个UnsupportedOperationException。
        //ThreadGroup.resume();//会抛出一个UnsupportedOperationException。
        //ThreadGroup.stop();//会抛出一个UnsupportedOperationException。
    }
}
