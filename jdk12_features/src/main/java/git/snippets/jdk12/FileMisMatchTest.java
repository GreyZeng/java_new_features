package git.snippets.jdk12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 文件内容对比
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 12
 */
public class FileMisMatchTest {
    public static void main(String[] args) throws IOException {
        match();
    }

    static void match() throws IOException {
        Path pathA = Files.createFile(Paths.get("a.txt"));
        Path pathB = Files.createFile(Paths.get("b.txt"));

// 写入相同内容
        Files.write(pathA, "abc".getBytes(), StandardOpenOption.WRITE);
        Files.write(pathB, "abc".getBytes(), StandardOpenOption.WRITE);
        long mismatch = Files.mismatch(pathA, pathB);
        System.out.println(mismatch);

// 追加不同内容
        Files.write(pathA, "1234".getBytes(), StandardOpenOption.APPEND);
        Files.write(pathB, "1321".getBytes(), StandardOpenOption.APPEND);
        mismatch = Files.mismatch(pathA, pathB);
        System.out.println(mismatch);

// 删除创建的文件
        pathA.toFile().deleteOnExit();
        pathB.toFile().deleteOnExit();
    }
}
