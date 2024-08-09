package Interfaces.FunctionalInterfaces;

import java.util.*;

public class Bi {
    public static void main(String[] args) {
        // Bi-function
        Map<String, Integer> emplMap = new HashMap<>();
        emplMap.put("John", 30);
        emplMap.put("Alice", 25);
        emplMap.put("Bob", 35);
        emplMap.replaceAll((key, value) -> value + 500);

        // Bi-consumer
        emplMap.forEach((key, value) -> System.out.println(key + ", " + value));

        // Bi-predicate
        // emplMap.entrySet().stream().filter((key, value) -> key.equals("John") &&
        // value == 35).collect(Collectors.toList());
    }
}
