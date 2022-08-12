package git.snippets.jdk7;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * @author <a href="mailto:410486047@qq.com">GreyZeng</a>
 * @version 1.0, 2022/8/12
 * @since 1.7
 */
public class FileWatcherTest {
    public static void main(String[] args) throws Exception {
        fileWatch();
    }

    // 监听文件/文件夹的变化
    private static void fileWatch() throws Exception {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        // FIXME 换成你本地目录
        Path path = Paths.get("D:\\test");
        path.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        while (true) {
            WatchKey watchKey = watchService.take();
            // 获取事件类型
            for (WatchEvent<?> pollEvent : watchKey.pollEvents()) {
                // 具体的事件上下文信息
                Path tempPath = (Path) pollEvent.context();
                WatchEvent.Kind<?> kind = pollEvent.kind();
                if (kind.name().equals(StandardWatchEventKinds.ENTRY_CREATE.name())) {
                    System.out.println("创建了一个文件：" + tempPath.toString());
                }
                if (kind.name().equals(StandardWatchEventKinds.ENTRY_DELETE.name())) {
                    System.out.println("删除了一个文件：" + tempPath.toString());
                }
                if (kind.name().equals(StandardWatchEventKinds.ENTRY_MODIFY.name())) {
                    System.out.println("修改了一个文件：" + tempPath.toString());
                }
            }
            // 事件处理完毕后要进行 reset 才能继续监听事件
            watchKey.reset();
            // 取消监视
            // watchKey.cancel();
        }
    }
}
