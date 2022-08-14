package git.snippets.jdk9;

import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.stream.Collectors;


/**
 * 获取进程相关信息
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/8/14
 * @since 9
 */
public class ProcessHandlerDemo {
    public static void main(String[] args) throws IOException {
        // 获取所有未结束的进程信息并打印
        ProcessHandle.allProcesses().filter(ProcessHandle::isAlive).collect(Collectors.toSet()).forEach(s -> System.out.println(s.info().command().get()));
        Runtime rt = Runtime.getRuntime();
        // FIXME 可以替换成你本地的一个进程名称
        Process p = rt.exec("java.exe");
        ProcessHandle pro = p.toHandle();
        p.onExit().thenRunAsync(() -> System.out.println("程序退出之后执行"));
        pro.supportsNormalTermination();
        if (pro.destroyForcibly()) {
            System.out.println("摧毁进程：" + pro.pid());
        }
        System.out.println(pro.isAlive());
    }
}
