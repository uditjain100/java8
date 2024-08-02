package Lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda {

    @FunctionalInterface
    interface MyInterface {
        boolean myMethod(int num);

        default boolean myDefaultMethod() {
            return false;
        }

        static boolean myStaticMethod(int num) {
            return num % 2 == 0;
        }
    }

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>(Arrays.asList(new int[] { 0, 1 }, new int[] { 2, 3 }));
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        list.forEach((l) -> map.put(l[0], l[1]));
        System.out.println(map);

        String str = "chjskcvjsvhlshdfhjsblchsdgcs";
        str.chars().allMatch(Character::isAlphabetic);

        List<Integer> even = Arrays.asList(1, 2, 3, 4, 5, 6);
        even = even.stream().filter((ele) -> (ele & 1) == 0).collect(Collectors.toList());
        System.out.println(even);

        MyInterface myInterface = (num) -> num % 2 == 0;
        System.out.println(myInterface.myMethod(10));
        System.out.println(myInterface.myDefaultMethod());
        System.out.println(MyInterface.myStaticMethod(10));
    }
}
