package InnerClasses;

public class MemberInnerClass {
    public static void main(String[] args) {

        Outer outer = new Outer();
        outer.testerOuter();

        Outer.Nested nested = outer.new Nested();
        nested.testerNested();

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
        // Outer class does not have access to the members of Nested class
        Nested nested = new Nested();
        System.out.println(nested.A);
        System.out.println(nested.C);
        nested.E();
        nested.F();
        nested.i();

        // System.out.println(Nested.B);
        // System.out.println(Nested.D);
        // Nested.G();
        // Nested.H();
        // Nested.j();
    }

    class Nested {

        int A;
        // static int B;
        final int C;
        // static final int D = 3;

        public Nested() {
            super();
            this.A = 0;
            // Nested.B = 1;
            this.C = 2;
        }

        public void E() {
            System.out.println("NESTED CLASS : " + "e");
        }

        private void F() {
            System.out.println("NESTED CLASS : " + "f");
        }

        // public static void G() {
        // System.out.println("NESTED CLASS : " + "g");
        // }

        // private static void H() {
        // System.out.println("NESTED CLASS : " + "h");
        // }

        void i() {
            System.out.println("NESTED CLASS : " + "i");
        }

        // static void j() {
        // System.out.println("NESTED CLASS : " + "j");
        // }

        void testerNested() {
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
            e();
            f();
            g();
            h();
            i();
            j();
        }

    }

}
