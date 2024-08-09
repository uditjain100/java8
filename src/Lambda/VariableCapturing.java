package Lambda;

public class VariableCapturing {

    int b = 20;
    static int c = 30;
    static {
        c = 35;
    }
    static int d = 40;

    public static void main(String[] args) {
        int e = 50;
        e = 55;
        int f = 60;

        Extensible extensible = () -> {
            int g = 70;
            g = 75;
            int h = 80;
            // System.out.println("a = " + a); // not visible
            // System.out.println("b = " + b); // not static
            System.out.println("c = " + c);
            System.out.println("d = " + d);
            // System.out.println("e = " + e); // not final or effectively final
            System.out.println("f = " + f);
            System.out.println("g = " + g);
            System.out.println("h = " + h);

            c += 100;
            d += 100;
            // f += 100; // Can't do as it should be final or effectively final
            g += 100;
            h += 100;

            System.out.println("c after update = " + c);
            System.out.println("d after update = " + d);
            System.out.println("g after update = " + g);
            System.out.println("h after update = " + h);
        };
        extensible.extend();

    }
}

interface Extensible {
    // by default static and final
    int a = 10;

    void extend();
}