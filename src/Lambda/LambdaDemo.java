package Lambda;

public class LambdaDemo {

    @FunctionalInterface
    interface Lambda0 {
        void run();

        default void defaultMethod() {
            System.out.println("Default method in Lambda0");
        }

        static void staticMethod() {
            System.out.println("Static method in Lambda0");
        }
    }

    @FunctionalInterface
    interface Lambda1 {
        void run(int a);

        default void defaultMethod() {
            System.out.println("Default method in Lambda0");
        }

        static void staticMethod() {
            System.out.println("Static method in Lambda0");
        }
    }

    @FunctionalInterface
    interface Lambda2 {
        int run(int a);

        default void defaultMethod() {
            System.out.println("Default method in Lambda0");
        }

        static void staticMethod() {
            System.out.println("Static method in Lambda0");
        }
    }

    @FunctionalInterface
    interface Lambda3 {
        void run(int a, String str);

        default void defaultMethod() {
            System.out.println("Default method in Lambda0");
        }

        static void staticMethod() {
            System.out.println("Static method in Lambda0");
        }
    }

    public static void main(String[] args) {

        // 0 Parameters
        Lambda0 a = () -> {
            System.out.println("0 argument lambda");
        };
        Lambda0 b = () -> System.out.println("0 argument lambda");

        // 1 Parameter
        Lambda1 c = (int num) -> {
            System.out.println("1 argument lambda");
        };
        Lambda1 d = (num) -> {
            System.out.println("1 argument lambda");
        };
        Lambda1 e = (num) -> System.out.println("1 argument lambda");
        Lambda1 f = num -> System.out.println("1 argument lambda");

        // 1 parameter with not void return type
        Lambda2 g = (int num) -> {
            System.out.println("1 parameter with not void return type");
            System.out.println("Block Lambda Expression");
            return 2 * num;
        };
        // Single line lambda expression
        Lambda2 h = num -> {
            return 2 * num;
        };
        Lambda2 i = num -> 2 * num;

        // More than 1 parameter
        Lambda3 j = (num, str) -> {
            System.out.println("More than 1 parameter lambda: " + num + ", " + str);
            System.out.println("Block lambda Expression");
        };
        Lambda3 k = (num, str) -> {
            System.out.println("More than 1 parameter lambda: " + num + ", " + str);
        };
        Lambda3 l = (num, str) -> System.out.println("More than 1 parameter lambda: " + num + ", " + str);

    }
}
