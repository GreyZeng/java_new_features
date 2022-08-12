package git.snippets.jdk8;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:410486047@qq.com">GreyZeng</a>
 * @version 1.0, 2022/8/12
 * @since 1.8
 */
public class FileWalkStreamDemo {
    public static void main(String[] args) throws Exception {
        fileTravel();
    }

    // 在 Java 8 中对 Files 类进行了增强，引入了 Java 8 的 Lambda 表达式，增加了 walk 方法，遍历文件也有异曲同工之妙（下面的例子中用到了 Lambda 表达式）。
    public static void fileTravel() throws Exception {
// FIXME 修改成你自己本地的路径
        final String pathString = "D:\\git\\algorithm\\src\\main\\java\\snippet";

// 遍历所有目录和子目录
        Stream<Path> pathStream = Files.walk(Paths.get(pathString));
        pathStream.forEach(pathTemp -> {
            System.out.println("Stream: " + pathTemp.toString());
        });

// 遍历所有目录和子目录 - 筛选 java 文件
        pathStream = Files.walk(Paths.get(pathString));
        pathStream
                .filter(pathTemp -> pathTemp.toString().endsWith(".java"))
                .forEach(pathTemp -> {
                    System.out.println("Stream filter java: " + pathTemp.toString());
                });
    }
}
