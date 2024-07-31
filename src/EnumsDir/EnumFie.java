package EnumsDir;

enum OutsideEnum {
    OUTSIDE_VALUE_1 {
        @Override
        void function() {
            System.out.println("Inside OUTSIDE_VALUE_1 function");
        }
    },
    OUTSIDE_VALUE_2 {
        @Override
        void function() {
            System.out.println("Inside OUTSIDE_VALUE_2 function");
        }
    };

    abstract void function();
}

public class EnumFie {

    enum Color {
        RED,
        GREEN,
        BLUE;

        private Color() {
            System.out.println("ENUM constructor called");
        }

        public static void main(String[] args) {
            System.out.println("ENUM main method called");
        }

        public void fun() {
            System.out.println("Enum method called");
        }

    }

    public static void main(String[] args) {
        for (Color color : Color.values())
            System.out.println("Color : " + color);

        Color c = Color.RED;
        System.out.println(c.ordinal());
        c.fun();

        switch (c) {
            case RED:
                System.out.println("Red");
                break;
            case GREEN:
                System.out.println("Green");
                break;
            case BLUE:
                System.out.println("Blue");
                break;
            default:
                System.out.println("Default");
                break;
        }

        for (OutsideEnum e : OutsideEnum.values())
            System.out.println("Outside value : " + e);

        OutsideEnum o = OutsideEnum.OUTSIDE_VALUE_1;
        o.function();
    }

}
