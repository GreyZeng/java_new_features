package git.snippets.jdk8;

import java.time.*;
import java.lang.*;
import java.util.*;

public class TestSimpleTimeClient {
    public static void main(String... args) {
        // NOTE：SimpleTimeClient无须做任何改动
        TimeClient myTimeClient = new SimpleTimeClient();
        System.out.println("Current time: " + myTimeClient.toString());
        // 调用默认实现
        System.out.println("Time in California: " + myTimeClient.getZonedDateTime("Blah blah").toString());
    }
}