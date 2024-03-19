package git.snippets.jdk22;

import java.util.ArrayList;

public class UnnamedPatternTest {
    void main() {
        try {
            String string = "xx";
            int number = Integer.parseInt(string);
        } catch (NumberFormatException _) {
            System.err.println("Not a number");
        }
    }
}
