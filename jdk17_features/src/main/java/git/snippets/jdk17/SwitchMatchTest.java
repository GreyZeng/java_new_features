//package git.snippets.jdk17;
//
//
///**
// * switch类型匹配(预览功能)
// *
// * @author <a href="mailto:410486047@qq.com">Grey</a>
// * @date 2021/11/29
// * @since 17
// */
//public class SwitchMatchTest {
//    public static void main(String[] args) {
//
//    }
//
//    record Human(String name, int age, String profession) {
//    }
//
//    record Circle() implements Shape {
//        public int getNumberOfSides() {
//            return 0;
//        }
//    }
//
//    interface Shape {
//    }
//
//    record Triangle() implements Shape {
//        public int getNumberOfSides() {
//            return 0;
//        }
//    }
//
//    public String checkObject(Object obj) {
//        return switch (obj) {
//            case Human h -> "Name: %s, age: %s and profession: %s".formatted(h.name(), h.age(), h.profession());
//            case Circle c -> "This is a circle";
//            case Shape s -> "It is just a shape";
//            case null -> "It is null";
//            default -> "It is an object";
//        };
//    }
//
//    public String checkShape(Shape shape) {
//        return switch (shape) {
//            case Triangle t && (t.getNumberOfSides() != 3) -> "This is a weird triangle";
//            case Circle c && (c.getNumberOfSides() != 0) -> "This is a weird circle";
//            default -> "Just a normal shape";
//        };
//    }
//}
