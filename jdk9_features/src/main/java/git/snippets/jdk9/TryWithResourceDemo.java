package git.snippets.jdk9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/8/13
 * @since 9
 */
public class TryWithResourceDemo {
    public static void main(String[] args) throws IOException {
        System.out.println(readDataPreJDK9("test"));
        System.out.println(readDataInJDK9("test"));
    }

    static String readDataPreJDK9(String message) throws IOException {
        Reader inputString = new StringReader(message);
        BufferedReader br = new BufferedReader(inputString);
        try (BufferedReader br1 = br) {
            return br1.readLine();
        }
    }

    static String readDataInJDK9(String message) throws IOException {
        Reader inputString = new StringReader(message);
        BufferedReader br = new BufferedReader(inputString);
        try (br) {
            return br.readLine();
        }
    }
}
