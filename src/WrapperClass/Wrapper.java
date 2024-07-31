package WrapperClass;

public class Wrapper {

    public static void main(String[] args) {

        Integer integer1 = new Integer(10);
        Integer integer2 = Integer.valueOf("10");
        Integer integer3 = 10;

        System.out.println(integer1 instanceof Integer);
        System.out.println(integer2 instanceof Integer);
        System.out.println(integer3 instanceof Integer);

    }
}
