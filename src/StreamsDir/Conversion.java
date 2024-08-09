package StreamsDir;

import java.util.*;
import java.util.stream.*;

public class Conversion {
    public static void main(String[] args) {

        // Array to Stream
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(Arrays.stream(arr));
        System.out.println(Stream.of(arr));
        System.out.println(IntStream.of(arr));

        // Stream to Array
        System.out.println(Arrays.stream(arr).toArray());
        System.out.println(Arrays.stream(arr).boxed().mapToInt(Integer::intValue));
        System.out.println(Stream.of(arr).toArray());
        System.out.println(Stream.of(arr).toArray(Object[]::new));

        // List to Stream
        List<Integer> list = Arrays.asList(12, 3, 4, 5, 6, 1, 2, 88, 45);
        System.out.println(list.stream());

        // Stream to List
        System.out.println(list.stream().collect(Collectors.toList()));

        // Array to List
        int[] ar = new int[] { 1, 2, 3 };
        List<Integer> bl = Arrays.stream(ar).boxed().collect(Collectors.toList());
        System.out.println(bl);

        // List to Array
        List<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 3));
        int[] br = al.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(br));

        // Map/Set to Stream
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        System.out.println(map.entrySet().stream());
        System.out.println(map.keySet().stream());
        System.out.println(map.values().stream());

        // Stream to Map
        System.out
                .println(map.entrySet().stream().collect(Collectors.toMap(ele -> ele.getKey(), ele -> ele.getValue())));

        // Stream to Set
        System.out.println(map.keySet().stream().collect(Collectors.toSet()));
        System.out.println(map.values().stream().collect(Collectors.toSet()));

        // Flattering a map
        map.entrySet().stream().flatMap(ele -> Stream.of(ele)).forEach(System.out::print);
        System.out.println();

        // Sorting a map
        List<Map.Entry<Integer, String>> l = new ArrayList<>(map.entrySet());
        Collections.sort(l, (a, b) -> a.getKey().compareTo(b.getKey()));
        System.out.println(l);

        map.entrySet().stream().sorted((a, b) -> a.getKey().compareTo(b.getKey())).forEach(System.out::print);
        System.out.println();
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::print);
        System.out.println();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::print);
        System.out.println();
        // For reverse order sorting
        map.entrySet().stream().sorted(Map.Entry.comparingByValue((a, b) -> b.compareTo(a)))
                .forEach(System.out::print);
        System.out.println();

        Map<Integer, Employee> emplMap = new HashMap<>();
        emplMap.put(1, new Employee("John", "A", 30, 50000));
        emplMap.put(2, new Employee("Alice", "A", 25, 60000));
        emplMap.put(3, new Employee("Bob", "B", 35, 70000));

        emplMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((a, b) -> a.getAge() - b.getAge()))
                .forEach(System.out::println);
        emplMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getAge)))
                .forEach(System.out::println);
    }
}
