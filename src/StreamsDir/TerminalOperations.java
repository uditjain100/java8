package StreamsDir;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class TerminalOperations {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5));
        int[] arr = new int[] { 5, 4, 2, 3, 4, 5, 6, 8 };

        Map<Integer, Employee> emplMap = new HashMap<>();
        emplMap.put(1, new Employee("John", "A", 30, 50000));
        emplMap.put(2, new Employee("Alice", "A", 25, 60000));
        emplMap.put(3, new Employee("Bob", "B", 5, 70000));

        List<Employee> empList = emplMap.values().stream().collect(Collectors.toList());

        // 1. collect
        // 1.a. Collectors

        // 1.a.1 toList / toSet / toMap / toCollection / toConcurrentMap /
        // toUnmodifiableList / toUnmodifiableSet / toUnmodifiableMap
        System.out.println(list.stream().filter(ele -> ele > 4).collect(Collectors.toList()));
        System.out.println(list.stream().filter(ele -> ele > 4).collect(Collectors.toUnmodifiableList())); // don't
                                                                                                           // allow null
                                                                                                           // values
        System.out.println(list.stream().filter(ele -> ele > 4).collect(Collectors.toSet()));
        System.out.println(list.stream().filter(ele -> ele > 4).collect(Collectors.toUnmodifiableSet())); // don't
                                                                                                          // allow null
                                                                                                          // values
        System.out.println(
                list.stream().filter(ele -> ele > 4).collect(Collectors.toCollection(() -> new LinkedList<>())));
        System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().filter(ele -> ele > 4)
                .collect(Collectors.toMap(Function.identity(), ele -> "" + ele)));
        System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().filter(ele -> ele > 4)
                .collect(Collectors.toConcurrentMap(Function.identity(), ele -> "" + ele)));
        System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().filter(ele -> ele > 4)
                .collect(Collectors.toUnmodifiableMap(Function.identity(), ele -> "" + ele)));// don't
                                                                                              // allow null
                                                                                              // values
        // 1.a.2 averagingDouble / averagingLong / averagingInt / summarizingDouble /
        // summarizingLong / summarizingInt / summingDouble / summingLong / summingInt
        System.out.println(empList.stream().collect(Collectors.averagingDouble(ele -> ele.getAge())));
        System.out.println(empList.stream().collect(Collectors.averagingLong(ele -> ele.getAge())));
        System.out.println(empList.stream().collect(Collectors.averagingInt(ele -> ele.getAge())));

        System.out.println(empList.stream().collect(Collectors.summarizingDouble(ele -> ele.getAge())));
        System.out.println(empList.stream().collect(Collectors.summarizingLong(ele -> ele.getAge())));
        System.out.println(empList.stream().collect(Collectors.summarizingInt(ele -> ele.getAge())));

        System.out.println(empList.stream().collect(Collectors.summingDouble(ele -> ele.getAge())));
        System.out.println(empList.stream().collect(Collectors.summingLong(ele -> ele.getAge())));
        System.out.println(empList.stream().collect(Collectors.summingInt(ele -> ele.getAge())));

        // 1.a.3 counting / groupingBy / groupingByConcurrent / maxBy / minBy
        System.out.println(list.stream().collect(Collectors.counting())); // counts the number of inputs
        System.err.println(empList.stream().collect(Collectors.groupingBy(ele -> ele.getAge())));
        // To get the average salary age wise
        System.err.println(empList.stream()
                .collect(Collectors.groupingBy(ele -> ele.getAge(), Collectors.averagingDouble(Employee::getSalary))));
        System.err.println(empList.stream().collect(Collectors.groupingByConcurrent(ele -> ele.getAge())));
        System.out.println(empList.stream().collect(Collectors.maxBy((a, b) -> a.getAge() - b.getAge())).get());
        System.out.println(empList.stream().collect(Collectors.minBy((a, b) -> a.getAge() - b.getAge())).get());

        // 1.a.4 joining / partitioningBy / collectingAndThen
        String[] strArr = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        System.out.println(Arrays.stream(strArr).collect(Collectors.joining()));
        System.out.println(Arrays.stream(strArr).collect(Collectors.joining(", ")));
        System.out.println(Arrays.stream(strArr).collect(Collectors.joining(", ", "[", "]")));

        System.out.println(empList.stream().collect(Collectors.partitioningBy(ele -> ele.getAge() > 20)));
        System.out.println(empList.stream().map(ele -> ele.getGrade()).collect(
                Collectors.collectingAndThen(Collectors.toList(), l -> l.stream().skip(1))));

        // 1.a.5 mapping / flatMapping / filtering / teeing
        System.out.println(empList.stream().collect(Collectors.mapping(ele -> ele.getAge(), Collectors.toList()))); // stream.map
        System.out.println(empList.stream()
                .collect(Collectors.flatMapping(ele -> Stream.of(ele.getName()), Collectors.toList()))); // stream.flatMap
        System.out
                .println(empList.stream().collect(Collectors.filtering(ele -> ele.getAge() > 20, Collectors.toList()))); // stream.filter

        System.out.println(empList.stream()
                .collect(Collectors.teeing(Collectors.counting(), Collectors.toSet(), (a, b) -> Stream.of(a, b)))
                .collect(Collectors.toSet()));

        // 2. forEach
        list.parallelStream().forEach(System.out::print); // not guarantee ordering
        System.out.println();

        // 3. forEachOrdered
        list.parallelStream().forEachOrdered(System.out::print); // for ordered printing
        System.out.println();

        // 4. Reduce Method
        System.out.println(list.stream().reduce((a, b) -> a + b).get());

        // 4.b. Filtering Odd numbers using reduce method
        list.stream().reduce(new ArrayList<>(), (a, b) -> {
            // System.out.println("a and b - " + a + " : " + b);
            if ((b & 1) != 0)
                a.add(b);
            return a;
        }, (a, b) -> {
            // System.out.println("a and b : " + a + " : " + b);
            // a.addAll(b);
            return a;
        }).forEach(System.out::print);
        System.out.println();

        // 5. min, max
        // 5.a. Integer List
        System.out.println(list.stream().min((a, b) -> a - b).get());
        // 5.b. Object Array
        System.out.println(Arrays.stream(list.toArray()).min((a, b) -> (int) a - (int) b).get());
        // 5.c. Integer Array
        System.out.println(Arrays.stream(arr).min().getAsInt());
        System.out.println(list.stream().mapToInt(ele -> ele).summaryStatistics().getMin());

        // 6. sum
        System.out.println(IntStream.range(0, list.size()).map(index -> list.get(index)).sum());
        System.out.println(list.stream().mapToInt(ele -> ele).summaryStatistics().getSum());
        System.out.println(list.stream().reduce(0, (a, b) -> a + b));

        // 7. average
        System.out.println(IntStream.range(0, list.size()).map(index -> list.get(index)).average());
        System.out.println(list.stream().mapToInt(ele -> ele).summaryStatistics().getAverage());

        // 8. count
        System.out.println(list.stream().count());
        System.out.println(IntStream.range(0, list.size()).map(index -> list.get(index)).count());
        System.out.println(list.stream().mapToInt(ele -> ele).summaryStatistics().getCount());

        // 9. toArray
        System.out.println(list.stream().toArray());

        // 10. anyMatch, allMatch, noneMatch
        System.out.println("anyMatch : " + list.stream().anyMatch(ele -> ele > 5));
        System.out.println("allMatch : " + list.stream().allMatch(ele -> ele < 10));
        System.out.println("noneMatch : " + list.stream().noneMatch(ele -> ele > 15));

        // 11. findAny
        System.out.println(list.stream().findAny().get());

        // 12. findFirst
        System.out.println(list.stream().findFirst().orElse(-1));

        // 12.a. first Element using reduce
        System.out.println(list.stream().reduce((a, b) -> a).get());

        // 12.b. Last Element
        System.out.println(list.stream().reduce((a, b) -> b).get());
        System.out.println(list.stream().skip(list.stream().count() - 1).findFirst().get());

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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}