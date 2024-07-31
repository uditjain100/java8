package Interfaces;

import java.util.*;

public class ForEach {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        list.forEach((ele) -> runTask(ele));
    }

    public static void runTask(int ele) {
        System.out.println(ele);
    }
}
