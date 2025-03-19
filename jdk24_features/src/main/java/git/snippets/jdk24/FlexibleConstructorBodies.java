package git.snippets.jdk24;

/**
 * **灵活的构造函数主体（第三次预览）** 在 JDK 23 是第二次预览
 * since 24
 */
public class FlexibleConstructorBodies {
    void main() {
        new Child1(1, 2);
        new Child2(1, 2);
    }
}


class Parent {
    private final int a;

    public Parent(int a) {
        this.a = a;
        printMe();
    }

    void printMe() {
        System.out.println("a = " + a);
    }
}

// JDK 23 之前
class Child1 extends Parent {
    private final int b;

    public Child1(int a, int b) {
        super(verifyParamsAndReturnA(a, b));
        this.b = b;
    }

    @Override
    void printMe() {
        super.printMe();
        System.out.println("b = " + b);
    }

    private static int verifyParamsAndReturnA(int a, int b) {
        if (a < 0 || b < 0) throw new IllegalArgumentException();
        return a;
    }
}

// JDK 23 及以后
class Child2 extends Parent {
    private final int b;

    public Child2(int a, int b) {
        if (a < 0 || b < 0) throw new IllegalArgumentException();
        this.b = b;
        super(a);
    }

    @Override
    void printMe() {
        super.printMe();
        System.out.println("b = " + b);
    }
}