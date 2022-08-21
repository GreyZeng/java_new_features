//package git.snippets.jdk14;
//
///**
// * @author <a href="mailto:410486047@qq.com">Grey</a>
// * @date 2021/11/29
// * @since 14
// */
//public record Author(String name, String topic) implements Information {
//    public String getFullName() {
//        return "Author " + name + " writes on " + topic;
//    }
//
//    public Author() {
//
//        this("NA", "NA");
//    }
//
//    public Author(String name) {
//
//        this(name, "NA");
//    }
//}
//
//interface Information {
//    String getFullName();
//}