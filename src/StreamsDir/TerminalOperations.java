package StreamsDir;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class TerminalOperations {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5));
        int[] arr = new int[] { 5, 4, 2, 3, 4, 5, 6, 8 };

        // 1. collect
        // 1.a. Collectors
        // 1.a.1 toList, toSet, toMap
        System.out.println(list.stream().filter(ele -> ele > 4).collect(Collectors.toList()));
        System.out.println(list.stream().filter(ele -> ele > 4).collect(Collectors.toSet()));
        System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().filter(ele -> ele > 4)
                .collect(Collectors.toMap(Function.identity(), ele -> "" + ele)));

        // 1.a.2 joining method
        String[] strArr = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        System.out.println(Arrays.stream(strArr).collect(Collectors.joining()));
        System.out.println(Arrays.stream(strArr).collect(Collectors.joining(", ")));
        System.out.println(Arrays.stream(strArr).collect(Collectors.joining(", ", "[", "]")));

        // 1.a.3 counting
        System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        // 1.a.4 summarizingDouble, summarizingLong, summarizingInt
        // 1.a.5 averagingDouble, averagingLong, averagingInt
        // 1.a.6 groupingBy
        // 1.a.7 partitionBy

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

        // 7. count
        System.out.println(list.stream().count());
        System.out.println(IntStream.range(0, list.size()).map(index -> list.get(index)).count());
        System.out.println(list.stream().mapToInt(ele -> ele).summaryStatistics().getCount());

        // 8. toArray
        System.out.println(list.stream().toArray());

        // 9. anyMatch, allMatch, noneMatch
        System.out.println("anyMatch : " + list.stream().anyMatch(ele -> ele > 5));
        System.out.println("allMatch : " + list.stream().allMatch(ele -> ele < 10));
        System.out.println("noneMatch : " + list.stream().noneMatch(ele -> ele > 15));

        // 10. findAny
        System.out.println(list.stream().findAny().get());

        // 11. findFirst
        System.out.println(list.stream().findFirst().orElse(-1));

        // 11.a. first Element using reduce
        System.out.println(list.stream().reduce((a, b) -> a).get());

        // 11.b. Last Element
        System.out.println(list.stream().reduce((a, b) -> b).get());
        System.out.println(list.stream().skip(list.stream().count() - 1).findFirst().get());

    }
}
