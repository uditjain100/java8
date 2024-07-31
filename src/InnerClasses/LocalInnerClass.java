package InnerClasses;

public class LocalInnerClass {

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.testerOuter();
    }

}

class Outer {

    int a;
    static int b;
    final int c;
    static final int d = 3;

    public Outer() {
        System.out.println("Called .......................");
        this.a = 0;
        Outer.b = 1;
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

    void testerOuter() {

        int alpha = 100;
        final int beta = 101;

        class Inner {

            int A;
            // static int B;
            final int C;
            static final int D = 3;

            public Inner() {
                super();
                this.A = 0;
                // Inner.B = 1;
                this.C = 2;
            }

            public void E() {
                System.out.println("INNER CLASS : " + "e");
            }

            private void F() {
                System.out.println("INNER CLASS : " + "f");
            }

            // public static void G() {
            // System.out.println("INNER CLASS : " + "g");
            // }

            // private static void H() {
            // System.out.println("INNER CLASS : " + "h");
            // }

            void i() {
                System.out.println("INNER CLASS : " + "i");
            }

            // static void j() {
            // System.out.println("INNER CLASS : " + "j");
            // }

            void testerInner() {
                System.out.println("ALPHA : " + alpha);
                System.out.println("BETA : " + beta);
                System.out.println("a : " + a);
                System.out.println("b : " + b);
                System.out.println("c : " + c);
                System.out.println("d : " + d);
                e();
                f();
                g();
                h();
                i();
                j();
            }
        }

        Inner inner = new Inner();
        System.out.println("A : " + inner.A);
        System.out.println("C : " + inner.C);
        inner.E();
        inner.F();
        inner.i();
        // System.out.println("B : " + Inner.B);
        System.out.println("D : " + Inner.D);
        // Inner.G();
        // Inner.H();
        // Inner.j();

        inner.testerInner();
    }

}
