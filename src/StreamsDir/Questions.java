package StreamsDir;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class Questions {
        public static void main(String[] args) {
                List<Integer> list = Arrays.asList(11, 11, 2, 33, 3, 33, 4, 5, 5, 5, 6, 6, 9);

                // Initialize a list in a single line with a specified value
                System.out.println(Arrays.stream(new Object[] { (Integer) 2, "abc" }).collect(Collectors.toList()));

                // Finding the duplicates
                Set<Integer> set = new HashSet<Integer>();
                System.out.println(list.stream().filter(ele -> !set.add(ele)).collect(Collectors.toSet()));

                System.out.println(list.stream()
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                                .entrySet().stream().filter(ele -> ele.getValue() > 1)
                                .collect(Collectors.toMap(ele -> ele.getKey(), ele -> ele.getValue())).keySet());

                System.out.println(list.stream()
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                                .entrySet().stream().filter(ele -> ele.getValue() > 1).map(ele -> ele.getKey())
                                .collect(Collectors.toList()));

                System.out.println(
                                list.stream().filter(ele -> Collections.frequency(list, ele) > 1)
                                                .collect(Collectors.toSet()));

                List<Employee> empList = new ArrayList<Employee>(Arrays.asList(new Employee("John", "A", 30, 50000),
                                new Employee("Alice", "A", 25, 60000), new Employee("Bob", "B", 35, 70000)));

                // Average salary of grade "A" employee
                System.out.println(
                                empList.stream().filter(emp -> emp.getGrade().equals("A")).map(emp -> emp.getSalary())
                                                .mapToDouble(i -> i).average().getAsDouble());

                // Sum of salary of grade "A" employees
                System.out.println(
                                empList.stream().filter(emp -> emp.getGrade().equals("A")).map(emp -> emp.getSalary())
                                                .mapToDouble(i -> i).sum());

                // Average salary of all employees
                System.out.println(empList.stream().map(emp -> emp.getSalary()).mapToDouble(i -> i).average()
                                .getAsDouble());

                // Sum of salary of all employees
                System.out.println(empList.stream().map(emp -> emp.getSalary()).mapToDouble(i -> i).sum());

                // Map of average salary of each department
                System.out.println(
                                empList.stream().collect(
                                                Collectors.groupingBy(Employee::getGrade,
                                                                Collectors.averagingDouble(Employee::getSalary))));

                // Map of sum of salary of each department
                System.out.println(
                                empList.stream().collect(
                                                Collectors.groupingBy(Employee::getGrade,
                                                                Collectors.summarizingDouble(Employee::getSalary))));

                // First employee in the list
                System.out.println(Optional.ofNullable(empList.get(0)).orElse(new Employee("str", "str", 20, 20)));

                // Sorting employee list on the basis of salary in descending order
                empList.stream().sorted((a, b) -> (int) (b.getSalary() - a.getSalary())).collect(Collectors.toList())
                                .forEach(System.out::println);

                String s = "qwertyuioqwertyuiopqweryuiopabcdef";
                char ch = 'a';

                // Count occurrence of a given character in a string
                System.out.println(s.chars().filter(c -> c == ch).count());

                // Count of each occurrence of each character in the string
                System.out.println(s.chars().mapToObj(ele -> (char) ele)
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
                // Duplicate characters in the string
                System.out.println(s.chars().mapToObj(ele -> (char) ele)
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                                .stream().filter(ele -> ele.getValue() > 1).map(ele -> ele.getKey())
                                .collect(Collectors.toList()));
                // First non repeating characters in the string
                System.out.println(s.chars().mapToObj(ele -> (char) ele)
                                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
                                                Collectors.counting()))
                                .entrySet().stream().filter(ele -> ele.getValue() == 1).map(ele -> ele.getKey())
                                .findFirst().get());

                String[] strArr = { "a", "bc", "kdgjskfhg", "jjgh", "qwertyuiopqwertyuiop", "zwertyuiopqwertyuiow",
                                "asdfg" };

                // Length of longest string
                System.out.println(Arrays.stream(strArr).reduce((a, b) -> a.length() >= b.length() ? a : b).get()
                                .length());
                // All Strings with longest length
                System.out.println(Arrays.stream(strArr)
                                .collect(Collectors.groupingBy(String::length,
                                                Collectors.mapping(Function.identity(), Collectors.toList())))
                                .entrySet().stream().sorted((a, b) -> b.getKey() - a.getKey()).findFirst().get()
                                .getValue());

                // Note : boxed() method is used for auto boxing -> primitive to wrapper class
                int[] numbers = { 5, 4, 3, 2, 8, 6, 7, 9, 1, 2, 4, 7, 5, 6, 66, 8, 88, 8, 97, 7, 9, 2, 22, 15, 1, 11,
                                114 };
                // Highest Number
                System.out.println(Arrays.stream(numbers).boxed().distinct().sorted(Comparator.reverseOrder()).limit(1)
                                .findFirst().orElse(-1));
                // Second Highest Number
                System.out.println(Arrays.stream(numbers).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1)
                                .limit(1).findFirst().orElse(-1));
                // Numbers starts with 1
                System.out.println(Arrays.stream(numbers).boxed().map(ele -> "" + ele)
                                .filter(ele -> ele.charAt(0) == '1').collect(Collectors.toList()));

                // To get the nth highest salary
                Map<String, Integer> emplMap2 = new HashMap<String, Integer>();
                emplMap2.put("E1", 10);
                emplMap2.put("E12", 20);
                emplMap2.put("E22", 20);
                emplMap2.put("E2", 20);
                emplMap2.put("E3", 30);
                emplMap2.put("E13", 30);
                emplMap2.put("E4", 40);
                emplMap2.put("E5", 50);
                emplMap2.put("E15", 50);
                emplMap2.put("E6", 60);

                int n = 5;
                // Failed
                // System.out.println(emplMap2.entrySet().stream().sorted((a, b) -> b.getValue()
                // - a.getValue())
                // .skip(n - 1)
                // .limit(1).map(ele ->
                // ele.getValue()).collect(Collectors.toList()).getFirst());

                System.out.println(emplMap2.entrySet().stream()
                                .collect(Collectors.groupingBy(Map.Entry::getValue,
                                                Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                                .entrySet().stream().sorted((a, b) -> b.getKey() - a.getKey()).skip(n - 1).limit(1)
                                .map(ele -> ele.getValue()).collect(Collectors.toList()).getFirst());

                // Filtering null values from list;
                List<String> nullList = Arrays.asList("a", null, "b", "c", null, "d");
                System.out.println(nullList.stream().filter(ele -> ele != null).collect(Collectors.toList()));
                System.out.println(nullList.stream().filter(Objects::nonNull).collect(Collectors.toList()));
                System.out.println(nullList.stream().map(Stream::ofNullable).collect(Collectors.toList()));

                // Finding the common elements in the 2 arrays
                int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
                int[] b = { 1, 2, 66, 11, 22, 44, 7, 8, 9, 5, 66, 41 };
                System.out.println(Arrays.stream(a).filter(ele -> Arrays.stream(b).anyMatch(i -> ele == i)).boxed()
                                .collect(Collectors.toList()));

                // Reverse an array
                int[] ans = new int[a.length];
                IntStream.rangeClosed(0, a.length / 2).forEach((i) -> {
                        ans[i] = a[a.length - 1 - i];
                        ans[a.length - 1 - i] = a[i];
                });
                System.out.println(Arrays.toString(ans));

                IntStream.rangeClosed(0, a.length / 2).forEach((i) -> {
                        int temp = a[i];
                        a[i] = a[a.length - 1 - i];
                        a[a.length - 1 - i] = temp;
                });
                System.out.println(Arrays.toString(a));

                // is Prime
                int len = 37;
                System.out.println("Is Prime : "
                                + (IntStream.rangeClosed(2, (int) Math.sqrt(len)).anyMatch(i -> (len % i) == 0) ? false
                                                : true));

                // print first count number of primes
                int count = 10;
                System.out.println(Stream.iterate(1, i -> i + 1)
                                .filter(i -> i == 1 ? false
                                                : i == 2 ? true
                                                                : IntStream.rangeClosed(2, (int) Math.sqrt(i))
                                                                                .noneMatch(num -> i % num == 0))
                                .limit(count).collect(Collectors.toList()));

                String str2 = "Welcome to Kolkata and Kolkata welcome you";
                System.out.println(Arrays.stream(str2.split(" "))
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        }
}

class Employee {
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