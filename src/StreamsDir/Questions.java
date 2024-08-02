package StreamsDir;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class Questions {

    static class Employee {
        private String name;
        private String grade;
        private int age;
        private double salary;

        public Employee(String name, String grade, int age, double salary) {
            this.name = name;
            this.grade = grade;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

        public String getGrade() {
            return grade;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11, 11, 2, 33, 3, 33, 4, 5, 5, 5, 6, 6, 9);

        // Finding the duplicates
        Set<Integer> set = new HashSet<Integer>();
        System.out.println(list.stream().filter(ele -> !set.add(ele)).collect(Collectors.toSet()));

        System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(ele -> ele.getValue() > 1)
                .collect(Collectors.toMap(ele -> ele.getKey(), ele -> ele.getValue())).keySet());

        System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(ele -> ele.getValue() > 1).map(ele -> ele.getKey())
                .collect(Collectors.toList()));

        System.out.println(
                list.stream().filter(ele -> Collections.frequency(list, ele) > 1).collect(Collectors.toSet()));

        // Count occurrence of a given character in a string
        String str = "aaa";
        char ch = 'a';
        System.out.println(str.chars().filter(c -> c == ch).count());

        // Reverse elements of a Stream
        System.out.println(
                list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    Collections.reverse(l);
                    return l.stream();
                })).collect(Collectors.toList()));

        list.stream().collect(Collectors.toCollection(LinkedList::new)).descendingIterator()
                .forEachRemaining(System.out::println);

        // Initialize a list in a single line with a specified value
        System.out.println(Arrays.stream(new Object[] { (Integer) 2, "abc" }).collect(Collectors.toList()));

        // joining method
        String[] arr = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        System.out.println(Arrays.stream(arr).collect(Collectors.joining()));
        System.out.println(Arrays.stream(arr).collect(Collectors.joining(", ")));
        System.out.println(Arrays.stream(arr).collect(Collectors.joining(", ", "[", "]")));

        // Sorting a map
        Map<String, Integer> map = new HashMap<>();
        map.put("C", 1);
        map.put("A", 3);
        map.put("B", 2);

        Collections.sort(new ArrayList<>(map.entrySet()), (a, b) -> a.getKey().compareTo(b.getKey()));
        System.out.println(map);

        map.entrySet().stream().sorted((a, b) -> a.getKey().compareTo(b.getKey())).forEach(System.out::println);
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(ele -> ele)))
                .forEach(System.out::println);
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        // map.entrySet().stream().sorted(Map.Entry.comparingByValue().reversed()).forEach(System.out::println);

        Map<Integer, Employee> emplMap = new HashMap<>();
        emplMap.put(1, new Employee("John", "A", 30, 50000));
        emplMap.put(2, new Employee("Alice", "A", 25, 60000));
        emplMap.put(3, new Employee("Bob", "B", 35, 70000));

        // map.entrySet().stream()
        // .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getAge)))
        // .forEach(System.out::println);

        List<Employee> empList = new ArrayList<Employee>(Arrays.asList(new Employee("John", "A", 30, 50000),
                new Employee("Alice", "A", 25, 60000), new Employee("Bob", "B", 35, 70000)));

        // Average salary of grade a employee
        System.out.println(empList.stream().filter(emp -> emp.getGrade().equals("A")).map(emp -> emp.getSalary())
                .mapToDouble(i -> i).average().getAsDouble());

        System.out.println(empList.stream().filter(emp -> emp.getGrade().equals("A")).map(emp -> emp.getSalary())
                .mapToDouble(i -> i).sum());

        System.out.println(empList.stream().map(emp -> emp.getSalary()).mapToDouble(i -> i).average().getAsDouble());

        System.out.println(empList.stream().map(emp -> emp.getSalary()).mapToDouble(i -> i).sum());

        System.out.println(
                empList.stream().collect(
                        Collectors.groupingBy(Employee::getGrade, Collectors.averagingDouble(Employee::getSalary))));

        System.out.println(
                empList.stream().collect(
                        Collectors.groupingBy(Employee::getGrade, Collectors.summarizingDouble(Employee::getSalary))));
    }
}
