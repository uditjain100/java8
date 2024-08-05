package StreamsDir;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Conversion {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        // Map/Set to Stream
        System.out.println(map.entrySet().stream());
        System.out.println(map.keySet().stream());
        System.out.println(map.values().stream());

        // Stream to Map
        System.out
                .println(map.entrySet().stream().collect(Collectors.toMap(ele -> ele.getKey(), ele -> ele.getValue())));

        // Flattering a map
        map.entrySet().stream().flatMap(ele -> Stream.of(ele)).forEach(System.out::println);

        // Stream to Set
        System.out.println(map.keySet().stream().collect(Collectors.toSet()));
        System.out.println(map.values().stream().collect(Collectors.toSet()));

        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> list = Arrays.asList(12, 3, 4, 5, 6, 1, 2, 88, 45);

        // Array to Stream
        System.out.println(Arrays.stream(arr));
        System.out.println(Stream.of(arr));
        System.out.println(IntStream.of(arr));
        System.out.println(list.stream());

        // Stream to Array
        System.out.println(Arrays.stream(arr).toArray());
        System.out.println(Stream.of(arr).toArray());
        // System.out.println(Arrays.stream(arr).toArray(Object[]::new));
        System.out.println(Stream.of(arr).toArray(Object[]::new));
        System.out.println(Arrays.stream(arr).boxed().mapToInt(Integer::intValue));

        // Slice of a stream
        System.out.println(list.stream().skip(1).limit(2).collect(Collectors.toList()));
        System.out.println(list.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> l.stream().skip(1).limit(2))));

        // Getting the first element
        System.out.println(list.stream().reduce((a, b) -> a).get());
        System.out.println(list.stream().findFirst().orElse(-1));

        // Getting the Random element
        System.out.println(list.stream().findAny().get());
        System.out.println(list.stream().findAny().get());
        System.out.println(list.stream().findAny().get());

        // Getting the Last element
        System.out.println(list.stream().reduce((a, b) -> b).get());
        System.out.println(list.stream().skip(list.stream().count() - 1).findFirst().get());

        // drop while and take while
        System.out.println(list.stream().dropWhile(ele -> ele > 5).collect(Collectors.toList()));
        System.out.println(list.stream().takeWhile(ele -> ele > 5).collect(Collectors.toList()));

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

        // Method Reference
        List<Student> students = Arrays.asList(new Student("A", 1, 1), new Student("B", 1, 2), new Student("C", 1, 3));
        // Static
        students.stream().map(st -> st.getDetails()).forEach(System.out::println);
        // Non - Static
        students.stream().map(Student::getName).forEach(System.out::println);
        // Constructor
        students.stream().map(Student::getId).map(ArrayList::new).forEach(System.out::println);
        students.stream().map(Student::getId).collect(Collectors.toList()).forEach(System.out::println);

    }
}

class Student {
    private String name;
    private int age;
    private int id;

    public Student() {
        this.name = "Student";
        this.age = 0;
        this.id = 0;
    }

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getDetails() {
        return "Student Details : " + this.name + " " + this.age + " " + this.id;
    }

    public static void printDetails() {
        System.out.println("Student Details");
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getAge() {
        return this.age;
    }
}