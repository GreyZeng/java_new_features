package git.snippets.jdk7;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;

/**
 * @author <a href="mailto:410486047@qq.com">GreyZeng</a>
 * @version 1.0, 2022/8/12
 * @link git.snippets.jdk8.FileWalkStreamDemo
 * @since 1.7
 */
public class NewFileTest {

    public static void main(String[] args) throws IOException {
        // FIXME 使用你本地存在的路径
        final String path = "D:\\git\\algorithm\\src";
        // pathTest1(path);

        // pathOp();
        // fileInfo();
        listFile2();
    }

    private static void pathTest1(final String pathString) {

        Path path = Paths.get(pathString);
        System.out.println("完整路径：" + path.toString());

        Path pathParent = path.getParent();
        System.out.println("父级路径：" + pathParent.toString());

        Path pathRoot = path.getRoot();
        System.out.println("根目录：" + pathRoot.toString());

        int pathNameCount = path.getNameCount();
        System.out.println("目录深度：" + pathNameCount);

        Path pathIndex3 = path.getName(2);
        System.out.println("第三级目录：" + pathIndex3);

        Path subPath = path.subpath(1, 3);
        System.out.println("第1级目录到第三级目录（包左不包右）：" + subPath.toString());

// resolveSibling 从当前目录父目录开始拼接目录
        // FIXME 使用你本地存在的路径
        Path pathResolveSibling = path.resolveSibling("src\\main");
        System.out.println("父目录开始拼接参数：" + pathResolveSibling.toString());

// resolve 把当前路径当作父路径，参数作为子目录或者文件
        // FIXME 使用你本地存在的路径
        Path pathResolve = Paths.get("\\java\\snippet").resolve("SimpleSortMethod.java");
        System.out.println("当前目录拼接后的目录：" + pathResolve.toString());

// 参数路径相对于主体路径的相对路径
        // FIXME 使用你本地存在的路径
        Path path1 = Paths.get("\\java\\snippet");
        Path path2 = Paths.get("\\java\\snippet\\SimpleSortMethod.java");
        Path path3 = path1.relativize(path2);
        System.out.println("相对路径：" + path3.toString());
    }

    private static void pathOp() throws IOException {
        // 如果文件不存在，则创建一个文件
        Path path = Paths.get("test.txt");
        Path pathBackup = Paths.get("test_bak.txt");
        Path pathLink = Paths.get("test.txt.link");
        Path pathDir = Paths.get("dir");

// 已存在则删除
        Files.deleteIfExists(path);
        Files.deleteIfExists(pathBackup);
        Files.deleteIfExists(pathLink);
        Files.deleteIfExists(pathDir);

// 创建文件写入内容
        Path file = Files.createFile(path);
        Files.write(path, "ABC".getBytes());
        Files.write(path, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
        Files.write(path, "EFG".getBytes(), StandardOpenOption.APPEND);
        System.out.println("创建文件：" + file.toString());

// 创建文件链接
        pathLink = Files.createLink(pathLink, path);
        System.out.println("创建文件：" + pathLink.toString());

// 创建目录
        Path directory = Files.createDirectory(pathDir);
        System.out.println("创建目录：" + directory.toString());

// 文件复制
        Files.copy(path, pathBackup);
        System.out.println("复制文件: " + path + " --> " + pathBackup);

// 读取文件
        List<String> lines = Files.readAllLines(pathBackup, Charset.defaultCharset());
        for (String line : lines) {
            System.out.println("文件读取：" + line);
        }
    }

    private static void fileInfo() throws IOException {
        // FIXME 使用你本地存在的文件
        Path path = Paths.get("D:\\git\\algorithm\\README.md");
        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes basicFileAttributes = fileAttributeView.readAttributes();
        FileTime creationTime = basicFileAttributes.creationTime();
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();
        System.out.println("创建时间：" + creationTime);
        System.out.println("上次修改时间：" + lastModifiedTime);
        System.out.println("上次访问时间：" + lastAccessTime);

        boolean directory = basicFileAttributes.isDirectory();
        boolean regularFile = basicFileAttributes.isRegularFile();
        boolean symbolicLink = basicFileAttributes.isSymbolicLink();
        System.out.println("是否目录：" + directory);
        System.out.println("是否普通文件：" + regularFile);
        System.out.println("是否符号链接：" + symbolicLink);

        long size = basicFileAttributes.size();
        System.out.println("文件大小：" + size);

        // Linux或者Mac使用下面PosixFileAttributeView
        // PosixFileAttributeView linuxFileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
//        UserPrincipal owner = linuxFileAttributeView.getOwner();
//        System.out.println("文件归属用户:" + owner.getName());
        // Windows使用DosFileAttributeView
        DosFileAttributeView windowsFileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        DosFileAttributes dosFileAttributes = windowsFileAttributeView.readAttributes();
    }

    // 文件流 jdk1.7之前
    // 这种遍历方式看起来也是十分优雅的，可是这种方式在面对大量文件时，效率会变的很低。

    public static void listFile() {
        // FIXME 改成你自己本地的可访问路径
        String pathString = "D:\\git\\algorithm\\src\\main\\java\\snippet";
        File file = new File(pathString);
        File[] listFiles = file.listFiles();
        for (File tempFile : listFiles) {
            System.out.println("file list: " + tempFile.getAbsolutePath());
        }
    }

    // 所以 Java 7 也对此进行了改进，引入了 DirectoryStream 文件列表流。它可以进行渐进式的文件遍历，每次读取一定数量，降低遍历时的性能开销，
    // 但是 DirectoryStream 遍历时只会遍历它的直接目录和文件，不会递归的遍历子目录。下面是它的遍历写法。
    public static void listFile2() throws IOException {
        // FIXME 改成你自己本地的可访问路径
        String pathString = "D:\\git\\algorithm\\src\\main\\java\\snippet";
// Path 直接遍历方式，不会遍历子目录
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(pathString))) {
            for (Path pathTemp : directoryStream) {
                System.out.println("DirectoryStream: " + pathTemp);
            }
        }

// Path 直接遍历方式 - 筛选 .class 文件
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(pathString), "*.java")) {
            for (Path pathTemp : directoryStream) {
                System.out.println("DirectoryStream file type is class : " + pathTemp);
            }
        }
    }
}
