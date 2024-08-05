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

                // Min Max Average

                System.out.println(list.stream().mapToInt(ele -> ele).summaryStatistics().getAverage());
                System.out.println(list.stream().mapToInt(ele -> ele).summaryStatistics().getMin());
                System.out.println(list.stream().min((a, b) -> a - b).get());
                System.out.println(list.stream().mapToInt(ele -> ele).summaryStatistics().getMax());
                System.out.println(list.stream().min((a, b) -> b - a).get());
                System.out.println(list.stream().mapToInt(ele -> ele).summaryStatistics().getCount());
                System.out.println(list.stream().count());
                System.out.println(list.stream().mapToInt(ele -> ele).summaryStatistics().getSum());
                System.out.println(list.stream().reduce(0, (a, b) -> a + b));

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
                System.out.println(
                                empList.stream().filter(emp -> emp.getGrade().equals("A")).map(emp -> emp.getSalary())
                                                .mapToDouble(i -> i).average().getAsDouble());

                System.out.println(
                                empList.stream().filter(emp -> emp.getGrade().equals("A")).map(emp -> emp.getSalary())
                                                .mapToDouble(i -> i).sum());

                System.out.println(empList.stream().map(emp -> emp.getSalary()).mapToDouble(i -> i).average()
                                .getAsDouble());

                System.out.println(empList.stream().map(emp -> emp.getSalary()).mapToDouble(i -> i).sum());

                System.out.println(
                                empList.stream().collect(
                                                Collectors.groupingBy(Employee::getGrade,
                                                                Collectors.averagingDouble(Employee::getSalary))));

                System.out.println(
                                empList.stream().collect(
                                                Collectors.groupingBy(Employee::getGrade,
                                                                Collectors.summarizingDouble(Employee::getSalary))));
                int age = 50;
                System.out.println(Optional.ofNullable(empList.get(0)).orElse(new Employee("str", "str", 20, 20)));

                // Sorting employee list on the basis of salary in descending order
                empList.stream().sorted((a, b) -> (int) (b.getSalary() - a.getSalary())).collect(Collectors.toList())
                                .forEach(System.out::println);

                String s = "qwertyuioqwertyuiopqweryuiopabcdef";
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
                System.out.println(nullList.stream().filter(Objects::nonNull).collect(Collectors.toList()));
                System.out.println(nullList.stream().filter(ele -> ele != null).collect(Collectors.toList()));
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
                System.out.println(Arrays.toString(ans));

        }
}
