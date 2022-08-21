package git.snippets.jdk18;

import java.nio.charset.Charset;

public class UFT8Test {
    public static void main(String[] args) {
        System.out.println("Default charset : " + Charset.defaultCharset());
        System.out.println("file.encoding   : " + System.getProperty("file.encoding"));
        System.out.println("native.encoding : " + System.getProperty("native.encoding"));
        System.out.println(Charset.defaultCharset());
        System.out.println("你好");
    }
}
