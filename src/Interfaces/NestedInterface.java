package Interfaces;

public class NestedInterface {
    public static void main(String[] args) {

        Outer outer = new OuterClass();
        outer.fun1();
        outer.fun2();
        Outer.fun3();
        // outer.fun3(); // not visible

        Outer.Inner inner = new InnerClass();
        inner.fun1();
        inner.fun2();
        // inner.fun3();
        Outer.Inner.fun3();
        inner.fun4();
        inner.fun5();
        // inner.fun6(); // not visible
        Outer.Inner.fun6();

        inner.tester();

    }
}

interface Outer {

    int a = 10;

    void fun1();

    default void fun2() {
        System.out.println("Outer fun2 called");
    }

    static void fun3() {
        System.out.println("Outer fun3 called");
    }

    void fun4();

    default void fun5() {
        System.out.println("Outer fun5 called");
    }

    static void fun6() {
        System.out.println("Outer fun6 called");
    }

    interface Inner {

        int a = 20;

        void fun1();

        default void fun2() {
            System.out.println("Inner fun2 called");
        }

        static void fun3() {
            System.out.println("Inner fun3 called");
        }

        void fun7();

        default void fun8() {
            System.out.println("Inner fun5 called");
        }

        static void fun9() {
            System.out.println("Inner fun6 called");
        }

        default void tester() {
            System.out.println(a);
            System.out.println(Outer.a);
            System.out.println(Inner.a);

            fun1();
            fun2();
            fun3();
            fun7();
            fun8();
            fun9();

            Outer outer = () -> System.out.println("Outer fun1 caller");

            outer.fun1();
            outer.fun2();
            Outer.fun3();
            // outer.fun3(); not visible

        }
    }
}

class OuterClass implements Outer {

    @Override
    public void fun1() {
        System.out.println("OuterClass fun1 called");
    }
}

class InnerClass implements Outer.Inner {

    @Override
    public void fun1() {
        System.out.println("InnerClass fun1 called");
    }

    @Override
    public void fun4() {
        System.out.println("InnerClass fun4 called");
    }
}
