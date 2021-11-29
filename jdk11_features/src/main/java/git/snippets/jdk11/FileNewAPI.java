package git.snippets.jdk11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * File增强API
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since
 */
public class FileNewAPI {
    public static void main(String[] args) throws IOException {
        testFile();
    }

    static void testFile() throws IOException {
        // 创建临时文件
        Path path = Files.writeString(Files.createTempFile("test", ".txt"), "hello world,你好，世界");
        System.out.println(path);
// 读取文件
// String ss = Files.readString(Path.of("file.json"));
        String s = Files.readString(path);
        System.out.println(s);

// 结果
// https://www.wdbyte.com
    }
}
