package InnerClasses;

public class AnonymousInner {

    public static void main(String[] args) {
        AnonymousInner anonymousInner = new AnonymousInner();
        anonymousInner.concreteClassTester();
        anonymousInner.abstractClassTester();
        anonymousInner.interfaceTester();
        anonymousInner.aicExamples();
    }

    public void concreteClassTester() {
        int alpha = 10;
        final int beta = 20;

        OuterClass outerClass = new OuterClass() {

            {
                System.out.println("ANONYMOUS CLASS : " + "Initializer Block");
            }

            int A = 0;
            // static int B = 1;
            final int C = 2;
            // static final int D = 3;

            public void E() {
                System.out.println("ANONYMOUS CLASS : " + "e");
            }

            // public static void G() {
            // System.out.println("ANONYMOUS CLASS : " + "g");
            // }

            @Override
            public void i() {
                System.out.println("ANONYMOUS CLASS : " + "i");
            }

            // @Override
            // static void j() {
            // System.out.println("ANONYMOUS CLASS : " + "j");
            // }

            @Override
            public void tester() {
                System.out.println("a : " + a);
                System.out.println("b : " + b);
                System.out.println("c : " + c);
                System.out.println("d : " + d);
                e();
                g();
                i();
                j();

                System.out.println("alpha : " + alpha);
                System.out.println("beta : " + beta);

                // Private Members are not visible of outer classes
                // f();
                // h();
            }

        };

        // New Members of Anonymous classes can't be accessed
        // System.out.println("A : " + outerClass.A);
        // System.out.println("B : " + outerClass.B);
        // System.out.println("C : " + outerClass.C);
        // System.out.println("D : " + outerClass.D);
        // outerClass.E();
        // outerClass.G();

        outerClass.tester();
    }

    public void abstractClassTester() {
        int alpha = 10;
        final int beta = 20;

        OuterAbstractClass outerAbstractClass = new OuterAbstractClass() {

            {
                System.out.println("ANONYMOUS CLASS : " + "Initializer Block");
            }

            int A = 0;
            // static int B = 1;
            final int C = 2;
            // static final int D = 3;

            public void E() {
                System.out.println("ANONYMOUS CLASS : " + "e");
            }

            // public static void G() {
            // System.out.println("ANONYMOUS CLASS : " + "g");
            // }

            @Override
            public void i() {
                System.out.println("ANONYMOUS CLASS : " + "i");
            }

            // @Override
            // static void j() {
            // System.out.println("ANONYMOUS CLASS : " + "j");
            // }

            @Override
            public void k() {
                System.out.println("ANONYMOUS CLASS : " + "k");
            }

            @Override
            public void tester() {
                System.out.println("a : " + a);
                System.out.println("b : " + b);
                System.out.println("c : " + c);
                System.out.println("d : " + d);
                e();
                g();
                i();
                j();
                k();

                System.out.println("alpha : " + alpha);
                System.out.println("beta : " + beta);

                // Private Members are not visible of outer classes
                // f();
                // h();
            }

        };

        // New Members of Anonymous classes can't be accessed
        // System.out.println("A : " + outerAbstractClass.A);
        // System.out.println("B : " + outerAbstractClass.B);
        // System.out.println("C : " + outerAbstractClass.C);
        // System.out.println("D : " + outerAbstractClass.D);
        // outerAbstractClass.E();
        // outerAbstractClass.G();

        outerAbstractClass.tester();
    }

    public void interfaceTester() {

        int alpha = 10;
        final int beta = 20;

        OuterInterface outerInterface = new OuterInterface() {

            {
                System.out.println("ANONYMOUS CLASS : " + "Initializer Block");
            }

            int A = 0;
            // static int B = 1;
            final int C = 2;
            // static final int D = 3;

            public void E() {
                System.out.println("ANONYMOUS CLASS : " + "e");
            }

            // public static void G() {
            // System.out.println("ANONYMOUS CLASS : " + "g");
            // }

            @Override
            public void i() {
                System.out.println("ANONYMOUS CLASS : " + "i");
            }

            // @Override
            // static void j() {
            // System.out.println("ANONYMOUS CLASS : " + "j");
            // }

            @Override
            public void k() {
                System.out.println("ANONYMOUS CLASS : " + "k");
            }

            @Override
            public void tester() {
                System.out.println("a : " + a);
                System.out.println("b : " + b);
                e();
                OuterInterface.g();
                i();
                OuterInterface.j();
                k();

                System.out.println("alpha : " + alpha);
                System.out.println("beta : " + beta);

                // Private Members are not visible of outer classes
                // f();
                // h();
            }

        };

        // New Members of Anonymous classes can't be accessed
        // System.out.println("A : " + outerInterface.A);
        // System.out.println("B : " + outerInterface.B);
        // System.out.println("C : " + outerInterface.C);
        // System.out.println("D : " + outerInterface.D);
        // outerInterface.E();
        // outerInterface.G();

        outerInterface.tester();

    }

    public void aicExamples() {

        Thread th = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread Run Executed");
            }
        };
        th.start();

        Runnable rn = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable Run Executed");
            }
        };
        Thread rnTh = new Thread(rn);
        rnTh.start();

        Thread rnTh2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable Inside Thread Run Executed");
            }
        });
        rnTh2.start();
    }

}

interface OuterInterface {

    // Both a and b are by default final
    int a = 0;
    static int b = 1;

    default void e() {
        System.out.println("OUTER CLASS : " + "e");
    }

    private void f() {
        System.out.println("OUTER CLASS : " + "f");
    }

    static void g() {
        System.out.println("OUTER CLASS : " + "g");
    }

    private static void h() {
        System.out.println("OUTER CLASS : " + "h");
    }

    default void i() {
        System.out.println("OUTER CLASS : " + "i");
    }

    static void j() {
        System.out.println("OUTER CLASS : " + "j");
    }

    // By default abstract
    void k();

    default void tester() {

    }

}

abstract class OuterAbstractClass {

    int a;
    static int b;
    final int c;
    static final int d = 3;

    public OuterAbstractClass() {
        this.a = 0;
        OuterAbstractClass.b = 1;
        this.c = 2;
    }

    public void e() {
        System.out.println("OUTER CLASS : " + "e");
    }

    private void f() {
        System.out.println("OUTER CLASS : " + "f");
    }

    public static void g() {
        System.out.println("OUTER CLASS : " + "g");
    }

    private static void h() {
        System.out.println("OUTER CLASS : " + "h");
    }

    void i() {
        System.out.println("OUTER CLASS : " + "i");
    }

    static void j() {
        System.out.println("OUTER CLASS : " + "j");
    }

    abstract void k();

    void tester() {

    }

}

class OuterClass {

    int a;
    static int b;
    final int c;
    static final int d = 3;

    public OuterClass() {
        this.a = 0;
        OuterClass.b = 1;
        this.c = 2;
    }

    public void e() {
        System.out.println("OUTER CLASS : " + "e");
    }

    private void f() {
        System.out.println("OUTER CLASS : " + "f");
    }

    public static void g() {
        System.out.println("OUTER CLASS : " + "g");
    }

    private static void h() {
        System.out.println("OUTER CLASS : " + "h");
    }

    void i() {
        System.out.println("OUTER CLASS : " + "i");
    }

    static void j() {
        System.out.println("OUTER CLASS : " + "j");
    }

    void tester() {

    }

}
