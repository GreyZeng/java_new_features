
package git.snippets.jdk25;
/**
 * When Clause
 * @since 25
 */

public class WhenClausesTest {
    void main() {
        test("h");
        doubleToRating(100d);
        bigNumbers(100000000000l);
        testSwitch(new R(33));
    }
    static void test(Object obj) {
        switch (obj) {
            case String s when s.length() == 1 -> System.out.println("Short: " + s);
            case String s                      -> System.out.println(s);
            default                            -> System.out.println("Not a string");
        }
    }
    String doubleToRating(double rating) {
        return switch(rating) {
            case 0d -> "0 stars";
            case double d when d > 0d && d < 2.5d
                    -> d + " is not good";
            case double d when d >= 2.5f && d < 5d
                    -> d + " is better";
            case 5d -> "5 stars";
            default -> "Invalid rating";
        };
    }

    void bigNumbers(long v) {
        switch (v) {
            case long x when x < 1_000_000L ->
                    System.out.println("Less than a million");
            case long x when x < 1_000_000_000L ->
                    System.out.println("Less than a billion");
            case long x when x < 1_000_000_000_000L ->
                    System.out.println("Less than a trillion");
            case long x when x < 1_000_000_000_000_000L ->
                    System.out.println("Less than a quadrillion");
            default -> System.out.println("At least a quadrillion");
        }
    }
    record R(int x) { }
    // ...
    static void testSwitch(R r) {
        switch(r) {
            case R(int x) when x >= 5 -> System.out.println(x + " => 5");
            default -> System.out.println(r.x + " < 5");
        }
    }
}

