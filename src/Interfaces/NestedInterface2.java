package Interfaces;

public class NestedInterface2 {
    public static void main(String[] args) {

        Outer outer = new Outer();

        System.out.println(outer.a);
        outer.fun1();
        Outer.fun2();
        // outer.fun2(); // allowed but should not be doing
        outer.fun3();
        Outer.fun4();
        // outer.fun4(); // allowed but should not be doing

        Outer.Inner inner = new InnerClass();
        inner.fun1();
        // inner.fun2();
        Outer.Inner.fun2();
        // inner.fun3(); // not part of nested interface
        // inner.fun4(); // not part of nested interface
        // Outer.Inner.fun4(); // not part of nested interface
        inner.fun5();
        // inner.fun6();
        Outer.Inner.fun6();

        inner.tester();

    }
}

class Outer {

    int a;

    public Outer() {
        System.out.println("Outer Constructor Called .......................");
        this.a = 10;
    }

    void fun1() {
        System.out.println("Outer fun1 called");
    }

    static void fun2() {
        System.out.println("Outer fun2 called");
    }

    void fun3() {
        System.out.println("Outer fun3 called");
    }

    static void fun4() {
        System.out.println("Outer fun4 called");
    }

    // Implicitly static and can't be private
    interface Inner {

        int a = 20;

        void fun1();

        static void fun2() {
            System.out.println("Inner fun2 called");
        }

        default void fun5() {
            fun1(); // Important
            System.out.println("Inner fun5 called");
        }

        static void fun6() {
            System.out.println("Inner fun6 called");
        }

        default void tester() {
            System.out.println(a);
            System.out.println(Inner.a);

            fun1();
            fun2();
            // fun3(); // not visible
            // fun4(); // not visible
            fun5();
            fun6();

            Outer outer = new Outer();

            System.out.println(outer.a);
            outer.fun1();
            Outer.fun2();
            // outer.fun2(); // allowed but should not be doing
            outer.fun3();
            Outer.fun4();
            // outer.fun4(); // allowed but should not be doing

        }
    }
}

class InnerClass implements Outer.Inner {

    @Override
    public void fun1() {
        System.out.println("InnerClass fun1 called");
    }
}
