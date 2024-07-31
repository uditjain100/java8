package Interfaces;

import java.util.*;

public class MapSort {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 25);
        map.put("b", 22);
        map.put("c", 20);

        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list, (a, b) -> a.getValue() - b.getValue());

        map.clear();
        for (Map.Entry<String, Integer> entry : list)
            map.put(entry.getKey(), entry.getValue());
        for (Map.Entry<String, Integer> entry : list)
            System.out.println(entry);
    }
}
