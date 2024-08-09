package Interfaces;

public class NestedInterface3 {
    public static void main(String[] args) {

        Outer outer = new OuterClass();
        outer.fun1();
        outer.fun2();
        Outer.fun3();
        // outer.fun3(); // not allowed
        outer.fun4();
        outer.fun5();
        Outer.fun6();
        // outer.fun6(); // not allowed

        Outer.Inner inner = new Outer.Inner();
        inner.fun1();
        inner.fun2();
        // inner.fun3(); // allowed but should not be doing that
        Outer.Inner.fun3();
        // inner.fun4(); // not part of nested interface
        // inner.fun5(); // not part of nested interface
        // inner.fun6(); // not part of nested interface
        // Outer.Inner.fun6(); // not part of nested interface
        inner.fun7();
        // inner.fun8(); // allowed but should not be doing that
        Outer.Inner.fun8();

        inner.tester();

    }
}

interface Outer {

    int a = 10;

    void fun1();

    default void fun2() {
        fun1(); // Important
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

    // implicitly static and can only be public
    class Inner {

        int a;

        public Inner() {
            System.out.println("Inner Constructor Called .......................");
            this.a = 30;
        }

        void fun1() {
            System.out.println("Inner fun1 called");
        }

        public void fun2() {
            fun1(); // Important
            System.out.println("Inner fun2 called");
        }

        static void fun3() {
            System.out.println("Inner fun3 called");
        }

        public void fun7() {
            System.out.println("Inner fun7 called");
        }

        static void fun8() {
            System.out.println("Inner fun8 called");
        }

        public void tester() {
            System.out.println(a);
            System.out.println(Outer.a);

            fun1();
            fun2();
            fun3();
            // fun4(); // not visible
            // fun5(); // not visible
            // fun6(); // not visible
            fun7();
            fun8();

            Outer outer = new Outer() {
                @Override
                public void fun1() {
                    System.out.println("Anonymous Inner fun1 called");
                }

                @Override
                public void fun4() {
                    System.out.println("Anonymous Inner fun4 called");
                }
            };

            outer.fun1();
            outer.fun2();
            Outer.fun3();
            // outer.fun3(); // not allowed
            outer.fun4();
            outer.fun5();
            Outer.fun6();
            // outer.fun6(); // not allowed

        }
    }
}

class OuterClass implements Outer {

    @Override
    public void fun1() {
        System.out.println("OuterClass fun1 called");
    }

    public void fun4() {
        System.out.println("OuterClass fun4 called");
    }
}