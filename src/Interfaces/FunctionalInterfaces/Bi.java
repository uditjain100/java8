package Interfaces.FunctionalInterfaces;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.function.BiPredicate;

public class Bi {
    public static void main(String[] args) throws Exception {
        // Bi-function
        Map<String, Integer> emplMap = new HashMap<>();
        emplMap.put("John", 30);
        emplMap.put("Alice", 25);
        emplMap.put("Bob", 35);
        emplMap.replaceAll((key, value) -> value + 500);

        // Bi-consumer
        emplMap.forEach((key, value) -> System.out.println(key + ", " + value));

        // Bi-predicate
        Path directory = Paths.get("C:\\Users\\ccs\\Documents\\java8\\src");
        BiPredicate<Path, BasicFileAttributes> matcher = (path, attrs) -> attrs.isRegularFile()
                && path.toString().endsWith(".txt");

        Files.find(directory, 10, matcher)
                .forEach(System.out::println);
    }
}
